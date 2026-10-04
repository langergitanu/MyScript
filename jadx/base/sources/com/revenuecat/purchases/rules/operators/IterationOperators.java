package com.revenuecat.purchases.rules.operators;

import com.revenuecat.purchases.rules.Evaluator;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IterationOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J,\u0010\r\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/IterationOperators;", "", "()V", "opAll", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opFilter", "opMap", "opNone", "opReduce", "opSome", "parseIterationArgs", "Lkotlin/Pair;", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class IterationOperators {
    public static final IterationOperators INSTANCE = new IterationOperators();

    private IterationOperators() {
    }

    public final Value opSome(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<List<Value>, Value> iterationArgs = parseIterationArgs(args, vars);
        List<Value> listComponent1 = iterationArgs.component1();
        Value valueComponent2 = iterationArgs.component2();
        boolean z = false;
        if (listComponent1 != null) {
            List<Value> list = listComponent1;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(valueComponent2, vars.scoped((Value) it.next())).isTruthy$purchases_defaultsRelease()) {
                        z = true;
                        break;
                    }
                }
            }
        }
        return new Value.BoolValue(z);
    }

    public final Value opAll(Value args, Scope vars) {
        boolean z;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<List<Value>, Value> iterationArgs = parseIterationArgs(args, vars);
        List<Value> listComponent1 = iterationArgs.component1();
        Value valueComponent2 = iterationArgs.component2();
        List<Value> list = listComponent1;
        if (list == null || list.isEmpty()) {
            z = false;
            break;
        }
        List<Value> list2 = listComponent1;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (!Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(valueComponent2, vars.scoped((Value) it.next())).isTruthy$purchases_defaultsRelease()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        return new Value.BoolValue(z);
    }

    public final Value opNone(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<List<Value>, Value> iterationArgs = parseIterationArgs(args, vars);
        List<Value> listComponent1 = iterationArgs.component1();
        Value valueComponent2 = iterationArgs.component2();
        boolean z = true;
        if (listComponent1 != null) {
            List<Value> list = listComponent1;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(valueComponent2, vars.scoped((Value) it.next())).isTruthy$purchases_defaultsRelease()) {
                        z = false;
                        break;
                    }
                }
            }
        }
        return new Value.BoolValue(z);
    }

    public final Value opMap(Value args, Scope vars) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<List<Value>, Value> iterationArgs = parseIterationArgs(args, vars);
        List<Value> listComponent1 = iterationArgs.component1();
        Value valueComponent2 = iterationArgs.component2();
        if (listComponent1 != null) {
            List<Value> list = listComponent1;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(valueComponent2, vars.scoped((Value) it.next())));
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        return new Value.ArrayValue(arrayListEmptyList);
    }

    public final Value opFilter(Value args, Scope vars) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<List<Value>, Value> iterationArgs = parseIterationArgs(args, vars);
        List<Value> listComponent1 = iterationArgs.component1();
        Value valueComponent2 = iterationArgs.component2();
        if (listComponent1 == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listComponent1) {
                if (Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(valueComponent2, vars.scoped((Value) obj)).isTruthy$purchases_defaultsRelease()) {
                    arrayList.add(obj);
                }
            }
            arrayListEmptyList = arrayList;
        }
        return new Value.ArrayValue(arrayListEmptyList);
    }

    public final Value opReduce(Value args, Scope vars) {
        Value.Null nullEvaluateValue$purchases_defaultsRelease;
        List<Value> items;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listArgsAsList = Operators.INSTANCE.argsAsList(args);
        Value.Null r1 = (Value) CollectionsKt.getOrNull(listArgsAsList, 0);
        if (r1 == null) {
            r1 = Value.Null.INSTANCE;
        }
        Value.Undefined undefined = (Value) CollectionsKt.getOrNull(listArgsAsList, 1);
        if (undefined == null) {
            undefined = Value.Undefined.INSTANCE;
        }
        Value valueEvaluateValue$purchases_defaultsRelease = Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(r1, vars);
        Value value = (Value) CollectionsKt.getOrNull(listArgsAsList, 2);
        if (value == null || (nullEvaluateValue$purchases_defaultsRelease = Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(value, vars)) == null) {
            nullEvaluateValue$purchases_defaultsRelease = Value.Null.INSTANCE;
        }
        Value.ArrayValue arrayValue = valueEvaluateValue$purchases_defaultsRelease instanceof Value.ArrayValue ? (Value.ArrayValue) valueEvaluateValue$purchases_defaultsRelease : null;
        if (arrayValue != null && (items = arrayValue.getItems()) != null) {
            Iterator<Value> it = items.iterator();
            while (it.hasNext()) {
                nullEvaluateValue$purchases_defaultsRelease = Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(undefined, vars.scoped(new Value.ObjectValue(MapsKt.mapOf(TuplesKt.m1606to("current", it.next()), TuplesKt.m1606to("accumulator", nullEvaluateValue$purchases_defaultsRelease)))));
            }
        }
        return nullEvaluateValue$purchases_defaultsRelease;
    }

    private final Pair<List<Value>, Value> parseIterationArgs(Value args, Scope vars) {
        List<Value> listArgsAsList = Operators.INSTANCE.argsAsList(args);
        Value.Null r0 = (Value) CollectionsKt.getOrNull(listArgsAsList, 0);
        if (r0 == null) {
            r0 = Value.Null.INSTANCE;
        }
        Value.Undefined undefined = (Value) CollectionsKt.getOrNull(listArgsAsList, 1);
        if (undefined == null) {
            undefined = Value.Undefined.INSTANCE;
        }
        Value valueEvaluateValue$purchases_defaultsRelease = Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(r0, vars);
        Value.ArrayValue arrayValue = valueEvaluateValue$purchases_defaultsRelease instanceof Value.ArrayValue ? (Value.ArrayValue) valueEvaluateValue$purchases_defaultsRelease : null;
        return TuplesKt.m1606to(arrayValue != null ? arrayValue.getItems() : null, undefined);
    }
}
