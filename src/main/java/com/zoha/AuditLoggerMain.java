package com.zoha;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

/**
 * @author amirhoshangi@gmail.com
 */
@SpringBootApplication
@ComponentScan("com.zoha")
public class AuditLoggerMain {

    //private static final String NEW_EPISODES_NOTIFICATION_JOB = "newEpisodesNotificationJob";
    private static final String ADD_PSTN_JOB = "addnewPSTNJob";

    public static void main(String[] args) throws BeansException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {

        //Log log = LogFactory.getLog(Application.class);

        SpringApplication app = new SpringApplication(AuditLoggerMain.class);
        app.setWebEnvironment(false);
        /*ConfigurableApplicationContext ctx=*/ app.run(args);
    //    JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);


      /*      Job addPSTNJob = ctx.getBean(ADD_PSTN_JOB, Job.class);
            JobParameters jobParameters = new JobParametersBuilder()
                    .addDate("date", new Date())
                    .toJobParameters();
*/
        //    JobExecution jobExecution = jobLauncher.run(addPSTNJob, jobParameters);

  /*          BatchStatus batchStatus = jobExecution.getStatus();
            while(batchStatus.isRunning()){
                System.out.println("*********** Still running.... **************");
                Thread.sleep(1000);
            }
            System.out.println(String.format("*********** Exit status: %s", jobExecution.getExitStatus().getExitCode()));
            JobInstance jobInstance = jobExecution.getJobInstance();
            System.out.println(String.format("********* Name of the job %s", jobInstance.getJobName()));

            System.out.println(String.format("*********** job instance Id: %d", jobInstance.getId()));
*/
            //System.exit(0);

        } /*else if(NEW_EPISODES_NOTIFICATION_JOB.equals(args[0])){
            JobParameters jobParameters = new JobParametersBuilder()
                    .addDate("date", new Date())
                    .addString("updateFrequency", args[1])
                    .toJobParameters();

            jobLauncher.run(ctx.getBean(NEW_EPISODES_NOTIFICATION_JOB,  Job.class), jobParameters);
        } else {
            throw new IllegalArgumentException("Please provide a valid Job name as first application parameter");
        }*/

        //System.exit(0);
    }




    /*    public static void main(String[] args) {
      SpringApplication.run(new Object[]{AuditLoggerMain.class}, args);



      System.out.println("Let's enjoy the audit logger");
    }
*/
/*
  static {
    //TODO: in prodcution should be changed
    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
            new javax.net.ssl.HostnameVerifier(){
              public boolean verify(String hostname,
                                    javax.net.ssl.SSLSession sslSession) {
                return true;
              }
            });
  }
*/

//}

