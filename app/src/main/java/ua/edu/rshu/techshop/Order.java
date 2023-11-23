package ua.edu.rshu.techshop;

public class Order {

    //ім'я користувача
    private String userName;
    //вибраний ним товар
    private String selectedProduct;
    //кылькысть вибраного товару
    private int countProduct;
    //ціна за одиницю товару
    private double priceByProduct;

    public Order() {
        this.userName = "None";
        this.selectedProduct = "None";
        this.countProduct = 0;
        this.priceByProduct = 0.0;
    // або просто:
    // this("None","None",0,0.0);
    }

    public Order(String userName, String selectedProduct, int countProduct, double priceByProduct) {
        this.userName = userName;
        this.selectedProduct = selectedProduct;
        this.countProduct = countProduct;
        this.priceByProduct = priceByProduct;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setSelectedProduct(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setPriceByProduct(double priceByProduct) {
        this.priceByProduct = priceByProduct;
    }

    public double getPriceByProduct() {
        return priceByProduct;
    }
}
