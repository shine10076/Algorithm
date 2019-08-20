package com.offer.algorithm;

import java.util.HashMap;

/**
 * @author shine10076
 * @date 2019/8/20 20:24
 */
public class FirstNonduplicate {

    public HashMap<Character,Integer> map = new HashMap<>();

    public StringBuilder sb = new StringBuilder();

    public void Insert(char ch)
    {
        sb.append(ch);
        if(map.containsKey(ch))
        {
            map.put(ch,map.get(ch)+1);
        }
        else
        {
            map.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(char c: sb.toString().toCharArray())
        {
            if(map.containsKey(c)&&map.get(c) == 1)
            {
                return c;
            }
        }

        return '#';
    }


    public static void main(String[] args) {

        String str = "google";
        FirstNonduplicate f = new FirstNonduplicate();

        for(char c : str.toCharArray())
        {
            f.Insert(c);
            System.out.println(f.FirstAppearingOnce());

        }

    }
}
