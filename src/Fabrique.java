import java.util.List;
import java.util.Random;

public class Fabrique {
    public Products productType;
    public Capitalist owner;
    private List<Worker> workers;
    private int productCount=100;

    Random random = new Random();
    private float sellPrice = 20 + random.nextInt(20); // Цена, по которой продается productType
    private float payoutPrice;

    Fabrique(Products productType, Capitalist owner, List<Worker> workers){
        this.productType = productType;
        this.owner = owner;
        this.workers = workers;
    }

    public Products getProductType() {
        return this.productType;
    }

    public List<Worker> getWorkers(){
        return this.workers;
    }

    public void makeProduct(){
        this.productCount +=1;
    }

    public void sellProduct(){
        this.productCount -= 1;


        // Когда продаем продукт,
        // то часть от выручки отдаем рабочим,
        // часть списываем на избытки
        // а остальное отдаем владельцу фабрики

        // Отдаем часть денег от продажи рабочим
        for(Worker worker:this.workers){
            worker.income(this.payoutPrice);
        }

        // Выплата владельцу = Цена продажи - выплата работникам - себестоимость
        owner.income(this.sellPrice - payoutPrice);

    }

    public void setPayoutPrice(float price){
        this.payoutPrice = price;
    }

    public void setSellPrice(float sellPrice){
        this.sellPrice = sellPrice;
    }

    public float getSellPrice() {return this.sellPrice;}

    @Override
    public String toString() {
       
        return "Фабрика "+this.productType+", цена продукции которой "+this.sellPrice;
    }
}
