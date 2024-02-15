public class SLList {
    private SLNode head;

    public SLList() {
        this.head = null;
    }

    public void listAdd(Book p) {
        SLNode newNode = new SLNode(p);
        if (head == null) {
            head = newNode;
        } else {
            SLNode pointer = head;
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
        SLNode pointer = head;
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
        SLNode pointer = head;
        while (pointer != null) {
            sb.append("{").append("bookName:").append(pointer.book.getTitle()).append(", ")
              .append("author:").append(pointer.book.getAuthor()).append(", ")
              .append("price:").append(pointer.book.getPrice()).append("}\n");
            pointer = pointer.next;
        }
        return sb.toString();
    }
}