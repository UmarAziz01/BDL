

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class Produk {

    private int id_produk;
    private String nama;
    private Double harga;

    public Produk(int id_produk, String nama, Double harga) {
        this.id_produk = id_produk;
        this.nama = nama;
        this.harga = harga;
    }

    /**
     * @return the id
     */
    public int getId_produk() {
        return id_produk;
    }

    /**
     * @param id_produk the id to set
     */
    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the harga
     */
    public Double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(Double harga) {
        this.harga = harga;
    }

    
    
}
