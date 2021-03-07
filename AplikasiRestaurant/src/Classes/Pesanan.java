package Classes;

public class Pesanan {
    private Menu menu;
    private int jumlah;
    private String keterangan;

    public void setKeterangan(String keterangan) { }

    public String getKeterangan() { return ""; }

    //tambahkan
    public Pesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    //tambahkan
    public Menu getMenu() {
        return menu;
    }

    //tambahkan
    public  int getJumlah(){
        return jumlah;
    }
}
