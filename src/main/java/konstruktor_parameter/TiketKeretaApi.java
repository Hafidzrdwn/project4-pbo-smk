package konstruktor_parameter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Hafidz Ridwan
 */
class SistemTiketKeretaApi {
    public int kelas, jumlah_penumpang, total_harga, uang_bayar, kembalian;
    public String ket_bayar;
    Scanner scan = new Scanner(System.in);
    
    public SistemTiketKeretaApi(int kelas, int jumlah_penumpang) {
        this.kelas = kelas;
        this.jumlah_penumpang = jumlah_penumpang;
        
        this.outputStruk();
    }
    
    private String toRupiahWithRP(String price) {
        int newPrice = Integer.parseInt(price);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(newPrice);
    }
    
    private String kelasKereta(int kelas) {
        String result;
        switch(kelas){
            case 1:
                result = "EKONOMI";
                break;
            case 2:
                result = "BISNIS";
                break;
            case 3:
                result = "EKSEKUTIF";
                break;
            default:
                result = "";
        }
        
        return result;
    }
    
    private int processHarga() {
        int price;
        switch(this.kelas){
            case 1:
                price = 15000;
                break;
            case 2:
                price = 80000;
                break;
            case 3:
                price = 110000;
                break;
            default:
                price = 0;
        }
        this.total_harga = price * this.jumlah_penumpang;
        return price;
    }
    
    public static void daftar_kelas() {
        System.out.println("\nSistem Tiket Kereta Api Sby - Malang");
        System.out.println("Daftar Kelas : ");
        System.out.println("1. Ekonomi(Rp. 15.000)");
        System.out.println("2. Bisnis(Rp. 80.000)");
        System.out.println("3. Eksekutif(Rp. 110.000)");
    }
    
    private void outputStruk() {
        System.out.println("\n----------Struk Kereta Api Sby - Malang----------\n");
        System.out.println("Kelas Kereta : "+ this.kelasKereta(this.kelas));
        System.out.println("Tujuan : Surabaya - Malang");
        System.out.println("Jumlah Penumpang : "+ this.jumlah_penumpang + " orang");
        System.out.println("Harga Tiket : "+ this.toRupiahWithRP(Integer.toString(this.processHarga())));
        System.out.println("Total Harga : " + this.toRupiahWithRP(Integer.toString(this.total_harga)));
        System.out.println("\n----------Terimakasih, Silahkan Membayar---------");
        this.inputBayar();
    }
    
    public void inputBayar() {
        System.out.print("Masukkan uang anda = ");
        this.uang_bayar = this.scan.nextInt();
        this.outputKembalian();
    }
    
    private boolean processUang() {
        if(this.uang_bayar >= this.total_harga){
            this.kembalian = this.uang_bayar - this.total_harga;
            this.ket_bayar = "Selamat, Transaksi Anda Telah Berhasil!!";
            return true;
        }else {
            this.kembalian = 0;
            this.ket_bayar = "Maaf uang anda tidak mencukupi!!";
            return false;
        }
    }
    
    public void outputKembalian() {
        System.out.println("\nNominal uang anda : "+ this.toRupiahWithRP(Integer.toString(this.uang_bayar)));
        if(this.processUang()) {
            System.out.println("Uang kembalian : "+ this.toRupiahWithRP(Integer.toString(this.kembalian)));
        } 
        System.out.println("-------------------------------------------------");
        System.out.println(this.ket_bayar);
        while(this.uang_bayar < this.total_harga) {
            this.inputBayar();
        }
    }
}

public class TiketKeretaApi {
    public static void main(String[] args) {
        int kelas_ki, jml_penumpang;
        Scanner input = new Scanner(System.in);
        
        SistemTiketKeretaApi.daftar_kelas();
        System.out.print("Silahkan pilih kelas(1,2,3) = ");
        kelas_ki = input.nextInt();
        System.out.print("Masukkan jumlah penumpang = ");
        jml_penumpang = input.nextInt();
        
        SistemTiketKeretaApi ka = new SistemTiketKeretaApi(kelas_ki, jml_penumpang);
    }
}
