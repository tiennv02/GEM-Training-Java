import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageEmployee ME = new ManageEmployee();

        HashSet set1 = new HashSet();
        set1.add(new Certificate("MCA"));
        set1.add(new Certificate("MBA"));
        set1.add(new Certificate("PMP"));

        // Add employee records in the database
        Integer empID1 = ME.addEmployee("Ho", "Van A", 4000, set1);

        // Another set of certificates for the second employee
//        HashSet set2 = new HashSet();
//        set2.add(new Certificate("BCA"));
//        set2.add(new Certificate("BA"));
//
//        // Add another employee record in the database
//        Integer empID2 = ME.addEmployee("Vo", "Van B", 3000, set2);
//
//        System.out.println("Show list all employees");
//        ME.listEmployees();

//        System.out.println("Update empID1");
//        ME.updateEmployee(empID1, 5000);
//
//        System.out.println("Delete empID2");
//        ME.deleteEmployee(empID2);
//
//        System.out.println("Show list all employees");
//        ME.listEmployees();
        Session session = factory.openSession();
        Transaction tx = null;
        Employee e= (Employee) session.get(Employee.class,5);

        Set<Certificate> set=e.getCertificates();
        System.out.println(set.size());
        /** su dung con de thay doi cha **/
        for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
            Certificate certName = (Certificate) iterator2.next();
            session.delete(certName);
            System.out.println("Certificate: " + certName.getName());
        }

        session.close();

    }

    // Method to add an employee record in the database
    public Integer addEmployee(String fname, String lname, int salary, Set cert) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employee.setCertificates(cert);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    // Method to list all the employees detail
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
                Employee employee = (Employee) iterator1.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
                Set certificates = employee.getCertificates();
                for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();) {
                    Certificate certName = (Certificate) iterator2.next();
                    System.out.println("Certificate: " + certName.getName());
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to update salary for an employee
//    public void updateEmployee(Integer EmployeeID, int salary) {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
//            employee.setSalary(salary);
//            session.update(employee);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Method to delete an employee from the records
//    public void deleteEmployee(Integer EmployeeID) {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
//            session.delete(employee);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
}
