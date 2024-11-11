class Person {
    String fName;
    String lName;
    String email;

    public Person(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
