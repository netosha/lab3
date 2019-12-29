import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class utils {
    public static List<Bredlam> generateBredlams() {
        List<Bredlam> bredlams = new ArrayList<>();
        // Создаем бредламы
        // На каждый бредлам будет приходится по 2 фабрики

        for(Products product:Products.values()){
            Random random = new Random();
            Fabrique[] fabs = new Fabrique[2];

            for(int i=0; i<2; i++) {
                Capitalist cap = new Capitalist("Cap" + String.valueOf(product), 5000000 + random.nextInt(50000));
                Worker[] workers = new Worker[20];
                for (int j = 0; j < 10; j++) {
                    workers[j] = new Worker("Worker" + String.valueOf(j), random.nextInt(500));
                }
                Fabrique fab = new Fabrique(product, cap, workers);
                fabs[i] = fab;
            }

            bredlams.add(new Bredlam(fabs));
        }

        for(Bredlam bredlam:bredlams){
            System.out.println(bredlam.toString());
        }

        return bredlams;
    }
}
