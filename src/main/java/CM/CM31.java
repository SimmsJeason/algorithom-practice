package CM;

public class CM31 {
    public int findMissing(int[][] numbers, int n) {
        // write code here
        for (int i = 0; i< numbers.length; i++){
            if(i % 2 != numbers[i][0]){
                return i;
            }
        }

        return n;
    }
}
