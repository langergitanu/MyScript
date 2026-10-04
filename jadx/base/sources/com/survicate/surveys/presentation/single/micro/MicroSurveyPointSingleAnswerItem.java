package com.survicate.surveys.presentation.single.micro;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: MicroSurveyPointSingleAnswerItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020\"J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0019\u0010\u001a¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleAnswerItem;", "Landroid/os/Parcelable;", "id", "", "title", "", "isCommentAvailable", "", "isCommentMandatory", "commentLabel", "commentHint", ClientCookie.COMMENT_ATTR, "isSelected", "<init>", "(JLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "()Z", "getCommentLabel", "getCommentHint", "getComment", "setComment", "(Ljava/lang/String;)V", "setSelected", "(Z)V", "getContentDescription", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "equals", "other", "", "hashCode", "", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointSingleAnswerItem implements Parcelable {
    public static final Parcelable.Creator<MicroSurveyPointSingleAnswerItem> CREATOR = new Creator();
    private String comment;
    private final String commentHint;
    private final String commentLabel;
    private final long id;
    private final boolean isCommentAvailable;
    private final boolean isCommentMandatory;
    private boolean isSelected;
    private final String title;

    /* JADX INFO: compiled from: MicroSurveyPointSingleAnswerItem.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<MicroSurveyPointSingleAnswerItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointSingleAnswerItem createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            boolean z3 = true;
            boolean z4 = false;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (parcel.readInt() != 0) {
                z2 = false;
                z4 = z;
            } else {
                z2 = false;
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            boolean z5 = z2;
            String string4 = parcel.readString();
            if (parcel.readInt() != 0) {
                z5 = z;
            }
            return new MicroSurveyPointSingleAnswerItem(j, string, z3, z4, string2, string3, string4, z5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointSingleAnswerItem[] newArray(int i) {
            return new MicroSurveyPointSingleAnswerItem[i];
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
        dest.writeInt(this.isCommentMandatory ? 1 : 0);
        dest.writeString(this.commentLabel);
        dest.writeString(this.commentHint);
        dest.writeString(this.comment);
        dest.writeInt(this.isSelected ? 1 : 0);
    }

    public MicroSurveyPointSingleAnswerItem(long j, String title, boolean z, boolean z2, String commentLabel, String commentHint, String comment, boolean z3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(commentLabel, "commentLabel");
        Intrinsics.checkNotNullParameter(commentHint, "commentHint");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.id = j;
        this.title = title;
        this.isCommentAvailable = z;
        this.isCommentMandatory = z2;
        this.commentLabel = commentLabel;
        this.commentHint = commentHint;
        this.comment = comment;
        this.isSelected = z3;
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

    /* JADX INFO: renamed from: isCommentMandatory, reason: from getter */
    public final boolean getIsCommentMandatory() {
        return this.isCommentMandatory;
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

    public final String getContentDescription(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isSelected && this.isCommentAvailable && this.isCommentMandatory && StringsKt.isBlank(this.commentLabel)) {
            return context.getString(C8369R.string.survicate_micro_comment_required_content_description, this.title);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleAnswerItem");
        MicroSurveyPointSingleAnswerItem microSurveyPointSingleAnswerItem = (MicroSurveyPointSingleAnswerItem) other;
        return this.id == microSurveyPointSingleAnswerItem.id && this.isCommentAvailable == microSurveyPointSingleAnswerItem.isCommentAvailable && this.isCommentMandatory == microSurveyPointSingleAnswerItem.isCommentMandatory && this.isSelected == microSurveyPointSingleAnswerItem.isSelected && Intrinsics.areEqual(this.title, microSurveyPointSingleAnswerItem.title) && Intrinsics.areEqual(this.commentLabel, microSurveyPointSingleAnswerItem.commentLabel) && Intrinsics.areEqual(this.commentHint, microSurveyPointSingleAnswerItem.commentHint) && Intrinsics.areEqual(this.comment, microSurveyPointSingleAnswerItem.comment);
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.id) * 31) + Boolean.hashCode(this.isCommentAvailable)) * 31) + Boolean.hashCode(this.isCommentMandatory)) * 31) + Boolean.hashCode(this.isSelected)) * 31) + this.title.hashCode()) * 31) + this.commentLabel.hashCode()) * 31) + this.commentHint.hashCode()) * 31) + this.comment.hashCode();
    }
}
