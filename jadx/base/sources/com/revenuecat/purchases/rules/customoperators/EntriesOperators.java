package com.revenuecat.purchases.rules.customoperators;

import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.ValueKt;
import com.revenuecat.purchases.rules.operators.Operators;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EntriesOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/EntriesOperators;", "", "()V", "opEntries", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opFromEntries", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class EntriesOperators {
    public static final EntriesOperators INSTANCE = new EntriesOperators();

    private EntriesOperators() {
    }

    public final Value opEntries(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Value valueFirstArgEvaluated = Operators.INSTANCE.firstArgEvaluated(args, vars);
        if (valueFirstArgEvaluated instanceof Value.ObjectValue) {
            Value.ObjectValue objectValue = (Value.ObjectValue) valueFirstArgEvaluated;
            List<String> listSorted = CollectionsKt.sorted(objectValue.getEntries().keySet());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSorted, 10));
            for (String str : listSorted) {
                Value[] valueArr = new Value[2];
                valueArr[0] = new Value.StringValue(str);
                Value.Null r1 = objectValue.getEntries().get(str);
                if (r1 == null) {
                    r1 = Value.Null.INSTANCE;
                }
                valueArr[1] = r1;
                arrayList.add(new Value.ArrayValue(CollectionsKt.listOf((Object[]) valueArr)));
            }
            return new Value.ArrayValue(arrayList);
        }
        if (valueFirstArgEvaluated instanceof Value.ArrayValue) {
            List<Value> items = ((Value.ArrayValue) valueFirstArgEvaluated).getItems();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            int i = 0;
            for (Object obj : items) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add(new Value.ArrayValue(CollectionsKt.listOf((Object[]) new Value[]{new Value.StringValue(String.valueOf(i)), (Value) obj})));
                i = i2;
            }
            return new Value.ArrayValue(arrayList2);
        }
        throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.entries' expected object or array, got " + valueFirstArgEvaluated);
    }

    public final Value opFromEntries(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Value valueFirstArgEvaluated = Operators.INSTANCE.firstArgEvaluated(args, vars);
        if (!(valueFirstArgEvaluated instanceof Value.ArrayValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.fromEntries' expected array, got " + valueFirstArgEvaluated);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Value value : ((Value.ArrayValue) valueFirstArgEvaluated).getItems()) {
            if (value instanceof Value.ArrayValue) {
                Value.ArrayValue arrayValue = (Value.ArrayValue) value;
                if (arrayValue.getItems().size() == 2) {
                    linkedHashMap.put(ValueKt.jsString(arrayValue.getItems().get(0)), arrayValue.getItems().get(1));
                }
            }
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.fromEntries' expected a two-element [key, value] entry, got " + value);
        }
        return new Value.ObjectValue(linkedHashMap);
    }
}
