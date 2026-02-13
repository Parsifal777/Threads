import Potoki.firstzadanie.FirstPorok;
import Potoki.firstzadanie.SecondPotok;
import Potoki.secondzadanie.InterruptibleThread;

public class Main {
    public static void main(String[] args) {
        FirstPorok firstTask = new FirstPorok();
        Thread thread1 = new Thread(firstTask, "Поток-1");

        SecondPotok secondTask = new SecondPotok();
        Thread thread2 = new Thread(secondTask, "Поток-2");
        try {
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Все потоки завершили выполнение!");


//        InterruptibleThread thread = new InterruptibleThread();
//        thread.start();
//        try {
//            Thread.sleep(3000);
//            System.out.println("Главный поток: Прерываю дочерний поток...");
//            thread.interrupt();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Главный поток завершен.");
    }
}
