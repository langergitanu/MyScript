package com.survicate.surveys.presentation.text.micro;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointTextAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextAnswer;", "Landroid/os/Parcelable;", "input", "", "inputHint", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "getInputHint", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointTextAnswer implements Parcelable {
    public static final Parcelable.Creator<MicroSurveyPointTextAnswer> CREATOR = new Creator();
    private String input;
    private final String inputHint;

    /* JADX INFO: compiled from: MicroSurveyPointTextAnswer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<MicroSurveyPointTextAnswer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointTextAnswer createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MicroSurveyPointTextAnswer(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointTextAnswer[] newArray(int i) {
            return new MicroSurveyPointTextAnswer[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.input);
        dest.writeString(this.inputHint);
    }

    public MicroSurveyPointTextAnswer(String input, String inputHint) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(inputHint, "inputHint");
        this.input = input;
        this.inputHint = inputHint;
    }

    public final String getInput() {
        return this.input;
    }

    public final void setInput(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.input = str;
    }

    public final String getInputHint() {
        return this.inputHint;
    }
}
