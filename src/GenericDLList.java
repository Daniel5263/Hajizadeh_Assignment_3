public class GenericDLList<T> {
    private class Node {
        public T object;
        public Node next;
        public Node prev;

        public Node(T i) {
            object = i;
            next = null;
            prev = null;
        }
    }
    private Node head;

    public GenericDLList() {
        this.head = null;
    }

    public void listAdd(T p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = newNode;
            newNode.prev = pointer;
        }
    }

    public void listRemove(int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        if (pos == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        Node pointer = head;
        for (int i = 0; i < pos; i++) {
            if (pointer.next == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            pointer = pointer.next;
        }
        pointer.prev.next = pointer.next;
        if (pointer.next != null) {
            pointer.next.prev = pointer.prev;
        }
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