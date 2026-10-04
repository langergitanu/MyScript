package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.PendingStroke;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IReflowSessionListener {
    void reflowInkRejected(int i, List<PendingStroke> list);

    void reflowInsertRejected(Extent extent);

    void reflowTypesetRejected(List<String> list);

    void reflowUpdated(Extent extent);
}
