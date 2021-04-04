package DataStructures.ListsG;
// public class BST<E extends Number & Comparable<? super E>>{
//     void add(){
//     ...
//     if(data.compareTo(root.getData()) == 1)
//     ...
// }
// https://stackoverflow.com/questions/20793082/java-comparing-generic-types
class Node<T> {
    T value;
    Node<T> next;

    Node() {
    }

    Node(T value) {
        this(value, null);
    }

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
public class SinglyLinkedList<T> {
    private Node<T> head;

    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public SinglyLinkedList(Node<T> head, int size) {
        this.head = head;
        this.size = size;
    }

    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    public void insertNth(T data, int position) {
      checkBounds(position, 0, size);
      Node<T> newNode = new Node(data);
      if (head == null) {
          head = newNode;
          size++;
          return;
      }
      if (position == 0) {
          newNode.next = head;
          head = newNode;
          size++;
          return;
      }
      Node<T> cur = head;
      for (int i = 0; i < position - 1; ++i) {
          cur = cur.next;
      }
      newNode.next = cur.next;
      cur.next = newNode;
      size++;
    }

    public void insertHead(T x) {
        insertNth(x, 0);
    }

    public void insert(T data) {
        insertNth(data, size);
    }

    public void deleteNth(int position) {
        checkBounds(position, 0, size - 1);
        if (position == 0) {
            Node<T> destroy = head;
            head = head.next;
            detroy = null;
            size--;
            return;
        }
        Node<T> cur = head;
        for (int i = 0; i < position - 1; ++i) {
            cur = cur.next;
        }

        Node<T> destroy = cur.next;
        cur.next = cur.next.next;
        destroy = null;
        size--;
    }

    public void deleteHead() {
        deleteNth(0);
    }

    public void delete() {
        deleteNth(size - 1 );
    }

    public void clear() {
        Node<T> cur = head;
        while (cur != null) {
            Node<T> prev = cur;
            cur = cur.next;
            prev = null;
        }
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public int count() {
        int count = 0;
        Node<T> cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public getNth(int index) {
        checkBounds(index, 0, size -1);
        Node<T> cur = head;

        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }

        return cur.value;
    }
}