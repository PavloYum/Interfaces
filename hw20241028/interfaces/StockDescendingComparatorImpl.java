package interfaces.hw20241028.interfaces;

import java.util.Comparator;

// Компаратор для сортировки по количеству на складе по убыванию
class StockDescendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p2.getStock(), p1.getStock());
    }
}
//