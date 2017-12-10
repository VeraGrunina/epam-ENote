import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        User vera = new User(13L, "Vera", "vera76532", "testPassword");
        User noname = new User();

        System.out.println(vera.getName());
        System.out.println(noname.getName());
    }
}
