package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoCategory;
import entity.Category;
import entity.Subcategory;

public class CategoryService {
  DaoCategory daoCategory = new DaoCategory();

  public List<Category> getAllCategory() {
    List<Category> list = new ArrayList<>();
    String HQL = "From Category";
    list = daoCategory.getAllCategory(HQL);
    return list;
  }

  public List<Subcategory> getAllSubCategory() {
    List<Subcategory> list = new ArrayList<>();
    String HQL = "From Subcategory";
    list = daoCategory.getAllSubCategory(HQL);
    return list;
  }

  public int countProduct(int subcategoryId) {
    String HQL = "Select count(*) From Product Where subcategory.id_SubCate = " + subcategoryId;
    int count = daoCategory.countProduct(HQL);
    return count;
  }
}
