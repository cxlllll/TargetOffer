package tfl.chapter3;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion14 {
    /**
     * 判断s1中是否有s2的换位词
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s2,String s1){
        if(s2.length()<s1.length())
        {
            return  false;
        }
        boolean result = false;
//        int[] charFlag = new int[26];
//        for(char c:s2.toCharArray()){
//            charFlag[c-'a']=1;
//        }
        HashMap<Character,Integer> map = new HashMap<>();// key表示字符 value表示 0，1是否出现
        for(char c:s2.toCharArray()){
            // 将s2中的字符放入map中，key为字符，value为次数
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int start = 0; // 子字符串开始索引
        int end = start+s2.length()-1;// 子字符串结束下标
        for(int i=0;i<=end;i++){
            // 第一个子字符串中包含的字符对map的影响  进来字符串的字符（end新加的字符）在map中如果存在，次数减一次 出去的字符（start）在map中如果存在就加1
            if(map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i),map.get(s1.charAt(i))-1);
            }
        }
        // start 和end必须同时移动的，因为子符串是固定长度的 所以
        end++;// end向前移动一位 因为 当前字符已经计算
        if(isAllZero(map)){
            return true;
        }
        for(;end<s1.length();end++){
            // 因为end已经移动了一位 所以 新字符需要计算
            if(map.containsKey(s1.charAt(end))){
                map.put(s1.charAt(end),map.get(s1.charAt(end))-1);
            }

            if(map.containsKey(s1.charAt(end-s2.length()))){
                // 出去了 就不是我哈希中记录的字符串的情况了 它不属于当前 start-end监测的字符串了 所以 应该消除他之前带来的影响
                map.put(s1.charAt(end-s2.length()),map.get(s1.charAt(end-s2.length()))+1);
            }
            if(isAllZero(map)){
                return true;
            }
        }
        return result;
    }

    private  static  boolean isAllZero(Map<Character,Integer> map){
       boolean result = true;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
           if(!entry.getValue().equals(0)){
               return false;
           }
       }
        return  true;
    }

    public static void main(String[] args) {
        boolean b = checkInclusion( "bcd","asdcbd");
        System.out.println(b);
    }
}
