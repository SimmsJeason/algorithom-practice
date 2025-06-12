package JZoffer;

public class JZ34 {
    public int FirstNotRepeatingChar(String str) {
        /**
         *
         * 首先用一个58长度的数组来存储每个字母出现的次数，为什么是58呢，
         * 主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，而每个字母的index=int(word)-65，
         */
        int [] words = new int[58];
        for(int i = 0; i< str.length(); i++){
            words[((int)str.charAt(i)) - 65] += 1;
        }

        for(int i= 0; i < str.length(); i++){
            if(words[((int)str.charAt(i)) - 65] == 1){
                return i;
            }
        }
        return -1;
    }
}
