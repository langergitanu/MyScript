package com.revenuecat.purchases.rules.operators;

import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.ValueKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComparisonOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u001b*\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/ComparisonOperators;", "", "()V", "BETWEEN_OPERAND_COUNT", "", "BINARY_OPERAND_COUNT", "MID_OPERAND_INDEX", "RHS_OPERAND_INDEX", "compare", "", "lhs", "Lcom/revenuecat/purchases/rules/Value;", "rhs", "cmp", "Lcom/revenuecat/purchases/rules/operators/ComparisonOperators$Comparator;", "evalBinary", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "evalChain", "opGe", "opGt", "opLe", "opLt", "toPrimitiveForComparison", "value", "asDouble", "", "Comparator", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ComparisonOperators {
    private static final int BETWEEN_OPERAND_COUNT = 3;
    private static final int BINARY_OPERAND_COUNT = 2;
    public static final ComparisonOperators INSTANCE = new ComparisonOperators();
    private static final int MID_OPERAND_INDEX = 1;
    private static final int RHS_OPERAND_INDEX = 2;

    private ComparisonOperators() {
    }

    public final Value opLt(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return evalChain(args, vars, Comparator.LESS);
    }

    public final Value opLe(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return evalChain(args, vars, Comparator.LESS_OR_EQUAL);
    }

    public final Value opGt(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return evalBinary(args, vars, Comparator.GREATER);
    }

    public final Value opGe(Value args, Scope vars) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        return evalBinary(args, vars, Comparator.GREATER_OR_EQUAL);
    }

    /* JADX INFO: compiled from: ComparisonOperators.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/operators/ComparisonOperators$Comparator;", "", "(Ljava/lang/String;I)V", "apply", "", "lhs", "", "rhs", "", "LESS", "LESS_OR_EQUAL", "GREATER", "GREATER_OR_EQUAL", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private enum Comparator {
        LESS,
        LESS_OR_EQUAL,
        GREATER,
        GREATER_OR_EQUAL;

        /* JADX INFO: compiled from: ComparisonOperators.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Comparator.values().length];
                try {
                    iArr[Comparator.LESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Comparator.LESS_OR_EQUAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Comparator.GREATER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Comparator.GREATER_OR_EQUAL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final boolean apply(double lhs, double rhs) {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return lhs < rhs;
            }
            if (i == 2) {
                return lhs <= rhs;
            }
            if (i == 3) {
                return lhs > rhs;
            }
            if (i == 4) {
                return lhs >= rhs;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final boolean apply(String lhs, String rhs) {
            Intrinsics.checkNotNullParameter(lhs, "lhs");
            Intrinsics.checkNotNullParameter(rhs, "rhs");
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return lhs.compareTo(rhs) < 0;
            }
            if (i == 2) {
                return lhs.compareTo(rhs) <= 0;
            }
            if (i == 3) {
                return lhs.compareTo(rhs) > 0;
            }
            if (i == 4) {
                return lhs.compareTo(rhs) >= 0;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean compare(Value lhs, Value rhs, Comparator cmp) {
        if (lhs == null || rhs == null) {
            return cmp.apply(asDouble(lhs), asDouble(rhs));
        }
        Value primitiveForComparison = toPrimitiveForComparison(lhs);
        Value primitiveForComparison2 = toPrimitiveForComparison(rhs);
        if ((primitiveForComparison instanceof Value.StringValue) && (primitiveForComparison2 instanceof Value.StringValue)) {
            return cmp.apply(((Value.StringValue) primitiveForComparison).getValue(), ((Value.StringValue) primitiveForComparison2).getValue());
        }
        return cmp.apply(asDouble(primitiveForComparison), asDouble(primitiveForComparison2));
    }

    private final Value toPrimitiveForComparison(Value value) {
        if (value instanceof Value.StringValue ? true : Intrinsics.areEqual(value, Value.Null.INSTANCE) ? true : Intrinsics.areEqual(value, Value.Undefined.INSTANCE) ? true : value instanceof Value.BoolValue ? true : value instanceof Value.IntValue ? true : value instanceof Value.FloatValue) {
            return value;
        }
        if (value instanceof Value.ArrayValue ? true : value instanceof Value.ObjectValue) {
            return new Value.StringValue(ValueKt.jsString(value));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Value evalChain(Value args, Scope vars, Comparator cmp) {
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Value value = (Value) CollectionsKt.firstOrNull((List) listEvalArgs);
        Value value2 = listEvalArgs.size() >= 2 ? listEvalArgs.get(1) : null;
        if (listEvalArgs.size() >= 3) {
            return new Value.BoolValue(compare(value, value2, cmp) && compare(value2, listEvalArgs.get(2), cmp));
        }
        return new Value.BoolValue(compare(value, value2, cmp));
    }

    private final Value evalBinary(Value args, Scope vars, Comparator cmp) {
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        return new Value.BoolValue(compare((Value) CollectionsKt.firstOrNull((List) listEvalArgs), listEvalArgs.size() >= 2 ? listEvalArgs.get(1) : null, cmp));
    }

    private final double asDouble(Value value) {
        Double numberOrNull$purchases_defaultsRelease;
        if (value == null || (numberOrNull$purchases_defaultsRelease = value.toNumberOrNull$purchases_defaultsRelease()) == null) {
            return Double.NaN;
        }
        return numberOrNull$purchases_defaultsRelease.doubleValue();
    }
}
