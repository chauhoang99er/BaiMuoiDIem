package vn.edu.ntu.chauhoang.baimuoidiem.Model;

public class HocVien {
    String Name, Date, SDT, diaChi, gioHoc, khoaHoc;

    public HocVien(String name, String date, String SDT, String diaChi, String gioHoc, String khoaHoc) {        Name = name;
        Date = date;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.gioHoc = gioHoc;
        this.khoaHoc = khoaHoc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioHoc() {
        return gioHoc;
    }

    public void setGioHoc(String gioHoc) {
        this.gioHoc = gioHoc;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
