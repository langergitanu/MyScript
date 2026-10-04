package com.myscript.nebo.whatsnew;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FancyWhatsNewDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0005J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006$"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/FancyWhatsNewData;", "Landroid/os/Parcelable;", "tag", "", "titleRes", "", "messageRes", "illustrationRes", "ctaLabelRes", "<init>", "(Ljava/lang/String;IIII)V", "getTag", "()Ljava/lang/String;", "getTitleRes", "()I", "getMessageRes", "getIllustrationRes", "getCtaLabelRes", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FancyWhatsNewData implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<FancyWhatsNewData> CREATOR = new Creator();
    private final int ctaLabelRes;
    private final int illustrationRes;
    private final int messageRes;
    private final String tag;
    private final int titleRes;

    /* JADX INFO: compiled from: FancyWhatsNewDialog.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<FancyWhatsNewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FancyWhatsNewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FancyWhatsNewData(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FancyWhatsNewData[] newArray(int i) {
            return new FancyWhatsNewData[i];
        }
    }

    public static /* synthetic */ FancyWhatsNewData copy$default(FancyWhatsNewData fancyWhatsNewData, String str, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = fancyWhatsNewData.tag;
        }
        if ((i5 & 2) != 0) {
            i = fancyWhatsNewData.titleRes;
        }
        if ((i5 & 4) != 0) {
            i2 = fancyWhatsNewData.messageRes;
        }
        if ((i5 & 8) != 0) {
            i3 = fancyWhatsNewData.illustrationRes;
        }
        if ((i5 & 16) != 0) {
            i4 = fancyWhatsNewData.ctaLabelRes;
        }
        int i6 = i4;
        int i7 = i2;
        return fancyWhatsNewData.copy(str, i, i7, i3, i6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMessageRes() {
        return this.messageRes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getIllustrationRes() {
        return this.illustrationRes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCtaLabelRes() {
        return this.ctaLabelRes;
    }

    public final FancyWhatsNewData copy(String tag, int titleRes, int messageRes, int illustrationRes, int ctaLabelRes) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new FancyWhatsNewData(tag, titleRes, messageRes, illustrationRes, ctaLabelRes);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FancyWhatsNewData)) {
            return false;
        }
        FancyWhatsNewData fancyWhatsNewData = (FancyWhatsNewData) other;
        return Intrinsics.areEqual(this.tag, fancyWhatsNewData.tag) && this.titleRes == fancyWhatsNewData.titleRes && this.messageRes == fancyWhatsNewData.messageRes && this.illustrationRes == fancyWhatsNewData.illustrationRes && this.ctaLabelRes == fancyWhatsNewData.ctaLabelRes;
    }

    public int hashCode() {
        return (((((((this.tag.hashCode() * 31) + Integer.hashCode(this.titleRes)) * 31) + Integer.hashCode(this.messageRes)) * 31) + Integer.hashCode(this.illustrationRes)) * 31) + Integer.hashCode(this.ctaLabelRes);
    }

    public String toString() {
        return "FancyWhatsNewData(tag=" + this.tag + ", titleRes=" + this.titleRes + ", messageRes=" + this.messageRes + ", illustrationRes=" + this.illustrationRes + ", ctaLabelRes=" + this.ctaLabelRes + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.tag);
        dest.writeInt(this.titleRes);
        dest.writeInt(this.messageRes);
        dest.writeInt(this.illustrationRes);
        dest.writeInt(this.ctaLabelRes);
    }

    public FancyWhatsNewData(String tag, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.titleRes = i;
        this.messageRes = i2;
        this.illustrationRes = i3;
        this.ctaLabelRes = i4;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int getMessageRes() {
        return this.messageRes;
    }

    public final int getIllustrationRes() {
        return this.illustrationRes;
    }

    public final int getCtaLabelRes() {
        return this.ctaLabelRes;
    }
}
