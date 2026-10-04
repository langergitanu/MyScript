package com.myscript.nebo.common.utils;

import androidx.core.view.ViewCompat;
import com.myscript.android.utils.ColorExt;
import com.myscript.atk.core.BackgroundPattern;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PageBackgroundUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0003\u001a\f\u0010\u000b\u001a\u00020\u0002*\u00020\u0002H\u0003\u001a\u001a\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0004¨\u0006\u0010"}, m1599d2 = {"LIGHT_BACKGROUND_COLORS", "", "", "getLIGHT_BACKGROUND_COLORS", "()Ljava/util/List;", "DARK_BACKGROUND_COLORS", "getDARK_BACKGROUND_COLORS", "BACKGROUND_PATTERNS", "Lcom/myscript/atk/core/BackgroundPattern;", "getBACKGROUND_PATTERNS", "toLightColor", "toDarkColor", "resolveBackgroundColor", "color", "isDarkMode", "", "common_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageBackgroundUtilsKt {
    private static final List<Integer> LIGHT_BACKGROUND_COLORS = ColorExt.asOpaqueColors(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK), 15395819, 14014168, 15788512, 16184523, 16638690, 14807546, 14285021, 16776580, 16497136, 11857151, 11206579}));
    private static final List<Integer> DARK_BACKGROUND_COLORS = ColorExt.asOpaqueColors(CollectionsKt.listOf((Object[]) new Integer[]{0, 2631978, 3618873, 2828066, 3158049, 4073512, 2502710, 2372390, 5787657, 3934556, 596556, 17932}));
    private static final List<BackgroundPattern> BACKGROUND_PATTERNS = CollectionsKt.listOf((Object[]) new BackgroundPattern[]{BackgroundPattern.NONE, BackgroundPattern.DOTS, BackgroundPattern.LINES, BackgroundPattern.GRID});

    public static final List<Integer> getLIGHT_BACKGROUND_COLORS() {
        return LIGHT_BACKGROUND_COLORS;
    }

    public static final List<Integer> getDARK_BACKGROUND_COLORS() {
        return DARK_BACKGROUND_COLORS;
    }

    public static final List<BackgroundPattern> getBACKGROUND_PATTERNS() {
        return BACKGROUND_PATTERNS;
    }

    private static final int toLightColor(int i) {
        List<Integer> list = LIGHT_BACKGROUND_COLORS;
        return list.contains(Integer.valueOf(i)) ? i : list.get(RangesKt.coerceIn(DARK_BACKGROUND_COLORS.indexOf(Integer.valueOf(i)), (ClosedRange<Integer>) CollectionsKt.getIndices(list))).intValue();
    }

    private static final int toDarkColor(int i) {
        List<Integer> list = DARK_BACKGROUND_COLORS;
        return list.contains(Integer.valueOf(i)) ? i : list.get(RangesKt.coerceIn(LIGHT_BACKGROUND_COLORS.indexOf(Integer.valueOf(i)), (ClosedRange<Integer>) CollectionsKt.getIndices(list))).intValue();
    }

    public static final int resolveBackgroundColor(int i, boolean z) {
        return z ? toDarkColor(i) : toLightColor(i);
    }
}
