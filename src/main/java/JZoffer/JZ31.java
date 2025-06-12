package JZoffer;

public class JZ31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i = 1; i<=n; i++){
            for(int j = i; j>0; j /=10){
                if(j % 10 == 1){
                    count ++;
                }
            }
        }

        return count;
    }
}
