import java.util.ArrayList;
import java.util.List;

public class Customer {
    public class Book_Item{
        Book_inventory book;
        int quantity;
        Book_Item(Book_inventory book,int quantity){
            this.book=book;
            this.quantity=quantity;
        }
    }
    String name,phone_number,email,address;
    List<Book_Item>myList=new ArrayList<>();
    public Customer(String name,String phone_number,String email,String address){
        this.name=name;
        this.phone_number=phone_number;
        this.email=email;
        this.address=address;
    }
    public void add(Paper_Book_inventory book,int quantity){

        myList.add(new Book_Item(book,quantity));

    }
    public void add(E_Book_inventory book){
        myList.add(new Book_Item(book,0));
    }

    public void remove(Book_inventory book){
        for(Book_Item b:myList){

            if(b.book.equals(book)){
                myList.remove(b);
                if(book instanceof Paper_Book_inventory){
                    ((Paper_Book_inventory) book).plus(b.quantity);
                }
                break;
            }
        }
    }

    public void checkOut()throws Exception{
        double amount=0,shippingFees=0;
        for(Book_Item b:myList){
            if(b.book instanceof Paper_Book_inventory){
                if(b.quantity>((Paper_Book_inventory)b.book).quantity)
                    throw new Exception(String.format("%s out of stock\n",b.book.title));
                ((Paper_Book_inventory)b.book).reduce(b.quantity);
            }
            System.out.printf("%s:",b.book.title);
            shippingFees+=b.book.deliveryService(b.quantity);
           amount+= b.book.getPrice()*(b.book instanceof Paper_Book_inventory? b.quantity:1);

        }
        System.out.printf("booksPrice= %f \n",amount);
        System.out.printf("shippingFees= %f \n",shippingFees);
        myList.clear();
    }

    public void addByIsbn(String ISBN,int quantity) throws Exception {
        boolean found=false;
        for(Book_inventory b:Book_inventory.myBooks){
            if(ISBN==b.ISBN&&b instanceof Paper_Book_inventory){this.add((Paper_Book_inventory) b,quantity);found=true;}
            else if(ISBN==b.ISBN&&b instanceof E_Book_inventory){this.add((E_Book_inventory) b);found=true;}
        }
        if(!found)throw new Exception("book is not found in store");
    }
}
