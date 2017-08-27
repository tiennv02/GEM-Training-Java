package Helper;

import JavaClasses.Order;
import JavaClasses.OrderDetail;
import JavaClasses.Product;
import JavaClasses.ProductLine;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class SelectHelper {
    private SessionFactory factory;

    public SelectHelper(SessionFactory factory) {
        this.factory = factory;
    }

    public List<ProductLine> getAllProductLine(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ProductLine> productLineList = new ArrayList<ProductLine>();

        try{
            productLineList = (List<ProductLine>) session.createQuery("FROM ProductLine").list();
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return productLineList;
    }

    public List<Product> getAllProductHQL(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> productList = new ArrayList<Product>();

        try{
            productList = (List<Product>) session.createQuery("FROM Product").list();
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return productList;
    }

    public List<Product> getAllProductNative(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> productList = new ArrayList<Product>();

        try{
            String sql = "SELECT * FROM products";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            productList = query.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return productList;
    }

    public List<Product> getAllProductCriteria(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> productList = new ArrayList<Product>();

        try{
            Criteria cr = session.createCriteria(Product.class);
            productList = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return productList;
    }

    public List<Order> getAllOrder(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Order> orderList = new ArrayList<Order>();

        try{
            orderList = (List<Order>) session.createQuery("FROM Order").list();
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return orderList;
    }

    public List<OrderDetail> getAllOrderDetail(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

        try{
            orderDetailList = (List<OrderDetail>) session.createQuery("FROM OrderDetail").list();
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return orderDetailList;
    }

}
