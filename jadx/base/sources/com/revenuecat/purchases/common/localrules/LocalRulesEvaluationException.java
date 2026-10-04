package com.revenuecat.purchases.common.localrules;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalRulesEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0006\u0007B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "DimensionResolution", "PredicateEvaluation", "Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluationException$DimensionResolution;", "Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluationException$PredicateEvaluation;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class LocalRulesEvaluationException extends Exception {
    public /* synthetic */ LocalRulesEvaluationException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private LocalRulesEvaluationException(String str) {
        super(str);
    }

    /* JADX INFO: compiled from: LocalRulesEvaluator.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluationException$PredicateEvaluation;", "Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluationException;", "ruleIndex", "", "error", "", "(ILjava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "getRuleIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class PredicateEvaluation extends LocalRulesEvaluationException {
        private final Throwable error;
        private final int ruleIndex;

        public static /* synthetic */ PredicateEvaluation copy$default(PredicateEvaluation predicateEvaluation, int i, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = predicateEvaluation.ruleIndex;
            }
            if ((i2 & 2) != 0) {
                th = predicateEvaluation.error;
            }
            return predicateEvaluation.copy(i, th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRuleIndex() {
            return this.ruleIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Throwable getError() {
            return this.error;
        }

        public final PredicateEvaluation copy(int ruleIndex, Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new PredicateEvaluation(ruleIndex, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PredicateEvaluation)) {
                return false;
            }
            PredicateEvaluation predicateEvaluation = (PredicateEvaluation) other;
            return this.ruleIndex == predicateEvaluation.ruleIndex && Intrinsics.areEqual(this.error, predicateEvaluation.error);
        }

        public int hashCode() {
            return (Integer.hashCode(this.ruleIndex) * 31) + this.error.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "PredicateEvaluation(ruleIndex=" + this.ruleIndex + ", error=" + this.error + ')';
        }

        public final int getRuleIndex() {
            return this.ruleIndex;
        }

        public final Throwable getError() {
            return this.error;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PredicateEvaluation(int i, Throwable error) {
            super("rule at index " + i + " could not be evaluated: " + error.getMessage(), null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.ruleIndex = i;
            this.error = error;
        }
    }

    /* JADX INFO: compiled from: LocalRulesEvaluator.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluationException$DimensionResolution;", "Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluationException;", "reason", "", "(Ljava/lang/Throwable;)V", "getReason", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class DimensionResolution extends LocalRulesEvaluationException {
        private final Throwable reason;

        public static /* synthetic */ DimensionResolution copy$default(DimensionResolution dimensionResolution, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = dimensionResolution.reason;
            }
            return dimensionResolution.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getReason() {
            return this.reason;
        }

        public final DimensionResolution copy(Throwable reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new DimensionResolution(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DimensionResolution) && Intrinsics.areEqual(this.reason, ((DimensionResolution) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "DimensionResolution(reason=" + this.reason + ')';
        }

        public final Throwable getReason() {
            return this.reason;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DimensionResolution(Throwable reason) {
            super("dimensions could not be collected: " + reason.getMessage(), null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }
    }
}
