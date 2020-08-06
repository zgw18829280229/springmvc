package cn.test.controller;

import java.io.*;
import java.util.HashMap;

public class TestBufferIo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        HashMap<String,String> hashMap = new HashMap<>();
        String line = null;
        while((line = br.readLine())!=null){
            String[] strings = line.split("\\.");
            hashMap.put(strings[0],strings[1]);
        }
        for(String key : hashMap.keySet()){
            String value = hashMap.get(key);
            line = key + "." + value;
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();

    }
}
