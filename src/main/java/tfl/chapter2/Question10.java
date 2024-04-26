package tfl.chapter2;

import java.util.HashMap;
import java.util.Map;

public class Question10 {
     public int subarraySum(int[] nums,int k){
        Map<Integer,Integer> map= new HashMap<>();
        int sum = 0;
        int result=0;
        for(int num : nums){
            sum +=num;
            map.put(sum,map.getOrDefault(sum,0)+1);
            result +=map.getOrDefault(k-sum,0);
        }
        return result;
    }
}
