package tfl.chapter1;

public class Question2 {
    // 二进制的计算
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int lengtha = a.length() - 1;
        int lengthb = b.length() - 1;
        int isAddBinary = 0;
        while (lengtha >= 0 || lengthb == 0) {
            int subA = 0;
            int subB = 0;
            if (lengtha > 0) {
                // 不减0得到的是asic码值
                subA = a.charAt(lengtha--) - '0';
            }
            if (lengthb > 0) {
                subB = a.charAt(lengthb--) - '0';
            }
            // 判断当前位的 0 1 2
            int sum = subA + subB + isAddBinary;
            isAddBinary = sum >= 2 ? 1 : 0;
            // 因为如果大于2已经进1了，当前位只需要留下0或者1
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        // 已经遍历到最后一位了 又进了1 需要加回来
        if (isAddBinary == 1) {
            result.append(isAddBinary);
        }
        return result.reverse().toString();
    }

}

