package com.sunniwell.net;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author ：zj
 * @date ：Created in 2020/11/24 11:49
 * @description：矩形打印
 * @version: 1.0$
 */
public class RectanglePrintDome {

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */
    public static void main(String[] args) {
        int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new ArrayList<Integer>();
        int x = 0,y = 0,n = data[0].length -1, m = data.length -1;
        while (x <= n && y <= m){
            rectangle(data, x++, y++, n--, m--, list);
        }
        System.out.println(list);
    }
    //以左上角为起始标志位（0,0）以斜对角为最大标志位（3,3）
    public static void rectangle(int[][] data, int x, int y, int n, int m, List<Integer> list){
        if(x == n && y == m){
            list.add(data[x][y]);
            return;
        }
        if(x == n || y == m){
            while (x < n){
                list.add(data[x++][y]);
            }

            while (y < m){
                list.add(data[x][y++]);
            }
            list.add(data[m][n]);
        }
        //从左往右打印
        int q = x; int p = y;
        while (q < n){
            list.add(data[p][q++]);
        }
        //从上往下打印
        while (p < m){
            list.add(data[p++][q]);
        }
        //从右往左打印
        while (q > x){
            list.add(data[p][q--]);
        }
        //从下往上打印
        while (p > y){
            list.add(data[p--][q]);
        }
    }
}
