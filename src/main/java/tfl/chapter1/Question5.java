package tfl.chapter1;

public class Question5 {
    public int findMaxProduct(String[] words){
        // 首先创建一个二维数组记录每个word中出现的字母情况，长度为26 使用 boolean来表示是否出现
        boolean[][] flags = new boolean[words.length][26];
        for(int i =0 ;i<words.length;i++){
            for(char c:words[i].toCharArray()){
                flags[i][c-'a'] =true;
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){

            for(int b=i+1;b<words.length;b++){
                int k=0;
                for(int a= 0;a<26;a++){
                    if(flags[i][a] && flags[b][a]){
                        break;
                    }
                    k++;
                }
                if(k==26){
                   result = Math.max(result,words[i].length()* words[b].length());
                }
            }
        }
        return result;
    }

}
