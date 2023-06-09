package ss6_ke_thua.bai_tap.point_2d_3d;

public class Point2D {
    private float x;
    private float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] setXY() {
        return new float[]{x, y};
    }

    public String toString() {
        return "Point2D{" + "x=" + x + ", y=" + y + '}';
    }
}
