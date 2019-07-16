package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
public class TranslationsScheduleTask {
    private static final Logger log = LoggerFactory.getLogger(TranslationsScheduleTask.class);

    /*@Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(fixedRate = 5000)
    public void importTranslations() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        // TODO implement PhraseApp translations import scheduling here

        jobLauncher.run(job, new JobParametersBuilder().toJobParameters());

        log.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }*/
}
