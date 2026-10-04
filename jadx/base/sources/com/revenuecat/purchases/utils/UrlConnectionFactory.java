package com.revenuecat.purchases.utils;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;

/* JADX INFO: compiled from: UrlConnectionFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "", "createConnection", "Lcom/revenuecat/purchases/utils/UrlConnection;", ImagesContract.URL, "", "connectTimeoutMillis", "", "readTimeoutMillis", "requestMethod", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface UrlConnectionFactory {
    UrlConnection createConnection(String url, int connectTimeoutMillis, int readTimeoutMillis, String requestMethod);

    /* JADX INFO: compiled from: UrlConnectionFactory.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ UrlConnection createConnection$default(UrlConnectionFactory urlConnectionFactory, String str, int i, int i2, String str2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConnection");
        }
        if ((i3 & 8) != 0) {
            str2 = "GET";
        }
        return urlConnectionFactory.createConnection(str, i, i2, str2);
    }
}
