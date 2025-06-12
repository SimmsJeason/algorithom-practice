package CM;

import dto.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class CM19 {
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here

        return check(a, b) || check(b,a);//因为是有向图，要从a -> b, b -> a 双向检查
    }

    public boolean check (UndirectedGraphNode a, UndirectedGraphNode b){
        if(a == null || b == null){
            return false;
        }

        if(a == b){
            return true;
        }

        Map<UndirectedGraphNode, Boolean> isVisit = new HashMap<UndirectedGraphNode, Boolean>();//是否被访问过
        Stack<UndirectedGraphNode> stack = new Stack<>();//从头到尾，先进后出，所以采用栈结构
        stack.push(a);

        while(stack.size() != 0){
            UndirectedGraphNode cur = stack.pop();
            isVisit.put(cur, true);
            if(cur.neighbors != null || cur.neighbors.size() != 0){
                for(int i = 0; i< cur.neighbors.size(); i++){
                    UndirectedGraphNode neib = cur.neighbors.get(i);
                    if(neib != null){
                        if(neib == b){
                            return true;
                        }
                        if(isVisit.get(neib) == null || !isVisit.get(neib)){
                            stack.push(neib);
                            isVisit.put(neib, true);
                        }
                    }
                }
            }
        }
        return false;
    }
}
