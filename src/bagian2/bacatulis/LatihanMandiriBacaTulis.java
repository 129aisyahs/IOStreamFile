package bagian2.bacatulis;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiriBacaTulis {
    public static void main(String[] args) {
        // SOAL Tulis 5 nama hari ke dalam berkas hari.txt (satu nama per baris), lalu baca kembali dan tampilkan ke layar.
        System.out.println("==========Soal 1==========");
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String h : hari) {
                penulis.println(h);
            }
            System.out.println("5 nama hari berhasil ditulis ke hari.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        System.out.println("\nIsi hari.txt setelah soal 1:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }

        
        // SOAL Tambahkan (append) 2 nama hari lagi ke berkas hari.txt tanpa menghapus isi sebelumnya, lalu tampilkan seluruh isinya.
        System.out.println("\n==========Soal 2==========");
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("\n2 nama hari ditambahkan tanpa menghapus data lama.");
        } catch (IOException e) {
            System.out.println("Gagal menambah: " + e.getMessage());
        }

        System.out.println("\nIsi hari.txt setelah soal 2:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }

        
        // SOAL 3. Baca berkas hari.txt lalu hitung dan tampilkan berapa banyak baris yang ada di dalamnya.
        System.out.println("\n==========Soal 3==========");
        int jumlah = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
        System.out.println("\nJumlah baris di hari.txt: " + jumlah);
    }
}