package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import context.HibernateUtil;
import entity.Category;
import entity.Subcategory;

public class DaoCategory {

  // get all category with jpa
  public List<Category> getAllCategory(String HQL) {
    List<Category> list = new ArrayList<>();

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      list = session.createQuery(HQL, Category.class).getResultList();
      session.close();
    } catch (Exception e) {
    }
    System.out.println(list);
    return list;
  }

  public List<Subcategory> getAllSubCategory(String HQL) {
    List<Subcategory> list = new ArrayList<>();

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      list = session.createQuery(HQL, Subcategory.class).getResultList();
      session.close();
    } catch (Exception e) {
    }
    System.out.println(list);
    return list;
  }

  public Integer countProduct(String HQL) {
    List<Number> list = new ArrayList<>();

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      list = session.createQuery(HQL, Number.class).getResultList();
      session.close();
    } catch (Exception e) {
    }
    System.out.println(list);
    return list.get(0).intValue();
  }
}
