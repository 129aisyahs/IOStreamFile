package bagian3.kontak;

public class MainKontak {    
    public static void main(String[] args) {
        // Membuat objek pengelola dan mengisinya
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi",  "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi",  "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        
        System.out.println();
        
        // No. 1 - Uji cariKontak
        System.out.println("=== Cari Kontak ===");
        buku.cariKontak("Budi");
        buku.cariKontak("Zara");
        
        System.out.println();

        // No. 3 - Uji hapusKontak
        System.out.println("=== Hapus Kontak ===");
        buku.hapusKontak("Budi");
        buku.tampilkanSemua();
        
       // Muat dari berkas ke objek baru
        System.out.println("=== Muat dari Berkas ===");
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak: " + bukuLain.jumlahKontak());
    }
}