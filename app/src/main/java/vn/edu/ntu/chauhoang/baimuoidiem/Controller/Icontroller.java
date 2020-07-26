package vn.edu.ntu.chauhoang.baimuoidiem.Controller;

import java.util.ArrayList;

import vn.edu.ntu.chauhoang.baimuoidiem.Model.HocVien;

public interface Icontroller {
    public ArrayList<HocVien> getlistHocVien();
    public void addInfo(HocVien hv);
}
