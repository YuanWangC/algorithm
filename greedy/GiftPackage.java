import java.util.Scanner;

public class GiftPackage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            t--;
            int a = in.nextInt();
            int b = in.nextInt();
            int can = (a + b) / 3;
            int ans = Math.min(can, Math.min(a, b));
            System.out.println(ans);
        }
    }
}
