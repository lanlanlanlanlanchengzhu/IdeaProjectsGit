import static org.junit.Assert.*;

public class SingleLinkedListTest {

    @org.junit.Test
    public void printLinkedList() {
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");

        singleLinkedList.delHead();

        System.out.println("getNode:" + singleLinkedList.getNode("A"));

        singleLinkedList.printLinkedList();
    }

}