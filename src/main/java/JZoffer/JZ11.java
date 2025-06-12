package JZoffer;

public class JZ11 {
    public int NumberOf1(int n) {
       String binary = Integer.toBinaryString(n);
        //System.out.println(binary);


        int count = 0;
        for(int i =0; i < binary.length() ; i++){
            if(binary.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

}
