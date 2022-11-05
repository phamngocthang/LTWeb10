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

	//bi-directional one-to-one association to Customer
	@OneToOne(mappedBy="account")
	private Customer customer;

	//bi-directional many-to-one association to Spyeuthich
	@OneToMany(mappedBy="account")
	private List<Spyeuthich> spyeuthiches;

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

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Spyeuthich> getSpyeuthiches() {
		return this.spyeuthiches;
	}

	public void setSpyeuthiches(List<Spyeuthich> spyeuthiches) {
		this.spyeuthiches = spyeuthiches;
	}

	public Spyeuthich addSpyeuthich(Spyeuthich spyeuthich) {
		getSpyeuthiches().add(spyeuthich);
		spyeuthich.setAccount(this);

		return spyeuthich;
	}

	public Spyeuthich removeSpyeuthich(Spyeuthich spyeuthich) {
		getSpyeuthiches().remove(spyeuthich);
		spyeuthich.setAccount(null);

		return spyeuthich;
	}

}