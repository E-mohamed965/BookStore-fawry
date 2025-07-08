import java.util.ArrayList;
import java.util.List;

public abstract class Book_inventory {
   public static List<Book_inventory> myBooks=new ArrayList<>();
    String ISBN,title,year;
    double price;

    public abstract boolean buy();
    public abstract double getPrice();
    public abstract double deliveryService(int quantity);

 public static List<Book_inventory> getMyBooks() {
  return myBooks;
 }
 public static void deleteOutDatedBooks(String year) {
  int currentYear = Integer.parseInt(year);
  myBooks.removeIf(b -> currentYear - Integer.parseInt(b.year) > 10);
 }

 public abstract void removeFromStore();
}


