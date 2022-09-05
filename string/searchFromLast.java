package string;

public class searchFromLast {
    public int search(String s,String p){
        if(p.length()==0)return s.length();
        int index = 0;
        int i=s.length()-1,temp = i;
        boolean flag = false;
        int res = temp;
        while(i>=0){
            System.out.println(i+" "+index);
            if(index>=p.length())break;
            if(p.charAt(index)=='*' ||s.charAt(i)==p.charAt(index)){
                if(temp-i+1 == p.length()){
                    flag = true;
                    index=0;
                    res = temp;
                    temp--;
                    i=temp;
                    continue;
                }
                index++;
                i--;
            }else{
                temp--;
                i=temp;
                index= 0;
            }

        }
        if(flag)return res;
        return -1;
    }
    public static void main(String[] args){
        String target = "Hello world";
//        String pattern = "ow";    //7
//        String pattern = "l*o";     //9
        String pattern = "l**";     //2
        searchFromLast obj = new searchFromLast();
        System.out.println(obj.search(target, pattern));
    }
}
