package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import entity.Spyeuthich;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_P;

	private int amount;

	private String brand;

	private String color;

	private String description;

	private String name_P;

	private double price;

	private String size;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="product")
	private List<Feedback> feedbacks;

	//bi-directional one-to-one association to Image
	@OneToOne(mappedBy="product")
	private Image image;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_Cate")
	private Category category;

	//bi-directional many-to-one association to Subcategory
	@ManyToOne
	@JoinColumn(name="id_SubCate")
	private Subcategory subcategory;

	//bi-directional many-to-one association to Spyeuthich
	@OneToMany(mappedBy="product")
	private List<Spyeuthich> spyeuthiches;

	public Product() {
	}

	public int getId_P() {
		return this.id_P;
	}

	public void setId_P(int id_P) {
		this.id_P = id_P;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName_P() {
		return this.name_P;
	}

	public void setName_P(String name_P) {
		this.name_P = name_P;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setProduct(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setProduct(null);

		return feedback;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public List<Spyeuthich> getSpyeuthiches() {
		return this.spyeuthiches;
	}

	public void setSpyeuthiches(List<Spyeuthich> spyeuthiches) {
		this.spyeuthiches = spyeuthiches;
	}

	public Spyeuthich addSpyeuthich(Spyeuthich spyeuthich) {
		getSpyeuthiches().add(spyeuthich);
		spyeuthich.setProduct(this);

		return spyeuthich;
	}

	public Spyeuthich removeSpyeuthich(Spyeuthich spyeuthich) {
		getSpyeuthiches().remove(spyeuthich);
		spyeuthich.setProduct(null);

		return spyeuthich;
	}

}