import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankAccountService {
    // map с owner в качестве ключа и balance в качестве значения
    public static Map<Person, Double> ownerToBalanceMap(List<BankAccount> accounts) {
        return accounts.stream()
                .collect(Collectors.toMap(
                        BankAccount::getOwner,
                        BankAccount::getBalance
                ));
    }

    // map с IBAN в качестве ключа и owner в качестве значения
    public static Map<String, Person> ibanToOwnerMap(List<BankAccount> accounts) {
        return accounts.stream()
                .collect(Collectors.toMap(
                        BankAccount::getIBAN,
                        BankAccount::getOwner
                ));
    }

    // map с IBAN в качестве ключа и сокращенной строкой J.Jack в качестве значения
    public static Map<String, String> ibanToInitialsMap(List<BankAccount> accounts) {
        return accounts.stream()
                .collect(Collectors.toMap(
                        BankAccount::getIBAN,
                        account -> account.getOwner().fName.charAt(0) + "." + account.getOwner().lName
                ));
    }
    // Метод для получения имен трех крупнейших клиентов
    public static List<String> topThreeClients(Map<String, BankAccount> accountMap) {
        return accountMap.values().stream()
                .sorted(Comparator.comparing(BankAccount::getBalance).reversed())
                .limit(3)
                .map(account -> account.getOwner().fName + " " + account.getOwner().lName)
                .collect(Collectors.toList());
    }
}
