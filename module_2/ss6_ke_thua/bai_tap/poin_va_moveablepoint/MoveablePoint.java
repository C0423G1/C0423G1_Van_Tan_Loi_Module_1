package ss6_ke_thua.bai_tap.poin_va_moveablepoint;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] setSpeed(float x, float y, float xSpeed, float ySpeed) {
        float[] speed = {super.x, super.y, xSpeed, ySpeed};
        return speed;
    }

    public MoveablePoint getSpeed() {
        x += xSpeed;
        y += ySpeed;
        return this;
    }

    public String toString() {
        return "MoveablePoint{" + "xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + ", x=" + x + ", y=" + y + '}';
    }
}
