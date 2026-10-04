package com.myscript.nebo.editing.controller.gesture;

import com.myscript.snt.core.ToolType;
import kotlin.Metadata;

/* JADX INFO: compiled from: TouchGestureDetector.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/controller/gesture/CurrentState;", "", "currentToolType", "Lcom/myscript/snt/core/ToolType;", "getCurrentToolType", "()Lcom/myscript/snt/core/ToolType;", "setCurrentToolType", "(Lcom/myscript/snt/core/ToolType;)V", "activePenMode", "", "getActivePenMode", "()Z", "setActivePenMode", "(Z)V", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CurrentState {
    boolean getActivePenMode();

    ToolType getCurrentToolType();

    void setActivePenMode(boolean z);

    void setCurrentToolType(ToolType toolType);
}
