package WrittenExamination.VipKid;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Main2 test = new Main2();
        Scanner in = new Scanner(System.in);
        List<String> str = new ArrayList<>();
        List<Interval> list = new ArrayList<>();

        while(true){
            String sss = in.nextLine();
            if(sss== null || sss.length() == 0 || sss == ""){
                break;
            }else {
                str.add(sss);
            }
        }


        for (int i = 0; i < str.size(); i++){
            String [] tmp = str.get(i).split(" ");
            int start = Integer.valueOf(tmp[0]);
            int end = Integer.valueOf(tmp[1]);
            list.add(new Interval(start , end));
        }


        test.solve(list);
    }


    public void solve(List<Interval> list){
        if(list == null || list.size() == 0){
            return;
        }
        if(list.size() == 1){
            System.out.println(list.get(0).start + " " +list.get(0).end);
            return;
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start){
                    return o2.end - o1.end;
                }
                return o1.start - o2.start;
            }
        });

        int len = list.size();
        List<Interval> merge = new ArrayList<>();

        for(int i =0; i < len; ){
            int start = 0;
            int end = 0;
            Interval cur = list.get(i);
            start = cur.start;
            end = cur.end;

            int nextStart = i+1;

            for(int j = i+1; j<len; j++){
                Interval next = list.get(j);

                if(next.start <= end && next.end > end){
                    end = next.end;
                    nextStart = j;
                    continue;
                }

                if(next.start > cur.end){
                    nextStart = j;
                    break;
                }
            }
            Interval newOne = new Interval(start, end);
            merge.add(newOne);
            i = nextStart;
        }

        //print
        for(int i = 0; i < merge.size(); i++){
            System.out.println( merge.get(i).start +" "+  merge.get(i).end);
        }
    }
}

class Interval{
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}