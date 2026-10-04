package com.myscript.nebo.sso.api;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SSOHttpClient.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\t\u001a\u00020\nH\u0016R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"com/myscript/nebo/sso/api/SSOHttpClientKt$buildNativeLoginHttpClient$cookieJar$1", "Lokhttp3/CookieJar;", "store", "", "", "", "Lokhttp3/Cookie;", "saveFromResponse", "", ImagesContract.URL, "Lokhttp3/HttpUrl;", "cookies", "", "loadForRequest", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SSOHttpClientKt$buildNativeLoginHttpClient$cookieJar$1 implements CookieJar {
    private final Map<String, List<Cookie>> store = new LinkedHashMap();

    SSOHttpClientKt$buildNativeLoginHttpClient$cookieJar$1() {
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        synchronized (this.store) {
            Map<String, List<Cookie>> map = this.store;
            String strHost = url.host();
            ArrayList arrayList = map.get(strHost);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(strHost, arrayList);
            }
            List<Cookie> list = arrayList;
            for (final Cookie cookie : cookies) {
                CollectionsKt.removeAll((List) list, new Function1() { // from class: com.myscript.nebo.sso.api.SSOHttpClientKt$buildNativeLoginHttpClient$cookieJar$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SSOHttpClientKt$buildNativeLoginHttpClient$cookieJar$1.saveFromResponse$lambda$0$1$0$0(cookie, (Cookie) obj));
                    }
                });
            }
            list.addAll(cookies);
            List<Cookie> list2 = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean saveFromResponse$lambda$0$1$0$0(Cookie cookie, Cookie it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.name(), cookie.name());
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl url) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(url, "url");
        synchronized (this.store) {
            List<Cookie> list = this.store.get(url.host());
            if (list == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((Cookie) obj).matches(url)) {
                        arrayList.add(obj);
                    }
                }
                arrayListEmptyList = arrayList;
            }
        }
        return arrayListEmptyList;
    }
}
