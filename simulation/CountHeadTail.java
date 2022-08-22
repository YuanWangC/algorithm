import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountHeadTail {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(in.nextInt());
        }
        if(arr.size()<=2)return;
        while(arr.size()>2){
            List<Integer> temp = new ArrayList<>();
            int i=0,j=arr.size()-1;
            while(i<j){
                temp.add(arr.get(i)+arr.get(j));
                i++;
                j--;
            }
            if(arr.size()%2!=0)temp.add(arr.get(i));
            arr = temp;
        }
        System.out.println(arr);
    }
}
