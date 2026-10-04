package com.revenuecat.purchases.rules.operators;

import androidx.compose.p004ui.spatial.RectListKt;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.revenuecat.purchases.rules.Evaluator;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.customoperators.CustomOperators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: compiled from: Operators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0019"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/Operators;", "", "()V", "argsAsList", "", "Lcom/revenuecat/purchases/rules/Value;", "args", "checkArity", "", "count", "", "allowed", "operatorName", "", "clampedInt", "value", "", "dispatch", "op", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "evalArgs", "evalTwo", "Lkotlin/Pair;", "firstArgEvaluated", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class Operators {
    public static final Operators INSTANCE = new Operators();

    private Operators() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Value dispatch(String op, Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        switch (op.hashCode()) {
            case -1274492040:
                if (op.equals("filter")) {
                    return IterationOperators.INSTANCE.opFilter(args, vars);
                }
                break;
            case -1146545107:
                if (op.equals("missing_some")) {
                    return AccessorOperators.INSTANCE.opMissingSome(args, vars);
                }
                break;
            case -934873754:
                if (op.equals("reduce")) {
                    return IterationOperators.INSTANCE.opReduce(args, vars);
                }
                break;
            case -891529231:
                if (op.equals("substr")) {
                    return StringArrayOperators.INSTANCE.opSubstr(args, vars);
                }
                break;
            case 33:
                if (op.equals("!")) {
                    return LogicOperators.INSTANCE.opNot(args, vars);
                }
                break;
            case 37:
                if (op.equals("%")) {
                    return ArithmeticOperators.INSTANCE.opMod(args, vars);
                }
                break;
            case 42:
                if (op.equals("*")) {
                    return ArithmeticOperators.INSTANCE.opMul(args, vars);
                }
                break;
            case 43:
                if (op.equals(Marker.ANY_NON_NULL_MARKER)) {
                    return ArithmeticOperators.INSTANCE.opAdd(args, vars);
                }
                break;
            case 45:
                if (op.equals("-")) {
                    return ArithmeticOperators.INSTANCE.opSub(args, vars);
                }
                break;
            case 47:
                if (op.equals(DomExceptionUtils.SEPARATOR)) {
                    return ArithmeticOperators.INSTANCE.opDiv(args, vars);
                }
                break;
            case 60:
                if (op.equals("<")) {
                    return ComparisonOperators.INSTANCE.opLt(args, vars);
                }
                break;
            case RectListKt.BitOffsetForGesturable /* 62 */:
                if (op.equals(">")) {
                    return ComparisonOperators.INSTANCE.opGt(args, vars);
                }
                break;
            case 1056:
                if (op.equals("!!")) {
                    return LogicOperators.INSTANCE.opNotNot(args, vars);
                }
                break;
            case 1084:
                if (op.equals("!=")) {
                    return EqualityOperators.INSTANCE.opLooseNe(args, vars);
                }
                break;
            case 1921:
                if (op.equals("<=")) {
                    return ComparisonOperators.INSTANCE.opLe(args, vars);
                }
                break;
            case 1952:
                if (op.equals("==")) {
                    return EqualityOperators.INSTANCE.opLooseEq(args, vars);
                }
                break;
            case 1983:
                if (op.equals(">=")) {
                    return ComparisonOperators.INSTANCE.opGe(args, vars);
                }
                break;
            case 3357:
                if (op.equals("if")) {
                    return LogicOperators.INSTANCE.opIf(args, vars);
                }
                break;
            case 3365:
                if (op.equals("in")) {
                    return StringArrayOperators.INSTANCE.opIn(args, vars);
                }
                break;
            case 3555:
                if (op.equals("or")) {
                    return LogicOperators.INSTANCE.opOr(args, vars);
                }
                break;
            case 33665:
                if (op.equals("!==")) {
                    return EqualityOperators.INSTANCE.opStrictNe(args, vars);
                }
                break;
            case 60573:
                if (op.equals("===")) {
                    return EqualityOperators.INSTANCE.opStrictEq(args, vars);
                }
                break;
            case 96673:
                if (op.equals("all")) {
                    return IterationOperators.INSTANCE.opAll(args, vars);
                }
                break;
            case 96727:
                if (op.equals("and")) {
                    return LogicOperators.INSTANCE.opAnd(args, vars);
                }
                break;
            case 98262:
                if (op.equals("cat")) {
                    return StringArrayOperators.INSTANCE.opCat(args, vars);
                }
                break;
            case 107332:
                if (op.equals("log")) {
                    return MiscOperators.INSTANCE.opLog(args, vars);
                }
                break;
            case 107868:
                if (op.equals("map")) {
                    return IterationOperators.INSTANCE.opMap(args, vars);
                }
                break;
            case 107876:
                if (op.equals("max")) {
                    return MinMaxOperators.INSTANCE.opMax(args, vars);
                }
                break;
            case 108114:
                if (op.equals("min")) {
                    return MinMaxOperators.INSTANCE.opMin(args, vars);
                }
                break;
            case 116519:
                if (op.equals("var")) {
                    return AccessorOperators.INSTANCE.opVar(args, vars);
                }
                break;
            case 3387192:
                if (op.equals("none")) {
                    return IterationOperators.INSTANCE.opNone(args, vars);
                }
                break;
            case 3536116:
                if (op.equals("some")) {
                    return IterationOperators.INSTANCE.opSome(args, vars);
                }
                break;
            case 103785528:
                if (op.equals("merge")) {
                    return StringArrayOperators.INSTANCE.opMerge(args, vars);
                }
                break;
            case 1069449574:
                if (op.equals("missing")) {
                    return AccessorOperators.INSTANCE.opMissing(args, vars);
                }
                break;
        }
        return CustomOperators.INSTANCE.dispatch(op, args, vars);
    }

    public final List<Value> argsAsList(Value args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return args instanceof Value.ArrayValue ? ((Value.ArrayValue) args).getItems() : CollectionsKt.listOf(args);
    }

    public final List<Value> evalArgs(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listArgsAsList = argsAsList(args);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listArgsAsList, 10));
        Iterator<T> it = listArgsAsList.iterator();
        while (it.hasNext()) {
            arrayList.add(Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease((Value) it.next(), vars));
        }
        return arrayList;
    }

    public final void checkArity(int count, List<Integer> allowed, String operatorName) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(allowed, "allowed");
        Intrinsics.checkNotNullParameter(operatorName, "operatorName");
        if (allowed.contains(Integer.valueOf(count))) {
            return;
        }
        throw new RulesEngine.EvaluationException.TypeMismatch("operator '" + operatorName + "' expects " + CollectionsKt.joinToString$default(allowed, " or ", null, null, 0, null, null, 62, null) + " arguments, got " + count);
    }

    public final Pair<Value, Value> evalTwo(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = evalArgs(args, vars);
        Value.Undefined undefined = (Value) CollectionsKt.firstOrNull((List) listEvalArgs);
        if (undefined == null) {
            undefined = Value.Undefined.INSTANCE;
        }
        return TuplesKt.m1606to(undefined, listEvalArgs.size() >= 2 ? listEvalArgs.get(1) : Value.Undefined.INSTANCE);
    }

    public final Value firstArgEvaluated(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        Value.Null r2 = (Value) CollectionsKt.firstOrNull((List) argsAsList(args));
        if (r2 == null) {
            r2 = Value.Null.INSTANCE;
        }
        return Evaluator.INSTANCE.evaluateValue$purchases_defaultsRelease(r2, vars);
    }

    public final int clampedInt(double value) {
        if (Double.isNaN(value)) {
            return 0;
        }
        if (value >= 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (value <= -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }
}
