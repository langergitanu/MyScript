package com.revenuecat.purchases.rules.operators;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.rules.Evaluator;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.ValueKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: AccessorOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ,\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J4\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\tJ.\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00162\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\tH\u0002¨\u0006\u001e"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/AccessorOperators;", "", "()V", "isMissing", "", "value", "Lcom/revenuecat/purchases/rules/Value;", "jsDotSplit", "", "", ClientCookie.PATH_ATTR, "keyAsPath", "lookupInScope", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "lookupPath", "lookupVar", "opMissing", "args", "opMissingSome", "opVar", "parseVarArrayArgs", "Lkotlin/Pair;", FirebaseAnalytics.Param.ITEMS, "operatorName", "pathSegment", "resolveVar", "lookup", "Lkotlin/Function1;", "resolveVarArgs", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class AccessorOperators {
    public static final AccessorOperators INSTANCE = new AccessorOperators();

    private AccessorOperators() {
    }

    public final Value opVar(Value args, final Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return resolveVar(args, new Function1<String, Value>() { // from class: com.revenuecat.purchases.rules.operators.AccessorOperators.opVar.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Value invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessorOperators.INSTANCE.lookupInScope(vars, it);
            }
        }, vars, "var");
    }

    public final Value resolveVar(Value args, Function1<? super String, ? extends Value> lookup, Scope vars, String operatorName) throws RulesEngine.EvaluationException.UnresolvedVariable {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(lookup, "lookup");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Intrinsics.checkNotNullParameter(operatorName, "operatorName");
        Pair<String, Value> pairResolveVarArgs = resolveVarArgs(args, vars, operatorName);
        String strComponent1 = pairResolveVarArgs.component1();
        Value valueComponent2 = pairResolveVarArgs.component2();
        Value valueInvoke = lookup.invoke(strComponent1);
        if (valueInvoke != null) {
            return valueInvoke;
        }
        if (valueComponent2 instanceof Value.Undefined) {
            return Value.Null.INSTANCE;
        }
        if (valueComponent2 != null) {
            return valueComponent2;
        }
        throw new RulesEngine.EvaluationException.UnresolvedVariable(strComponent1);
    }

    public final Value opMissing(Value args, Scope vars) {
        ArrayList arrayListListOf;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        if (!(args instanceof Value.ArrayValue)) {
            arrayListListOf = CollectionsKt.listOf(Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(args, vars));
        } else {
            List<Value> items = ((Value.ArrayValue) args).getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease((Value) it.next(), vars));
            }
            arrayListListOf = arrayList;
        }
        Value value = (Value) CollectionsKt.firstOrNull((List) arrayListListOf);
        if (value instanceof Value.ArrayValue) {
            arrayListListOf = ((Value.ArrayValue) value).getItems();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<Value> it2 = arrayListListOf.iterator();
        while (it2.hasNext()) {
            String strKeyAsPath = keyAsPath(it2.next());
            if (strKeyAsPath != null) {
                Value.Null nullLookupInScope = lookupInScope(vars, strKeyAsPath);
                if (nullLookupInScope == null) {
                    nullLookupInScope = Value.Null.INSTANCE;
                }
                if (isMissing(nullLookupInScope)) {
                    arrayList2.add(new Value.StringValue(strKeyAsPath));
                }
            }
        }
        return new Value.ArrayValue(arrayList2);
    }

    public final Value opMissingSome(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        List<Value> listEmptyList;
        Long lValueOf;
        List<Value> items;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Operators.INSTANCE.checkArity(listEvalArgs.size(), CollectionsKt.listOf(2), "missing_some");
        Value value = listEvalArgs.get(0);
        Value value2 = listEvalArgs.get(1);
        if (value2 instanceof Value.ArrayValue) {
            listEmptyList = ((Value.ArrayValue) value2).getItems();
            lValueOf = Long.valueOf(r7.getItems().size());
        } else if (value2 instanceof Value.StringValue) {
            listEmptyList = CollectionsKt.listOf(new Value.StringValue(((Value.StringValue) value2).getValue()));
            lValueOf = Long.valueOf(r7.getValue().length());
        } else {
            if (Intrinsics.areEqual(value2, Value.Null.INSTANCE) ? true : Intrinsics.areEqual(value2, Value.Undefined.INSTANCE)) {
                listEmptyList = CollectionsKt.emptyList();
                lValueOf = null;
            } else {
                throw new RulesEngine.EvaluationException.TypeMismatch("operator 'missing_some': second argument must be array-like, got " + value2);
            }
        }
        double dJsToNumber = ValueKt.jsToNumber(value);
        Value valueOpMissing = opMissing(new Value.ArrayValue(listEmptyList), vars);
        Value.ArrayValue arrayValue = valueOpMissing instanceof Value.ArrayValue ? (Value.ArrayValue) valueOpMissing : null;
        return (lValueOf == null || ((double) (lValueOf.longValue() - ((arrayValue == null || (items = arrayValue.getItems()) == null) ? 0L : (long) items.size()))) < dJsToNumber) ? valueOpMissing : new Value.ArrayValue(CollectionsKt.emptyList());
    }

    private final boolean isMissing(Value value) {
        if (value == null ? true : Intrinsics.areEqual(value, Value.Null.INSTANCE)) {
            return true;
        }
        return (value instanceof Value.StringValue) && ((Value.StringValue) value).getValue().length() == 0;
    }

    private final Pair<String, Value> resolveVarArgs(Value args, Scope vars, String operatorName) {
        if (args instanceof Value.ArrayValue) {
            List<Value> items = ((Value.ArrayValue) args).getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease((Value) it.next(), vars));
            }
            return parseVarArrayArgs(arrayList, operatorName);
        }
        return TuplesKt.m1606to(pathSegment(Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(args, vars)), null);
    }

    private final Pair<String, Value> parseVarArrayArgs(List<? extends Value> items, String operatorName) {
        String strPathSegment = pathSegment((Value) CollectionsKt.firstOrNull((List) items));
        Value value = items.size() >= 2 ? items.get(1) : null;
        if (items.size() > 2) {
            RulesEngine.INSTANCE.getLogger$purchases_defaultsRelease().warn(operatorName + ": ignoring " + (items.size() - 2) + " extra arg(s); expected [path] or [path, default]");
        }
        return TuplesKt.m1606to(strPathSegment, value);
    }

    private final String pathSegment(Value value) {
        return value == null ? true : Intrinsics.areEqual(value, Value.Null.INSTANCE) ? true : Intrinsics.areEqual(value, Value.Undefined.INSTANCE) ? "" : ValueKt.jsString(value);
    }

    private final String keyAsPath(Value value) {
        if ((value instanceof Value.Null) || (value instanceof Value.Undefined)) {
            return null;
        }
        return ValueKt.jsString(value);
    }

    public final Value lookupInScope(Scope vars, String path) {
        Intrinsics.checkNotNullParameter(vars, "vars");
        Intrinsics.checkNotNullParameter(path, "path");
        Value valueLookupVar = lookupVar(vars.getCurrent(), path);
        if (valueLookupVar != null) {
            return valueLookupVar;
        }
        if (vars.getBindings().isEmpty() || path.length() == 0 || lookupVar(vars.getCurrent(), StringsKt.substringBefore$default(path, '.', (String) null, 2, (Object) null)) != null) {
            return null;
        }
        return lookupPath(new Value.ObjectValue(vars.getBindings()), path);
    }

    public final Value lookupVar(Value vars, String path) {
        Intrinsics.checkNotNullParameter(vars, "vars");
        Intrinsics.checkNotNullParameter(path, "path");
        return path.length() == 0 ? vars : lookupPath(vars, path);
    }

    private final List<String> jsDotSplit(String path) {
        String str = path;
        if (str.length() == 0) {
            return CollectionsKt.listOf("");
        }
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (path.charAt(i2) == '.') {
                String strSubstring = path.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                arrayList.add(strSubstring);
                i = i2 + 1;
            }
        }
        String strSubstring2 = path.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        arrayList.add(strSubstring2);
        return arrayList;
    }

    private final Value lookupPath(Value vars, String path) {
        Integer intOrNull;
        int iIntValue;
        for (String str : jsDotSplit(path)) {
            if (!(vars instanceof Value.ObjectValue)) {
                if ((vars instanceof Value.ArrayValue) && (intOrNull = StringsKt.toIntOrNull(str)) != null && (iIntValue = intOrNull.intValue()) >= 0) {
                    Value.ArrayValue arrayValue = (Value.ArrayValue) vars;
                    if (iIntValue < arrayValue.getItems().size()) {
                        vars = arrayValue.getItems().get(iIntValue);
                    }
                }
                return null;
            }
            vars = ((Value.ObjectValue) vars).getEntries().get(str);
            if (vars == null) {
                return null;
            }
        }
        return vars;
    }
}
