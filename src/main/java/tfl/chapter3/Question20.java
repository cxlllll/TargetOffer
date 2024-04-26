package tfl.chapter3;

public class Question20 {
    public   int countSubStrings(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        int count =0;
        for(int i=0;i<s.length();i++){
            count +=countPalidnrome(s,i,i);
            count+=countPalidnrome(s,i,i+1);
        }
        return count;
    }

    /**
     * 从中间开始计算,这个字符串的 所有回文串数量
     * 要是start==end 就是以一个字符为对称中心 start=end-1 就是两个字符为对称中心向两端散列
     * @param s
     * @param start
     * @param end
     * @return
     */
    private  int countPalidnrome(String s,int start,int end){
        int count =0;
        while(start>=0 && end <s.length() && s.toCharArray()[start]== s.toCharArray()[end]){
            count++;
            start--;
            end++;
        }
        return  count;
    }
}
