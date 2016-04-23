package com.infosysengr.crime;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private long mMomentItHappened;
    private boolean mIsSolved;

    public Crime() {
        mId = UUID.randomUUID();
        mMomentItHappened = System.currentTimeMillis();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(final String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public long getMomentItHappened() {
        return mMomentItHappened;
    }

    public void setMomentItHappened(final long momentItHappened) {
        mMomentItHappened = momentItHappened;
    }

    public boolean isSolved() {
        return mIsSolved;
    }

    public void setSolved(final boolean solved) {
        mIsSolved = solved;
    }


}
