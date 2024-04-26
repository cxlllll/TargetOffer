package tfl.chapter2;

public class Question11 {
    public static int pivotIndex(int[] nums){
        int[] sums = new int[nums.length];
        int result =-1;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            sums[i] = sum;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0){
                if(sums[i-1]== (sums[nums.length-1]-sums[i])){
                    return i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,1,0,0,0,1,1};
        System.out.println(pivotIndex(nums));
    }
}
