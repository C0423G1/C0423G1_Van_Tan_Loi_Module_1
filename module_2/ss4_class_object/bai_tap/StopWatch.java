package ss4_class_object.bai_tap;

public class StopWatch {
    private long a, b;

    public StopWatch() {
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public long getStartTime() {
        long mili = System.currentTimeMillis();
        this.a = mili;
        return this.a;
    }

    public long getEndTime() {
        long mili = System.currentTimeMillis();
        this.b = mili;
        return this.b;
    }

    public long getElapsedTime() {
        return this.b - this.a;
    }
}
