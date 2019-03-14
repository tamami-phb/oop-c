public class Aplikasi2 {

    public static void main(String[] args) {
        Mahasiswa[] data = {
          new Mahasiswa("19001", "tamami"),
          new Mahasiswa("19002", "diva"),
          new Mahasiswa("19003", "nabila"),
          new Mahasiswa("19004", "honda")
        };

        int angka = 0;

        for(; angka < data.length; ) {
            data[angka].cetak();
            angka++;
        }

        System.out.println();
        int i = 0;
        System.out.println(i+1);
        System.out.println(i);

        System.out.println();
        for(Mahasiswa mhs : data) {
            mhs.cetak();
        }
    }

}