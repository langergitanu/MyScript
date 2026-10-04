package com.survicate.surveys.core.logic.display.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: QuestionAnswered.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/MatrixAnswer;", "", "rowId", "", "columnId", "<init>", "(JJ)V", "getRowId", "()J", "getColumnId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class MatrixAnswer {
    private final long columnId;
    private final long rowId;

    public static /* synthetic */ MatrixAnswer copy$default(MatrixAnswer matrixAnswer, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = matrixAnswer.rowId;
        }
        if ((i & 2) != 0) {
            j2 = matrixAnswer.columnId;
        }
        return matrixAnswer.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getRowId() {
        return this.rowId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getColumnId() {
        return this.columnId;
    }

    public final MatrixAnswer copy(long rowId, long columnId) {
        return new MatrixAnswer(rowId, columnId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixAnswer)) {
            return false;
        }
        MatrixAnswer matrixAnswer = (MatrixAnswer) other;
        return this.rowId == matrixAnswer.rowId && this.columnId == matrixAnswer.columnId;
    }

    public int hashCode() {
        return (Long.hashCode(this.rowId) * 31) + Long.hashCode(this.columnId);
    }

    public String toString() {
        return "MatrixAnswer(rowId=" + this.rowId + ", columnId=" + this.columnId + ')';
    }

    public MatrixAnswer(long j, long j2) {
        this.rowId = j;
        this.columnId = j2;
    }

    public final long getColumnId() {
        return this.columnId;
    }

    public final long getRowId() {
        return this.rowId;
    }
}
