package com.pluralsight;

import com.pluralsight.AppConfig;
import com.pluralsight.data.User;
import com.pluralsight.services.SpeakerService;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


// DEMO 3: SpEL
public class ConferenceDemoApplication {
  public static void main(String args[]) throws Exception {

    SpelExpressionParser parser = new SpelExpressionParser();
    Expression exp1 = parser.parseExpression("'Hello World'");
    String message = (String) exp1.getValue();
    System.out.println(message);

    Expression exp2 = parser.parseExpression("'Hello World'.length()");
    System.out.println(exp2.getValue());

    StandardEvaluationContext ec1 = new StandardEvaluationContext();
    ec1.setVariable("greeting", "What it do!");
    String msg = (String) parser.parseExpression("#greeting.substring(5)").getValue(ec1);
    System.out.println(msg);

    User user = new User();
    StandardEvaluationContext userContext = new StandardEvaluationContext(user);
    parser.parseExpression("country").setValue(userContext, "USA");
    System.out.println(user.getCountry());

    StandardEvaluationContext propsContext = new StandardEvaluationContext();
    propsContext.setVariable("systemProperties", System.getProperties());
    Expression expCountry = parser.parseExpression("#systemProperties['user.country']");
    parser.parseExpression("country").setValue(userContext, expCountry.getValue(propsContext));
    System.out.println(user.getCountry());
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
