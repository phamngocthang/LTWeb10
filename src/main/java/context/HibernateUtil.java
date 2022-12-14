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
import entity.Bill;
import entity.Billdetail;
import entity.Cart;
import entity.Category;
import entity.Customer;
import entity.Favoriteproduct;
import entity.Feedback;
import entity.Image;
import entity.Product;
import entity.Subcategory;

public class HibernateUtil {
    
	private final static SessionFactory FACTORY;
	
	static {
		Configuration conf = new Configuration ();
		Properties pros = new Properties();

		pros.put (Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		pros.put (Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		
		pros.put (Environment.URL, "jdbc:mysql://remotemysql.com/mgyaK3eV1F");
		pros.put (Environment.USER, "mgyaK3eV1F");
		pros.put (Environment.PASS, "K47f2jh7v4");
		
//		pros.put (Environment.URL, "jdbc:mysql://localhost:3306/ltweb");
//		pros.put (Environment.USER, "root");
//		pros.put (Environment.PASS, "123456");
		
		pros.put (Environment.SHOW_SQL, "true");
		pros.put(Environment.AUTOCOMMIT, "true");
		pros.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		pros.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");

		
		conf.setProperties(pros);
		
		conf.addAnnotatedClass(Product.class);
		conf.addAnnotatedClass(Image.class);
		conf.addAnnotatedClass(Account.class);
		conf.addAnnotatedClass(Category.class);
		conf.addAnnotatedClass(Customer.class);
		conf.addAnnotatedClass(Feedback.class);
		conf.addAnnotatedClass(Subcategory.class);
		conf.addAnnotatedClass(Favoriteproduct.class);
		conf.addAnnotatedClass(Bill.class);
		conf.addAnnotatedClass(Billdetail.class);
		conf.addAnnotatedClass(Cart.class);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties()).build();

		FACTORY  = conf.buildSessionFactory(registry);
		
	}
	public static SessionFactory getSessionFactory(){
		return FACTORY;
	}
}