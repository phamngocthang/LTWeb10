package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the favoriteproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Favoriteproduct.findAll", query="SELECT f FROM Favoriteproduct f")
public class Favoriteproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_spyeuthich")
	private int idSpyeuthich;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userName")
	private Account account;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_P")
	private Product product;

	public Favoriteproduct() {
	}

	public int getIdSpyeuthich() {
		return this.idSpyeuthich;
	}

	public void setIdSpyeuthich(int idSpyeuthich) {
		this.idSpyeuthich = idSpyeuthich;
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