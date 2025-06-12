package CM;

public class CM40 {
    //从尾向前统计
    public int countWays(int x, int y) {
        // write code here
        if(x <= 0 || y <= 0){//出界
            return 0;
        }

        if(x == 1 && y == 1){//当只有一个方格的时候
            return 1;
        }

        return countWays(x-1, y) + countWays(x, y-1);
    }
}
