package com.dev.chawki.alpha.fragments;


import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TimePicker;

import com.dev.chawki.alpha.R;
import com.dev.chawki.alpha.adapters.MedicamentAdapter;
import com.dev.chawki.alpha.adapters.SigneAdapter;
import com.dev.chawki.alpha.models.Medicament;
import com.dev.chawki.alpha.models.Signe;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class StableFragment extends Fragment {

    LayoutInflater inflater;

    Button selectTimeBtn;
    ImageButton openMedicPopupBtn;
    ImageButton openSignePopupBtn;


    public StableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;

        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_stable, container, false);


        // Get the views
        selectTimeBtn = (Button) root.findViewById(R.id.select_time_btn);
        openMedicPopupBtn = (ImageButton) root.findViewById(R.id.open_medic_popup_btn);
        openSignePopupBtn = (ImageButton) root.findViewById(R.id.open_signe_popup_btn);


        // Actions
        selectTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(root.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        selectTimeBtn.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });


        openMedicPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the dialog
                showMedicDialog();
            }
        });

        openSignePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSigneDialog();
            }
        });



        return root;
    }


    private void showMedicDialog(){

        //final Dialog dialog = new Dialog(getContext());

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        View view = inflater.inflate(R.layout.medicamnet_list, null);

        ListView lv = (ListView) view.findViewById(R.id.list);


        ArrayList<Medicament> myListOfItems = new ArrayList<>();
        myListOfItems.add(new Medicament("Medoc", 0));
        myListOfItems.add(new Medicament("Medoc", 0));
        myListOfItems.add(new Medicament("Medoc", 0));
        myListOfItems.add(new Medicament("Medoc", 0));
        myListOfItems.add(new Medicament("Medoc", 0));

        MedicamentAdapter clad = new MedicamentAdapter(getContext(), myListOfItems);

        lv.setAdapter(clad);

        // lv.setOnItemClickListener(........);


        alert.setView(view);
        alert.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        alert.show();

        //dialog.show();

    }

    private void showSigneDialog(){

        //final Dialog dialog = new Dialog(getContext());

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        View view = inflater.inflate(R.layout.signe_list, null);

        ListView lv = (ListView) view.findViewById(R.id.list);


        ArrayList<Signe> myListOfItems = new ArrayList<>();
        myListOfItems.add(new Signe("Signe"));
        myListOfItems.add(new Signe("Signe"));
        myListOfItems.add(new Signe("Signe"));
        myListOfItems.add(new Signe("Signe"));
        myListOfItems.add(new Signe("Signe"));

        SigneAdapter clad = new SigneAdapter(getContext(), myListOfItems);

        lv.setAdapter(clad);

        // lv.setOnItemClickListener(........);


        alert.setView(view);
        alert.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        alert.show();

        //dialog.show();

    }
}
