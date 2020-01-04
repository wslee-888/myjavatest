package socket;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class NIOFiles {
    public static void main(String[] args) throws Exception{
        //是否存在
//        boolean isExit1 = Files.exists(Paths.get("C:\\Users\\fcz01\\Desktop\\poi"));
//        System.out.println("isExit1:"+isExit1);
//        boolean isExit2 = Files.exists(Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\test.txt"));
//        System.out.println("isExit2:"+isExit2);
//
//        System.out.println(Files.exists(Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\test.txt"),new LinkOption[]{ LinkOption.NOFOLLOW_LINKS}));

        //新建
        //Files.createDirectory(Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\properties"));
        //Files.createFile(Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\properties\\test.properties"));

        //Path sourcePath = Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\properties\\test.properties");
        //Path destinationPath = Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\test.properties");

        //复制
        //Files.copy(sourcePath, destinationPath);


        //覆盖
        //Files.copy(sourcePath, destinationPath,StandardCopyOption.REPLACE_EXISTING);

        //移动
        //Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

        //删除
        //Files.delete(Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\properties\\test2.properties"));

        //Files.deleteIfExists(Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\properties\\test.properties"));

        //浏览
/*        Files.walkFileTree(Paths.get("C:\\Users\\fcz01\\Desktop\\poi"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("pre visit dir:" + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visit file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("post visit directory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });*/

        //搜寻
/*        Path rootPath = Paths.get("C:\\Users\\fcz01\\Desktop\\poi");
        String fileToFind = File.separator + "test.properties";

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    //System.out.println("pathString = " + fileString);

                    if(fileString.endsWith(fileToFind)){
                        System.out.println("file found at path: " + file.toAbsolutePath());
                        //return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }*/

        //递归删除(指定路径下的所有文件夹和文件，可扩展按条件删除)
/*        Path rootPath = Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\新建文件夹");

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("delete file: " + file.toString());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    System.out.println("delete dir: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }*/


    }

}



