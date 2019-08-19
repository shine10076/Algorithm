package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/17 21:03
 */
public class 二叉树的下一个节点 {


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;

        if(pNode.right != null) return getFirst(pNode.right);

        if(pNode.next != null)
        {
            if(pNode.next.left != null && pNode.next.left == pNode)
            {
                return pNode.next;
            }
            else if(pNode.next.right != null && pNode.next.right == pNode)
            {
                TreeLinkNode res = null;
                TreeLinkNode point = pNode.next.next;
                TreeLinkNode cur = pNode.next;
                while (point!=null && point.left == cur)
                {
                    res = point;
                    point = point.next;
                    cur = cur.next;
                }
                return res;
            }
        }

        return null;
    }


    public TreeLinkNode getFirst(TreeLinkNode root)
    {
        if(root == null ) return null;

        if(root.left != null) return getFirst(root.left);

        return root;
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}