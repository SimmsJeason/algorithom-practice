package CM;

import java.util.ArrayList;

public class CM76 {
    public int getDistance(String[] article, int n, String x, String y) {
        // write code here
        ArrayList<Integer> xLoc = new ArrayList<>();
        ArrayList<Integer> yLoc = new ArrayList<>();
        int min = 1001;
        for(int i =0; i< n; i++){
            if(article[i].equals(x)){
                xLoc.add(i);
            }

            if(article[i].equals(y)){
                yLoc.add(i);
            }
        }

        for(Integer i : xLoc){
            for(Integer j: yLoc){
                int distance = Math.abs(i-j);
                min = Math.min(min, distance);
            }
        }

        return min;
    }

    //时间复杂度为O(n),空间复杂度O（1）。
//总的思想就是设置一个游标记录上一个出现的x或者y的位置。游标初始化为-1，最短距离设置为n。
//当遇到第一个x或y时，游标设置为当前位置。接下来（1）再遇到相同字符串时，只需将游标设置
//为当前位置，原因是，在两个相同字符串中间没有出现另一个需要查找的字符串，则即使接下来出
//现了另一个字符串，也只会距离当前位置的最近。（2）遇到需要查找的第二个字符串，则计算两
//者之间的距离,判断是否比最短距离还短，若是，则更新最短距离。完事后需要将游标设为当前位置
//。接下来就明朗了，要么遇到不同的另一个字符串或者同一个，按上述循环即可。

    public int getDistance2(String[] article, int n, String x, String y) {
        int point = -1;
        int min = n;
        for(int i =0; i< n; i++){
            if(article[i] == x || article[i] == y){
                if(point != -1 && article[point] != article[i] && min > i-point){
                    min = i- point;
                }
                point = i;
            }
        }
        return min;
    }
}
