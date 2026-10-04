package com.revenuecat.purchases.rules.customoperators;

import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaseOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/CaseOperators;", "", "()V", "opLower", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opUpper", "stringArgument", "", "operatorName", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CaseOperators {
    public static final CaseOperators INSTANCE = new CaseOperators();

    private CaseOperators() {
    }

    public final Value opLower(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        String lowerCase = stringArgument(args, vars, "rc.lower").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Value.StringValue(lowerCase);
    }

    public final Value opUpper(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        String upperCase = stringArgument(args, vars, "rc.upper").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return new Value.StringValue(upperCase);
    }

    private final String stringArgument(Value args, Scope vars, String operatorName) throws RulesEngine.EvaluationException.TypeMismatch {
        Value valueFirstArgEvaluated = Operators.INSTANCE.firstArgEvaluated(args, vars);
        if (!(valueFirstArgEvaluated instanceof Value.StringValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator '" + operatorName + "' expected string, got " + valueFirstArgEvaluated);
        }
        return ((Value.StringValue) valueFirstArgEvaluated).getValue();
    }
}
