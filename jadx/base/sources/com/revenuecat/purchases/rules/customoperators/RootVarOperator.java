package com.revenuecat.purchases.rules.customoperators;

import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.AccessorOperators;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootVarOperator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/RootVarOperator;", "", "()V", "opRootVar", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RootVarOperator {
    public static final RootVarOperator INSTANCE = new RootVarOperator();

    private RootVarOperator() {
    }

    public final Value opRootVar(Value args, final Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return AccessorOperators.INSTANCE.resolveVar(args, new Function1<String, Value>() { // from class: com.revenuecat.purchases.rules.customoperators.RootVarOperator.opRootVar.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Value invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessorOperators.INSTANCE.lookupVar(vars.getRoot(), it);
            }
        }, vars, "rc.rootVar");
    }
}
