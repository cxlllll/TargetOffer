package tfl.chapter2;

public class Question9 {
    public int lessThank(int[] nums,int k){
        int result = 0;
        int left = 0;
        long product= 1;
        for(int  right = 0;right<nums.length;right++){
            product *=nums[right];
            while(left <=right && product>=k){
                product /=nums[left++];
                // 直到product小于k才能推出这个循环
            }
            // 如果是left> right 说明right此时指向的元素比k值大
            result += right>left?right-left+1:0;
        }
        return  result;
    }
}
