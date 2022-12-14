package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_FB;

	private String content;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int rate;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_P")
	private Product product;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userName")
	private Customer customer;

	public Feedback() {
	}

	public int getId_FB() {
		return this.id_FB;
	}

	public void setId_FB(int id_FB) {
		this.id_FB = id_FB;
	}

	public String getContent() {
		return this.content;
	}

	

	public Feedback(int id_FB, String content, Date date, int rate, Product product) {
		super();
		this.id_FB = id_FB;
		this.content = content;
		this.date = date;
		this.rate = rate;
		this.product = product;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}