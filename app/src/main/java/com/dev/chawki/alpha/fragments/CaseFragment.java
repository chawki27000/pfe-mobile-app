package com.dev.chawki.alpha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.chawki.alpha.models.Case;
import com.dev.chawki.alpha.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CaseFragment extends Fragment {


    public CaseFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private CaseAdapter mCaseAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_case, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvCase);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {

        ArrayList<Case> cases = Case.createCaseList(50);
        mCaseAdapter = new CaseAdapter(cases);
        recyclerView.setAdapter(mCaseAdapter);

    }

    private class CaseHolder extends RecyclerView.ViewHolder {
        public TextView mAgeTV;
        public TextView mTypeTV;
        public ImageView mGenderTV;

        public CaseHolder(View itemView) {
            super(itemView);
            mAgeTV = (TextView) itemView.findViewById(R.id.age_tv);
            mTypeTV = (TextView) itemView.findViewById(R.id.type_tv);
            mGenderTV = (ImageView) itemView.findViewById(R.id.gender_tv);
        }
    }

    private class CaseAdapter extends RecyclerView.Adapter<CaseHolder> {
        private List<Case> mCases;

        public CaseAdapter(List<Case> cases) {
            mCases = cases;
        }

        @Override
        public CaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.case_list_item, parent, false);
            return new CaseHolder(view);
        }

        @Override
        public void onBindViewHolder(CaseHolder holder, int position) {
            Case aCase = mCases.get(position);

            // Set the age
            holder.mAgeTV.setText(String.valueOf(aCase.getAge()));

            // Set the type
            holder.mTypeTV.setText(aCase.getType());

            // Set the gender
            if(Objects.equals(aCase.getGender(), Case.MALE)) {
                holder.mGenderTV.setImageResource(R.drawable.male);
            } else {
                holder.mGenderTV.setImageResource(R.drawable.female);
            }

        }

        @Override
        public int getItemCount() {
            return mCases.size();
        }
    }


}
