import java.util.ArrayList;
import java.util.List;


public class Bredlam {
    public List<Fabrique> fabriques;
    public Products product;

    Bredlam(Products product, List<Fabrique> fabriques) {
        this.fabriques = fabriques;
        this.product = product;
    }
    
    // Устанавливаем цену на продукцию.
    public void setSellPrice(float price) {
        for(Fabrique f : this.fabriques) {
            f.setSellPrice(price);
        }
    }

     // Устанавливаем зарплату.
     public void setPayoutPrice(float price) {
        for(Fabrique f : this.fabriques) {
            f.setPayoutPrice(price);
        }
    }

    public List<Capitalist> getCapitalists() {
        List<Capitalist> capitalists = new ArrayList<>();
        for(Fabrique fab:this.fabriques){
            capitalists.add(fab.owner);
        }
        return capitalists;
    }

    public int getWorekrsCount(){
        int count = 0;
        for(Fabrique fab:this.fabriques){
            count += fab.workers.size();
        }
        return count;
    }
    

    @Override
    public String toString() {
        return "Ебучий "+this.fabriques.get(0).productType+" бредлам с "+fabriques.size()+" фабриками";
    }
}