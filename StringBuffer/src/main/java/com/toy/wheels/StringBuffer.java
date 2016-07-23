package com.toy.wheels;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;

/**
 * Created by toy on 7/23/16.
 */
public class StringBuffer {
    private char[] string = new char[16];
    private int count = 0;
    public StringBuffer() {
        expandCapacity(16);
        count = 0;
    }

    public StringBuffer(String s) {
        if (s == null)
            expandCapacity(16);
        else {
            int len = s.length();
            expandCapacity(len);
            System.arraycopy(s.toCharArray(), 0, string,0, len);
            count = len;

        }
    }


    public synchronized StringBuffer append(String s) {
        return append(new StringBuffer(s));
    }

    public synchronized StringBuffer append(StringBuffer sb) {
        if (sb == null) return this;
        int len = sb.length();
        int newLen = count + len;

        if (string.length < newLen) {
            expandCapacity(newLen);
        }
        sb.getChars(0, len, string, count);
        count = newLen;
        return this;
    }

    private int length() {
        return count;
    }

    public void getChars(int begin, int end, char[] dest, int destBegin) {
        if (begin < 0)
            begin = 0;
        if (end < 0 || end > count)
            end = count;

        if (begin > end) {
            int tmp = begin;
            begin = end;
            end = tmp;
        }
        System.arraycopy(string, begin, dest, destBegin, end - begin);

    }

    private void expandCapacity(int newCount) {
        int newCapacity = (string.length + 1) * 2;
        if (newCapacity < 0) {
            newCapacity = Integer.MAX_VALUE;
        } else if (newCapacity > newCapacity) {
            newCapacity = newCount;
        }
        string = Arrays.copyOf(string, newCapacity);
    }

    @Override
    public String toString() {
        char[] array= Arrays.copyOf(string, count);
        String result = new String(array);
        return result;
    }

    public static void main(String[] args) {
        StringBuffer a1 = new StringBuffer("abcd");
        a1.append("efgh");
        System.out.println(a1.toString());
    }
}
