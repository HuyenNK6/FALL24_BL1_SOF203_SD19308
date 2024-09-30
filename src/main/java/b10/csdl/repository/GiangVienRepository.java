package b10.csdl.repository;

import b10.csdl.entity.GiangVien;
import b10.csdl.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {
    /*
    repository => kết nối với cơ sở dữ liệu
    CRUD
    - Create <=> Insert
    - Read <=> Select
    - Update <=> Update
    - Delete <=> Delete
     */
    public ArrayList<GiangVien> getAll(){
        //B1: tạo danh sách
        ArrayList <GiangVien> listGV = new ArrayList<>();
        //B2: Viết câu lệnh sql
        String sql= "SELECT [ma]\n" +
                "      ,[ten]\n" +
                "      ,[loai]\n" +
                "      ,[tuoi]\n" +
                "      ,[bac]\n" +
                "      ,[gioi_tinh]\n" +
                "  FROM [dbo].[giang_vien]";
        //B3: Mở cổng kết nối => xảy ra ngoại lệ => ném vào try-catch
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps= con.prepareStatement(sql)) {
            //B4: Select => trả về 1 bảng ResultSet (1 dòng/ nhiều dòng) => execute Query
            ResultSet rs= ps.executeQuery();
            while (rs.next()){//kiểm tra xem còn có dòng nào kok??
                //B5: Tạo đối tượng GV mới
                GiangVien gv= new GiangVien();
                gv.setMaGV(rs.getString(1));
                gv.setTen(rs.getString(2));
                gv.setLoai(rs.getString(3));
                gv.setTuoi(rs.getInt(4));
                gv.setBac(rs.getInt(5));
                gv.setGioiTinh(rs.getBoolean(6));
                //B6: Thêm đối tượng vào danh sách
                listGV.add(gv);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listGV;
    }
    public GiangVien getOne(String maGV){

        //B2: Viết câu lệnh sql
        String sql= "SELECT ma, ten, loai, tuoi, bac, gioi_tinh\n" +
                "FROM     dbo.giang_vien\n" +
                "WHERE  (ma = ?)";
        //B3: Mở cổng kết nối => xảy ra ngoại lệ => ném vào try-catch
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps= con.prepareStatement(sql)) {
            //set dấu ?
            ps.setObject(1,maGV);
            //B4: Select => trả về 1 bảng ResultSet (1 dòng/ nhiều dòng) => execute Query
            ResultSet rs= ps.executeQuery();
            if (rs.next()){//kiểm tra xem còn có dòng nào kok??
                //B5: Tạo đối tượng GV mới
                GiangVien gv= new GiangVien();
                gv.setMaGV(rs.getString(1));
                gv.setTen(rs.getString(2));
                gv.setLoai(rs.getString(3));
                gv.setTuoi(rs.getInt(4));
                gv.setBac(rs.getInt(5));
                gv.setGioiTinh(rs.getBoolean(6));
                //B6: return luôn
                return gv;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        GiangVienRepository rep= new GiangVienRepository();
        List<GiangVien> list= rep.getAll();
        for (GiangVien giangVien : list) {
            System.out.println(giangVien.toString());
        }
        GiangVien gv= rep.getOne("HangNT169");
        System.out.println("GetOne: "+gv.toString());
    }
    /*
    BTVN
    làm nốt phần thêm, sửa, xóa
    JSP- Servlet -> như mọi khi (detail đẩy lên form)
     */
}
