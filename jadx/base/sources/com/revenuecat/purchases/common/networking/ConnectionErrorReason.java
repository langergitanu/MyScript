package com.revenuecat.purchases.common.networking;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectionErrorReason.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ConnectionErrorReason;", "", "(Ljava/lang/String;I)V", "TIMEOUT", "NO_NETWORK", "OTHER", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum ConnectionErrorReason {
    TIMEOUT,
    NO_NETWORK,
    OTHER;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ConnectionErrorReason.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ConnectionErrorReason$Companion;", "", "()V", "fromIOException", "Lcom/revenuecat/purchases/common/networking/ConnectionErrorReason;", "ioException", "Ljava/io/IOException;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectionErrorReason fromIOException(IOException ioException) {
            Intrinsics.checkNotNullParameter(ioException, "ioException");
            if (ioException instanceof SocketTimeoutException) {
                return ConnectionErrorReason.TIMEOUT;
            }
            if (ioException instanceof ConnectException ? true : ioException instanceof UnknownHostException) {
                return ConnectionErrorReason.NO_NETWORK;
            }
            return ConnectionErrorReason.OTHER;
        }
    }
}
