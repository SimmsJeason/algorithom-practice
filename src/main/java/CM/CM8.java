package CM;

public class CM8 {
    public boolean checkReverseEqual(String s1, String s2) {
        if(s1.length() == 0 || s1.length() == 0){
            return false;
        }
        String s = s1 + s1;
        if(s.indexOf(s2) == -1){
            return false;
        }else {
            return true;
        }
    }
}
