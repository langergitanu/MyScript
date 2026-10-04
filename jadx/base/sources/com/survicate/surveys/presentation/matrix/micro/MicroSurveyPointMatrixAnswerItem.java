package com.survicate.surveys.presentation.matrix.micro;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointMatrixAnswerItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020(J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006/"}, m1599d2 = {"Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixAnswerItem;", "Landroid/os/Parcelable;", "id", "", "title", "", "columns", "", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixColumnItem;", "isCommentAvailable", "", "commentLabel", "commentHint", "selectedColumnId", "isExpanded", "<init>", "(JLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getColumns", "()Ljava/util/List;", "()Z", "getCommentLabel", "getCommentHint", "getSelectedColumnId", "()Ljava/lang/Long;", "setSelectedColumnId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "setExpanded", "(Z)V", "selectedColumn", "getSelectedColumn", "()Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixColumnItem;", "equals", "other", "", "hashCode", "", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointMatrixAnswerItem implements Parcelable {
    public static final Parcelable.Creator<MicroSurveyPointMatrixAnswerItem> CREATOR = new Creator();
    private final List<MicroSurveyPointMatrixColumnItem> columns;
    private final String commentHint;
    private final String commentLabel;
    private final long id;
    private final boolean isCommentAvailable;
    private boolean isExpanded;
    private Long selectedColumnId;
    private final String title;

    /* JADX INFO: compiled from: MicroSurveyPointMatrixAnswerItem.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<MicroSurveyPointMatrixAnswerItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointMatrixAnswerItem createFromParcel(Parcel parcel) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(MicroSurveyPointMatrixColumnItem.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            boolean z2 = true;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z2 = false;
            }
            return new MicroSurveyPointMatrixAnswerItem(j, string, arrayList2, z2, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? z : false);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MicroSurveyPointMatrixAnswerItem[] newArray(int i) {
            return new MicroSurveyPointMatrixAnswerItem[i];
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
        List<MicroSurveyPointMatrixColumnItem> list = this.columns;
        dest.writeInt(list.size());
        Iterator<MicroSurveyPointMatrixColumnItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeInt(this.isCommentAvailable ? 1 : 0);
        dest.writeString(this.commentLabel);
        dest.writeString(this.commentHint);
        Long l = this.selectedColumnId;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeInt(this.isExpanded ? 1 : 0);
    }

    public MicroSurveyPointMatrixAnswerItem(long j, String title, List<MicroSurveyPointMatrixColumnItem> columns, boolean z, String commentLabel, String commentHint, Long l, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(commentLabel, "commentLabel");
        Intrinsics.checkNotNullParameter(commentHint, "commentHint");
        this.id = j;
        this.title = title;
        this.columns = columns;
        this.isCommentAvailable = z;
        this.commentLabel = commentLabel;
        this.commentHint = commentHint;
        this.selectedColumnId = l;
        this.isExpanded = z2;
    }

    public /* synthetic */ MicroSurveyPointMatrixAnswerItem(long j, String str, List list, boolean z, String str2, String str3, Long l, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, list, z, str2, str3, (i & 64) != 0 ? null : l, (i & 128) != 0 ? false : z2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<MicroSurveyPointMatrixColumnItem> getColumns() {
        return this.columns;
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

    public final Long getSelectedColumnId() {
        return this.selectedColumnId;
    }

    public final void setSelectedColumnId(Long l) {
        this.selectedColumnId = l;
    }

    /* JADX INFO: renamed from: isExpanded, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    public final MicroSurveyPointMatrixColumnItem getSelectedColumn() {
        Object next;
        Iterator<T> it = this.columns.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            long id = ((MicroSurveyPointMatrixColumnItem) next).getId();
            Long l = this.selectedColumnId;
            if (l != null && id == l.longValue()) {
                break;
            }
        }
        return (MicroSurveyPointMatrixColumnItem) next;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixAnswerItem");
        MicroSurveyPointMatrixAnswerItem microSurveyPointMatrixAnswerItem = (MicroSurveyPointMatrixAnswerItem) other;
        return this.id == microSurveyPointMatrixAnswerItem.id && Intrinsics.areEqual(this.title, microSurveyPointMatrixAnswerItem.title) && Intrinsics.areEqual(this.columns, microSurveyPointMatrixAnswerItem.columns) && this.isCommentAvailable == microSurveyPointMatrixAnswerItem.isCommentAvailable && Intrinsics.areEqual(this.commentLabel, microSurveyPointMatrixAnswerItem.commentLabel) && Intrinsics.areEqual(this.commentHint, microSurveyPointMatrixAnswerItem.commentHint) && Intrinsics.areEqual(this.selectedColumnId, microSurveyPointMatrixAnswerItem.selectedColumnId) && this.isExpanded == microSurveyPointMatrixAnswerItem.isExpanded;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.columns.hashCode()) * 31) + Boolean.hashCode(this.isCommentAvailable)) * 31) + this.commentLabel.hashCode()) * 31) + this.commentHint.hashCode()) * 31;
        Long l = this.selectedColumnId;
        return ((iHashCode + (l != null ? l.hashCode() : 0)) * 31) + Boolean.hashCode(this.isExpanded);
    }
}
