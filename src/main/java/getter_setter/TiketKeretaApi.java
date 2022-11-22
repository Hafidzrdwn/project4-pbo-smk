package getter_setter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Hafidz Ridwan
 */
class SistemTiketKeretaApi {
    private int kelas, jumlah_penumpang, harga, total_harga, uang_bayar, kembalian;
    private String ket_bayar;
    Scanner input = new Scanner(System.in);

    SistemTiketKeretaApi() {
        this.inputAwal();
        this.outputStruk();
    }
    
    public void setKelas(int kelas) {
        this.kelas = kelas;
    }
    
    public void setJumlahPenumpang(int jml_penumpang) {
        this.jumlah_penumpang = jml_penumpang;
    }
    
    public void setUangBayar(int uang_byr) {
        this.uang_bayar = uang_byr;
    }
    
    public void setKeteranganBayar(String ket) {
        this.ket_bayar = ket;
    }
    
    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }
    
    public int getKelas() {
        return this.kelas;
    }
    
    public String getDeskripsiKelas() {
        String result;
        switch(this.getKelas()){
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
    
    public int getJumlahPenumpang() {
        return this.jumlah_penumpang;
    }
    
    public int getHargaKAPerKelas() {
        switch(this.getKelas()){
            case 1:
                this.harga = 15000;
                break;
            case 2:
                this.harga = 80000;
                break;
            case 3:
                this.harga = 110000;
                break;
            default:
                this.harga = 0;
        }
        
        return this.harga;
    }
    
    public int getTotalHarga() {
        this.total_harga = this.getHargaKAPerKelas() * this.getJumlahPenumpang();
        return this.total_harga;
    }
    
    public int getUangBayar() {
        return this.uang_bayar;
    }
    
    public String getKeteranganBayar() {
        return this.ket_bayar;
    }
    
    public int getKembalian() {
        return this.kembalian;
    }
    
    private String getRupiahWithRP(String price) {
        int newPrice = Integer.parseInt(price);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(newPrice);
    }
    
    private void inputAwal() {
     
        System.out.println("\nSistem Tiket Kereta Api Sby - Malang");
        System.out.println("Daftar Kelas : ");
        System.out.println("1. Ekonomi(Rp. 15.000)");
        System.out.println("2. Bisnis(Rp. 80.000)");
        System.out.println("3. Eksekutif(Rp. 110.000)");
        
        System.out.print("Silahkan pilih kelas(1,2,3) = ");
        this.setKelas(this.input.nextInt());
        System.out.print("Masukkan jumlah penumpang = ");
        this.setJumlahPenumpang(this.input.nextInt());
        
    }
    
    private void outputStruk() {
        System.out.println("\n----------Struk Kereta Api Sby - Malang----------\n");
        System.out.println("Kelas Kereta : "+ this.getDeskripsiKelas());
        System.out.println("Tujuan : Surabaya - Malang");
        System.out.println("Jumlah Penumpang : "+ this.getJumlahPenumpang() + " orang");
        System.out.println("Harga Tiket : "+ this.getRupiahWithRP(Integer.toString(this.getHargaKAPerKelas())));
        System.out.println("Total Harga : " + this.getRupiahWithRP(Integer.toString(this.getTotalHarga())));
        System.out.println("\n----------Terimakasih, Silahkan Membayar---------");
        this.inputBayar();
    }
    
    private void inputBayar() {
        System.out.print("Masukkan uang anda = ");
        this.setUangBayar(this.input.nextInt());
        this.outputKembalian();
    }
    
     private boolean processUang() {
        if(this.getUangBayar() >= this.getTotalHarga()){
            this.setKembalian(this.getUangBayar() - this.getTotalHarga());
            this.setKeteranganBayar("Selamat, Transaksi Anda Telah Berhasil!!");
            return true;
        }else {
            this.setKembalian(0);
            this.setKeteranganBayar("Maaf uang anda tidak mencukupi!!");
            return false;
        }
    }
    
    private void outputKembalian() {
        System.out.println("\nNominal uang anda : "+ this.getRupiahWithRP(Integer.toString(this.getUangBayar())));
        if(this.processUang()) {
            System.out.println("Uang kembalian : "+ this.getRupiahWithRP(Integer.toString(this.getKembalian())));
        } 
        System.out.println("-------------------------------------------------");
        System.out.println(this.getKeteranganBayar());
        while(this.getUangBayar() < this.getTotalHarga()) {
            this.inputBayar();
        }
    }
    
}

public class TiketKeretaApi {
    public static void main(String[] args) {
        SistemTiketKeretaApi ka = new SistemTiketKeretaApi();
    }
}
