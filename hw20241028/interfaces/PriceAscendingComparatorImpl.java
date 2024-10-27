package interfaces.hw20241028.interfaces;

import java.util.Comparator;
// Компаратор для сортировки по цене по возрастанию
class PriceAscendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }

}
//