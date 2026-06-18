// Nama  : Aisya Salsabila Nur Rohmah
// NPM   : 2410010053

package tugas;

public class MainTugas {
    public static void main(String[] args) {

        // Array kategori (ukuran tetap, minimal 3)
        String[] kategori = {"Elektronik", "Makanan", "Minuman", "Peralatan", "Pakaian"};
        System.out.println("== Kategori Barang ==");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }

        System.out.println();

        // Buat gudang dan tambah minimal 5 barang
        Gudang gudang = new Gudang("barang.txt");
        gudang.tambahBarang(new Barang("Laptop",    8500000, 10));
        gudang.tambahBarang(new Barang("Mie Instan",    3000,  200));
        gudang.tambahBarang(new Barang("Air Mineral",   5000,  150));
        gudang.tambahBarang(new Barang("Sapu",         25000,   50));
        gudang.tambahBarang(new Barang("Kaos Polos",   75000,   30));

        // Tampilkan dan simpan ke berkas
        gudang.tampilkanSemua();
        System.out.println("Total Nilai Persediaan: Rp" + gudang.totalNilai());
        gudang.simpanKeBerkas();

        System.out.println();

        // Buat objek baru, muat dari berkas, buktikan data tersimpan
        System.out.println("=== Memuat ulang dari berkas ===");
        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        gudangBaru.tampilkanSemua();
        System.out.println("Total Nilai Persediaan: Rp" + String.format("%.0f", gudang.totalNilai()));
    }
}