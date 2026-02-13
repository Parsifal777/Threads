package Potoki.thirdzadanie;

public class Thread1 extends Thread {
    public Thread1() {
        super("Thread1");
    }

    @Override
    public void run() {
        System.out.println("Поток 1: Начало работы");

        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Поток 1: Итерация " + i);
                Thread.sleep(500); // sleep() - задержка 0.5 секунды
            }
        } catch (InterruptedException e) {
            System.out.println("Поток 1: Прерван");
        }

        System.out.println("Поток 1: Завершение работы");
    }
}
