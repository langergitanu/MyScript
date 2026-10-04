package com.myscript.nebo.penpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.core.ToolbarConfigurationExt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: toolConfigurationUI.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, m1599d2 = {"toolDrawableRes", "", "toolType", "Lcom/myscript/snt/core/ToolType;", "stroker", "lassoShape", "", "asDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/myscript/snt/core/ToolConfiguration;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "penpanel_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolConfigurationUIKt {

    /* JADX INFO: compiled from: toolConfigurationUI.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolType.values().length];
            try {
                iArr[ToolType.Keyboard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolType.InteractionTool.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolType.Highlighter.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ToolType.Eraser.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ToolType.Lasso.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ToolType.Pen.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toolDrawableRes(ToolType toolType, int i, String lassoShape) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        Intrinsics.checkNotNullParameter(lassoShape, "lassoShape");
        switch (WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()]) {
            case 1:
                return C6693R.drawable.ic_keyboard;
            case 2:
                return C6693R.drawable.ic_hand;
            case 3:
                return C6693R.drawable.ic_highlighter;
            case 4:
                return C6693R.drawable.ic_eraser;
            case 5:
                return Intrinsics.areEqual(lassoShape, ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE) ? C6693R.drawable.ic_lasso_rectangle : C6693R.drawable.ic_lasso;
            case 6:
                if (i == 0) {
                    return C6693R.drawable.ic_felt_pen;
                }
                if (i == 1) {
                    return C6693R.drawable.ic_fountain_pen;
                }
                if (i == 3) {
                    return C6693R.drawable.ic_calligraphic_brush;
                }
                return C6693R.drawable.ic_color_pen;
            default:
                return 0;
        }
    }

    public static final Drawable asDrawable(ToolConfiguration toolConfiguration, Context context) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ToolType type = toolConfiguration.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        int stroker = ToolbarConfigurationExt.getStroker(toolConfiguration);
        String property = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE);
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        int i = toolDrawableRes(type, stroker, property);
        if (i != 0) {
            return ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme());
        }
        return null;
    }
}
