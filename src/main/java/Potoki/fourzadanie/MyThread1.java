package Potoki.fourzadanie;

public class MyThread1 extends Thread {
    private SharedData sharedData;

    public MyThread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": Запуск продуцента");

        for (int i = 0; i < 5; i++) {
            sharedData.produce();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(getName() + ": Продуцент завершил работу");
    }
}
