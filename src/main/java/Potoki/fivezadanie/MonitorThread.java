package Potoki.fivezadanie;

public class MonitorThread extends Thread {
    private FileInfo fileInfo;

    public MonitorThread(FileInfo fileInfo) {
        super("Монитор");
        this.fileInfo = fileInfo;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": Мониторинг запущен");

        while (!fileInfo.isCompleted() && !isInterrupted()) {
            try {
                Thread.sleep(2000);
                System.out.println(getName() + ": Текущий прогресс: " + fileInfo.getProgress() + "%");
            } catch (InterruptedException e) {
                System.out.println(getName() + ": Мониторинг прерван!");
                break;
            }
        }

        System.out.println(getName() + ": Финальный прогресс: " + fileInfo.getProgress() + "%");
        System.out.println(getName() + ": Мониторинг завершен");
    }
}
