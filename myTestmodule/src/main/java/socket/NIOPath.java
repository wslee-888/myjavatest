package socket;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOPath {
    public static void main(String[] args) {
        Path path1 = Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\test.txt");
        System.out.println(path1);


        Path path2 = Paths.get("\\Users\\fcz01\\Desktop\\poi\\test.txt");
        System.out.println(path2);

        Path path3 = Paths.get("C:\\Users\\fcz01\\Desktop\\poi\\","test.txt");
        System.out.println(path3);

        Path path5 = Paths.get(".");
        System.out.println(path5.toAbsolutePath());

        Path path6 = Paths.get("C:\\Users\\fcz01\\Desktop\\..\\test.txt");
        System.out.println(path6);

        Path path7 = path6.normalize();
        System.out.println(path7);
    }
}
