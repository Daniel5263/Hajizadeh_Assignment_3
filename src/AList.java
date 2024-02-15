public class AList {
    private Book[] books;
    private int size;
    private static final int INITIAL_SIZE = 10;

    public AList() {
        books = new Book[INITIAL_SIZE];
        size = 0;
    }

    public void listAdd(Book p) {
        if (size == books.length) {
            Book[] newBooks = new Book[books.length * 2];
            for (int i = 0; i < size; i++) {
                newBooks[i] = books[i];
            }
            books = newBooks;
        }
        books[size] = p;
        size++;
    }

    public void listRemove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
            for (int i = pos; i < size - 1; i++) {
                books[i] = books[i + 1];
            }
            books[size - 1] = null;
            size--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("{").append("bookName:").append(books[i].getTitle()).append(", ")
              .append("author:").append(books[i].getAuthor()).append(", ")
              .append("price:").append(books[i].getPrice()).append("}\n");
        }
        return sb.toString();
    }
}