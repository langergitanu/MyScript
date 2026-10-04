package com.survicate.surveys.presentation.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointImage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/SurveyPointImageBindingData;", "Landroid/os/Parcelable;", "surveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)V", "getSurveyPointImage", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyPointImageBindingData implements Parcelable {
    public static final Parcelable.Creator<SurveyPointImageBindingData> CREATOR = new Creator();
    private final SurveyPointImage surveyPointImage;

    /* JADX INFO: compiled from: MicroSurveyPointImage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointImageBindingData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointImageBindingData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurveyPointImageBindingData(parcel.readInt() == 0 ? null : SurveyPointImage.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointImageBindingData[] newArray(int i) {
            return new SurveyPointImageBindingData[i];
        }
    }

    public static /* synthetic */ SurveyPointImageBindingData copy$default(SurveyPointImageBindingData surveyPointImageBindingData, SurveyPointImage surveyPointImage, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyPointImage = surveyPointImageBindingData.surveyPointImage;
        }
        return surveyPointImageBindingData.copy(surveyPointImage);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    public final SurveyPointImageBindingData copy(SurveyPointImage surveyPointImage) {
        return new SurveyPointImageBindingData(surveyPointImage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SurveyPointImageBindingData) && Intrinsics.areEqual(this.surveyPointImage, ((SurveyPointImageBindingData) other).surveyPointImage);
    }

    public int hashCode() {
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        if (surveyPointImage == null) {
            return 0;
        }
        return surveyPointImage.hashCode();
    }

    public String toString() {
        return "SurveyPointImageBindingData(surveyPointImage=" + this.surveyPointImage + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        if (surveyPointImage == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            surveyPointImage.writeToParcel(dest, flags);
        }
    }

    public SurveyPointImageBindingData(SurveyPointImage surveyPointImage) {
        this.surveyPointImage = surveyPointImage;
    }

    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }
}
