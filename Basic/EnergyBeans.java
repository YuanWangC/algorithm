package Basic;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EnergyBeans {

    public static void main(String[] args){
        int[] beans = {2,7,4,1,8,1};
        int res = count(beans);
        System.out.println(res);
    }
    private static int count(int[] beans) {
        ArrayList<Integer> bean = new ArrayList<>();
        for(int i:beans)bean.add(i);
        int res = 0;
        while(bean.size()>=2) {
            Collections.sort(bean);
            res = Math.abs(bean.get(bean.size() - 1) - bean.get(bean.size() - 2));
            System.out.println(bean);
            if(bean.size() == 2)return res;
            bean.remove(bean.size() - 1);
            bean.remove(bean.size() - 2);
            bean.add(res);
        }
        return res;
    }
}
