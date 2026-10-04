package com.myscript.nebo.sso.api.discovery;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;

/* JADX INFO: compiled from: DiscoveryApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/discovery/DiscoveryApi;", "", "discoverSSOConfiguration", "Lcom/myscript/nebo/sso/api/discovery/DiscoveredSSOConfiguration;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface DiscoveryApi {
    @GET("/.well-known/openid-configuration")
    Object discoverSSOConfiguration(Continuation<? super DiscoveredSSOConfiguration> continuation);
}
