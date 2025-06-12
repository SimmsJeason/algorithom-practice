package JZoffer;

import dto.TreeNode;

public class JZ61 {
/*    String Serialize(TreeNode root) {
        TreeNode [] queue = new TreeNode[100];
        StringBuffer result = new StringBuffer();
        int in = 0;
        int out = 0;
        queue[in ++] = root;
        while (in != out){
            TreeNode tmp = queue[out++];

            if(tmp.val == Integer.MAX_VALUE){
                result.append('#');
            }else {
                result.append(Integer.toString(tmp.val));
            }

            if(tmp.left != null){
                queue[in ++] = tmp.left;
            }else if(tmp.val != Integer.MAX_VALUE){
                queue[in ++] = new TreeNode(Integer.MAX_VALUE);
            }

            if(tmp.right != null){
                queue[in ++] = tmp.right;
            }else if(tmp.val != Integer.MAX_VALUE){
                queue[in ++] = new TreeNode(Integer.MAX_VALUE);
            }
        }
        return result.toString();
    }*/

    public int index = -1;
    //前序遍历
    public String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }
}
