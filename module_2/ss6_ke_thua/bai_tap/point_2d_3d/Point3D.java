package ss6_ke_thua.bai_tap.point_2d_3d;

public class Point3D extends Point2D {
    public float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] xyz = {super.getX(), super.getY(), z};
        return xyz;
    }

    @Override
    public String toString() {
        return "Point3D{" + "x=" + super.getX() + ", y=" + super.getY() + ", z=" + z + '}';
    }
}
