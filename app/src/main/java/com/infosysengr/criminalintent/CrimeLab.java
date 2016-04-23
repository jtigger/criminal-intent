package com.infosysengr.criminalintent;

import android.content.Context;

import com.infosysengr.crime.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private List<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 3 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context context) {
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for(Crime crime : mCrimes) {
          if(crime.getId().equals(id)) {
              return crime;
          }
        }
        return null;
    }
}
