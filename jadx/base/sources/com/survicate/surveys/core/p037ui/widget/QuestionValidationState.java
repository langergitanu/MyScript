package com.survicate.surveys.core.p037ui.widget;

import kotlin.Metadata;

/* JADX INFO: compiled from: SubmitViewState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/QuestionValidationState;", "", "isSuccess", "", "hideDefaultSubmitButton", "<init>", "(ZZ)V", "()Z", "getHideDefaultSubmitButton", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class QuestionValidationState {
    private final boolean hideDefaultSubmitButton;
    private final boolean isSuccess;

    public static /* synthetic */ QuestionValidationState copy$default(QuestionValidationState questionValidationState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = questionValidationState.isSuccess;
        }
        if ((i & 2) != 0) {
            z2 = questionValidationState.hideDefaultSubmitButton;
        }
        return questionValidationState.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHideDefaultSubmitButton() {
        return this.hideDefaultSubmitButton;
    }

    public final QuestionValidationState copy(boolean isSuccess, boolean hideDefaultSubmitButton) {
        return new QuestionValidationState(isSuccess, hideDefaultSubmitButton);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionValidationState)) {
            return false;
        }
        QuestionValidationState questionValidationState = (QuestionValidationState) other;
        return this.isSuccess == questionValidationState.isSuccess && this.hideDefaultSubmitButton == questionValidationState.hideDefaultSubmitButton;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isSuccess) * 31) + Boolean.hashCode(this.hideDefaultSubmitButton);
    }

    public String toString() {
        return "QuestionValidationState(isSuccess=" + this.isSuccess + ", hideDefaultSubmitButton=" + this.hideDefaultSubmitButton + ')';
    }

    public QuestionValidationState(boolean z, boolean z2) {
        this.isSuccess = z;
        this.hideDefaultSubmitButton = z2;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final boolean getHideDefaultSubmitButton() {
        return this.hideDefaultSubmitButton;
    }
}
