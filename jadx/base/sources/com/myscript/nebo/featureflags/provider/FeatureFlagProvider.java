package com.myscript.nebo.featureflags.provider;

import com.myscript.nebo.featureflags.feature.Feature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: FeatureFlagProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/featureflags/provider/FeatureFlagProvider;", "", LogFactory.PRIORITY_KEY, "", "getPriority", "()I", "hasFeature", "", "featureKey", "", "isFeatureEnabled", "defaultValue", "isReadonly", "feature", "Lcom/myscript/nebo/featureflags/feature/Feature;", "Companion", "feature-flags_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface FeatureFlagProvider {
    public static final int BUILD_TIME_PRIORITY = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final boolean FEATURE_DEFAULT = false;
    public static final int MAX_PRIORITY = 1;
    public static final int MEDIUM_PRIORITY = 2;
    public static final int MIN_PRIORITY = 3;

    int getPriority();

    default boolean hasFeature(String featureKey) {
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        return true;
    }

    default boolean isFeatureEnabled(String featureKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        return defaultValue;
    }

    /* JADX INFO: compiled from: FeatureFlagProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean hasFeature(FeatureFlagProvider featureFlagProvider, String featureKey) {
            Intrinsics.checkNotNullParameter(featureKey, "featureKey");
            return FeatureFlagProvider.super.hasFeature(featureKey);
        }

        @Deprecated
        public static boolean isFeatureEnabled(FeatureFlagProvider featureFlagProvider, String featureKey, boolean z) {
            Intrinsics.checkNotNullParameter(featureKey, "featureKey");
            return FeatureFlagProvider.super.isFeatureEnabled(featureKey, z);
        }

        @Deprecated
        public static boolean isReadonly(FeatureFlagProvider featureFlagProvider, Feature feature) {
            Intrinsics.checkNotNullParameter(feature, "feature");
            return FeatureFlagProvider.super.isReadonly(feature);
        }
    }

    default boolean isReadonly(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return feature.getReadonly();
    }

    /* JADX INFO: compiled from: FeatureFlagProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/featureflags/provider/FeatureFlagProvider$Companion;", "", "<init>", "()V", "BUILD_TIME_PRIORITY", "", "MAX_PRIORITY", "MEDIUM_PRIORITY", "MIN_PRIORITY", "FEATURE_DEFAULT", "", "feature-flags_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BUILD_TIME_PRIORITY = 0;
        public static final boolean FEATURE_DEFAULT = false;
        public static final int MAX_PRIORITY = 1;
        public static final int MEDIUM_PRIORITY = 2;
        public static final int MIN_PRIORITY = 3;

        private Companion() {
        }
    }
}
