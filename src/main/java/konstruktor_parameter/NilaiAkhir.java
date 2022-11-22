package konstruktor_parameter;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Hafidz Ridwan
 */
class SistemNilaiAkhir {
    public double nilai_tugas, nilai_uts, nilai_uas, nilai_akhir;
    public String keterangan, grade;
    
    public SistemNilaiAkhir(double nilai_tugas, double nilai_uts, double nilai_uas) {
        this.nilai_tugas = nilai_tugas;
        this.nilai_uts = nilai_uts;
        this.nilai_uas = nilai_uas;
        
        this.process();
        this.output();
    }
    
    public double prosesNilaiAkhir() {
        this.nilai_akhir = (0.3 * this.nilai_tugas) + (0.3 * this.nilai_uts) + (0.4 * this.nilai_uas);
        return Double.parseDouble(new DecimalFormat("##.##").format(this.nilai_akhir));
    }
    
    private void process() {
        this.keterangan = (this.prosesNilaiAkhir() >= 75) ? "LULUS" : "TIDAK LULUS";
        
        double na = this.prosesNilaiAkhir();
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
    
    private void output() {
        System.out.println("\n---------- Hasil Akhir ----------");
        System.out.println("Nilai Akhir : "+ this.prosesNilaiAkhir());
        System.out.println("Grade : "+ this.grade);
        System.out.println("Keterangan : "+ this.keterangan);
        System.out.println("---------------------------------\n\n");
    }
}

public class NilaiAkhir {
    public static void main(String[] args) {
        double n_tgs,n_uts,n_uas;
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nPerhitungan Nilai Akhir");
        System.out.println("-----------------------");
        System.out.print("Masukkan nilai tugas = ");
        n_tgs = input.nextDouble();
        System.out.print("Masukkan nilai UTS = ");
        n_uts = input.nextDouble();
        System.out.print("Masukkan nilai UAS = ");
        n_uas = input.nextDouble();
        
        SistemNilaiAkhir hasil = new SistemNilaiAkhir(n_tgs,n_uts,n_uas);
    }
}
