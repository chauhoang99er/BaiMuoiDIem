package vn.edu.ntu.chauhoang.baimuoidiem;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Calendar;

import vn.edu.ntu.chauhoang.baimuoidiem.Controller.Icontroller;
import vn.edu.ntu.chauhoang.baimuoidiem.Model.HocVien;


public class first_layout extends Fragment {
    Button button;
    NavController navController;

    Icontroller icontroller;

    EditText edtName, edtDate, edtSDT, edtDiaChi;
    ImageView imgDate;
    RadioButton rb1, rb2, rb3;
    Spinner spinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_layout, container, false);
        addView(view);
        addEvent();
        return view;
    }

    private void addView(View view) {
        button  = view.findViewById(R.id.button);
        edtName  = view.findViewById(R.id.edtName);
        edtDate  = view.findViewById(R.id.edtDate);
        imgDate  = view.findViewById(R.id.imgDate);
        edtSDT  = view.findViewById(R.id.edtSDT);
        edtDiaChi  = view.findViewById(R.id.edtDiaChi);
        rb1  = view.findViewById(R.id.rb1);
        rb2  = view.findViewById(R.id.rb2);
        rb3  = view.findViewById(R.id.rb3);
        spinner  = view.findViewById(R.id.spinner);

        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        navController = NavHostFragment.findNavController(first_layout.this);
        ((MainActivity)getActivity()).navController = navController;

        icontroller =  ((MainActivity)getActivity()).icontroller;

        String[] hocvien = new String[]{"JAVA", "C++", "C#", "C", "Python"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(first_layout.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,hocvien);
        spinner.setAdapter(arrayAdapter);
    }

    private void addEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_first_layout_to_second_layout);

                String gioHoc = "";
                if(rb1.isChecked())
                    gioHoc = "Sáng";
                if(rb2.isChecked())
                    gioHoc = "Chiều";
                if(rb3.isChecked())
                    gioHoc = "Tối";
                HocVien hv = new HocVien(edtName.getText().toString(), edtDate.getText().toString(), edtSDT.getText().toString(),
                        edtDiaChi.getText().toString(), gioHoc, spinner.getSelectedItem().toString());
                icontroller.addInfo(hv);
            }
        });

        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
//Khai bao calendar

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year)
                                .append("-")
                                .append(++month)
                                .append("-")
                                .append(dayOfMonth);
                        edtDate.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }
}