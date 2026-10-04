package com.myscript.nebo.editing.impl.p027ui;

import android.R;
import android.content.Context;
import android.util.TypedValue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.nebo.editing.C6421R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomRenderedItemsConfiguration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/CustomRenderedItemsConfiguration;", "", "searchHitColor", "", "searchSelectedHitColor", "searchHitPaddingPx", "pageBoundsBorderColor", "pageBoundsBorderWidthPx", "<init>", "(IIIII)V", "getSearchHitColor", "()I", "getSearchSelectedHitColor", "getSearchHitPaddingPx", "getPageBoundsBorderColor", "getPageBoundsBorderWidthPx", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class CustomRenderedItemsConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int pageBoundsBorderColor;
    private final int pageBoundsBorderWidthPx;
    private final int searchHitColor;
    private final int searchHitPaddingPx;
    private final int searchSelectedHitColor;

    public CustomRenderedItemsConfiguration(int i, int i2, int i3) {
        this(i, i2, 0, i3, 0, 20, null);
    }

    public CustomRenderedItemsConfiguration(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, 16, null);
    }

    public static /* synthetic */ CustomRenderedItemsConfiguration copy$default(CustomRenderedItemsConfiguration customRenderedItemsConfiguration, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = customRenderedItemsConfiguration.searchHitColor;
        }
        if ((i6 & 2) != 0) {
            i2 = customRenderedItemsConfiguration.searchSelectedHitColor;
        }
        if ((i6 & 4) != 0) {
            i3 = customRenderedItemsConfiguration.searchHitPaddingPx;
        }
        if ((i6 & 8) != 0) {
            i4 = customRenderedItemsConfiguration.pageBoundsBorderColor;
        }
        if ((i6 & 16) != 0) {
            i5 = customRenderedItemsConfiguration.pageBoundsBorderWidthPx;
        }
        int i7 = i5;
        int i8 = i3;
        return customRenderedItemsConfiguration.copy(i, i2, i8, i4, i7);
    }

    @JvmStatic
    public static final CustomRenderedItemsConfiguration from(Context context) {
        return INSTANCE.from(context);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSearchHitColor() {
        return this.searchHitColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSearchSelectedHitColor() {
        return this.searchSelectedHitColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSearchHitPaddingPx() {
        return this.searchHitPaddingPx;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPageBoundsBorderColor() {
        return this.pageBoundsBorderColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPageBoundsBorderWidthPx() {
        return this.pageBoundsBorderWidthPx;
    }

    public final CustomRenderedItemsConfiguration copy(int searchHitColor, int searchSelectedHitColor, int searchHitPaddingPx, int pageBoundsBorderColor, int pageBoundsBorderWidthPx) {
        return new CustomRenderedItemsConfiguration(searchHitColor, searchSelectedHitColor, searchHitPaddingPx, pageBoundsBorderColor, pageBoundsBorderWidthPx);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomRenderedItemsConfiguration)) {
            return false;
        }
        CustomRenderedItemsConfiguration customRenderedItemsConfiguration = (CustomRenderedItemsConfiguration) other;
        return this.searchHitColor == customRenderedItemsConfiguration.searchHitColor && this.searchSelectedHitColor == customRenderedItemsConfiguration.searchSelectedHitColor && this.searchHitPaddingPx == customRenderedItemsConfiguration.searchHitPaddingPx && this.pageBoundsBorderColor == customRenderedItemsConfiguration.pageBoundsBorderColor && this.pageBoundsBorderWidthPx == customRenderedItemsConfiguration.pageBoundsBorderWidthPx;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.searchHitColor) * 31) + Integer.hashCode(this.searchSelectedHitColor)) * 31) + Integer.hashCode(this.searchHitPaddingPx)) * 31) + Integer.hashCode(this.pageBoundsBorderColor)) * 31) + Integer.hashCode(this.pageBoundsBorderWidthPx);
    }

    public String toString() {
        return "CustomRenderedItemsConfiguration(searchHitColor=" + this.searchHitColor + ", searchSelectedHitColor=" + this.searchSelectedHitColor + ", searchHitPaddingPx=" + this.searchHitPaddingPx + ", pageBoundsBorderColor=" + this.pageBoundsBorderColor + ", pageBoundsBorderWidthPx=" + this.pageBoundsBorderWidthPx + ")";
    }

    public CustomRenderedItemsConfiguration(int i, int i2, int i3, int i4, int i5) {
        this.searchHitColor = i;
        this.searchSelectedHitColor = i2;
        this.searchHitPaddingPx = i3;
        this.pageBoundsBorderColor = i4;
        this.pageBoundsBorderWidthPx = i5;
    }

    public /* synthetic */ CustomRenderedItemsConfiguration(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i6 & 4) != 0 ? 10 : i3, i4, (i6 & 16) != 0 ? 1 : i5);
    }

    public final int getSearchHitColor() {
        return this.searchHitColor;
    }

    public final int getSearchSelectedHitColor() {
        return this.searchSelectedHitColor;
    }

    public final int getSearchHitPaddingPx() {
        return this.searchHitPaddingPx;
    }

    public final int getPageBoundsBorderColor() {
        return this.pageBoundsBorderColor;
    }

    public final int getPageBoundsBorderWidthPx() {
        return this.pageBoundsBorderWidthPx;
    }

    /* JADX INFO: compiled from: CustomRenderedItemsConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/CustomRenderedItemsConfiguration$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/myscript/nebo/editing/impl/ui/CustomRenderedItemsConfiguration;", "uiContext", "Landroid/content/Context;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CustomRenderedItemsConfiguration from(Context uiContext) {
            Intrinsics.checkNotNullParameter(uiContext, "uiContext");
            TypedValue typedValue = new TypedValue();
            uiContext.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            int i = typedValue.data;
            return new CustomRenderedItemsConfiguration(ColorUtils.setAlphaComponent(i, uiContext.getResources().getInteger(C6421R.integer.search_hit_alpha)), ColorUtils.setAlphaComponent(i, uiContext.getResources().getInteger(C6421R.integer.search_selected_hit_alpha)), 0, DarkModeUtils.isDarkMode(uiContext) ? 704643071 : 1358954496, 0, 20, null);
        }
    }
}
