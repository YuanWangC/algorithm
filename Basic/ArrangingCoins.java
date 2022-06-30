package Basic;
//    用n个硬币放置，第k行有k个硬币，求硬币数完整的行数
public class ArrangingCoins {
//  使用二分查找，查找等差数列和小于等于n的最大值
    public int arrangeCoins(int n) {
        long l=0,r=n;
        long ans = n;
        while(l<=r){
            long m=(l+r)/2;
            // 等差数列求和：(i+1)i/2
            long sum = m*(m+1)/2;
            if(sum<=n){
                ans = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args){
        ArrangingCoins obj = new ArrangingCoins();
        int res = obj.arrangeCoins(8);
        System.out.println(res);
    }
}
