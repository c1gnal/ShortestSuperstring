package com.imit;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Pretty_Visitor on 11.01.2015.
 */
public class Main {

    public static void main(String[]args) throws IOException {
        ObjectMapper om = new ObjectMapper();
        List<String> list = om.readValue(new File("D:\\GitHub\\ShortestSuperstring/list.json"), new TypeReference<List<String>>() {
        });
        String res = GreedyAlg.createSuperString(list);

        System.out.println(res + "\nsize = " + res.length());
    }
}
