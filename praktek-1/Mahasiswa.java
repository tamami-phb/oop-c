public class Mahasiswa {

    private String nim;
    private String nama;

    Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    // NetBeans: klik kanan -> refactor -> encapsulate fields

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}