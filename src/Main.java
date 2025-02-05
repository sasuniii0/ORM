import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    private static FactoryConfiguration factoryConfiguration;
    public static void main(String[] args) {
        factoryConfiguration = FactoryConfiguration.getInstance();
        /*Customer customer2 = new Customer("Ann@gmail.com", 2, "Ann", "0114785237");
        Customer customer3 = new Customer("John@gmail.com", 3, "John", "0114785238");
        Customer customer4 = new Customer("Nice@gmail.com", 4, "Nice", "0114785239");
        Customer customer5 = new Customer("Mice@gmail.com", 5, "Mice", "0114785230");
        Customer customer6 = new Customer("Eva@gmail.com", 6, "Eva", "0114785231");

        saveCustomer(customer2);
        saveCustomer(customer3);
        saveCustomer(customer4);
        saveCustomer(customer5);
        saveCustomer(customer6);*/
        Customer customerById = getCustomerById(2);
        System.out.println(customerById);

        //boolean b = deleteCustomer(6);

        Customer customer = new Customer("Ann@gmail.com", 6, "Ann", "0114785237");
        updateCustomer(customer);

        List<Customer> allCustomer = getAllCustomer();
        for (Customer customers : allCustomer){
            System.out.println(customers);
        }
    }
    //save customer
    public static boolean saveCustomer(Customer customer){
        Session session = factoryConfiguration.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }   finally{
            if (session != null){
                session.close();
            }
        }
    }
    //get customer
    public static Customer getCustomerById(int id){
        Session session = factoryConfiguration.getSession();
        Customer customer = session.get(Customer.class,id);
        session.close();
        return customer;
    }
    //delete customer
    public static boolean deleteCustomer(int id){
        Session session = factoryConfiguration.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class,id);
            session.delete(customer);
            transaction.commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }   finally{
            if (session != null){
                session.close();
            }
        }
    }
    //update customer
    public static boolean updateCustomer(Customer customer){
        Session session = factoryConfiguration.getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
    //get all
    public static List<Customer> getAllCustomer(){
        Session session = factoryConfiguration.getSession();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();//HQL
        session.close();
        return customers;
    }
}