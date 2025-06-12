package CM;

public class CM79 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        for(int i = 0; i< n; i++){
            if(s.indexOf(p[i]) >= 0){
                res[i] = true;
            }else {
                res[i] = false;
            }
        }
        return res;
    }
}
