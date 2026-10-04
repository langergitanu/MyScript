package com.survicate.surveys.presentation.text;

import kotlin.Metadata;

/* JADX INFO: compiled from: TextQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/FollowUpResult;", "", "Success", "Error", "Lcom/survicate/surveys/presentation/text/FollowUpResult$Error;", "Lcom/survicate/surveys/presentation/text/FollowUpResult$Success;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface FollowUpResult {

    /* JADX INFO: compiled from: TextQuestionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/FollowUpResult$Success;", "Lcom/survicate/surveys/presentation/text/FollowUpResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Success implements FollowUpResult {
        public static final Success INSTANCE = new Success();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1270312873;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
        }
    }

    /* JADX INFO: compiled from: TextQuestionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/FollowUpResult$Error;", "Lcom/survicate/surveys/presentation/text/FollowUpResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class Error implements FollowUpResult {
        public static final Error INSTANCE = new Error();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 649769774;
        }

        public String toString() {
            return "Error";
        }

        private Error() {
        }
    }
}
