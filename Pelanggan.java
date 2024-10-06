

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private int id_pelanggan; // harus sesuai dengan nama di tabel
    private String nama;
    private String alamat;
    private String no_telepon;
    

    public Pelanggan(int id_pelanggan, String nama, String alamat, String no_telepon) {
        this.id_pelanggan = id_pelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
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
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the no_telepon
     */
    public String getNo_telepon() {
        return no_telepon;
    }

    /**
     * @param no_telepon the no_telepon to set
     */
    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
}
