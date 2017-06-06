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


/**
 * A simple {@link Fragment} subclass.
 */
public class NeuroFragment extends Fragment {

    private Button buttonNeuro;
    private EditText param1;
    private EditText param2;
    private EditText param3;

    public NeuroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_neuro, container, false);

        // BINDING
        buttonNeuro = (Button) view.findViewById(R.id.button_neuro);

        param1 = (EditText) view.findViewById(R.id.param1);
        param2 = (EditText) view.findViewById(R.id.param2);
        param3 = (EditText) view.findViewById(R.id.param3);

        buttonNeuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting
                String s_param1 = param1.getText().toString();
                String s_param2 = param2.getText().toString();
                String s_param3 = param3.getText().toString();

                // Begin the transaction
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_placeholder, new ResultFragment());
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
