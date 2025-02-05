import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice@gmail.com", 1, "Alice", "0114785236");

        //save customer
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);

        transaction.commit();
        session.close();
    }
}