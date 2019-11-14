package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * 2019/11/14 20:39
 */
public class 验证IP地址 {

    public static   String validIPAddress(String IP) {

        IP = IP.toLowerCase();
        if(IP.startsWith(".")||IP.endsWith(".")||IP.startsWith(":")||IP.endsWith(":"))
        return "Neither";

        if(IP.split("\\.").length==4){
            /*判断是否为IPv4*/
            String[] ipv4 = IP.split("\\.");
            for(String ip : ipv4)
            {
                if((ip.startsWith("0")&&ip.length()>1)||(!isNumber(ip)))
                {
                    return "Neither";
                }
                int cur = Integer.parseInt(ip);
                if(cur<0||cur>255){
                    return "Neither";
                }
            }
            return "IPv4";

        }else if(IP.split(":").length==8)
        {
            /*判断是否为IPv6*/
            String[] ipv6 = IP.split(":");
            for(String ip:ipv6){

                /*长度大于4*/
                if(ip.length() > 4||ip.length()<1) return "Neither";
                /*是否有多余的0*/
//                if(isAllZero(ip)&&ip.length()>4) return "Neither";
                if(isAllZero(ip)&&ip.length()<=4) continue;

                /*除去开头的0*/
                String exclude = excludeBeginZero(ip);
                if(isPartOfIpv6(exclude)) continue;
                else return "Neither";
            }

            return "IPv6";
        }else
        {
            return "Neither";
        }
    }

    public static  boolean isNumber(String str)
    {
        if(str == null || str.length()==0 || str.length() > 3) return false;
        for(char c : str.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public static String excludeBeginZero(String ipv6){
        StringBuilder sb = new StringBuilder();
        boolean isBegin = true;
        for(char c : ipv6.toCharArray()){
            if(c=='0'&&isBegin) continue;
            else {
                isBegin = false;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean isAllZero(String ipv6){
        for(char c : ipv6.toCharArray()){
            if(c!='0')
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isPartOfIpv6(String ip){
        if(ip==null || ip.length() == 0) return false;
        if(ip.length()>4) return false;
        for(char c:ip.toCharArray()){
            if((c>='0'&&c<='9')||(c>='a'&&c<='f'))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "2001:db8:85a3:0::8a2E:0370:7334";
        String f = "1.1.1.1.";
        System.out.println(validIPAddress(s));
        System.out.println(validIPAddress(f));
        System.out.println(s.split(":").length);


    }
}
