package com.myscript.nebo.featureflags;

import com.myscript.nebo.featureflags.feature.Feature;
import com.myscript.nebo.featureflags.provider.FeatureFlagProvider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RuntimeFeatureFlagHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/featureflags/RuntimeFeatureFlagHelper;", "", "<init>", "()V", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/myscript/nebo/featureflags/provider/FeatureFlagProvider;", "isFeatureEnabled", "", "feature", "Lcom/myscript/nebo/featureflags/feature/Feature;", "addProvider", "provider", "feature-flags_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RuntimeFeatureFlagHelper {
    public static final RuntimeFeatureFlagHelper INSTANCE = new RuntimeFeatureFlagHelper();
    private static final CopyOnWriteArrayList<FeatureFlagProvider> providers = new CopyOnWriteArrayList<>();

    private RuntimeFeatureFlagHelper() {
    }

    @JvmStatic
    public static final boolean isFeatureEnabled(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        CopyOnWriteArrayList<FeatureFlagProvider> copyOnWriteArrayList = providers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            if (((FeatureFlagProvider) obj).hasFeature(feature.getKey())) {
                arrayList.add(obj);
            }
        }
        FeatureFlagProvider featureFlagProvider = (FeatureFlagProvider) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.myscript.nebo.featureflags.RuntimeFeatureFlagHelper$isFeatureEnabled$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((FeatureFlagProvider) t).getPriority()), Integer.valueOf(((FeatureFlagProvider) t2).getPriority()));
            }
        }));
        if (featureFlagProvider != null) {
            return featureFlagProvider.isFeatureEnabled(feature.getKey(), feature.getDefaultValue());
        }
        return feature.getDefaultValue();
    }

    @JvmStatic
    public static final boolean addProvider(FeatureFlagProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        return providers.add(provider);
    }
}
