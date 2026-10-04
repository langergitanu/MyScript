package com.myscript.nebo.storage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/storage/AvailableSpaceProvider;", "", "getAvailableSpace", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCriticalThreshold", "getLowThreshold", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AvailableSpaceProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Object getAvailableSpace(Continuation<? super Long> continuation);

    default long getCriticalThreshold() {
        return 524288000L;
    }

    default long getLowThreshold() {
        return 1048576000L;
    }

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static long getCriticalThreshold(AvailableSpaceProvider availableSpaceProvider) {
            return AvailableSpaceProvider.super.getCriticalThreshold();
        }

        @Deprecated
        public static long getLowThreshold(AvailableSpaceProvider availableSpaceProvider) {
            return AvailableSpaceProvider.super.getLowThreshold();
        }
    }

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/storage/AvailableSpaceProvider$Companion;", "", "<init>", "()V", "CRITICAL_THRESHOLD", "", "LOW_THRESHOLD", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final long CRITICAL_THRESHOLD = 524288000;
        private static final long LOW_THRESHOLD = 1048576000;

        private Companion() {
        }
    }
}
