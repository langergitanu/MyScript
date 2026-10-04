package com.revenuecat.purchases.utils;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UrlConnectionFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/DefaultUrlConnectionFactory;", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "()V", "createConnection", "Lcom/revenuecat/purchases/utils/UrlConnection;", ImagesContract.URL, "", "connectTimeoutMillis", "", "readTimeoutMillis", "requestMethod", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DefaultUrlConnectionFactory implements UrlConnectionFactory {
    @Override // com.revenuecat.purchases.utils.UrlConnectionFactory
    public UrlConnection createConnection(String url, int connectTimeoutMillis, int readTimeoutMillis, String requestMethod) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout(connectTimeoutMillis);
        httpURLConnection.setReadTimeout(readTimeoutMillis);
        httpURLConnection.setRequestMethod(requestMethod);
        httpURLConnection.setDoInput(true);
        return new DefaultUrlConnection(httpURLConnection);
    }
}
