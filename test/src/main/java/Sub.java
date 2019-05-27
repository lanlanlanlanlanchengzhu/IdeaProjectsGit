class Sub extends Base{
    private String name="sada";

    public String test(){
        return"子类重写父类的方法"+"其name字符的长度为"+name.length();
    }
    public static void main(String[] args){
        Sub s=new Sub();

        System.out.println(s.test());

    }
}