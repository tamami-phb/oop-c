public class Aplikasi {

    public static void main(String[] args) {

        if(args.length == 1) {
            int angka = new Integer(args[0]);

            // x ? y : z;
            //System.out.println(angka % 2 == 0);
            String hasil = ( angka % 2 == 0) ? "Genap" : "Ganjil";
            System.out.println(angka + " -> " + hasil);
        } else {
            System.out.println("Gunakan : java Aplikasi {angka}");
        }
    }

}