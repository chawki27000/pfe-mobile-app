package com.dev.chawki.alpha.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.chawki.alpha.R;
import com.dev.chawki.alpha.models.Medicament;

import java.util.ArrayList;

/**
 * Created by ilyes on 6/13/17.
 */

public class MedicamentAdapter extends ArrayAdapter<Medicament> {

    public MedicamentAdapter(@NonNull Context context, ArrayList<Medicament> medicaments) {
        super(context, 0, medicaments);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the clicked data
        Medicament medicament = getItem(position);

        // Get the layout file as a view
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.medicament_list_item, parent, false);

        // Get the views
        TextView medicNameTV = (TextView) convertView.findViewById(R.id.medic_name_tv);

        // Set the data into the views
        //medicNameTV.setText(medicament.getName());
        medicNameTV.setText("Medoc");

        final NumberPicker np = (NumberPicker) convertView.findViewById(R.id.quantity_picker);
        np.setMaxValue(100);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(getContext(), "" + newVal, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
