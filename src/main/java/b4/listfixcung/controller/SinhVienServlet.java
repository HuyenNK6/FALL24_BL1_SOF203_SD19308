package b4.listfixcung.controller;

import b4.listfixcung.entity.SinhVien;
import b4.listfixcung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "sinhVienServlet",value = {
                                    "/sinh-vien/get-all",//GET
                                    "/sinh-vien/search",//GET
                                    "/sinh-vien/remove",//GET
                                    "/sinh-vien/detail",//GET
                                    "/sinh-vien/view-update",//GET
                                    "/sinh-vien/update",//POST
                                    "/sinh-vien/view-add",//GET
                                    "/sinh-vien/add"//POST
                                    })
public class SinhVienServlet extends HttpServlet {
    private SinhVienService service= new SinhVienService();
    private List<SinhVien> listSV= new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lấy URI từ đường đẫn
        //ví dụ: http://localhost:8080/sinh-vien/get-all
        //Phương thức getRequestURI() trả về một chuỗi (String) chứa URI của yêu cầu
        //=> kết quả là: /sinh-vien/get-all
        String uri= req.getRequestURI();
        if(uri.contains("get-all")){
            this.getAll(req,resp);//gọi đến get all
        }else if(uri.contains("search")){
            //gọi đến search
        }else if(uri.contains("remove")){
            //gọi đến remove
        }else if(uri.contains("detail")){
            //gọi đến detail
        }else if(uri.contains("view-update")){
            //gọi đến search
        }else if(uri.contains("view-add")){
            //gọi đến view-add
            this.viewAdd(req,resp);
        }else{
            //gọi đến get all
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("update")){
           //gọi đến update
        }else if(uri.contains("add")){
            //gọi đến add
            this.addStudent(req,resp);
        }

    }
    //Lấy toàn bộ danh sách từ service sang
    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listSV= service.getAll();
        req.setAttribute("listSV",listSV);
        req.getRequestDispatcher("/b4/sinh-vien.jsp").forward(req,resp);
    }
    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/b4/add-sinh-vien.jsp").forward(req,resp);
    }
    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //B1: lấy dữ liệu từ JSP
        String mssv= req.getParameter("mssv");
        String ten= req.getParameter("ten");
        String tuoi= req.getParameter("tuoi");
        String diaChi= req.getParameter("diaChi");
        String gioiTinh= req.getParameter("gioiTinh");
        //B2: Tạo đối tượng SV
        SinhVien sv= new SinhVien(mssv,ten,
                Integer.valueOf(tuoi),
                Boolean.valueOf(gioiTinh),
                diaChi
                );
        //B3: thêm đối tượng SV mới vào danh sách
        service.addSinhVien(sv);
        //B4: lấy lại danh sách để chuyển sang trang jsp
        listSV = service.getAll();
        req.setAttribute("listSV",listSV);
        req.getRequestDispatcher("/b4/sinh-vien.jsp").forward(req,resp);
    }

}
