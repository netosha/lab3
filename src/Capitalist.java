
public class Capitalist extends Person implements Payable{

    public Capitalist(String name, float balance){
        super(name, balance);
    }

  

    @Override
    public String toString() {
        return "Капиталист "+this.name+" с состоянием "+this.balance+" тугриков";
    }

    @Override
    public void charge(float amount) {
        // Для штрафа, например, тупо списывает бабки
        this.balance -= amount;
    }

    @Override
    public void income(float amount) {
        this.balance += amount;
    }
}


