package com.myscript.nebo.editing;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.PendingStroke;
import com.myscript.atk.core.SWIGVectorPendingStroke;
import com.myscript.snt.core.IReflowSessionListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflowListenerAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/editing/ReflowListenerAdapter;", "Lcom/myscript/snt/core/IReflowSessionListener;", "<init>", "()V", "reflowUpdated", "", "docExtent", "Lcom/myscript/atk/core/Extent;", "reflowInkRejected", "causes", "", "strokes", "", "Lcom/myscript/atk/core/PendingStroke;", "reflowTypesetRejected", "boxesId", "", "reflowInsertRejected", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ReflowListenerAdapter implements IReflowSessionListener {
    public static final int $stable = 0;

    @Override // com.myscript.snt.core.IReflowSessionListener
    public void reflowTypesetRejected(List<String> boxesId) {
        Intrinsics.checkNotNullParameter(boxesId, "boxesId");
    }

    @Override // com.myscript.snt.core.IReflowSessionListener
    public void reflowUpdated(Extent docExtent) {
        if (docExtent != null) {
            docExtent.delete();
        }
    }

    @Override // com.myscript.snt.core.IReflowSessionListener
    public void reflowInkRejected(int causes, List<PendingStroke> strokes) {
        Intrinsics.checkNotNullParameter(strokes, "strokes");
        if (strokes instanceof SWIGVectorPendingStroke) {
            ((SWIGVectorPendingStroke) strokes).delete();
        }
    }

    @Override // com.myscript.snt.core.IReflowSessionListener
    public void reflowInsertRejected(Extent docExtent) {
        if (docExtent != null) {
            docExtent.delete();
        }
    }
}
