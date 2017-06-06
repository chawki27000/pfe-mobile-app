package com.dev.chawki.alpha;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class HemoFragment extends Fragment {

    private Button buttonHemo;
    private EditText edittextPouls;
    private EditText edittextTrc;
    private EditText edittextTemp;
    private EditText edittextPvc;
    private Spinner spinnerTa;
    private Spinner spinnerDurese;
    private Spinner spinnerCard;
    private CheckBox checkboxMarbrure;
    private CheckBox checkboxTmpext;
    private CheckBox checkboxTurg;
    private CheckBox checkboxHepat;


    public HemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hemo, container, false);

        // Binding
        buttonHemo = (Button) view.findViewById(R.id.button_hemo);

        edittextPouls = (EditText) view.findViewById(R.id.edittext_pouls);
        edittextTrc = (EditText) view.findViewById(R.id.edittext_trc);
        edittextTemp = (EditText) view.findViewById(R.id.edittext_temp);
        edittextPvc = (EditText) view.findViewById(R.id.edittext_pvc);

        spinnerTa = (Spinner) view.findViewById(R.id.spinner_ta);
        spinnerDurese = (Spinner) view.findViewById(R.id.spinner_durese);
        spinnerCard = (Spinner) view.findViewById(R.id.spinner_card);

        checkboxMarbrure = (CheckBox) view.findViewById(R.id.checkbox_marbrure);
        checkboxTmpext = (CheckBox) view.findViewById(R.id.checkbox_tmpext);
        checkboxTurg = (CheckBox) view.findViewById(R.id.checkbox_turg);
        checkboxHepat = (CheckBox) view.findViewById(R.id.checkbox_hepat);

        buttonHemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting
                String pouls = edittextPouls.getText().toString();
                String trc = edittextTrc.getText().toString();
                String temp = edittextTemp.getText().toString();
                String pvc = edittextPvc.getText().toString();

                String ta = spinnerTa.getSelectedItem().toString();
                String durese = spinnerDurese.getSelectedItem().toString();
                String card = spinnerCard.getSelectedItem().toString();

                String marbrure = String.valueOf(checkboxMarbrure.isEnabled());
                String tmpext = String.valueOf(checkboxTmpext.isEnabled());
                String turg = String.valueOf(checkboxTurg.isEnabled());
                String hepat = String.valueOf(checkboxHepat.isEnabled());

                // Begin the transaction
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_placeholder, new PleuroFragment());
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
