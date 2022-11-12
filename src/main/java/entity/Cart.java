package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCard;

	private int amount;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userName")
	private Account account;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_P")
	private Product product;

	public Cart(int amount, Account account, Product product) {
		super();
		this.amount = amount;
		this.account = account;
		this.product = product;
	}

	public Cart() {
	}

	public int getIdCard() {
		return this.idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}