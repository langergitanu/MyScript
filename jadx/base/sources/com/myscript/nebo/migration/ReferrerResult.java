package com.myscript.nebo.migration;

import com.myscript.nebo.purchase.NeboUserProfileManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstallReferrerSource.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/ReferrerResult;", "", "Resolved", "Transient", "Lcom/myscript/nebo/migration/ReferrerResult$Resolved;", "Lcom/myscript/nebo/migration/ReferrerResult$Transient;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ReferrerResult {

    /* JADX INFO: compiled from: InstallReferrerSource.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/migration/ReferrerResult$Resolved;", "Lcom/myscript/nebo/migration/ReferrerResult;", NeboUserProfileManager.CUSTOM_ATTRIBUTE_REFERRER_KEY, "", "<init>", "(Ljava/lang/String;)V", "getReferrer", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Resolved implements ReferrerResult {
        public static final int $stable = 0;
        private final String referrer;

        public static /* synthetic */ Resolved copy$default(Resolved resolved, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resolved.referrer;
            }
            return resolved.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getReferrer() {
            return this.referrer;
        }

        public final Resolved copy(String referrer) {
            return new Resolved(referrer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Resolved) && Intrinsics.areEqual(this.referrer, ((Resolved) other).referrer);
        }

        public int hashCode() {
            String str = this.referrer;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Resolved(referrer=" + this.referrer + ")";
        }

        public Resolved(String str) {
            this.referrer = str;
        }

        public final String getReferrer() {
            return this.referrer;
        }
    }

    /* JADX INFO: compiled from: InstallReferrerSource.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/migration/ReferrerResult$Transient;", "Lcom/myscript/nebo/migration/ReferrerResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Transient implements ReferrerResult {
        public static final int $stable = 0;
        public static final Transient INSTANCE = new Transient();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Transient)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -651762792;
        }

        public String toString() {
            return "Transient";
        }

        private Transient() {
        }
    }
}
