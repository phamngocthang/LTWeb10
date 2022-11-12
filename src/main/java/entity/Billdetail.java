package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the billdetail database table.
 * 
 */
@Entity
@NamedQuery(name="Billdetail.findAll", query="SELECT b FROM Billdetail b")
public class Billdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBillDetail;

	private int amount;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_P")
	private Product product;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="idBill")
	private Bill bill;

	public Billdetail() {
	}

	public int getIdBillDetail() {
		return this.idBillDetail;
	}

	public void setIdBillDetail(int idBillDetail) {
		this.idBillDetail = idBillDetail;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}