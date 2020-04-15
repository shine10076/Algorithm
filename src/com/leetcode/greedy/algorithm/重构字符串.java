package com.leetcode.greedy.algorithm;

import java.util.Arrays;

/**
 * @author shine10076
 * @date 2020/4/14 15:40
 */
public class 重构字符串 {

    public String reorganizeString(String S) {
        MyChar[] mychars = new MyChar[26];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26;i++){
            mychars[i] = new MyChar(0,(char)('a'+i));
        }
        for(char c : S.toCharArray()){
            mychars[c-'a'].time++;
        }
        while(true){
            Arrays.sort(mychars);
            if(sb.length() >= 1 && sb.charAt(sb.length()-1) == mychars[0].a){
                if(mychars[1].time-- > 0){
                    sb.append(mychars[1].a);
                }else{
                    break;
                }
            }else{
                if(mychars[0].time-- > 0) sb.append(mychars[0].a);
                else break;
            }
        }

        return S.length() == sb.length()? sb.toString() : "";
    }
    class MyChar implements Comparable<MyChar>{
        int time;
        char a;
        MyChar(int time, char a){
            this.time = time;
            this.a = a;
        }

        @Override
        public int compareTo(MyChar o){
            return o.time - this.time;
        }
    }
}
