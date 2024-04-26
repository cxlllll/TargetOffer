package tfl.chapter2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question7 {
    public List<List<Integer>> findThreeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length > 3) {
            // 先进行排序 才能使用双指针
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length - 2)// 当 i后面至少还有两个数的时候才可以进行下面的操作
            {
                twoSum(i, nums, result);
                int temp = nums[i];
                while (i < nums.length && temp == nums[i]) {
                    i++;// 跳过重复的值
                }
            }
        }
        return result;
    }

    private void twoSum(int i, int[] nums, List<List<Integer>> result) {
        int k = nums.length - 1;
        int n = i + 1;
        while (n < k) {
            if (nums[i] + nums[k] + nums[n] == 0) {
                result.add(Arrays.asList(nums[i], nums[n], nums[k]));
                // 还需要往下继续遍历  这里面移动的是j
                int temp = nums[n];
                while (n < k && temp == nums[n]) {
                    n++;
                }
            } else if (nums[i] + nums[k] + nums[n] > 0) {
                k--;
            } else {
                n++;
            }
        }
    }
}
