package com.example.lcj.file;

import java.io.*;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author lichengjian
 * @date 2021/6/4
 */
public class Mp3Merge {
    public static void main1(String[] args) throws IOException {
        File file1 = new File("/Users/lichengjian/run/02-2-20s.mp3");
        File file2 = new File("/Users/lichengjian/run/dajiyue-tripicalhouse1+africa1+2.mp3");



        InputStream is1 = new FileInputStream(file1);
        InputStream is2 = new FileInputStream(file2);

        OutputStream os = new FileOutputStream("/Users/lichengjian/run/c.mp3");

        byte[] b1 = new byte[128];
        byte[] b2 = new byte[128];
        int len1 = 0;
        int len2 = 0;
        int index = 0;

        while ((len1 = is1.read(b1)) != -1) {
            index++;
            if (index == 1) {
                continue;
            }
            os.write(b1, 0, len1);
        }
        index = 0;
        while ((len2 = is2.read(b2)) != -1) {
            index++;
            os.write(b2, 0, len2);
        }

        is1.close();
        is2.close();
        os.flush();
        os.close();
    }

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
        File file1 = new File("/Users/lichengjian/run/02-2-20s.mp3");
        File file2 = new File("/Users/lichengjian/run/02-4-20s.mp3");
        File file3 = new File("/Users/lichengjian/run/2-4.mp3");
        mergeFile(file1, file2, file3);
    }

    public static void mergeFile(File srcFile1, File srcFile2, File descFile)
            throws IOException, UnsupportedAudioFileException {
        AudioFileFormat aff = AudioSystem.getAudioFileFormat(srcFile1);

        AudioInputStream ais1 = AudioSystem.getAudioInputStream(srcFile1);

        AudioInputStream ais2 = AudioSystem.getAudioInputStream(srcFile2);

        SequenceInputStream sis = new SequenceInputStream(ais1, ais2);

        AudioSystem.write(new AudioInputStream(sis, aff.getFormat(), ais1.getFrameLength() + ais2.getFrameLength()),
                aff.getType(), descFile);

        ais1.close();
        ais2.close();
        sis.close();

    }
}


