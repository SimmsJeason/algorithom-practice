package CM;

public class CM3 {
    public boolean checkSam(String stringA, String stringB) {
        if(stringA.length() > 5000 || stringB.length() > 5000 || stringA.length() != stringB.length()){
            return false;
        }


        StringBuffer sb = new StringBuffer(stringB);

        char[] charsA = stringA.toCharArray();

        int len = stringA.length();
        for(int i = 0; i < len; i++){
            if(sb.indexOf(String.valueOf(charsA[i])) >= 0){
                sb.deleteCharAt(sb.indexOf(String.valueOf(charsA[i])));
            }else {
                return false;
            }
        }

        return true;
    }
}
