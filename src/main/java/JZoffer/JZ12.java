package JZoffer;

public class JZ12 {
    public double Power(double base, int exponent) {
        if(base == 0.0){
            return 0;
        }

        double result = 1;

        if(exponent == 0){
            return 1;
        } else if(exponent >0){
            for(int i = exponent; i>0; i--){
                result *=base;
            }
        }else{
            for(int i = Math.abs(exponent); i>0; i--){
                result *=base;
            }
            result = 1 / result;
        }

        return result;
    }
}
