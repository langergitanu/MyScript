package com.myscript.nebo.penpanel;

import com.myscript.snt.core.ToolType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PenFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"isConfigurableTool", "", "Lcom/myscript/snt/core/ToolType;", "(Lcom/myscript/snt/core/ToolType;)Z", "penpanel_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PenFragmentKt {

    /* JADX INFO: compiled from: PenFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolType.values().length];
            try {
                iArr[ToolType.Highlighter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolType.Pen.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolType.Eraser.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ToolType.Lasso.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isConfigurableTool(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }
}
