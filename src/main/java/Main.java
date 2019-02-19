import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vasyunin.store.Client;
import ru.vasyunin.store.Order;
import ru.vasyunin.store.OrderInformation;
import ru.vasyunin.store.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(OrderInformation.class);
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        System.out.println(showProductsByClient(4));
        System.out.println(showClientsByProduct(5));
        System.out.println(showPrice(1, 3));

//        removeClient(3);
//        removeProduct(6);
    }

    public static void removeClient(long id){
        final Session session = getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.delete(client);
        session.getTransaction().commit();
    }

    public static void removeProduct(long id){
        final Session session = getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public static List<Client> showClientsByProduct(long product_id){
        final Session session = getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, product_id);
        if (product == null) return null;
        List<Client> result = product.getClients();
        session.getTransaction().commit();
        return result;
    }

    public static List<Product> showProductsByClient(long client_id){
        final Session session = getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, client_id);
        if (client == null) return null;
        List<Product> result = client.getProducts();
        session.getTransaction().commit();
        return result;
    }

    /*
        По другому реализовать не получилось
     */
    public static List<OrderInformation> showPrice(long client_id, long product_id){
        final Session session = getSession();
        session.beginTransaction();
        List<OrderInformation> orders = session.createQuery("select oi from Order o left join OrderInformation oi on (o.id = oi.order_id) where o.client_id=:client and o.product_id=:product", OrderInformation.class)
                .setParameter("client", client_id)
                .setParameter("product", product_id)
                .getResultList();
        session.getTransaction().commit();
        return orders;
    }

}