package Potoki.secondzadanie;

public class InterruptibleThread extends Thread {

    @Override
    public void run() {
        System.out.println("Поток запущен и будет выполняться каждую секунду..");

        while(!this.isInterrupted()) {
            try {
                System.out.println("Выполняюсь..");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
                this.interrupt();
                break;
            }
        }
        System.out.println("Завершение потока.");
    }
}
