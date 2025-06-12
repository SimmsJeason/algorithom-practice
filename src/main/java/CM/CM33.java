package CM;

public class CM33 {
    public double antsCollision(int n) {
        // write code here
        double total = 1;
        for(int i = 1; i<= n; i++){
            total *= 2;
        }
        double result = (total-2) / total;
        return result;
    }
}
