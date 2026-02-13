package Potoki.fivezadanie;

public class FileInfo {
    private int progress = 0;
    private boolean completed = false;

    public synchronized void increaseProgress() {
        progress += 10;
        if (progress >= 100) {
            progress = 100;
            completed = true;
        }
    }

    public synchronized int getProgress() {
        return progress;
    }

    public synchronized boolean isCompleted() {
        return completed;
    }
}
