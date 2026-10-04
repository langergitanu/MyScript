package com.myscript.nebo.dms.core;

import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.snt.dms.DMSFilter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: CollectionsManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/CollectionsManager;", "", "getCollectionModels", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "filter", "Lcom/myscript/snt/dms/DMSFilter;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CollectionsManager {
    List<CollectionModel> getCollectionModels(DMSFilter filter);

    /* JADX INFO: compiled from: CollectionsManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ List getCollectionModels$default(CollectionsManager collectionsManager, DMSFilter dMSFilter, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollectionModels");
        }
        if ((i & 1) != 0) {
            dMSFilter = DMSFilter.ACTIVE;
        }
        return collectionsManager.getCollectionModels(dMSFilter);
    }
}
