package com.myscript.nebo.utils;

import com.myscript.nebo.featureflags.feature.Feature;
import com.myscript.nebo.featureflags.provider.FeatureFlagProvider;
import com.myscript.nebo.sso.model.UserData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: InstrumentedFeatureFlagProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/utils/InstrumentedFeatureFlagProvider;", "Lcom/myscript/nebo/featureflags/provider/FeatureFlagProvider;", "userDataProvider", "Lcom/myscript/nebo/sso/model/UserData;", "<init>", "(Lcom/myscript/nebo/sso/model/UserData;)V", LogFactory.PRIORITY_KEY, "", "getPriority", "()I", "hasFeature", "", "featureKey", "", "isFeatureEnabled", "defaultValue", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstrumentedFeatureFlagProvider implements FeatureFlagProvider {
    public static final int $stable = 8;
    private final int priority;
    private final UserData userDataProvider;

    public InstrumentedFeatureFlagProvider(UserData userDataProvider) {
        Intrinsics.checkNotNullParameter(userDataProvider, "userDataProvider");
        this.userDataProvider = userDataProvider;
        this.priority = 3;
    }

    @Override // com.myscript.nebo.featureflags.provider.FeatureFlagProvider
    public /* bridge */ boolean isReadonly(Feature feature) {
        return super.isReadonly(feature);
    }

    @Override // com.myscript.nebo.featureflags.provider.FeatureFlagProvider
    public int getPriority() {
        return this.priority;
    }

    @Override // com.myscript.nebo.featureflags.provider.FeatureFlagProvider
    public boolean hasFeature(String featureKey) {
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        return Intrinsics.areEqual(featureKey, "instrumented");
    }

    @Override // com.myscript.nebo.featureflags.provider.FeatureFlagProvider
    public boolean isFeatureEnabled(String featureKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        return this.userDataProvider.isInstrumentedFeatureActivated();
    }
}
