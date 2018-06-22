public class Stack_Array {
    static class Stack{
        int maxSize;
        int indexTop = -1;
        char[] stack;

        public Stack(int maxSize){
            maxSize = maxSize;
            stack = new char[maxSize];
        }

        public void push(char c){
            stack[++indexTop] = c;
        }

        public char pop(){
            return stack[indexTop--];
        }

        public boolean isEmpty(){
            return indexTop == -1;
        }

    }

    public static void main(String[] args) {
        String src = "asdf";
        String res = "";
        int length = src.length();
        Stack stack = new Stack(length);
        for (int i = 0; i < length; i++) {
            stack.push(src.charAt(i));
        }
        for (int i = 0; i < length; i++) {
            char temp = stack.pop();
            res += temp;
        }
        System.out.println(res);
    }

}
