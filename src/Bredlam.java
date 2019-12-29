public class Bredlam {
    private Fabrique[] fabriques;

    Bredlam(Fabrique[] fabriques){
        this.fabriques = fabriques;
    }

    public void setMaxPayoutPrice(float price){
        for(Fabrique f : this.fabriques){
            f.setMaxPayout(price);
        }
    }

    public void setSellPrice(float price){
        for(Fabrique f : this.fabriques){
            f.setSellPrice(price);
        }
    }

    @Override
    public String toString() {
        return "Ебучий "+this.fabriques[0].productType+" бредлам с "+fabriques.length+" фабриками";
    }
}