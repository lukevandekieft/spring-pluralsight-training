package com.pluralsight;

import com.pluralsight.AppConfig;
import com.pluralsight.services.SpeakerService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ConferenceDemoApplication {
  public static void main(String args[]) {
    // "args" is how in-line arguments get passed in
    SpringApplication.run(ConferenceDemoApplication.class, args);
  }
}

////DEMO 1:
//public class Application {
//  public static void main(String args[]) {
//    ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
//    SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
//
//    System.out.println(service.findAll().get(0).getFirstName());
//    System.out.println(service.findAll().get(0).getLastName());
//    System.out.println(service.findAll().get(0).getSeedNum());
//  }
//}
