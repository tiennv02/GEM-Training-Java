# Tổng quát Project
- Trang web có chức năng thêm (CREATE), đọc (READ), sửa (UPDATE), xoá (DELETE)
- Cơ sở dữ liệu PostgresDB (cài đặt bên dưới)
- FrameWork: Spring MVC + JBDC Template;
- Cấu trúc Project: 
	. Các file view bao gồm các trang hiển thị trên trình duyệt (.jsp): viewemp, empform, editform trong src/main/webapp/WEB-INF/jsp
	. Model Emp lưu trữ thông tin về đối tượng
	. Controller EmpController có chức năng nhận, xử lí, phản hồi yêu cầu từ view
	. EmpDao thực hiện các câu lệnh truy vấn xử lí thông tin từ CSDL

# Cài đặt Project
- Tạo cơ sở dữ liệu PostgresDB như sau:
```
CREATE TABLE public.emp
(
    id INTEGER DEFAULT nextval('emp_id_seq'::regclass) PRIMARY KEY NOT NULL,
    name VARCHAR(4000),
    salary DOUBLE PRECISION,
    designation VARCHAR(4000)
);
CREATE UNIQUE INDEX table_name_pkey ON public.emp (id)
```
lưu ý: khoá chính của project được đặt ở chế độ auto increase, not null và unique. Người dùng sẽ không thao tác với khoá chính (ID)

- Chỉnh sửa file cấu hình spring-servlet.xml những nội dung trong thẻ bean sau khi đã có cơ sở dữ liệu:

```
<bean id="ds" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="org.postgresql.Driver"></property>
        <property name="url" value=""></property> <!--địa chỉ CSDL-->
        <property name="username" value="postgres"></property> <!--tên người dùng CSDL-->
        <property name="password" value=""></property><!--mật khẩu-->
</bean>
```
- Chọn Run/Edit Configuration: để cấu hình project chạy với TomCat Server/Local