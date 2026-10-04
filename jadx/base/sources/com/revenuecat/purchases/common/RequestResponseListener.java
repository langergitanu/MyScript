package com.revenuecat.purchases.common;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001JZ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/RequestResponseListener;", "", "onRequestResponse", "", ImagesContract.URL, "", FirebaseAnalytics.Param.METHOD, "requestHeaders", "", "requestBody", "responseCode", "", "responseHeaders", "responseBody", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface RequestResponseListener {
    void onRequestResponse(String url, String method, Map<String, String> requestHeaders, String requestBody, int responseCode, Map<String, String> responseHeaders, String responseBody);
}
