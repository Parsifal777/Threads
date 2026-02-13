package Potoki.fourzadanie;

import java.util.Random;

public class SharedData {
    private int number;
    private boolean isProduced = false;

    public synchronized void produce() {
        try {
            while (isProduced) {
                wait();
            }

            Random random = new Random();
            number = random.nextInt(100) + 1; // Случайное число от 1 до 100
            System.out.println("MyThread1 (Продуцент): Сгенерировано число " + number);

            isProduced = true;
            notify(); // Уведомляем потребителя

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume() {
        try {
            while (!isProduced) {
                wait();
            }

            System.out.println("MyThread2 (Потребитель): Получено число " + number);

            isProduced = false;
            notify(); // Уведомляем производителя

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
