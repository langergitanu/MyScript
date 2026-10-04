package com.survicate.surveys;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: IntegrationListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/IntegrationListener;", "Lcom/survicate/surveys/SurvicateEventListener;", "<init>", "()V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "onWillSendAnswer", "", "Lcom/survicate/surveys/IntegrationPayload;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public class IntegrationListener extends SurvicateEventListener {
    private final String providerName = "";

    public String getProviderName() {
        return this.providerName;
    }

    public Map<String, IntegrationPayload> onWillSendAnswer() {
        return MapsKt.emptyMap();
    }
}
