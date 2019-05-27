public class Overload {
	public void test(String msg){
		System.out.println("只有一个字符串参数的test方法");
	}
	public void test(String...books){
		System.out.println("****形参个数可变的test方法****");
	}

	public static void main(String[] args) {
		Overload ol=new Overload();
		ol.test();
		ol.test("aa","bb");
		ol.test("aa");
		ol.test(new String[]{"aa"});

	}

}