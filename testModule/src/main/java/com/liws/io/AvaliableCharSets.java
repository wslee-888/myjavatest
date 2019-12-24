package com.liws.io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvaliableCharSets {
    public static void main(String[] args) {
        SortedMap<String,Charset> charsets = Charset.availableCharsets();

        Iterator<String> it = charsets.keySet().iterator();
        while (it.hasNext()){
            String csName = it.next();

            System.out.println(csName+":");

            Iterator aliases = charsets.get(csName).aliases().iterator();

            while (aliases.hasNext()){
                System.out.println(aliases.next());
                if (aliases.hasNext()){
                    System.out.print(",");
                }
            }
        }
    }
}
