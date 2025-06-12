package WrittenExamination.meituan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        item [] array = new item[n];
        int i = 0;
        while(i < n){
            item tmp = new item();
            tmp.code = i+1;
            tmp.priority = in.nextInt();
            tmp.ness = in.nextInt();
            array[i] = tmp;
            i++;
        }
        Main3 test = new Main3();
        test.work(n, array);
    }

    public void work(int n, item[] items){
        Arrays.sort(items, new Comparator<item>() {
            @Override
            public int compare(item o1, item o2) {
                if(o1.ness == o2.ness){
                    return o2.priority - o1.priority;
                }else {
                    return o2.ness - o1.ness;
                }
            }
        });
        for(int i = 0; i<items.length; i++){
            System.out.print( items[i].code + " ");
        }
    }
}

class item{
    public int priority;
    public int ness;
    public int code;

    public item(int priority, int ness, int code) {
        this.priority = priority;
        this.ness = ness;
        this.code = code;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getNess() {
        return ness;
    }

    public void setNess(int ness) {
        this.ness = ness;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public item() {
    }
}
