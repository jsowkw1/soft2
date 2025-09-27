package DAsiq1;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y));
    }

    static double bruteForce(Point[] P, int n) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (dist(P[i], P[j]) < min)
                    min = dist(P[i], P[j]);
            }
        }
        return min;
    }

    static double stripClosest(Point[] strip, int size, double d) {
        double min = d;

        Arrays.sort(strip, 0, size, Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
                if (dist(strip[i], strip[j]) < min) {
                    min = dist(strip[i], strip[j]);
                }
            }
        }
        return min;
    }

    static double closestUtil(Point[] Px, int n) {
        if (n <= 3) return bruteForce(Px, n);

        int mid = n / 2;
        Point midPoint = Px[mid];

        double dl = closestUtil(Arrays.copyOfRange(Px, 0, mid), mid);
        double dr = closestUtil(Arrays.copyOfRange(Px, mid, n), n - mid);

        double d = Math.min(dl, dr);

        Point[] strip = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(Px[i].x - midPoint.x) < d) {
                strip[j++] = Px[i];
            }
        }

        return Math.min(d, stripClosest(strip, j, d));
    }

    public static double closest(Point[] P, int n) {
        Arrays.sort(P, Comparator.comparingDouble(p -> p.x));
        return closestUtil(P, n);
    }


    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };
        int n = points.length;
        System.out.println("min distance = " + closest(points, n));
    }
}
