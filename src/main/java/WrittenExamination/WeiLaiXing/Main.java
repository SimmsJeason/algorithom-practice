package WrittenExamination.WeiLaiXing;

/**
 * 一个数 x 一个数组 arr  判断数 x 是否可以是 arr 元素中的乘积
 */
public class Main {
    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String arrayS = in.nextLine();
        String [] arrayStr = arrayS.split(" ");
        int len = arrayStr.length;
        int[] array = new int[len];
        for(int i = 0 ; i < len; i++){
            array[i] = Integer.valueOf(arrayStr[i]);
        }*/

        int k = 20;
        int [] array = {2,3,4,5,7};
        Main test = new Main();

        System.out.println(test.solve1(array, k));
    }

    //完全背包解法

    /**
     *原因分析：对于从 一堆数 中挑选重复若干数 乘积看是否得到某数
     * 类似 在容量限制下，从一堆物品中重复挑若干物品组成价值最高
     * 以12 {6,3,4}为例
     * 大问题12由是否可以由集合元素的乘积得到
     * 变量只有一个：考虑元素的范围{6} {6,3} {6,3,4}
     * 当考虑{6}时, 6是可以获得的 12因为没有2得到不了12
     * 当考虑{6，3}时 3，6,9 可以获得
     * 当考虑{6，3，4}时6, 3, 4, 12（可以用4**3得到，3是上面有的）
     *
     * 状态转移公式：
     * a[x][y] = (a[x][y/集合新加入元素] 或运算|| a[x-1][y]) // 本行左面新加入集合元素位置有没有1，上面一个有没有1
     * 初始时a[1][y]=1
     */
    public int solvePackage(int [] array, int k){
        int len = array.length;
        int [] dp = new int[k+1];
        return 0;
    }

    public int solve1(int [] array, int k ){
        if(k == 0 ){
            for(int i = 0 ; i < array.length; i ++){
                if(array[i] == 0){
                    return 1;
                }
            }
            return -1;
        }

        if(k == 1 ){
            for(int i = 0 ; i < array.length; i ++){
                if(array[i] == 1){
                    return 1;
                }
            }
            return -1;
        }

        if(check1(array, k)){
            return 1;
        }else {
            return -1;
        }
    }

    public boolean check1(int[] array, int k){
        if(k == 0) return false;

        if(k == 1) return  true;

        boolean flag = false;
        for(int i = 0 ; i < array.length; i ++){
            if(array[i] == 0) continue;
            if(k % array[i] == 0){
                flag = flag || check1(array, k / array[i]);
            }

        }
        return flag;
    }



}
