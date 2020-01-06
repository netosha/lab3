
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Main {

    public static Capitalist createCapitatlist(){

        Random random = new Random();

        List<String> names = Arrays.asList("Спрутс", "Мебельный гигант", "Серега", "Господин Дуб", "Шишкин");

        // Создаем капиталиста с рандомным балансом
        Capitalist cap = new Capitalist(names.get(random.nextInt(names.size())), 5000000 + random.nextInt(50000));
        return cap;
    }

    public static List<Worker> createWorkers(int count){
        Random random = new Random();
        List<String> randomNames = Arrays.asList("Витя", "Паша", "Серега", "Виталик", "Генна", "Сева", "Никита");
        List<Worker> workers = new ArrayList<>();
        for(int i=0; i<count; i++){
            Worker worker = new Worker(randomNames.get(random.nextInt(randomNames.size())), 100 + random.nextInt(200));
            workers.add(worker);
        }
        return workers;
    }

    public static List<Fabrique> createFabriques(Products product, int count){
        List<Fabrique> fabriques = new ArrayList<>();

        for(int i=0; i<count; i++){
            Fabrique fab = new Fabrique(product, createCapitatlist(), createWorkers(5));
            fabriques.add(fab);
        }
        
        
        return fabriques;
    }


    public static void main(String[] args) throws InterruptedException {
        List<Bredlam> bredlams = new ArrayList<>();
        for(Products product:Products.values()){
            Bredlam bredlam = new Bredlam(product, createFabriques(product, 2));
            bredlams.add(bredlam);
        }

        for(Bredlam bredlam:bredlams){
            System.out.println(bredlam.toString());
        }

        
    }
}
