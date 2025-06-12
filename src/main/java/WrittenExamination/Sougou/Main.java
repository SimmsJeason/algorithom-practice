package WrittenExamination.Sougou;

public class Main {
    public static void main(String[] args) {

        String str1 = "ABC";
        String str2 = "DDD";
        Main test = new Main();
        Interval res = test.solve(3,1, str1, str2);
        System.out.println(res.start + " " + res.end);
    }

    public Interval solve (int n, int k, String str1, String str2) {
        // write code here
        char [] chars1 = str1.toCharArray();
        char [] chars2 = str2.toCharArray();
        int same = 0;

        for(int i = 0; i < n; i++){
            if(chars1[i] == chars2[i]){
                same ++;
            }
        }
        Interval res= new Interval();
        int different = n- same;

        int error = n - k;
        if(different >=same){
            res.start = 0;
            int tmp = different - k;

            if(tmp > 4 - k ){
                if(4- k<0){
                    tmp = 0;
                }else {
                    tmp = 4-k;
                }
            }

            int max = Math.max(same, tmp);
            res.end = max;
        }else {
            if(same <= error){
                res.start = 0;
            }else {
                res.start = same - error;
            }

            if(same <= k){
                int max = Math.max(same, different - k);
                res.end = max;
            }else {
                res.end = k;
            }

        }
        return res;
    }
}

 class Interval {
   public int start;
     public int end;
}