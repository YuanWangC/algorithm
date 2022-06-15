package algorithm;

public class FindNthDigitInString {
	public int findNthDigit(int n) {
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<=n;i++){
            s.append(String.valueOf(i));
        }
        System.out.println(s);
        return 0;
    }
	public static void main(String[] args) {
		FindNthDigitInString f = new FindNthDigitInString();
		int res = f.findNthDigit(10);
		System.out.println(res);
	}
}
