package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/29 14:29
 */
public class 将有序链表转化为二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null ) return null;
        return toBST(head,null);
    }

    private TreeNode toBST(ListNode head, ListNode tail)
    {
        if(head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != tail&&fast.next != tail)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,tail);
        return root;
    }
}
