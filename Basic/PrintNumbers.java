package algorithm;

public class PrintNumbers {
	public int start,countNine=0,n;
    //public StringBuilder res = new StringBuilder();
	public int[] res;
    public char[] loop = {'0','1','2','3','4','5','6','7','8','9'};
    public char[] number;
    public int index = 0;
    public int[] printNumbers(int n) {
    	//将n改为全局变量
    	this.n = n;
    	this.res = new int[(int)(Math.pow(10, n)-1)];
        this.number = new char[n];
        this.start = n-1;
        DFS(0);
        //返回字符串形式结果
        //res.deleteCharAt(res.length-1);
        //return res.toString();
        return res;
     }
     public void DFS(int x){
        if(x == this.n){
            String subStr = String.valueOf(this.number).substring(this.start);
            //System.out.print(this.number);
            if(!subStr.equals("0")) {
            	this.res[this.index++] =Integer.parseInt(subStr);
            	//返回字符串形式结果
                //res.append(String.valueOf(subStr)+",");
            }
            if(this.n == this.countNine + this.start)
            	this.start--;
            //出栈
            return;
        }
        for(char ch:this.loop){
            if(ch == '9') this.countNine++;
            //System.out.print(x);
            //System.out.print(ch);
            this.number[x] = ch;
            DFS(x+1);
        }
        this.countNine--;
     }
     public static void main(String[] args) {
    	 PrintNumbers p = new PrintNumbers();
    	 int[] res = p.printNumbers(2);
    	 for(int i:res)
    		 System.out.print(i);
    	 
     }
}
