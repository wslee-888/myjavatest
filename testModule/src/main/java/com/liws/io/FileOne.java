package com.liws.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class MyFilter implements FileFilter{
    private Pattern pattern;

    public MyFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File pathname) {
        return false;
    }
}


class DirFilter implements FilenameFilter{

    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}


public class FileOne {
    public static void main(String[] args) {
       File file = new File("F:\\迅雷下载2");

       String[] fileNames = file.list(new DirFilter("(crypto).*"));
        Arrays.sort(fileNames, String.CASE_INSENSITIVE_ORDER);

        for (String fileName : fileNames){
           System.out.println(fileName);
       }

    }
}
