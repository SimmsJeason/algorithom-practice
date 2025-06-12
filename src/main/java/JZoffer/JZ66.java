package JZoffer;

public class JZ66 {
    public int movingCount(int threshold, int rows, int cols)
    {

        if(rows == 0 && cols == 0){
            return 0;
        }
        int count = 0;
        if(rows == 1){
            for(int i = 0; i< cols; i++){
                count++;
                if(!check(rows-1, i, threshold)){
                    count --;
                    break;
                }
            }
        }else if(cols == 1){
            for(int i = 0; i< rows; i++){
                count++;
                if(!check(i, cols-1, threshold)){
                    count --;
                    break;
                }
            }
        }else {
            for(int i = 0; i<rows; i++){
                for (int j = 0; j<cols; j++){
                    if(check(i,j,threshold)){
                        System.out.println("[" + i + "," + j + "]");
                        count ++;
                    }
                }
            }
        }

        return count;
    }

    public boolean check(int row, int col, int k){
        int [] tmp = new int[10];
        int sum = 0;
        String str = Integer.toString(row);
        str += Integer.toString(col);

        for(int i =0 ; i< str.length(); i++){
            tmp[i] =str.charAt(i) - '0';
        }

        for(int i = 0; i<tmp.length; i++){
            sum += tmp[i];
        }


        if(sum > k){
            System.out.println(row + " " + col);
            return false;
        }else {
            return true;
        }
    }
}
