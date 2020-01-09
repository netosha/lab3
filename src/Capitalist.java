
public class Capitalist extends Person implements Payable, Disapointable{

    public Capitalist(String name, float balance){
        super(name, balance, 10);
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

    @Override
    public void buyProduct(Fabrique fabrique) {
        // (!!! Тут можно добавить эксепшон, если не совпадает продукт на фабрике и тот, который хочет купить человек)
        this.charge(fabrique.getSellPrice());
        this.addDisappointment(-1);
        System.out.println("Капиталист  "+super.name + " купил "+fabrique.getProductType());
    }

    @Override
    public void addDisappointment(int disappointment){
        if(this.disappointment >= 100){
            this.disappointment += 100;
        } else if (this.disappointment <= 0) {
            this.disappointment += 0;
        } else {
            this.disappointment += disappointment;
        }
        if (disappointment > 0){
            System.out.println("Капиталист "+super.name + " повысил уровень злобы до "+this.disappointment);

        }else{
            System.out.println("Капиталист "+super.name + " понизил уровень злобы до "+this.disappointment);
        }

    }
}


