package com.myscript.nebo.utils;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.myscript.nebo.featureflags.feature.Feature;
import com.myscript.nebo.featureflags.provider.FeatureFlagProvider;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: EarlyAccessFeaturesProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/utils/EarlyAccessFeaturesProvider;", "Lcom/myscript/nebo/featureflags/provider/FeatureFlagProvider;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", LogFactory.PRIORITY_KEY, "", "getPriority", "()I", "hasFeature", "", "featureKey", "", "isFeatureEnabled", "defaultValue", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EarlyAccessFeaturesProvider implements FeatureFlagProvider {
    public static final int $stable = 8;
    private final Application application;
    private final int priority;
    private final SharedPreferences sharedPreferences;

    public EarlyAccessFeaturesProvider(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.sharedPreferences = defaultSharedPreferences;
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
        EnumEntries<EarlyAccessFeature> entries = EarlyAccessFeature.getEntries();
        if ((entries instanceof Collection) && entries.isEmpty()) {
            return false;
        }
        Iterator<EarlyAccessFeature> it = entries.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getKey(), featureKey)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.myscript.nebo.featureflags.provider.FeatureFlagProvider
    public boolean isFeatureEnabled(String featureKey, boolean defaultValue) {
        EarlyAccessFeature next;
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        Iterator<EarlyAccessFeature> it = EarlyAccessFeature.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(next.getKey(), featureKey)) {
                break;
            }
        }
        EarlyAccessFeature earlyAccessFeature = next;
        if (earlyAccessFeature == null) {
            return false;
        }
        String string = this.application.getString(earlyAccessFeature.getSharedPreferenceKey());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return this.sharedPreferences.getBoolean(string, defaultValue);
    }
}
