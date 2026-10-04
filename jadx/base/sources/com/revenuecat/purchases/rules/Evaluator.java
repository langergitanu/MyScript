package com.revenuecat.purchases.rules;

import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Evaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bJ\u001d\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Evaluator;", "", "()V", "evaluate", "", "predicate", "Lcom/revenuecat/purchases/rules/Value;", "variables", "", "", "evaluateValue", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "evaluateValue$purchases_defaultsRelease", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class Evaluator {
    public static final Evaluator INSTANCE = new Evaluator();

    private Evaluator() {
    }

    public final boolean evaluate(Value predicate, Map<String, ? extends Value> variables) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(variables, "variables");
        return evaluateValue$purchases_defaultsRelease(predicate, new Scope(new Value.ObjectValue(variables))).isTruthy$purchases_defaultsRelease();
    }

    public final Value evaluateValue$purchases_defaultsRelease(Value predicate, Scope vars) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(vars, "vars");
        if (Intrinsics.areEqual(predicate, Value.Null.INSTANCE) ? true : Intrinsics.areEqual(predicate, Value.Undefined.INSTANCE) ? true : predicate instanceof Value.BoolValue ? true : predicate instanceof Value.IntValue ? true : predicate instanceof Value.FloatValue ? true : predicate instanceof Value.StringValue) {
            return predicate;
        }
        if (predicate instanceof Value.ArrayValue) {
            List<Value> items = ((Value.ArrayValue) predicate).getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.evaluateValue$purchases_defaultsRelease((Value) it.next(), vars));
            }
            return new Value.ArrayValue(arrayList);
        }
        if (predicate instanceof Value.ObjectValue) {
            Map<String, Value> entries = ((Value.ObjectValue) predicate).getEntries();
            if (entries.size() != 1) {
                return predicate;
            }
            Map.Entry entry = (Map.Entry) CollectionsKt.first(entries.entrySet());
            return Operators.INSTANCE.dispatch((String) entry.getKey(), (Value) entry.getValue(), vars);
        }
        throw new NoWhenBranchMatchedException();
    }
}
