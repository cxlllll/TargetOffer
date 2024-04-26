package tfl.chapter3;

import java.util.HashMap;

public class Question17 {
    public static String minWindow(String s,String t){
        HashMap<Character,Integer> charToCount = new HashMap<>();
        for(char c:t.toCharArray()){
            // 将短的字符串放入哈希表中
            charToCount.put(c,charToCount.getOrDefault(c,0)+1);
        }
        int count = charToCount.size();
        int start =0,end =0,minStart= 0,minEnd =0;
        int minLength =Integer.MAX_VALUE;
        while(end<s.length() || (count==0&& end==s.length() )){
            if(count>0){
                char endCh=s.charAt(end);
                if(charToCount.containsKey(endCh)){
                    charToCount.put(endCh,charToCount.get(endCh)-1);
                    if(charToCount.get(endCh)==0){
                        count--;
                    }
                }
                end++;
            }else{
                if(end -start<minLength){
                    minLength=end-start;
                    minStart = start;
                    minEnd = end;
                }
                char startch = s.charAt(start);
                if(charToCount.containsKey(startch)){
                    charToCount.put(startch,charToCount.get(startch)+1);
                    if(charToCount.get(startch)==1){
                        count++;
                    }
                }
                start++;
            }
        }
        return minLength <Integer.MAX_VALUE?s.substring(minStart,minEnd):"";
    }

    public static void main(String[] args) {
        System.out.println(minWindow("toancskad","ask"));
    }
}
