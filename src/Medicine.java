public class Medicine {
    private String ID;
    private String nama;
    private String supplier;
    private int qty;
    private int price;

    public Medicine() {
    }

    public Medicine(String ID, String nama, String supplier, int qty, int price) {
        this.ID = ID;
        this.nama = nama;
        this.supplier = supplier;
        this.qty = qty;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
