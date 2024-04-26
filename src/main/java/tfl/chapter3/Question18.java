package tfl.chapter3;

public class Question18 {
    /**
     * 首尾指针，这里是真的先指向首尾
     *
     * @param str1
     * @return
     */
    public static boolean isPalindrome(String str1) {
        if (null == str1 || str1.length() == 0) {
            return true;
        }
        String str = str1.trim().toLowerCase();// 先去除空格 大小写的影响
        int i = 0;
        int j = str.length() - 1;
        boolean result = true;
        while (i <= j) {
            char c = str.toCharArray()[i];
            char d = str.toCharArray()[j];
            // 消除非字母的影响
            if (Character.isLetterOrDigit(c)) {
                i++;
            } else if (Character.isLetterOrDigit(d)) {
                j--;
            } else {
                if (!(c == d)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abba";
        String str1 = "abcba";
        boolean palindrome = isPalindrome(str);
        boolean palindrome1 = isPalindrome(str1);
        System.out.println(palindrome);
    }
}
