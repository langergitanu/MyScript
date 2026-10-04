package com.revenuecat.purchases.rules.operators;

import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MinMaxOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J:\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rH\u0002¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/MinMaxOperators;", "", "()V", "opMax", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opMin", "reduceExtremum", "empty", "", "combine", "Lkotlin/Function2;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class MinMaxOperators {
    public static final MinMaxOperators INSTANCE = new MinMaxOperators();

    private MinMaxOperators() {
    }

    public final Value opMax(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return reduceExtremum(args, vars, Double.NEGATIVE_INFINITY, new Function2<Double, Double, Double>() { // from class: com.revenuecat.purchases.rules.operators.MinMaxOperators.opMax.1
            public final Double invoke(double d, double d2) {
                return Double.valueOf(Math.max(d, d2));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Double invoke(Double d, Double d2) {
                return invoke(d.doubleValue(), d2.doubleValue());
            }
        });
    }

    public final Value opMin(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return reduceExtremum(args, vars, Double.POSITIVE_INFINITY, new Function2<Double, Double, Double>() { // from class: com.revenuecat.purchases.rules.operators.MinMaxOperators.opMin.1
            public final Double invoke(double d, double d2) {
                return Double.valueOf(Math.min(d, d2));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Double invoke(Double d, Double d2) {
                return invoke(d.doubleValue(), d2.doubleValue());
            }
        });
    }

    private final Value reduceExtremum(Value args, Scope vars, double empty, Function2<? super Double, ? super Double, Double> combine) {
        Iterator<T> it = Operators.INSTANCE.evalArgs(args, vars).iterator();
        while (it.hasNext()) {
            Double numberOrNull$purchases_defaultsRelease = ((Value) it.next()).toNumberOrNull$purchases_defaultsRelease();
            double dDoubleValue = numberOrNull$purchases_defaultsRelease != null ? numberOrNull$purchases_defaultsRelease.doubleValue() : Double.NaN;
            empty = (Double.isNaN(empty) || Double.isNaN(dDoubleValue)) ? Double.NaN : combine.invoke(Double.valueOf(empty), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return new Value.FloatValue(empty);
    }
}
