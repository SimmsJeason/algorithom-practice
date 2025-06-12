package CM;

public class CM28 {
    public int[] getCloseNumber(int x) {
        // write code here
        int [] result = new int[2];

        String binary = Integer.toBinaryString(x);
        int num1 = numOfOne(binary);
        for(int i = x+1; ;i++){
            String big = Integer.toBinaryString(i);
            if(numOfOne(big) == num1){
                result[1] = Integer.parseInt(big, 2);
                break;
            }
        }

        for(int i = x-1; ; i--){
            String small = Integer.toBinaryString(i);
            if(numOfOne(small) == num1){
                result[0] = Integer.parseInt(small, 2);
                break;
            }
        }

        return result;
    }

    public int numOfOne(String binary){
        String tmp = binary.replace("1", "");
        return binary.length() - tmp.length();
    }
}
