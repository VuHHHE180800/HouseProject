create database TroDB
use TroDB
CREATE TABLE users (
    user_id int identity(1,1) PRIMARY KEY,
    username NVARCHAR(20) ,
    password nVARCHAR(15),
    email nVARCHAR(100) ,
    phone_number NVARCHAR(10),
	gender bit,
	role bit
);

CREATE TABLE Home (
    Home_id int identity(1,1)  PRIMARY KEY,
    Name nvarchar(20),
    address nvarchar(20),
    description nvarchar(500),
	elec_price int,
	service_price int,
    owner_id  int FOREIGN KEY  REFERENCES users(user_id),
	reveiw_score float,
	image nvarchar(50)
);

create table room(
	room_id int identity(1,1)  primary key,
	room_price int,
	room_name varchar(5),
	dt float,
	photo nvarchar(50),
	avaliable bit,
	House_id int foreign key references Home(Home_id),
	numberHuman int
);

Create table Cart(
	cartid int identity(1,1) Primary key,
	cusid int foreign key references users(user_id),
	bookingDate nvarchar(50),
	phong_id int foreign key references room(room_id),
	timeRent int
)



CREATE TABLE HopDong (
    hdid int identity(1,1) PRIMARY KEY,
    cusid int foreign key references users(user_id),
	phong_id int foreign key references room(room_id),
	bookingDate nvarchar(50),
	timeRent int,
	totalPrice int ,
	enterDate nvarchar(50) 
);

INSERT INTO users (username, password, email, phone_number, gender, role) VALUES
(N'nguyen_van', '123456', 'van@example.com', '0123456790', 0, 1),
(N'pham_minh', '123456', 'minh@example.com', '0123456791', 0, 1),
(N'le_thanh', '123456', 'thanh@example.com', '0123456792', 0, 1),
(N'nguyen_quyen', '123456', 'quyen@example.com', '0123456793', 0, 1),
(N'tran_dao', '123456', 'dao@example.com', '0123456794', 0, 1),
(N'ngo_thai', '123456', 'thai@example.com', '0123456795', 0, 1),
(N'pham_hieu', '123456', 'hieu@example.com', '0123456796', 0, 1),
(N'tran_lan', '123456', 'lan@example.com', '0123456797', 1, 1),
(N'nguyen_hai', '123456', 'hai@example.com', '0123456798', 1, 1),
(N'pham_truc', '123456', 'truc@example.com', '0123456799', 1, 1),
(N'tran_tam', '123456', 'tam@example.com', '0123456789', 0, 0),
(N'nguyen_anh', '123456', 'anh@example.com', '0123456789', 0, 0),
(N'tran_binh', '123456', 'binh@example.com', '0123456780', 0, 0),
(N'le_chi', '123456', 'chi@example.com', '0123456781', 1, 0),
(N'pham_dung', '123456', 'dung@example.com', '0123456782', 0, 0),
(N'ngo_hoang', '123456', 'hoang@example.com', '0123456783', 0, 0),
(N'tran_huong', '123456', 'huong@example.com', '0123456784', 1, 0),
(N'nguyen_khanh', '123456', 'khanh@example.com', '0123456785', 1, 0),
(N'vo_linh', '123456', 'linh@example.com', '0123456786', 0, 0),
(N'le_phuong', '123456', 'phuong@example.com', '0123456787', 1, 0),
(N'phan_quoc', '123456', 'quoc@example.com', '0123456788', 0, 0);

