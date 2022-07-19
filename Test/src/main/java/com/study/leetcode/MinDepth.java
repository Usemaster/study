package com.study.leetcode;

import java.util.ArrayList;
import java.util.Collections;

//描述
//求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
//示例1
//输入：
//{1,2,3,4,5}
//返回值：
//2
public class MinDepth {

    public int run (TreeNode root) {
        ArrayList<Integer> holder = new ArrayList<>();
        if(root == null){
            return 0;
        }
        //深度优先遍历所有的路径
        DFS(root,1,holder);
        //通过比较所有的路径中哪个路径最小
        return Collections.min(holder);
    }

    //深度优先遍历
    public void DFS(TreeNode root,int depth,ArrayList<Integer> holder){
        //递归结束条件
        if(root.left == null && root.right == null){
            holder.add(depth);
        }

        //左树不为空，遍历左树
        if(root.left != null){
            DFS(root.left,depth + 1,holder);
        }

        //右树不为空，遍历右树
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