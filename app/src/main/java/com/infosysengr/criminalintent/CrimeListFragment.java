package com.infosysengr.criminalintent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;

import com.infosysengr.crime.Crime;

import java.util.List;

public class CrimeListFragment extends ListFragment {

    private List<Crime> mCrimes;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
    }
}
