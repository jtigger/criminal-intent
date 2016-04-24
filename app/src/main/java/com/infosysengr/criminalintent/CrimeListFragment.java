package com.infosysengr.criminalintent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.infosysengr.crime.Crime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrimeListFragment extends ListFragment {
    private static final String TAG = CrimeListFragment.class.getName();
    private List<Crime> mCrimes;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        List<CrimeListItem> listOfCrimes = new ArrayList<>(mCrimes.size());

        for(Crime crime : mCrimes) {
            listOfCrimes.add(new CrimeListItem(crime));
        }

        ArrayAdapter<CrimeListItem> adapter =
                new ArrayAdapter<CrimeListItem>(getActivity(), android.R.layout.simple_list_item_1, listOfCrimes);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(final ListView l, final View v, final int position, final long id) {
        final CrimeListItem crimeListItem = (CrimeListItem) getListAdapter().getItem(position);
        Log.d(TAG, String.format("onListItemClick: currentItem = {\n  \"%s\"=\"%s\",\n  \"%s\"=\"%s\",\n  \"%s\"=\"%s\"\n}",
                "id", crimeListItem.getCrime().getId(),
                "title", crimeListItem.getCrime().getTitle(),
                "momentItHappened", new Date(crimeListItem.getCrime().getMomentItHappened()).toString()
                ) );
    }
}
