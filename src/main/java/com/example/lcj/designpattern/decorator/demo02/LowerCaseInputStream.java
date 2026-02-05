package com.example.lcj.designpattern.decorator.demo02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {
    /*
     * 自己的装饰类,将大写字母转为小写字母
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? -1 : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i <= off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}