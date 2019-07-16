package hello;

import hello.dto.PostDto;
import org.javalite.http.Get;
import org.javalite.http.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.io.InputStream;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration {
    private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public AppConfiguration appConfiguration;

    @Autowired
    public Authentication authentication;

    @Bean
    public JsonItemReader<PostDto> itemReader() throws Exception {

        return new JsonItemReaderBuilder<PostDto>()
                .name("postsReader")
                .resource(new InputStreamResource(urlResource()))
                .jsonObjectReader(new JacksonJsonObjectReader<>(PostDto.class))
                .strict(false)
                .build();
    }

    @Bean
    public ItemWriter<PostDto> itemWriter() {
        return items -> {
            for (PostDto item : items) {
                log.info("item = " + item);
            }
        };
    }

    @Bean
    public Job job() throws Exception {
        return jobBuilderFactory.get("job")
                .start(step())
                .build();
    }

    @Bean
    public Step step() throws Exception {
        return stepBuilderFactory.get("step")
                .<PostDto, PostDto>chunk(5)
                .reader(itemReader())
                .writer(itemWriter())
                .build();
    }

    @Bean(destroyMethod = "close")
    public InputStream urlResource() throws IOException {
        Get get = Http.get(appConfiguration.getPostsUrl())
                .header(CONTENT_TYPE, "application/json")
                .header(AUTHORIZATION, authentication.token());

        return get.getInputStream();
    }
}
