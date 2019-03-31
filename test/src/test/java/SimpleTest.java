import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimpleTest {

    @Test
    public void jsonFormat () {
        // 各种情况总Map
        Map<String, Object> dictMap = new HashMap<>();
        Set<String> sameValueSet = new HashSet<>();
        Set<String> differentValueSet = new HashSet<>();
        Set<String> firstGeneMissValueSet = new HashSet<>();
        Set<String> secondGeneMissValueSet = new HashSet<>();
        Set<String> bothMissValueSet = new HashSet<>();
        dictMap.put("sameValueSet", sameValueSet);
        dictMap.put("differentValueSet", differentValueSet);
        dictMap.put("firstGeneMissValueSet", firstGeneMissValueSet);
        dictMap.put("secondGeneMissValueSet", secondGeneMissValueSet);
        dictMap.put("bothMissValueSet", bothMissValueSet);
        sameValueSet.add("sameValueSetValue");
        differentValueSet.add("differentValueSetValue");
        firstGeneMissValueSet.add("firstGeneMissValueSetValue");
        secondGeneMissValueSet.add("secondGeneMissValueSetValue");
        bothMissValueSet.add("bothMissValueSetValue");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("210921199607211115", dictMap);
        System.out.println(JSON.toJSONString(resultMap));
    }

}
