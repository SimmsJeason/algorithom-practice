package CM;

public class CM1 {
    public boolean checkDifferent(String iniString) {
        // write code here
        for(int i =0; i<iniString.length();i++){
            for(int j =0; j < iniString.length(); j++){
                if(i != j){
                    if(iniString.charAt(i) == iniString.charAt(j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
