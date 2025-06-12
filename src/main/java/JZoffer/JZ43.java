package JZoffer;

public class JZ43 {
    public String LeftRotateString(String str,int n) {

        if(str == null || str.length() == 0){
            return "";
        }

        n %= str.length();
        String str1 = str.substring(n);
        String str2 = str.substring(0, n);

        return str1+str2;
    }
}
