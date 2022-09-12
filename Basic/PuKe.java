package Basic;
import java.util.*;

public class PuKe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        HashMap<String,Integer> memo = new HashMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        HashMap<Character,Integer> colorCount = new HashMap<>();
        int hasA = 0;
        for(int i=0;i<s.length;i++){
            int cur = 0;
            if(s[i].charAt(1) == 'K') cur = 13;
            else if(s[i].charAt(1) == 'Q') cur = 12;
            else if(s[i].charAt(1) == 'J') cur = 11;
            else if(s[i].charAt(1) == 'A') {
                cur = 14;
                hasA++;
            }
            else if(s[i].charAt(1) == '1' && s[i].length() ==3){
                cur = 10;
            }
            else {
                cur = s[i].charAt(1)-'0';
            }
            memo.put(s[i],cur);
            count.put(cur,count.getOrDefault(cur,0)+1);
            colorCount.put(s[i].charAt(0),colorCount.getOrDefault(s[i].charAt(0),0)+1);
        }
        System.out.println(count);
        System.out.println(colorCount);
        System.out.println(memo);
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(memo.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        ArrayList<Map.Entry<Integer,Integer>> listCount = new ArrayList<>(count.entrySet());
        Collections.sort(listCount, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println("*******");
        System.out.println(count);
        System.out.println(listCount);
        System.out.println(list);
        boolean hasShunZi = false;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getValue()==14){
                boolean res = checkIfTHS(list,i,true);
                if(res){
                    System.out.println("HuangJiaTongHuaShun");
                    return;
                }
                list.get(i).setValue(1);
                Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
                    @Override
                    public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
            }else{
                boolean res = checkIfTHS(list,i,true);
                if(res){
                    System.out.println("TongHuaShun");
                    return;
                }
            }
            hasShunZi = checkIfTHS(list,i,false);
            if(hasShunZi)break;
        }
        int hasThree = 0;
        int hasTwo = 0;
        for(int i=0;i<listCount.size();i++){
            int cn = listCount.get(i).getValue();
            if(cn>=4){
                System.out.println("SiTiao");
                return;
            }else if(cn==3){
                hasThree++;
//                hasTwo++;
            }else if(cn ==2){
                hasTwo++;
            }
        }
        if(hasThree>0 && hasTwo>0){
            System.out.println("HuLu");
            return;
        }
        for(Integer i:colorCount.values()){
            if(i>=5){
                System.out.println("TongHua");
                return;
            }
        }
        if(hasShunZi){
            System.out.println("ShunZi");
            return;
        }
        if(hasThree > 0){
            System.out.println("SanTiao");
            return;
        }
        if(hasTwo>=2){
            System.out.println("LiangDui");
            return;
        }
        if(hasTwo>0){
            System.out.println("YiDui");
            return;
        }
        System.out.println("QiTa");
    }

    private static boolean checkIfTHS(ArrayList<Map.Entry<String, Integer>> list, int i,boolean same) {
        //if(i+5>list.size())return false;
        int count = 1,cur = list.get(i).getValue();
        if(same) {
            Character color = list.get(i).getKey().charAt(0);
            for (int j = i + 1; j < list.size(); j++) {
                if (cur == list.get(j).getValue() + 1 && color == list.get(j).getKey().charAt(0)) {
                    count++;
                    cur--;
                }
                if (count == 5) break;
            }
        }else{
            for(int j = i + 1; j < list.size(); j++) {
                if (cur == list.get(j).getValue() + 1) {
                    count++;
                    cur--;
                }
                if (count == 5) break;
            }
        }
        if(count==5)return true;
        return false;
    }

}
/*
SA SK SQ SJ S10 H10 C9
S10 SK SQ SJ S9 H10 C9
H2 H2 S3 H2 H2 H10 C9
H2 H2 S3 H2 S3 H10 C9
HK HJ H3 H5 S3 H10 C9
S6 H2 S3 C4 S5 H10 C9
SA SA S3 S3 H5 H10 C9
SA SA SA H3 H5 H10 C9
SA SA S4 H3 H5 H10 C9
 */
/*
ShunZi:
SA H2 S3 C4 S5 H10 C9
 */