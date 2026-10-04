package com.revenuecat.purchases.rules.customoperators;

import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemverOperator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/SemverOperator;", "", "()V", "ARGUMENT_COUNT", "", "opSemverCompare", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SemverOperator {
    private static final int ARGUMENT_COUNT = 2;
    public static final SemverOperator INSTANCE = new SemverOperator();

    private SemverOperator() {
    }

    public final Value opSemverCompare(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Operators.INSTANCE.checkArity(Operators.INSTANCE.evalArgs(args, vars).size(), CollectionsKt.listOf(2), "rc.semverCompare");
        return new Value.IntValue(SemanticVersion.INSTANCE.parse(r4.get(0)).compare(SemanticVersion.INSTANCE.parse(r4.get(1))));
    }
}
