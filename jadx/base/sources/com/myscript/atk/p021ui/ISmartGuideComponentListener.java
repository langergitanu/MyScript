package com.myscript.atk.p021ui;

import com.myscript.atk.core.Extent;

/* JADX INFO: loaded from: classes4.dex */
public interface ISmartGuideComponentListener {
    void changeVisibility(boolean z, boolean z2);

    void clearPrompter();

    void clearSmartGuide();

    void clearSmartGuide(String str);

    void conversionPreviewSettingChanged(boolean z);

    void smartGuideBlockTypeUpdated(String str, Extent extent, SmartGuideBlockType smartGuideBlockType, boolean z, boolean z2);

    void smartGuideModelShapeUpdated(Extent extent, PrompterShapeSupport prompterShapeSupport, boolean z, boolean z2, boolean z3, boolean z4);

    void smartGuideTextUpdated(Extent extent, PrompterBox prompterBox, PrompterWord prompterWord, boolean z, boolean z2, boolean z3, boolean z4);
}
