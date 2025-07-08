public class Demo_Book_inventory extends Book_inventory{
    public Demo_Book_inventory(String ISBN,String title,String year){
        this.ISBN=ISBN;
        this.title=title;
        this.year=year;
        myBooks.add(this);

    }
    @Override
    public boolean buy() {
        return false;
    }

    @Override
    public double deliveryService(int quantity){
        System.out.println("not for sale");
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
        return 0;
    }
}
