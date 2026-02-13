package Potoki.fivezadanie;

public class DownloadThread extends Thread {
    private FileInfo fileInfo;

    public DownloadThread(FileInfo fileInfo) {
        super("Загрузчик");
        this.fileInfo = fileInfo;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": Начало загрузки...");

        while (!fileInfo.isCompleted() && !isInterrupted()) {
            try {
                Thread.sleep(1000);
                fileInfo.increaseProgress();
                System.out.println(getName() + ": Прогресс " + fileInfo.getProgress() + "%");
            } catch (InterruptedException e) {
                System.out.println(getName() + ": Загрузка прервана!");
                break;
            }
        }

        if (fileInfo.isCompleted()) {
            System.out.println(getName() + ": Загрузка завершена!");
        }
    }
}