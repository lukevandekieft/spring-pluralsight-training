import com.pluralsight.AppConfig;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class Application {
  public static void main(String args[]) {
    ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);

    System.out.println(service.findAll().get(0).getFirstName());
    System.out.println(service.findAll().get(0).getLastName());
  }
}
