package entity;

public class Product {
    private int productid;
    private String category;
    private String name;
    private int qty;
    private float price;

    public int getProductid() {
        return productid;
    }
    public void setProductid(int id) {this.productid= id;}
    public String getProductname(){ return name;}
    public void setProductname(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getQty() {return qty;}
    public void setQty(int qty) {this.qty = qty;}

    public float getprice() {return price;}
    public void setPrice(float price){this.price = price;}
}
