public class Main {
    public static void main(String[] args) {
        AList booksList = new AList();
        //SLList booksList = new SLList();
        //DLList booksList = new DLList();

        System.out.println(booksList.toString());

        Book book1 = new Book("Black Clover", "Yuki Tabata", 20.49);
        Book book2 = new Book("Crème Waffles for Dummies", "Piro Lane", 24.79);
        Book book3 = new Book("Wireless Networks", "Anke Berr", 14.99);

        booksList.listAdd(book1);
        booksList.listAdd(book1);
        booksList.listAdd(book2);
        booksList.listAdd(book1);

        System.out.println(booksList.toString());

        booksList.listRemove(1);

        System.out.println(booksList.toString());


        //Generic String
        GenericAList<String> stringList = new GenericAList<>();
        //GenericSLList<String> stringList = new GenericSLList<>();
        //GenericDLList<String> stringList = new GenericDLList<>();

        System.out.println(stringList.toString());

        String s1 = "Yuki Tabata";
        String s2 = "Piro Lane";
        String s3 = "Anke Berr";

        stringList.listAdd(s1);
        stringList.listAdd(s2);
        stringList.listAdd(s3);

        System.out.println(stringList.toString());

        stringList.listRemove(1);

        System.out.println(stringList.toString());

        //Generic Integer
        GenericAList<Integer> integerList = new GenericAList<>();
        //GenericSLList<Integer> integerList = new GenericSLList<>();
        //GenericDLList<Integer> integerList = new GenericDLList<>();

        System.out.println(integerList.toString());

        integerList.listAdd(1);
        integerList.listAdd(2);
        integerList.listAdd(3);

        System.out.println(integerList.toString());

        integerList.listRemove(1);

        System.out.println(integerList.toString());
    }
}