package com.revenuecat.purchases.rules.operators;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.ValueKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StringArrayOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/StringArrayOperators;", "", "()V", "BINARY_OPERAND_COUNT", "", "LENGTH_OPERAND_INDEX", "START_OPERAND_INDEX", "TERNARY_OPERAND_COUNT", "opCat", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opIn", "opMerge", "opSubstr", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class StringArrayOperators {
    private static final int BINARY_OPERAND_COUNT = 2;
    public static final StringArrayOperators INSTANCE = new StringArrayOperators();
    private static final int LENGTH_OPERAND_INDEX = 2;
    private static final int START_OPERAND_INDEX = 1;
    private static final int TERNARY_OPERAND_COUNT = 3;

    private StringArrayOperators() {
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Value opIn(Value args, Scope vars) {
        Object obj;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Value.Null r6 = (Value) CollectionsKt.firstOrNull((List) listEvalArgs);
        if (r6 == null) {
            r6 = Value.Null.INSTANCE;
        }
        boolean zContains$default = true;
        if (listEvalArgs.size() >= 2) {
            obj = (Value) listEvalArgs.get(1);
        } else {
            obj = (Value) Value.Null.INSTANCE;
        }
        if (obj instanceof Value.StringValue) {
            Value.StringValue stringValue = (Value.StringValue) obj;
            zContains$default = stringValue.getValue().length() == 0 ? false : StringsKt.contains$default((CharSequence) stringValue.getValue(), (CharSequence) ValueKt.jsString(r6), false, 2, (Object) null);
        } else if (obj instanceof Value.ArrayValue) {
            List<Value> items = ((Value.ArrayValue) obj).getItems();
            if (!(items instanceof Collection) || !items.isEmpty()) {
                Iterator<T> it = items.iterator();
                while (it.hasNext()) {
                    if (ValueKt.strictEq(r6, (Value) it.next())) {
                        break;
                    }
                }
            }
        }
        return new Value.BoolValue(zContains$default);
    }

    public final Value opCat(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return new Value.StringValue(CollectionsKt.joinToString$default(Operators.INSTANCE.evalArgs(args, vars), "", null, null, 0, null, new Function1<Value, CharSequence>() { // from class: com.revenuecat.purchases.rules.operators.StringArrayOperators.opCat.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Value it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ValueKt.jsArrayElementString(it);
            }
        }, 30, null));
    }

    public final Value opSubstr(Value args, Scope vars) {
        Value.Null r0;
        int iCoerceAtMost;
        String strSubstring;
        int iCoerceAtMost2;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Value.Undefined undefined = (Value) CollectionsKt.firstOrNull((List) listEvalArgs);
        if (undefined == null) {
            undefined = Value.Undefined.INSTANCE;
        }
        if (listEvalArgs.size() >= 2) {
            r0 = listEvalArgs.get(1);
        } else {
            r0 = Value.Null.INSTANCE;
        }
        Value value = listEvalArgs.size() >= 3 ? listEvalArgs.get(2) : null;
        String strJsString = ValueKt.jsString(undefined);
        int length = strJsString.length();
        Operators operators = Operators.INSTANCE;
        Double numberOrNull$purchases_defaultsRelease = r0.toNumberOrNull$purchases_defaultsRelease();
        double dDoubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int iClampedInt = operators.clampedInt(numberOrNull$purchases_defaultsRelease != null ? numberOrNull$purchases_defaultsRelease.doubleValue() : 0.0d);
        if (iClampedInt < 0) {
            iCoerceAtMost = RangesKt.coerceAtLeast(iClampedInt + length, 0);
        } else {
            iCoerceAtMost = RangesKt.coerceAtMost(iClampedInt, length);
        }
        int i = length - iCoerceAtMost;
        if (value != null) {
            Operators operators2 = Operators.INSTANCE;
            Double numberOrNull$purchases_defaultsRelease2 = value.toNumberOrNull$purchases_defaultsRelease();
            if (numberOrNull$purchases_defaultsRelease2 != null) {
                dDoubleValue = numberOrNull$purchases_defaultsRelease2.doubleValue();
            }
            int iClampedInt2 = operators2.clampedInt(dDoubleValue);
            if (iClampedInt2 < 0) {
                iCoerceAtMost2 = RangesKt.coerceAtLeast(i + iClampedInt2, 0);
            } else {
                iCoerceAtMost2 = RangesKt.coerceAtMost(iClampedInt2, i);
            }
            strSubstring = strJsString.substring(iCoerceAtMost, iCoerceAtMost2 + iCoerceAtMost);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = strJsString.substring(iCoerceAtMost, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        return new Value.StringValue(strSubstring);
    }

    public final Value opMerge(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        ArrayList arrayList = new ArrayList();
        for (Value value : listEvalArgs) {
            if (value instanceof Value.ArrayValue) {
                CollectionsKt.addAll(arrayList, ((Value.ArrayValue) value).getItems());
            } else {
                arrayList.add(value);
            }
        }
        return new Value.ArrayValue(arrayList);
    }
}
