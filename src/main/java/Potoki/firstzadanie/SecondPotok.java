package Potoki.firstzadanie;

public class SecondPotok implements Runnable {

    @Override
    public void run() {
        for(int i =0; i < 5; i++) {
            System.out.println("Поток #2: Выполнение...");
            try {
                Thread.sleep(2000); // Пауза в 2 секунды (2000 миллисекунд)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
