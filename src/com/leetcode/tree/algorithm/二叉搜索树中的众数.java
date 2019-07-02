package com.leetcode.tree.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/30 13:43
 */
public class 二叉搜索树中的众数 {
    int curCnt = 0;
    int maxCnt = 0;
    TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dps(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dps(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dps(root.left, list);

        if (preNode != null) {
            if (preNode.val == root.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        } else {
            curCnt = 1;
            maxCnt = 1;
        }
        if (maxCnt < curCnt) {
            list.clear();
            list.add(root.val);
            maxCnt = curCnt;
        } else if (maxCnt == curCnt) {
            list.add(root.val);
        }

        preNode = root;
        dps(root.right, list);

    }
}
