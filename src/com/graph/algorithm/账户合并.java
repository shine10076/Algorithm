package com.graph.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/9/26 20:07
 */
public class 账户合并 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<ArrayList<String>> res = new ArrayList<>();
        int[] find = new int[accounts.size()];
        for(int i=0;i<find.length;i++) find[i] = i;

        for(int i=0;i<accounts.size();i++)
        {
            for(int j=i+1;j<accounts.size();j++)
            {
                if(isSamePerson(accounts,i,j))
                {
                    union(find,find(find,i),find(find,j));
                }
            }
        }
        HashMap<Integer,List<String>> map = new HashMap<>();


        return null;

    }

    private int find(int[] find,int a)
    {
        while (find[a] != a)
        {
            a = find[a];
        }
        return a;
    }

    private void union(int[] find, int a, int b)
    {
        find[b] = a;
    }

    private boolean isSameSet(int[] find, int a, int b)
    {
        return find(find,a) == find(find,b);
    }

    private boolean isSamePerson(List<List<String>> accounts, int a, int b)
    {
        HashSet<String> set = new HashSet<>();
        for(int i=1;i<accounts.get(a).size();i++)
        {
            set.add(accounts.get(a).get(i));
        }
        for(int i=1;i<accounts.get(b).size();i++)
        {
            if(set.contains(accounts.get(b).get(i)))
            {
                return true;
            }
        }

        return false;
    }
}
