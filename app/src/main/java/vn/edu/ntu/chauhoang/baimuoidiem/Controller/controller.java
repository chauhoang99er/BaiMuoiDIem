package vn.edu.ntu.chauhoang.baimuoidiem.Controller;

import android.app.Application;

import java.util.ArrayList;

import vn.edu.ntu.chauhoang.baimuoidiem.Model.HocVien;

public class controller extends Application implements Icontroller {
    ArrayList<HocVien> dsHV = new ArrayList<>();
    public void controller(){

    }
    @Override
    public ArrayList<HocVien> getlistHocVien() {
        return dsHV;
    }

    @Override
    public void addInfo(HocVien hv) {
        dsHV.add(hv);
    }
}
