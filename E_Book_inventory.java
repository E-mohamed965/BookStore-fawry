public class E_Book_inventory extends Book_inventory{
    public E_Book_inventory(String ISBN,String title,String year,double price){
        this.ISBN=ISBN;
        this.title=title;
        this.year=year;
        this.price=price;
        myBooks.add(this);
    }
    @Override
    public boolean buy() {
        return true;
    }
    @Override
   public double deliveryService(int quantity){
       System.out.println("sent to mail service");
       return 0;
   }
    @Override
    public void removeFromStore() {
        for(Book_inventory b:Book_inventory.myBooks){
            if(this.ISBN==b.ISBN)myBooks.remove(b);
        }
    }
    @Override
    public double getPrice() {
        return this.price;
    }
}
