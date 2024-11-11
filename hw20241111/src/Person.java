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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fName, person.fName) &&
                Objects.equals(lName, person.lName) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, lName, email);
    }
}
