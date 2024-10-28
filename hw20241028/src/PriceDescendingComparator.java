package interfaces.hw20241028.interfaces;

import java.util.Comparator;

// Компаратор для сортировки по цене по убыванию
class PriceDescendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p2.getPrice(), p1.getPrice());
    }
}
//