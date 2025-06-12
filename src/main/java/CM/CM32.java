package CM;

public class CM32 {
    public int[] renderPixel(int[] screen, int x, int y) {
        // write code here
        int[] binary = {1,2,4,8,16,32,64,128};

        int i = 0;
        while (i< screen.length *8){

            if(i >= x && i <=y){
                int k = i / 8;

                int bit = i % 8;
                int tmp = screen[k];
                tmp = tmp >> bit;
                if(tmp %2 == 0){
                    screen[k] += binary[bit];
                }
            }

            i++;
        }

        return screen;
    }
}
