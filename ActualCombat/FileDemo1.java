package ActualCombat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
将input文件中的内容写入output文件中去
 */
public class FileDemo1 {
    public static void main(String[] args){
        FileInputStream input = null;
        FileOutputStream out = null;
        try {
            //参数相对于项目的根目录
            input = new FileInputStream("./ActualCombat/demo1_input.txt");
            out = new FileOutputStream("./ActualCombat/demo1_output.txt");
            byte[] bytes = new byte[1024];
            int readnum;
            //Reads up to b.length bytes of data from this input stream into an array of bytes.
            // This method blocks until some input is available.
            //每次读取bytes数组长度的字符
            while((readnum = input.read(bytes))!=-1){
                //Writes len bytes from the specified byte array starting at offset off to this file output stream.
                System.out.println("write:");
                System.out.println(readnum);
                out.write(bytes,0,readnum);
            }
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(input!=null){
                try {
                    input.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
