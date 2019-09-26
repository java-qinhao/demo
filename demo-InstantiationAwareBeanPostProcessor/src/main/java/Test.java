import com.luban.config.AppConfig;
import com.luban.service.Service1;
import com.luban.service.Service2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Service1 service1=(Service1)context.getBean("service1");
        service1.query();
    }
}
