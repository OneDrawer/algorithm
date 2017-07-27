package ML.Kmeans.Kmeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwz on 3/2/17.
 *
 * Cluster: 簇
 */
public class Cluster {

    private int id;//标识
    private Point center;//中心
    private List<Point> members = new ArrayList<Point>();//成员

    //构造函数
    public Cluster(int id, Point center) {
        this.id = id;
        this.center = center;
    }

    public Cluster(int id, Point center, List<Point> members) {
        this.id = id;
        this.center = center;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    // 获取簇的中心
    public Point getCenter() {
        return center;
    }

    //设置簇的中心
    public void setCenter(Point center) {
        this.center = center;
    }

    //获取簇的所有成员
    public List<Point> getMembers() {
        return members;
    }

    //簇增加新的样本点
    public void addPoint(Point newPoint) {
        if (!members.contains(newPoint))
            members.add(newPoint);
        else
            throw new IllegalStateException("试图处理同一个样本数据!");
    }

    @Override
    public String toString() {
        return "Cluster{" +
                "id=" + id +
                ", center=" + center +
                ", members=" + members +
                "}";
    }
}
