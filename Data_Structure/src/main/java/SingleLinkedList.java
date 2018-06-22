public class SingleLinkedList {

    private class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
        }
    }

    int size;
    Node head;

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    //在头部增加节点
    public Object addHead(Object obj){

        Node newNode = new Node(obj);

        if(size == 0){
            //链表为空
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
        return obj;
    }

    //删除表头节点
    public Object delHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查询节点是否存在
    public Object getNode(Object obj){
        Node current = head;
        int tempSize = size;
        while (tempSize > 0){
            if(current.data == obj){
                return obj;
            }else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定节点
    public boolean delNode(Object obj){
        if(size == 0){
            return false;
        }
        Node current = head;
        Node previous = head;
        while(current.data != obj){
            if(current.next == null){
                return false;
            }else {
                previous = current;
                current = current.next;
            }
        }
        previous.next = current.next;
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //展示链表
    public void printLinkedList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

}
