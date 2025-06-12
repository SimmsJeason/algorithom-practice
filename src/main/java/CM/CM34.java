package CM;

public class CM34 {
    public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        // write code here
        // 斜率相等且截距不同的两条直线不相交
        // 浮点数比较不能用==，应当是小于某个极小值
        if(Math.abs(s1 - s2) < 1e-6 && Math.abs(y1 - y2) > 1e-6) return false;
        return true;
    }
}
