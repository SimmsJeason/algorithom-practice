package WrittenExamination.Bianlifeng;

import java.util.*;

public class Main22 {
    public static void main(String[] args) {

        Main22 test = new Main22();
        String [] relations = {"A->B","B->C","E->B","B->D","D->F", "F->R"};
        System.out.println(test.haveCircle(relations));

    }
    public boolean haveCircle(String [] relations){

        List<Node2> nodes = new ArrayList<>();

        for(String str :  relations){
            String [] relation = str.split("->");
            Node2 from = new Node2(relation[0].charAt(0));
            Node2 to = new Node2(relation[1].charAt(0));

            if(nodes.contains(to)){

                for(int i = 0; i < nodes.size() ; i++){
                    Node2 cur = nodes.get(i);
                    if(cur.equals(to)){
                        cur.indegreeIncrement();
                    }
                }
            }else {
               nodes.add(to);
            }

            if(nodes.contains(from)){
                for(int i = 0; i < nodes.size() ; i++){
                    Node2 cur = nodes.get(i);
                    if(cur.equals(from)){
                        cur.nearby.add(to);
                    }
                }

            }else {
                nodes.add(from);
            }

        }

        Queue<Node2> queue = new LinkedList<>();
        for(Node2 node : nodes){
            if(node.indegreeZero()){
                queue.add(node);
            }
        }
        int size = 1;

        while(!queue.isEmpty()){
            Node2 tmp = queue.poll();
            size ++;
            List<Node2> nearby = tmp.nearby;
            for(Node2  near : nearby){
                near.indegreeDecrement();
                if(near.indegreeZero()){
                    queue.add(near);
                }
            }
        }

        if(size < nodes.size()){
            return true;
        }else {
            return false;
        }
    }
}

class  Node2{
    public char val;
    public List<Node2> nearby;
    public int indegree;

    public Node2(char val) {
        this.val = val;
        this.nearby = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;
        if( !(obj instanceof Node2)) return false;

        Node2 o = (Node2) obj;
        return this.val == o.val;
    }

    public void indegreeIncrement(){
        this.indegree ++;
    }

    public void indegreeDecrement(){
        this.indegree --;
    }

    public boolean indegreeZero(){
        return this.indegree == 0;
    }
}
