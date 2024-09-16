package b4.listfixcung.entity;


import lombok.*;

//annotation
//Lombok sẽ tự sinh ra các phương thức
@Getter //Tạo ra các phương thức getter và setter cho các trường dữ liệu.
@Setter
@ToString//Tạo ra phương thức toString.
@AllArgsConstructor //tạo ra một constructor có tham số cho tất cả các trường (fields) của lớp đó
@NoArgsConstructor //tạo một constructor không tham số
@Builder//giúp tạo ra các đối tượng 1 cách dễ dàng với các thuộc tính tùy chọn
public class SinhVien {
    //String mssv; String ten; int tuoi; boolean gioiTinh; String diaChi;
    private String mssv;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String diaChi;
}
