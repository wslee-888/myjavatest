package com.liws.io;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTwo {
    public static void main(String[] args) throws Exception{

        //File file = new File("C:\\Users\\fcz01\\Desktop\\poi");

        //File file2 = new File("C:\\Users\\fcz01\\Desktop\\code","2019-09-26");

        //System.out.println("file getParent:"+file.getParent()+",getParentFile:"+file.getParentFile());

        //System.out.println("file2 getParent:"+file2.getParent()+",getParentFile:"+file2.getParentFile());

        //System.out.println(new File(".").getCanonicalPath());

        //File file3 = new File(new File("C:\\Users\\fcz01\\Desktop"),"\\poi");


       /* URI uri = file.toURI();
        Path path = file.toPath();

        System.out.println("uri:"+uri.toString());
        System.out.println("path:"+path.toString());

        File file5 = new File(uri);*/

        //System.out.println(file.compareTo(file2));


/*        String[] fileNames = file.list();
        for (String fileName : fileNames){
            System.out.println("666666:"+fileName);
        }*/


        File testFile = new File("C:\\Users\\fcz01\\Desktop\\poi\\test.txt");
        if (testFile.exists()){
            System.out.println("testFile已存在");
        }else{
            testFile.createNewFile();
        }

        //testFile.renameTo(new File("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt"));
        //testFile.renameTo(new File("C:\\Users\\fcz01\\Desktop\\poi\\test2\\20191011\\test.txt"));
        //URI uri = testFile.toURI();
        // System.out.println(uri.toString());
/*
        File testDir = new File("C:\\Users\\fcz01\\Desktop\\poi\\test");

        if (testDir.exists()){
            System.out.println("testDir已存在");
        }else{
            testDir.mkdir();
        }

        File testDirs = new File("C:\\Users\\fcz01\\Desktop\\poi\\test2\\20191011");

        if (testDirs.exists()){
            System.out.println("testDir已存在");
        }else{
            testDirs.mkdirs();
        }*/


        //testFile.deleteOnExit();
        //testFile.delete();

        //testDir.delete();
        //testDir.deleteOnExit();

        //System.out.println("file isFile:"+file.isFile());
        //System.out.println("file isDirectory:"+file.isDirectory());

        //System.out.println("testFile isFile:"+testFile.isFile());
        //System.out.println("testFile isDirectory:"+testFile.isDirectory());

        /*file.setReadOnly();
        file.setReadable(true);
        file.setWritable(true);
        file.setExecutable(true);*/
        //file.setLastModified(System.currentTimeMillis());

        //File[] files =  file.listFiles();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //for (File f : files){
        //long modifiedTime = f.lastModified();
        //Date date = new Date(modifiedTime);

           /* System.out.println("888888:"+f.getName()+",canRead:"+f.canRead()
                    +",canWrite:"+f.canWrite()+",canExecute:"
                    +f.canExecute()+",isHidden:"+f.isHidden()
                    +",modifiedTime:"+dateFormat.format(date));*/

        // System.out.println(f.getName()+",length:"+f.length()+",isAbsolute:"+f.isAbsolute());

        //System.out.println(f.getName()+",666888,"+"getPath:"+f.getPath());
        //System.out.println(f.getName()+",666888,"+"getAbsoluteFile:"+f.getAbsoluteFile()+",getAbsolutePath:"+f.getAbsolutePath());
        //System.out.println(f.getName()+",666888,"+"getCanonicalFile:"+f.getCanonicalFile()+",getCanonicalPath:"+f.getCanonicalPath());

        //System.out.println(f.getName()+",666888,"+"getParent:"+f.getParent()+",getParentFile:"+f.getParentFile());

        //System.out.println(f.getName()+",666888,"+"getTotalSpace:"+f.getTotalSpace()+",getUsableSpace:"+f.getUsableSpace()+",getFreeSpace:"+f.getFreeSpace());
        //}



/*
        file.exists();
        file.createNewFile();
        file.mkdir();
        file.mkdirs();
        file.deleteOnExit();
        file.delete();
        file.isDirectory();
        file.isFile();
        file.renameTo();
        file.compareTo();
*/

/*
        file.list();
        file.listFiles();
        file.toPath();
        file.toURI();
        file.isAbsolute();
        file.length();
        file.getName();

        file.getAbsoluteFile();
        file.getAbsolutePath();
        file.getCanonicalFile();
        file.getCanonicalPath();
        file.getFreeSpace();
        file.getParent();
        file.getParentFile();
        file.getPath();
        file.getTotalSpace();
        file.getUsableSpace();
        */

      /*
        file.canExecute();
        file.canRead();
        file.canWrite();
        file.isHidden();
        file.setExecutable(true);
        file.lastModified();
        file.setLastModified(System.currentTimeMillis());
        file.setReadable(true);
        file.setReadOnly();
        file.setWritable(true);*/

    }
}
