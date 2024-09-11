package b2.form.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//value = {"/login", "/ket-qua"}: Đây là một mảng các URL patterns mà servlet này sẽ xử lý.
// Khi người dùng truy cập vào một trong các URL này, servlet loginServlet sẽ được gọi để xử lý yêu cầu.
@WebServlet(name = "loginServlet", value = {"/login","/ket-qua"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message","FPOLY");

        req.getRequestDispatcher("/b2/form-login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //B1: lấy dữ liệu từ jsp về servlet
        String username = req.getParameter("usn");
        String password = req.getParameter("pw");

        //B2: Truyền dữ liệu từ servlet => jsp kết quả
        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.getRequestDispatcher("/b2/ket-qua-login.jsp").forward(req,resp);

    }
    //Cách hoạt động:
//Khi người dùng truy cập vào .../login,
// => phương thức doGet trong LoginServlet sẽ được gọi, và trang login sẽ được trả về.
//Khi người dùng truy cập vào .../ket-qua,
// => phương thức doGet cũng sẽ được gọi, nhưng lần này trang kết quả sẽ được trả về.
}
