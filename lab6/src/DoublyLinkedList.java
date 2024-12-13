import java.util.*;

/**
 * A custom doubly linked list implementation for managing Flower objects.
 */
class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    /**
     * Node constructor.
     *
     * @param data The value to store in this node.
     */
    Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList<T extends Flower> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructs an empty DoublyLinkedList.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructs a DoublyLinkedList with a single element.
     *
     * @param data The element to add to the list.
     */
    public DoublyLinkedList(T data) {
        this();
        insertAtEnd(data);
    }

    /**
     * Constructs a DoublyLinkedList with elements from a given collection.
     *
     * @param collection The collection of elements to add to the list.
     */
    public DoublyLinkedList(Collection<T> collection) {
        this();
        for (T item : collection) {
            insertAtEnd(item);
        }
    }

    /**
     * Adds a new element at the beginning of the list.
     *
     * @param data The element to add.
     */
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds a new element at the end of the list.
     *
     * @param data The element to add.
     */
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserts an element at a specific position.
     *
     * @param data     The element to add.
     * @param position The position to insert the element at (1-based index).
     */
    public void insertAtPosition(T data, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        if (position == 1) {
            insertAtBeginning(data);
        } else if (position == size + 1) {
            insertAtEnd(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            size++;
        }
    }

    /**
     * Removes the first element of the list.
     */
    public void deleteAtBeginning() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
    }

    /**
     * Removes the last element of the list.
     */
    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        size--;
    }

    /**
     * Removes an element at a specific position.
     *
     * @param position The position of the element to remove (1-based index).
     */
    public void deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        if (position == 1) {
            deleteAtBeginning();
        } else if (position == size) {
            deleteAtEnd();
        } else {
            Node<T> current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = current.prev = null;
            size--;
        }
    }

    /**
     * Displays the list elements.
     */
    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
