package Basic;

public class TheGreatestMinValueBinarySearch {
    public int mySqrt(int x) {
        long l=0,r=x,ans=x;
        while(l<=r){
            long m = (l+r)/2;
            if(m*m<=x){
                ans = m;
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args){
        TheGreatestMinValueBinarySearch obj = new TheGreatestMinValueBinarySearch();
        int res = obj.mySqrt(8);
        System.out.println(res);
    }
}