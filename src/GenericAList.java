public class GenericAList<T> {
    private T[] objects;
    private int size;
    private static final int INITIAL_SIZE = 10;

    public GenericAList() {
        objects = (T[]) new Object[INITIAL_SIZE];
        size = 0;
    }

    public void listAdd(T p) {
        if (size == objects.length) {
            T[] newObjects = (T[]) new Object[objects.length * 2];
            for (int i = 0; i < size; i++) {
                newObjects[i] = objects[i];
            }
            objects = newObjects;
        }
        objects[size] = p;
        size++;
    }

    public void listRemove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        for (int i = pos; i < size - 1; i++) {
            objects[i] = objects[i + 1];
        }
        objects[size - 1] = null;
        size--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder nonBookObjects = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (objects[i] instanceof Book book) {
                sb.append("{").append("bookName:").append(book.getTitle()).append(", ")
                        .append("author:").append(book.getAuthor()).append(", ")
                        .append("price:").append(book.getPrice()).append("}\n");
            } else {
                nonBookObjects.append(objects[i]);
                if (i < size - 1) {
                    nonBookObjects.append(", ");
                }
            }
        }
        if (!nonBookObjects.isEmpty()) {
            sb.append("{").append(nonBookObjects).append("}");
        }
        return sb.toString();
    }
}