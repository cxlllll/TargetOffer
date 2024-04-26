package tfl.chapter3;

public class Question19 {
    public static  boolean validHuiWen(String str) {
        int i = 0;
        int j = str.length() - 1;
        String trim = str.trim();// 去除空指针的影响
        boolean result = true;
        while (i <= j) {
            char a1 = trim.toCharArray()[i];
            char a2 = trim.toCharArray()[j];
            if (a1 == a2) {
                i++;
                j--;
            } else {
                int t1 = i + 1;
                int t2 = j - 1;
                    if (trim.toCharArray()[t1] == a2) {
                        i++;
                    } else if (trim.toCharArray()[t2] == a1) {
                        j--;
                    }else{
                        return  false;
                    }

            }
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(validHuiWen("abbca"));
    }
}
