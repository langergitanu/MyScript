package com.myscript.nebo.cloudsync.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.myscript.nebo.cloudsync.CloudManager;

/* JADX INFO: loaded from: classes3.dex */
public class ProviderModel implements Parcelable, Comparable<ProviderModel> {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.myscript.nebo.cloudsync.settings.ProviderModel.1
        @Override // android.os.Parcelable.Creator
        public ProviderModel createFromParcel(Parcel parcel) {
            return new ProviderModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProviderModel[] newArray(int i) {
            return new ProviderModel[i];
        }
    };
    private int mIconResId;
    private int mName;
    private int mOrder;
    private CloudManager.CloudProviderType mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ProviderModel(int i, CloudManager.CloudProviderType cloudProviderType, int i2, int i3) {
        this.mOrder = i;
        this.mType = cloudProviderType;
        this.mName = i2;
        this.mIconResId = i3;
    }

    ProviderModel(Parcel parcel) {
        this.mOrder = parcel.readInt();
        this.mType = CloudManager.CloudProviderType.valueOf(parcel.readString());
        this.mName = parcel.readInt();
        this.mIconResId = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mOrder);
        parcel.writeString(this.mType.name());
        parcel.writeInt(this.mName);
        parcel.writeInt(this.mIconResId);
    }

    public int getName() {
        return this.mName;
    }

    public CloudManager.CloudProviderType getType() {
        return this.mType;
    }

    public int getIconResId() {
        return this.mIconResId;
    }

    @Override // java.lang.Comparable
    public int compareTo(ProviderModel providerModel) {
        return this.mOrder - providerModel.mOrder;
    }
}
