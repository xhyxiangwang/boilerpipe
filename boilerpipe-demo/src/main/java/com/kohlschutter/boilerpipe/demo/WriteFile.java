package com.kohlschutter.boilerpipe.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by xianghongyan on 2017/11/13.
 */

public class WriteFile {
    public static void writeFile(String filePathAndName, String fileContent) {
        try {

            File file = new File(filePathAndName);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(fileContent);
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println(e+"写入失败");
        }

    }
}
