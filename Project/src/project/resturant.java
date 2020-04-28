
package project;


public class resturant {
    int itemId;
    String item;
   

    public resturant(int itemId, String item) {
        this.itemId = itemId;
        this.item = item;
      
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "resturant{" + "itemId=" + itemId + ", item=" + item + '}';
    }
}
