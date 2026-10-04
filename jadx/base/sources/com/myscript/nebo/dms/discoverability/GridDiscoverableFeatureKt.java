package com.myscript.nebo.dms.discoverability;

import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GridDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"gridDiscoverableFeatures", "", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "getGridDiscoverableFeatures", "()Ljava/util/List;", "dms_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridDiscoverableFeatureKt {
    private static final List<IDiscoverableFeature> gridDiscoverableFeatures = CollectionsKt.listOf(GridDiscoverableFeature.AddNoteFeature.INSTANCE);

    public static final List<IDiscoverableFeature> getGridDiscoverableFeatures() {
        return gridDiscoverableFeatures;
    }
}
