package com.survicate.surveys.entities.views;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputValidationView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/entities/views/InputValidationResult;", "", "isSuccess", "", "errorMessage", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class InputValidationResult {
    private final String errorMessage;
    private final boolean isSuccess;

    public static /* synthetic */ InputValidationResult copy$default(InputValidationResult inputValidationResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = inputValidationResult.isSuccess;
        }
        if ((i & 2) != 0) {
            str = inputValidationResult.errorMessage;
        }
        return inputValidationResult.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final InputValidationResult copy(boolean isSuccess, String errorMessage) {
        return new InputValidationResult(isSuccess, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputValidationResult)) {
            return false;
        }
        InputValidationResult inputValidationResult = (InputValidationResult) other;
        return this.isSuccess == inputValidationResult.isSuccess && Intrinsics.areEqual(this.errorMessage, inputValidationResult.errorMessage);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isSuccess) * 31;
        String str = this.errorMessage;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InputValidationResult(isSuccess=" + this.isSuccess + ", errorMessage=" + this.errorMessage + ')';
    }

    public InputValidationResult(boolean z, String str) {
        this.isSuccess = z;
        this.errorMessage = str;
    }

    public /* synthetic */ InputValidationResult(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
