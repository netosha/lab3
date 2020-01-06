public abstract class Person implements Payable {
    protected float balance;
    protected String name;
    private int disappointment;
    Person(String name, Float balance){
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void buy(Fabrique fabrique) {
        fabrique.sellProduct();
        this.balance -= fabrique.getSellPrice();
    }

    void getMoney(float amount){
        this.balance += amount;
    }

}
