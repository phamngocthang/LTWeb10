package entity;

public class Image {
	private int id_P;
	private String path_middle;
	private String path_left;
	private String path_right;
	public int getId_P() {
		return id_P;
	}
	public void setId_P(int id_P) {
		this.id_P = id_P;
	}
	public String getPath_middle() {
		return path_middle;
	}
	public void setPath_middle(String path_middle) {
		this.path_middle = path_middle;
	}
	public String getPath_left() {
		return path_left;
	}
	public void setPath_left(String path_left) {
		this.path_left = path_left;
	}
	public String getPath_right() {
		return path_right;
	}
	public void setPath_right(String path_right) {
		this.path_right = path_right;
	}
	@Override
	public String toString() {
		return "Image [id_P=" + id_P + ", path_middle=" + path_middle + ", path_left=" + path_left + ", path_right="
				+ path_right + "]";
	}
	public Image(int id_P, String path_middle, String path_left, String path_right) {
		super();
		this.id_P = id_P;
		this.path_middle = path_middle;
		this.path_left = path_left;
		this.path_right = path_right;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Image(String path_middle) {
		super();
		this.path_middle = path_middle;
	}
	public Image(String path_middle, String path_left, String path_right) {
		super();
		this.path_middle = path_middle;
		this.path_left = path_left;
		this.path_right = path_right;
	}
}
