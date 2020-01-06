public class Worker extends Person {
    private float disappointment = 50;

    public Worker(String name, float balance){
        super(name, balance);
    }
    
    public void addDisappointment(int disappointment){
        if(this.disappointment >= 100){
            this.disappointment = 100;
        } else if (this.disappointment <= 0) {
            this.disappointment = 0;
        } else {
            this.disappointment += disappointment;
        }
        System.out.println("Рабочий "+super.name + " разозлился");
        // System.out.println(String.format("Рабочий %s разозлился до %i", {super.name, super}));

    }
}
