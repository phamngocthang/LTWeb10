package entity;

import java.io.Serializable;
import java.util.List;

import entity.Image;

public class Product implements Serializable {
	private int id_P;
	private String name_P;
	private int id_Cate;
	private int id_SubCate;
	private double price;;
	private String color;
	private String size;
	private int amount;
	private String title;
	private String brand;
	private String description;
	private String detail_desc;
	private String infor;
	private Image img;
	
	public int getId_P() {
		return id_P;
	}
	public void setId_P(int id_P) {
		this.id_P = id_P;
	}
	public String getName_P() {
		return name_P;
	}
	public void setName_P(String name_P) {
		this.name_P = name_P;
	}
	public int getId_Cate() {
		return id_Cate;
	}
	public void setId_Cate(int id_Cate) {
		this.id_Cate = id_Cate;
	}
	public int getId_SubCate() {
		return id_SubCate;
	}
	public void setId_SubCate(int id_SubCate) {
		this.id_SubCate = id_SubCate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetail_desc() {
		return detail_desc;
	}
	public void setDetail_desc(String detail_desc) {
		this.detail_desc = detail_desc;
	}
	public String getInfor() {
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id_P, String name_P, int id_Cate, int id_SubCate, double price, String color, String size,
			int amount, String title, String brand, String description, String detail_desc, String infor, Image img) {
		super();
		this.id_P = id_P;
		this.name_P = name_P;
		this.id_Cate = id_Cate;
		this.id_SubCate = id_SubCate;
		this.price = price;
		this.color = color;
		this.size = size;
		this.amount = amount;
		this.title = title;
		this.brand = brand;
		this.description = description;
		this.detail_desc = detail_desc;
		this.infor = infor;
		this.img = img;
	}
	public Product(int id_P, String name_P,double price, Image img) {
		super();
		this.id_P = id_P;
		this.name_P = name_P;
		this.price = price;
		this.img = img;
	}
	public Product(int id_P, String name_P,double price, String color, String size,
			int amount, String description, String detail_desc, String infor, Image img) {
		super();
		this.id_P = id_P;
		this.name_P = name_P;
		this.price = price;
		this.color = color;
		this.size = size;
		this.amount = amount;
		this.description = description;
		this.detail_desc = detail_desc;
		this.infor = infor;
		this.img = img;
	}
	@Override
	public String toString() {
		return "Product [id_P=" + id_P + ", name_P=" + name_P + ", id_Cate=" + id_Cate + ", id_SubCate=" + id_SubCate
				+ ", price=" + price + ", color=" + color + ", size=" + size + ", amount=" + amount + ", title=" + title
				+ ", brand=" + brand + ", description=" + description + ", detail_desc=" + detail_desc + ", infor="
				+ infor + ", img=" + img + "]";
	}
	
	
}
