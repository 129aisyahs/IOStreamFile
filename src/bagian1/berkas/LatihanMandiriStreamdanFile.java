package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiriStreamdanFile {
    public static void main(String[] args) {
        //1. Buat objek File yang menunjuk laporan.txt. Tampilkan apakah berkas tersebut ada, dan jika ada tampilkan ukurannya dalam byte.
        System.out.println("==================Soal 1===============================");
        File berkas = new File("laporan.txt");
        if (berkas.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkas.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak di temukan.");
        }
        
        //2. Buat sebuah folder baru bernama arsip menggunakan method mkdir(). Tampilkan pesan berhasil atau gagal berdasarkan nilai yang dikembalikan method tersebut.
        System.out.println("\n=================Soal 2==============================");
        File folder = new File("arsip");
        if (folder.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Gagal membuat folder (mungkin sudah ada).");
        }
        
        //3. Buat objek File sementara.txt, buat berkasnya, lalu hapus kembali dengan method delete(). Tampilkan status keberadaan berkas sebelum dan sesudah dihapus.
        System.out.println("\n=================Soal 3==============================");
        berkas = new File("sementara.txt");
        try {
            berkas.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + berkas.exists());
            berkas.delete();
            System.out.println("Sesudah dihapus, ada? " + berkas.exists());
        } catch (IOException e) {
            System.out.println("kesalahan: " + e.getMessage());
        }
        
    }
}
    