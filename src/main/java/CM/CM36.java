package CM;

import dto.Point;

public class CM36 {
    public double[] getBipartition(Point[] A, Point[] B) {
        // write code here

        Point midA = new Point(0,0);
        Point midB = new Point(0,0);
        for(int i = 0; i< 4; i++){
            midA.x += A[i].x;
            midA.y += A[i].y;
            midB.x += B[i].x;
            midB.y += B[i].y;
        }

        double x1 = midA.x;
        x1 /= 4;
        double y1 = midA.y;
        y1 /= 4;

        double x2 = midB.x;
        x2 /= 4;
        double y2 = midB.y;
        y2 /= 4;

        double[] result = new double[2];
        result[0] = (y2-y1)/(x2-x1);

        result[1] = y1- x1 * result[0];

        return result;
    }
}
