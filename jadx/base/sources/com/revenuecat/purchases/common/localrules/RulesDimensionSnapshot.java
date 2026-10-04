package com.revenuecat.purchases.common.localrules;

import com.revenuecat.purchases.rules.Value;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RulesDimensionResolver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionSnapshot;", "", "values", "", "", "Lcom/revenuecat/purchases/rules/Value;", "evaluationDate", "Ljava/util/Date;", "(Ljava/util/Map;Ljava/util/Date;)V", "getEvaluationDate", "()Ljava/util/Date;", "getValues", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class RulesDimensionSnapshot {
    private final Date evaluationDate;
    private final Map<String, Value> values;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RulesDimensionSnapshot copy$default(RulesDimensionSnapshot rulesDimensionSnapshot, Map map, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            map = rulesDimensionSnapshot.values;
        }
        if ((i & 2) != 0) {
            date = rulesDimensionSnapshot.evaluationDate;
        }
        return rulesDimensionSnapshot.copy(map, date);
    }

    public final Map<String, Value> component1() {
        return this.values;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getEvaluationDate() {
        return this.evaluationDate;
    }

    public final RulesDimensionSnapshot copy(Map<String, ? extends Value> values, Date evaluationDate) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(evaluationDate, "evaluationDate");
        return new RulesDimensionSnapshot(values, evaluationDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RulesDimensionSnapshot)) {
            return false;
        }
        RulesDimensionSnapshot rulesDimensionSnapshot = (RulesDimensionSnapshot) other;
        return Intrinsics.areEqual(this.values, rulesDimensionSnapshot.values) && Intrinsics.areEqual(this.evaluationDate, rulesDimensionSnapshot.evaluationDate);
    }

    public int hashCode() {
        return (this.values.hashCode() * 31) + this.evaluationDate.hashCode();
    }

    public String toString() {
        return "RulesDimensionSnapshot(values=" + this.values + ", evaluationDate=" + this.evaluationDate + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RulesDimensionSnapshot(Map<String, ? extends Value> values, Date evaluationDate) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(evaluationDate, "evaluationDate");
        this.values = values;
        this.evaluationDate = evaluationDate;
    }

    public final Map<String, Value> getValues() {
        return this.values;
    }

    public final Date getEvaluationDate() {
        return this.evaluationDate;
    }
}
