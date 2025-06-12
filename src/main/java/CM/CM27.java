package CM;

public class CM27 {
    public String printBin(double num) {
        // write code here
        StringBuffer sb = new StringBuffer();
        sb.append('0');
        sb.append('.');
        while (num != 0 && sb.length() <=33){
            num = num*2;

            if(num >= 1){
                sb.append('1');
                num --;
            }else {
                sb.append('0');
            }
        }

        if(sb.length() > 32){
            return "Error";
        }

        return sb.toString();
    }
}
