package com.revenuecat.purchases.rules.customoperators;

import com.revenuecat.purchases.rules.Evaluator;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LetOperator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/LetOperator;", "", "()V", "ARGUMENT_COUNT", "", "bindings", "", "", "Lcom/revenuecat/purchases/rules/Value;", "declarations", "Lcom/revenuecat/purchases/rules/Value$ObjectValue;", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opLet", "args", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class LetOperator {
    private static final int ARGUMENT_COUNT = 2;
    public static final LetOperator INSTANCE = new LetOperator();

    private LetOperator() {
    }

    public final Value opLet(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listArgsAsList = Operators.INSTANCE.argsAsList(args);
        Operators.INSTANCE.checkArity(listArgsAsList.size(), CollectionsKt.listOf(2), "rc.let");
        Value value = listArgsAsList.get(0);
        if (!(value instanceof Value.ObjectValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.let' expected an object of bindings, got " + value);
        }
        return Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(listArgsAsList.get(1), vars.binding(bindings((Value.ObjectValue) value, vars)));
    }

    private final Map<String, Value> bindings(Value.ObjectValue declarations, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        List listSorted = CollectionsKt.sorted(declarations.getEntries().keySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSorted, 10)), 16));
        for (Object obj : listSorted) {
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            String str = (String) obj;
            String str2 = str;
            if (str2.length() == 0 || StringsKt.contains$default((CharSequence) str2, (CharSequence) ".", false, 2, (Object) null)) {
                throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.let' expected a binding name that is non-empty and free of '.', got '" + str + '\'');
            }
            Evaluator evaluator = Evaluator.INSTANCE;
            Value.Null r4 = declarations.getEntries().get(str);
            if (r4 == null) {
                r4 = Value.Null.INSTANCE;
            }
            linkedHashMap2.put(obj, evaluator.evaluateValue$purchases_defaultsRelease(r4, vars));
        }
        return linkedHashMap;
    }
}
