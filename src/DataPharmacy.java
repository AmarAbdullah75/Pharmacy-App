import java.util.ArrayList;
import java.util.List;

public class DataPharmacy {
    private List listMedicine = new ArrayList();

    public DataPharmacy(){
        this.listMedicine = new ArrayList();
    }
    public List getAll(){
        return listMedicine;
    }

    public void insertMedicine(String ID, String nama, String supplier, int qty, int price) {
        Medicine medicine = new Medicine(ID, nama, supplier, qty,price);
        listMedicine.add(medicine);
    }

    public Medicine find(List<Medicine> medicines, String id){
        for (int i = 0; i < medicines.size(); i++) {
            if(medicines.get(i).getID().equals(id)){
                return medicines.get(i);
            }
        }
        return null;
    }
    public void delete(List<Medicine> medicines, String id){
        for (int i = 0; i < medicines.size(); i++) {
            if(medicines.get(i).getID().equals(id)){
                medicines.remove(i);
            }
        }
    }

}
