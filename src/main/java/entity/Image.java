package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_P;

	@Column(name="path_left")
	private String pathLeft;

	@Column(name="path_middle")
	private String pathMiddle;

	@Column(name="path_right")
	private String pathRight;

	//bi-directional one-to-one association to Product
	@OneToOne
	@JoinColumn(name="id_P")
	private Product product;

	public Image() {
	}

	public int getId_P() {
		return this.id_P;
	}

	public void setId_P(int id_P) {
		this.id_P = id_P;
	}

	public String getPathLeft() {
		return this.pathLeft;
	}

	public void setPathLeft(String pathLeft) {
		this.pathLeft = pathLeft;
	}

	public String getPathMiddle() {
		return this.pathMiddle;
	}

	public void setPathMiddle(String pathMiddle) {
		this.pathMiddle = pathMiddle;
	}

	public String getPathRight() {
		return this.pathRight;
	}

	public void setPathRight(String pathRight) {
		this.pathRight = pathRight;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}