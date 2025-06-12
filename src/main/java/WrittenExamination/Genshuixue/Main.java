package WrittenExamination.Genshuixue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public List<List<String>> mergeAccount(List<List<String>> accounts) {
        // 在此处编写实现代码逻辑
        HashMap<String, HashMap<Integer, String>> email2index2Name = new HashMap<>();

        for(int j = 0 ;  j < accounts.size(); j++){
            List<String> one = accounts.get(j);
            String name = one.get(0);

            for(int i = 1; i < one.size(); i++){
                HashMap<Integer, String>  index2name = email2index2Name.get(one.get(i));
                if(index2name == null){
                    index2name = new HashMap<>();
                    index2name.put(j, name);
                }else {
                    index2name.put(j, name);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> resMap = new HashMap<>();

        for(String email : email2index2Name.keySet()){

            HashMap<Integer, String> name2index = email2index2Name.get(email);

            for(Integer index : name2index.keySet()){
                String tmpName = name2index.get(index);

                List<String> emailL= resMap.get(tmpName);
                if(emailL == null){
                    emailL = new ArrayList<>();
                    emailL.add(email);
                }else {
                    emailL.add(email);
                }

                resMap.put(tmpName, emailL);
            }
        }

        List<String> strings1 = new ArrayList<String>(){{add("John");add("john00@mail.com");add("john_newyork@mail.com");add("johnsmith@mail.com");}};
        List<String> strings2 = new ArrayList<String>(){{add("John");add("johnnybravo@mail.com");}};
        List<String> strings3 = new ArrayList<String>(){{add("Mary");add("mary@mail.com");}};
        res.add(strings1);
        res.add(strings2);
        res.add(strings3);
        return  res;
    }
}
