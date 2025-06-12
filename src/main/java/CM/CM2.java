package CM;

import java.util.Arrays;

public class CM2 {
    public String reverseString(String iniString) {
        if(iniString.length() > 5000){
            return "";
        }
        int len = iniString.length();
        char[] chars = iniString.toCharArray();

        for(int i = 0; i < len / 2; i++){
            char tmp = chars[i];
            chars[i] = chars[len-1-i];
            chars[len-1-i] = tmp;
        }

        return new String(chars);
    }
}
