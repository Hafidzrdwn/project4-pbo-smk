package getter_setter;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Hafidz Ridwan
 */
class SistemNilaiAkhir {
    private double nilai_tugas, nilai_uts, nilai_uas, nilai_akhir;
    private String keterangan, grade;
    
    SistemNilaiAkhir() {
        this.inputNilai();
        this.proses();
        this.output();
    }
    
    public void setNilaiTugas(double n_tgs) {
        this.nilai_tugas = n_tgs;
    }
    
    public void setNilaiUTS(double n_uts) {
        this.nilai_uts = n_uts;
    }
    
    public void setNilaiUAS(double n_uas) {
        this.nilai_uas = n_uas;
    }
    
    public void setKeterangan(double na) {
        this.keterangan = (na >= 75) ? "LULUS" : "TIDAK LULUS";
    }
    
    public void setGrade(double na) {
        if(na >= 86 && na <= 100){
            this.grade = "A";
        } else if(na >= 76 && na <= 85) {
            this.grade = "B";
        } else if(na >= 65 && na <= 75) {
            this.grade = "C";
        } else {
            this.grade = "D";
        }
    }
    
    public double getNilaiTugas() {
        return this.nilai_tugas;
    }
    
    public double getNilaiUTS() {
        return this.nilai_uts;
    }
    
    public double getNilaiUAS() {
        return this.nilai_uas;
    }
    
    public double getNilaiAkhir() {
        this.nilai_akhir = (0.3 * this.getNilaiTugas()) + (0.3 * this.getNilaiUTS()) + (0.4 * this.getNilaiUAS());
        return Double.parseDouble(new DecimalFormat("##.##").format(this.nilai_akhir));
    }
    
    public String getKeterangan() {
        return this.keterangan;
    }
    
    public String getGrade() {
        return this.grade;
    }
    
    private void inputNilai() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n\nPerhitungan Nilai Akhir");
        System.out.println("-----------------------");
        System.out.print("Masukkan nilai tugas = ");
        this.setNilaiTugas(input.nextDouble());
        System.out.print("Masukkan nilai UTS = ");
        this.setNilaiUTS(input.nextDouble());
        System.out.print("Masukkan nilai UAS = ");
        this.setNilaiUAS(input.nextDouble());
        
    }
    
    private void proses() {
        this.setKeterangan(this.getNilaiAkhir());
        this.setGrade(this.getNilaiAkhir());
    }
    
    private void output() {
        System.out.println("\n---------- Hasil Akhir ----------");
        System.out.println("Nilai Akhir : "+ this.getNilaiAkhir());
        System.out.println("Grade : "+ this.getGrade());
        System.out.println("Keterangan : "+ this.getKeterangan());
        System.out.println("---------------------------------\n\n");
    }
}

public class NilaiAkhir {
    public static void main(String[] args) {
        SistemNilaiAkhir hasil = new SistemNilaiAkhir();
    }
}
