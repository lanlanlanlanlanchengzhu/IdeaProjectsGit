/**
 * @author xiasiyu
 * @desc
 * @create 2018/04/10 0:02
 **/
public class IntArrayGetMoreThanOne {

    public static void main(String[] args) {
        int[] a = {1,2,2,2,3};
        int halfSize = a.length / 2;
        int count = 0;
        int result;

        for (int i = 0; i < halfSize; i++) {
            for (int j = 0; j < halfSize; j++) {
                if(a[i] != a[j]){
                    i++;
                }
            }
        }
    }

}
