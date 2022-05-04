package com.study.test01;

import java.util.ArrayList;
import java.util.Collections;

public class MinDepth {

    public int run (TreeNode root) {
        ArrayList<Integer> holder = new ArrayList<>();
        if(root == null){
            return 0;
        }

        DFS(root,1,holder);
        return Collections.min(holder);
    }

    public void DFS(TreeNode root,int depth,ArrayList<Integer> holder){
        if(root.left == null && root.right == null){
            holder.add(depth);
        }

        if(root.left != null){
            DFS(root.left,depth + 1,holder);
        }

        if(root.right != null){
            DFS(root.right,depth + 1,holder);
        }
    }

}
class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
}