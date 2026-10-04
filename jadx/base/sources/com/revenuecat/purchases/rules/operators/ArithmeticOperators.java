package com.revenuecat.purchases.rules.operators;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.ValueKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArithmeticOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0007H\u0002¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/ArithmeticOperators;", "", "()V", "evalDivisorPair", "Lkotlin/Pair;", "", "args", "Lcom/revenuecat/purchases/rules/Value;", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opAdd", "opDiv", "opMod", "opMul", "opSub", "asDouble", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ArithmeticOperators {
    public static final ArithmeticOperators INSTANCE = new ArithmeticOperators();

    private ArithmeticOperators() {
    }

    public final Value opAdd(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Iterator<T> it = Operators.INSTANCE.evalArgs(args, vars).iterator();
        double dJsParseFloat = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (it.hasNext()) {
            dJsParseFloat += ValueKt.jsParseFloat((Value) it.next());
        }
        return new Value.FloatValue(dJsParseFloat);
    }

    public final Value opMul(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Value value = (Value) CollectionsKt.firstOrNull((List) listEvalArgs);
        if (value == null) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator '*' requires at least 1 argument");
        }
        if (listEvalArgs.size() <= 1) {
            return value;
        }
        List listDrop = CollectionsKt.drop(listEvalArgs, 1);
        double dJsParseFloat = ValueKt.jsParseFloat(value);
        Iterator it = listDrop.iterator();
        while (it.hasNext()) {
            dJsParseFloat *= ValueKt.jsParseFloat((Value) it.next());
        }
        return new Value.FloatValue(dJsParseFloat);
    }

    public final Value opSub(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Value value = (Value) CollectionsKt.firstOrNull((List) listEvalArgs);
        double dAsDouble = value != null ? asDouble(value) : Double.NaN;
        if (listEvalArgs.size() >= 2) {
            return new Value.FloatValue(dAsDouble - asDouble(listEvalArgs.get(1)));
        }
        return new Value.FloatValue(-dAsDouble);
    }

    public final Value opDiv(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<Double, Double> pairEvalDivisorPair = evalDivisorPair(args, vars);
        return new Value.FloatValue(pairEvalDivisorPair.component1().doubleValue() / pairEvalDivisorPair.component2().doubleValue());
    }

    public final Value opMod(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Pair<Double, Double> pairEvalDivisorPair = evalDivisorPair(args, vars);
        return new Value.FloatValue(pairEvalDivisorPair.component1().doubleValue() % pairEvalDivisorPair.component2().doubleValue());
    }

    private final Pair<Double, Double> evalDivisorPair(Value args, Scope vars) {
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Value value = (Value) CollectionsKt.firstOrNull((List) listEvalArgs);
        return TuplesKt.m1606to(Double.valueOf(value != null ? asDouble(value) : Double.NaN), Double.valueOf(listEvalArgs.size() >= 2 ? asDouble(listEvalArgs.get(1)) : Double.NaN));
    }

    private final double asDouble(Value value) {
        Double numberOrNull$purchases_defaultsRelease = value.toNumberOrNull$purchases_defaultsRelease();
        if (numberOrNull$purchases_defaultsRelease != null) {
            return numberOrNull$purchases_defaultsRelease.doubleValue();
        }
        return Double.NaN;
    }
}
