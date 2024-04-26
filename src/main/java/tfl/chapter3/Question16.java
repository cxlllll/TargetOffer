package tfl.chapter3;

import java.util.HashMap;
import java.util.Map;

public class Question16 {
    public static  String findMinLengStr(String str){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int start = 0,end=1;// 用来存字符串的首位指针 是遍历用的
        int startIndex = 0,endIndex=0;// 用来存 真正的结果指针
            hashMap.put(str.charAt(start),1);
        while(start<=end && end<str.length()){
            while(isAllOne(hashMap) && end<str.length()){
                // 当符合条件的时候就移动末指针 让新字符加入到子字符串中
                if(end-start>endIndex-startIndex){
                    startIndex =start;
                    endIndex  =end;
                }
                if(hashMap.containsKey(str.charAt(end))){
                    hashMap.put(str.charAt(end),hashMap.get(str.charAt(end))+1);
                }else{
                    hashMap.put(str.charAt(end),1);
                }
                end++;
            }
            // 当不符合条件时 就需要移动首指针 寻找新的符合条件的子字符串
            hashMap.put(str.charAt(start),hashMap.get(str.charAt(start))-1);
            start++;
        }
        // 因为不管怎么样end都会+1，而这里的substring方法刚好不包含end索引位置 所以 抵消了 endindex-1+1；
        return str.substring(startIndex,endIndex);
    }

    private  static  boolean isAllOne(Map<Character,Integer> map){
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                return false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        String abcbcedfgf = findMinLengStr("abcbcedfgfffff");
        System.out.println(abcbcedfgf);
    }
}
