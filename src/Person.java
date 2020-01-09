import java.util.Objects;

public class Person{
    protected float balance;
    protected String name;
    protected int disappointment;

    Person(String name, Float balance, int disappointment){
        this.name = name;
        this.balance = balance;
        this.disappointment = disappointment;
    }

    Person(String name, Float balance){
        this.name = name;
        this.balance = balance;
        this.disappointment = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name == person.name &&
                Float.compare(person.balance, balance) == 0 &&
                Objects.equals(name, person.name) && Float.compare(person.disappointment, disappointment) == 0;
    }
}
