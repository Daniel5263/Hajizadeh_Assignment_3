public class DLNode {
    Book book;
    DLNode next;
    DLNode prev;

    public DLNode(Book book) {
        this.book = book;
        this.next = null;
        this.prev = null;
    }
}