package entities;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
    PENDING, DELIVERED;
    private static Map map = new HashMap();
    static{
        for(OrderStatus o: OrderStatus.values()){
            map.put(o.hashCode(),o);
        }
    }
    public static OrderStatus valueOf(int i){
        return (OrderStatus) map.get(i);
    }
}
