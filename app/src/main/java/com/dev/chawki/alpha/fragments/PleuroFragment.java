package com.dev.chawki.alpha.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.dev.chawki.alpha.R;
import com.dev.chawki.alpha.fragments.NeuroFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PleuroFragment extends Fragment {

    private Button buttonPleuro;
    private EditText edittextFr;
    private EditText edittextFio2;
    private Spinner spinnerAmpl;
    private Spinner spinnerSpo2;
    private Spinner spinnerBruit;
    private Spinner spinnerToux;
    private Spinner spinnerRythme;
    private CheckBox checkboxCyanose;
    private CheckBox checkboxSueur;

    public PleuroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pleuro, container, false);

        // BINDING
        buttonPleuro = (Button) view.findViewById(R.id.button_pleuro);

        edittextFr = (EditText) view.findViewById(R.id.edittext_fr);
        edittextFio2 = (EditText) view.findViewById(R.id.edittext_fio2);

        spinnerAmpl = (Spinner) view.findViewById(R.id.spinner_ampl);
        spinnerSpo2 = (Spinner) view.findViewById(R.id.spinner_spo2);
        spinnerBruit = (Spinner) view.findViewById(R.id.spinner_bruit);
        spinnerToux = (Spinner) view.findViewById(R.id.spinner_toux);
        spinnerRythme = (Spinner) view.findViewById(R.id.spinner_rythme);

        checkboxCyanose = (CheckBox) view.findViewById(R.id.checkbox_cyanose);
        checkboxSueur = (CheckBox) view.findViewById(R.id.checkbox_sueur);

        buttonPleuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting
                String fr = edittextFr.getText().toString();
                String fio2 = edittextFio2.getText().toString();

                String ampl = spinnerAmpl.getSelectedItem().toString();
                String spo2 = spinnerSpo2.getSelectedItem().toString();
                String bruit = spinnerBruit.getSelectedItem().toString();
                String toux = spinnerToux.getSelectedItem().toString();
                String rythme = spinnerRythme.getSelectedItem().toString();

                String cyanose = String.valueOf(checkboxCyanose.isEnabled());
                String sueur = String.valueOf(checkboxSueur.isEnabled());

                // Begin the transaction
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_placeholder, new NeuroFragment());
                ft.commit();
            }
        });

        return view;
    }

    private class AsyncRequest extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return null;
        }
    }

}
