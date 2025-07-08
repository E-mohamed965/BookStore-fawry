public class Paper_Book_inventory extends Book_inventory{

    int quantity;
    public Paper_Book_inventory(String ISBN,String title,String year,double price,int quantity){
        this.ISBN=ISBN;
        this.title=title;
        this.year=year;
        this.price=price;
        this.quantity=quantity;
        myBooks.add(this);
    }
    @Override
    public boolean buy() {
        return true;
    }
    @Override
    public double deliveryService(int quantity){

        System.out.println("sent to shipping service");
        return price*quantity*.01;
    }

    @Override
    public void removeFromStore() {
        for(Book_inventory b:Book_inventory.myBooks){
            if(this.ISBN==b.ISBN)myBooks.remove(b);
        }
    }

    public void reduce(int quantity){
        this.quantity-=quantity;
        if(this.quantity==0)myBooks.remove(this);
   }
    public void plus(int quantity){
        this.quantity+=quantity;
    }
    @Override
    public double getPrice() {
        return this.price;
    }
}
