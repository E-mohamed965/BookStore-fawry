public class Test {
    public static void testSuccessfulPayment(){
        Customer c=new Customer("kilaney","01024345355","kilaney@gmail.com","cairo");

        Paper_Book_inventory b=new Paper_Book_inventory("firstBook","head first java","2014",30,22);
        E_Book_inventory b1=new E_Book_inventory("secondBook","head first java","2012",20);
        c.add(b,10);
        c.add(b1);
        try{
            c.checkOut();}
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    public static void testOutOfStock(){
        Customer c=new Customer("kilaney","01024345355","kilaney@gmail.com","cairo");

        Paper_Book_inventory b=new Paper_Book_inventory("firstBook","head first java","2014",30,22);
        E_Book_inventory b1=new E_Book_inventory("secondBook","head first java","2012",20);
        c.add(b,49);
        try{
            c.checkOut();}
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    public static void testNotFoundBook(){
        Customer c=new Customer("kilaney","01024345355","kilaney@gmail.com","cairo");

        Paper_Book_inventory b=new Paper_Book_inventory("firstBook","head first java","2014",30,22);
        E_Book_inventory b1=new E_Book_inventory("secondBook","head first java","2012",20);
       b.removeFromStore();
        try {
            c.addByIsbn("firstBook",2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void testRemoveOutDatedBooks(){
        Book_inventory.myBooks.clear();
        Paper_Book_inventory b=new Paper_Book_inventory("firstBook","head first java","2014",30,22);
        E_Book_inventory b1=new E_Book_inventory("secondBook","head first java","2012",20);
        for (Book_inventory book:Book_inventory.getMyBooks()){
            System.out.println(book.ISBN);
        }
        Book_inventory.deleteOutDatedBooks("2024");
        System.out.println("remaining books");
        for (Book_inventory book:Book_inventory.getMyBooks()){
            System.out.println(book.ISBN);
        }
    }
}
