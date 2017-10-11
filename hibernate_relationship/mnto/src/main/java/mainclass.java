import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class mainclass
{
    private static SessionFactory factory;
    public static void main(String[] args) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        tx=session.beginTransaction();
        Classs cl = (Classs)session.get(Classs.class,2);
        Student std1= (Student) session.get(Student.class,5);
//        session.delete(std1);
//  System.out.println(cl.getName());
        session.delete(cl);
        tx.commit();
//        System.out.println(std1.getName());
        session.close();

    }
}
