package Helper;

import JavaClasses.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InsertHelper {
    private SessionFactory factory;

    public InsertHelper(SessionFactory factory) {
        this.factory = factory;
    }

    public void insertDB(Father father){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.persist(father);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void insertProductLine(ProductLine productLine){
        insertDB(productLine);
    }

    public void insertProduct(Product product){
        insertDB(product);
    }

    public void insertOrderDetail(OrderDetail orderDetail){
        insertDB(orderDetail);
    }

    public void insertOrder(Order order){
        insertDB(order);
    }
}
