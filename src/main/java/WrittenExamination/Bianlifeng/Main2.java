package WrittenExamination.Bianlifeng;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String [] relations = new String[n];
        String tmp = in.nextLine();
        for(int i = 0; i < n; i++){
            relations[i] = in.nextLine();
        }
        Main2 test = new Main2();
        System.out.println(test.solve(relations));
    }

    public char solve(String [] relations){
        ListNode [] nodes = new ListNode[26];
        char [] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i = 0; i < 26; i++){
            ListNode cur = new ListNode(chars[i]);
            nodes[i] = cur;
        }


        for(String str: relations){
            String [] cur = str.split("->");
            int from = cur[0].charAt(0) - 'A';
            int to = cur[1].charAt(0) - 'A';
            nodes[from].next = nodes[to];
        }

        for(int i = 0; i < 26 ;i ++){
            if(nodes[i].next == null){
                continue;
            }else {
                if(isCurcle(nodes[i])){
                    return 'Y';
                }
            }
        }
        return 'N';
    }

    public  boolean isCurcle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

class ListNode{
    public char val;
    public ListNode next;

    public ListNode(char val) {
        this.val = val;
    }
}