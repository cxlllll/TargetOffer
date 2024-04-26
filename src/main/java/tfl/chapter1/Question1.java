package tfl.chapter1;

public class Question1 {
    /**
     * @param diviend 被除数
     * @param divisor 除数
     * @return
     */
    public int divide(int diviend,int divisor)throws  Exception{
        // 内存溢出
        if(diviend== 0X80000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(divisor == 0){
            throw new Exception("除数不能为0");
        }
        int negative = 2;// 判断是否转换为负数.
        if(diviend>0){
            negative -=negative;
            diviend = -diviend;
        }
        if(divisor>0){
            negative -=negative;
            divisor = -divisor;
        }
        int result =divideCore(diviend,divisor);
        return negative==1?-result:result;
    }

    private int divideCore(int diviend, int divisor) {
        int result = 0;
        while(diviend <divisor){
            int value = divisor;
            int beishu = 1;
            // 要是被除数 比 当前value的两倍还大的话
            while(value >= 0Xc0000000&& diviend<=value+value){
                beishu += beishu;
                value+=value;
            }
            result +=beishu;
            // 到这里的话是 diviend比value的一倍大 没有超过两倍
            diviend -=value;
        }
        return result;
    }
}
