package com.myscript.nebo.penpanel;

import com.myscript.atk.core.IColorInversionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ToolbarViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002*(\b\u0002\u0010\u0007\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b2\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b¨\u0006\u000b"}, m1599d2 = {"toColorPills", "", "Lcom/myscript/nebo/penpanel/ColorPill;", "", "selectedIndex", "colorPolicy", "Lcom/myscript/atk/core/IColorInversionPolicy;", "ToolbarConfigurationDelegate", "Lkotlin/Function1;", "Lcom/myscript/snt/core/ToolbarConfiguration;", "", "penpanel_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolbarViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ColorPill> toColorPills(List<Integer> list, int i, IColorInversionPolicy iColorInversionPolicy) {
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i2 = 0;
        for (Object obj : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int iIntValue = ((Number) obj).intValue();
            arrayList.add(new ColorPill(i2, iIntValue, iColorInversionPolicy != null ? iColorInversionPolicy.invertColor2(iIntValue) : iIntValue, i2 == i));
            i2 = i3;
        }
        return arrayList;
    }
}
