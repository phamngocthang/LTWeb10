package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userName;

	private int isAdmin;

	private String passWord;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="account")
	private List<Bill> bills;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="account")
	private List<Cart> carts;

	//bi-directional one-to-one association to Customer
	@OneToOne(mappedBy="account")
	private Customer customer;

	//bi-directional many-to-one association to Favoriteproduct
	@OneToMany(mappedBy="account")
	private List<Favoriteproduct> favoriteproducts;

	public Account() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setAccount(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setAccount(null);

		return bill;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setAccount(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setAccount(null);

		return cart;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Favoriteproduct> getFavoriteproducts() {
		return this.favoriteproducts;
	}

	public void setFavoriteproducts(List<Favoriteproduct> favoriteproducts) {
		this.favoriteproducts = favoriteproducts;
	}

	public Favoriteproduct addFavoriteproduct(Favoriteproduct favoriteproduct) {
		getFavoriteproducts().add(favoriteproduct);
		favoriteproduct.setAccount(this);

		return favoriteproduct;
	}

	public Favoriteproduct removeFavoriteproduct(Favoriteproduct favoriteproduct) {
		getFavoriteproducts().remove(favoriteproduct);
		favoriteproduct.setAccount(null);

		return favoriteproduct;
	}

}