import Potoki.firstzadanie.FirstPorok;
import Potoki.firstzadanie.SecondPotok;
import Potoki.fivezadanie.DownloadThread;
import Potoki.fivezadanie.FileInfo;
import Potoki.fivezadanie.MonitorThread;
import Potoki.fourzadanie.MyThread1;
import Potoki.fourzadanie.MyThread2;
import Potoki.fourzadanie.SharedData;
import Potoki.secondzadanie.InterruptibleThread;
import Potoki.thirdzadanie.Thread1;
import Potoki.thirdzadanie.Thread2;
import Potoki.thirdzadanie.Thread3;

public class Main {
    public static void main(String[] args) {
        //Zadanie1
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

        //Zadanie2
        InterruptibleThread thread = new InterruptibleThread();
        thread.start();
        try {
            Thread.sleep(3000);
            System.out.println("Главный поток: Прерываю дочерний поток...");
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Главный поток завершен.");

        //Zadanie3
        Thread1 thread11 = new Thread1();
        Thread2 thread21 = new Thread2(thread11);
        Thread3 thread31 = new Thread3(thread21);
        try {

            System.out.println("Главный поток: Запуск " + thread11.getName());
            thread11.start();

            Thread.sleep(1000);

            System.out.println("Главный поток: Запуск " + thread21.getName());
            thread21.start();

            Thread.sleep(1000);

            System.out.println("Главный поток: Запуск " + thread31.getName());

            thread31.start();
            thread11.join();
            thread21.join();
            thread31.join();

        } catch (InterruptedException e) {
            System.err.println("Главный поток: Прерван");
            e.printStackTrace();
        }

        System.out.println("\nВсе потоки завершены. Программа окончена");

        //Zadanie4
        SharedData sharedData = new SharedData();

        MyThread1 producer = new MyThread1(sharedData);
        MyThread2 consumer = new MyThread2(sharedData);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nПрограмма завершена");

        //Zadanie5
        FileInfo fileInfo = new FileInfo();

        DownloadThread downloader = new DownloadThread(fileInfo);
        MonitorThread monitor = new MonitorThread(fileInfo);

        downloader.start();
        monitor.start();

        try {
            downloader.join();
            monitor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }
}
