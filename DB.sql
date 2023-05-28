
/*Phan loại theo giới tính - độ tuôi (Giày nam, giày nữ, giày trẻ em)*/
CREATE TABLE Category(
	id_Cate INT NOT NULL AUTO_INCREMENT,
	name_Cate VARCHAR(200) NOT NULL,
	PRIMARY KEY(id_Cate)
);
/*Một Category sẽ có nhiều SUBCATEGORY (VD: Giày Nam có giày tây, giày thể thao, giày sandals...)*/
CREATE TABLE Subcategory (
	id_SubCate INT NOT NULL AUTO_INCREMENT,
	id_Cate INT NOT NULL,
	SubCate_Name VARCHAR(200) NOT NULL,
	PRIMARY KEY(id_SubCate),
	FOREIGN KEY (id_Cate) REFERENCES Category(id_Cate)
);

/* Nguồn lấy data trang 6pm .com */
/* title - description - detail_desc - infor: chứa thông tin trên trang ShopDetail*/
/* id_ P - Name - id_cate - id_subcate - price - color - size - amount - title - brand - description*/
/* Màu sắc: lấy 3 màu Black, White, Blue */
/* Giá từ 100k -> 9999k  */
/* Size: M, L, XL  */
Create table Product (
	id_P INT AUTO_INCREMENT,
	name_P VARCHAR(200) NOT NULL,
	id_Cate INT NOT NULL,
	id_SubCate INT NOT NULL,
	price DOUBLE NOT NULL,
	color VARCHAR(20) NOT NULL,
	size VARCHAR(5) NOT NULL,
	amount INT NOT NULL,
	brand VARCHAR(100) NOT NULL,
	description VARCHAR(5000) NOT NULL,
	status INT NOT NULL,
	PRIMARY KEY(id_P),
	FOREIGN KEY (id_Cate) REFERENCES Category(id_Cate),
	FOREIGN KEY (id_SubCate) REFERENCES Subcategory(id_SubCate)
);

/* Quan hệ 1 - 1 với table Product, 1 PRODUCT có 3 ảnh giữa - trái - phải (nguồn ảnh 6pm .com) */
Create table Image (
	id_P INT,
	path_middle VARCHAR(2000) NOT NULL,
	path_left VARCHAR(2000) NOT NULL,
	path_right VARCHAR(2000) NOT NULL,
	PRIMARY KEY(id_P),
	FOREIGN KEY (id_P) REFERENCES Product(id_P)
);

INSERT INTO Category(id_cate, name_Cate) VALUES(1, 'Giày Nam');
INSERT INTO Category(id_cate, name_Cate) VALUES(2, 'Giày Nữ');

/* Giày Nam*/
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(1, 1, 'Giày Sandals Nam');
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(2, 1, 'Giày Lười Nam');
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(3, 1, 'Giày Sneaker Nam');
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(4, 1, 'Giày Thể Thao Nam');


/* giày Nữ*/
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(5, 2, 'Giày Cao Gót Nữ');
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(6, 2, 'Giày Sneaker Nữ');
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(7, 2, 'Giày Thể Thao Nữ');
INSERT INTO Subcategory(id_SubCate, id_Cate, SubCate_Name) VALUES(8, 2, 'Giày Đế Bệ Nữ');

