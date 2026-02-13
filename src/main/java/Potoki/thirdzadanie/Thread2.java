package Potoki.thirdzadanie;

public class Thread2 extends Thread {
    private Thread firstThread;

    public Thread2(Thread firstThread) {
        super("Thread2");
        this.firstThread = firstThread;
    }

    @Override
    public void run() {
        System.out.println("Поток 2: Начало работы");
        System.out.println("Поток 2: Ожидаю завершение Потока 1...");

        try {
            firstThread.join();
            System.out.println("Поток 2: Поток 1 завершен, продолжаю работу");

            for (int i = 1; i <= 3; i++) {
                System.out.println("Поток 2: Итерация " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток 2: Прерван");
        }

        System.out.println("Поток 2: Завершение работы");
    }
}
