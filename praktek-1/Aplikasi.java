public class Aplikasi {

    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("19001", "tamami");
        Mahasiswa mhs2 = new Mahasiswa("19002", "diva");
        Mahasiswa mhs3 = new Mahasiswa("19003", "nabila");

        Mahasiswa mhs4 = null;
        if(args.length == 2) {
            mhs4 = new Mahasiswa(args[0], args[1]);
        } else {
            //System.out.println("Gunakan : java Aplikasi {nim} {nama}");
        }
        //mhs1.nim = "19001";
        //mhs1.nama = "tamami";
        //System.out.println(mhs1.getNim() + " : " +  mhs1.getNama());
        //System.out.println(mhs2.getNim() + " : " +  mhs2.getNama());
        //System.out.println(mhs3.getNim() + " : "  + mhs3.getNama());
        mhs1.cetak();
        mhs2.cetak();
        mhs3.cetak();

        if(args.length == 2) {
            //System.out.println(mhs4.getNim() + " : " + mhs4.getNama());
            mhs4.cetak();
        }
    }

}