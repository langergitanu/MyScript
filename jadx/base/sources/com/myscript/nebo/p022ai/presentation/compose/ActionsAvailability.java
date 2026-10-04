package com.myscript.nebo.p022ai.presentation.compose;

import kotlin.Metadata;

/* JADX INFO: compiled from: AIContainerViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/ActionsAvailability;", "", "summarize", "", "explain", "quiz", "<init>", "(ZZZ)V", "getSummarize", "()Z", "getExplain", "getQuiz", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ActionsAvailability {
    public static final int $stable = 0;
    private final boolean explain;
    private final boolean quiz;
    private final boolean summarize;

    public static /* synthetic */ ActionsAvailability copy$default(ActionsAvailability actionsAvailability, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = actionsAvailability.summarize;
        }
        if ((i & 2) != 0) {
            z2 = actionsAvailability.explain;
        }
        if ((i & 4) != 0) {
            z3 = actionsAvailability.quiz;
        }
        return actionsAvailability.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSummarize() {
        return this.summarize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getExplain() {
        return this.explain;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getQuiz() {
        return this.quiz;
    }

    public final ActionsAvailability copy(boolean summarize, boolean explain, boolean quiz) {
        return new ActionsAvailability(summarize, explain, quiz);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionsAvailability)) {
            return false;
        }
        ActionsAvailability actionsAvailability = (ActionsAvailability) other;
        return this.summarize == actionsAvailability.summarize && this.explain == actionsAvailability.explain && this.quiz == actionsAvailability.quiz;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.summarize) * 31) + Boolean.hashCode(this.explain)) * 31) + Boolean.hashCode(this.quiz);
    }

    public String toString() {
        return "ActionsAvailability(summarize=" + this.summarize + ", explain=" + this.explain + ", quiz=" + this.quiz + ")";
    }

    public ActionsAvailability(boolean z, boolean z2, boolean z3) {
        this.summarize = z;
        this.explain = z2;
        this.quiz = z3;
    }

    public final boolean getExplain() {
        return this.explain;
    }

    public final boolean getQuiz() {
        return this.quiz;
    }

    public final boolean getSummarize() {
        return this.summarize;
    }
}
