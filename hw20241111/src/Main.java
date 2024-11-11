import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты Person
        Person person1 = new Person("John", "Doe", "john.doe@example.com");
        Person person2 = new Person("Jane", "Smith", "jane.smith@example.com");
        Person person3 = new Person("Jack", "Johnson", "jack.johnson@example.com");

        // Создаем объекты BankAccount
        List<BankAccount> accounts = List.of(
                new BankAccount(person1, "IBAN123", 500.0),
                new BankAccount(person2, "IBAN456", 1500.0),
                new BankAccount(person3, "IBAN789", 200.0)
        );

        // Map<Person, Double> - соответствие владельца и баланса
        Map<Person, Double> ownerToBalanceMap = BankAccountService.ownerToBalanceMap(accounts);
        System.out.println("Map: Owner to Balance:");
        ownerToBalanceMap.forEach((owner, balance) ->
                System.out.println(owner.fName + " " + owner.lName + " - Balance: " + balance)
        );

        // Map<String, Person> - соответствие IBAN и владельца
        Map<String, Person> ibanToOwnerMap = BankAccountService.ibanToOwnerMap(accounts);
        System.out.println("\nMap: IBAN to Owner:");
        ibanToOwnerMap.forEach((iban, owner) ->
                System.out.println("IBAN: " + iban + " - Owner: " + owner.fName + " " + owner.lName)
        );

        // Map<String, String> - соответствие IBAN и инициалов владельца
        Map<String, String> ibanToInitialsMap = BankAccountService.ibanToInitialsMap(accounts);
        System.out.println("\nMap: IBAN to Initials:");
        ibanToInitialsMap.forEach((iban, initials) ->
                System.out.println("IBAN: " + iban + " - Initials: " + initials)
        );

        // Map<String, BankAccount> для получения 3 крупнейших клиентов
        Map<String, BankAccount> accountMap = accounts.stream()
                .collect(Collectors.toMap(acc -> acc.getOwner().email, Function.identity()));

        // Получение 3 крупнейших клиентов
        List<String> topThreeClients = BankAccountService.topThreeClients(accountMap);
        System.out.println("\nTop 3 Clients by Balance:");
        topThreeClients.forEach(System.out::println);
    }
}
