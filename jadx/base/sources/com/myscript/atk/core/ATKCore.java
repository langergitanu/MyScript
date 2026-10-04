package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class ATKCore implements ATKCoreConstants {
    ATKCore() {
    }

    public static long new_SWIGVectorInkStyle() {
        return ATKCoreJNI.new_SWIGVectorInkStyle();
    }

    public static long new_SWIGVectorGlyph() {
        return ATKCoreJNI.new_SWIGVectorGlyph();
    }

    public static long new_SWIGVectorGlyphLines() {
        return ATKCoreJNI.new_SWIGVectorGlyphLines();
    }

    public static long new_SWIGVectorParallelogram() {
        return ATKCoreJNI.new_SWIGVectorParallelogram();
    }

    public static boolean FileLogLevelAtLeast(FileLogLevel fileLogLevel, FileLogLevel fileLogLevel2) {
        return ATKCoreJNI.FileLogLevelAtLeast(fileLogLevel.swigValue(), fileLogLevel2.swigValue());
    }

    public static List<String> getDebugConsoleLevelLabels() {
        long jDebugConsoleLevelLabels_get = ATKCoreJNI.DebugConsoleLevelLabels_get();
        if (jDebugConsoleLevelLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jDebugConsoleLevelLabels_get, false);
    }

    public static List<String> getDebugConsoleCategoryLabels() {
        long jDebugConsoleCategoryLabels_get = ATKCoreJNI.DebugConsoleCategoryLabels_get();
        if (jDebugConsoleCategoryLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jDebugConsoleCategoryLabels_get, false);
    }

    public static C6025x4b45fbfb getDebugConsoleCategoryMasks() {
        long jDebugConsoleCategoryMasks_get = ATKCoreJNI.DebugConsoleCategoryMasks_get();
        if (jDebugConsoleCategoryMasks_get == 0) {
            return null;
        }
        return new C6025x4b45fbfb(jDebugConsoleCategoryMasks_get, false);
    }

    public static List<String> getDebugConsolePrefixLabels() {
        long jDebugConsolePrefixLabels_get = ATKCoreJNI.DebugConsolePrefixLabels_get();
        if (jDebugConsolePrefixLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jDebugConsolePrefixLabels_get, false);
    }

    public static C6026x70c8c04f getDebugConsolePrefixMasks() {
        long jDebugConsolePrefixMasks_get = ATKCoreJNI.DebugConsolePrefixMasks_get();
        if (jDebugConsolePrefixMasks_get == 0) {
            return null;
        }
        return new C6026x70c8c04f(jDebugConsolePrefixMasks_get, false);
    }

    public static void logEnable(int i) {
        ATKCoreJNI.logEnable__SWIG_0(i);
    }

    public static void logEnable() {
        ATKCoreJNI.logEnable__SWIG_1();
    }

    public static void logDisable() {
        ATKCoreJNI.logDisable();
    }

    public static List<String> getPointerTypeLabels() {
        long jPointerTypeLabels_get = ATKCoreJNI.PointerTypeLabels_get();
        if (jPointerTypeLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jPointerTypeLabels_get, false);
    }

    public static List<String> getButtonTypeLabels() {
        long jButtonTypeLabels_get = ATKCoreJNI.ButtonTypeLabels_get();
        if (jButtonTypeLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jButtonTypeLabels_get, false);
    }

    public static List<String> getPointerTypeSetLabels() {
        long jPointerTypeSetLabels_get = ATKCoreJNI.PointerTypeSetLabels_get();
        if (jPointerTypeSetLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jPointerTypeSetLabels_get, false);
    }

    public static C6027x9ff1978 getPointerTypeSetMasks() {
        long jPointerTypeSetMasks_get = ATKCoreJNI.PointerTypeSetMasks_get();
        if (jPointerTypeSetMasks_get == 0) {
            return null;
        }
        return new C6027x9ff1978(jPointerTypeSetMasks_get, false);
    }

    public static List<String> getButtonTypeSetLabels() {
        long jButtonTypeSetLabels_get = ATKCoreJNI.ButtonTypeSetLabels_get();
        if (jButtonTypeSetLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jButtonTypeSetLabels_get, false);
    }

    public static ButtonTypeSet convertButtonType(ButtonType buttonType) {
        return ButtonTypeSet.swigToEnum(ATKCoreJNI.convertButtonType(buttonType.swigValue()));
    }

    public static boolean hasButtonType(ButtonTypeSet buttonTypeSet, ButtonType buttonType) {
        return ATKCoreJNI.hasButtonType(buttonTypeSet.swigValue(), buttonType.swigValue());
    }

    public static List<String> getSelectionStateLabels() {
        long jSelectionStateLabels_get = ATKCoreJNI.SelectionStateLabels_get();
        if (jSelectionStateLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jSelectionStateLabels_get, false);
    }

    public static SWIGTYPE_p_std__vectorT_atk__core__SelectionState_t getDisplayingCursorStates() {
        long jDisplayingCursorStates_get = ATKCoreJNI.DisplayingCursorStates_get();
        if (jDisplayingCursorStates_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_atk__core__SelectionState_t(jDisplayingCursorStates_get, false);
    }

    public static SWIGTYPE_p_std__vectorT_atk__core__SelectionState_t getTransitionStates() {
        long jTransitionStates_get = ATKCoreJNI.TransitionStates_get();
        if (jTransitionStates_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_atk__core__SelectionState_t(jTransitionStates_get, false);
    }

    public static List<String> getSelectionEventLabels() {
        long jSelectionEventLabels_get = ATKCoreJNI.SelectionEventLabels_get();
        if (jSelectionEventLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jSelectionEventLabels_get, false);
    }

    public static List<String> getSelectionDataTypeLabels() {
        long jSelectionDataTypeLabels_get = ATKCoreJNI.SelectionDataTypeLabels_get();
        if (jSelectionDataTypeLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jSelectionDataTypeLabels_get, false);
    }

    public static Point mapped(Point point, Transform transform) {
        return new Point(ATKCoreJNI.mapped__SWIG_0(Point.getCPtr(point), point, Transform.getCPtr(transform), transform), true);
    }

    public static PointerInfo mapped(PointerInfo pointerInfo, Transform transform) {
        return new PointerInfo(ATKCoreJNI.mapped__SWIG_1(PointerInfo.getCPtr(pointerInfo), pointerInfo, Transform.getCPtr(transform), transform), true);
    }

    public static Line mapped(Line line, Transform transform) {
        return new Line(ATKCoreJNI.mapped__SWIG_2(Line.getCPtr(line), line, Transform.getCPtr(transform), transform), true);
    }

    public static Rectangle mapped(Rectangle rectangle, Transform transform) {
        return new Rectangle(ATKCoreJNI.mapped__SWIG_3(Rectangle.getCPtr(rectangle), rectangle, Transform.getCPtr(transform), transform), true);
    }

    public static Extent mapped(Extent extent, Transform transform) {
        return new Extent(ATKCoreJNI.mapped__SWIG_4(Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform), true);
    }

    public static Insets mapped(Insets insets, Transform transform) {
        return new Insets(ATKCoreJNI.mapped__SWIG_5(Insets.getCPtr(insets), insets, Transform.getCPtr(transform), transform), true);
    }

    public static Path mapped(Path path, Transform transform) {
        return new Path(ATKCoreJNI.mapped__SWIG_6(Path.getCPtr(path), path, Transform.getCPtr(transform), transform), true);
    }

    public static Extent getEXTENT_EMPTY() {
        long jEXTENT_EMPTY_get = ATKCoreJNI.EXTENT_EMPTY_get();
        if (jEXTENT_EMPTY_get == 0) {
            return null;
        }
        return new Extent(jEXTENT_EMPTY_get, false);
    }

    public static List<String> getBackgroundPatternLabels() {
        long jBackgroundPatternLabels_get = ATKCoreJNI.BackgroundPatternLabels_get();
        if (jBackgroundPatternLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jBackgroundPatternLabels_get, false);
    }

    public static BackgroundPattern patternFromString(String str) {
        return BackgroundPattern.swigToEnum(ATKCoreJNI.patternFromString(str.getBytes()));
    }

    public static float[] insetForPattern(BackgroundPattern backgroundPattern) {
        return ATKCoreJNI.insetForPattern(backgroundPattern.swigValue());
    }

    public static String patternToString(BackgroundPattern backgroundPattern) {
        return new String(ATKCoreJNI.patternToString(backgroundPattern.swigValue()), StandardCharsets.UTF_8);
    }

    public static void logSelection(Selection selection) {
        ATKCoreJNI.logSelection(Selection.getCPtr(selection), selection);
    }

    public static String getInvalidChildPageId() {
        return ATKCoreJNI.InvalidChildPageId_get();
    }

    public static String getEmptyPdfChildPage() {
        return ATKCoreJNI.EmptyPdfChildPage_get();
    }

    public static long getEmptyPdfChildPageSize() {
        return ATKCoreJNI.EmptyPdfChildPageSize_get();
    }

    public static float getVinculumFactor() {
        return ATKCoreJNI.VinculumFactor_get();
    }

    public static float getFontWeightThin() {
        return ATKCoreJNI.FontWeightThin_get();
    }

    public static float getFontWeightNormal() {
        return ATKCoreJNI.FontWeightNormal_get();
    }

    public static float getFontWeightBlack() {
        return ATKCoreJNI.FontWeightBlack_get();
    }

    public static float getEPSILON() {
        return ATKCoreJNI.EPSILON_get();
    }

    public static String getName(MimeType mimeType) {
        return new String(ATKCoreJNI.getName(mimeType.swigValue()), StandardCharsets.UTF_8);
    }

    public static MimeType getMimeTypeFromPath(String str) {
        return MimeType.swigToEnum(ATKCoreJNI.getMimeTypeFromPath(str.getBytes()));
    }

    public static MimeType getMimeTypeFromTypeName(String str) {
        return MimeType.swigToEnum(ATKCoreJNI.getMimeTypeFromTypeName(str.getBytes()));
    }

    public static String getTypeName(MimeType mimeType) {
        return new String(ATKCoreJNI.getTypeName(mimeType.swigValue()), StandardCharsets.UTF_8);
    }

    public static List<String> getTypeNames(MimeType mimeType) {
        return new SWIGVectorString(ATKCoreJNI.getTypeNames(mimeType.swigValue()), true);
    }

    public static String getFileExtensions(MimeType mimeType) {
        return new String(ATKCoreJNI.getFileExtensions(mimeType.swigValue()), StandardCharsets.UTF_8);
    }

    public static List<String> getFileExtensionList(MimeType mimeType) {
        return new SWIGVectorString(ATKCoreJNI.getFileExtensionList(mimeType.swigValue()), true);
    }

    public static String getFileExtension(MimeType mimeType) {
        return new String(ATKCoreJNI.getFileExtension(mimeType.swigValue()), StandardCharsets.UTF_8);
    }

    public static boolean isTextual(MimeType mimeType) {
        return ATKCoreJNI.isTextual(mimeType.swigValue());
    }

    public static boolean isImage(MimeType mimeType) {
        return ATKCoreJNI.isImage(mimeType.swigValue());
    }

    public static String getTEXT_DOCUMENT() {
        return new String(ATKCoreJNI.TEXT_DOCUMENT_get(), StandardCharsets.UTF_8);
    }

    public static String getGEOMETRY() {
        return new String(ATKCoreJNI.GEOMETRY_get(), StandardCharsets.UTF_8);
    }

    public static String getDRAWING() {
        return new String(ATKCoreJNI.DRAWING_get(), StandardCharsets.UTF_8);
    }

    public static String getTEXT() {
        return new String(ATKCoreJNI.TEXT_get(), StandardCharsets.UTF_8);
    }

    public static String getMATH() {
        return new String(ATKCoreJNI.MATH_get(), StandardCharsets.UTF_8);
    }

    public static String getDIAGRAM() {
        return new String(ATKCoreJNI.DIAGRAM_get(), StandardCharsets.UTF_8);
    }

    public static String getRAW_CONTENT() {
        return new String(ATKCoreJNI.RAW_CONTENT_get(), StandardCharsets.UTF_8);
    }

    public static String getTABLE() {
        return new String(ATKCoreJNI.TABLE_get(), StandardCharsets.UTF_8);
    }

    public static String getPDF() {
        return new String(ATKCoreJNI.PDF_get(), StandardCharsets.UTF_8);
    }

    public static String getEXTERNAL() {
        return new String(ATKCoreJNI.EXTERNAL_get(), StandardCharsets.UTF_8);
    }

    public static String getCONTAINER() {
        return new String(ATKCoreJNI.CONTAINER_get(), StandardCharsets.UTF_8);
    }

    public static String getNODE() {
        return new String(ATKCoreJNI.NODE_get(), StandardCharsets.UTF_8);
    }

    public static String getEDGE() {
        return new String(ATKCoreJNI.EDGE_get(), StandardCharsets.UTF_8);
    }

    public static String getSHAPE() {
        return new String(ATKCoreJNI.SHAPE_get(), StandardCharsets.UTF_8);
    }

    public static String getIMAGE() {
        return new String(ATKCoreJNI.IMAGE_get(), StandardCharsets.UTF_8);
    }

    public static String getPLACEHOLDER() {
        return new String(ATKCoreJNI.PLACEHOLDER_get(), StandardCharsets.UTF_8);
    }

    public static String getGESTURE() {
        return new String(ATKCoreJNI.GESTURE_get(), StandardCharsets.UTF_8);
    }

    public static String getUNKNOWN() {
        return new String(ATKCoreJNI.UNKNOWN_get(), StandardCharsets.UTF_8);
    }

    public static String getNOTHING() {
        return new String(ATKCoreJNI.NOTHING_get(), StandardCharsets.UTF_8);
    }

    public static String getMIXED() {
        return new String(ATKCoreJNI.MIXED_get(), StandardCharsets.UTF_8);
    }

    public static String getANALYTICS() {
        return new String(ATKCoreJNI.ANALYTICS_get(), StandardCharsets.UTF_8);
    }

    public static String getBANNER() {
        return new String(ATKCoreJNI.BANNER_get(), StandardCharsets.UTF_8);
    }

    public static String getDBG() {
        return new String(ATKCoreJNI.DBG_get(), StandardCharsets.UTF_8);
    }

    public static String getTRACE() {
        return new String(ATKCoreJNI.TRACE_get(), StandardCharsets.UTF_8);
    }

    public static String getJOURNAL() {
        return new String(ATKCoreJNI.JOURNAL_get(), StandardCharsets.UTF_8);
    }

    public static String getSNAP() {
        return new String(ATKCoreJNI.SNAP_get(), StandardCharsets.UTF_8);
    }

    public static String getHOLD() {
        return new String(ATKCoreJNI.HOLD_get(), StandardCharsets.UTF_8);
    }

    public static String getLOCKED_GESTURE() {
        return new String(ATKCoreJNI.LOCKED_GESTURE_get(), StandardCharsets.UTF_8);
    }

    public static List<String> getMessageIdentifierLabels() {
        long jMessageIdentifierLabels_get = ATKCoreJNI.MessageIdentifierLabels_get();
        if (jMessageIdentifierLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jMessageIdentifierLabels_get, false);
    }

    public static List<String> getKeyboardModifierLabels() {
        long jKeyboardModifierLabels_get = ATKCoreJNI.KeyboardModifierLabels_get();
        if (jKeyboardModifierLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jKeyboardModifierLabels_get, false);
    }

    public static List<String> getKeyboardActionLabels() {
        long jKeyboardActionLabels_get = ATKCoreJNI.KeyboardActionLabels_get();
        if (jKeyboardActionLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jKeyboardActionLabels_get, false);
    }
}
