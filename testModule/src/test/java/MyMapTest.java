import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class MyMapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        Integer i1 = 1;
        Integer i2 = 2;
        map.put(i1,"123");
        map.put(i2,"abc");

        String jsonData = JSON.toJSONString(map);
        System.out.println(jsonData);
    }
}
