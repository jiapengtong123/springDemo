import myspring.ApplicationContext;
import myspring.demo.User;

public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ApplicationContext("myspring");
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }
}
