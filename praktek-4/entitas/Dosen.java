package entitas;

public class Dosen extends Person {

    private String nid;

    public Dosen() {
        super("na", "na");
    }

    public void cetak() {
        System.out.println(nid + " : " +
                getNama());
    }

    public String toString() {
        return nid + " : " + getNama();
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
}