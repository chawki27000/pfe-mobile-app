package com.dev.chawki.alpha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


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
        return view;
    }

    private void updateUI() {

        ArrayList<Case> cases = Case.createCaseList(50);
        mCaseAdapter = new CaseAdapter(cases);
        recyclerView.setAdapter(mCaseAdapter);

    }

    private class CaseHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;

        public CaseHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
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
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new CaseHolder(view);
        }

        @Override
        public void onBindViewHolder(CaseHolder holder, int position) {
            Case aCase = mCases.get(position);
            holder.mTitleTextView.setText(aCase.getAge());
        }

        @Override
        public int getItemCount() {
            return mCases.size();
        }
    }


}
