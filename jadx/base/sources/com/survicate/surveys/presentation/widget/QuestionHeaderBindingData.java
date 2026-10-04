package com.survicate.surveys.presentation.widget;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroQuestionHeader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "Landroid/os/Parcelable;", "surveyPointIntroduction", "", "surveyPointTitle", "answerRequiredLabel", "showAnswerRequiredLabel", "", "imageBindingData", "Lcom/survicate/surveys/presentation/widget/SurveyPointImageBindingData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/survicate/surveys/presentation/widget/SurveyPointImageBindingData;)V", "getSurveyPointIntroduction", "()Ljava/lang/String;", "getSurveyPointTitle", "getAnswerRequiredLabel", "getShowAnswerRequiredLabel", "()Z", "getImageBindingData", "()Lcom/survicate/surveys/presentation/widget/SurveyPointImageBindingData;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Factory", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class QuestionHeaderBindingData implements Parcelable {
    private final String answerRequiredLabel;
    private final SurveyPointImageBindingData imageBindingData;
    private final boolean showAnswerRequiredLabel;
    private final String surveyPointIntroduction;
    private final String surveyPointTitle;

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<QuestionHeaderBindingData> CREATOR = new Creator();

    /* JADX INFO: compiled from: MicroQuestionHeader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<QuestionHeaderBindingData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final QuestionHeaderBindingData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QuestionHeaderBindingData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : SurveyPointImageBindingData.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final QuestionHeaderBindingData[] newArray(int i) {
            return new QuestionHeaderBindingData[i];
        }
    }

    public static /* synthetic */ QuestionHeaderBindingData copy$default(QuestionHeaderBindingData questionHeaderBindingData, String str, String str2, String str3, boolean z, SurveyPointImageBindingData surveyPointImageBindingData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questionHeaderBindingData.surveyPointIntroduction;
        }
        if ((i & 2) != 0) {
            str2 = questionHeaderBindingData.surveyPointTitle;
        }
        if ((i & 4) != 0) {
            str3 = questionHeaderBindingData.answerRequiredLabel;
        }
        if ((i & 8) != 0) {
            z = questionHeaderBindingData.showAnswerRequiredLabel;
        }
        if ((i & 16) != 0) {
            surveyPointImageBindingData = questionHeaderBindingData.imageBindingData;
        }
        SurveyPointImageBindingData surveyPointImageBindingData2 = surveyPointImageBindingData;
        String str4 = str3;
        return questionHeaderBindingData.copy(str, str2, str4, z, surveyPointImageBindingData2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSurveyPointIntroduction() {
        return this.surveyPointIntroduction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSurveyPointTitle() {
        return this.surveyPointTitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAnswerRequiredLabel() {
        return this.answerRequiredLabel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowAnswerRequiredLabel() {
        return this.showAnswerRequiredLabel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SurveyPointImageBindingData getImageBindingData() {
        return this.imageBindingData;
    }

    public final QuestionHeaderBindingData copy(String surveyPointIntroduction, String surveyPointTitle, String answerRequiredLabel, boolean showAnswerRequiredLabel, SurveyPointImageBindingData imageBindingData) {
        Intrinsics.checkNotNullParameter(surveyPointIntroduction, "surveyPointIntroduction");
        Intrinsics.checkNotNullParameter(surveyPointTitle, "surveyPointTitle");
        Intrinsics.checkNotNullParameter(answerRequiredLabel, "answerRequiredLabel");
        return new QuestionHeaderBindingData(surveyPointIntroduction, surveyPointTitle, answerRequiredLabel, showAnswerRequiredLabel, imageBindingData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionHeaderBindingData)) {
            return false;
        }
        QuestionHeaderBindingData questionHeaderBindingData = (QuestionHeaderBindingData) other;
        return Intrinsics.areEqual(this.surveyPointIntroduction, questionHeaderBindingData.surveyPointIntroduction) && Intrinsics.areEqual(this.surveyPointTitle, questionHeaderBindingData.surveyPointTitle) && Intrinsics.areEqual(this.answerRequiredLabel, questionHeaderBindingData.answerRequiredLabel) && this.showAnswerRequiredLabel == questionHeaderBindingData.showAnswerRequiredLabel && Intrinsics.areEqual(this.imageBindingData, questionHeaderBindingData.imageBindingData);
    }

    public int hashCode() {
        int iHashCode = ((((((this.surveyPointIntroduction.hashCode() * 31) + this.surveyPointTitle.hashCode()) * 31) + this.answerRequiredLabel.hashCode()) * 31) + Boolean.hashCode(this.showAnswerRequiredLabel)) * 31;
        SurveyPointImageBindingData surveyPointImageBindingData = this.imageBindingData;
        return iHashCode + (surveyPointImageBindingData == null ? 0 : surveyPointImageBindingData.hashCode());
    }

    public String toString() {
        return "QuestionHeaderBindingData(surveyPointIntroduction=" + this.surveyPointIntroduction + ", surveyPointTitle=" + this.surveyPointTitle + ", answerRequiredLabel=" + this.answerRequiredLabel + ", showAnswerRequiredLabel=" + this.showAnswerRequiredLabel + ", imageBindingData=" + this.imageBindingData + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.surveyPointIntroduction);
        dest.writeString(this.surveyPointTitle);
        dest.writeString(this.answerRequiredLabel);
        dest.writeInt(this.showAnswerRequiredLabel ? 1 : 0);
        SurveyPointImageBindingData surveyPointImageBindingData = this.imageBindingData;
        if (surveyPointImageBindingData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            surveyPointImageBindingData.writeToParcel(dest, flags);
        }
    }

    public QuestionHeaderBindingData(String surveyPointIntroduction, String surveyPointTitle, String answerRequiredLabel, boolean z, SurveyPointImageBindingData surveyPointImageBindingData) {
        Intrinsics.checkNotNullParameter(surveyPointIntroduction, "surveyPointIntroduction");
        Intrinsics.checkNotNullParameter(surveyPointTitle, "surveyPointTitle");
        Intrinsics.checkNotNullParameter(answerRequiredLabel, "answerRequiredLabel");
        this.surveyPointIntroduction = surveyPointIntroduction;
        this.surveyPointTitle = surveyPointTitle;
        this.answerRequiredLabel = answerRequiredLabel;
        this.showAnswerRequiredLabel = z;
        this.imageBindingData = surveyPointImageBindingData;
    }

    public final String getSurveyPointIntroduction() {
        return this.surveyPointIntroduction;
    }

    public final String getSurveyPointTitle() {
        return this.surveyPointTitle;
    }

    public final String getAnswerRequiredLabel() {
        return this.answerRequiredLabel;
    }

    public final boolean getShowAnswerRequiredLabel() {
        return this.showAnswerRequiredLabel;
    }

    public final SurveyPointImageBindingData getImageBindingData() {
        return this.imageBindingData;
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.widget.QuestionHeaderBindingData$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MicroQuestionHeader.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData$Factory;", "", "<init>", "()V", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
