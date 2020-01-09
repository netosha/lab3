
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Main {

    public static Capitalist createCapitatlist(){

        Random random = new Random();

        List<String> names = Arrays.asList("Спрутс", "Мебельный гигант", "Серужан", "Господин Дуб", "Шишкин", "Ержан");

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


    public static void main(String[] args) {
        Random random = new Random();
        // Объеденяемся в сообщества
        List<Bredlam> bredlams = new ArrayList<>();
        for(Products product:Products.values()){
            Bredlam bredlam = new Bredlam(product, createFabriques(product, 1));
            bredlams.add(bredlam);
        }

        // Собираем всех капиталистов
        List<Capitalist> capitalists = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();
        List<Fabrique> fabriques = new ArrayList<>();

        for(Bredlam bredlam:bredlams){
            List<Capitalist> capitalistsInBredlam = bredlam.getCapitalists();
            workers.addAll(bredlam.getWorekrs());
            fabriques.addAll(bredlam.getFabriques());
            for(Capitalist cap:capitalistsInBredlam){
                System.out.println(cap.toString()+" прибыл на встречу.");
            }
            capitalists.addAll(capitalistsInBredlam);
        }
        

        // Договариваемся какую плату платить рабочим и почем продавать товар
        float totalPayout = 0;
        
        for(Capitalist capitalist:capitalists) {
            // Скидываемся в общак для общей зарплаты
            float payoutRatio = (float) (0.02 + random.nextFloat() * (0.15 - 0.02));
            float payoutAmount = capitalist.balance * payoutRatio;
            capitalist.charge(payoutAmount);
            System.out.println(capitalist+" скинулся в общак "+payoutAmount);
            totalPayout += payoutAmount;
            
        }
        
        {
            float sugarPrice = (float) (30 + random.nextFloat() * 20); // От 30 до 50 рублей (30 + [0;1)*20 ) Коэф 1
            float breadPrice =(float) (20 + random.nextFloat() * 10); // От 20 до 30 рублей (20 + [0;1)*10 )
            float cheesePrice = (float) (100 + random.nextFloat() * 100); // От 100 до 200 рублей (100 + [0;1)*100 )
            float leatherPrice = (float) (500 + random.nextFloat() * 1000); // От 500 до 1500 рублей (500 + [0;1)*1000 )
            float coalPrice = (float) (100 + random.nextFloat() * 300); // От 100 до 400 рублей (100 + [0;1)*300 )
        }


        // Устанавливаем зарплату рабочим
        for(Bredlam bredlam:bredlams){
            bredlam.setPayoutPrice(totalPayout/workers.size());
            float sellPrice = 10+random.nextInt(40);
            bredlam.setSellPrice(sellPrice);
            System.out.println("Капиталисты установили цену в "+sellPrice+" тугриков на "+bredlam.getProduct());
        }

        System.out.println("Капиталисты установили зарплату в "+totalPayout/workers.size());

        // Рабочие работают
        for(Bredlam bredlam:bredlams){
            for (Fabrique fabrique:bredlam.getFabriques()){
                workers = fabrique.getWorkers();
                for(Worker worker:workers){
                    worker.work(fabrique); // Сначала работает
                    Fabrique toBuyFabrique = fabriques.get(random.nextInt(fabriques.size()));   // Выбираем фабрику, на которой купить продукт
                    worker.buyProduct(toBuyFabrique);       // Покупае продукт
                }
            }
        }

        /*Worker w1 = new Worker("Вей талик", (float) 200);
        Worker w2 = new Worker("Вей талик", (float) 200);
        Integer a = new Integer(5);
        Integer b = new Integer(5);
        System.out.println(w2.equals(w1));*/

    }
}
