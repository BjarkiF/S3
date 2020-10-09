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

import java.util.ArrayList;


public class PointSET {
    public SET<Point2D> points;

    // construct an empty set of points
    public PointSET() { points = new SET<Point2D>(); }

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
        for (Point2D node: points){
            StdDraw.point(node.x(), node.y());
        }
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        SET<Point2D> pointsInRange = new SET<Point2D>();
        for (Point2D node: points){
            if (node.x() >= rect.xmin() && node.x() <= rect.xmax()){
                if (node.y() >= rect.ymin() && node.y() <= rect.ymax()){
                    pointsInRange.add(node);
                }
            }
        }
        return pointsInRange;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        if (points.isEmpty()){
            return null;
        }
        Point2D nearestNode = null;
        for (Point2D node: points){
            if (nearestNode == null){
                nearestNode = node;
            }
            else if (p.distanceTo(node) < p.distanceTo(nearestNode) && node != p){
                nearestNode = node;
            }
        }
        return nearestNode;
    }

    public static void main(String[] args) {
        PointSET set = new PointSET();
        Point2D point1 = new Point2D(0.112, 0.334);
        Point2D point2 = new Point2D(0.13, 0.134);
        Point2D point3 = new Point2D(0.712, 0.434);
        Point2D point4 = new Point2D(0.313, 0.834);
        Point2D point5 = new Point2D(0.912, 0.934);
        Point2D point6 = new Point2D(0.753, 0.134);
        set.insert(point1);
        set.insert(point2);
        set.insert(point3);
        set.insert(point4);
        set.insert(point5);
        set.insert(point6);
//        set.draw();
//
//        RectHV zone = new RectHV(0.100,0.050,0.400,0.900);
        System.out.println(set.nearest(point2));
    }

}
