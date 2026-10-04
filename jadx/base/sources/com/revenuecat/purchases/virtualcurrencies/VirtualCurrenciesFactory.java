package com.revenuecat.purchases.virtualcurrencies;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.common.JsonProvider;
import com.revenuecat.purchases.common.networking.HTTPResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VirtualCurrenciesFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrenciesFactory;", "", "()V", "buildVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "httpResult", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "jsonString", "", TtmlNode.TAG_BODY, "Lorg/json/JSONObject;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class VirtualCurrenciesFactory {
    public static final VirtualCurrenciesFactory INSTANCE = new VirtualCurrenciesFactory();

    private VirtualCurrenciesFactory() {
    }

    public final VirtualCurrencies buildVirtualCurrencies(HTTPResult httpResult) throws JSONException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(httpResult, "httpResult");
        return buildVirtualCurrencies(httpResult.getBody());
    }

    public final VirtualCurrencies buildVirtualCurrencies(JSONObject body) throws JSONException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(body, "body");
        Json defaultJson = JsonProvider.INSTANCE.getDefaultJson();
        String string = body.toString();
        Intrinsics.checkNotNullExpressionValue(string, "body.toString()");
        defaultJson.getSerializersModule();
        return (VirtualCurrencies) defaultJson.decodeFromString(VirtualCurrencies.INSTANCE.serializer(), string);
    }

    public final VirtualCurrencies buildVirtualCurrencies(String jsonString) throws JSONException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Json defaultJson = JsonProvider.INSTANCE.getDefaultJson();
        defaultJson.getSerializersModule();
        return (VirtualCurrencies) defaultJson.decodeFromString(VirtualCurrencies.INSTANCE.serializer(), jsonString);
    }
}
