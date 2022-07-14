package Basic;

public class Zijuzheng {
    int[] res=new int[4];
    public int getMaxMatrix(int[][] matrix) {
        // 暂存矩阵的列和
        int[] sum = new int[matrix[0].length];
        int max = matrix[0][0];
        for (int beginLine = 0; beginLine < matrix.length; beginLine++) {
            //清空矩阵的列和
            for (int i = 0; i < sum.length; i++) {
                sum[i]=0;
            }
            for (int i = beginLine; i < matrix.length; i++) {
                int dp=Integer.MIN_VALUE;
                //求连续子数组的最大和
                int begin=0;
                for (int j = 0; j < matrix[0].length; j++) {
                    sum[j]+=matrix[i][j];
                    if(dp>0) {
                        dp=dp+sum[j];
                    }else {
                        dp=sum[j];
                        begin=j;
                    }
                    max=change(max, dp, beginLine, begin, i, j);
                }
                //System.out.println(Arrays.toString(sum));
            }
        }

        //System.out.println(max);
        return max;
//        return res;
    }

    private int change(int max, int tmpMax, int beginY, int beginX, int endY, int endX) {
        if(max<tmpMax) {
            res[0]=beginY;
            res[1]=beginX;
            res[2]=endY;
            res[3]=endX;
            return tmpMax;
        }
        return max;
    }
    public static void main(String[] args){
        Zijuzheng obk = new Zijuzheng();
        int[][] arrs=  new int[][]{{2,3,4,5},{3,4,5,0}};
        int res = obk.getMaxMatrix(arrs);
        System.out.println(res);
    }
}