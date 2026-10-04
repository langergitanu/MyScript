package com.myscript.nebo.dms.edit_new_notebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.myscript.nebo.dms.edit_languages.LegacyLanguageNameHelper;

/* JADX INFO: loaded from: classes7.dex */
public class DisplayableLocale implements Comparable<DisplayableLocale>, Parcelable {
    public static final Parcelable.Creator<DisplayableLocale> CREATOR = new Parcelable.Creator<DisplayableLocale>() { // from class: com.myscript.nebo.dms.edit_new_notebook.DisplayableLocale.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayableLocale createFromParcel(Parcel parcel) {
            return new DisplayableLocale(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayableLocale[] newArray(int i) {
            return new DisplayableLocale[i];
        }
    };
    private final LegacyLanguageNameHelper mLanguageNameHelper;
    private final String mLocale;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DisplayableLocale(LegacyLanguageNameHelper legacyLanguageNameHelper, String str) {
        this.mLanguageNameHelper = legacyLanguageNameHelper;
        this.mLocale = str;
    }

    protected DisplayableLocale(Parcel parcel) {
        this.mLanguageNameHelper = null;
        this.mLocale = parcel.readString();
    }

    public String getLocale() {
        return this.mLocale;
    }

    public String toString() {
        LegacyLanguageNameHelper legacyLanguageNameHelper;
        return (!isValid() || (legacyLanguageNameHelper = this.mLanguageNameHelper) == null) ? "" : legacyLanguageNameHelper.getDisplayLanguage(this.mLocale);
    }

    public boolean isValid() {
        return this.mLocale != null;
    }

    @Override // java.lang.Comparable
    public int compareTo(DisplayableLocale displayableLocale) {
        if (this.mLocale == null) {
            return 1;
        }
        if (displayableLocale.mLocale == null) {
            return -1;
        }
        return toString().compareTo(displayableLocale.toString());
    }

    public int hashCode() {
        String str = this.mLocale;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DisplayableLocale)) {
            return false;
        }
        Object obj2 = ((DisplayableLocale) obj).mLocale;
        String str = this.mLocale;
        return obj2 == str || (str != null && str.equals(obj2));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mLocale);
    }
}
