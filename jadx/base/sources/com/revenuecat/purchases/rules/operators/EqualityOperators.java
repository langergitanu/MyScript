package com.revenuecat.purchases.rules.operators;

import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.ValueKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EqualityOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/EqualityOperators;", "", "()V", "opLooseEq", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opLooseNe", "opStrictEq", "opStrictNe", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class EqualityOperators {
    public static final EqualityOperators INSTANCE = new EqualityOperators();

    private EqualityOperators() {
    }

    public final Value opLooseEq(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<Value, Value> pairEvalTwo = Operators.INSTANCE.evalTwo(args, vars);
        return new Value.BoolValue(ValueKt.looseEq(pairEvalTwo.component1(), pairEvalTwo.component2()));
    }

    public final Value opLooseNe(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<Value, Value> pairEvalTwo = Operators.INSTANCE.evalTwo(args, vars);
        return new Value.BoolValue(!ValueKt.looseEq(pairEvalTwo.component1(), pairEvalTwo.component2()));
    }

    public final Value opStrictEq(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<Value, Value> pairEvalTwo = Operators.INSTANCE.evalTwo(args, vars);
        return new Value.BoolValue(ValueKt.strictEq(pairEvalTwo.component1(), pairEvalTwo.component2()));
    }

    public final Value opStrictNe(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<Value, Value> pairEvalTwo = Operators.INSTANCE.evalTwo(args, vars);
        return new Value.BoolValue(!ValueKt.strictEq(pairEvalTwo.component1(), pairEvalTwo.component2()));
    }
}
