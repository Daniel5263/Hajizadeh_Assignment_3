public class DLList {
    private DLNode head;

    public DLList() {
        this.head = null;
    }

    public void listAdd(Book p) {
        DLNode newNode = new DLNode(p);
        if (head == null) {
            head = newNode;
        } else {
            DLNode pointer = head;
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
        DLNode pointer = head;
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
        DLNode pointer = head;
        while (pointer != null) {
            sb.append("{").append("bookName:").append(pointer.book.getTitle()).append(", ")
              .append("author:").append(pointer.book.getAuthor()).append(", ")
              .append("price:").append(pointer.book.getPrice()).append("}\n");
            pointer = pointer.next;
        }
        return sb.toString();
    }
}