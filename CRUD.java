

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CRUD {

    Connection cn;
    PreparedStatement ps;
    Statement st;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/A_BDL_UTS";
    String user = "postgres";
    String password = " ";
    
    private String infoBegin,infoEnd,infoRollback,info;

    public CRUD() {

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(koneksi, user, password);
            System.out.println("Koneksi Sukses");
            // cn.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean tambahPelanggan(int idPe, String namaPe, String alamatPe, String noPe) {
        String sql = "INSERT INTO Pelanggan (id_pelanggan, nama, alamat, no_telepon) VALUES (?, ?, ?, ?)";
        try {

            ps = cn.prepareStatement(sql);
            ps.setLong(1, idPe);
            ps.setString(2, namaPe);
            ps.setString(3, alamatPe);
            ps.setString(4, noPe);
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean tambahProduk(int idPr, String namaPr, Double hargaPr) {
        String sql = "INSERT INTO Produk (id_produk, nama_produk, harga) VALUES (?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idPr);
            ps.setString(2, namaPr);
            ps.setDouble(3, hargaPr);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean tambahTransaksi(String tanggal, int id_transaksi, int id_pelanggan, int id_produk, int jumlah, Double harga) {
        String sql = "INSERT INTO transaksi (tanggal, id_transaksi, id_pelanggan, id_produk, jumlah, total_harga) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, tanggal);
            ps.setInt(2, id_transaksi);
            ps.setInt(3, id_pelanggan);
            ps.setInt(4, id_produk);
            ps.setInt(5, jumlah);
            ps.setDouble(6, harga);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Pelanggan> tampilPelanggan() {//list nama class
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM Pelanggan";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Pelanggan peList = new Pelanggan( //nama class
                        rs.getInt("id_pelanggan"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon")
                );
                list.add(peList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Produk> tampilProduk() {//list nama class
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM Produk";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Produk n = new Produk( //nama class
                        rs.getInt("id_produk"),
                        rs.getString("nama_produk"),
                        rs.getDouble("harga")
                );
                listProduk.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduk;
    }

    public List<Transaksi> tampilTransaksi() {//list nama class
        List<Transaksi> listTransaksi = new ArrayList<>();
        String sql = "SELECT * FROM Transaksi";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Transaksi t = new Transaksi( //nama class
                        rs.getString("tanggal"),
                        rs.getInt("id_transaksi"),
                        rs.getInt("id_pelanggan"),
                        rs.getInt("id_produk"),
                        rs.getInt("jumlah"),
                        rs.getDouble("total_harga")
                );
                listTransaksi.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTransaksi;
    }

    public boolean hapusPelanggan(int id) {
        String sql = "DELETE FROM Pelanggan WHERE id_pelanggan = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean hapusProduk(int id) {
        String sql = "DELETE FROM Produk WHERE id_produk = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean hapusTransaksi(int id) {
        String sql = "DELETE FROM transaksi WHERE id_transaksi = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updatePelanggan(int id, String nama, String alamat, String no) {
        String sql = "UPDATE pelanggan SET nama = ?, alamat = ?, no_telepon = ? WHERE id_pelanggan = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, alamat);
            ps.setString(3, no);
            ps.setInt(4, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateProduk(int id, String nama, Double harga) {
        String sql = "UPDATE produk SET nama_produk = ?, harga = ? WHERE id_produk = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setDouble(2, harga);
            ps.setInt(3, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateTransaksi(String tanggal, int id_transaksi, int id_pelanggan, int id_produk, int jumlah, Double harga) {
        String sql = "UPDATE transaksi SET tanggal = ?, id_pelanggan=?, id_produk=?, jumlah=?, total_harga=? WHERE id_transaksi= ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, tanggal);
            ps.setInt(2, id_pelanggan);
            ps.setInt(3, id_produk);
            ps.setInt(4, jumlah);
            ps.setDouble(5, harga);
            ps.setInt(6, id_transaksi);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void hapusSemuaPelanggan() {
        String sql = "DELETE FROM pelanggan";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapusSemuaProduk() {
        String sql = "DELETE FROM produk";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapusSemuaTransaksi() {
        String sql = "DELETE FROM transaksi";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pelanggan cariDataByIdPelanggan(int id) throws DataTidakDitemukanException {// public nama class
        String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Pelanggan( // new .. nama class
                        rs.getInt("id_pelanggan"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon")
                );
            } else {
                throw new DataTidakDitemukanException("Data dengan ID Pelanggan " + id + " tidak ditemukan.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DataTidakDitemukanException("Terjadi kesalahan saat mencari data.");
        }
    }

    public Produk cariDataByIdProduk(int id) throws DataTidakDitemukanException {
        String sql = "SELECT * FROM produk WHERE id_produk = ?";

        try {
            // Pastikan 'cn' adalah instance dari Connection yang benar
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Mengembalikan objek Produk jika ditemukan
                return new Produk(
                        rs.getInt("id_produk"),
                        rs.getString("nama_produk"),
                        rs.getDouble("harga")
                );
            } else {
                // Jika data tidak ditemukan, lemparkan exception
                throw new DataTidakDitemukanException("Data dengan ID Produk " + id + " tidak ditemukan.");
            }
        } catch (SQLException ex) {
            // Tangkap error SQL
            throw new DataTidakDitemukanException("Terjadi kesalahan saat mencari data: " + ex.getMessage());
        }
    }

    public Transaksi cariDataByIdTransaksi(int idTransaksi) throws DataTidakDitemukanException {// public nama class
        String sql = "SELECT * FROM transaksi WHERE id_transaksi = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idTransaksi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Transaksi(// new .. nama class
                        rs.getString("tanggal"),
                        rs.getInt("id_transaksi"),
                        rs.getInt("id_pelanggan"),
                        rs.getInt("id_produk"),
                        rs.getInt("jumlah"),
                        rs.getDouble("total_harga")
                );
            } else {
                throw new DataTidakDitemukanException("Data dengan ID Transaksi " + idTransaksi + " tidak ditemukan.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DataTidakDitemukanException("Terjadi kesalahan saat mencari data.");
        }
    }
    
    public Produk cariHargaByIdProduk(int id) throws DataTidakDitemukanException {
    String sql = "SELECT id_produk, nama_produk, harga FROM produk WHERE id_produk = ?";

    try {
        ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Mengembalikan objek Produk jika ditemukan
            return new Produk(
                    rs.getInt("id_produk"),
                    rs.getString("nama_produk"),
                    rs.getDouble("harga")
            );
        } else {
            // Jika data tidak ditemukan, lemparkan exception
            throw new DataTidakDitemukanException("Data dengan ID Produk " + id + " tidak ditemukan.");
        }
    } catch (SQLException ex) {
        // Tangkap error SQL
        throw new DataTidakDitemukanException("Terjadi kesalahan saat mencari data: " + ex.getMessage());
    }
}
    

    public void tutupKoneksi() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
            System.out.println("Koneksi Sudah Ditutup");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void beginSql() {
        try {
            // Menonaktifkan auto-commit (Memulai transaksi)
            cn.setAutoCommit(false);
            infoBegin="Transaksi dimulai. Auto-commit dimatikan.";
            System.out.println(infoBegin);
        } catch (SQLException e) {
            System.out.println("Gagal memulai transaksi");
        }
    }
    
    public void endSql() {
        try {
            // Menonaktifkan auto-commit (Memulai transaksi)
             cn.commit();
             infoEnd="Transaksi berhasil disimpan. Auto-commit dihidupkan.";
            System.out.println("Transaksi berhasil disimpan. Auto-commit dihidupkan.");
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan transaksi. Auto-commit dihidupkan.");
        }
    }
    
    public void rollbackSql() {
        try {
            // Menonaktifkan auto-commit (Memulai transaksi)
             cn.rollback();
            System.out.println("Transaksi dibatalkan. Auto-commit dihidupkan.");
        } catch (SQLException e) {
            System.out.println("Gagal membatalkan transaksi. Auto-commit dihidupkan.");
        }
    }
    
//    public infoBegin(){
//        info = infoBegin;
//    }
}
