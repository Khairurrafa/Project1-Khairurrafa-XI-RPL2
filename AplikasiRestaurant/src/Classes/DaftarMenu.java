package Classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DaftarMenu {
    private ArrayList<Menu> daftarMenu;

    public DaftarMenu() {
        daftarMenu = new ArrayList<>();
    }

    public void tambahMenu (Menu menu) {
        daftarMenu.add(menu);
    }

    public void getMenuByKategori(String kategori) {
        System.out.println("======== " + kategori + " ========");

        for (int i = 0; i < daftarMenu.size(); i++) {
            Menu m = daftarMenu.get(i);
            if (m.getKategori().equals(kategori)) {
                System.out.println((i + 1) + ". " + m.getNama_menu() + "\t" + m.getHarga());
            }
        }
    }

    public void tampilDaftarMenu() {
        System.out.println("======== ALDEBARAMEN ========");
        getMenuByKategori("Ramen");
        getMenuByKategori("Kuah");
        getMenuByKategori("Toping");
        getMenuByKategori("Minuman");
    }

    //tambah method
    public Menu pilihMenu() {
        try{
            Scanner input = new Scanner(System.in);

            System.out.print("Nomor Menu yang dipesan : ");
            int no_menu = input.nextInt();

            //get menu berdasarkan no_menu, di -1 karena arrayList mulai dari 0
            Menu m = daftarMenu.get(no_menu-1);

            //cek apakah menu kuah?
            if (!m.getKategori().equalsIgnoreCase("Kuah")) {
                return m;
            }else {
                //jika yang dipilih adalah menu kuah, maka tidak bisa, user harus memilih lagi
                System.out.println("[Err] Pesan dulu Menu Ramen");
                return pilihMenu();
            }
        } catch (IndexOutOfBoundsException err) {
            //jika no_menu tidak ada, makan akan masuk ke sini
            //mo_menu dianggap tidak ada ketika no_menu diluar dari index arrayList

            System.out.println("[Err] Pesanan Tidak Tersedia");
            //jika tidak da, maka user akan diminta untuk mengulang memasukan nomor menu
            //teknik ini disebut dengan rekursif
            return pilihMenu();
        } catch (InputMismatchException err) {
            //jika input bukan berupa angka maka akan masuk ke sini
            System.out.println("[Err] Mohon masukan nomor menu");
            return pilihMenu();
        }
    }

    public Menu pilihKuah () {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Kuah [sesuai nomor menu] : ");
            int no_menu = input.nextInt();

            //get menu berdasarkan no_menu, di -1 karena arrayList mulai dari 0
            Menu m = daftarMenu.get(no_menu-1);

            //cek apakah menu kuah?
            if (m.getKategori().equalsIgnoreCase("Kuah")) {
                return m;
            }else {
                System.out.println("[Err] Bukan Menu Kuah");
                return pilihKuah();
            }
        } catch (IndexOutOfBoundsException err) {
            //jika no_menu tidak ada, makan akan masuk ke sini
            //mo_menu dianggap tidak ada ketika no_menu diluar dari index arrayList

            System.out.println("[Err] Pesanan Tidak Tersedia");
            //jika tidak da, maka user akan diminta untuk mengulang memasukan nomor menu
            //teknik ini disebut dengan rekursif
            return pilihKuah();
        } catch (InputMismatchException err) {
            //jika input bukan berupa angka maka akan masuk ke sini
            System.out.println("[Err] Mohon masukan nomor kuah");
            return pilihKuah();
        }
    }
}
