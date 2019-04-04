package service;

import java.util.*;
import entity.*;

public class MahasiswaService {

    private static List<Mahasiswa> data = new LinkedList<Mahasiswa>();

    public void addData(Mahasiswa mhs) {
        data.add(mhs);
        System.out.println("data telah tersimpan");
    }

    public void updateData(Mahasiswa mhs) {
        int index = data.indexOf(mhs);
        if(index >= 0) {
            data.set(index, mhs);
            System.out.println("data telah berubah");
        }
    }

    public void deleteData(String nim) {}

    public void showAllData() {
        int i=1;
        System.out.println("\nData di List :");
        for(Mahasiswa mhs : data) {
            System.out.println("data ke-" + i++);
            System.out.println("  NIM : " + mhs.getNim());
            System.out.println("  NAMA : " + mhs.getNama());
            System.out.println("  KELAS : " + mhs.getKelas());
        }
    }

}