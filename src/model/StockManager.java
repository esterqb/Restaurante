package model;

import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private static StockManager instance;
    private Map<String, Integer> stock;

    private StockManager() {
        stock = new HashMap<>();
        stock.put("Coca-Cola", 24);
        stock.put("Cola Zero", 24);
        stock.put("Fanta naranja", 24);
        stock.put("Fanta limon", 24);
        stock.put("Nestea", 24);
        stock.put("Agua 1,5l", 6);
        stock.put("Cerveza", 24);
        stock.put("Vino", 10);
    }

    public static StockManager getInstance() {
        if (instance == null) {
            instance = new StockManager();
        }
        return instance;
    }

    public int getStock(String bebida) {
        return stock.getOrDefault(bebida, 0);
    }

    public boolean restarStock(String bebida, int cantidad) {
        int actual = stock.getOrDefault(bebida, 0);
        if (actual >= cantidad) {
            stock.put(bebida, actual - cantidad);
            return true;
        }
        return false;
    }

    public void sumarStock(String bebida, int cantidad) {
        stock.put(bebida, stock.getOrDefault(bebida, 0) + cantidad);
    }
}
