package com.revenuecat.purchases.rules.customoperators;

import androidx.collection.SieveCacheKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import com.revenuecat.purchases.rules.operators.Operators;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: RegexOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/RegexOperators;", "", "()V", "BINARY", "", "TERNARY", "group", "value", "Lcom/revenuecat/purchases/rules/Value;", "operatorName", "", "opRegexExtract", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "opRegexMatch", "opRegexReplace", "operands", "Lcom/revenuecat/purchases/rules/customoperators/RegexOperators$Operands;", "evaluated", "", "Operands", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RegexOperators {
    private static final int BINARY = 2;
    public static final RegexOperators INSTANCE = new RegexOperators();
    private static final int TERNARY = 3;

    private RegexOperators() {
    }

    public final Value opRegexMatch(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Operators.INSTANCE.checkArity(listEvalArgs.size(), CollectionsKt.listOf(2), "rc.regexMatch");
        Operands operands = operands(listEvalArgs, "rc.regexMatch");
        return new Value.BoolValue(operands.getRegex().containsMatchIn(operands.getInput()));
    }

    public final Value opRegexExtract(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        MatchGroupCollection groups;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Operators.INSTANCE.checkArity(listEvalArgs.size(), CollectionsKt.listOf((Object[]) new Integer[]{2, 3}), "rc.regexExtract");
        Operands operands = operands(listEvalArgs, "rc.regexExtract");
        int iGroup = group((Value) CollectionsKt.getOrNull(listEvalArgs, 2), "rc.regexExtract");
        int iGroupCount = operands.getRegex().getNativePattern().matcher("").groupCount();
        if (iGroup > iGroupCount) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.regexExtract' asked for group " + iGroup + " of a pattern with " + iGroupCount + " capture group(s)");
        }
        MatchGroup matchGroup = null;
        MatchResult matchResultFind$default = Regex.find$default(operands.getRegex(), operands.getInput(), 0, 2, null);
        if (matchResultFind$default != null && (groups = matchResultFind$default.getGroups()) != null) {
            matchGroup = groups.get(iGroup);
        }
        return matchGroup != null ? new Value.StringValue(matchGroup.getValue()) : Value.Null.INSTANCE;
    }

    public final Value opRegexReplace(Value args, Scope vars) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        List<Value> listEvalArgs = Operators.INSTANCE.evalArgs(args, vars);
        Operators.INSTANCE.checkArity(listEvalArgs.size(), CollectionsKt.listOf(3), "rc.regexReplace");
        Operands operands = operands(listEvalArgs, "rc.regexReplace");
        Value value = listEvalArgs.get(2);
        if (!(value instanceof Value.StringValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator 'rc.regexReplace' expected a string replacement, got " + value);
        }
        return new Value.StringValue(operands.getRegex().replace(operands.getInput(), Regex.INSTANCE.escapeReplacement(((Value.StringValue) value).getValue())));
    }

    private final int group(Value value, String operatorName) throws RulesEngine.EvaluationException.TypeMismatch {
        if (value == null) {
            return 0;
        }
        if (value instanceof Value.IntValue) {
            Value.IntValue intValue = (Value.IntValue) value;
            if (intValue.getValue() >= 0) {
                return (int) RangesKt.coerceAtMost(intValue.getValue(), SieveCacheKt.NodeLinkMask);
            }
        }
        if (value instanceof Value.FloatValue) {
            Value.FloatValue floatValue = (Value.FloatValue) value;
            if (floatValue.getValue() >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && floatValue.getValue() % 1.0d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return Operators.INSTANCE.clampedInt(floatValue.getValue());
            }
        }
        throw new RulesEngine.EvaluationException.TypeMismatch("operator '" + operatorName + "' expected a whole, non-negative group number, got " + value);
    }

    public final Operands operands(List<? extends Value> evaluated, String operatorName) throws RulesEngine.EvaluationException.TypeMismatch {
        Intrinsics.checkNotNullParameter(evaluated, "evaluated");
        Intrinsics.checkNotNullParameter(operatorName, "operatorName");
        Value value = evaluated.get(0);
        if (!(value instanceof Value.StringValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator '" + operatorName + "' expected a string to match against, got " + value);
        }
        Value value2 = evaluated.get(1);
        if (!(value2 instanceof Value.StringValue)) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator '" + operatorName + "' expected a string pattern, got " + value2);
        }
        try {
            return new Operands(((Value.StringValue) value).getValue(), new Regex(((Value.StringValue) value2).getValue()));
        } catch (PatternSyntaxException unused) {
            throw new RulesEngine.EvaluationException.TypeMismatch("operator '" + operatorName + "' could not compile pattern '" + ((Value.StringValue) value2).getValue() + '\'');
        }
    }

    /* JADX INFO: compiled from: RegexOperators.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/RegexOperators$Operands;", "", "input", "", "regex", "Lkotlin/text/Regex;", "(Ljava/lang/String;Lkotlin/text/Regex;)V", "getInput", "()Ljava/lang/String;", "getRegex", "()Lkotlin/text/Regex;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class Operands {
        private final String input;
        private final Regex regex;

        public static /* synthetic */ Operands copy$default(Operands operands, String str, Regex regex, int i, Object obj) {
            if ((i & 1) != 0) {
                str = operands.input;
            }
            if ((i & 2) != 0) {
                regex = operands.regex;
            }
            return operands.copy(str, regex);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInput() {
            return this.input;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Regex getRegex() {
            return this.regex;
        }

        public final Operands copy(String input, Regex regex) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(regex, "regex");
            return new Operands(input, regex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Operands)) {
                return false;
            }
            Operands operands = (Operands) other;
            return Intrinsics.areEqual(this.input, operands.input) && Intrinsics.areEqual(this.regex, operands.regex);
        }

        public int hashCode() {
            return (this.input.hashCode() * 31) + this.regex.hashCode();
        }

        public String toString() {
            return "Operands(input=" + this.input + ", regex=" + this.regex + ')';
        }

        public Operands(String input, Regex regex) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(regex, "regex");
            this.input = input;
            this.regex = regex;
        }

        public final String getInput() {
            return this.input;
        }

        public final Regex getRegex() {
            return this.regex;
        }
    }
}
