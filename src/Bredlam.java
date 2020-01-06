import java.util.List;


public class Bredlam {
    public List<Fabrique> fabriques;
    public Products product;

    Bredlam(Products product, List<Fabrique> fabriques) {
        this.fabriques = fabriques;
        this.product = product;
    }

    public void setSellPrice(float price) {
        // Устанавливаем цену на продукцию.
        for(Fabrique f : this.fabriques) {
            f.setSellPrice(price);
        }
    }

    @Override
    public String toString() {
        return "Ебучий "+this.fabriques.get(0).productType+" бредлам с "+fabriques.size()+" фабриками";
    }
}