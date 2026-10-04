package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.revenuecat.purchases.CustomerInfoOriginalSource, still in use, count: 1, list:
  (r0v0 com.revenuecat.purchases.CustomerInfoOriginalSource) from 0x002c: SPUT (r0v0 com.revenuecat.purchases.CustomerInfoOriginalSource) (LINE:33) com.revenuecat.purchases.CustomerInfoOriginalSource.DEFAULT com.revenuecat.purchases.CustomerInfoOriginalSource
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: CustomerInfo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/CustomerInfoOriginalSource;", "", "(Ljava/lang/String;I)V", "MAIN", "LOAD_SHEDDER", "OFFLINE_ENTITLEMENTS", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CustomerInfoOriginalSource {
    MAIN,
    LOAD_SHEDDER,
    OFFLINE_ENTITLEMENTS;

    private static final CustomerInfoOriginalSource DEFAULT = new CustomerInfoOriginalSource();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static CustomerInfoOriginalSource valueOf(String str) {
        return (CustomerInfoOriginalSource) Enum.valueOf(CustomerInfoOriginalSource.class, str);
    }

    public static CustomerInfoOriginalSource[] values() {
        return (CustomerInfoOriginalSource[]) $VALUES.clone();
    }

    private CustomerInfoOriginalSource() {
    }

    static {
    }

    /* JADX INFO: compiled from: CustomerInfo.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/CustomerInfoOriginalSource$Companion;", "", "()V", "DEFAULT", "Lcom/revenuecat/purchases/CustomerInfoOriginalSource;", "getDEFAULT", "()Lcom/revenuecat/purchases/CustomerInfoOriginalSource;", "fromString", "originalSourceString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomerInfoOriginalSource getDEFAULT() {
            return CustomerInfoOriginalSource.DEFAULT;
        }

        public final CustomerInfoOriginalSource fromString(String originalSourceString) {
            if (originalSourceString != null) {
                try {
                    return CustomerInfoOriginalSource.valueOf(originalSourceString);
                } catch (IllegalArgumentException e) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Invalid CustomerInfo original source deserializing from cache", e);
                    return getDEFAULT();
                }
            }
            return getDEFAULT();
        }
    }
}
