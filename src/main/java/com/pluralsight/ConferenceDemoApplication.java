package com.pluralsight;

import com.pluralsight.AppConfig;
import com.pluralsight.services.SpeakerService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;


// DEMO 3: SpEL
public class ConferenceDemoApplication {
  public static void main(String args[]) throws Exception {

    SpelExpressionParser parser = new SpelExpressionParser();
    Expression exp1 = parser.parseExpression("'Hello World'");
    String message = (String) exp1.getValue();
    System.out.println(message);
  }
}

//// DEMO 2: TOMCAT SERVER WITH DB
//@SpringBootApplication
//public class ConferenceDemoApplication {
//  public static void main(String args[]) throws Exception {
//    // "args" is how in-line arguments get passed in
//    SpringApplication.run(ConferenceDemoApplication.class, args);
//
//    SpelExpressionParser parser = new SpelExpressionParser();
//    Expression exp1 = parser.parseExpression("'Hello World'");
//    String message = (String) exp1.getValue();
//    System.out.println(message);
//  }
//}

////DEMO 1: XML & JAVA SETUPS
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
