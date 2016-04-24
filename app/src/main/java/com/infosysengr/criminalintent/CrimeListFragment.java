package com.infosysengr.criminalintent;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

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

        setListAdapter(new CrimesAdapter(getActivity(), mCrimes));
    }

    @Override
    public void onListItemClick(final ListView l, final View v, final int position, final long id) {
        final CrimeListItem crimeListItem = ((CrimesAdapter) getListAdapter()).getItem(position);
        Log.d(TAG, String.format("onListItemClick: currentItem = {\n  \"%s\"=\"%s\",\n  \"%s\"=\"%s\",\n  \"%s\"=\"%s\"\n}",
                "id", crimeListItem.getCrime().getId(),
                "title", crimeListItem.getCrime().getTitle(),
                "momentItHappened", new Date(crimeListItem.getCrime().getMomentItHappened()).toString()
                ) );
    }

    private static class CrimesAdapter extends ArrayAdapter<CrimeListItem> {
        private Activity mActivity;

        private static List<CrimeListItem> wrapInPresenters(List<Crime> crimes) {
            List<CrimeListItem> listOfCrimes = new ArrayList<>(crimes.size());
            for(Crime crime : crimes) {
                listOfCrimes.add(new CrimeListItem(crime));
            }
            return listOfCrimes;
        }
        public CrimesAdapter(Activity activity, List<Crime> crimes) {
            super(activity, 0, wrapInPresenters(crimes));
            mActivity = activity;
        }

        @Override
        public View getView(final int position, View crimeItemView, final ViewGroup parent) {
            if(crimeItemView == null) {
                crimeItemView = mActivity.getLayoutInflater().inflate(R.layout.crime_list_item, null);
            }

            CrimeListItem crimeListItem = getItem(position);

            ((TextView)crimeItemView.findViewById(R.id.crime_item_title))
                    .setText(crimeListItem.getCrime().getTitle());
            ((TextView)crimeItemView.findViewById(R.id.crime_item_subtitle))
                    .setText(new Date(crimeListItem.getCrime().getMomentItHappened()).toString());
            ((CheckBox)crimeItemView.findViewById(R.id.crime_item_checkbox))
                    .setChecked(crimeListItem.getCrime().isSolved());

            return crimeItemView;
        }
    }
}
