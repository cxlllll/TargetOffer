package tfl.chapter1;

public class Question3 {
    public int[] countBits(int num){
        int[] result = new int[num+1];
        //  因为 i&i-1 的二进制1的个数比i的二进制1的个数 少1，然后(i-1)要大于0，所以从1开始
        for(int i=1;i<=num;i++){
            result[i] = result[i&(i-1)]+1;
        }
        return result;
    }

}
