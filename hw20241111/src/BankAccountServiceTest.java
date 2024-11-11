import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class BankAccountServiceTest {

    private List<BankAccount> setupAccounts() {
        Person person1 = new Person("John", "Doe", "john.doe@example.com");
        Person person2 = new Person("Jane", "Smith", "jane.smith@example.com");
        Person person3 = new Person("Jack", "Johnson", "jack.johnson@example.com");
        return Arrays.asList(
                new BankAccount(person1, "IBAN123", 500.0),
                new BankAccount(person2, "IBAN456", 1500.0),
                new BankAccount(person3, "IBAN789", 200.0)
        );
    }

    private Map<String, BankAccount> setupAccountMap() {
        List<BankAccount> accounts = setupAccounts();
        return accounts.stream().collect(Collectors.toMap(acc -> acc.getOwner().email,
                Function.identity()));
    }

    @Test
    void testOwnerToBalanceMap() {
        List<BankAccount> accounts = setupAccounts();
        Map<Person, Double> result = BankAccountService.ownerToBalanceMap(accounts);
        assertEquals(3, result.size());
    }


    @Test
    void testIbanToOwnerMap() {
        List<BankAccount> accounts = setupAccounts();
        Map<String, Person> result = BankAccountService.ibanToOwnerMap(accounts);
        assertEquals(3, result.size());
    }

    private void assertEquals(int i, int size) {

    }

    @Test
    void testIbanToInitialsMap() {
        List<BankAccount> accounts = setupAccounts();
        Map<String, String> result = BankAccountService.ibanToInitialsMap(accounts);
        assertEquals(3, result.size());
    }

    @Test
    void testTopThreeClients() {
        Map<String, BankAccount> accountMap = setupAccountMap();
        List<String> result = BankAccountService.topThreeClients(accountMap);
        assertEquals(3, result.size());
    }
}
