import java.util.Random;

public class Worker extends Person implements Payable, Disapointable{
    static Random random = new Random();

    public Worker(String name, float balance) {
        super(name, balance, 40 + random.nextInt(30));
    }

    public void addDisappointment(int disappointment){
        if(this.disappointment >= 100){
            this.disappointment += 100;
        } else if (this.disappointment <= 0) {
            this.disappointment += 0;
        } else {
            this.disappointment += disappointment;
        }
        if (disappointment > 0){
            System.out.println("Рабочий "+super.name + " повысил уровень злобы до "+this.disappointment);

        }else{
            System.out.println("Рабочий "+super.name + " понизил уровень злобы до "+this.disappointment);
        }
    }

    public void work(Fabrique fabrique){
        fabrique.makeProduct();
        this.addDisappointment(2);
        System.out.println("Рабочий "+super.name + " работает на фабрике  "+fabrique.productType);
    }

	@Override
    public void charge(float amount) {
        // Для штрафа, например, тупо списывает бабки
        this.balance -= amount;
        System.out.println("У рабочего "+super.name + " списались бабки в размере "+amount);

    }

    @Override
    public void income(float amount) {
        this.balance += amount;
        System.out.println("Рабочему "+super.name + " прилетели бабки в размере "+amount);

    }

    @Override
    public void buyProduct(Fabrique fabrique) {
        // (!!! Тут можно добавить эксепшон, если не совпадает продукт на фабрике и тот, который хочет купить человек)
        this.charge(fabrique.getSellPrice());
        this.addDisappointment(5);
        System.out.println("Рабочий  "+super.name + " купил "+fabrique.getProductType());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        if (!super.equals(o))
            return false;
        Worker worker = (Worker) o;
        return (Float.compare(worker.balance, balance) == 0) && (name.equals(worker.name)) && Float.compare(worker.disappointment, disappointment) == 0;
    }
}
