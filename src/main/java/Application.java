import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
  public static void main(String args[]) {
    ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

    // SpeakerService service = new SpeakerServiceImpl();     <-- old hard-coded way. Example below using setter injection.
    SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);

    // 3 lines below prove that SpeakerService is singleton - both instances have the same object address
    System.out.println(service);
    SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
    System.out.println(service2);

    System.out.println(service.findAll().get(0).getFirstName());
    System.out.println(service.findAll().get(0).getLastName());
  }
}
