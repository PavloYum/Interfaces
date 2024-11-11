class BankAccount {
    Person owner;
    String IBAN;
    double balance;

    public BankAccount(Person owner, String IBAN, double balance) {
        this.owner = owner;
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public java.lang.String toString() {
        return "BankAccount{" +
                "owner=" + owner +
                ", IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.balance, balance) == 0 &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(IBAN, that.IBAN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, IBAN, balance);
}



