import java.util.ArrayList;
import java.util.List;


public class Bredlam {
    private List<Fabrique> fabriques;
    private Products product;

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

    public List<Worker> getWorekrs(){
        List<Worker> workers = new ArrayList<>();
        for(Fabrique fab:this.fabriques){
            workers.addAll(fab.getWorkers());
        }
        return workers;
    }
    
    public Products getProduct(){
        return this.product;
    }

    public List<Fabrique> getFabriques(){
        return this.fabriques;
    }   

    @Override
    public String toString() {
        return "Ебучий "+this.fabriques.get(0).productType+" бредлам с "+fabriques.size()+" фабриками";
    }
}