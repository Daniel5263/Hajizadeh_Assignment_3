public class GenericSLList<T> {
    private class Node {
        public T object;
        public Node next;

        public Node(T i, Node n) {
            object = i;
            next = n;
        }
    }
    private Node head;
    private int size;

    public GenericSLList() {
        this.head = null;
        size = 0;
    }

    public void listAdd(T p) {
        Node newNode = new Node(p, null);
        if (head == null) {
            head = newNode;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = newNode;
        }
    }

    public void listRemove(int pos) {
        if (pos < 0 || head == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        if (pos == 0) {
            head = head.next;
            return;
        }
        Node pointer = head;
        for (int i = 0; i < pos - 1; i++) {
            if (pointer.next == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder nonBookObjects = new StringBuilder();
        Node pointer = head;
        while (pointer != null) {
            if (pointer.object instanceof Book book) {
                sb.append("{").append("bookName:").append(book.getTitle()).append(", ")
                        .append("author:").append(book.getAuthor()).append(", ")
                        .append("price:").append(book.getPrice()).append("}\n");
            } else {
                nonBookObjects.append(pointer.object.toString());
                if (pointer.next != null) {
                    nonBookObjects.append(", ");
                }
            }
            pointer = pointer.next;
        }
        if (!nonBookObjects.isEmpty()) {
            sb.append("{").append(nonBookObjects).append("}");
        }
        return sb.toString();
    }
}