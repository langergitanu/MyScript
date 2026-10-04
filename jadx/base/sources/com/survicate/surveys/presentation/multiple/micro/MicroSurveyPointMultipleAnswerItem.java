package com.survicate.surveys.presentation.multiple.micro;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: MicroSurveyPointMultipleAnswerItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0013\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/presentation/multiple/micro/MicroSurveyPointMultipleAnswerItem;", "Landroid/os/Parcelable;", "id", "", "title", "", "isCommentAvailable", "", "commentLabel", "commentHint", ClientCookie.COMMENT_ATTR, "isSelected", "isSingleSelection", "<init>", "(JLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "()Z", "getCommentLabel", "getCommentHint", "getComment", "setComment", "(Ljava/lang/String;)V", "setSelected", "(Z)V", "equals", "other", "", "hashCode", "", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointMultipleAnswerItem implements Parcelable {
    public static final Parcelable.Creator<MicroSurveyPointMultipleAnswerItem> CREATOR = new Creator();
    private String comment;
    private final String commentHint;
    private final String commentLabel;
    private final long id;
    private final boolean isCommentAvailable;
    private boolean isSelected;
    private final boolean isSingleSelection;
    private final String title;

    /* JADX INFO: compiled from: MicroSurveyPointMultipleAnswerItem.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<MicroSurveyPointMultipleAnswerItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointMultipleAnswerItem createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            boolean z4 = true;
            if (parcel.readInt() != 0) {
                z = true;
                z2 = false;
            } else {
                z = true;
                z4 = false;
                z2 = false;
            }
            String string2 = parcel.readString();
            boolean z5 = z2;
            String string3 = parcel.readString();
            boolean z6 = z5;
            String string4 = parcel.readString();
            if (parcel.readInt() != 0) {
                z3 = z6;
                z6 = z;
            } else {
                z3 = z6;
            }
            if (parcel.readInt() != 0) {
                z3 = z;
            }
            return new MicroSurveyPointMultipleAnswerItem(j, string, z4, string2, string3, string4, z6, z3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointMultipleAnswerItem[] newArray(int i) {
            return new MicroSurveyPointMultipleAnswerItem[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.isCommentAvailable ? 1 : 0);
        dest.writeString(this.commentLabel);
        dest.writeString(this.commentHint);
        dest.writeString(this.comment);
        dest.writeInt(this.isSelected ? 1 : 0);
        dest.writeInt(this.isSingleSelection ? 1 : 0);
    }

    public MicroSurveyPointMultipleAnswerItem(long j, String title, boolean z, String commentLabel, String commentHint, String comment, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(commentLabel, "commentLabel");
        Intrinsics.checkNotNullParameter(commentHint, "commentHint");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.id = j;
        this.title = title;
        this.isCommentAvailable = z;
        this.commentLabel = commentLabel;
        this.commentHint = commentHint;
        this.comment = comment;
        this.isSelected = z2;
        this.isSingleSelection = z3;
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isCommentAvailable, reason: from getter */
    public final boolean getIsCommentAvailable() {
        return this.isCommentAvailable;
    }

    public final String getCommentLabel() {
        return this.commentLabel;
    }

    public final String getCommentHint() {
        return this.commentHint;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.comment = str;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    /* JADX INFO: renamed from: isSingleSelection, reason: from getter */
    public final boolean getIsSingleSelection() {
        return this.isSingleSelection;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.survicate.surveys.presentation.multiple.micro.MicroSurveyPointMultipleAnswerItem");
        MicroSurveyPointMultipleAnswerItem microSurveyPointMultipleAnswerItem = (MicroSurveyPointMultipleAnswerItem) other;
        return this.id == microSurveyPointMultipleAnswerItem.id && Intrinsics.areEqual(this.title, microSurveyPointMultipleAnswerItem.title) && this.isCommentAvailable == microSurveyPointMultipleAnswerItem.isCommentAvailable && Intrinsics.areEqual(this.commentLabel, microSurveyPointMultipleAnswerItem.commentLabel) && Intrinsics.areEqual(this.commentHint, microSurveyPointMultipleAnswerItem.commentHint) && Intrinsics.areEqual(this.comment, microSurveyPointMultipleAnswerItem.comment) && this.isSelected == microSurveyPointMultipleAnswerItem.isSelected && this.isSingleSelection == microSurveyPointMultipleAnswerItem.isSingleSelection;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.isCommentAvailable)) * 31) + this.commentLabel.hashCode()) * 31) + this.commentHint.hashCode()) * 31) + this.comment.hashCode()) * 31) + Boolean.hashCode(this.isSelected)) * 31) + Boolean.hashCode(this.isSingleSelection);
    }
}
