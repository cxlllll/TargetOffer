package tfl.chapter1;

public class Question4 {
    public int singleNumber(int[] nums){
        int[] bitSums = new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++){
                // 得到他的最后一位,并加入到当前数组中此位置的和
                bitSums[i]+=(num>>(32-i))&1;
            }
        }
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result += result>>1 +bitSums[i]%3;
        }
        return result;
    }
}
