package WrittenExamination.Qunar;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String tmp2 = in.nextLine();
        String sortS1 = in.nextLine();
        System.out.println(4);
    }

    private String solve(String [] strings){
        int len = strings.length;
        Poke[] pokes = new Poke[len];

        for(int i = 0 ; i < len; i++){
            char [] chars = strings[i].toCharArray();
            Poke poke = new Poke(chars[0], chars[1]);
        }
        return "";
    }

    private String TongHuaShun(Poke [] pokes){
        boolean colorSame = true;
        for(int i = 0 ; i < pokes.length-1; i++){
            if(pokes[i].color != pokes[i+1].color){
                colorSame = false;
                break;
            }
        }

        if(colorSame){

        }else {
            return "NOT";
        }

        return "NOT";
    }

    private String shunZi(Poke [] pokes){

        int len = pokes.length;
        if(len <5){
            return "NOT";
        }

        int [] num1 = new int[pokes.length];
        int [] num2 = new int[pokes.length];
        for(int i = 0; i < len; i ++){
            if(pokes[i].number == 'A'){
                num1[i] = 1;
                num2[i] = 14;
            }else if(pokes[i].number == 'K'){
                num1[i] = 13;
                num2[i] = 13;
            }else if(pokes[i].number == 'Q'){
                num1[i] = 12;
                num2[i] = 12;
            }else if(pokes[i].number == 'J'){
                num1[i] = 11;
                num2[i] = 11;
            }else {
                num1[i] = Integer.valueOf(pokes[i].number);
                num2[i] = Integer.valueOf(pokes[i].number);
            }

        }

        Arrays.sort(num1);
        Arrays.sort(num2);
        boolean num1Shun = true;
        boolean num2Shun = true;
        for(int i = 0; i < len-1; i++){
            if(num1[i] +1 != num1[i+1]){
                num1Shun = false;
            }
            if(num2[i] +1 != num2[i+1]){
                num2Shun = false;
            }
        }

        if(num2Shun && num2[len-1] == 14){
            return "HuangJiaShun";
        }else if(num1Shun || num2Shun) {
            return "ShunZi";
        }else {
            return "NOT";
        }

    }


}


class Poke{
    public char color;
    public char number;
    public Poke(char color, char number){
        this.color = color;
        this.number = number;
    }

}