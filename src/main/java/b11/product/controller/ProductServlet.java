package b11.product.controller;

import b11.product.entity.Product;
import b11.product.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "producServlet", value = {"/san-pham/hien-thi",
                                                "/san-pham/detail",
                                                "/san-pham/delete",
                                                "/san-pham/view-update",
                                                "/san-pham/update",
                                                "/san-pham/view-add",
                                                "/san-pham/add",
                                                "/san-pham/search"
})
public class ProductServlet extends HttpServlet {
    ProductRepository repository= new ProductRepository();
    List<Product> listProducts= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("hien-thi")){
            this.getAll(req,resp);
        }

    }
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listProducts= repository.getAll();
        req.setAttribute("listProducts",listProducts);
        req.getRequestDispatcher("/b11/hien-thi.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
