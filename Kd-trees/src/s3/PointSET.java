/****************************************************************************
 *  Compilation:  javac s3.PointSET.java
 *  Execution:
 *  Dependencies:
 *  Author:
 *  Date:
 *
 *  Data structure for maintaining a set of 2-D points,
 *    including rectangle and nearest-neighbor queries
 *
 *************************************************************************/

package s3;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;


public class PointSET {
    // construct an empty set of points TODO: setja í method?
    public SET<Point2D> points;

    public PointSET() {
        points = new SET<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty() { return points.isEmpty(); }

    // number of points in the set
    public int size() { return points.size(); }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (!contains(p)) {
            points.add(p);
        }
        else{
            System.out.println("Point already exists"); //TODO: taka út
        }
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return points.contains(p);
    }

    // draw all of the points to standard draw
    public void draw() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (Point2D key: points){
            StdDraw.point(key.x(), key.y());
        }
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        return null;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        return p;
    }

    public static void main(String[] args) {
        PointSET set = new PointSET();
        System.out.println(set.isEmpty());
        Point2D point1 = new Point2D(0.112, 0.334);
        Point2D point2 = new Point2D(0.13, 0.134);
        set.insert(point1);
        System.out.println(set.isEmpty());
        System.out.println(set.contains(point1));
        set.insert(point1);
        set.insert(point2);
        System.out.println(set.size());
        set.draw();
    }

}
