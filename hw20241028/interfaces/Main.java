package interfaces.hw20241028.interfaces;

import java.util.Comparator;
import java.util.Scanner;
//
public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        // Добавление товаров в каталог
        catalog.addProduct(new Product("Laptop", 1200.99, 4.5, 10));
        catalog.addProduct(new Product("Smartphone", 799.49, 4.7, 25));
        catalog.addProduct(new Product("Headphones", 199.99, 4.3, 50));
        catalog.addProduct(new Product("Keyboard", 49.99, 4.0, 80));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите способ сортировки:");
        System.out.println("1 - по цене по возрастанию");
        System.out.println("2 - по цене по убыванию");
        System.out.println("3 - по рейтингу");
        System.out.println("4 - по количеству на складе");

        int choice = scanner.nextInt();
        Comparator<Product> comparator;

        switch (choice) {
            case 1:
                comparator = new PriceAscendingComparator();
                break;
            case 2:
                comparator = new PriceDescendingComparator();
                break;
            case 3:
                comparator = new RatingDescendingComparator();
                break;
            case 4:
                comparator = new StockDescendingComparator();
                break;
            default:
                System.out.println("Неправильный выбор. Сортировка по умолчанию: по цене по возрастанию.");
                comparator = new PriceAscendingComparator();
                break;
        }

        catalog.sortBy(comparator);
        catalog.displayProducts();
    }
}
