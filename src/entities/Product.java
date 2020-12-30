package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private long id;
    private String name;
    private double price;
    private String description;
    private String imageUri;

    public static Product Query(ResultSet  rs) throws SQLException {
        return new Product(rs.getLong("Id"),
                rs.getString("Name"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getString("image_uri"));
    }
    public static Product QueryJoin(ResultSet  rs) throws SQLException {
        return new Product(rs.getLong("product_id"),
                rs.getString("Name"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getString("image_uri"));
    }
    public Product(long id, String name, double price, String description, String imageUri) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getImageUri(){
        return imageUri;
    }
    public void setImageUri(){
        this.imageUri = imageUri;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
