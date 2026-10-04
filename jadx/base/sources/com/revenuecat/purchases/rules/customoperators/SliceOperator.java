package com.revenuecat.purchases.rules.customoperators;

import androidx.collection.SieveCacheKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SliceOperator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/SliceOperator;", "", "()V", "BINARY_OPERAND_COUNT", "", "TERNARY_OPERAND_COUNT", FirebaseAnalytics.Param.INDEX, "value", "Lcom/revenuecat/purchases/rules/Value;", "argument", "", "opSlice", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SliceOperator {
    private static final int BINARY_OPERAND_COUNT = 2;
    public static final SliceOperator INSTANCE = new SliceOperator();
    private static final int TERNARY_OPERAND_COUNT = 3;

    private SliceOperator() {
    }

    public final Value opSlice(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        int iMin;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Operators.INSTANCE.checkArity(listEvalArgs.size(), CollectionsKt.listOf((Object[]) new Integer[]{2, 3}), "rc.slice");
        Value value = listEvalArgs.get(0);
        if (!(value instanceof Value.ArrayValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.slice' expected an array to slice, got " + value + (value instanceof Value.StringValue ? "; strings use 'substr'" : ""));
        }
        List<Value> items = ((Value.ArrayValue) value).getItems();
        int iIndex = index(listEvalArgs.get(1), TtmlNode.START);
        int size = items.size();
        List list = CollectionsKt.toList(items.subList(iIndex < 0 ? Math.max(size + iIndex, 0) : Math.min(iIndex, size), items.size()));
        if (listEvalArgs.size() != 3) {
            return new Value.ArrayValue(list);
        }
        int iIndex2 = index(listEvalArgs.get(2), "length");
        if (iIndex2 < 0) {
            iMin = Math.max(list.size() + iIndex2, 0);
        } else {
            iMin = Math.min(iIndex2, list.size());
        }
        return new Value.ArrayValue(CollectionsKt.toList(list.subList(0, iMin)));
    }

    private final int index(Value value, String argument) throws RulesEngine.EvaluationException.TypeMismatch {
        if (value instanceof Value.IntValue) {
            return (int) RangesKt.coerceIn(((Value.IntValue) value).getValue(), SieveCacheKt.NodeMetaAndPreviousMask, SieveCacheKt.NodeLinkMask);
        }
        if (value instanceof Value.FloatValue) {
            Value.FloatValue floatValue = (Value.FloatValue) value;
            if (floatValue.getValue() % 1.0d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return Operators.INSTANCE.clampedInt(floatValue.getValue());
            }
        }
        throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.slice' expected a whole number " + argument + ", got " + value);
    }
}
