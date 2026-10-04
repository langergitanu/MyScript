package com.revenuecat.purchases.rules.customoperators;

import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SplitOperator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/SplitOperator;", "", "()V", "ARGUMENT_COUNT", "", "opSplit", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SplitOperator {
    private static final int ARGUMENT_COUNT = 2;
    public static final SplitOperator INSTANCE = new SplitOperator();

    private SplitOperator() {
    }

    public final Value opSplit(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Operators.INSTANCE.checkArity(listEvalArgs.size(), CollectionsKt.listOf(2), "rc.split");
        Value value = listEvalArgs.get(0);
        if (!(value instanceof Value.StringValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.split' expected a string to split, got " + value);
        }
        Value value2 = listEvalArgs.get(1);
        if (value2 instanceof Value.StringValue) {
            Value.StringValue stringValue = (Value.StringValue) value2;
            if (stringValue.getValue().length() != 0) {
                List listSplit$default = StringsKt.split$default((CharSequence) ((Value.StringValue) value).getValue(), new String[]{stringValue.getValue()}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Value.StringValue((String) it.next()));
                }
                return new Value.ArrayValue(arrayList);
            }
        }
        throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.split' expected a non-empty string separator, got " + value2);
    }
}
