package com.leetcode.sort.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author shine10076
 * @date 2019/10/10 15:26
 */
public class 车队 {

    public int carFleet(int target, int[] position, int[] speed) {

        ArrayList<cars> list = new ArrayList<>();

        for(int i=0;i<position.length;i++)
        {
            list.add(new cars(position[i],speed[i],target));
        }

        Collections.sort(list, new Comparator<cars>() {
            @Override
            public int compare(cars o1, cars o2) {
                return o2.position-o1.position;
            }
        });
        if(list.size()<=0){
            return 0;
        }

        int res = 1;
        System.out.print(list.get(0).position+" ");
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i).time <= list.get(i-1).time)
            {
                System.out.print(list.get(i).position+" ");
                list.get(i).time = Math.max(list.get(i-1).time,list.get(i).time);
                continue;
            }
            else
            {
                System.out.println();
                System.out.print(list.get(i).position+" ");
                res++;
            }
        }

        return res;

    }

    class cars
    {
       public int position;
       public int speed;
       public double time;

        public cars(int position, int speed, int target)
        {
            this.position = position;
            this.speed = speed;
            time = (double) (target - position)/(double)speed;
        }
    }


    public static void main(String[] args) {
        车队 cats = new 车队();
        cats.carFleet(10,new int[]{0,4,2}, new int[]{2,1,3});
    }
}