/* id_ P - Name - id_cate - id_subcate - price - color - size - amount - brand - description - detail_desc - infor*/
/* Sandals Nam*/
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES('1', 'Byron Bungee Slide', 1, 1, 500000, 'Black', 'M', 50, 'Adidas', 'Thoải mái và phong cách, Rockport® Byron Bungee Slides chắc chắn sẽ trở thành món đồ mới của bạn.', 1);
/* id_P, name_P, path, path_middle, path_left, path_right */
INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(1, 'https://m.media-amazon.com/images/I/616SvGm1MDL._AC_SR920,736_.jpg', 'https://m.media-amazon.com/images/I/61VYESWgo1L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/611vEz+f3aL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES('2', 'Tommy Hilfiger Zolo', 1, 1, 300000, 'White', 'L', 50, 'Puma', 'Tommy Hilfiger® Zolo trông thật phong cách và mang đến sự thoải mái với phần đệm chân có đệm.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(2, 'https://m.media-amazon.com/images/I/51+eTBuACYL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/51w5S6IRteL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/611vEz+f3aL._AC_SR1840,1472_.jpg');

/* Lười Nam*/
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(3, 'Johnston & Murphy Collection', 1, 2, 859000, 'Black', 'XL', 50, 'Puma', 'Mang vào đôi giày Johnston & Murphy Collection® Ellsworth Penny cực kỳ nhẹ và linh hoạt.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(3, 'https://m.media-amazon.com/images/I/61zGn+NXztL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61CDV9iuhYL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61PCSdnvasL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(4, 'Ellsworth Penny', 1, 2, 299000, 'Brown', 'M', 50, 'Puma', 'Mang vào đôi giày Johnston & Murphy Collection® Ellsworth Penny cực kỳ nhẹ và linh hoạt.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(4, 'https://m.media-amazon.com/images/I/71QU1UOxsyL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71OIbl-wBjL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71BfJ8CEHAL._AC_SR1840,1472_.jpg');

/* Giay sneaker nam*/ 
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(5, 'Retropy F2', 1, 3, 259000, 'Black', 'L', 50, 'Adidas', 'Hãy sẵn sàng cho một buổi đi bộ bình thường vào buổi sáng hoặc buổi chạy dài nhất với đôi giày adidas® Originals Retropy F2 thoải mái.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(5, 'https://m.media-amazon.com/images/I/71S6r42sR8L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61W392PjYKL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/710c6dhCQRL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(6, 'Stan Smith', 1, 3, 299000, 'White', 'L', 50, 'Adidas', 'Kiếm những đường sọc của bạn với hình bóng mang tính biểu tượng và thiết kế đẹp mắt của giày thể thao adidas Originals Stan Smith.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(6, 'https://m.media-amazon.com/images/I/618SuUWdYwL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61IUuJjP-CL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61Rlpp0hU9L._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(7, 'ASSN Warmup', 1, 3, 835000, 'Blue', 'XL', 50, 'Nike', 'Tạo vẻ ngoài thoải mái đáng kể khi mang giày thể thao ASSN.® Warmup', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(7, 'https://m.media-amazon.com/images/I/81xT8Xt05TL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/81bXnWXvNPL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/719sZd0I4CL._AC_SR1840,1472_.jpg');

/* Giay thể thao Nam*/
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(8, 'Adizero Adios 6', 1, 4, 875000, 'White', 'M', 50, 'Adidas', 'Làm cho quá trình chạy bộ của bạn trở nên thú vị và dễ chịu hơn trong đôi giày adidas® Running Adizero Adios 6 này.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(8, 'https://m.media-amazon.com/images/I/61aJwW-c-iL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61fnEm-ipKL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/615PPW6pUDL._AC_SR1840,1472_.jpg');


INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(9, 'Levitate Stealthfit 5', 1, 4, 275000, 'White', 'M', 50, 'Nike', 'Duy trì sải bước và đạt được mục tiêu của bạn với giày chạy bộ Nike® Levitate Stealthfit 5 tràn đầy năng lượng.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(9, 'https://m.media-amazon.com/images/I/61fh5ifr-wL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71iymmViPbL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/718coEIm7CL._AC_SR1840,1472_.jpg');



/* Giay cao got nu*/
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(10, 'Anne Klein
Jayla', 2, 5, 675000, 'Black', 'XL', 50, 'Puma', 'Hãy mang đến cho bộ sưu tập giày dép của bạn một bản cập nhật nổi bật bằng cách chọn cho mình những đôi xăng đan Anne Klein® Jayla tuyệt đẹp.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(10, 'https://m.media-amazon.com/images/I/61GGN6L-m2L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/610s3fbu4CL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61eyIUluMfL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(11, 'Nine West
Haris', 2, 5, 1075000, 'White', 'M', 50, 'Puma', 'Trông cực kỳ sang trọng và thu hút mọi ánh nhìn bằng cách đeo Nine West® Haris Heels.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(11, 'https://m.media-amazon.com/images/I/61oEVaFVuPL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/51njTU9qBbL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61BXwxvwjdL._AC_SR1840,1472_.jpg');

/* Giay Sneaker*/
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(14, 'Tommy Hilfiger
Nery', 2, 6, 695000, 'Blue', 'L', 50, 'Adidas', 'Bước sang một phong cách mới trong mùa này với Giày thể thao xỏ ngón Nery của Tommy Hilfiger.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(14, 'https://m.media-amazon.com/images/I/71aE3RkYOSL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71Jj3Jc0G3L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61PAc074W-L._AC_SR1840,1472_.jpg');


INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(15, 'ZeroGrand Winner Tennis Sneaker', 2, 6, 795000, 'Blue', 'XL', 50, 'Nike', 'Bước sang một phong cách mới trong mùa này với Giày thể thao xỏ ngón Nery của ZeroGrand Winner Tennis Sneaker.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(15, 'https://m.media-amazon.com/images/I/71Y1NtsrIDL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71Qta3H2c8L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/61dPkHahrcL._AC_SR1840,1472_.jpg');

/* Giay thể thao nữ */
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(12, 'Nine West
Haris', 2, 7, 295000, 'Black', 'M', 50, 'Nike', 'Hãy tận hưởng cuộc chạy buổi sáng của bạn với đôi Giày Under Armour® Charged Vantage 2 trọng lượng nhẹ này có kiểu dáng thời trang và thiết kế bền bỉ.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(12, 'https://m.media-amazon.com/images/I/71VhaWPbhZL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71qr36vljIL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71+JtkVk-cL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(13, 'Under Armour
Charged Assert 9', 2, 7, 595000, 'Blue', 'L', 50, 'Puma', 'Đi trên đường phố và tập luyện chăm chỉ với đôi giày chạy bộ Under Armour® Assert 9 này, có thương hiệu Under Armour và phần đóng ren.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(13, 'https://m.media-amazon.com/images/I/711tHok3hFL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71jeGeILa4L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71lxywSQRJL._AC_SR1840,1472_.jpg');

/* Giày đế bệ nữ*/
INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(16, 'Jewel Devisha', 2, 8, 795000, 'Blue', 'XL', 50, 'Puma', 'Thêm phong cách và sự thoải mái cho trang phục của bạn khi mang Dép Jewel Badgley Mischka® Devisha, được trang trí bằng ren và ruy băng grosgrain đáng yêu.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(16, 'https://m.media-amazon.com/images/I/71jCGFtrP2L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71yxj1+2lKL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71b0mBKW0nL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(17, 'Seychelles
Great Escape', 2, 8, 595000, 'Blue', 'M', 50, 'Puma', 'Hãy nuông chiều bản thân với Seychelles® Great Escape Heels phù hợp tuyệt vời với hầu hết mọi trang phục.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(17, 'https://m.media-amazon.com/images/I/71EPZUNEobL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71Rv7XZI9ML._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71TVHZCM3eL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(18, 'Hilfiger
Ancer', 1, 2, 195000, 'Blue', 'XL', 50, 'Adidas', 'Hãy nuông chiều bản thân với Seychelles® Great Escape Heels phù hợp tuyệt vời với hầu hết mọi trang phục.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(18, 'https://m.media-amazon.com/images/I/61JAd7jCm4L._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71WKPKG4QUL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71pupq3WCSL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(19, 'Nantucket 2.0 Penny Loafer', 1, 2, 225000, 'Blue', 'M', 50, 'Nike', 'Bạn sẽ thích mang Cole Haan® Nantucket 2.0 Penny Loafer khi thời tiết ấm hơn với một đôi giày penny lười dễ dàng bật / tắt có các chi tiết ngăn màu và một tấm lót chân êm ái.', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(19, 'https://m.media-amazon.com/images/I/711B3h3IsLL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/81ZUuVp8ezL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/716y430PylL._AC_SR1840,1472_.jpg');

INSERT INTO Product(id_P, name_P, id_Cate, id_SubCate, price, color, size, amount , brand, description, status) VALUES(20, 'New Jenson Slip-On', 1, 2, 175000, 'White', 'M', 50, 'Nike', 'Hãy để Ben Sherman® New Jenson Slip-On mang đến cho bạn một cái nhìn thư giãn!', 1);

INSERT INTO Image(id_P, path_middle, path_left, path_right) VALUES(20, 'https://m.media-amazon.com/images/I/71Doo08k2HL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/713GuTY5GvL._AC_SR1840,1472_.jpg', 'https://m.media-amazon.com/images/I/71Yv7z+rxaL._AC_SR1840,1472_.jpg');
/* Quan hệ 1 - 1 với table Customer */
CREATE TABLE Account (
	userName VARCHAR(200) PRIMARY KEY,
	passWord varchar(200),
	isAdmin INT NOT NULL
);

Create TABLE Customer (
	userName VARCHAR(200) PRIMARY KEY,
	firstName VARCHAR(200) NOT NULL,
	lastName VARCHAR(200) NOT NULL,
	email VARCHAR(200) NOT NULL,
	address VARCHAR(200) NOT NULL,
	phonenumber VARCHAR(200) NOT NULL,
	FOREIGN KEY (userName) REFERENCES Account(userName)
);



Create Table Feedback (
	id_FB INT NOT NULL AUTO_INCREMENT,
	id_P INT NOT NULL,
	userName VARCHAR(200) NOT NULL,
	rate INT NOT NULL,
	content VARCHAR(5000) NOT NULL,
	date DATE NOT NULL,
	PRIMARY KEY(id_FB),
	FOREIGN KEY (id_P) REFERENCES Product(id_P),
	FOREIGN KEY (userName) REFERENCES Customer(userName)
);

/* Làm phần sản phẩm yêu thích*/
CREATE Table Favoriteproduct(
	id_spyeuthich INT NOT NULL AUTO_INCREMENT,
	userName VARCHAR(200) NOT NULL,
	id_P INT NOT NULL,
	PRIMARY KEY(id_spyeuthich),
	FOREIGN KEY (userName) REFERENCES Account(userName),
	FOREIGN KEY (id_P) REFERENCES Product(id_P)
);


Insert INTO Account Values('pntnoah', '123456', 1);
Insert INTO Account Values('admin', '123456', 1);
INSERT INTO Account VALUES('user1', '123456', 0);
INSERT INTO Account VALUES('user2', '123456', 0);
INSERT INTO Account VALUES('user3', '123456', 0);
INSERT INTO Account VALUES('user4', '123456', 0);
INSERT INTO Account VALUES('user5', '123456', 0);
INSERT INTO Account VALUES('user6', '123456', 0);


INSERT INTO Favoriteproduct Values(1,'pntnoah', 1);
INSERT INTO Favoriteproduct Values(2,'pntnoah', 2);
INSERT INTO Favoriteproduct Values(3,'pntnoah', 3);

INSERT INTO Customer VALUES('pntnoah', 'thang', 'pham', 'pntnoah1@gmail.com', '1 Vo Van Ngan', '0123456789');
INSERT INTO Customer VALUES('admin', 'phu', 'le', 'pntnoah2@gmail.com', '45 Hai Ba Trung', '0123456789');
INSERT INTO Customer VALUES('user1', 'Khanh', 'Huy', 'khanhhuy1@gmail.com', '6 Le Loi', '0123456789');
INSERT INTO Customer VALUES('user2', 'Duy', 'Ngoc', 'duyngoc1@gmail.com', '01 Ben Thanh', '0123456789');
INSERT INTO Customer VALUES('user3', 'Phan', 'Le', 'phanle1@gmail.com', '01 Huu Nghi', '0123456789');
INSERT INTO Customer VALUES('user4', 'Anh', 'Thu', 'anhthu1@gmail.com', '18 Thong Nhat', '0123456789');
INSERT INTO Customer VALUES('user5', 'Thanh', 'Phu', 'thanhphu1@gmail.com', '212 Nguyen Trai', '0123456789');
INSERT INTO Customer VALUES('user6', 'Quang', 'Quyen', 'quangquyen1@gmail.com', '428 Le Van Viet', '0123456789');

Create Table Cart (
	idCard INT NOT NULL AUTO_INCREMENT,
	userName VARCHAR(200) NOT NULL,
	id_P INT NOT NULL,
	amount INT NOT NULL,
	PRIMARY KEY(idCard),
	FOREIGN KEY (userName) REFERENCES Account(userName),
	FOREIGN KEY (id_P) REFERENCES Product(id_P)
);

Create Table Bill (
	idBill INT NOT NULL AUTO_INCREMENT,
	userName VARCHAR(200) NOT NULL,
	totalPrice double NOT NULL,
	date DATE NOT NULL,
	PRIMARY KEY(idBill),
	FOREIGN KEY (userName) REFERENCES Account(userName)
);
INSERT INTO Bill(userName, totalPrice, date) Values ('user6', 750000, '2021-11-20');
INSERT INTO Bill(userName, totalPrice, date) Values ('pntnoah', 150000, '2021-02-20');
INSERT INTO Bill(userName, totalPrice, date) Values ('user3', 100000, '2021-03-20');
INSERT INTO Bill(userName, totalPrice, date) Values ('user2', 1550000, '2021-11-20');
INSERT INTO Bill(userName, totalPrice, date) Values ('user1', 450000, '2021-03-20');
INSERT INTO Bill(userName, totalPrice, date) Values ('user1', 650000, '2021-04-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user2', 850000, '2021-05-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user2', 450000, '2021-05-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user3', 120000, '2021-06-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user3', 800000, '2021-06-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user4', 240000, '2021-07-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user5', 150000, '2021-08-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user5', 280000, '2021-09-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user5', 580000, '2021-09-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user1', 590000, '2021-10-12');
INSERT INTO Bill(userName, totalPrice, date) Values ('user3', 820000, '2021-11-20');
INSERT INTO Bill(userName, totalPrice, date) Values ('user4', 140000, '2021-11-20');
INSERT INTO Bill(userName, totalPrice, date) Values ('user5', 520000, '2021-11-20');



Create Table Billdetail (
	idBillDetail INT NOT NULL AUTO_INCREMENT,
	idBill INT NOT NULL,
	id_P INT NOT NULL,
	amount INT NOT NULL,
	PRIMARY KEY(idBillDetail),
	FOREIGN KEY (id_P) REFERENCES Product(id_P),
	FOREIGN KEY (idBill) REFERENCES Bill(idBill)
);

INSERT INTO Billdetail(idBill, id_P, amount) VALUES(1, 1, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(2, 5, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(3, 9, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(4, 11, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(5, 13, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(6, 19, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(6, 5, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(3, 8, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(14, 2, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(15, 14, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(10, 15, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(7, 17, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(13, 16, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(13, 5, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(14, 7, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(14, 11, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(15, 12, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(12, 13, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(7, 8, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(13, 6, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(4, 15, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(3, 16, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(13, 6, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(4, 7, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(3, 8, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(3, 9, 1);
INSERT INTO Billdetail(idBill, id_P, amount) VALUES(3, 12, 1);


