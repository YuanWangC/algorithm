import java.util.*;

public class CountStruct {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<String> program = new ArrayList<>();
        String s = "";
        while(!s.startsWith("sizeof(")){
            s = in.nextLine();
            program.add(s);
        }
        String target = s.substring(6,s.length()-1);
        int pos = program.indexOf("sizeof(");
        System.out.println(program);
        System.out.println(pos);
        HashMap<String,Integer> memo = new HashMap<>();
        memo.put("char",1);
        memo.put("short",2);
        memo.put("long",4);
    }
}
/*
struct RecordList {
    short recordListTotalValue;
    long recordListTotalPrice;
    struct RecordItem recordItem;
};
struct Record2 {
    short recordListTotalValue;
    struct RecordItem recordItem2;
    struct RecordItem recordItem;
};
struct RecordItem {
    char nameA;
    char nameB;
    short value;
    long price;
};
sizeof(RecordList);
 */