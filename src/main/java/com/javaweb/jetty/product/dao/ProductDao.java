package com.javaweb.jetty.product.dao;

import com.javaweb.jetty.product.common.ConnectionUtility;
import com.javaweb.jetty.product.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    String saveSQL="INSERT INTO product (name,model,factory) values (?,?,?)";
    String updateSQL="UPDATE  product set name=?, model=?,factory=? WHERE id=?";
    String deleteSQL="DELETE FROM product WHERE id=?";
    String selectAllSQL="SELECT * FROM product";
    String findSQL="SELECT * FROM product WHERE id=?";

    public void save(Product product){

        try {
            Connection cn = ConnectionUtility.getConnection();
            PreparedStatement ps=cn.prepareStatement(saveSQL);
            ps.setString(1,product.getName());
            ps.setString(2,product.getModel());
            ps.setString(3,product.getFactory());
            ps.executeUpdate();
            cn.commit();
            cn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Product product){

        try {
            Connection cn = ConnectionUtility.getConnection();
            PreparedStatement ps=cn.prepareStatement(updateSQL);
            ps.setString(1,product.getName());
            ps.setString(2,product.getModel());
            ps.setString(3,product.getFactory());
            ps.setInt(4,product.getId());
            ps.executeUpdate();
            cn.commit();
            cn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Product product){

        try {
            Connection cn = ConnectionUtility.getConnection();
            PreparedStatement ps=cn.prepareStatement(deleteSQL);
            ps.setInt(1,product.getId());
            ps.executeUpdate();
            cn.commit();
            cn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> selectAll(){
        List<Product> result = new ArrayList<Product>();
        try {
            Connection cn = ConnectionUtility.getConnection();
            PreparedStatement ps=cn.prepareStatement(selectAllSQL);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String model=rs.getString("model");
                String factory=rs.getString("factory");
                result.add(new Product(id,name,model,factory));
            }
            cn.commit();
            cn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Product findOne(Integer id){
        Product product=null;
        try {
            Connection cn = ConnectionUtility.getConnection();
            PreparedStatement ps=cn.prepareStatement(findSQL);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
               String name=rs.getString("name");
               String model=rs.getString("model");
               String factory=rs.getString("factory");
               product=new Product(id,name,model,factory);
            }
            cn.commit();
            cn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

}
