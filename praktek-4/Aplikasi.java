import entitas.*;

public class Aplikasi {

    public static void main(String[] args) {
        Mahasiswa[] dataMhs = {
          new Mahasiswa("19001", "tamami"),
          new Mahasiswa("19002", "diva"),
          new Mahasiswa("19003", "nabila")
        };

        for(Person person : dataMhs) {
            person.cetak();
        }

        System.out.println();
        Dosen dosen = new Dosen();
        dosen.setNama("honda");
        dosen.setNid("1984001");
        dosen.cetak();
        System.out.println(dosen);
        System.out.println(dosen.hashCode());
    }

}