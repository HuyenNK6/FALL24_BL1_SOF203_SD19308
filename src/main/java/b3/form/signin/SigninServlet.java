package b3.form.signin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "signinServlet", value = {"/signin","/ket-qua-sign-in"})
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/b3/form-signin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy dữ liệu từ JSP
        String hoTen= req.getParameter("hoVaTen");
        String ngaySinh= req.getParameter("ngaySinh");
        LocalDate dateOfBirth= LocalDate.parse(ngaySinh);
        String sdt= req.getParameter("sdt");
        String gioiTinh= req.getParameter("gioiTinh");
        String diaChi= req.getParameter("diaChi");
        String quocGia= req.getParameter("quocGia");
        String[] monHocs= req.getParameterValues("monHoc");
        String[] soThiches= req.getParameterValues("soThich");

        //set attribute => gửi sang ket-qua-signin.jsp
        req.setAttribute("hoTen",hoTen);
        req.setAttribute("dateOfBirth",dateOfBirth);
        req.setAttribute("sdt",sdt);
        req.setAttribute("gioiTinh",gioiTinh);
        req.setAttribute("diaChi",diaChi);
        req.setAttribute("quocGia",quocGia);
        req.setAttribute("monHocs",monHocs);
        req.setAttribute("soThiches",soThiches);

        //file => ai muốn 9/10 điểm tự làm nhé ahihi :))

        req.getRequestDispatcher("/b3/ket-qua-signin.jsp").forward(req,resp);
    }
}
