import java.util.Scanner;
/*
37 5
00000001000000100000000200000020000000110030000200041234567800050003abcdef
37 6
00000001000000100000000200000020000000110030000200041234567800050003abcdef
 */
public class MessageAnalyse {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int tag = in.nextInt();
        String message = in.next();
        if(len<22 || len>1024 || message.length()<40){
            System.out.println(-4);
            return;
        }
        String contentLength16 = message.substring(32,40);
        int contentLength10 = Integer.parseInt(contentLength16,16);
        if(contentLength10*2!=message.length()-40){
            System.out.println(-4);
            return;
        }
        int messageContentType = Integer.parseInt(message.substring(40,44),16);
        if(messageContentType<1 || messageContentType>200){
            System.out.println(-3);
            return;
        }
        int res = -1;
        int index = 44;
        boolean found = false;
        while(index<message.length()){
            if(index+8>message.length()){
                System.out.println(-2);
                return;
            }
            int tagType = Integer.parseInt(message.substring(index,index+4),16);
            if(tagType == tag){
                found = true;
                res = index/2;
            }
            int tagLength = Integer.parseInt(message.substring(index+4,index+8),16)*2;
            index+=8;
            int remainLen = message.substring(index).length();
            if(remainLen<tagLength){
                System.out.println(-2);
                return;
            }else{
                index += tagLength;
            }
            if(found){
                break;
            }
        }
        System.out.println(res);
    }
}
