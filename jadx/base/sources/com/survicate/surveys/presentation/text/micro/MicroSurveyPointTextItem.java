package com.survicate.surveys.presentation.text.micro;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointTextAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0007J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextItem;", "Landroid/os/Parcelable;", "header", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "answer", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextAnswer;", "maxAnswerCharacterCount", "", "<init>", "(Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextAnswer;I)V", "getHeader", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getAnswer", "()Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextAnswer;", "getMaxAnswerCharacterCount", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class MicroSurveyPointTextItem implements Parcelable {
    public static final Parcelable.Creator<MicroSurveyPointTextItem> CREATOR = new Creator();
    private final MicroSurveyPointTextAnswer answer;
    private final QuestionHeaderBindingData header;
    private final int maxAnswerCharacterCount;

    /* JADX INFO: compiled from: MicroSurveyPointTextAnswer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<MicroSurveyPointTextItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointTextItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MicroSurveyPointTextItem(QuestionHeaderBindingData.CREATOR.createFromParcel(parcel), MicroSurveyPointTextAnswer.CREATOR.createFromParcel(parcel), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointTextItem[] newArray(int i) {
            return new MicroSurveyPointTextItem[i];
        }
    }

    public static /* synthetic */ MicroSurveyPointTextItem copy$default(MicroSurveyPointTextItem microSurveyPointTextItem, QuestionHeaderBindingData questionHeaderBindingData, MicroSurveyPointTextAnswer microSurveyPointTextAnswer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            questionHeaderBindingData = microSurveyPointTextItem.header;
        }
        if ((i2 & 2) != 0) {
            microSurveyPointTextAnswer = microSurveyPointTextItem.answer;
        }
        if ((i2 & 4) != 0) {
            i = microSurveyPointTextItem.maxAnswerCharacterCount;
        }
        return microSurveyPointTextItem.copy(questionHeaderBindingData, microSurveyPointTextAnswer, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final QuestionHeaderBindingData getHeader() {
        return this.header;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MicroSurveyPointTextAnswer getAnswer() {
        return this.answer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMaxAnswerCharacterCount() {
        return this.maxAnswerCharacterCount;
    }

    public final MicroSurveyPointTextItem copy(QuestionHeaderBindingData header, MicroSurveyPointTextAnswer answer, int maxAnswerCharacterCount) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new MicroSurveyPointTextItem(header, answer, maxAnswerCharacterCount);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MicroSurveyPointTextItem)) {
            return false;
        }
        MicroSurveyPointTextItem microSurveyPointTextItem = (MicroSurveyPointTextItem) other;
        return Intrinsics.areEqual(this.header, microSurveyPointTextItem.header) && Intrinsics.areEqual(this.answer, microSurveyPointTextItem.answer) && this.maxAnswerCharacterCount == microSurveyPointTextItem.maxAnswerCharacterCount;
    }

    public int hashCode() {
        return (((this.header.hashCode() * 31) + this.answer.hashCode()) * 31) + Integer.hashCode(this.maxAnswerCharacterCount);
    }

    public String toString() {
        return "MicroSurveyPointTextItem(header=" + this.header + ", answer=" + this.answer + ", maxAnswerCharacterCount=" + this.maxAnswerCharacterCount + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.header.writeToParcel(dest, flags);
        this.answer.writeToParcel(dest, flags);
        dest.writeInt(this.maxAnswerCharacterCount);
    }

    public MicroSurveyPointTextItem(QuestionHeaderBindingData header, MicroSurveyPointTextAnswer answer, int i) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.header = header;
        this.answer = answer;
        this.maxAnswerCharacterCount = i;
    }

    public /* synthetic */ MicroSurveyPointTextItem(QuestionHeaderBindingData questionHeaderBindingData, MicroSurveyPointTextAnswer microSurveyPointTextAnswer, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(questionHeaderBindingData, microSurveyPointTextAnswer, (i2 & 4) != 0 ? 0 : i);
    }

    public final QuestionHeaderBindingData getHeader() {
        return this.header;
    }

    public final MicroSurveyPointTextAnswer getAnswer() {
        return this.answer;
    }

    public final int getMaxAnswerCharacterCount() {
        return this.maxAnswerCharacterCount;
    }
}
