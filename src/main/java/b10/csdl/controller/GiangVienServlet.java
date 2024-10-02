package b10.csdl.controller;

import b10.csdl.entity.GiangVien;
import b10.csdl.repository.GiangVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HIHI" ,value = "/giang-vien/get-all")
public class GiangVienServlet extends HttpServlet {
    private List<GiangVien> giangViens = new ArrayList<>();
    private GiangVienRepository repository = new GiangVienRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/get-all")){
            this.getAll(req,resp);
        }else if (uri.contains("/detail")){

        }else if (uri.contains("/delete")){

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("add")){
            this.add(req,resp);
        }
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        giangViens = repository.getAll();
        req.setAttribute("giangViens",giangViens);
        req.getRequestDispatcher("/b10/hien-thi.jsp").forward(req,resp);
    }
    @SneakyThrows
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//Cách 1: thông thường
        //        String ma = req.getParameter("maGV");
//        String ten = req.getParameter("ten");
//        String loai = req.getParameter("loai");
//        int tuoi =Integer.valueOf(req.getParameter("tuoi"));
//        int bac =Integer.valueOf(req.getParameter("bac"));
//        String gioiTinh = req.getParameter("gioiTinh");
//
//        GiangVien gv = GiangVien.builder()
//                .maGV(ma)
//                .ten(ten)
//                .loai(loai)
//                .tuoi(Integer.valueOf(tuoi))
//                .bac(Integer.valueOf(bac))
//                .gioiTinh(Boolean.valueOf(gioiTinh))
//                .build();
        //Cách 2: sử dụng BeanUtils
        GiangVien gv= new GiangVien();
        BeanUtils.populate(gv, req.getParameterMap());

        repository.add(gv);
        giangViens = repository.getAll();
        req.setAttribute("giangViens",giangViens);
        req.setAttribute("gv",gv);
        req.getRequestDispatcher("/b10/hien-thi.jsp").forward(req,resp);
    }


}
