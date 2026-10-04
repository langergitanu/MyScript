package com.myscript.nebo.editing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.p007ts.PsExtractor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.C4627R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.analytics.AnalyticsEvent;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.editing.NeboQuickToolControl;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.ColorNonePill;
import com.myscript.nebo.penpanel.ColorPill;
import com.myscript.nebo.penpanel.ToolConfigurationUIKt;
import com.myscript.nebo.penpanel.ToolbarViewModel;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.core.ToolbarConfigurationExt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener;
import com.samsung.android.sdk.pen.setting.quicktool.OnVisibilityAnimationListener;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorPickerLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NeboQuickToolControl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009b\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020-H\u0002J \u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020-H\u0002J\u000f\u0010I\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010JJ\u000f\u0010K\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010JJ\b\u0010L\u001a\u00020MH\u0002J\u0016\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u0002042\u0006\u0010P\u001a\u000204J\u0006\u0010Q\u001a\u00020\fJ\u0006\u0010R\u001a\u00020\fJ\u0018\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u0002022\b\u0010U\u001a\u0004\u0018\u00010VJ\u0016\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u0002002\u0006\u0010Y\u001a\u000200J\u000e\u0010Z\u001a\u00020\f2\u0006\u0010[\u001a\u000200J\u0014\u0010\\\u001a\u00020\f2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020*0)J\u0012\u0010^\u001a\u00020\u00172\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010_\u001a\u00020\fH\u0002J\b\u0010`\u001a\u00020\fH\u0002J\b\u0010a\u001a\u00020\fH\u0002J\b\u0010b\u001a\u00020\fH\u0002J\b\u0010c\u001a\u00020\fH\u0002J\b\u0010d\u001a\u00020\fH\u0002J\b\u0010e\u001a\u00020\fH\u0002J\u0010\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020-H\u0002J\b\u0010h\u001a\u00020\fH\u0002J\u0010\u0010i\u001a\u00020\f2\u0006\u0010j\u001a\u000204H\u0002J\u0010\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020-H\u0002J\b\u0010m\u001a\u00020 H\u0002J\u0010\u0010n\u001a\u00020 2\u0006\u0010o\u001a\u00020-H\u0002J\u0018\u0010p\u001a\u00020\f2\u0006\u0010q\u001a\u00020 2\u0006\u0010r\u001a\u00020-H\u0002J\u001a\u0010s\u001a\u00020\f2\b\u0010q\u001a\u0004\u0018\u00010 2\u0006\u0010o\u001a\u00020-H\u0002J\u0010\u0010t\u001a\u00020u2\u0006\u0010r\u001a\u00020-H\u0002J\u000e\u0010v\u001a\b\u0012\u0004\u0012\u00020w0)H\u0002J\u000e\u0010x\u001a\b\u0012\u0004\u0012\u00020y0)H\u0002J\u0010\u0010z\u001a\u00020\f2\u0006\u0010{\u001a\u000200H\u0002J\b\u0010|\u001a\u00020\fH\u0002J\u0018\u0010}\u001a\u00020-2\u0006\u0010~\u001a\u00020-2\u0006\u0010\u007f\u001a\u00020-H\u0002J\t\u0010\u0080\u0001\u001a\u00020-H\u0002J\u001b\u0010\u0081\u0001\u001a\u00020-2\u0006\u0010T\u001a\u0002022\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\t\u0010\u0082\u0001\u001a\u000200H\u0002J\t\u0010\u0083\u0001\u001a\u00020\fH\u0002J\u0011\u0010\u0084\u0001\u001a\u00020\f2\u0006\u0010q\u001a\u00020 H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020\f2\u0006\u0010T\u001a\u000202H\u0002J\u001c\u0010\u0086\u0001\u001a\u00020\f2\b\u0010q\u001a\u0004\u0018\u00010 2\u0007\u0010\u0087\u0001\u001a\u000200H\u0002J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0003\u0010\u008b\u0001J*\u0010\u008c\u0001\u001a\u00020\f2\u0006\u0010q\u001a\u00020\n2\u0006\u0010O\u001a\u0002042\u0006\u0010P\u001a\u0002042\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020-2\u0007\u0010\u008f\u0001\u001a\u00020-H\u0002J\u001b\u0010\u0090\u0001\u001a\u00020-2\u0007\u0010\u0091\u0001\u001a\u00020-2\u0007\u0010\u0092\u0001\u001a\u00020-H\u0002J\u0012\u0010\u0093\u0001\u001a\u00020-2\u0007\u0010\u0094\u0001\u001a\u00020-H\u0002J\u0012\u0010\u0095\u0001\u001a\u0002042\u0007\u0010\u0094\u0001\u001a\u00020-H\u0002J\u0012\u0010\u0096\u0001\u001a\u00020-2\u0007\u0010\u0097\u0001\u001a\u000204H\u0002J\t\u0010\u0098\u0001\u001a\u00020\fH\u0002J\t\u0010\u0099\u0001\u001a\u00020\fH\u0002J\t\u0010\u009a\u0001\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u0002040)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006\u009c\u0001"}, m1599d2 = {"Lcom/myscript/nebo/editing/NeboQuickToolControl;", "", WebViewMessageType.CONTEXT, "Landroid/app/Activity;", "editingLayout", "Landroid/view/ViewGroup;", "toolbarViewModel", "Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "trackButtonWhileOpen", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "", "forwardTouchToCanvas", "Lkotlin/Function1;", "onUndo", "Lkotlin/Function0;", "onRedo", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/myscript/nebo/penpanel/ToolbarViewModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "overlayView", "Landroid/widget/FrameLayout;", "qtLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout;", "attrLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout;", "colorDial", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout;", "colorPickerLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorPickerLayout;", "centerAreaRef", "centerImageRef", "Landroid/widget/ImageView;", "colorView", "sizeView", "eraserView", "highlighterView", "penView", "undoView", "redoView", "lastKnownColors", "", "Lcom/myscript/nebo/penpanel/ColorPill;", "snapshotColors", "currentSizeLevel", "", "currentColorIndex", "currentNoColorSelected", "", "currentToolType", "Lcom/myscript/snt/core/ToolType;", "toolThicknessRatios", "", "pendingPickerColor", "suppressDialCallback", "suppressSizeCallback", "isDismissing", "originalWindowCallback", "Landroid/view/Window$Callback;", "hitRect", "Landroid/graphics/Rect;", "overlayGestureActive", "overlayPendingRemoval", "isVisible", "()Z", "isWithinToolbox", "rawX", "rawY", "cornerRadiusSquared", "", "rect", "centerX", "centerY", "attrSliderRadiusSquared", "()Ljava/lang/Long;", "colorDialMaskRadiusSquared", "buildBackgroundTouchListener", "Landroid/view/View$OnTouchListener;", "show", "x", "y", "hide", "release", "syncToolType", "toolType", "toolConfig", "Lcom/myscript/snt/core/ToolConfiguration;", "syncPageState", "canUndo", "canRedo", "syncNoColor", "isSelected", "syncColors", "colors", "buildQtLayout", "onCenterTap", "cycleHighlighterPolicy", "cycleEraserPolicy", "cyclePenStroker", "onColorViewClick", "onSizeViewClick", "onNoColorClick", "onColorSelected", "dialIndex", "onColorPickerClick", "applyThickness", "thicknessRatio", "buildIconView", "drawableRes", "buildColorView", "buildSizeView", "sizePx", "setColorCircle", "view", "color", "updateSizeView", "makeColorCircle", "Landroid/graphics/drawable/GradientDrawable;", "buildDialItems", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "buildFixedItems", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$FixedItem;", "setEdgeViewsVisible", "visible", "applyAttrMaxDots", "themeColor", "attrRes", "fallback", "neutralIconColor", "centerDrawableRes", "hasEffectiveColor", "updateColorCircleForTool", "applyCenterTint", "updateActiveStates", "updateToolActiveState", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "makeActiveBackground", "Landroid/graphics/drawable/InsetDrawable;", "currentInkColor", "()Ljava/lang/Integer;", "positionView", "parent", "dpToPx", "dp", "levelForIndex", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "count", "snapSizeLevel", FirebaseAnalytics.Param.LEVEL, "levelToThickness", "thicknessToLevel", "ratio", "installWindowTouchDismiss", "restoreWindowCallback", "cleanup", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboQuickToolControl {
    private static final int ACTIVE_BACKGROUND_INSET_DP = 4;
    private static final int ALPHA_OPAQUE = -16777216;
    private static final int CENTER_SIZE_DP = 100;
    private static final int COLOR_PADDING_DP = 10;
    private static final int DEFAULT_SIZE_LEVEL = 50;
    private static final int DEFAULT_SIZE_VIEW_DP = 48;
    private static final float DEFAULT_THICKNESS_RATIO = 0.35f;
    private static final int ICON_PADDING_DP = 8;
    private static final int ICON_SIZE_DP = 40;
    private static final String NO_COLOR_TAG = "noColor";
    private static final float SIZE_DOT_MAX_RADIUS_FRACTION = 0.7f;
    private static final float SIZE_DOT_MIN_SCALE = 0.1f;
    private static final String TAG = "NeboQuickToolControl";
    private SpenSettingQTAttributesLayout attrLayout;
    private View centerAreaRef;
    private ImageView centerImageRef;
    private SpenSettingQTColorDialLayout colorDial;
    private SpenSettingQTColorPickerLayout colorPickerLayout;
    private ImageView colorView;
    private final Activity context;
    private int currentColorIndex;
    private boolean currentNoColorSelected;
    private int currentSizeLevel;
    private ToolType currentToolType;
    private final ViewGroup editingLayout;
    private ImageView eraserView;
    private final Function1<MotionEvent, Unit> forwardTouchToCanvas;
    private ImageView highlighterView;
    private final Rect hitRect;
    private boolean isDismissing;
    private List<ColorPill> lastKnownColors;
    private final Function0<Unit> onRedo;
    private final Function0<Unit> onUndo;
    private Window.Callback originalWindowCallback;
    private boolean overlayGestureActive;
    private FrameLayout overlayPendingRemoval;
    private FrameLayout overlayView;
    private ImageView penView;
    private int pendingPickerColor;
    private SpenSettingQTLayout qtLayout;
    private ImageView redoView;
    private ImageView sizeView;
    private List<ColorPill> snapshotColors;
    private boolean suppressDialCallback;
    private boolean suppressSizeCallback;
    private List<Float> toolThicknessRatios;
    private final ToolbarViewModel toolbarViewModel;
    private final Function2<View, MotionEvent, Unit> trackButtonWhileOpen;
    private ImageView undoView;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final int NEUTRAL_ICON_COLOR_FALLBACK = -6381922;
    private static final int DEFAULT_INK_COLOR = -16777216;

    /* JADX INFO: compiled from: NeboQuickToolControl.kt */
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
                iArr[ToolType.Highlighter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolType.Eraser.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NeboQuickToolControl(Activity context, ViewGroup editingLayout, ToolbarViewModel toolbarViewModel, Function2<? super View, ? super MotionEvent, Unit> trackButtonWhileOpen, Function1<? super MotionEvent, Unit> forwardTouchToCanvas, Function0<Unit> onUndo, Function0<Unit> onRedo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editingLayout, "editingLayout");
        Intrinsics.checkNotNullParameter(toolbarViewModel, "toolbarViewModel");
        Intrinsics.checkNotNullParameter(trackButtonWhileOpen, "trackButtonWhileOpen");
        Intrinsics.checkNotNullParameter(forwardTouchToCanvas, "forwardTouchToCanvas");
        Intrinsics.checkNotNullParameter(onUndo, "onUndo");
        Intrinsics.checkNotNullParameter(onRedo, "onRedo");
        this.context = context;
        this.editingLayout = editingLayout;
        this.toolbarViewModel = toolbarViewModel;
        this.trackButtonWhileOpen = trackButtonWhileOpen;
        this.forwardTouchToCanvas = forwardTouchToCanvas;
        this.onUndo = onUndo;
        this.onRedo = onRedo;
        this.lastKnownColors = CollectionsKt.emptyList();
        this.snapshotColors = CollectionsKt.emptyList();
        this.currentSizeLevel = 50;
        this.currentToolType = ToolType.Pen;
        this.toolThicknessRatios = CollectionsKt.emptyList();
        this.hitRect = new Rect();
    }

    public final boolean isVisible() {
        return this.overlayView != null;
    }

    private final boolean isWithinToolbox(int rawX, int rawY) {
        long jCornerRadiusSquared;
        Long lColorDialMaskRadiusSquared;
        SpenSettingQTLayout spenSettingQTLayout = this.qtLayout;
        if (spenSettingQTLayout == null) {
            return false;
        }
        spenSettingQTLayout.getGlobalVisibleRect(this.hitRect);
        int iCenterX = this.hitRect.centerX();
        int iCenterY = this.hitRect.centerY();
        long jMax = 0;
        for (View view : CollectionsKt.listOfNotNull((Object[]) new View[]{this.centerAreaRef, this.colorView, this.sizeView, this.eraserView, this.highlighterView, this.penView, this.undoView, this.redoView, this.attrLayout, this.colorDial, this.colorPickerLayout})) {
            if (view.getVisibility() == 0 && view.getGlobalVisibleRect(this.hitRect)) {
                if (Intrinsics.areEqual(view, this.attrLayout)) {
                    Long lAttrSliderRadiusSquared = attrSliderRadiusSquared();
                    jCornerRadiusSquared = lAttrSliderRadiusSquared != null ? lAttrSliderRadiusSquared.longValue() : cornerRadiusSquared(this.hitRect, iCenterX, iCenterY);
                } else {
                    jCornerRadiusSquared = (!Intrinsics.areEqual(view, this.colorDial) || (lColorDialMaskRadiusSquared = colorDialMaskRadiusSquared()) == null) ? cornerRadiusSquared(this.hitRect, iCenterX, iCenterY) : lColorDialMaskRadiusSquared.longValue();
                }
                jMax = Math.max(jMax, jCornerRadiusSquared);
            }
        }
        if (jMax == 0) {
            return false;
        }
        long j = rawX - iCenterX;
        long j2 = rawY - iCenterY;
        return (j * j) + (j2 * j2) <= jMax;
    }

    private final long cornerRadiusSquared(Rect rect, int centerX, int centerY) {
        long jMax = Math.max(Math.abs(rect.left - centerX), Math.abs(rect.right - centerX));
        long jMax2 = Math.max(Math.abs(rect.top - centerY), Math.abs(rect.bottom - centerY));
        return (jMax * jMax) + (jMax2 * jMax2);
    }

    private final Long attrSliderRadiusSquared() {
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
        if (spenSettingQTAttributesLayout == null) {
            return null;
        }
        try {
            Field declaredField = SpenSettingQTAttributesLayout.class.getDeclaredField("mSizeView");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(spenSettingQTAttributesLayout);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = obj.getClass().getDeclaredField("mRadius");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Float f = obj2 instanceof Float ? (Float) obj2 : null;
            if (f != null) {
                float fFloatValue = f.floatValue();
                return Long.valueOf((long) (fFloatValue * fFloatValue));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private final Long colorDialMaskRadiusSquared() {
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.colorDial;
        if (spenSettingQTColorDialLayout == null) {
            return null;
        }
        try {
            Field declaredField = SpenSettingQTColorDialLayout.class.getDeclaredField("mCircularRoundLayout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(spenSettingQTColorDialLayout);
            View view = obj instanceof View ? (View) obj : null;
            if (view == null) {
                return null;
            }
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return null;
            }
            long jMin = ((long) Math.min(rect.width(), rect.height())) / 2;
            return Long.valueOf(jMin * jMin);
        } catch (Exception unused) {
            return null;
        }
    }

    private final View.OnTouchListener buildBackgroundTouchListener() {
        final int scaledTouchSlop = ViewConfiguration.get(this.context).getScaledTouchSlop();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        return new View.OnTouchListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NeboQuickToolControl.buildBackgroundTouchListener$lambda$0(this.f$0, booleanRef2, objectRef, booleanRef, scaledTouchSlop, view, motionEvent);
            }
        };
    }

    private static final void buildBackgroundTouchListener$reset(Ref.ObjectRef<MotionEvent> objectRef, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2) {
        MotionEvent motionEvent = objectRef.element;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        objectRef.element = null;
        booleanRef.element = false;
        booleanRef2.element = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, android.view.MotionEvent] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean buildBackgroundTouchListener$lambda$0(NeboQuickToolControl neboQuickToolControl, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef2, int i, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            buildBackgroundTouchListener$reset(objectRef, booleanRef2, booleanRef);
            if (neboQuickToolControl.isWithinToolbox((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                booleanRef.element = true;
            } else {
                objectRef.element = MotionEvent.obtain(motionEvent);
                neboQuickToolControl.overlayGestureActive = true;
                neboQuickToolControl.hide();
            }
        } else if (actionMasked == 1) {
            if (booleanRef2.element) {
                Function1<MotionEvent, Unit> function1 = neboQuickToolControl.forwardTouchToCanvas;
                Intrinsics.checkNotNull(motionEvent);
                function1.invoke(motionEvent);
            }
            if (!booleanRef.element) {
                neboQuickToolControl.overlayGestureActive = false;
                view.setOnTouchListener(null);
                FrameLayout frameLayout = neboQuickToolControl.overlayPendingRemoval;
                if (frameLayout != null) {
                    ViewParent parent = frameLayout.getParent();
                    ViewGroup viewGroup = neboQuickToolControl.editingLayout;
                    if (parent == viewGroup) {
                        viewGroup.removeView(frameLayout);
                    }
                }
                neboQuickToolControl.overlayPendingRemoval = null;
            }
            buildBackgroundTouchListener$reset(objectRef, booleanRef2, booleanRef);
        } else if (actionMasked == 2) {
            MotionEvent motionEvent2 = (MotionEvent) objectRef.element;
            if (!booleanRef.element) {
                if (booleanRef2.element) {
                    Function1<MotionEvent, Unit> function12 = neboQuickToolControl.forwardTouchToCanvas;
                    Intrinsics.checkNotNull(motionEvent);
                    function12.invoke(motionEvent);
                } else if (motionEvent2 != null) {
                    float x = motionEvent.getX() - motionEvent2.getX();
                    float y = motionEvent.getY() - motionEvent2.getY();
                    if ((x * x) + (y * y) > i * i) {
                        booleanRef2.element = true;
                        neboQuickToolControl.forwardTouchToCanvas.invoke(motionEvent2);
                        Function1<MotionEvent, Unit> function13 = neboQuickToolControl.forwardTouchToCanvas;
                        Intrinsics.checkNotNull(motionEvent);
                        function13.invoke(motionEvent);
                    }
                }
            }
        } else if (actionMasked == 3) {
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.myscript.nebo.editing.NeboQuickToolControl$show$overlay$1] */
    public final void show(final float x, final float y) {
        ColorNonePill value;
        if (this.overlayView == null && this.overlayPendingRemoval == null) {
            ToolType selectedToolTypeValue = this.toolbarViewModel.getSelectedToolTypeValue();
            this.currentToolType = selectedToolTypeValue;
            if (selectedToolTypeValue == ToolType.Keyboard || this.currentToolType == ToolType.Lasso) {
                this.toolbarViewModel.changeTool(ToolType.Pen);
                this.currentToolType = ToolType.Pen;
            }
            if (INSTANCE.isToolSupported(this.currentToolType)) {
                AnalyticsEvent.log$default(NeboFirebaseEvent.SpenQuickToolOpen, null, 1, null);
                ToolConfiguration toolConfigurationFindToolConfigurationByType = this.toolbarViewModel.findToolConfigurationByType(this.currentToolType);
                if (this.lastKnownColors.isEmpty()) {
                    List<ColorPill> value2 = this.toolbarViewModel.getColors().getValue();
                    if (value2 == null) {
                        value2 = CollectionsKt.emptyList();
                    }
                    this.lastKnownColors = value2;
                }
                this.snapshotColors = this.lastKnownColors;
                this.toolThicknessRatios = this.toolbarViewModel.availableThicknessRatios(this.currentToolType);
                this.currentSizeLevel = thicknessToLevel(toolConfigurationFindToolConfigurationByType != null ? toolConfigurationFindToolConfigurationByType.getThicknessRatio() : DEFAULT_THICKNESS_RATIO);
                Iterator<ColorPill> it = this.snapshotColors.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (it.next().isSelected()) {
                        break;
                    } else {
                        i++;
                    }
                }
                this.currentColorIndex = RangesKt.coerceAtLeast(i, 0);
                this.currentNoColorSelected = this.currentToolType == ToolType.Highlighter && (value = this.toolbarViewModel.getColorNone().getValue()) != null && value.isSelected();
                final Activity activity = this.context;
                final ?? r5 = new FrameLayout(activity) { // from class: com.myscript.nebo.editing.NeboQuickToolControl$show$overlay$1
                    {
                        super(activity);
                    }

                    @Override // android.view.ViewGroup
                    public boolean onInterceptTouchEvent(MotionEvent ev) {
                        ViewParent parent;
                        Intrinsics.checkNotNullParameter(ev, "ev");
                        if (ev.getActionMasked() == 0 && (parent = getParent()) != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        return super.onInterceptTouchEvent(ev);
                    }

                    @Override // android.view.View
                    public boolean dispatchGenericMotionEvent(MotionEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        int actionMasked = event.getActionMasked();
                        if (actionMasked == 7 || actionMasked == 9 || actionMasked == 10) {
                            this.this$0.trackButtonWhileOpen.invoke(this, event);
                        }
                        return super.dispatchGenericMotionEvent(event);
                    }
                };
                r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                r5.setClipChildren(false);
                r5.setClipToPadding(false);
                r5.setOnTouchListener(buildBackgroundTouchListener());
                this.editingLayout.addView((View) r5);
                this.overlayView = (FrameLayout) r5;
                installWindowTouchDismiss();
                final SpenSettingQTLayout spenSettingQTLayoutBuildQtLayout = buildQtLayout(toolConfigurationFindToolConfigurationByType);
                r5.addView(spenSettingQTLayoutBuildQtLayout, new ViewGroup.LayoutParams(-2, -2));
                this.qtLayout = spenSettingQTLayoutBuildQtLayout;
                spenSettingQTLayoutBuildQtLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl.show.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (spenSettingQTLayoutBuildQtLayout.getWidth() <= 0 || spenSettingQTLayoutBuildQtLayout.getHeight() <= 0) {
                            return;
                        }
                        if (spenSettingQTLayoutBuildQtLayout.getViewTreeObserver().isAlive()) {
                            spenSettingQTLayoutBuildQtLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                        this.positionView(spenSettingQTLayoutBuildQtLayout, x, y, r5);
                    }
                });
                spenSettingQTLayoutBuildQtLayout.setVisibilityWithAnimation(0, null);
            }
        }
    }

    public final void hide() {
        if (this.isDismissing) {
            return;
        }
        this.isDismissing = true;
        SpenSettingQTLayout spenSettingQTLayout = this.qtLayout;
        if (spenSettingQTLayout == null) {
            cleanup();
        } else {
            spenSettingQTLayout.setVisibilityWithAnimation(8, new OnVisibilityAnimationListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl.hide.1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.OnVisibilityAnimationListener
                public void onAnimationStart(int visibility) {
                }

                @Override // com.samsung.android.sdk.pen.setting.quicktool.OnVisibilityAnimationListener
                public void onAnimationEnd(int visibility, boolean canceled) {
                    if (visibility == 8) {
                        NeboQuickToolControl.this.cleanup();
                    }
                }
            });
        }
    }

    public final void release() {
        cleanup();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void syncToolType(ToolType toolType, ToolConfiguration toolConfig) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        if (isVisible()) {
            if (!INSTANCE.isToolSupported(toolType)) {
                hide();
                return;
            }
            this.currentToolType = toolType;
            this.toolThicknessRatios = this.toolbarViewModel.availableThicknessRatios(toolType);
            applyAttrMaxDots();
            if (toolConfig != null) {
                this.currentSizeLevel = thicknessToLevel(toolConfig.getThicknessRatio());
            }
            ImageView imageView = this.centerImageRef;
            if (imageView != null) {
                int iCenterDrawableRes = centerDrawableRes(toolType, toolConfig);
                if (iCenterDrawableRes != 0) {
                    imageView.setImageResource(iCenterDrawableRes);
                }
                applyCenterTint(imageView);
            }
            updateActiveStates(toolType);
            updateColorCircleForTool();
            ImageView imageView2 = this.sizeView;
            if (imageView2 != null) {
                Integer numValueOf = Integer.valueOf(imageView2.getWidth());
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : dpToPx(48);
            }
            updateSizeView(this.sizeView, iIntValue);
            SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
            if (spenSettingQTAttributesLayout == null || spenSettingQTAttributesLayout.getVisibility() != 0) {
                return;
            }
            this.suppressSizeCallback = true;
            try {
                SpenSettingQTAttributesLayout spenSettingQTAttributesLayout2 = this.attrLayout;
                if (spenSettingQTAttributesLayout2 != null) {
                    spenSettingQTAttributesLayout2.setSizeLevel(this.currentSizeLevel);
                }
            } finally {
                this.suppressSizeCallback = false;
            }
        }
    }

    public final void syncPageState(boolean canUndo, boolean canRedo) {
        ImageView imageView = this.undoView;
        if (imageView != null) {
            imageView.setAlpha(canUndo ? 1.0f : 0.4f);
        }
        ImageView imageView2 = this.undoView;
        if (imageView2 != null) {
            imageView2.setEnabled(canUndo);
        }
        ImageView imageView3 = this.redoView;
        if (imageView3 != null) {
            imageView3.setAlpha(canRedo ? 1.0f : 0.4f);
        }
        ImageView imageView4 = this.redoView;
        if (imageView4 != null) {
            imageView4.setEnabled(canRedo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void syncNoColor(boolean isSelected) {
        int iIntValue;
        if (isVisible()) {
            this.currentNoColorSelected = isSelected;
            updateColorCircleForTool();
            ImageView imageView = this.sizeView;
            if (imageView != null) {
                Integer numValueOf = Integer.valueOf(imageView.getWidth());
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : dpToPx(48);
            }
            updateSizeView(this.sizeView, iIntValue);
            ImageView imageView2 = this.centerImageRef;
            if (imageView2 != null) {
                applyCenterTint(imageView2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void syncColors(List<ColorPill> colors) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.lastKnownColors = colors;
        if (isVisible()) {
            this.snapshotColors = colors;
            Iterator<ColorPill> it = colors.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().isSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            this.currentColorIndex = RangesKt.coerceAtLeast(i, 0);
            Integer numCurrentInkColor = currentInkColor();
            if (numCurrentInkColor != null) {
                int iIntValue = numCurrentInkColor.intValue();
                if (hasEffectiveColor() && (imageView = this.colorView) != null) {
                    setColorCircle(imageView, iIntValue);
                }
                SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
                if (spenSettingQTAttributesLayout != null) {
                    spenSettingQTAttributesLayout.setColor(iIntValue);
                }
                ImageView imageView2 = this.sizeView;
                if (imageView2 != null) {
                    Integer numValueOf = Integer.valueOf(imageView2.getWidth());
                    if (numValueOf.intValue() <= 0) {
                        numValueOf = null;
                    }
                    int iIntValue2 = numValueOf != null ? numValueOf.intValue() : dpToPx(48);
                    updateSizeView(this.sizeView, iIntValue2);
                }
            }
            ImageView imageView3 = this.centerImageRef;
            if (imageView3 != null) {
                applyCenterTint(imageView3);
            }
        }
    }

    private final SpenSettingQTLayout buildQtLayout(ToolConfiguration toolConfig) {
        SpenSettingQTLayout spenSettingQTLayout = new SpenSettingQTLayout(this.context);
        spenSettingQTLayout.setClipChildren(false);
        spenSettingQTLayout.setClipToPadding(false);
        final int iDpToPx = dpToPx(40);
        int iDpToPx2 = dpToPx(100);
        View viewAddCenterView = spenSettingQTLayout.addCenterView(C6079R.layout.spen_qt_center_view, iDpToPx2, iDpToPx2);
        ImageView imageView = (ImageView) viewAddCenterView.findViewById(C6079R.id.spen_qt_center_image);
        int iCenterDrawableRes = centerDrawableRes(this.currentToolType, toolConfig);
        if (iCenterDrawableRes != 0) {
            imageView.setImageResource(iCenterDrawableRes);
        }
        viewAddCenterView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCenterTap();
            }
        });
        this.centerAreaRef = viewAddCenterView;
        this.centerImageRef = imageView;
        Intrinsics.checkNotNull(imageView);
        applyCenterTint(imageView);
        ImageView imageViewBuildColorView = buildColorView();
        imageViewBuildColorView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onColorViewClick();
            }
        });
        spenSettingQTLayout.addEdgeView(imageViewBuildColorView, iDpToPx, iDpToPx, 0, 2);
        this.colorView = imageViewBuildColorView;
        ImageView imageViewBuildIconView = buildIconView(C6693R.drawable.ic_eraser);
        imageViewBuildIconView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeboQuickToolControl.buildQtLayout$lambda$2$0(this.f$0, view);
            }
        });
        spenSettingQTLayout.addEdgeView(imageViewBuildIconView, iDpToPx, iDpToPx, 45, 2);
        this.eraserView = imageViewBuildIconView;
        ImageView imageViewBuildIconView2 = buildIconView(C6693R.drawable.ic_highlighter);
        imageViewBuildIconView2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeboQuickToolControl.buildQtLayout$lambda$3$0(this.f$0, view);
            }
        });
        spenSettingQTLayout.addEdgeView(imageViewBuildIconView2, iDpToPx, iDpToPx, 90, 2);
        this.highlighterView = imageViewBuildIconView2;
        ImageView imageViewBuildIconView3 = buildIconView(C6693R.drawable.ic_pen);
        imageViewBuildIconView3.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeboQuickToolControl.buildQtLayout$lambda$4$0(this.f$0, view);
            }
        });
        spenSettingQTLayout.addEdgeView(imageViewBuildIconView3, iDpToPx, iDpToPx, 135, 2);
        this.penView = imageViewBuildIconView3;
        ImageView imageViewBuildSizeView = buildSizeView(iDpToPx);
        imageViewBuildSizeView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onSizeViewClick();
            }
        });
        spenSettingQTLayout.addEdgeView(imageViewBuildSizeView, iDpToPx, iDpToPx, SensibleDefaults.X_OFFSET, 2);
        this.sizeView = imageViewBuildSizeView;
        ImageView imageViewBuildIconView4 = buildIconView(C6183R.drawable.ic_undo);
        imageViewBuildIconView4.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeboQuickToolControl.buildQtLayout$lambda$6$0(this.f$0, view);
            }
        });
        spenSettingQTLayout.addEdgeView(imageViewBuildIconView4, iDpToPx, iDpToPx, PsExtractor.VIDEO_STREAM_MASK, 2);
        this.undoView = imageViewBuildIconView4;
        ImageView imageViewBuildIconView5 = buildIconView(C6183R.drawable.ic_redo);
        imageViewBuildIconView5.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeboQuickToolControl.buildQtLayout$lambda$7$0(this.f$0, view);
            }
        });
        spenSettingQTLayout.addEdgeView(imageViewBuildIconView5, iDpToPx, iDpToPx, 300, 2);
        this.redoView = imageViewBuildIconView5;
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = new SpenSettingQTAttributesLayout(this.context, 1);
        spenSettingQTAttributesLayout.setSizeLevel(this.currentSizeLevel);
        Integer numCurrentInkColor = currentInkColor();
        if (numCurrentInkColor != null) {
            spenSettingQTAttributesLayout.setColor(numCurrentInkColor.intValue());
        }
        spenSettingQTAttributesLayout.setDataChangedListener(new SpenSettingQTAttributesLayout.OnDataChangedListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$buildQtLayout$attr$1$2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.OnDataChangedListener
            public void onAlphaChanged(int alpha, boolean notify) {
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.OnDataChangedListener
            public void onFixedWidthChanged(boolean isFixedWidth) {
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.OnDataChangedListener
            public void onSizeChanged(int sizeLevel) {
                if (this.this$0.suppressSizeCallback) {
                    return;
                }
                int iSnapSizeLevel = this.this$0.snapSizeLevel(sizeLevel);
                this.this$0.currentSizeLevel = iSnapSizeLevel;
                NeboQuickToolControl neboQuickToolControl = this.this$0;
                neboQuickToolControl.updateSizeView(neboQuickToolControl.sizeView, iDpToPx);
                if (!this.this$0.toolThicknessRatios.isEmpty()) {
                    NeboQuickToolControl neboQuickToolControl2 = this.this$0;
                    neboQuickToolControl2.applyThickness(neboQuickToolControl2.levelToThickness(iSnapSizeLevel));
                }
                if (iSnapSizeLevel != sizeLevel) {
                    this.this$0.suppressSizeCallback = true;
                    try {
                        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout2 = this.this$0.attrLayout;
                        if (spenSettingQTAttributesLayout2 != null) {
                            spenSettingQTAttributesLayout2.setSizeLevel(iSnapSizeLevel);
                        }
                    } finally {
                        this.this$0.suppressSizeCallback = false;
                    }
                }
            }
        });
        spenSettingQTAttributesLayout.setVisibility(8, false);
        spenSettingQTLayout.addView(spenSettingQTAttributesLayout);
        this.attrLayout = spenSettingQTAttributesLayout;
        applyAttrMaxDots();
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = new SpenSettingQTColorDialLayout(this.context);
        spenSettingQTColorDialLayout.setDialItems(buildDialItems());
        spenSettingQTColorDialLayout.setFixedItems(buildFixedItems());
        int size = this.snapshotColors.size();
        int i = this.currentColorIndex;
        if (i >= 0 && i < size) {
            spenSettingQTColorDialLayout.setSelected(SpenSettingQTColorDialLayout.ButtonType.DIALED, this.currentColorIndex, true, false);
        }
        spenSettingQTColorDialLayout.setActionListener(new SpenSettingQTColorDialLayout.ActionListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$buildQtLayout$dial$1$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.ActionListener
            public void onDialButtonClick(int index, boolean isSelected) {
                if (this.this$0.suppressDialCallback) {
                    return;
                }
                this.this$0.onColorSelected(index);
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.ActionListener
            public void onFixedButtonClick(int index, boolean isSelected) {
                if (this.this$0.currentToolType != ToolType.Highlighter) {
                    if (index == 0) {
                        this.this$0.onColorPickerClick();
                    }
                } else if (index == 0) {
                    this.this$0.onNoColorClick();
                } else {
                    if (index != 1) {
                        return;
                    }
                    this.this$0.onColorPickerClick();
                }
            }
        });
        spenSettingQTColorDialLayout.setVisibility(8);
        spenSettingQTLayout.addView(spenSettingQTColorDialLayout);
        this.colorDial = spenSettingQTColorDialLayout;
        updateActiveStates(this.currentToolType);
        updateColorCircleForTool();
        return spenSettingQTLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildQtLayout$lambda$2$0(NeboQuickToolControl neboQuickToolControl, View view) {
        NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboQuickToolControl.buildQtLayout$lambda$2$0$0((Bundle) obj);
            }
        });
        neboQuickToolControl.toolbarViewModel.switchBetweenEraserAndPreviousTool();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildQtLayout$lambda$2$0$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "eraser");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildQtLayout$lambda$3$0(NeboQuickToolControl neboQuickToolControl, View view) {
        NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboQuickToolControl.buildQtLayout$lambda$3$0$0((Bundle) obj);
            }
        });
        neboQuickToolControl.toolbarViewModel.changeTool(ToolType.Highlighter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildQtLayout$lambda$3$0$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "highlighter");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildQtLayout$lambda$4$0(NeboQuickToolControl neboQuickToolControl, View view) {
        NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboQuickToolControl.buildQtLayout$lambda$4$0$0((Bundle) obj);
            }
        });
        neboQuickToolControl.toolbarViewModel.changeTool(ToolType.Pen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildQtLayout$lambda$4$0$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "pen");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildQtLayout$lambda$6$0(NeboQuickToolControl neboQuickToolControl, View view) {
        NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboQuickToolControl.buildQtLayout$lambda$6$0$0((Bundle) obj);
            }
        });
        neboQuickToolControl.onUndo.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildQtLayout$lambda$6$0$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "undo");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildQtLayout$lambda$7$0(NeboQuickToolControl neboQuickToolControl, View view) {
        NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboQuickToolControl.buildQtLayout$lambda$7$0$0((Bundle) obj);
            }
        });
        neboQuickToolControl.onRedo.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildQtLayout$lambda$7$0$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "redo");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCenterTap() {
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.colorDial;
        if (spenSettingQTColorDialLayout != null && spenSettingQTColorDialLayout.getVisibility() == 0) {
            SpenSettingQTColorDialLayout spenSettingQTColorDialLayout2 = this.colorDial;
            if (spenSettingQTColorDialLayout2 != null) {
                spenSettingQTColorDialLayout2.setVisibility(8);
            }
            setEdgeViewsVisible(true);
            return;
        }
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
        if (spenSettingQTAttributesLayout != null && spenSettingQTAttributesLayout.getVisibility() == 0) {
            SpenSettingQTAttributesLayout spenSettingQTAttributesLayout2 = this.attrLayout;
            if (spenSettingQTAttributesLayout2 != null) {
                spenSettingQTAttributesLayout2.setVisibility(8);
            }
            setEdgeViewsVisible(true);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentToolType.ordinal()];
        if (i == 1) {
            NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NeboQuickToolControl.onCenterTap$lambda$0((Bundle) obj);
                }
            });
            cyclePenStroker();
        } else if (i == 2) {
            NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NeboQuickToolControl.onCenterTap$lambda$1((Bundle) obj);
                }
            });
            cycleHighlighterPolicy();
        } else {
            if (i != 3) {
                return;
            }
            NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NeboQuickToolControl.onCenterTap$lambda$2((Bundle) obj);
                }
            });
            cycleEraserPolicy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCenterTap$lambda$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "pen_style_cycled");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCenterTap$lambda$1(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "highlighter_policy_cycled");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCenterTap$lambda$2(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "eraser_policy_cycled");
        return Unit.INSTANCE;
    }

    private final void cycleHighlighterPolicy() {
        String str;
        ToolConfiguration toolConfigurationFindToolConfigurationByType = this.toolbarViewModel.findToolConfigurationByType(ToolType.Highlighter);
        if (toolConfigurationFindToolConfigurationByType == null) {
            return;
        }
        if (Intrinsics.areEqual(toolConfigurationFindToolConfigurationByType.getProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY), ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART)) {
            str = ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH;
        } else {
            str = ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART;
        }
        ToolConfiguration toolConfiguration = new ToolConfiguration(ToolType.Highlighter, toolConfigurationFindToolConfigurationByType.getColor2(), toolConfigurationFindToolConfigurationByType.getThicknessRatio());
        toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY, str);
        this.toolbarViewModel.applyToolConfiguration(toolConfiguration);
    }

    private final void cycleEraserPolicy() {
        String str;
        ToolConfiguration toolConfigurationFindToolConfigurationByType = this.toolbarViewModel.findToolConfigurationByType(ToolType.Eraser);
        if (toolConfigurationFindToolConfigurationByType == null) {
            return;
        }
        if (Intrinsics.areEqual(toolConfigurationFindToolConfigurationByType.getProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY), ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_PRECISE)) {
            str = ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_STROKE;
        } else {
            str = ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_PRECISE;
        }
        ToolConfiguration toolConfiguration = new ToolConfiguration(ToolType.Eraser, toolConfigurationFindToolConfigurationByType.getColor2(), toolConfigurationFindToolConfigurationByType.getThicknessRatio());
        toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY, str);
        this.toolbarViewModel.applyToolConfiguration(toolConfiguration);
    }

    private final void cyclePenStroker() {
        String str;
        ToolConfiguration toolConfigurationFindToolConfigurationByType = this.toolbarViewModel.findToolConfigurationByType(ToolType.Pen);
        if (toolConfigurationFindToolConfigurationByType == null) {
            return;
        }
        String property = toolConfigurationFindToolConfigurationByType.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER);
        if (Intrinsics.areEqual(property, ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FELT)) {
            str = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN;
        } else {
            str = Intrinsics.areEqual(property, ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN) ? ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC : ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FELT;
        }
        ToolConfiguration toolConfiguration = new ToolConfiguration(ToolType.Pen, toolConfigurationFindToolConfigurationByType.getColor2(), toolConfigurationFindToolConfigurationByType.getThicknessRatio());
        toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER, str);
        this.toolbarViewModel.applyToolConfiguration(toolConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorViewClick() {
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout;
        if (ToolbarConfigurationExt.isWritingTool(this.currentToolType)) {
            SpenSettingQTColorDialLayout spenSettingQTColorDialLayout2 = this.colorDial;
            if (spenSettingQTColorDialLayout2 != null && spenSettingQTColorDialLayout2.getVisibility() == 0) {
                SpenSettingQTColorDialLayout spenSettingQTColorDialLayout3 = this.colorDial;
                if (spenSettingQTColorDialLayout3 != null) {
                    spenSettingQTColorDialLayout3.setVisibility(8);
                }
                setEdgeViewsVisible(true);
                return;
            }
            if (this.snapshotColors.isEmpty()) {
                return;
            }
            SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
            if (spenSettingQTAttributesLayout != null) {
                spenSettingQTAttributesLayout.setVisibility(8);
            }
            setEdgeViewsVisible(false);
            ImageView imageView = this.colorView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.suppressDialCallback = true;
            try {
                SpenSettingQTColorDialLayout spenSettingQTColorDialLayout4 = this.colorDial;
                if (spenSettingQTColorDialLayout4 != null) {
                    spenSettingQTColorDialLayout4.setFixedItems(buildFixedItems());
                }
                SpenSettingQTColorDialLayout spenSettingQTColorDialLayout5 = this.colorDial;
                if (spenSettingQTColorDialLayout5 != null) {
                    spenSettingQTColorDialLayout5.setDialItems(buildDialItems());
                }
                if (this.currentToolType == ToolType.Highlighter && this.currentNoColorSelected) {
                    SpenSettingQTColorDialLayout spenSettingQTColorDialLayout6 = this.colorDial;
                    if (spenSettingQTColorDialLayout6 != null) {
                        spenSettingQTColorDialLayout6.setSelected(SpenSettingQTColorDialLayout.ButtonType.FIXED, 0, true, false);
                    }
                } else {
                    int size = this.snapshotColors.size();
                    int i = this.currentColorIndex;
                    if (i >= 0 && i < size && (spenSettingQTColorDialLayout = this.colorDial) != null) {
                        spenSettingQTColorDialLayout.setSelected(SpenSettingQTColorDialLayout.ButtonType.DIALED, this.currentColorIndex, true, false);
                    }
                }
                this.suppressDialCallback = false;
                SpenSettingQTColorDialLayout spenSettingQTColorDialLayout7 = this.colorDial;
                if (spenSettingQTColorDialLayout7 != null) {
                    spenSettingQTColorDialLayout7.setVisibility(0, true);
                }
                View view = this.centerAreaRef;
                if (view != null) {
                    view.bringToFront();
                }
            } catch (Throwable th) {
                this.suppressDialCallback = false;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSizeViewClick() {
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
        if (spenSettingQTAttributesLayout != null && spenSettingQTAttributesLayout.getVisibility() == 0) {
            NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NeboQuickToolControl.onSizeViewClick$lambda$0((Bundle) obj);
                }
            });
            SpenSettingQTAttributesLayout spenSettingQTAttributesLayout2 = this.attrLayout;
            if (spenSettingQTAttributesLayout2 != null) {
                spenSettingQTAttributesLayout2.setVisibility(8);
            }
            setEdgeViewsVisible(true);
            return;
        }
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.colorDial;
        if (spenSettingQTColorDialLayout != null) {
            spenSettingQTColorDialLayout.setVisibility(8);
        }
        setEdgeViewsVisible(false);
        ImageView imageView = this.sizeView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout3 = this.attrLayout;
        if (spenSettingQTAttributesLayout3 != null) {
            spenSettingQTAttributesLayout3.setSizeLevel(this.currentSizeLevel);
        }
        Integer numCurrentInkColor = currentInkColor();
        if (numCurrentInkColor != null) {
            int iIntValue = numCurrentInkColor.intValue();
            SpenSettingQTAttributesLayout spenSettingQTAttributesLayout4 = this.attrLayout;
            if (spenSettingQTAttributesLayout4 != null) {
                spenSettingQTAttributesLayout4.setColor(iIntValue);
            }
        }
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout5 = this.attrLayout;
        if (spenSettingQTAttributesLayout5 != null) {
            spenSettingQTAttributesLayout5.setVisibility(0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSizeViewClick$lambda$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "size_changed");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNoColorClick() {
        this.currentNoColorSelected = true;
        NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboQuickToolControl.onNoColorClick$lambda$0((Bundle) obj);
            }
        });
        this.toolbarViewModel.activateNoneColor();
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.colorDial;
        if (spenSettingQTColorDialLayout != null) {
            spenSettingQTColorDialLayout.setVisibility(8);
        }
        setEdgeViewsVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onNoColorClick$lambda$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "no_color_selected");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorSelected(int dialIndex) {
        if (dialIndex < 0 || dialIndex >= this.snapshotColors.size()) {
            return;
        }
        ColorPill colorPill = this.snapshotColors.get(dialIndex);
        this.currentColorIndex = dialIndex;
        this.currentNoColorSelected = false;
        ImageView imageView = this.colorView;
        if (imageView != null) {
            setColorCircle(imageView, colorPill.getDisplayedColor());
        }
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
        if (spenSettingQTAttributesLayout != null) {
            spenSettingQTAttributesLayout.setColor(colorPill.getDisplayedColor());
        }
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.colorDial;
        if (spenSettingQTColorDialLayout != null) {
            spenSettingQTColorDialLayout.setSelected(SpenSettingQTColorDialLayout.ButtonType.DIALED, dialIndex, true, false);
        }
        NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboQuickToolControl.onColorSelected$lambda$1((Bundle) obj);
            }
        });
        this.toolbarViewModel.selectColorAt(colorPill.getIndex());
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout2 = this.colorDial;
        if (spenSettingQTColorDialLayout2 != null) {
            spenSettingQTColorDialLayout2.setVisibility(8);
        }
        setEdgeViewsVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onColorSelected$lambda$1(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("action", "color_selected");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorPickerClick() {
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.colorDial;
        if (spenSettingQTColorDialLayout != null) {
            spenSettingQTColorDialLayout.setVisibility(8);
        }
        setEdgeViewsVisible(false);
        Integer numCurrentInkColor = currentInkColor();
        int iIntValue = (numCurrentInkColor != null ? numCurrentInkColor.intValue() : DEFAULT_INK_COLOR) | (-16777216);
        this.pendingPickerColor = iIntValue;
        float[] fArr = new float[3];
        Color.colorToHSV(iIntValue, fArr);
        SpenSettingQTColorPickerLayout spenSettingQTColorPickerLayout = this.colorPickerLayout;
        if (spenSettingQTColorPickerLayout == null) {
            SpenSettingQTColorPickerLayout spenSettingQTColorPickerLayout2 = new SpenSettingQTColorPickerLayout(this.context, fArr);
            spenSettingQTColorPickerLayout2.setColorTheme(0);
            spenSettingQTColorPickerLayout2.setCurrentColor(fArr);
            spenSettingQTColorPickerLayout2.setOnActionListener(new C63741(spenSettingQTColorPickerLayout2));
            spenSettingQTColorPickerLayout2.setOnColorChangedListener(new SpenColorPickerDataChangedListener() { // from class: com.myscript.nebo.editing.NeboQuickToolControl.onColorPickerClick.2
                @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
                public void onColorChanged(int color, float[] hsvColor) {
                    Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                    NeboQuickToolControl.this.pendingPickerColor = Color.HSVToColor(hsvColor) | (-16777216);
                    ImageView imageView = NeboQuickToolControl.this.colorView;
                    if (imageView != null) {
                        NeboQuickToolControl neboQuickToolControl = NeboQuickToolControl.this;
                        neboQuickToolControl.setColorCircle(imageView, neboQuickToolControl.pendingPickerColor);
                    }
                    SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = NeboQuickToolControl.this.attrLayout;
                    if (spenSettingQTAttributesLayout != null) {
                        spenSettingQTAttributesLayout.setColor(NeboQuickToolControl.this.pendingPickerColor);
                    }
                }
            });
            spenSettingQTColorPickerLayout2.setVisibility(8);
            SpenSettingQTLayout spenSettingQTLayout = this.qtLayout;
            if (spenSettingQTLayout != null) {
                spenSettingQTLayout.addView(spenSettingQTColorPickerLayout2);
            }
            this.colorPickerLayout = spenSettingQTColorPickerLayout2;
            spenSettingQTColorPickerLayout2.setVisibility(0, true);
            return;
        }
        Integer numCurrentInkColor2 = currentInkColor();
        this.pendingPickerColor = (numCurrentInkColor2 != null ? numCurrentInkColor2.intValue() : DEFAULT_INK_COLOR) | (-16777216);
        spenSettingQTColorPickerLayout.setCurrentColor(fArr);
        spenSettingQTColorPickerLayout.setVisibility(0, true);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NeboQuickToolControl$onColorPickerClick$1 */
    /* JADX INFO: compiled from: NeboQuickToolControl.kt */
    @Metadata(m1598d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m1599d2 = {"com/myscript/nebo/editing/NeboQuickToolControl$onColorPickerClick$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorPickerLayout$ActionListener;", "onColorTap", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C63741 implements SpenSettingQTColorPickerLayout.ActionListener {
        final /* synthetic */ SpenSettingQTColorPickerLayout $newPicker;

        C63741(SpenSettingQTColorPickerLayout spenSettingQTColorPickerLayout) {
            this.$newPicker = spenSettingQTColorPickerLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onColorTap$lambda$0(Bundle log) {
            Intrinsics.checkNotNullParameter(log, "$this$log");
            log.putString("action", "custom_color_picked");
            return Unit.INSTANCE;
        }

        @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorPickerLayout.ActionListener
        public void onColorTap() {
            NeboFirebaseEvent.SpenQuickToolAction.log(new Function1() { // from class: com.myscript.nebo.editing.NeboQuickToolControl$onColorPickerClick$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NeboQuickToolControl.C63741.onColorTap$lambda$0((Bundle) obj);
                }
            });
            NeboQuickToolControl.this.toolbarViewModel.addColor(NeboQuickToolControl.this.pendingPickerColor);
            this.$newPicker.setVisibility(8, true);
            NeboQuickToolControl.this.setEdgeViewsVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyThickness(float thicknessRatio) {
        ToolConfiguration toolConfigurationFindToolConfigurationByType = this.toolbarViewModel.findToolConfigurationByType(this.currentToolType);
        if (toolConfigurationFindToolConfigurationByType == null) {
            return;
        }
        ToolConfiguration toolConfiguration = new ToolConfiguration(this.currentToolType, toolConfigurationFindToolConfigurationByType.getColor2(), thicknessRatio);
        String property = toolConfigurationFindToolConfigurationByType.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER);
        Intrinsics.checkNotNull(property);
        if (property.length() > 0) {
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER, property);
        }
        String property2 = toolConfigurationFindToolConfigurationByType.getProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY);
        Intrinsics.checkNotNull(property2);
        if (property2.length() > 0) {
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY, property2);
        }
        String property3 = toolConfigurationFindToolConfigurationByType.getProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY);
        Intrinsics.checkNotNull(property3);
        if (property3.length() > 0) {
            toolConfiguration.setProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY, property3);
        }
        this.toolbarViewModel.applyToolConfiguration(toolConfiguration);
    }

    private final ImageView buildIconView(int drawableRes) {
        ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
        imageView.setImageResource(drawableRes);
        return imageView;
    }

    private final ImageView buildColorView() {
        ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int iDpToPx = dpToPx(10);
        imageView.setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        if (this.currentNoColorSelected) {
            imageView.setImageResource(C6693R.drawable.ic_none_color);
            return imageView;
        }
        Integer numCurrentInkColor = currentInkColor();
        imageView.setImageDrawable(makeColorCircle(numCurrentInkColor != null ? numCurrentInkColor.intValue() : DEFAULT_INK_COLOR));
        return imageView;
    }

    private final ImageView buildSizeView(int sizePx) {
        ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        updateSizeView(imageView, sizePx);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setColorCircle(ImageView view, int color) {
        view.setImageDrawable(makeColorCircle(color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSizeView(ImageView view, int sizePx) {
        Integer numCurrentInkColor;
        if (view == null) {
            return;
        }
        int iNeutralIconColor = (!hasEffectiveColor() || (numCurrentInkColor = currentInkColor()) == null) ? neutralIconColor() : numCurrentInkColor.intValue();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(iNeutralIconColor);
        float f = sizePx / 2.0f;
        canvas.drawCircle(f, f, 0.7f * f * RangesKt.coerceIn(this.currentSizeLevel * 0.01f, 0.1f, 1.0f), paint);
        view.setImageBitmap(bitmapCreateBitmap);
    }

    private final GradientDrawable makeColorCircle(int color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(color | (-16777216));
        return gradientDrawable;
    }

    private final List<SpenSettingQTColorDialLayout.ColorDialItem> buildDialItems() {
        List<ColorPill> list = this.snapshotColors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ColorPill colorPill : list) {
            arrayList.add(new SpenSettingQTColorDialLayout.ColorDialItem(SpenSettingQTColorDialLayout.DialItemType.COLOR, colorPill.getDisplayedColor(), String.valueOf(colorPill.getIndex())));
        }
        return arrayList;
    }

    private final List<SpenSettingQTColorDialLayout.FixedItem> buildFixedItems() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (this.currentToolType == ToolType.Highlighter) {
            listCreateListBuilder.add(new SpenSettingQTColorDialLayout.FixedItem(C6693R.drawable.ic_none_color, 0, NO_COLOR_TAG));
        }
        listCreateListBuilder.add(new SpenSettingQTColorDialLayout.FixedItem(C6693R.drawable.ic_color_add_w28, 0, "colorPicker"));
        return CollectionsKt.build(listCreateListBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEdgeViewsVisible(boolean visible) {
        int i = visible ? 0 : 8;
        ImageView imageView = this.colorView;
        if (imageView != null) {
            imageView.setVisibility((visible && ToolbarConfigurationExt.isWritingTool(this.currentToolType)) ? 0 : 8);
        }
        ImageView imageView2 = this.sizeView;
        if (imageView2 != null) {
            imageView2.setVisibility(i);
        }
        ImageView imageView3 = this.eraserView;
        if (imageView3 != null) {
            imageView3.setVisibility(i);
        }
        ImageView imageView4 = this.highlighterView;
        if (imageView4 != null) {
            imageView4.setVisibility(i);
        }
        ImageView imageView5 = this.penView;
        if (imageView5 != null) {
            imageView5.setVisibility(i);
        }
        ImageView imageView6 = this.undoView;
        if (imageView6 != null) {
            imageView6.setVisibility(i);
        }
        ImageView imageView7 = this.redoView;
        if (imageView7 != null) {
            imageView7.setVisibility(i);
        }
    }

    private final void applyAttrMaxDots() {
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout;
        if (this.toolThicknessRatios.size() == 6 && (spenSettingQTAttributesLayout = this.attrLayout) != null) {
            try {
                Field declaredField = SpenSettingQTAttributesLayout.class.getDeclaredField("mSizeView");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(spenSettingQTAttributesLayout);
                if (obj == null) {
                    return;
                }
                Field declaredField2 = obj.getClass().getDeclaredField("mCircularDotDrawable");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 == null) {
                    return;
                }
                Field declaredField3 = obj2.getClass().getDeclaredField("mItemSizes");
                declaredField3.setAccessible(true);
                Object obj3 = declaredField3.get(obj2);
                float[] fArr = obj3 instanceof float[] ? (float[]) obj3 : null;
                if (fArr == null) {
                    return;
                }
                if (fArr.length >= 10) {
                    fArr[1] = 0.0f;
                    fArr[3] = 0.0f;
                    fArr[5] = 0.0f;
                    fArr[7] = 0.0f;
                    fArr[9] = 0.0f;
                }
                Drawable drawable = obj2 instanceof Drawable ? (Drawable) obj2 : null;
                if (drawable != null) {
                    drawable.invalidateSelf();
                }
            } catch (Exception e) {
                Log.w(TAG, "applyAttrMaxDots: reflection failed — SDK structure may have changed", e);
            }
        }
    }

    private final int themeColor(int attrRes, int fallback) {
        TypedValue typedValue = new TypedValue();
        this.context.getTheme().resolveAttribute(attrRes, typedValue, true);
        return (typedValue.type < 28 || typedValue.type > 31) ? fallback : typedValue.data;
    }

    private final int neutralIconColor() {
        return themeColor(android.R.attr.colorControlNormal, NEUTRAL_ICON_COLOR_FALLBACK);
    }

    private final int centerDrawableRes(ToolType toolType, ToolConfiguration toolConfig) {
        String property;
        int i = WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()];
        if (i == 2) {
            if (Intrinsics.areEqual(toolConfig != null ? toolConfig.getProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY) : null, ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART)) {
                return C6693R.drawable.ic_highlighter_smart;
            }
            return C6693R.drawable.ic_highlighter_freehand;
        }
        if (i == 3) {
            if (Intrinsics.areEqual(toolConfig != null ? toolConfig.getProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY) : null, ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_PRECISE)) {
                return C6693R.drawable.ic_eraser_precise;
            }
            return C6693R.drawable.ic_eraser_stroke;
        }
        int stroker = toolConfig != null ? ToolbarConfigurationExt.getStroker(toolConfig) : 0;
        if (toolConfig == null || (property = toolConfig.getProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE)) == null) {
            property = "";
        }
        return ToolConfigurationUIKt.toolDrawableRes(toolType, stroker, property);
    }

    private final boolean hasEffectiveColor() {
        return ToolbarConfigurationExt.isWritingTool(this.currentToolType) && !this.currentNoColorSelected;
    }

    private final void updateColorCircleForTool() {
        ImageView imageView = this.colorView;
        if (imageView == null) {
            return;
        }
        if (!ToolbarConfigurationExt.isWritingTool(this.currentToolType)) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        if (this.currentNoColorSelected) {
            imageView.setImageResource(C6693R.drawable.ic_none_color);
        } else {
            Integer numCurrentInkColor = currentInkColor();
            setColorCircle(imageView, numCurrentInkColor != null ? numCurrentInkColor.intValue() : neutralIconColor());
        }
        imageView.setEnabled(true);
        imageView.setAlpha(1.0f);
    }

    private final void applyCenterTint(ImageView view) {
        Integer numCurrentInkColor = currentInkColor();
        if (numCurrentInkColor != null && hasEffectiveColor()) {
            view.setColorFilter(numCurrentInkColor.intValue() | (-16777216), PorterDuff.Mode.SRC_IN);
        } else {
            view.clearColorFilter();
        }
    }

    private final void updateActiveStates(ToolType toolType) {
        updateToolActiveState(this.penView, toolType == ToolType.Pen);
        updateToolActiveState(this.eraserView, toolType == ToolType.Eraser);
        updateToolActiveState(this.highlighterView, toolType == ToolType.Highlighter);
    }

    private final void updateToolActiveState(ImageView view, boolean active) {
        if (view != null) {
            view.setBackground(active ? makeActiveBackground() : null);
        }
        if (view != null) {
            view.setElevation(active ? dpToPx(4) : 0.0f);
        }
    }

    private final InsetDrawable makeActiveBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(themeColor(C4627R.attr.colorSurface, -1));
        return new InsetDrawable((Drawable) gradientDrawable, dpToPx(4));
    }

    private final Integer currentInkColor() {
        ColorPill colorPill = (ColorPill) CollectionsKt.getOrNull(this.snapshotColors, this.currentColorIndex);
        if (colorPill != null) {
            return Integer.valueOf(colorPill.getDisplayedColor() | (-16777216));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void positionView(View view, float x, float y, View parent) {
        view.setX(RangesKt.coerceIn(x - (view.getWidth() / 2.0f), 0.0f, RangesKt.coerceAtLeast(parent.getWidth() - view.getWidth(), 0.0f)));
        view.setY(RangesKt.coerceIn(y - (view.getHeight() / 2.0f), 0.0f, RangesKt.coerceAtLeast(parent.getHeight() - view.getHeight(), 0.0f)));
    }

    private final int dpToPx(int dp) {
        return (int) ((dp * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final int levelForIndex(int i, int count) {
        if (count <= 1) {
            return 50;
        }
        return MathKt.roundToInt((i / (count - 1)) * 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int snapSizeLevel(int level) {
        Object obj;
        int size = this.toolThicknessRatios.size();
        if (size == 0) {
            return level;
        }
        IntRange intRangeUntil = RangesKt.until(0, size);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(levelForIndex(((IntIterator) it).nextInt(), size)));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            if (it2.hasNext()) {
                int iAbs = Math.abs(((Number) next).intValue() - level);
                do {
                    Object next2 = it2.next();
                    int iAbs2 = Math.abs(((Number) next2).intValue() - level);
                    if (iAbs > iAbs2) {
                        next = next2;
                        iAbs = iAbs2;
                    }
                } while (it2.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Integer num = (Integer) obj;
        return num != null ? num.intValue() : level;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float levelToThickness(int level) {
        Integer num;
        List<Float> list = this.toolThicknessRatios;
        if (list.isEmpty()) {
            return DEFAULT_THICKNESS_RATIO;
        }
        Iterator<Integer> it = CollectionsKt.getIndices(list).iterator();
        if (it.hasNext()) {
            Integer next = it.next();
            if (it.hasNext()) {
                int iAbs = Math.abs(levelForIndex(next.intValue(), list.size()) - level);
                do {
                    Integer next2 = it.next();
                    int iAbs2 = Math.abs(levelForIndex(next2.intValue(), list.size()) - level);
                    if (iAbs > iAbs2) {
                        next = next2;
                        iAbs = iAbs2;
                    }
                } while (it.hasNext());
            }
            num = next;
        } else {
            num = null;
        }
        Integer num2 = num;
        return list.get(num2 != null ? num2.intValue() : 0).floatValue();
    }

    private final int thicknessToLevel(float ratio) {
        Integer num;
        List<Float> list = this.toolThicknessRatios;
        if (list.isEmpty()) {
            return 50;
        }
        Iterator<Float> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Math.abs(it.next().floatValue() - ratio) < 0.001f) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return levelForIndex(i, list.size());
        }
        Iterator<Integer> it2 = CollectionsKt.getIndices(list).iterator();
        if (it2.hasNext()) {
            Integer next = it2.next();
            if (it2.hasNext()) {
                float fAbs = Math.abs(list.get(next.intValue()).floatValue() - ratio);
                do {
                    Integer next2 = it2.next();
                    float fAbs2 = Math.abs(list.get(next2.intValue()).floatValue() - ratio);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it2.hasNext());
            }
            num = next;
        } else {
            num = null;
        }
        Integer num2 = num;
        return levelForIndex(num2 != null ? num2.intValue() : 0, list.size());
    }

    private final void installWindowTouchDismiss() {
        Window window = this.context.getWindow();
        Window.Callback callback = window.getCallback();
        if (callback != null && this.originalWindowCallback == null) {
            this.originalWindowCallback = callback;
            window.setCallback(new Window.Callback(callback, this) { // from class: com.myscript.nebo.editing.NeboQuickToolControl.installWindowTouchDismiss.1
                private final /* synthetic */ Window.Callback $$delegate_0;
                final /* synthetic */ Window.Callback $original;
                final /* synthetic */ NeboQuickToolControl this$0;

                @Override // android.view.Window.Callback
                public boolean dispatchGenericMotionEvent(MotionEvent p0) {
                    return this.$$delegate_0.dispatchGenericMotionEvent(p0);
                }

                @Override // android.view.Window.Callback
                public boolean dispatchKeyEvent(KeyEvent p0) {
                    return this.$$delegate_0.dispatchKeyEvent(p0);
                }

                @Override // android.view.Window.Callback
                public boolean dispatchKeyShortcutEvent(KeyEvent p0) {
                    return this.$$delegate_0.dispatchKeyShortcutEvent(p0);
                }

                @Override // android.view.Window.Callback
                public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent p0) {
                    return this.$$delegate_0.dispatchPopulateAccessibilityEvent(p0);
                }

                @Override // android.view.Window.Callback
                public boolean dispatchTrackballEvent(MotionEvent p0) {
                    return this.$$delegate_0.dispatchTrackballEvent(p0);
                }

                @Override // android.view.Window.Callback
                public void onActionModeFinished(ActionMode p0) {
                    this.$$delegate_0.onActionModeFinished(p0);
                }

                @Override // android.view.Window.Callback
                public void onActionModeStarted(ActionMode p0) {
                    this.$$delegate_0.onActionModeStarted(p0);
                }

                @Override // android.view.Window.Callback
                public void onAttachedToWindow() {
                    this.$$delegate_0.onAttachedToWindow();
                }

                @Override // android.view.Window.Callback
                public void onContentChanged() {
                    this.$$delegate_0.onContentChanged();
                }

                @Override // android.view.Window.Callback
                public boolean onCreatePanelMenu(int p0, Menu p1) {
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    return this.$$delegate_0.onCreatePanelMenu(p0, p1);
                }

                @Override // android.view.Window.Callback
                public View onCreatePanelView(int p0) {
                    return this.$$delegate_0.onCreatePanelView(p0);
                }

                @Override // android.view.Window.Callback
                public void onDetachedFromWindow() {
                    this.$$delegate_0.onDetachedFromWindow();
                }

                @Override // android.view.Window.Callback
                public boolean onMenuItemSelected(int p0, MenuItem p1) {
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    return this.$$delegate_0.onMenuItemSelected(p0, p1);
                }

                @Override // android.view.Window.Callback
                public boolean onMenuOpened(int p0, Menu p1) {
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    return this.$$delegate_0.onMenuOpened(p0, p1);
                }

                @Override // android.view.Window.Callback
                public void onPanelClosed(int p0, Menu p1) {
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    this.$$delegate_0.onPanelClosed(p0, p1);
                }

                @Override // android.view.Window.Callback
                public boolean onPreparePanel(int p0, View p1, Menu p2) {
                    Intrinsics.checkNotNullParameter(p2, "p2");
                    return this.$$delegate_0.onPreparePanel(p0, p1, p2);
                }

                @Override // android.view.Window.Callback
                public boolean onSearchRequested() {
                    return this.$$delegate_0.onSearchRequested();
                }

                @Override // android.view.Window.Callback
                public boolean onSearchRequested(SearchEvent p0) {
                    return this.$$delegate_0.onSearchRequested(p0);
                }

                @Override // android.view.Window.Callback
                public void onWindowAttributesChanged(WindowManager.LayoutParams p0) {
                    this.$$delegate_0.onWindowAttributesChanged(p0);
                }

                @Override // android.view.Window.Callback
                public void onWindowFocusChanged(boolean p0) {
                    this.$$delegate_0.onWindowFocusChanged(p0);
                }

                @Override // android.view.Window.Callback
                public ActionMode onWindowStartingActionMode(ActionMode.Callback p0) {
                    return this.$$delegate_0.onWindowStartingActionMode(p0);
                }

                @Override // android.view.Window.Callback
                public ActionMode onWindowStartingActionMode(ActionMode.Callback p0, int p1) {
                    return this.$$delegate_0.onWindowStartingActionMode(p0, p1);
                }

                {
                    this.$original = callback;
                    this.this$0 = this;
                    this.$$delegate_0 = callback;
                }

                @Override // android.view.Window.Callback
                public boolean dispatchTouchEvent(MotionEvent event) {
                    if (event != null && event.getAction() == 0 && this.this$0.isVisible()) {
                        this.this$0.editingLayout.getGlobalVisibleRect(this.this$0.hitRect);
                        if (!this.this$0.hitRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                            this.this$0.hide();
                        }
                    }
                    return this.$original.dispatchTouchEvent(event);
                }
            });
        }
    }

    private final void restoreWindowCallback() {
        Window.Callback callback = this.originalWindowCallback;
        if (callback != null) {
            this.context.getWindow().setCallback(callback);
        }
        this.originalWindowCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanup() {
        this.isDismissing = false;
        restoreWindowCallback();
        SpenSettingQTAttributesLayout spenSettingQTAttributesLayout = this.attrLayout;
        if (spenSettingQTAttributesLayout != null) {
            spenSettingQTAttributesLayout.close();
        }
        this.attrLayout = null;
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.colorDial;
        if (spenSettingQTColorDialLayout != null) {
            spenSettingQTColorDialLayout.close();
        }
        this.colorDial = null;
        SpenSettingQTColorPickerLayout spenSettingQTColorPickerLayout = this.colorPickerLayout;
        if (spenSettingQTColorPickerLayout != null) {
            spenSettingQTColorPickerLayout.close();
        }
        this.colorPickerLayout = null;
        SpenSettingQTLayout spenSettingQTLayout = this.qtLayout;
        if (spenSettingQTLayout != null) {
            spenSettingQTLayout.close();
        }
        this.qtLayout = null;
        if (this.overlayGestureActive) {
            this.overlayPendingRemoval = this.overlayView;
        } else {
            FrameLayout frameLayout = this.overlayView;
            if (frameLayout != null) {
                ViewParent parent = frameLayout.getParent();
                ViewGroup viewGroup = this.editingLayout;
                if (parent == viewGroup) {
                    viewGroup.removeView(frameLayout);
                }
            }
        }
        this.overlayView = null;
        this.centerAreaRef = null;
        this.centerImageRef = null;
        this.colorView = null;
        this.sizeView = null;
        this.eraserView = null;
        this.highlighterView = null;
        this.penView = null;
        this.undoView = null;
        this.redoView = null;
        this.snapshotColors = CollectionsKt.emptyList();
        this.toolThicknessRatios = CollectionsKt.emptyList();
        this.pendingPickerColor = 0;
        this.suppressDialCallback = false;
        this.suppressSizeCallback = false;
        this.currentNoColorSelected = false;
    }

    /* JADX INFO: compiled from: NeboQuickToolControl.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/editing/NeboQuickToolControl$Companion;", "", "<init>", "()V", "TAG", "", "NO_COLOR_TAG", "ICON_SIZE_DP", "", "CENTER_SIZE_DP", "ICON_PADDING_DP", "COLOR_PADDING_DP", "ACTIVE_BACKGROUND_INSET_DP", "DEFAULT_SIZE_VIEW_DP", "DEFAULT_THICKNESS_RATIO", "", "DEFAULT_SIZE_LEVEL", "SIZE_DOT_MAX_RADIUS_FRACTION", "SIZE_DOT_MIN_SCALE", "ALPHA_OPAQUE", "NEUTRAL_ICON_COLOR_FALLBACK", "DEFAULT_INK_COLOR", "isToolSupported", "", "toolType", "Lcom/myscript/snt/core/ToolType;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isToolSupported(ToolType toolType) {
            return toolType == ToolType.Pen || toolType == ToolType.Highlighter || toolType == ToolType.Eraser;
        }
    }
}
