package WrittenExamination.Qunar;

public class Main {

    /**
     *  n <= 100 m <= n
     * @param args
     */
    public static void main(String[] args) {

        Main test = new Main();
/*        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();*/
       int n = 100;
       int m = 5;
            System.out.println(test.C(n, m));
    }


    /**
     * 递归算法
     * @param n
     * @param m
     * @return
     */
    public int f(int n, int m){
        if(m >n) return 0;
        if(m == 0) return 1;
        return f(n-1, m-1)+ f(n-1,m);
    }


    public long C(int n ,int m){
        int tmp = 0;
        long sum = 1;

        for(int i = 0 ; i < m ; i ++){
            int t1 = n - tmp;
            sum = t1 * sum;
            sum = sum /(tmp +1);
            tmp ++;
        }

        return sum;
    }


}
