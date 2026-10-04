package com.revenuecat.purchases.common.localrules;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: RulesDimensionResolver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0006\u0007B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "ConflictingDimension", "ProviderFailed", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException$ConflictingDimension;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException$ProviderFailed;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class RulesDimensionResolutionException extends Exception {
    public /* synthetic */ RulesDimensionResolutionException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private RulesDimensionResolutionException(String str) {
        super(str);
    }

    /* JADX INFO: compiled from: RulesDimensionResolver.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException$ProviderFailed;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException;", "namespace", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "reason", "", "(Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;Ljava/lang/String;)V", "getNamespace", "()Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "getReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class ProviderFailed extends RulesDimensionResolutionException {
        private final RulesDimensionNamespace namespace;
        private final String reason;

        public static /* synthetic */ ProviderFailed copy$default(ProviderFailed providerFailed, RulesDimensionNamespace rulesDimensionNamespace, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                rulesDimensionNamespace = providerFailed.namespace;
            }
            if ((i & 2) != 0) {
                str = providerFailed.reason;
            }
            return providerFailed.copy(rulesDimensionNamespace, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RulesDimensionNamespace getNamespace() {
            return this.namespace;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final ProviderFailed copy(RulesDimensionNamespace namespace, String reason) {
            Intrinsics.checkNotNullParameter(namespace, "namespace");
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new ProviderFailed(namespace, reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProviderFailed)) {
                return false;
            }
            ProviderFailed providerFailed = (ProviderFailed) other;
            return this.namespace == providerFailed.namespace && Intrinsics.areEqual(this.reason, providerFailed.reason);
        }

        public int hashCode() {
            return (this.namespace.hashCode() * 31) + this.reason.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "ProviderFailed(namespace=" + this.namespace + ", reason=" + this.reason + ')';
        }

        public final RulesDimensionNamespace getNamespace() {
            return this.namespace;
        }

        public final String getReason() {
            return this.reason;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProviderFailed(RulesDimensionNamespace namespace, String reason) {
            super("dimension provider '" + namespace.getKey() + "' failed: " + reason, null);
            Intrinsics.checkNotNullParameter(namespace, "namespace");
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.namespace = namespace;
            this.reason = reason;
        }
    }

    /* JADX INFO: compiled from: RulesDimensionResolver.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException$ConflictingDimension;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException;", ClientCookie.PATH_ATTR, "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class ConflictingDimension extends RulesDimensionResolutionException {
        private final String path;

        public static /* synthetic */ ConflictingDimension copy$default(ConflictingDimension conflictingDimension, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conflictingDimension.path;
            }
            return conflictingDimension.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        public final ConflictingDimension copy(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new ConflictingDimension(path);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ConflictingDimension) && Intrinsics.areEqual(this.path, ((ConflictingDimension) other).path);
        }

        public int hashCode() {
            return this.path.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "ConflictingDimension(path=" + this.path + ')';
        }

        public final String getPath() {
            return this.path;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConflictingDimension(String path) {
            super("two dimension providers supplied '" + path + '\'', null);
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
        }
    }
}
