package CM;

public class CM29 {
    public int calcCost(int A, int B) {
        // write code here
        int result = A ^ B;
        String binR = Integer.toBinaryString(result);
        String str = binR.replace("1", "");
        return binR.length() - str.length();
    }
}
