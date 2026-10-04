package com.myscript.nebo.penpanel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.MimeTypes;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InkSettings.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b%\u0018\u0000 =2\u00020\u0001:\u0001=B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0017J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u001d\u001a\u00020\u0006J\u001a\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u001f\u001a\u00020\u0006H\u0007J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u001d\u001a\u00020\u0006H\u0007J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010$\u001a\u00020\u0006H\u0007J \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u001d\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0007J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010$\u001a\u00020\u0006H\u0007J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0007J\u0006\u0010*\u001a\u00020\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010+\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R$\u00103\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R$\u00107\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R$\u0010:\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010-\"\u0004\b<\u0010/¨\u0006>"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/InkSettings;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "defaultColors", "", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "gson", "Lcom/google/gson/Gson;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "value", "colors", "getColors", "()Ljava/util/List;", "getInkWidthPrefKey", "", "toolType", "Lcom/myscript/snt/core/ToolType;", "getSelectedThicknessRatio", "", "setSelectedThicknessRatio", "", "inkSizeValue", "getColorPrefKey", "setSelectedColor", "color", "getSelectedColor", "defaultColor", "setColors", "resetColors", "addColor", "duplicateColorAt", "position", "modifyColorAt", "removeColorAt", "moveColors", "fromPosition", "toPosition", "saveColors", "eraserPolicy", "getEraserPolicy", "()Ljava/lang/String;", "setEraserPolicy", "(Ljava/lang/String;)V", "penStroker", "getPenStroker", "setPenStroker", "highlighterPolicy", "getHighlighterPolicy", "setHighlighterPolicy", "clearMode", "highlighterClearMode", "getHighlighterClearMode", "setHighlighterClearMode", "lassoShape", "getLassoShape", "setLassoShape", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InkSettings {
    private static final String COLORS_KEY = "INK_SETTINGS_COLORS_KEY_JSON";
    private static final String COLORS_KEY_LEGACY = "INK_SETTINGS_COLORS_KEY";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INK_SETTINGS_PREFS = "com.myscript.nebo.InkSettingsPrefs";
    public static final int INK_SIZE_FACTOR = 2;
    private static final String LAST_USED_ERASER_POLICY_KEY = "LAST_USED_ERASER_POLICY_KEY";
    private static final String LAST_USED_ERASER_WIDTH_KEY = "LAST_USED_ERASER_WIDTH_KEY";
    private static final String LAST_USED_HIGHLIGHTER_CLEAR_MODE_KEY = "LAST_USED_HIGHLIGHTER_CLEAR_MODE_KEY";
    private static final String LAST_USED_HIGHLIGHTER_INK_WIDTH_KEY = "LAST_USED_HIGHLIGHTER_INK_WIDTH_KEY";
    private static final String LAST_USED_HIGHLIGHTER_POLICY_KEY = "LAST_USED_HIGHLIGHTER_POLICY_KEY";
    private static final String LAST_USED_LASSO_SHAPE_KEY = "LAST_USED_LASSO_SHAPE_KEY";
    private static final String LAST_USED_PEN_INK_WIDTH_KEY = "LAST_USED_PEN_INK_WIDTH_KEY";
    private static final String LAST_USED_PEN_STROKER_KEY = "LAST_USED_PEN_STROKER_KEY";
    private static final String LAST_USER_HIGHLIGHTER_COLOR_KEY = "LAST_USER_HIGHLIGHTER_COLOR_KEY";
    private static final String LAST_USER_PEN_COLOR_KEY = "LAST_USER_PEN_COLOR_KEY";
    private List<Integer> colors;
    private final Gson gson;
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: compiled from: InkSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolType.values().length];
            try {
                iArr[ToolType.Pen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolType.Eraser.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolType.Highlighter.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ InkSettings(Context context, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list);
    }

    private InkSettings(Context context, List<Integer> list) {
        ArrayList arrayListEmptyList;
        List listSplit$default;
        Gson gson = new Gson();
        this.gson = gson;
        SharedPreferences sharedPreferences = context.getSharedPreferences(INK_SETTINGS_PREFS, 0);
        this.sharedPreferences = sharedPreferences;
        String string = sharedPreferences.getString(COLORS_KEY, null);
        if (string == null) {
            String string2 = sharedPreferences.getString(COLORS_KEY_LEGACY, null);
            if (string2 == null || (listSplit$default = StringsKt.split$default((CharSequence) string2, new String[]{Literals.COMMENT_2}, false, 0, 6, (Object) null)) == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    Integer intOrNull = StringsKt.toIntOrNull((String) it.next());
                    if (intOrNull != null) {
                        arrayList.add(intOrNull);
                    }
                }
                arrayListEmptyList = arrayList;
            }
            if (!arrayListEmptyList.isEmpty()) {
                setColors(arrayListEmptyList);
            }
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "sharedPreferences");
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            editorEdit.remove(COLORS_KEY_LEGACY);
            editorEdit.apply();
        } else {
            Object objFromJson = gson.fromJson(string, new TypeToken<List<? extends Integer>>() { // from class: com.myscript.nebo.penpanel.InkSettings$colors$2
            }.getType());
            Intrinsics.checkNotNull(objFromJson);
            arrayListEmptyList = (List) objFromJson;
        }
        List<Integer> list2 = arrayListEmptyList.isEmpty() ? null : arrayListEmptyList;
        this.colors = list2 != null ? list2 : list;
    }

    /* synthetic */ InkSettings(Context context, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Integer> getColors() {
        return this.colors;
    }

    private final String getInkWidthPrefKey(ToolType toolType) {
        int i = WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()];
        if (i == 1) {
            return LAST_USED_PEN_INK_WIDTH_KEY;
        }
        if (i == 2) {
            return LAST_USED_ERASER_WIDTH_KEY;
        }
        if (i != 3) {
            return null;
        }
        return LAST_USED_HIGHLIGHTER_INK_WIDTH_KEY;
    }

    public final float getSelectedThicknessRatio(ToolType toolType, Context context) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(C6693R.dimen.thickness_button_default_thickness_ratio, typedValue, true);
        return this.sharedPreferences.getFloat(getInkWidthPrefKey(toolType), typedValue.getFloat());
    }

    public final void setSelectedThicknessRatio(ToolType toolType, float inkSizeValue) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putFloat(getInkWidthPrefKey(toolType), inkSizeValue);
        editorEdit.apply();
    }

    private final String getColorPrefKey(ToolType toolType) {
        int i = WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()];
        if (i == 1) {
            return LAST_USER_PEN_COLOR_KEY;
        }
        if (i != 3) {
            return null;
        }
        return LAST_USER_HIGHLIGHTER_COLOR_KEY;
    }

    public final void setSelectedColor(ToolType toolType, int color) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        String colorPrefKey = getColorPrefKey(toolType);
        if (colorPrefKey == null || Color.alpha(color) == 0) {
            return;
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(colorPrefKey, color);
        editorEdit.apply();
    }

    public final int getSelectedColor(ToolType toolType, int defaultColor) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        return this.sharedPreferences.getInt(getColorPrefKey(toolType), defaultColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Integer> setColors(List<Integer> colors) {
        this.colors = CollectionsKt.toList(colors);
        saveColors();
        return this.colors;
    }

    public final List<Integer> resetColors(List<Integer> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return setColors(colors);
    }

    public final List<Integer> addColor(int color) {
        return setColors(CollectionsKt.plus((Collection<? extends Integer>) this.colors, Integer.valueOf(color)));
    }

    public final List<Integer> duplicateColorAt(int position) {
        if (position >= 0 && position < this.colors.size()) {
            List<Integer> mutableList = CollectionsKt.toMutableList((Collection) this.colors);
            mutableList.add(position, mutableList.get(position));
            return setColors(mutableList);
        }
        return this.colors;
    }

    public final List<Integer> modifyColorAt(int color, int position) {
        if (position >= 0 && position < this.colors.size()) {
            List<Integer> mutableList = CollectionsKt.toMutableList((Collection) this.colors);
            mutableList.set(position, Integer.valueOf(color));
            return setColors(mutableList);
        }
        return this.colors;
    }

    public final List<Integer> removeColorAt(int position) {
        if (position >= 0 && position < this.colors.size()) {
            List<Integer> mutableList = CollectionsKt.toMutableList((Collection) this.colors);
            mutableList.remove(position);
            return setColors(mutableList);
        }
        return this.colors;
    }

    public final List<Integer> moveColors(int fromPosition, int toPosition) {
        if (fromPosition >= 0 && fromPosition < this.colors.size() && toPosition >= 0 && toPosition < this.colors.size()) {
            List<Integer> mutableList = CollectionsKt.toMutableList((Collection) this.colors);
            mutableList.add(toPosition, mutableList.remove(fromPosition));
            return setColors(mutableList);
        }
        return this.colors;
    }

    public final void saveColors() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(COLORS_KEY, this.gson.toJson(this.colors));
        editorEdit.apply();
    }

    public final String getEraserPolicy() {
        String string = this.sharedPreferences.getString(LAST_USED_ERASER_POLICY_KEY, ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_DEFAULT);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final void setEraserPolicy(String eraserPolicy) {
        Intrinsics.checkNotNullParameter(eraserPolicy, "eraserPolicy");
        if (!Intrinsics.areEqual(eraserPolicy, ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_STROKE) && !Intrinsics.areEqual(eraserPolicy, ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_PRECISE)) {
            throw new IllegalArgumentException(("Eraser policy must either be " + ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_STROKE + " or " + ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_PRECISE).toString());
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(LAST_USED_ERASER_POLICY_KEY, eraserPolicy);
        editorEdit.apply();
    }

    public final String getPenStroker() {
        String string = this.sharedPreferences.getString(LAST_USED_PEN_STROKER_KEY, ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_DEFAULT);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final void setPenStroker(String penStroker) {
        Intrinsics.checkNotNullParameter(penStroker, "penStroker");
        if (!Intrinsics.areEqual(penStroker, ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FELT) && !Intrinsics.areEqual(penStroker, ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN) && !Intrinsics.areEqual(penStroker, ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC)) {
            throw new IllegalArgumentException(("Pen stroker must either be " + ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FELT + " or " + ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN + " or " + ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC).toString());
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(LAST_USED_PEN_STROKER_KEY, penStroker);
        editorEdit.apply();
    }

    public final String getHighlighterPolicy() {
        String string = this.sharedPreferences.getString(LAST_USED_HIGHLIGHTER_POLICY_KEY, ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final void setHighlighterPolicy(String highlighterPolicy) {
        Intrinsics.checkNotNullParameter(highlighterPolicy, "highlighterPolicy");
        if (!Intrinsics.areEqual(highlighterPolicy, ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH) && !Intrinsics.areEqual(highlighterPolicy, ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART)) {
            throw new IllegalArgumentException(("Highlighter policy must either be " + ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH + " or " + ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART).toString());
        }
        this.sharedPreferences.edit().putString(LAST_USED_HIGHLIGHTER_POLICY_KEY, highlighterPolicy).apply();
    }

    public final String getHighlighterClearMode() {
        String string = this.sharedPreferences.getString(LAST_USED_HIGHLIGHTER_CLEAR_MODE_KEY, ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_FALSE);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final void setHighlighterClearMode(String clearMode) {
        Intrinsics.checkNotNullParameter(clearMode, "clearMode");
        if (!Intrinsics.areEqual(clearMode, ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_TRUE) && !Intrinsics.areEqual(clearMode, ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_FALSE)) {
            throw new IllegalArgumentException(("Highlighter clear mode must either be " + ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_TRUE + " or " + ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_FALSE).toString());
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(LAST_USED_HIGHLIGHTER_CLEAR_MODE_KEY, clearMode);
        editorEdit.apply();
    }

    public final String getLassoShape() {
        String string = this.sharedPreferences.getString(LAST_USED_LASSO_SHAPE_KEY, ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_DEFAULT);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final void setLassoShape(String lassoShape) {
        Intrinsics.checkNotNullParameter(lassoShape, "lassoShape");
        if (!Intrinsics.areEqual(lassoShape, ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_POLYGON) && !Intrinsics.areEqual(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE, lassoShape)) {
            throw new IllegalArgumentException(("Lasso shape must either be " + ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_POLYGON + " or " + ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE).toString());
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(LAST_USED_LASSO_SHAPE_KEY, lassoShape);
        editorEdit.apply();
    }

    /* JADX INFO: compiled from: InkSettings.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ,\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010!\u001a\u00020\u00162\b\b\u0001\u0010\"\u001a\u00020\u00162\b\b\u0001\u0010#\u001a\u00020\u0016J,\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\b\b\u0001\u0010!\u001a\u00020\u00162\b\b\u0001\u0010\"\u001a\u00020\u00162\b\b\u0001\u0010#\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/InkSettings$Companion;", "", "<init>", "()V", "COLORS_KEY_LEGACY", "", "COLORS_KEY", "INK_SETTINGS_PREFS", "getINK_SETTINGS_PREFS$annotations", "getINK_SETTINGS_PREFS", "()Ljava/lang/String;", InkSettings.LAST_USER_PEN_COLOR_KEY, InkSettings.LAST_USER_HIGHLIGHTER_COLOR_KEY, InkSettings.LAST_USED_PEN_INK_WIDTH_KEY, InkSettings.LAST_USED_ERASER_WIDTH_KEY, InkSettings.LAST_USED_HIGHLIGHTER_INK_WIDTH_KEY, InkSettings.LAST_USED_ERASER_POLICY_KEY, InkSettings.LAST_USED_PEN_STROKER_KEY, InkSettings.LAST_USED_HIGHLIGHTER_POLICY_KEY, InkSettings.LAST_USED_HIGHLIGHTER_CLEAR_MODE_KEY, InkSettings.LAST_USED_LASSO_SHAPE_KEY, "INK_SIZE_FACTOR", "", "loadFromPreferences", "Lcom/myscript/nebo/penpanel/InkSettings;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "defaultColors", "", "loadFromColors", "colors", "resetColors", "", "defaultColorsRes", "defaultPenColorRes", "defaultHighlighterColorRes", "bootstrapIfNeeded", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getINK_SETTINGS_PREFS$annotations() {
        }

        private Companion() {
        }

        public final String getINK_SETTINGS_PREFS() {
            return InkSettings.INK_SETTINGS_PREFS;
        }

        public final InkSettings loadFromPreferences(Context context, List<Integer> defaultColors) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(defaultColors, "defaultColors");
            return new InkSettings(context, defaultColors, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final InkSettings loadFromColors(Context context, List<Integer> colors) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(colors, "colors");
            InkSettings inkSettings = new InkSettings(context, null, 2, 0 == true ? 1 : 0);
            inkSettings.setColors(colors);
            return inkSettings;
        }

        public final void resetColors(Context context, int defaultColorsRes, int defaultPenColorRes, int defaultHighlighterColorRes) {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(defaultColorsRes);
            Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
            int color = ResourcesCompat.getColor(resources, defaultHighlighterColorRes, context.getTheme());
            int color2 = ResourcesCompat.getColor(resources, defaultPenColorRes, context.getTheme());
            InkSettings inkSettingsLoadFromColors = loadFromColors(context, ArraysKt.toList(intArray));
            inkSettingsLoadFromColors.setSelectedColor(ToolType.Highlighter, color);
            inkSettingsLoadFromColors.setSelectedColor(ToolType.Pen, color2);
            inkSettingsLoadFromColors.saveColors();
            String TOOL_PROPERTY_BRUSH_CLEAR_FALSE = ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_FALSE;
            Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_BRUSH_CLEAR_FALSE, "TOOL_PROPERTY_BRUSH_CLEAR_FALSE");
            inkSettingsLoadFromColors.setHighlighterClearMode(TOOL_PROPERTY_BRUSH_CLEAR_FALSE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bootstrapIfNeeded(Application application, int defaultColorsRes, int defaultPenColorRes, int defaultHighlighterColorRes) {
            Intrinsics.checkNotNullParameter(application, "application");
            Application application2 = application;
            if (new InkSettings(application2, null, 2, 0 == true ? 1 : 0).getColors().isEmpty()) {
                resetColors(application2, defaultColorsRes, defaultPenColorRes, defaultHighlighterColorRes);
            }
        }
    }
}
