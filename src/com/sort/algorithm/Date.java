package com.sort.algorithm;

/**
 * @author shine10076
 * @date 2019/4/7 16:13
 * 定义一个可以比较的数据类型
 */
public class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    /**
     * 重写比较器
     */
    public int compareTo(Date that) {
        if (this.year > that.year) {
            return +1;
        }
        if (this.year < that.year) {
            return -1;
        }
        if (this.month > that.month) {
            return +1;
        }
        if (this.month < that.month) {
            return -1;
        }
        if (this.day > that.day) {
            return +1;
        }
        if (this.day < that.day) {
            return -1;
        }
        return 0;
    }
}
