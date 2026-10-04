package com.myscript.nebo.editing.discoverability;

import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"editingDiscoverableFeatures", "", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "getEditingDiscoverableFeatures", "()Ljava/util/List;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EditingDiscoverableFeatureKt {
    private static final List<IDiscoverableFeature> editingDiscoverableFeatures = CollectionsKt.listOf((Object[]) new IDiscoverableFeature[]{EditingDiscoverableFeature.NotebookFeature.INSTANCE, EditingDiscoverableFeature.BoardFeature.INSTANCE, EditingDiscoverableFeature.DocumentFeature.INSTANCE, EditingDiscoverableFeature.PdfFeature.INSTANCE, EditingDiscoverableFeature.ConvertTextFeature.INSTANCE, EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE, EditingDiscoverableFeature.AIExplainFeature.INSTANCE, EditingDiscoverableFeature.PdfAddPageFeature.INSTANCE, EditingDiscoverableFeature.PdfOptimizationFeature.INSTANCE, EditingDiscoverableFeature.PenOptionsFeature.INSTANCE, EditingDiscoverableFeature.ScratchOutGestureFeature.INSTANCE, EditingDiscoverableFeature.ShapesFeature.INSTANCE});

    public static final List<IDiscoverableFeature> getEditingDiscoverableFeatures() {
        return editingDiscoverableFeatures;
    }
}
