package com.dev.chawki.alpha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dev.chawki.alpha.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InstableFragment extends Fragment {

    Button ameliorationBtn;


    public InstableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_instable, container, false);

        ameliorationBtn = (Button) root.findViewById(R.id.amelioration_btn);

        ameliorationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Begin the transaction
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_placeholder, new StableFragment());
                ft.commit();
            }
        });

        return root;
    }


}
