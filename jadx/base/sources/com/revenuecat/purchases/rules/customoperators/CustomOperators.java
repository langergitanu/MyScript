package com.revenuecat.purchases.rules.customoperators;

import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Scope;
import com.revenuecat.purchases.rules.Value;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomOperators.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/customoperators/CustomOperators;", "", "()V", "dispatch", "Lcom/revenuecat/purchases/rules/Value;", "op", "", "args", "vars", "Lcom/revenuecat/purchases/rules/Scope;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CustomOperators {
    public static final CustomOperators INSTANCE = new CustomOperators();

    private CustomOperators() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Value dispatch(String op, Value args, Scope vars) throws RulesEngine.EvaluationException.UnsupportedOperator {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(vars, "vars");
        switch (op.hashCode()) {
            case -2115354358:
                if (op.equals("rc.regexReplace")) {
                    return RegexOperators.INSTANCE.opRegexReplace(args, vars);
                }
                break;
            case -1267268197:
                if (op.equals("rc.regexMatch")) {
                    return RegexOperators.INSTANCE.opRegexMatch(args, vars);
                }
                break;
            case -938338082:
                if (op.equals("rc.let")) {
                    return LetOperator.INSTANCE.opLet(args, vars);
                }
                break;
            case -669649591:
                if (op.equals("rc.fromEntries")) {
                    return EntriesOperators.INSTANCE.opFromEntries(args, vars);
                }
                break;
            case -220173609:
                if (op.equals("rc.regexExtract")) {
                    return RegexOperators.INSTANCE.opRegexExtract(args, vars);
                }
                break;
            case 200539396:
                if (op.equals("rc.lower")) {
                    return CaseOperators.INSTANCE.opLower(args, vars);
                }
                break;
            case 206901141:
                if (op.equals("rc.slice")) {
                    return SliceOperator.INSTANCE.opSlice(args, vars);
                }
                break;
            case 207023389:
                if (op.equals("rc.split")) {
                    return SplitOperator.INSTANCE.opSplit(args, vars);
                }
                break;
            case 208874149:
                if (op.equals("rc.upper")) {
                    return CaseOperators.INSTANCE.opUpper(args, vars);
                }
                break;
            case 467920936:
                if (op.equals("rc.rootVar")) {
                    return RootVarOperator.INSTANCE.opRootVar(args, vars);
                }
                break;
            case 1392190816:
                if (op.equals("rc.semverCompare")) {
                    return SemverOperator.INSTANCE.opSemverCompare(args, vars);
                }
                break;
            case 1791222227:
                if (op.equals("rc.entries")) {
                    return EntriesOperators.INSTANCE.opEntries(args, vars);
                }
                break;
            case 2122022130:
                if (op.equals("rc.sortBy")) {
                    return SortByOperator.INSTANCE.opSortBy(args, vars);
                }
                break;
        }
        throw new RulesEngine.EvaluationException.UnsupportedOperator(op);
    }
}
