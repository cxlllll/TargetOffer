package tfl.chapter2;

public class Question12 {
    private int[][] sums;
    // 初始化数组 二维数组保存0，0到所有节点的区间的所有子元素的和
    public void NumMatrix(int[][] matrix){
        if(matrix.length==0 || matrix[0].length==0){
            return;
        }
        // 多建一行一列是为了负数的影响
        sums = new int[matrix.length+1][matrix[0].length+1];

        for(int i =0;i<matrix.length;i++){
            int sum=0;// 求这一行的和
            for(int j = 0;j<matrix[0].length;j++){
                sum+=matrix[i][j];
                sums[i+1][j+1]= sums[i][j+1]+sum;
            }
        }

    }
    // 区域和
    public int sumRegion(int row1,int col1,int row2,int col2){
        // 所有的坐标在原来的基础上+1了

        return  sums[row2+1][col2+1] -sums[row1][col2+1]-sums[row2][col1+1]+sums[row1][col1];
    }
}
