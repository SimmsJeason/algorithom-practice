package CM;

public class CM24 {
    public int getLCA(int a, int b) {
        // write code here
        if(a < b){
            if(b%2 == 1){
                return getLCA(a, (b-1)/2);
            }else if(b %2 == 0){
                if(b/2 == a){
                    return a;
                }
                return getLCA(a, b/2);
            }
        }else if(a > b){
            if(a%2 == 1){
                return getLCA((a-1)/2, b);
            }else if(a % 2 == 0){
                if(a/2 == b){
                    return b;
                }
                return getLCA(a/2, b);
            }
        }else {
            return a;
        }

        return -1;
    }
}
