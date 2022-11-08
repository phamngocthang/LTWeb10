package context;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.hql.internal.CollectionProperties;
import org.hibernate.mapping.Property;
import org.hibernate.service.ServiceRegistry;

import entity.Account;
import entity.Category;
import entity.Customer;
import entity.Feedback;
import entity.Image;
import entity.Product;
import entity.Spyeuthich;
import entity.Subcategory;

public class HibernateUtil {
	/*private static SessionFactory sessionFactory = null;

    static {
        Configuration cfg = new Configuration().configure();
        Properties pros = new Properties();
		pros.put (Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
		pros.put (Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		pros.put (Environment.URL, "jdbc:mysql://localhost:3306/dbshopshoes");
		pros.put (Environment.USER, "root");
		pros.put (Environment.PASS, "");
		pros.put (Environment.SHOW_SQL, "true");
		cfg.setProperties (pros);
		cfg.addAnnotatedClass(Product.class);
		cfg.addAnnotatedClass(Image.class);
		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Feedback.class);
		cfg.addAnnotatedClass(Subcategory.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        }*/
    
	private final static SessionFactory FACTORY;
	
	static {
		Configuration conf = new Configuration ();
		Properties pros = new Properties();
		pros.put (Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		pros.put (Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		pros.put (Environment.URL, "jdbc:mysql://localhost:3306/ltweb");
		pros.put (Environment.USER, "root");
		pros.put (Environment.PASS, "20110687");
		pros.put (Environment.SHOW_SQL, "true");
		pros.put(Environment.AUTOCOMMIT, "true");
		
		conf.setProperties(pros);
		
		conf.addAnnotatedClass(Product.class);
		conf.addAnnotatedClass(Image.class);
		conf.addAnnotatedClass(Account.class);
		conf.addAnnotatedClass(Category.class);
		conf.addAnnotatedClass(Customer.class);
		conf.addAnnotatedClass(Feedback.class);
		conf.addAnnotatedClass(Subcategory.class);
		conf.addAnnotatedClass(Spyeuthich.class);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties()).build();

		FACTORY  = conf.buildSessionFactory(registry);
		
	}
	public static SessionFactory getSessionFactory(){
		return FACTORY;
	}
}
