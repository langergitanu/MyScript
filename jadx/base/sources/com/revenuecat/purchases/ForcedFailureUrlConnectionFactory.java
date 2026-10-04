package com.revenuecat.purchases;

import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForcedFailureUrlConnectionFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ForcedFailureUrlConnectionFactory;", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "delegate", "strategy", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "(Lcom/revenuecat/purchases/utils/UrlConnectionFactory;Lcom/revenuecat/purchases/ForceServerErrorStrategy;)V", "createConnection", "Lcom/revenuecat/purchases/utils/UrlConnection;", ImagesContract.URL, "", "connectTimeoutMillis", "", "readTimeoutMillis", "requestMethod", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ForcedFailureUrlConnectionFactory implements UrlConnectionFactory {
    private final UrlConnectionFactory delegate;
    private final ForceServerErrorStrategy strategy;

    public ForcedFailureUrlConnectionFactory(UrlConnectionFactory delegate, ForceServerErrorStrategy strategy) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.delegate = delegate;
        this.strategy = strategy;
    }

    @Override // com.revenuecat.purchases.utils.UrlConnectionFactory
    public UrlConnection createConnection(String url, int connectTimeoutMillis, int readTimeoutMillis, String requestMethod) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        if (this.strategy.shouldForceConnectionFailure(url)) {
            throw new IOException("Forced connection failure for " + url);
        }
        return this.delegate.createConnection(url, connectTimeoutMillis, readTimeoutMillis, requestMethod);
    }
}
