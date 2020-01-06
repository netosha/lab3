import java.util.List;

public class Fabrique {
    private float payoutCoef = (float) 0.5; // Коэфициент выплаты рабочим от каждой продажи
    final float BASE_PRODUCT_PRICE_COEF = (float) 0.1; // Процент от sellPrice, который идет на закупку товара
    public Products productType;
    public Capitalist owner;
    public List<Worker> workers;
    private int productCount;
    private float sellPrice; // Цена, по которой продается productType

    Fabrique(Products productType, Capitalist owner, List<Worker> workers){
        this.productType = productType;
        this.owner = owner;
        this.workers = workers;
    }

    public Products getProductType() {
        return this.productType;
    }

    public void sellProduct(){
        this.productCount -= 1;


        // Когда продаем продукт,
        // то часть от выручки отдаем рабочим,
        // часть списываем на избытки
        // а остальное отдаем владельцу фабрики

        // Отдаем часть денег от продажи рабочим
        float payoutToWorkers = this.sellPrice * this.payoutCoef;
        for(Worker worker:this.workers){
            worker.getMoney(payoutToWorkers / this.workers.size());
        }

        // Выплата владельцу = Цена продажи - выплата работникам - себестоимость
        owner.getMoney(this.sellPrice - payoutToWorkers - (this.sellPrice * this.BASE_PRODUCT_PRICE_COEF));

    }

    public void setPayoutCoef(float coef){
        this.payoutCoef = coef;
    }

    public void setSellPrice(float sellPrice){
        if(sellPrice < 0) {
            this.sellPrice = 0;
        } else {
            this.sellPrice = sellPrice;
        }
    }

    public float getSellPrice() {return this.sellPrice;}
}
