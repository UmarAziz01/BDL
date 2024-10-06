

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class Transaksi {
    private String tanggal;
    private int id_transaksi;
    private int id_pelanggan;
    private int id_produk;
    private int jumlah;
    private Double total_harga;

    

    public Transaksi(String tanggal, int id_transaksi, int id_pelanggan, int id_produk, int jumlah, Double harga) {
        this.tanggal = tanggal;
        this.id_transaksi = id_transaksi;
        this.id_pelanggan = id_pelanggan;
        this.id_produk = id_produk;
        this.jumlah = jumlah;
        this.total_harga = harga;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the id_transaksi
     */
    public int getId_transaksi() {
        return id_transaksi;
    }

    /**
     * @param id_transaksi the id_transaksi to set
     */
    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    /**
     * @return the id_pelanggan
     */
    public int getId_pelanggan() {
        return id_pelanggan;
    }

    /**
     * @param id_pelanggan the id_pelanggan to set
     */
    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    /**
     * @return the id_produk
     */
    public int getId_produk() {
        return id_produk;
    }

    /**
     * @param id_produk the id_produk to set
     */
    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    /**
     * @return the jumlah
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the harga
     */
    public Double getHarga() {
        return total_harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(Double harga) {
        this.total_harga = harga;
    }

    

    
}
