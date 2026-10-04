package com.revenuecat.purchases.rules;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: RulesEngine.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/RulesEngine;", "", "()V", "_logger", "Lcom/revenuecat/purchases/rules/RulesEngineLogger;", "logger", "getLogger$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/rules/RulesEngineLogger;", "evaluate", "Lkotlin/Result;", "", "predicate", "", "variables", "", "Lcom/revenuecat/purchases/rules/Value;", "evaluate-gIAlu-s", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/Object;", "setLogger", "", "EvaluationException", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RulesEngine {
    public static final RulesEngine INSTANCE = new RulesEngine();
    private static volatile RulesEngineLogger _logger = PrintLogger.INSTANCE;

    private RulesEngine() {
    }

    public final RulesEngineLogger getLogger$purchases_defaultsRelease() {
        return _logger;
    }

    public final synchronized void setLogger(RulesEngineLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        _logger = logger;
    }

    /* JADX INFO: compiled from: RulesEngine.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\u0006\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "Parse", "TypeMismatch", "Unknown", "UnresolvedVariable", "UnsupportedOperator", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$Parse;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$TypeMismatch;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$Unknown;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$UnresolvedVariable;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$UnsupportedOperator;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static abstract class EvaluationException extends Exception {
        public /* synthetic */ EvaluationException(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private EvaluationException(String str) {
            super(str);
        }

        /* JADX INFO: compiled from: RulesEngine.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$Parse;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Parse extends EvaluationException {
            private final String reason;

            public static /* synthetic */ Parse copy$default(Parse parse, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = parse.reason;
                }
                return parse.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final Parse copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Parse(reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Parse) && Intrinsics.areEqual(this.reason, ((Parse) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            @Override // java.lang.Throwable
            public String toString() {
                return "Parse(reason=" + this.reason + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Parse(String reason) {
                super("failed to parse predicate JSON: " + reason, null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }
        }

        /* JADX INFO: compiled from: RulesEngine.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$UnresolvedVariable;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException;", ClientCookie.PATH_ATTR, "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class UnresolvedVariable extends EvaluationException {
            private final String path;

            public static /* synthetic */ UnresolvedVariable copy$default(UnresolvedVariable unresolvedVariable, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unresolvedVariable.path;
                }
                return unresolvedVariable.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPath() {
                return this.path;
            }

            public final UnresolvedVariable copy(String path) {
                Intrinsics.checkNotNullParameter(path, "path");
                return new UnresolvedVariable(path);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UnresolvedVariable) && Intrinsics.areEqual(this.path, ((UnresolvedVariable) other).path);
            }

            public int hashCode() {
                return this.path.hashCode();
            }

            @Override // java.lang.Throwable
            public String toString() {
                return "UnresolvedVariable(path=" + this.path + ')';
            }

            public final String getPath() {
                return this.path;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UnresolvedVariable(String path) {
                super("unresolved variable: " + path, null);
                Intrinsics.checkNotNullParameter(path, "path");
                this.path = path;
            }
        }

        /* JADX INFO: compiled from: RulesEngine.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$TypeMismatch;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException;", "detail", "", "(Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class TypeMismatch extends EvaluationException {
            private final String detail;

            public static /* synthetic */ TypeMismatch copy$default(TypeMismatch typeMismatch, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = typeMismatch.detail;
                }
                return typeMismatch.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getDetail() {
                return this.detail;
            }

            public final TypeMismatch copy(String detail) {
                Intrinsics.checkNotNullParameter(detail, "detail");
                return new TypeMismatch(detail);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TypeMismatch) && Intrinsics.areEqual(this.detail, ((TypeMismatch) other).detail);
            }

            public int hashCode() {
                return this.detail.hashCode();
            }

            @Override // java.lang.Throwable
            public String toString() {
                return "TypeMismatch(detail=" + this.detail + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TypeMismatch(String detail) {
                super("type mismatch: " + detail, null);
                Intrinsics.checkNotNullParameter(detail, "detail");
                this.detail = detail;
            }

            public final String getDetail() {
                return this.detail;
            }
        }

        /* JADX INFO: compiled from: RulesEngine.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$UnsupportedOperator;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class UnsupportedOperator extends EvaluationException {
            private final String name;

            public static /* synthetic */ UnsupportedOperator copy$default(UnsupportedOperator unsupportedOperator, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unsupportedOperator.name;
                }
                return unsupportedOperator.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final UnsupportedOperator copy(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new UnsupportedOperator(name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UnsupportedOperator) && Intrinsics.areEqual(this.name, ((UnsupportedOperator) other).name);
            }

            public int hashCode() {
                return this.name.hashCode();
            }

            @Override // java.lang.Throwable
            public String toString() {
                return "UnsupportedOperator(name=" + this.name + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UnsupportedOperator(String name) {
                super("unsupported operator: " + name, null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: RulesEngine.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException$Unknown;", "Lcom/revenuecat/purchases/rules/RulesEngine$EvaluationException;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Unknown extends EvaluationException {
            private final String reason;

            public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unknown.reason;
                }
                return unknown.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final Unknown copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Unknown(reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Unknown) && Intrinsics.areEqual(this.reason, ((Unknown) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            @Override // java.lang.Throwable
            public String toString() {
                return "Unknown(reason=" + this.reason + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Unknown(String reason) {
                super("unknown error: " + reason, null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }
        }
    }

    /* JADX INFO: renamed from: evaluate-gIAlu-s, reason: not valid java name */
    public final Object m13852evaluategIAlus(String predicate, Map<String, ? extends Value> variables) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(variables, "variables");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Boolean.valueOf(Evaluator.INSTANCE.evaluate(ValueJson.INSTANCE.parse(predicate), variables)));
        } catch (EvaluationException e) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(e));
        } catch (Exception e2) {
            Result.Companion companion3 = Result.INSTANCE;
            String message = e2.getMessage();
            if (message == null) {
                message = "unknown error";
            }
            return Result.m14499constructorimpl(ResultKt.createFailure(new EvaluationException.Unknown(message)));
        }
    }
}
