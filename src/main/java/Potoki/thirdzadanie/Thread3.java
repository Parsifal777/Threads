package Potoki.thirdzadanie;

public class Thread3 extends Thread {
    private Thread secondThread;

    public Thread3(Thread secondThread) {
        super("Thread3");
        this.secondThread = secondThread;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": Начало работы");
        System.out.println(getName() + ": Ожидаю завершение " + secondThread.getName() + " (таймаут 3 сек)...");

        try {
            long startTime = System.currentTimeMillis();
            secondThread.join(3000);
            long waitTime = System.currentTimeMillis() - startTime;

            System.out.println(getName() + ": Время ожидания: " + waitTime + " мс");

            if (secondThread.isAlive()) {
                System.out.println(getName() + ": ТАЙМАУТ! " + secondThread.getName() + " еще работает");
                System.out.println(getName() + ": Продолжаю выполнение без полного завершения");
            } else {
                System.out.println(getName() + ": " + secondThread.getName() + " успел завершиться");
            }

            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + ": Итерация " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + ": Прерван");
        }

        System.out.println(getName() + ": Завершение работы");
    }
}
