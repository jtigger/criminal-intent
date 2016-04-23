package com.infosysengr.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class CrimeActivity extends SingleFragmentActivity {
    @NonNull
    CrimeFragment createFragment() {
        return new CrimeFragment();
    }
}
