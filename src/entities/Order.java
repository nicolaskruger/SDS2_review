package entities;

import javax.management.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private long id;
    private double latitude;
    private double longitude;
    private Instant moment;
    private OrderStatus status;

    public List<Product> getProduct() {
        return product;
    }



    private List<Product> product = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", moment=" + moment +
                ", status=" + status +
                ", product=" + product +
                '}';
    }

    public void addProduct(Product p){
        this.product.add(p);
    }
    public static Order Query(ResultSet rs) throws SQLException {
        return new Order(rs.getLong("id"),
                rs.getDouble("latitude"),
                rs.getDouble("longitude"),
                rs.getTimestamp("moment").toInstant(),
                OrderStatus.values()[rs.getInt("status")]);
    }
    public static Order QueryJoin(ResultSet rs) throws SQLException {
        return new Order(rs.getLong("order_id"),
                rs.getDouble("latitude"),
                rs.getDouble("longitude"),
                rs.getTimestamp("moment").toInstant(),
                OrderStatus.values()[rs.getInt("status")]);
    }

    public Order(long id, double latitude, double longitude, Instant moment, OrderStatus status) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
