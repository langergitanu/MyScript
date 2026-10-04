package com.myscript.nebo.editing.impl.p027ui;

import com.myscript.snt.core.ToolType;
import kotlin.Metadata;

/* JADX INFO: compiled from: NestedScrollableSwipeFilter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/InteractionContext;", "", "activePenEnabled", "", "getActivePenEnabled", "()Z", "currentToolType", "Lcom/myscript/snt/core/ToolType;", "getCurrentToolType", "()Lcom/myscript/snt/core/ToolType;", "isCurrentToolInteracting", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface InteractionContext {
    boolean getActivePenEnabled();

    ToolType getCurrentToolType();

    boolean isCurrentToolInteracting();
}