INSERT INTO Home (Name, address, description, service_price, elec_price, owner_id, reveiw_score, image) VALUES
(N'Trọ Nguyễn Hiền', N'Thôn 4', N'Nhà trọ mà cứ như khách sạn ý cả nhà ạ', 160000, 3000, 1, 4.5, 'img/home1.jpg'),
(N'Hòa Lạc Apartment', N'Thôn 2', N'Phòng đầy đủ nội thất, giờ giấc tự do thoải mái', 100000, 3000, 2, 4.7, 'img/home2.jpg'),
(N'SkyHome', N'Thôn 2', N'Đến ngay với đại gia đình Skyhome, một chung cư mini với đầy đủ nội thất cơ bản bao gồm điều hoà, tủ lạnh, máy giặt,…', 180000, 3500, 3, 4.2, 'img/home3.jpg'),
(N'Hoàng Kim house', N'Tân Xã', N'Có sẵn đồ nội thất cơ bản như máy giặt, máy lọc, điều hòa,...', 160000, 2500, 4, 3.8, 'img/home4.jpg'),
(N'Trọ Nguyên Khôi', N'Tân Xã', N'Gần siêu thị Minh Vượt, chợ Hola, giờ giấc thoải mái', 150000, 3000, 5, 4.6, 'img/home5.jpg'),
(N'Trọ Phú Hữu', N'Thôn 3', N'Nội thất tối nhẹ nhàng, phòng trọ phù hợp cho 2 bạn sinh viên', 100000, 3000, 6, 4.9, 'img/home6.jpg'),
(N'Trọ Diamond', N'Thôn 3', N'Không chung chủ, giờ giấc thoải mái.', 200000, 3000, 7, 4.0, 'img/home7.jpg'),
(N'Trọ Quang Duy', N'Thôn 4', N'Thích hợp cho những bạn thích sống 1 mình, ko thích ồn ào.', 220000, 3000, 8, 4.8, 'img/home8.jpg'),
(N'Trọ Tuấn Cường', N'Tân Xã', N'Nhà mới sơn nên rất sạch sẽ, phòng có đầy đủ nội thất cơ bản', 130000, 2800, 9, 3.9, 'img/home9.jpg'),
(N'Young House', N'Tân Xã', N'Dạng phòng gác xép được trang bị nội thất decor xinh xắn, trẻ trung', 190000, 3000, 10, 4.3, 'img/home10.jpg');

INSERT INTO room (room_price, room_name, dt, photo, avaliable, House_id, numberHuman) VALUES
(2000000, '101', 33, 'img/tro1.jpg', 1, 1, 2),
(2100000, '102', 30, 'img/tro2.jpg', 1, 1, 2),
(3600000, '103', 32, 'img/tro3.jpg', 1, 2, 3),
(4000000, '104', 33, 'img/tro4.jpg', 1, 2, 2),
(2500000, '105', 36, 'img/tro5.jpg', 1, 3, 2),
(2100000, '106', 30, 'img/tro6.jpg', 1, 3, 3),
(2600000, '107', 35, 'img/tro7.jpg', 1, 4, 2),
(2700000, '108', 30.5, 'img/tro8.jpg', 1, 4, 3),
(1500000, '109', 28, 'img/tro9.jpg', 1, 5, 3),
(1800000, '201', 30, 'img/tro10.jpg', 1, 5, 2),
(1100000, '202', 21.5, 'img/tro11.jpg', 1, 6, 2),
(1200000, '203', 22.5, 'img/tro12.jpg', 1, 6, 3),
(2300000, '204', 30, 'img/tro13.jpg', 1, 7, 2),
(2400000, '205', 30.5, 'img/tro14.jpg', 1, 7, 3),
(2500000, '206', 31.0, 'img/tro15.jpg', 1, 8, 2),
(2600000, '207', 31.5, 'img/tro16.jpg', 1, 8, 3),
(2700000, '208', 32.0, 'img/tro17.jpg', 1, 9, 3),
(2800000, '209', 32.5, 'img/tro18.jpg', 1, 9, 2),
(1900000, '301', 26, 'img/tro19.jpg', 1, 10, 2),
(2000000, '302', 28, 'img/tro20.jpg', 1, 10, 3);

drop table Cart
drop table HopDong
drop table room
drop table Home
drop table users

