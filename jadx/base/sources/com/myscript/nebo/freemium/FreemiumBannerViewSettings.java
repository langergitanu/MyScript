package com.myscript.nebo.freemium;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.webkit.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FreemiumBannerView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/freemium/FreemiumBannerViewSettings;", "Landroid/os/Parcelable;", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Lcom/myscript/nebo/freemium/FreemiumBannerViewSettings$Default;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class FreemiumBannerViewSettings implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ FreemiumBannerViewSettings(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FreemiumBannerViewSettings() {
    }

    /* JADX INFO: compiled from: FreemiumBannerView.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0083\u0004J\n\u0010\n\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/freemium/FreemiumBannerViewSettings$Default;", "Lcom/myscript/nebo/freemium/FreemiumBannerViewSettings;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Default extends FreemiumBannerViewSettings {
        public static final int $stable = 0;
        public static final Default INSTANCE = new Default();
        public static final Parcelable.Creator<Default> CREATOR = new Creator();

        /* JADX INFO: compiled from: FreemiumBannerView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<Default> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Default createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Default.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Default[] newArray(int i) {
                return new Default[i];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Default)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1042640619;
        }

        public String toString() {
            return Profile.DEFAULT_PROFILE_NAME;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }

        private Default() {
            super(null);
        }
    }
}
