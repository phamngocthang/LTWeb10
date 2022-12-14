package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoCategory;
import dao.DaoSubcategory;
import entity.Category;
import entity.Subcategory;

public class CategoryService {
  DaoCategory daoCategory = new DaoCategory();
  DaoSubcategory daoSub = new DaoSubcategory();
  public List<Category> getAllCategory() {
    return daoCategory.findAll("");
  }

  public List<Subcategory> getAllSubCategory() {
    return daoSub.findAll("");
  }

  public int countProduct(int subcategoryId) {
    String HQL = "Select count(*) From Product Where subcategory.id_SubCate = " + subcategoryId;
    int count = daoCategory.count(HQL);
    return count;
  }
  
}
