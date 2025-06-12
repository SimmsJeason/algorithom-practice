package WrittenExamination.Sougou;

public class Main2 {


    public static void main(String[] args) {

        Main2 test = new Main2();
       // String[] str1 = { "ABCD","EFGH","IJKL","MNPQ"};
        String[] str1 = { "AB","CD"};
        //String [] str2 = {"1101","1010","1111","1010"};
        String [] str2 = {"10","01"};
        System.out.println(test.rotatePassword(str1, str2));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public String rotatePassword (String[] s1, String[] s2) {
        // write code here
        int m = s2.length;

        char [][] chars1 = new char[m][m];
        char [][] chars2 = new char[m][m];
        for(int i = 0 ; i < m; i++){
            char[] cur1 = s1[i].toCharArray();
            chars1[i] = cur1;

            char[] cur2 = s2[i].toCharArray();
            chars2[i] = cur2;
        }

        StringBuffer sb = new StringBuffer();

        char [][] str2After = chars1;
        char [][] str2After1 = xuanzhuan(str2After);
        char [][] str2After2 = xuanzhuan(str2After1);
        char [][] str2After3 = xuanzhuan(str2After2);

        sb.append(once(chars2, str2After, m));
        sb.append(once(chars2, str2After1, m));
        sb.append(once(chars2, str2After2, m));
        sb.append(once(chars2, str2After3, m));

        return sb.toString();
    }

    public String once(char [][] str1, char[][] str2, int m){

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < m; j++){
                if(str2[i][j] == '0'){
                    sb.append(str1[i][j]);
                }
            }
        }
        return sb.toString();
    }

    private char[][] xuanzhuan(char[][] strings){
        int m = strings.length;
        int n = strings[0].length;
        char [][] chars = new char[m][n];
        for(int j = 0 ; j < m ; j ++){
            for(int i = 0; i < n; i ++){
                chars[i][n-1- j] = strings[j][i];
            }
        }
       return chars;
    }
}
