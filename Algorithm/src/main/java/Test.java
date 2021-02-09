import java.util.Arrays;
import java.util.Comparator;

/**
 * @author x
 * @date 2020-06-19
 */
public class Test {

    public static void main(String[] args) {
        int[][] tmp = new int[10][10];
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
    }


}
