package vn.edu.ntu.chauhoang.baimuoidiem;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.ntu.chauhoang.baimuoidiem.Controller.Icontroller;
import vn.edu.ntu.chauhoang.baimuoidiem.Model.HocVien;


public class second_layout extends Fragment {

    NavController navController;
    Button button;

    Icontroller icontroller;
    ArrayList<HocVien> dsHV;
    RecyclerView rvViewHV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second_layout, container, false);
        addView(view);
        addEvent();
        return view;
    }

    private void addEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // navController.navigate(R.id.action_second_layout_to_first_layout);
               System.exit(1);
            }
        });
    }

    private void addView(View view) {
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navController = NavHostFragment.findNavController(second_layout.this);
        button = view.findViewById(R.id.button);

        icontroller = ((MainActivity)getActivity()).icontroller;
        rvViewHV = view.findViewById(R.id.rvViewHV);
        dsHV = icontroller.getlistHocVien();
        infoAdapter adapter = new infoAdapter(dsHV);
        rvViewHV.setLayoutManager(new LinearLayoutManager(second_layout.this.getActivity()));
        rvViewHV.setAdapter(adapter);
    }

    private class inforViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtHV;

        public inforViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHV = itemView.findViewById(R.id.txtHV);

        }
        public void bind(HocVien p) {
            txtHV.setText("Chúc mừng bạn: " + p.getName() + "\nSinh ngày: " + p.getDate()
                    + "\n Đã đăng ký thành công khóa học: \n " + p.getKhoaHoc() +
                    "\nGiờ học: " + p.getGioHoc() + "\nLiên hệ sdt: " + p.getSDT() + "\n Địa chỉ: " + p.getDiaChi());
        }

    }

    private class infoAdapter extends RecyclerView.Adapter<inforViewHolder>
    {
        ArrayList<HocVien> listinfos;

        public infoAdapter(ArrayList<HocVien> listProducts) {
            this.listinfos = listProducts;
        }
        @NonNull
        @Override
        public inforViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.hocvieninfo, parent, false);
            return new inforViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull inforViewHolder holder, int position) {
            holder.bind(listinfos.get(position));
        }

        @Override
        public int getItemCount() {
            return listinfos.size();
        }
    }
}