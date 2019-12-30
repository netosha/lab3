
import java.lang.Thread;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Bredlam> bredlams = utils.generateBredlams();

        while (true) {
            Thread.sleep(500);
        }
    }
}
