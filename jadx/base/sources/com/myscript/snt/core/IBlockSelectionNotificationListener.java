package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Renderer;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IBlockSelectionNotificationListener {
    List<Extent> configureBlockFullSelectionHandles(Extent extent);

    List<Extent> configureBlockSimpleSelectionHandles(Extent extent);

    void onBlockSelectableChanged(List<Extent> list);

    void onBlockSelectionChanged(List<Extent> list);

    void onBlockSelectionDragged(float f, float f2, float f3, float f4, float f5, float f6);

    void onBlockSelectionDraggedEnd();

    void onBlockSelectionDraggedStart(Renderer renderer, Extent extent, float f);

    void onBlockSelectionOverlap(List<Extent> list);

    void onBlockSelectionResized(Renderer renderer, List<Extent> list, List<Extent> list2);
}
