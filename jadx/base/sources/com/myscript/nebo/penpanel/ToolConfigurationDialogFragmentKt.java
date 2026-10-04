package com.myscript.nebo.penpanel;

import com.myscript.snt.core.ToolType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"thicknessPills", "", "Lcom/myscript/nebo/penpanel/ThicknessPill;", "Lcom/myscript/snt/core/ToolType;", "getThicknessPills", "(Lcom/myscript/snt/core/ToolType;)Ljava/util/List;", "penpanel_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolConfigurationDialogFragmentKt {

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ThicknessPill> getThicknessPills(ToolType toolType) {
        int i = WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return CollectionsKt.listOf((Object[]) new ThicknessPill[]{new ThicknessPill(C6693R.drawable.ic_tool_thickness1_24, 0.15f), new ThicknessPill(C6693R.drawable.ic_tool_thickness2_24, 0.25f), new ThicknessPill(C6693R.drawable.ic_tool_thickness3_24, 0.35f), new ThicknessPill(C6693R.drawable.ic_tool_thickness4_24, 0.5f), new ThicknessPill(C6693R.drawable.ic_tool_thickness5_24, 0.7f), new ThicknessPill(C6693R.drawable.ic_tool_thickness6_24, 1.0f)});
        }
        return CollectionsKt.emptyList();
    }
}
