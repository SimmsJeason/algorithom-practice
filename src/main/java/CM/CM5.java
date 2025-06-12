package CM;

public class CM5 {
    public String zipString(String iniString) {
        // write code here
        char[] chars = iniString.toCharArray();

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i< chars.length;){
            sb.append(chars[i]);
            int time = 1;
            while(i+1 <chars.length && chars[i] == chars[i+1]){
               i++;
               time ++;
            }
            sb.append(Integer.toString(time));
            i++;
        }

        if(sb.length() >= iniString.length()){
            return iniString;
        }else {
            return sb.toString();
        }
    }
}
