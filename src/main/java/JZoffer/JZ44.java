package JZoffer;

public class JZ44 {
    public String ReverseSentence(String str) {

        //！！！！！！！！！！！！！！！！
        if (str.trim().equals("") && str.length() > 0) {
            return str;
        }

        String [] words = str.split(" ");
        String[] revers = new String[words.length];
        int j =0;
        for(int i = words.length-1; i>=0; i--){
            revers[j] = words[i];
            j++;
        }

        String result = "";
        for(int k = 0; k < revers.length; k++){
            result += revers[k] + " ";
        }

        return result.trim();
    }
}
