import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Manager {
    private static SessionFactory factory;


    public void updateStudent(int id, Classs classs_id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Student std = (Student) session.get(Student.class, id);
            std.setClass_ID(classs_id);
            session.update(std);
            tx.commit();
            System.out.println("update complete");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteStudent(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student std = (Student) session.get(Student.class, id);
            session.delete(std);
            tx.commit();
            System.out.println("delete complete");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

    public void deleteClass(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Classs std = (Classs) session.get(Classs.class, id);
            session.delete(std);
            tx.commit();
            System.out.println("delete complete");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

    public static void main(String[] args) {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        /*demo cascade*********************************************************************/

        Transaction tx = null;
        tx = session.beginTransaction();
//        Student std= (Student) session.get(Student.class,2);//get sv2
//        System.out.println(std.getName());//in ra name
       Student stdadd=new Student(8,"quangdn",new Classs(10,"123456"));//ad student voi truong id_classs la 1 class moi chua co trong bang
       session.save(stdadd);//insert thanh cong neu co  cascade="all".
//        tx.commit();
        Manager mn = new Manager();
        // mn.updateStudent(4, (Classs) session.get(Classs.class,4));//update student,ok phet hihih
        //mn.deleteStudent(1);
      // mn.deleteClass(7);

//        Transaction tx=null;
//        try{
//            Student addstudent=new Student(8,"quangdaongoc",new Classs(9,"c++"));
//            tx = session.beginTransaction();
//            session.save(addstudent);
//            tx.commit();
//            System.out.println("adđ complete");
//        }catch (HibernateException e){
//            if(tx!=null){
//                tx.rollback();
//            }
//        }finally {
//            session.close();
//        }

        //many to one close
        //lay du lieu tu cha sang con la ko dc
    }
}
