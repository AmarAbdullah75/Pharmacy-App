import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyPharmacyApp {
    private int choice;
    Scanner scan = new Scanner(System.in);
    DataPharmacy data = new DataPharmacy();

    public void getMenus() {
        System.out.println("+====================+");
        System.out.println("    My Pharmacy App");
        System.out.println("+====================+");
        System.out.println(" 1. Menambahkan Obat");
        System.out.println(" 2. Menampilkan Obat");
        System.out.println(" 3. Mengubah data Obat");
        System.out.println(" 4. Menghapus data Obat");
        System.out.println(" 5. Keluar");
        System.out.println("+====================+");
        System.out.print("Pilihan: ");
        getChoice(scan.nextInt());
    }

    public void getChoice(int choice) {
        switch (choice) {
            case 1:scan.nextLine();addMedicine();break;
            case 2:displayMedicine();break;
            case 3:scan.nextLine();updateMedicine();break;
            case 4:scan.nextLine();deleteMedicine();break;
            case 5: System.out.println("Thank you for using app!");break;
            default: System.out.println("Inccorect Menu!");
        }
    }

    private void addMedicine() {
        System.out.println("+====================+");
        System.out.println("     Add Medicine");
        System.out.println("+====================+");
        Medicine medicine = new Medicine();
        System.out.print("Medicine ID   :");
        medicine.setID(scan.nextLine());
        System.out.print("Name          :");
        medicine.setNama(scan.nextLine());
        System.out.print("Supplier      :");
        medicine.setSupplier(scan.nextLine());
        System.out.print("Quantity      :");
        medicine.setQty(scan.nextInt());
        System.out.print("Price         :");
        medicine.setPrice(scan.nextInt());
        data.insertMedicine(medicine.getID(), medicine.getNama(), medicine.getSupplier(), medicine.getQty(), medicine.getPrice());
        System.out.println("+=========================+");
        System.out.println("Medicine added succecfully!");
        System.out.println("+=========================+");
        System.out.print("Add more data?[Y/N]");
        char val = scan.next().charAt(0);
        scan.nextLine();
        if (val == 'y' || val == 'Y') {
            addMedicine();
        } else if (val == 'n' || val == 'N') {
            getMenus();
        }
    }

    private void displayMedicine() {
        System.out.println("+====================+");
        System.out.println("    Display Medicine");
        System.out.println("+====================+");
        System.out.println("=====================================" +
                "=====================");
        System.out.println("No\tMedicine ID\t\tName\t\t\t\t\tSupplier\t\tQty\t\tPrice");
        System.out.println("==========================================" +
                "=====================================================");
        List listMedicine = new ArrayList();
        listMedicine = data.getAll();

        for (int i = 0; i < listMedicine.size(); i++) {
            Medicine a = (Medicine) listMedicine.get(i);
            System.out.println(i + 1 + "\t" + a.getID() + "\t\t" + a.getNama() + "\t\t" + a.getSupplier()
                    + "\t\t" + a.getQty() + "\t\t" + a.getPrice());
        }
        System.out.println("==========================================" +
                "=====================================================");
        System.out.print("Keep looking this data?[Y/N]");
        char val = scan.next().charAt(0);
        scan.nextLine();
        if (val == 'y' || val == 'Y') {
            displayMedicine();
        } else if (val == 'n' || val == 'N') {
            getMenus();
        }
    }

    public void updateMedicine() {
        System.out.println("+====================+");
        System.out.println("    Update Medicine");
        System.out.println("+====================+");
        List listMedicine = new ArrayList();
        listMedicine = data.getAll();
        DataPharmacy data = new DataPharmacy();
        System.out.print(" ID Medicine : ");
        String id = scan.nextLine();
        Medicine medicine = data.find(listMedicine, id);
        if (medicine != null) {
            System.out.println(" ID           : " + medicine.getID());
            System.out.println(" Name         : " + medicine.getNama());
            System.out.println(" Supplier     : " + medicine.getSupplier());
            System.out.println(" Quantity     : " + medicine.getQty());
            System.out.println(" Price        : " + medicine.getPrice());
            System.out.println("+=========================================+");
            System.out.print(" Name         :");
            medicine.setNama(scan.nextLine());
            System.out.print(" Supplier     :");
            medicine.setSupplier(scan.nextLine());
            System.out.print(" Quantity     :");
            medicine.setQty(scan.nextInt());
            System.out.print(" Price        :");
            medicine.setPrice(scan.nextInt());
            System.out.println(" ===Detail Berhasil diubah!===");
        } else {
            System.out.println(" Data not found!");
        }
        System.out.print(" Update another medicine?[Y/N] ");
        char val = scan.next().charAt(0);
        scan.nextLine();
        if (val == 'y' || val == 'Y') {
            updateMedicine();
        } else if (val == 'n' || val == 'N') {
            getMenus();
        }
    }
    public void deleteMedicine(){
        System.out.println("+====================+");
        System.out.println("    Delete Medicine");
        System.out.println("+====================+");
        List listMedicine = new ArrayList();
        listMedicine = data.getAll();
        DataPharmacy data = new DataPharmacy();
        System.out.print(" ID Medicine : ");
        String id = scan.nextLine();
        Medicine medicine = data.find(listMedicine, id);
        if (medicine != null) {
            System.out.println(" ID           : " + medicine.getID());
            System.out.println(" Name         : " + medicine.getNama());
            System.out.println(" Supplier     : " + medicine.getSupplier());
            System.out.println(" Quantity     : " + medicine.getQty());
            System.out.println(" Price        : " + medicine.getPrice());
            System.out.println("+=========================================+");
            data.delete(listMedicine,id);
            System.out.println(" ===Data berhasil dihapus!===");
        } else {
            System.out.println(" Data not found!");
        }
        System.out.print(" Delete another medicine?[Y/N] ");
        char val = scan.next().charAt(0);
        scan.nextLine();
        if (val == 'y' || val == 'Y') {
            deleteMedicine();
        } else if (val == 'n' || val == 'N') {
            getMenus();
        }
    }
    public static void main(String[] args) {

        MyPharmacyApp app = new MyPharmacyApp();
        app.getMenus();
//        ArrayList arrayList = new ArrayList<>();
//
//        System.out.println("Jumlah data awal: "+arrayList.size());
//        System.out.println("");
//
//        arrayList.add("Sanmol");
//        arrayList.add("Promag");
//        arrayList.add("Bodrexin");
//        arrayList.add("Antalgin");
//        arrayList.add("Tolak Angin");
//
//        System.out.println("Jumlah data awal: "+arrayList.size());
//
//        System.out.println("Data My PharmacyL "+arrayList);
//        System.out.println("");
//
//        arrayList.remove("Promag");
//
//        System.out.println("Jumlah data setelah dihapus: "+arrayList.size());
//
//        System.out.println("Data My Pharmacy setelah dihapus:"+arrayList);
    }
}
