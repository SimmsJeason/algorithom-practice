package CM;

public class CM61 {
    public int[] exchangeAB(int[] AB) {
        // write code here
        if(AB[0] == AB[1]){
            return AB;
        }

        AB[0] -=AB[1];
        AB[1] = AB[0] + AB[1];
        AB[0] = -(AB[0] - AB[1]);
        return  AB;
    }
}
