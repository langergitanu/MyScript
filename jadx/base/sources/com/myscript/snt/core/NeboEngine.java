package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class NeboEngine {
    public static void setNativeCrashHandlerClass(Object obj) {
        NeboEngineJNI.setNativeCrashHandlerClass(obj);
    }

    protected static byte[] getBytesUTF8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Exception unused) {
            throw new RuntimeException("UTF8 Not supported");
        }
    }

    public static String getRAW_CONTENT_PROPERTIES_PREFIX() {
        return NeboEngineJNI.RAW_CONTENT_PROPERTIES_PREFIX_get();
    }

    public static String getDIAGRAM_PROPERTY_PAGE_SIZE_DEFAULT() {
        return NeboEngineJNI.DIAGRAM_PROPERTY_PAGE_SIZE_DEFAULT_get();
    }

    public static String getDIAGRAM_PROPERTY_PAGE_SIZE_INSET_DEFAULT() {
        return NeboEngineJNI.DIAGRAM_PROPERTY_PAGE_SIZE_INSET_DEFAULT_get();
    }

    public static String getDIAGRAM_PROPERTY_PAGE_SIZE_FIT_SCREEN_DEFAULT() {
        return NeboEngineJNI.DIAGRAM_PROPERTY_PAGE_SIZE_FIT_SCREEN_DEFAULT_get();
    }

    public static String getSN2_TEXT_CONFIGURATION_NAME() {
        return new String(NeboEngineJNI.SN2_TEXT_CONFIGURATION_NAME_get(), StandardCharsets.UTF_8);
    }

    public static long getCOLOR_NONE() {
        return NeboEngineJNI.COLOR_NONE_get();
    }

    public static float getDEFAULT_THICKNESS_RATIO() {
        return NeboEngineJNI.DEFAULT_THICKNESS_RATIO_get();
    }

    public static float getDEFAULT_PRESSURE_SENSITIVITY() {
        return NeboEngineJNI.DEFAULT_PRESSURE_SENSITIVITY_get();
    }

    public static String getTOOL_PROPERTY_COLOR() {
        return NeboEngineJNI.TOOL_PROPERTY_COLOR_get();
    }

    public static String getTOOL_PROPERTY_THICKNESS_RATIO() {
        return NeboEngineJNI.TOOL_PROPERTY_THICKNESS_RATIO_get();
    }

    public static String getTOOL_PROPERTY_PRESSURE_SENSITIVITY() {
        return NeboEngineJNI.TOOL_PROPERTY_PRESSURE_SENSITIVITY_get();
    }

    public static String getTOOL_PROPERTY_ERASER_SHOW() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_SHOW_get();
    }

    public static String getTOOL_PROPERTY_ERASER_SHOW_TRUE() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_SHOW_TRUE_get();
    }

    public static String getTOOL_PROPERTY_ERASER_SHOW_FALSE() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_SHOW_FALSE_get();
    }

    public static String getTOOL_PROPERTY_ERASER_SHOW_DEFAULT() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_SHOW_DEFAULT_get();
    }

    public static String getTOOL_PROPERTY_ERASER_RADIUS() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_RADIUS_get();
    }

    public static String getTOOL_PROPERTY_ERASER_POLICY() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_POLICY_get();
    }

    public static String getTOOL_PROPERTY_ERASER_POLICY_STROKE() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_POLICY_STROKE_get();
    }

    public static String getTOOL_PROPERTY_ERASER_POLICY_PRECISE() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_POLICY_PRECISE_get();
    }

    public static String getTOOL_PROPERTY_ERASER_POLICY_DEFAULT() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_POLICY_DEFAULT_get();
    }

    public static String getTOOL_PROPERTY_ERASER_DYNAMIC_RADIUS() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_get();
    }

    public static String getTOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_TRUE() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_TRUE_get();
    }

    public static String getTOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_FALSE() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_FALSE_get();
    }

    public static String getTOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_DEFAULT() {
        return NeboEngineJNI.TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_DEFAULT_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_POLICY() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_POLICY_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_POLICY_DRAWINGS() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_POLICY_DRAWINGS_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_POLICY_SEMANTIC() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_POLICY_SEMANTIC_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_CLEAR() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_CLEAR_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_CLEAR_TRUE() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_CLEAR_TRUE_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_CLEAR_FALSE() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_CLEAR_FALSE_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_CLEAR_DEFAULT() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_CLEAR_DEFAULT_get();
    }

    public static String getTOOL_PROPERTY_BRUSH_FEEDBACK_COLOR() {
        return NeboEngineJNI.TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR_get();
    }

    public static String getTOOL_PROPERTY_LASSO_SHAPE() {
        return NeboEngineJNI.TOOL_PROPERTY_LASSO_SHAPE_get();
    }

    public static String getTOOL_PROPERTY_LASSO_SHAPE_POLYGON() {
        return NeboEngineJNI.TOOL_PROPERTY_LASSO_SHAPE_POLYGON_get();
    }

    public static String getTOOL_PROPERTY_LASSO_SHAPE_RECTANGLE() {
        return NeboEngineJNI.TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE_get();
    }

    public static String getTOOL_PROPERTY_LASSO_SHAPE_DEFAULT() {
        return NeboEngineJNI.TOOL_PROPERTY_LASSO_SHAPE_DEFAULT_get();
    }

    public static String getTOOL_PROPERTY_PEN_STROKER() {
        return NeboEngineJNI.TOOL_PROPERTY_PEN_STROKER_get();
    }

    public static String getTOOL_PROPERTY_PEN_STROKER_FELT() {
        return NeboEngineJNI.TOOL_PROPERTY_PEN_STROKER_FELT_get();
    }

    public static String getTOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN() {
        return NeboEngineJNI.TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN_get();
    }

    public static String getTOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC_BRUSH() {
        return NeboEngineJNI.TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC_BRUSH_get();
    }

    public static String getTOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC_QUILL() {
        return NeboEngineJNI.TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC_QUILL_get();
    }

    public static String getTOOL_PROPERTY_PEN_STROKER_QALAM() {
        return NeboEngineJNI.TOOL_PROPERTY_PEN_STROKER_QALAM_get();
    }

    public static String getTOOL_PROPERTY_PEN_STROKER_DEFAULT() {
        return NeboEngineJNI.TOOL_PROPERTY_PEN_STROKER_DEFAULT_get();
    }

    public static String ToolType_to_string(ToolType toolType) {
        return new String(NeboEngineJNI.ToolType_to_string(toolType.swigValue()), StandardCharsets.UTF_8);
    }

    public static ReflowOptions getDefaultReflowOptions() {
        long jDefaultReflowOptions_get = NeboEngineJNI.DefaultReflowOptions_get();
        if (jDefaultReflowOptions_get == 0) {
            return null;
        }
        return new ReflowOptions(jDefaultReflowOptions_get, false);
    }

    public static ReflowOptions getNoStackingtReflowOptions() {
        long jNoStackingtReflowOptions_get = NeboEngineJNI.NoStackingtReflowOptions_get();
        if (jNoStackingtReflowOptions_get == 0) {
            return null;
        }
        return new ReflowOptions(jNoStackingtReflowOptions_get, false);
    }

    public static DisplayContext getNoDisplayContext() {
        long jNoDisplayContext_get = NeboEngineJNI.NoDisplayContext_get();
        if (jNoDisplayContext_get == 0) {
            return null;
        }
        return new DisplayContext(jNoDisplayContext_get, false);
    }

    public static RecoContext getNoRecoContext() {
        long jNoRecoContext_get = NeboEngineJNI.NoRecoContext_get();
        if (jNoRecoContext_get == 0) {
            return null;
        }
        return new RecoContext(jNoRecoContext_get, false);
    }

    public static String getPAGECONTROLLER_PROPERTY_TRUE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_TRUE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_FALSE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_FALSE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_REFLOW_STACKING_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_REFLOW_STACKING_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_REFLOW_STACKING_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_REFLOW_STACKING_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_PDF_SQUASH() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_PDF_SQUASH_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_PDF_SQUASH_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_PDF_SQUASH_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_SLICE_GESTURE_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_SLICE_GESTURE_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_SLICE_GESTURE_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_SLICE_GESTURE_ENABLE_DEFAULT_get();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_KEYBOARD_SHOW_ON_TAP_INTERACTIONS_ENABLE */
    public static String m1074xd1dc629b() {
        return NeboEngineJNI.m1087xc180175c();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_KEYBOARD_SHOW_ON_TAP_INTERACTIONS_ENABLE_DEFAULT */
    public static String m1075x4138a07d() {
        return NeboEngineJNI.m1086x9e6d4a3e();
    }

    public static String getPAGECONTROLLER_PROPERTY_ANIMATIONS_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ANIMATIONS_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_ANIMATIONS_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ANIMATIONS_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_ACTIVEPEN_FORCE_DISABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ACTIVEPEN_FORCE_DISABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_ACTIVEPEN_FORCE_DISABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ACTIVEPEN_FORCE_DISABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_ACTIVEPEN_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ACTIVEPEN_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_ACTIVEPEN_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ACTIVEPEN_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_STYLUS_BUTTON_ERASER_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_STYLUS_BUTTON_ERASER_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_STYLUS_BUTTON_ERASER_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_STYLUS_BUTTON_ERASER_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_STYLUS_BUTTON_SELECTOR_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_STYLUS_BUTTON_SELECTOR_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_STYLUS_BUTTON_SELECTOR_ENABLE_DEFAULT() {
        return NeboEngineJNI.m1089x5b34dc46();
    }

    public static String getPAGECONTROLLER_PROPERTY_MATH_BONUS_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_MATH_BONUS_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_MATH_BONUS_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_MATH_BONUS_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_SHAPE_BONUS_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_SHAPE_BONUS_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_SHAPE_BONUS_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_SHAPE_BONUS_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_FREEFORM_PDF_ALIGNMENT_GUIDES_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_FREEFORM_PDF_ALIGNMENT_GUIDES_ENABLE_get();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_FREEFORM_PDF_ALIGNMENT_GUIDES_ENABLE_DEFAULT */
    public static String m1071xe82673e1() {
        return NeboEngineJNI.m1083x5b3a30a2();
    }

    public static String getPAGECONTROLLER_PROPERTY_DIAGRAM_TYPEFEEDBACK_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_DIAGRAM_TYPEFEEDBACK_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_DIAGRAM_TYPEFEEDBACK_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_DIAGRAM_TYPEFEEDBACK_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_ATTR_NEED_COMPUTEGRID() {
        return NeboEngineJNI.PAGECONTROLLER_ATTR_NEED_COMPUTEGRID_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_GESTURE_STRIKE_THROUGH_BEHAVIOR() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_GESTURE_STRIKE_THROUGH_BEHAVIOR_get();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_GESTURE_STRIKE_THROUGH_BEHAVIOR_DEFAULT */
    public static String m1073xad59f039() {
        return NeboEngineJNI.m1085x98e71166();
    }

    public static String getPAGECONTROLLER_PROPERTY_GESTURE_UNDERLINES_BEHAVIOR() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_GESTURE_UNDERLINES_BEHAVIOR_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_GESTURE_UNDERLINES_BEHAVIOR_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_GESTURE_UNDERLINES_BEHAVIOR_DEFAULT_get();
    }

    public static String getPROPERTY_PREFIX_RAW_CONTENT() {
        return NeboEngineJNI.PROPERTY_PREFIX_RAW_CONTENT_get();
    }

    public static String getPROPERTY_PREFIX_PDF() {
        return NeboEngineJNI.PROPERTY_PREFIX_PDF_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_TITLE_GESTURE_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_TITLE_GESTURE_ENABLE_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_TITLE_GESTURE_ENABLE_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_TITLE_GESTURE_ENABLE_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_LONG_PAGE_SOFT_LIMIT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_LONG_PAGE_SOFT_LIMIT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_LONG_PAGE_HARD_LIMIT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_LONG_PAGE_HARD_LIMIT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_ZOOM_FULL_PAGE_PDF() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ZOOM_FULL_PAGE_PDF_get();
    }

    public static float getPAGECONTROLLER_PROPERTY_ZOOM_FULL_PAGE_PDF_DEFAULT() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_ZOOM_FULL_PAGE_PDF_DEFAULT_get();
    }

    public static String getPAGECONTROLLER_PROPERTY_FREEFORM_SELECTION_CHANGED_LISTENER() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_FREEFORM_SELECTION_CHANGED_LISTENER_get();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_FREEFORM_SELECTION_CHANGED_LISTENER_DEFAULT */
    public static String m1072x45295697() {
        return NeboEngineJNI.m1084x180a9dc4();
    }

    public static String getPAGECONTROLLER_PROPERTY_RESTORE_SCROLL_POSITION_ENABLE() {
        return NeboEngineJNI.PAGECONTROLLER_PROPERTY_RESTORE_SCROLL_POSITION_ENABLE_get();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_RESTORE_SCROLL_POSITION_ENABLE_DEFAULT */
    public static String m1076x3a3d5766() {
        return NeboEngineJNI.m1088x40a29127();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_FEATUREFLAG_FIT_TO_WIDTH_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE */
    public static String m1067x34be65ea() {
        return NeboEngineJNI.m1080xf61329ab();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_FEATUREFLAG_FIT_TO_WIDTH_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE_DEFAULT */
    public static String m1068x3085e4cc() {
        return NeboEngineJNI.m1079x20ec9d8d();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_CENTER_AT_BOTTOM_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE */
    public static String m1069x5263eebc() {
        return NeboEngineJNI.m1082x59632a69();
    }

    /* JADX INFO: renamed from: getPAGECONTROLLER_PROPERTY_CENTER_AT_BOTTOM_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE_DEFAULT */
    public static String m1070xd4467b9e() {
        return NeboEngineJNI.m1081x3f07004b();
    }

    public static String getBALLOT_BOX() {
        return NeboEngineJNI.BALLOT_BOX_get();
    }

    public static String getBALLOT_BOX_CHECK() {
        return NeboEngineJNI.BALLOT_BOX_CHECK_get();
    }

    public static String getBALLOT_BOX_X() {
        return NeboEngineJNI.BALLOT_BOX_X_get();
    }
}
