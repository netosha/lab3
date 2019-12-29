public class Fabrique {
    public Products productType;
    private Capitalist owner;
    private Worker[] workers;

    private float maxPayout; // Цена, которую устанавливают бредламы выплаты рабочим
    private float sellPrice; // Цена, по которой продается productType

    Fabrique(Products productType, Capitalist owner, Worker[] workers){
        this.productType = productType;
        this.owner = owner;
        this.workers = workers;
    }

    public void setMaxPayout(float maxPayout){
        this.maxPayout = maxPayout;
    }

    public void setSellPrice(float sellPrice){
        this.sellPrice = sellPrice;
    }
}
