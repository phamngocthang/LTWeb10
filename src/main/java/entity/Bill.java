package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBill;

	@Temporal(TemporalType.DATE)
	private Date date;

	private double totalPrice;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="userName")
	private Account account;

	//bi-directional many-to-one association to Billdetail
	@OneToMany(mappedBy="bill")
	private List<Billdetail> billdetails;

	public Bill() {
	}

	public int getIdBill() {
		return this.idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Billdetail> getBilldetails() {
		return this.billdetails;
	}

	public void setBilldetails(List<Billdetail> billdetails) {
		this.billdetails = billdetails;
	}

	public Billdetail addBilldetail(Billdetail billdetail) {
		getBilldetails().add(billdetail);
		billdetail.setBill(this);

		return billdetail;
	}

	public Billdetail removeBilldetail(Billdetail billdetail) {
		getBilldetails().remove(billdetail);
		billdetail.setBill(null);

		return billdetail;
	}

}