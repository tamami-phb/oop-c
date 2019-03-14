public class Aplikasi {

    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("19001", "tamami");
        Mahasiswa mhs2 = new Mahasiswa("19002", "diva");
        Mahasiswa mhs3 = new Mahasiswa("19003", "nabila");
        //mhs1.nim = "19001";
        //mhs1.nama = "tamami";
        System.out.println(mhs1.nim + " : " + mhs1.nama);
        System.out.println(mhs2.nim + " : " + mhs2.nama);
        System.out.println(mhs3.nim + " : "  + mhs3.nama);
    }

}