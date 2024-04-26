package tfl.chapter2;

public class Question6 {
    public int[] findTwoSum(int[] sums,int target){
        int a=0;
        int b=sums.length-1;// 建立收尾两个指针。
        while(a <b && sums[a]+sums[b]!=target){
            if(sums[a]+sums[b]>target){
                b=b-1;
            }else if(sums[a]+sums[b]<target){
                a=a+1;
            }
        }
        return new int[]{a,b};
    }
}
