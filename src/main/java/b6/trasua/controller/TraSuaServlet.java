package b6.trasua.controller;

import b6.trasua.entity.TraSua;
import b6.trasua.service.TraSuaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "Hehe", value =
        {"/tra-sua/hien-thi",
        "/tra-sua/chi-tiet"})
public class TraSuaServlet extends HttpServlet {

    private TraSuaService service = new TraSuaService();
    private List<TraSua> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURI();
        if (url.contains("/hien-thi")) {
            this.getAll(req, resp);
        }else if (url.contains("/chi-tiet")) {
            this.detail(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if(action.equalsIgnoreCase("add")){
           this.addTS(req,resp);
       }

    }

    public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        list = service.getAll();

        req.setAttribute("listTraSua", list);

        req.getRequestDispatcher("/b6/hien-thi.jsp").forward(req, resp);
    }
    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma= req.getParameter("ma");
        TraSua ts= service.searchTSByMa(ma);
        req.setAttribute("ts",ts);

        list = service.getAll();
        req.setAttribute("listTraSua", list);

        req.getRequestDispatcher("/b6/hien-thi.jsp").forward(req, resp);
    }
    public void addTS(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //B1: lấy dữ liệu từ form trên jsp
        String ma= req.getParameter("ma");
        String vi= req.getParameter("vi");
        String gia= req.getParameter("gia");
        String size= req.getParameter("size");
        String thuongHieu= req.getParameter("thuongHieu");

        //B2: Tạo đối tượng TS mới
//        TraSua ts= new TraSua(ma,vi,
//                        Integer.valueOf(gia),
//                        size.charAt(0),
//                        thuongHieu
//                        );
        //sử dụng builder
        TraSua ts= TraSua.builder()
                .gia(Integer.valueOf(gia))
                .ma(ma)
                .vi(vi)
                .thuongHieu(thuongHieu)
                .size(size.charAt(0))
                .build();
        service.addTraSua(ts);
        list = service.getAll();
        req.setAttribute("ts", ts);
        req.setAttribute("listTraSua", list);
        req.getRequestDispatcher("/b6/hien-thi.jsp").forward(req, resp);
    }
}
