package com.example.muyi.myapplication;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    /**
     * 暴力查找法
     *
     * @param targetStr  主串
     * @param patternStr 模式串
     * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
     */
    private int bf(String targetStr, String patternStr) {
        System.out.print("bf:");
        char[] ts = targetStr.toCharArray();
        char[] ps = patternStr.toCharArray();
        int i = 0;//主串位置
        int j = 0;//模式串位置
        int count = 0;
        while (i < ts.length && j < ps.length) {
            count++;
            System.out.print("i=" + i);
            System.out.print("j=" + j + "\n");

            if (ts[i] == ps[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;//一旦不匹配，i回溯
                j = 0;//j归0
            }

        }
        System.out.print("count=" + count);

        if (j == ps.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * kmp查找法
     *
     * @param targetStr
     * @param patternStr
     */
    private int kmp(String targetStr, String patternStr) {
        System.out.print("kmp:");
        char[] ts = targetStr.toCharArray();
        char[] ps = patternStr.toCharArray();
        int[] next = getNext(patternStr);
        int i = 0;//主串位置
        int j = 0;//模式串位置
        int count = 0;
        while (i < ts.length && j < ps.length) {
            count++;
            System.out.print("i=" + i);
            System.out.print("j=" + j + "\n");
            if (ts[i] == ps[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    // i不需要回溯了
                    j = next[j - 1]; // j回到指定位置
                }

            }
        }
        System.out.print("count=" + count);
        if (j == ps.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * kmp查找法
     *
     * @param targetStr
     * @param patternStr
     */
    private int kmp2(String targetStr, String patternStr) {
        System.out.print("kmp2:");
        char[] ts = targetStr.toCharArray();
        char[] ps = patternStr.toCharArray();
        int[] next = getNext2(patternStr);
        int i = 0;//主串位置
        int j = 0;//模式串位置
        int count = 0;
        while (i < ts.length && j < ps.length) {
            count++;
            System.out.print("i=" + i);
            System.out.print("j=" + j + "\n");
            if (j==-1||ts[i] == ps[j]) {
                i++;
                j++;
            } else {
               j=next[j];

            }
        }
        System.out.print("count=" + count);
        if (j == ps.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    @Test
    public void testBf() {

        String t ="aaabaaaaab" ;
        String p="aabaabc" ;

        int result1 = bf(t, p);
        System.out.print("index=" + result1);
        System.out.print("\n");

        int result2 = kmp(t, p);
        System.out.print("index=" + result2);
        System.out.print("\n");

        int result3 = kmp2(t, p);
        System.out.print("index=" + result3);

    }


    private int[] getNext(String patternStr) {
        int[] next = new int[patternStr.length()];
        next[0] = 0;
        for (int i = 1; i < patternStr.length(); i++) {
            if (patternStr.charAt(i) == patternStr.charAt(next[i - 1])) {
                next[i] = next[i - 1] + 1;
            }
        }

        return next;
    }

    private int[] getNext2(String patternStr) {
        char[] p = patternStr.toCharArray();
        int[] next = new int[patternStr.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < patternStr.length() -1)
        {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p[j] == p[k])
            {
                ++k;
                ++j;
                next[j] = k;
            }
            else
            {
                k = next[k];
            }
        }

        return next;
    }


    @Test
    public void testNext() {
        String ss = "ABCDABD";
        int[] result = getNext(ss);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "");
        }

    }
    @Test
    public void testFloat(){
        checkFloat();

    }

    private void  checkFloat(){
        System.out.print("3*0.1="+3*0.1);

        if(3*0.1==0.3){
            System.out.print("true");
        }else{
            System.out.print("false");
        }
    }
}