package CM;

public class CM4 {
    public String replaceSpace(String iniString, int length) {
        // write code here
        if(length > 5000 || iniString.length() != length){

            return "";
        }

        StringBuffer sb = new StringBuffer(iniString);
        while(sb.indexOf(" ") >=0){
            System.out.println(sb.indexOf(" "));
            sb.insert(sb.indexOf(" "), "%20");
            sb.deleteCharAt(sb.indexOf(" "));
        }

        return sb.toString();
    }
}
