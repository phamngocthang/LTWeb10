package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Subcategory.findAll", query="SELECT s FROM Subcategory s")
public class Subcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_SubCate;

	private String subCate_Name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="subcategory")
	private List<Product> products;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_Cate")
	private Category category;

	public Subcategory() {
	}

	public int getId_SubCate() {
		return this.id_SubCate;
	}

	public void setId_SubCate(int id_SubCate) {
		this.id_SubCate = id_SubCate;
	}

	public String getSubCate_Name() {
		return this.subCate_Name;
	}

	public void setSubCate_Name(String subCate_Name) {
		this.subCate_Name = subCate_Name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSubcategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSubcategory(null);

		return product;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}