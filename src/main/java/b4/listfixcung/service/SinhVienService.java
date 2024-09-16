package b4.listfixcung.service;

import b4.listfixcung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> listSV= new ArrayList<>();

    //chèn constructor ko tham số
    //click chuột phải -> generate -> Constructor=> select none


    public SinhVienService() {//ctrl+D
        listSV.add(new SinhVien("1230","Hằng", 17, false, "HN"));
        listSV.add(new SinhVien("1234","Ngân", 17, false, "HN"));
        listSV.add(new SinhVien("1235","Phong", 27, true, "HN"));
        listSV.add(new SinhVien("1236","Nguyên", 27, true, "HN"));
        listSV.add(new SinhVien("1237","Tiến", 37, true, "HN"));
        listSV.add(new SinhVien("1238","Dũng", 37, true, "HN"));
        listSV.add(new SinhVien("1239","Khánh", 37, true, "HN"));
    }
    public List<SinhVien> getAll(){
        return listSV;
    }
    public void addSinhVien(SinhVien sv){
        listSV.add(sv);
    }
}
