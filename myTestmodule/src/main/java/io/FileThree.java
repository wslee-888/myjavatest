package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;

final class Directory{

    public static File[] local(File dir,String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path, String regex){
        return local(new File(path), regex);
    }

    public static class Treeinfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        /*@Override
        public void forEach(Consumer<? super File> action) {

        }

        @Override
        public Spliterator<File> spliterator() {
            return null;
        }*/

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        @Override
        public String toString() {
            return "dirs:";
        }

        void addAll(Treeinfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        //递归查询，获取文件夹和文件，最后的结果是存放在首级Treeinfo
        static Treeinfo recurseDirs(File startDir, String regex){
            Treeinfo result = new Treeinfo();
            for (File item:startDir.listFiles()){
                if (item.isDirectory()){
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item,regex));
                }else {
                    if (item.getName().matches(regex)){
                        result.files.add(item);
                    }
                }
            }
            return result;
        }

        public static Treeinfo walk(String start,String regex){
            return recurseDirs(new File(start),regex);
        }

        public static Treeinfo walk(File start, String regex){
            return recurseDirs(start,regex);
        }

        public static Treeinfo walk(String start){
            return recurseDirs(new File(start),".*");
        }

        public static Treeinfo walk(File start){
            return recurseDirs(start,".*");
        }

    }


}

class PPrint{
    public static String pformat(Collection<?> c){
        if (c.size() == 0) return "[]";
        StringBuilder result = new StringBuilder("[");
        for (Object elem:c){
            if (c.size() != 1)
                result.append("\n");
            result.append(elem);
        }

        if (c.size() != 1){
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c){
        System.out.println(pformat(Arrays.asList(c)));
    }
}

public class FileThree {

    public static void main(String[] args) {
        /*for (String arg : args){
            System.out.println(arg);
        }*/
/*        Directory.Treeinfo result = Directory.Treeinfo.walk("C:\\Users\\fcz01\\Desktop\\poi");

        for (File file:result.dirs){
            System.out.println("目录："+file.getName());
        }

        for(File file:result.files){
            System.out.println("文件："+file.getName());
        }*/

        //PPrint.pprint(Directory.Treeinfo.walk("C:\\Users\\fcz01\\Desktop\\poi").dirs);

        //PPrint.pprint(Directory.local("C:\\Users\\fcz01\\Desktop\\poi",".*"));

    }
}
