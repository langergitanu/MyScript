package com.revenuecat.purchases.rules.customoperators;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.rules.Evaluator;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: SortByOperator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/SortByOperator;", "", "()V", "ARGUMENT_COUNT", "", "comparator", "Ljava/util/Comparator;", "Lcom/revenuecat/purchases/rules/Value;", "Lkotlin/Comparator;", UserMetadata.KEYDATA_FILENAME, "", "keyKind", "Lcom/revenuecat/purchases/rules/customoperators/SortByOperator$KeyKind;", SubscriberAttributeKt.JSON_NAME_KEY, "opSortBy", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "sorted", FirebaseAnalytics.Param.ITEMS, "KeyKind", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SortByOperator {
    private static final int ARGUMENT_COUNT = 2;
    public static final SortByOperator INSTANCE = new SortByOperator();

    /* JADX INFO: compiled from: SortByOperator.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/SortByOperator$KeyKind;", "", "(Ljava/lang/String;I)V", "STRING", "NUMBER", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private enum KeyKind {
        STRING,
        NUMBER
    }

    private SortByOperator() {
    }

    public final Value opSortBy(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listArgsAsList = Operators.INSTANCE.argsAsList(args);
        Operators.INSTANCE.checkArity(listArgsAsList.size(), CollectionsKt.listOf(2), "rc.sortBy");
        Value valueEvaluateValue$purchases_defaultsRelease = Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(listArgsAsList.get(0), vars);
        if (!(valueEvaluateValue$purchases_defaultsRelease instanceof Value.ArrayValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.sortBy' expected an array to sort, got " + valueEvaluateValue$purchases_defaultsRelease);
        }
        Value.ArrayValue arrayValue = (Value.ArrayValue) valueEvaluateValue$purchases_defaultsRelease;
        List<Value> items = arrayValue.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(listArgsAsList.get(1), vars.scoped((Value) it.next())));
        }
        return new Value.ArrayValue(sorted(arrayValue.getItems(), arrayList));
    }

    private final List<Value> sorted(List<? extends Value> items, final List<? extends Value> keys) throws RulesEngine.EvaluationException.TypeMismatch {
        final Comparator<Value> comparator = comparator(keys);
        IntRange indices = CollectionsKt.getIndices(keys);
        final Function2<Integer, Integer, Integer> function2 = new Function2<Integer, Integer, Integer>() { // from class: com.revenuecat.purchases.rules.customoperators.SortByOperator.sorted.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(Integer left, Integer right) {
                Comparator<Value> comparator2 = comparator;
                List<Value> list = keys;
                Intrinsics.checkNotNullExpressionValue(left, "left");
                Value value = list.get(left.intValue());
                List<Value> list2 = keys;
                Intrinsics.checkNotNullExpressionValue(right, "right");
                int iCompare = comparator2.compare(value, list2.get(right.intValue()));
                if (iCompare == 0) {
                    iCompare = Intrinsics.compare(left.intValue(), right.intValue());
                }
                return Integer.valueOf(iCompare);
            }
        };
        List listSortedWith = CollectionsKt.sortedWith(indices, new Comparator() { // from class: com.revenuecat.purchases.rules.customoperators.SortByOperator$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SortByOperator.sorted$lambda$1(function2, obj, obj2);
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add(items.get(((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sorted$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final KeyKind keyKind(Value key) throws RulesEngine.EvaluationException.TypeMismatch {
        if (key instanceof Value.StringValue) {
            return KeyKind.STRING;
        }
        if (key instanceof Value.IntValue) {
            return KeyKind.NUMBER;
        }
        if (!(key instanceof Value.FloatValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.sortBy' expected string or number keys, got " + key);
        }
        double value = ((Value.FloatValue) key).getValue();
        if (!Double.isInfinite(value) && !Double.isNaN(value)) {
            return KeyKind.NUMBER;
        }
        throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.sortBy' expected a finite number key, got " + key);
    }

    private final Comparator<Value> comparator(List<? extends Value> keys) throws RulesEngine.EvaluationException.TypeMismatch {
        List<? extends Value> list = keys;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.keyKind((Value) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        boolean zContains = arrayList2.contains(KeyKind.STRING);
        boolean zContains2 = arrayList2.contains(KeyKind.NUMBER);
        if (zContains && zContains2) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.sortBy' expected keys of a single type, got both strings and numbers");
        }
        if (zContains) {
            return new Comparator() { // from class: com.revenuecat.purchases.rules.customoperators.SortByOperator$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SortByOperator.comparator$lambda$4((Value) obj, (Value) obj2);
                }
            };
        }
        return new Comparator() { // from class: com.revenuecat.purchases.rules.customoperators.SortByOperator$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SortByOperator.comparator$lambda$5((Value) obj, (Value) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int comparator$lambda$4(Value value, Value value2) {
        String value3;
        String value4;
        Value.StringValue stringValue = value instanceof Value.StringValue ? (Value.StringValue) value : null;
        String str = "";
        if (stringValue == null || (value3 = stringValue.getValue()) == null) {
            value3 = "";
        }
        Value.StringValue stringValue2 = value2 instanceof Value.StringValue ? (Value.StringValue) value2 : null;
        if (stringValue2 != null && (value4 = stringValue2.getValue()) != null) {
            str = value4;
        }
        return value3.compareTo(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int comparator$lambda$5(Value value, Value value2) {
        Double numberOrNull$purchases_defaultsRelease = value.toNumberOrNull$purchases_defaultsRelease();
        double dDoubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double dDoubleValue2 = numberOrNull$purchases_defaultsRelease != null ? numberOrNull$purchases_defaultsRelease.doubleValue() : 0.0d;
        Double numberOrNull$purchases_defaultsRelease2 = value2.toNumberOrNull$purchases_defaultsRelease();
        if (numberOrNull$purchases_defaultsRelease2 != null) {
            dDoubleValue = numberOrNull$purchases_defaultsRelease2.doubleValue();
        }
        return Double.compare(dDoubleValue2, dDoubleValue);
    }
}
