package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek bertipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;
    public BukuKontak(String namaBerkas) {
    this.namaBerkas = namaBerkas;
    }
    
    // Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }
    
    // Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }
    // Menyimpan seluruh kontak ke berkas, satu kontak per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        } 
    }
    
    // Membaca kembali kontak dari berkas ke dalam ArrayList
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) { // ← diganti 3 karena sekarang ada email
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2])); // ← tambah bagian[2] untuk email
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }
    
    // 1. Tambahkan method cariKontak(String nama) pada class BukuKontak yang menampilkan keterangan kontak bila ditemukan, atau pesan tidak ditemukan bila tidak ada. Uji dari class main.
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equals(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return;
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan.");
    }
    
    // 3. Tambahkan method hapusKontak(String nama) pada class BukuKontak yang menghapus kontak berdasarkan nama, kemudian panggil simpanKeBerkas agar perubahan ikut tersimpan.
    public void hapusKontak(String nama) {
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equals(nama)) {
                daftar.remove(i);
                System.out.println("Kontak " + nama + " berhasil dihapus.");
                simpanKeBerkas(); // langsung simpan perubahan
                return;
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan.");
    }
    
    public int jumlahKontak() {
        return daftar.size();
    }
}