package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TestAnnotation {

    public static void main (String [] args){
//
//        //Sử dụng khi cấu hình bean = annotation
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        HelloWorld h = (HelloWorld) context.getBean("hello");
//        h.sayHello();


//        //Sử dụng khi component-scan
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//        //iD của bean chính là tên của class chứa @Component với kí tự đầu viết thường.
        HelloWorld h_bean = (HelloWorld) context.getBean("helloWorld");
        h_bean.sayHello();
    }
}
