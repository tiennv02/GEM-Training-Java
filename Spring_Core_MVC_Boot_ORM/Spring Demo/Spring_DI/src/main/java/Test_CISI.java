import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_CISI {

    public static void main (String [] args){
//        Gọi container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//        Lấy đối tượng (bean) từ trong container
        Drawing drawing = (Drawing) context.getBean("draw");

//        Sau khi lấy xong có thể thao tác
        drawing.drawDrawing();
    }
}
