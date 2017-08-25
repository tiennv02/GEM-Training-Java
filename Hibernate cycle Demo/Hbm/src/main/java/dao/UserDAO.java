package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.sql.Date;
import java.util.Iterator;
import java.util.List;

public class UserDAO {
    public static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

//        User user = new User();     //transient state
//        user.setName("hoang");
//        user.setAddress("ha noi");
//
//        UserDAO userDAO = new UserDAO();
//        userDAO.addUser(user);


        //---- get load
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//        User user = (User) session.get(User.class,new Integer(15));
//        System.out.println(user.getName());
//        user.setName("HOANG");
//        session.update(user);
//        tx.commit();

        //---- start transient to persistent ----

        //persist save, save or update
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//        User user = new User("Hoang", "HN");
//        session.persist(user);      //void return type, call in transaction
//        session.save(user);         //obj return type, can call outside transaction
//        tx.commit();

        //update merge
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//        User user = new User("Hoang", "HN");
//        session.merge(user);        //create new db row if user is not exist
//        session.update(user);       //throw exception if not exist, just update only if exist

        //---- end transient to persistent ----

        //---- start persistent to detached using clear(), evict() and close() ----
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//        User user1 = (User) session.get(User.class, 15);
//        User user2 = (User) session.get(User.class, 16);
//
//        user1.setName("name clear save change");
//        user2.setAddress("address clear save change");
//
//        session.update(user1);
//        session.update(user2);
//        session.evict(user1);       //clear user1 only
//        session.clear();        //clear user1 and user2 from session
//
//        tx.commit();
//        session.close();          //close session

        //---- end persistent to detached ----

        //---- detached to persistent
        //* diffrence between update and merge
//        Session session = factory.openSession();
//        User user = (User) session.get(User.class, 15);
//        session.close();
//
//
//        Session session1 = factory.openSession();
//        Transaction tx = session1.beginTransaction();
//        User user1 = (User) session1.get(User.class, 15);
//        user1.setAddress("address");
//        session1.update(user1);          //cant not update while have 2 same objs in session
//        session1.merge(user1);             //can update
//        tx.commit();



    }
}
