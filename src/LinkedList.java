/**
 * Created by afuller on 11/1/15.
 */
public class LinkedList {

    private Node n;

    public static void main(String[] args) {
        int[] numbers = {2, 1, 6};
        int[] numbers2 = {3, 1, 2};
        LinkedList list1 = new LinkedList(numbers);
        LinkedList list2 = new LinkedList(numbers2);

    }

    public LinkedList(int[] numbers) {
        Node n = new Node(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            n.appendToTail(numbers[i]);
        }
        this.n = n;
    }

    public boolean delete(Node node) {
        if (node.next == null || node == null) {
            return false;
        } else {
            Node next = node.next;
            node.data = next.data;
            node.next = next;
            return true;
        }
    }

    public Node getNodeAtPosition(int d) {
        Node node = this.n;
        while (d > 0 && node.next != null) {
            node = node.next;
            d--;
        }
        return node;
    }

    @Override
    public String toString() {
        Node node = this.n;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.getData());
            sb.append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        public Node() {}

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        int getData() {
            return this.data;
        }
    }

}
