package ML.Kmeans.Kmeans;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by xwz on 3/2/17.
 *
 * Point: 点坐标
 */

public class Point {
    private ArrayList<Double> x; //X坐标
    private double y; //Y坐标
    //private double[] weight;
    private int id;
    private boolean beyond;//标识是否属于样本

    //构造函数
    public Point(int id, ArrayList x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.beyond = true;
    }

    public Point(int id, ArrayList x, double y, boolean beyond) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.beyond = beyond;
    }

    public ArrayList getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public boolean isBeyond() {
        return beyond;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (point.x.equals(x) && (Double.compare(point.y, y) != 0)) return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = x.indexOf(0);
        result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
