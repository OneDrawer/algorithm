package ML.Kmeans.Kmeans;

/**
 * Created by xwz on 3/2/17.
 *
 * 抽象的距离，可以具体实现为欧式，曼式或其他距离公式
 */
public abstract class AbstractDistance {

    abstract public double getDis(Point p1, Point p2);

}
