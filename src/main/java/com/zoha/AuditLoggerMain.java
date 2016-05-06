package com.zoha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author amirhoshangi@gmail.com
 */
@SpringBootApplication
@ComponentScan("com.zoha")
public class AuditLoggerMain {
        public static void main(String[] args) {
      SpringApplication.run(new Object[]{AuditLoggerMain.class}, args);
      System.out.println("Let's enjoy the audit logger");
    }

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

}

