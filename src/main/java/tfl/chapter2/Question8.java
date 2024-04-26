package tfl.chapter2;

public class Question8 {
    // 求的是连续数组的话 就不要想着排序了
    public int minSubArrayLen(int k,int[] nums){
        int left =0;
        int sum =0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0;right <nums.length;right++){
            // 外层循环加到符合条件 sum>=k为止
            sum +=nums[right];
            while(left <right && sum >= k){
                // 内层循环就尽量缩小外层循环得到的数组。
                minLength = Math.min(minLength,right-left+1);
                sum -=nums[left--];
            }
        }
        return minLength;
    }
}
