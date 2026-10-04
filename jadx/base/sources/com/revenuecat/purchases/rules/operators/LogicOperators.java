package com.revenuecat.purchases.rules.operators;

import com.revenuecat.purchases.rules.Evaluator;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogicOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/LogicOperators;", "", "()V", "opAnd", "Lcom/revenuecat/purchases/rules/Value;", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opIf", "opNot", "opNotNot", "opOr", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class LogicOperators {
    public static final LogicOperators INSTANCE = new LogicOperators();

    private LogicOperators() {
    }

    public final Value opNot(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return new Value.BoolValue(!Operators.INSTANCE.firstArgEvaluated(args, vars).isTruthy$purchases_defaultsRelease());
    }

    public final Value opNotNot(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return new Value.BoolValue(Operators.INSTANCE.firstArgEvaluated(args, vars).isTruthy$purchases_defaultsRelease());
    }

    public final Value opAnd(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Value.Undefined undefinedEvaluateValue$purchases_defaultsRelease = Value.Undefined.INSTANCE;
        Iterator<Value> it = Operators.INSTANCE.argsAsList(args).iterator();
        while (it.hasNext()) {
            undefinedEvaluateValue$purchases_defaultsRelease = Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(it.next(), vars);
            if (!undefinedEvaluateValue$purchases_defaultsRelease.isTruthy$purchases_defaultsRelease()) {
                break;
            }
        }
        return undefinedEvaluateValue$purchases_defaultsRelease;
    }

    public final Value opOr(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Value.Undefined undefinedEvaluateValue$purchases_defaultsRelease = Value.Undefined.INSTANCE;
        Iterator<Value> it = Operators.INSTANCE.argsAsList(args).iterator();
        while (it.hasNext()) {
            undefinedEvaluateValue$purchases_defaultsRelease = Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(it.next(), vars);
            if (undefinedEvaluateValue$purchases_defaultsRelease.isTruthy$purchases_defaultsRelease()) {
                break;
            }
        }
        return undefinedEvaluateValue$purchases_defaultsRelease;
    }

    public final Value opIf(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listArgsAsList = Operators.INSTANCE.argsAsList(args);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 < listArgsAsList.size()) {
                if (Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(listArgsAsList.get(i), vars).isTruthy$purchases_defaultsRelease()) {
                    return Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(listArgsAsList.get(i2), vars);
                }
                i += 2;
            } else {
                if (i < listArgsAsList.size()) {
                    return Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(listArgsAsList.get(i), vars);
                }
                return Value.Null.INSTANCE;
            }
        }
    }
}
