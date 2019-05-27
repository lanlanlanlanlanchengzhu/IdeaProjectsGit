public class TestV1 {
    {
        a=6;
    }
    int a=9;
    int b=5;
    {
        b=7;
    }

    public static void main(String[] args) {
        System.out.println(new TestV1().a);//9
        System.out.println(new TestV1().b);//7

    }

}
