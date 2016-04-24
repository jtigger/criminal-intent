package com.infosysengr.criminalintent;

import com.infosysengr.crime.Crime;

class CrimeListItem {
    private final Crime mCrime;
    CrimeListItem(Crime crime) {
        mCrime = crime;
    }
    public String toString() {
        return mCrime.getTitle();
    }

    Crime getCrime() {
        return mCrime;
    }
}
