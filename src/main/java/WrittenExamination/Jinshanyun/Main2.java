package WrittenExamination.Jinshanyun;


public class Main2 {
    public static void main(String[] args) {

  /*      Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        int node1 = in.nextInt();
        int node2 = in.nextInt();

        String [] strings = str.split(" ");
        int [] array = new int [strings.length];
        for(int i = 0; i < strings.length; i++){
            array[i] = Integer.valueOf(strings[i]);
        }*/

  int [] array = {3,5,6,-1,-1,2,7,-1,-1,4,-1,-1,1,9,-1,-1,8,-1,-1};
  int node1 = 5;
  int node2 = 1;

        Main2 test = new Main2();
        System.out.println(test.solute(array, node1, node2));
    }

    public int solute(int [] array, int node1, int node2){
        int n = array.length;
        boolean [] isLeaf = new boolean[n];
        int node1Sub = 0;
        int node2Sub = 0;

        for(int i = 0 ; i < n ;i ++){
            if(array[i] == node1){
                node1Sub = i;
            }

            if(array[i] == node2){
                node2Sub = i;
            }

            if(array[i]!= -1  &&  i+2 <n && array[i+1] == -1 && array[i+2] == -1 ){
                isLeaf[i] = true;
            }
        }



        return array[0];
    }

   


}
class TmpTree{
    public int val;
    public TmpTree left;
    public TmpTree right;

    public TmpTree(int val) {
        this.val = val;
    }
}

