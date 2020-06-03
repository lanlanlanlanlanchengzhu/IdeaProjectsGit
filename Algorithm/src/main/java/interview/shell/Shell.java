package interview.shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author x
 * @date 2020-06-03
 */
public class Shell {

    /**
     * 902 login lilei www.taobao.com
     * 220 login hmm s.taobao.com
     * 499 visit cde i.taobao.com
     * 879 login lilei s.taobao.com
     *
     * cat /Users/micro/jyxb_gitLab/logs/test.log | grep "login" | awk '{print $3}' | sort | uniq -c | sort -k 2r
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            File inputFile = new File("/Users/x/icode/IdeaProjectsGit/Algorithm/src/main/java/interview/shell/source");
            inputStreamReader = new InputStreamReader(new FileInputStream(inputFile));
            bufferedReader = new BufferedReader(inputStreamReader);
            List<String> content = new ArrayList<>();
            String oneLine;
            while ((oneLine = bufferedReader.readLine()) != null) {
                List<String> oneInternal = new ArrayList<>();
                oneInternal.addAll(Arrays.asList(oneLine.split(" ")));
                // grep “login”
                // awk '{print $3}'
                if (oneInternal.size() > 0 && oneInternal.contains("login") && oneInternal.size() >= 3) {
                    content.add(oneInternal.get(2));
                }
            }
            Map<String, Integer> countMap = new HashMap<>();
            content.forEach(s -> {
                if (!countMap.containsKey(s)) {
                    countMap.put(s, 0);
                }
                countMap.put(s, countMap.get(s) + 1);
            });
            List<String[]> result = new ArrayList<>();
            countMap.forEach((k, v) -> {
                String[] pair = new String[]{v.toString(), k};
                result.add(pair);
            });
            result.sort((arr1, arr2) -> {
                return arr2[0].charAt(0) - arr1[0].charAt(0);
            });
            for (String[] pair : result) {
                System.out.print(pair[0]);
                System.out.print(" ");
                System.out.print(pair[1]);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
