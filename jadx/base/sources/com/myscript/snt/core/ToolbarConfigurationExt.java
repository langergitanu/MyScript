package com.myscript.snt.core;

import android.os.Bundle;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.ViewTransform;
import com.myscript.snt.core.LayoutGrid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolbarConfigurationExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0003\u001a \u0010\t\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0002\u001a\n\u0010#\u001a\u00020$*\u00020\n\u001a\u0016\u0010%\u001a\u00020\n*\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0019\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011*\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"isWritingTool", "", "Lcom/myscript/snt/core/ToolType;", "(Lcom/myscript/snt/core/ToolType;)Z", "inkThicknessMM", "", "width", "styleProperties", "Lcom/myscript/snt/core/LayoutGrid$StyleProperties;", "getInkThicknessForScreen", "Lcom/myscript/snt/core/ToolConfiguration;", "viewTransform", "Lcom/myscript/atk/core/ViewTransform;", "findToolByType", "Lcom/myscript/snt/core/ToolbarConfiguration;", "toolType", "listOfTools", "", "getListOfTools", "(Lcom/myscript/snt/core/ToolbarConfiguration;)Ljava/util/List;", "stroker", "", "getStroker", "(Lcom/myscript/snt/core/ToolConfiguration;)I", ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_TYPE_KEY, "", ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_COLOR_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_THICKNESS_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_STATE_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_ERASER_POLICY_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_PEN_STROKER_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_LASSO_SHAPE_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_POLICY_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_CLEAR_KEY, ToolbarConfigurationExt.TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_FEEDBACK_COLOR_KEY, "asBundle", "Landroid/os/Bundle;", "asToolConfiguration", "contentType", "editing_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolbarConfigurationExt {
    private static final String TOOL_CONFIGURATION_BUNDLE_COLOR_KEY = "TOOL_CONFIGURATION_BUNDLE_COLOR_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_ERASER_POLICY_KEY = "TOOL_CONFIGURATION_BUNDLE_ERASER_POLICY_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_CLEAR_KEY = "TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_CLEAR_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_FEEDBACK_COLOR_KEY = "TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_FEEDBACK_COLOR_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_POLICY_KEY = "TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_POLICY_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_LASSO_SHAPE_KEY = "TOOL_CONFIGURATION_BUNDLE_LASSO_SHAPE_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_PEN_STROKER_KEY = "TOOL_CONFIGURATION_BUNDLE_PEN_STROKER_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_STATE_KEY = "TOOL_CONFIGURATION_BUNDLE_STATE_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_THICKNESS_KEY = "TOOL_CONFIGURATION_BUNDLE_THICKNESS_KEY";
    private static final String TOOL_CONFIGURATION_BUNDLE_TYPE_KEY = "TOOL_CONFIGURATION_BUNDLE_TYPE_KEY";

    /* JADX INFO: compiled from: ToolbarConfigurationExt.kt */
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

    @Deprecated(message = "Shouldn't need ViewTransform")
    public static final float getInkThicknessForScreen(ToolConfiguration toolConfiguration, ViewTransform viewTransform) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(viewTransform, "viewTransform");
        return getInkThicknessForScreen$default(toolConfiguration, viewTransform, null, 2, null);
    }

    public static final boolean isWritingTool(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()];
        return i == 1 || i == 2;
    }

    @Deprecated(message = "Shouldn't duplicate C++ code and approximate lineGap")
    private static final float inkThicknessMM(ToolType toolType, float f, LayoutGrid.StyleProperties styleProperties) {
        if (toolType == ToolType.Highlighter) {
            return (f < 0.2f ? 0.125f : f < 0.3f ? 0.25f : f < 0.42f ? 0.5f : f < 0.6f ? 0.75f : f < 0.85f ? 1.125f : 1.75f) * (styleProperties != null ? StyleUtils.getValue(StyleUtils.getTYPE_HANDWRITING(), StyleUtils.getPROPERTY_LINEGAP(), styleProperties) : 10.0f);
        }
        return (f < 0.2f ? 0.15f : f < 0.3f ? 0.35f : f < 0.42f ? 0.625f : f < 0.6f ? 0.9f : f < 0.85f ? 1.4f : 2.0f) * (styleProperties != null ? styleProperties.getRem() * 0.3f : 1.0f);
    }

    public static /* synthetic */ float getInkThicknessForScreen$default(ToolConfiguration toolConfiguration, ViewTransform viewTransform, LayoutGrid.StyleProperties styleProperties, int i, Object obj) {
        if ((i & 2) != 0) {
            styleProperties = null;
        }
        return getInkThicknessForScreen(toolConfiguration, viewTransform, styleProperties);
    }

    @Deprecated(message = "Shouldn't need ViewTransform")
    public static final float getInkThicknessForScreen(ToolConfiguration toolConfiguration, ViewTransform viewTransform, LayoutGrid.StyleProperties styleProperties) {
        float f;
        Intrinsics.checkNotNullParameter(toolConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(viewTransform, "viewTransform");
        int stroker = getStroker(toolConfiguration);
        if (stroker != 1) {
            f = 1.0f;
            if (stroker != 2) {
            }
        } else {
            f = 1.4f;
        }
        ToolType type = toolConfiguration.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        float fInkThicknessMM = f * inkThicknessMM(type, toolConfiguration.getThicknessRatio(), styleProperties);
        Point map = viewTransform.map(fInkThicknessMM, fInkThicknessMM);
        return ((map.getX() + map.getY()) / 2.0f) * viewTransform.zoomScale();
    }

    public static final ToolConfiguration findToolByType(ToolbarConfiguration toolbarConfiguration, ToolType toolType) {
        SWIGVectorToolConfiguration availableTools;
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        ToolConfiguration toolConfiguration = null;
        if (toolbarConfiguration == null || (availableTools = toolbarConfiguration.getAvailableTools()) == null) {
            return null;
        }
        Iterator<ToolConfiguration> it = availableTools.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ToolConfiguration next = it.next();
            if (next.getType() == toolType) {
                toolConfiguration = next;
                break;
            }
        }
        return toolConfiguration;
    }

    public static final List<ToolConfiguration> getListOfTools(ToolbarConfiguration toolbarConfiguration) {
        SWIGVectorToolConfiguration availableTools;
        ArrayList arrayList = new ArrayList();
        if (toolbarConfiguration != null && (availableTools = toolbarConfiguration.getAvailableTools()) != null) {
            for (ToolConfiguration toolConfiguration : availableTools) {
                Intrinsics.checkNotNull(toolConfiguration);
                arrayList.add(toolConfiguration);
            }
        }
        return arrayList;
    }

    public static final int getStroker(ToolConfiguration toolConfiguration) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "<this>");
        if (toolConfiguration.getType() == ToolType.Highlighter) {
            return 6;
        }
        if (toolConfiguration.getType() == ToolType.Pen && Intrinsics.areEqual(toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER), ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FELT)) {
            return 0;
        }
        if (toolConfiguration.getType() == ToolType.Pen && Intrinsics.areEqual(toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER), ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN)) {
            return 1;
        }
        if (toolConfiguration.getType() == ToolType.Pen && Intrinsics.areEqual(toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER), ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC)) {
            return 3;
        }
        return toolConfiguration.getType() == ToolType.Pen ? 0 : 11;
    }

    public static final Bundle asBundle(ToolConfiguration toolConfiguration) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString(TOOL_CONFIGURATION_BUNDLE_TYPE_KEY, toolConfiguration.getType().name());
        bundle.putInt(TOOL_CONFIGURATION_BUNDLE_COLOR_KEY, toolConfiguration.getColor2());
        bundle.putFloat(TOOL_CONFIGURATION_BUNDLE_THICKNESS_KEY, toolConfiguration.getThicknessRatio());
        bundle.putString(TOOL_CONFIGURATION_BUNDLE_STATE_KEY, toolConfiguration.getState().name());
        ToolType type = toolConfiguration.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            String property = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY);
            Intrinsics.checkNotNull(property);
            if (property.length() > 0) {
                bundle.putString(TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_POLICY_KEY, property);
            }
            bundle.putString(TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_CLEAR_KEY, toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR));
            bundle.putString(TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_FEEDBACK_COLOR_KEY, toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR));
            return bundle;
        }
        if (i == 2) {
            String property2 = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER);
            if (property2.length() == 0) {
                property2 = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_DEFAULT;
            }
            bundle.putString(TOOL_CONFIGURATION_BUNDLE_PEN_STROKER_KEY, property2);
            return bundle;
        }
        if (i == 3) {
            String property3 = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY);
            if (property3.length() == 0) {
                property3 = ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_DEFAULT;
            }
            bundle.putString(TOOL_CONFIGURATION_BUNDLE_ERASER_POLICY_KEY, property3);
            return bundle;
        }
        if (i != 4) {
            return bundle;
        }
        String property4 = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE);
        if (property4.length() == 0) {
            property4 = ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_DEFAULT;
        }
        bundle.putString(TOOL_CONFIGURATION_BUNDLE_LASSO_SHAPE_KEY, property4);
        return bundle;
    }

    public static /* synthetic */ ToolConfiguration asToolConfiguration$default(Bundle bundle, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return asToolConfiguration(bundle, str);
    }

    public static final ToolConfiguration asToolConfiguration(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        String string = bundle.getString(TOOL_CONFIGURATION_BUNDLE_TYPE_KEY);
        if (string == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ToolType toolTypeValueOf = ToolType.valueOf(string);
        ToolConfiguration toolConfiguration = new ToolConfiguration(toolTypeValueOf, bundle.getInt(TOOL_CONFIGURATION_BUNDLE_COLOR_KEY), bundle.getFloat(TOOL_CONFIGURATION_BUNDLE_THICKNESS_KEY));
        String string2 = bundle.getString(TOOL_CONFIGURATION_BUNDLE_STATE_KEY);
        toolConfiguration.setState(string2 != null ? ToolState.valueOf(string2) : ToolState.Unselected);
        int i = WhenMappings.$EnumSwitchMapping$0[toolTypeValueOf.ordinal()];
        if (i == 1) {
            String string3 = bundle.getString(TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_POLICY_KEY, Intrinsics.areEqual(str, ContentTypes.RAW_CONTENT) ? ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH : ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART);
            if (string3 != null && string3.length() > 0) {
                toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY, string3);
            }
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR, bundle.getString(TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_CLEAR_KEY, ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_FALSE));
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR, bundle.getString(TOOL_CONFIGURATION_BUNDLE_HIGHLIGHTER_BRUSH_FEEDBACK_COLOR_KEY));
            return toolConfiguration;
        }
        if (i == 2) {
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER, bundle.getString(TOOL_CONFIGURATION_BUNDLE_PEN_STROKER_KEY));
            return toolConfiguration;
        }
        if (i == 3) {
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY, bundle.getString(TOOL_CONFIGURATION_BUNDLE_ERASER_POLICY_KEY));
            return toolConfiguration;
        }
        if (i != 4) {
            return toolConfiguration;
        }
        toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE, bundle.getString(TOOL_CONFIGURATION_BUNDLE_LASSO_SHAPE_KEY));
        return toolConfiguration;
    }
}
