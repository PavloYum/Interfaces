package interfaces.hw20241028.interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void sortBy(Comparator<Product> comparator) {
        products.sort(comparator);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
//