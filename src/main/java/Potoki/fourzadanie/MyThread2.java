package Potoki.fourzadanie;

public class MyThread2 extends Thread {
    private SharedData sharedData;

    public MyThread2(SharedData sharedData) {
        super("Consumer-Thread");
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": Запуск потребителя");

        for (int i = 0; i < 5; i++) {
            sharedData.consume();
        }

        System.out.println(getName() + ": Потребитель завершил работу");
    }
}
