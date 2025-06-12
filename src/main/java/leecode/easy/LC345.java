package leecode.easy;

public class LC345 {
    public static void main(String[] args) {

        LC345 lc345 = new LC345();

        String str= "hello";
        System.out.println(lc345.reverseVowels(str));
    }
    public String reverseVowels(String s) {
        char [] chars = s.toCharArray();
        int l = 0;
        int h = s.length() -1;
        while(l < h){

            while(l < h && !isWord(chars[l])){
                l++;
            }

            while(l < h && !isWord(chars[h])){
                h--;
            }

            if(l < h) {
                char temp = chars[l];
                chars[l] = chars[h];
                chars[h] = temp;
                l ++;
                h--;
            }
        }
        return new String(chars);
    }
    public boolean isWord(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u'
        || c == 'A' || c == 'E' || c == 'I'|| c == 'O'|| c == 'U'){
            return true;
        }else {
            return false;
        }
    }
}
