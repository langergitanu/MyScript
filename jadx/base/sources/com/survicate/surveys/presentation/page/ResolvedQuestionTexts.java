package com.survicate.surveys.presentation.page;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "", "title", "", "introduction", "answerRequiredLabel", "commentHint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getIntroduction", "getAnswerRequiredLabel", "getCommentHint", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class ResolvedQuestionTexts {
    private final String answerRequiredLabel;
    private final String commentHint;
    private final String introduction;
    private final String title;

    public static /* synthetic */ ResolvedQuestionTexts copy$default(ResolvedQuestionTexts resolvedQuestionTexts, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resolvedQuestionTexts.title;
        }
        if ((i & 2) != 0) {
            str2 = resolvedQuestionTexts.introduction;
        }
        if ((i & 4) != 0) {
            str3 = resolvedQuestionTexts.answerRequiredLabel;
        }
        if ((i & 8) != 0) {
            str4 = resolvedQuestionTexts.commentHint;
        }
        return resolvedQuestionTexts.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAnswerRequiredLabel() {
        return this.answerRequiredLabel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCommentHint() {
        return this.commentHint;
    }

    public final ResolvedQuestionTexts copy(String title, String introduction, String answerRequiredLabel, String commentHint) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(answerRequiredLabel, "answerRequiredLabel");
        Intrinsics.checkNotNullParameter(commentHint, "commentHint");
        return new ResolvedQuestionTexts(title, introduction, answerRequiredLabel, commentHint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolvedQuestionTexts)) {
            return false;
        }
        ResolvedQuestionTexts resolvedQuestionTexts = (ResolvedQuestionTexts) other;
        return Intrinsics.areEqual(this.title, resolvedQuestionTexts.title) && Intrinsics.areEqual(this.introduction, resolvedQuestionTexts.introduction) && Intrinsics.areEqual(this.answerRequiredLabel, resolvedQuestionTexts.answerRequiredLabel) && Intrinsics.areEqual(this.commentHint, resolvedQuestionTexts.commentHint);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.introduction.hashCode()) * 31) + this.answerRequiredLabel.hashCode()) * 31) + this.commentHint.hashCode();
    }

    public String toString() {
        return "ResolvedQuestionTexts(title=" + this.title + ", introduction=" + this.introduction + ", answerRequiredLabel=" + this.answerRequiredLabel + ", commentHint=" + this.commentHint + ')';
    }

    public ResolvedQuestionTexts(String title, String introduction, String answerRequiredLabel, String commentHint) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(answerRequiredLabel, "answerRequiredLabel");
        Intrinsics.checkNotNullParameter(commentHint, "commentHint");
        this.title = title;
        this.introduction = introduction;
        this.answerRequiredLabel = answerRequiredLabel;
        this.commentHint = commentHint;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIntroduction() {
        return this.introduction;
    }

    public final String getAnswerRequiredLabel() {
        return this.answerRequiredLabel;
    }

    public final String getCommentHint() {
        return this.commentHint;
    }
}
