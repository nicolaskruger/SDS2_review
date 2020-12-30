package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import db.DB;
import entities.Order;
import entities.Product;

public class Program {

    public static void main(String[] args) throws SQLException {

        Connection conn = DB.getConnection();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select * from tb_product");

        ResultSet res = st.executeQuery("select * from tb_order");

        ResultSet resu = st.executeQuery("SELECT * FROM tb_order " +
                "INNER JOIN tb_order_product ON tb_order.id = tb_order_product.order_id " +
                "INNER JOIN tb_product ON tb_product.id = tb_order_product.product_id");

        while (rs.next()) {
            Product p = Product.Query(rs);
            System.out.println(p);
        }
        while (res.next()){
            Order o = Order.Query(res);
            System.out.println(o);
        }
        Map<Long,Order> map = new HashMap<>();
        while (resu.next()){
            Long id = resu.getLong("order_id");
            if(!map.containsKey(id)){
                map.put(id,Order.QueryJoin(resu));
            }
            map.get(id).addProduct(Product.QueryJoin(resu));

        }
        map.forEach((k,s)->{
            System.out.println(s);
        });


    }
}
