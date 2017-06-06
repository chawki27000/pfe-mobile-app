package com.dev.chawki.alpha;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment {

    private Button buttonInformation;
    private EditText edittextAge;
    private EditText edittextWeight;
    private Spinner spinnerAge;
    private Spinner spinnerGender;

    public InformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        // BINDING
        buttonInformation = (Button) view.findViewById(R.id.button_information);
        edittextAge = (EditText) view.findViewById(R.id.edittext_age);
        edittextWeight = (EditText) view.findViewById(R.id.edittext_weight);
        spinnerAge = (Spinner) view.findViewById(R.id.spinner_age);
        spinnerGender = (Spinner) view.findViewById(R.id.spinner_gender);

        buttonInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting
                String age = edittextAge.getText().toString();
                String weight = edittextAge.getText().toString();
                String s_age = spinnerAge.getSelectedItem().toString();
                String gender = spinnerGender.getSelectedItem().toString();

                // Begin the transaction
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.fragment_placeholder, new HemoFragment());
//                ft.commit();

                // AsyncRequest
                AsyncTask asyncTask = new AsyncRequest();
                asyncTask.execute(age, weight, s_age, gender);
            }
        });

        return view;
    }

    private class AsyncRequest extends AsyncTask<String, Void, String> {

        public final MediaType JSON
                = MediaType.parse("application/x-www-form-urlencoded");

        OkHttpClient client = new OkHttpClient();

        // FormBuilder
//        RequestBody formBody = new FormBody.Builder()
//                .add("username", params[1])
//                .add("password", params[2])
//                .build();

        @Override
        protected String doInBackground(String... params) {

            return null;
        }
    }

}
