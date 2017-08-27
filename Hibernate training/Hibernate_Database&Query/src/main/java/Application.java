import Helper.InsertHelper;
import Helper.SelectHelper;
import JavaClasses.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

public class Application {
    private static SessionFactory sessionFactory;
    private static InsertHelper insertHelper;
    private static SelectHelper selectHelper;

    public static void main(String[] args){
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

        // builds a session factory from the service registry
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        selectHelper = new SelectHelper(sessionFactory);
//        displayProductLine();
//        displayProductHQL();
//        displayProductNative();
        displayProductCriteria();

//        insertHelper = new InsertHelper(sessionFactory);
//        insert();


    }

    public static void insert(){
        ProductLine productLine = new ProductLine("Audi","Come From Germany","htmlaudi","imageaudi");

        Product product = new Product("G200","Berus","Violet Color",500,25000);
        product.setProductLine(productLine);

        Product product1 = new Product("G300","Champa","Brown Color",300,20000);
        product1.setProductLine(productLine);

        Date date = new Date();
        Order order = new Order(4,date,date,date,"processing");

        OrderDetail orderDetail = new OrderDetail(new OrderDetailId(4,"G200"),50);
        orderDetail.setProduct(product);
        orderDetail.setOrder(order);

        OrderDetail orderDetail1 = new OrderDetail(new OrderDetailId(4,"D300"),40);
        orderDetail1.setProduct(product1);
        orderDetail1.setOrder(order);

        insertHelper.insertDB(productLine);
        insertHelper.insertDB(product);
        insertHelper.insertDB(product1);

        insertHelper.insertDB(order);
        insertHelper.insertDB(orderDetail);
        insertHelper.insertDB(orderDetail1);
    }

    public static void displayProductLine(){
        List<ProductLine> productLineList = selectHelper.getAllProductLine();
        for (int i=0; i<productLineList.size(); i++){
            System.out.println("ProductLine         : " + productLineList.get(i).getId());
            System.out.println("TextDescription     : " + productLineList.get(i).getTextDescription());
            System.out.println("HtmlDescription     : " + productLineList.get(i).getHtmlDescription());
            System.out.println("Image               : " + productLineList.get(i).getImage());
            System.out.println("------------------------");
        }
    }

    public static void displayProductHQL(){
        List<Product> productList = selectHelper.getAllProductHQL();
        for (int i=0; i<productList.size(); i++){
            System.out.println("ProductCode             : " + productList.get(i).getProductCode());
            System.out.println("ProductName             : " + productList.get(i).getProductName());
//            System.out.println("ProductLine             : " + productList.get(i).getProductLine().getId());
            System.out.println("ProductDescription      : " + productList.get(i).getProductDescription());
            System.out.println("QuantityInStock         : " + productList.get(i).getQuantityInStock());
            System.out.println("BuyPrice                : " + productList.get(i).getBuyPrice());
            System.out.println("------------------------");
        }
    }

    public static void displayProductNative(){
        List<Product> productList = selectHelper.getAllProductNative();
        for (int i=0; i<productList.size(); i++){
            System.out.println("ProductCode             : " + productList.get(i).getProductCode());
            System.out.println("ProductName             : " + productList.get(i).getProductName());
//            System.out.println("ProductLine             : " + productList.get(i).getProductLine().getId());
            System.out.println("ProductDescription      : " + productList.get(i).getProductDescription());
            System.out.println("QuantityInStock         : " + productList.get(i).getQuantityInStock());
            System.out.println("BuyPrice                : " + productList.get(i).getBuyPrice());
            System.out.println("------------------------");
        }
    }

    public static void displayProductCriteria(){
        List<Product> productList = selectHelper.getAllProductCriteria();
        for (int i=0; i<productList.size(); i++){
            System.out.println("ProductCode             : " + productList.get(i).getProductCode());
            System.out.println("ProductName             : " + productList.get(i).getProductName());
//            System.out.println("ProductLine             : " + productList.get(i).getProductLine().getId());
            System.out.println("ProductDescription      : " + productList.get(i).getProductDescription());
            System.out.println("QuantityInStock         : " + productList.get(i).getQuantityInStock());
            System.out.println("BuyPrice                : " + productList.get(i).getBuyPrice());
            System.out.println("------------------------");
        }
    }
}
