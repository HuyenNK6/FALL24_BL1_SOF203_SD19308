package b11.product.repository;

import b11.product.entity.Category;
import b11.product.entity.Product;
import b11.product.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository {
    public ArrayList<Product> getAll(){
        ArrayList<Product> listProducts= new ArrayList<>();
        String sql = "SELECT dbo.product.id, dbo.product.product_code, dbo.product.product_name, dbo.product.price, dbo.product.description, dbo.product.category_id, dbo.category.category_code, dbo.category.category_name\n" +
                "FROM     dbo.category INNER JOIN\n" +
                "                  dbo.product ON dbo.category.id = dbo.product.category_id";
        try(Connection con = DBConnect.getConnection();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                //tạo đối tượng category
                Category category= new Category();
                category.setId(rs.getInt(6));
                category.setCode(rs.getString(7));
                category.setName(rs.getString(8));
                //tạo đối tượng product
                Product product= new Product();
                product.setId(rs.getInt(1));
                product.setCode(rs.getString(2));
                product.setName(rs.getString(3));
                product.setPrice(rs.getFloat(4));
                product.setDescription(rs.getString(5));
                product.setCategory(category);

                listProducts.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listProducts;
    }
    //lấy toàn bộ danh sách category
    public ArrayList<Category> getAllCategory(){
        ArrayList<Category> listCategorys= new ArrayList<>();
        String sql = "SELECT id, category_code, category_name\n" +
                "FROM     dbo.category";
        try(Connection con = DBConnect.getConnection();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                //tạo đối tượng category
                Category category= new Category();
                category.setId(rs.getInt(1));
                category.setCode(rs.getString(2));
                category.setName(rs.getString(3));

                listCategorys.add(category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listCategorys;
    }

    public static void main(String[] args) {
        ProductRepository rep= new ProductRepository();
        ArrayList<Product> list= rep.getAll();
        for (Product product : list) {
            System.out.println(product.toString());
        }
        ArrayList<Category> listCate= rep.getAllCategory();
        for (Category category : listCate) {
            System.out.println(category.toString());
        }
    }
}
