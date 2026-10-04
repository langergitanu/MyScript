package com.myscript.nebo.penpanel;

import android.graphics.Color;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ColorExt;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.IdentityColorInversionPolicy;
import com.myscript.nebo.common.ColorPolicyRepository;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolPropertyExt;
import com.myscript.snt.core.ToolType;
import com.myscript.snt.core.ToolbarConfiguration;
import com.myscript.snt.core.ToolbarConfigurationExt;
import com.myscript.snt.core.ToolbarController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ToolbarViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 z2\u00020\u0001:\u0001zB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ6\u0010C\u001a\u00020D2'\u0010E\u001a#\b\u0001\u0012\u0004\u0012\u00020B\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0G\u0012\u0006\u0012\u0004\u0018\u00010H0F¢\u0006\u0002\bIH\u0002¢\u0006\u0002\u0010JJ\u0006\u0010M\u001a\u00020DJ\u0006\u0010N\u001a\u00020DJ&\u0010O\u001a\u00020D2\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010P\u001a\u00020LH\u0002J\u000e\u0010S\u001a\u00020D2\u0006\u0010A\u001a\u00020BJ\u0006\u0010T\u001a\u00020DJ\b\u0010U\u001a\u00020DH\u0017J\u0010\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020)H\u0002J*\u0010X\u001a\u00020D2\u0006\u0010Y\u001a\u00020\u00102\u000e\b\u0001\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00100\u00172\b\b\u0002\u0010P\u001a\u00020LH\u0002J\u0016\u0010[\u001a\u00020D2\u000e\b\u0001\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017J\u000e\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0010J\u0010\u0010^\u001a\u00020D2\b\b\u0001\u0010_\u001a\u00020\u0010J\u000e\u0010`\u001a\u00020D2\u0006\u0010]\u001a\u00020\u0010J\u0010\u0010a\u001a\u00020D2\b\b\u0001\u0010_\u001a\u00020\u0010J\u0006\u0010b\u001a\u00020DJ\u0012\u0010c\u001a\u00020\u00102\b\b\u0003\u0010_\u001a\u00020\u0010H\u0007J\u0006\u0010d\u001a\u00020\u0010J\u0010\u0010e\u001a\u00020D2\b\b\u0001\u0010_\u001a\u00020\u0010J\u0016\u0010f\u001a\u00020D2\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u0010J\u0016\u0010i\u001a\u00020D2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020D0kH\u0002J\u000e\u0010l\u001a\u00020D2\u0006\u0010W\u001a\u00020)J\u000e\u0010m\u001a\u00020D2\u0006\u0010n\u001a\u000206J\u000e\u0010o\u001a\u00020D2\u0006\u0010W\u001a\u00020)J\u0012\u0010p\u001a\u00020D2\b\b\u0001\u0010_\u001a\u00020\u0010H\u0002J\u0006\u0010q\u001a\u00020LJ\u0006\u0010r\u001a\u000206J\u0010\u0010s\u001a\u0004\u0018\u00010)2\u0006\u0010n\u001a\u000206J\u0014\u0010t\u001a\b\u0012\u0004\u0012\u00020u0\u00172\u0006\u0010n\u001a\u000206J\u0006\u0010v\u001a\u00020DJ\u0014\u0010w\u001a\u0004\u0018\u00010)2\b\b\u0001\u0010x\u001a\u00020\u0010H\u0002J\u0010\u0010y\u001a\u00020D2\b\b\u0001\u0010_\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00178\u0002@BX\u0083\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00108CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00170\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00170!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0!8F¢\u0006\u0006\u001a\u0004\b'\u0010#R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0!8F¢\u0006\u0006\u001a\u0004\b+\u0010#R\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00170\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010.\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020- /*\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00170\u00170!¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002020!8F¢\u0006\u0006\u001a\u0004\b4\u0010#R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001e¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R(\u0010;\u001a\u000706¢\u0006\u0002\b:2\u000b\u0010\u0016\u001a\u000706¢\u0006\u0002\b:@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b<\u0010=R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010?\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\u00100\u00100!¢\u0006\b\n\u0000\u001a\u0004\b@\u0010#R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006{"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolbarViewModel;", "Landroidx/lifecycle/ViewModel;", "inkSettings", "Lcom/myscript/nebo/penpanel/InkSettings;", "writingSettings", "Lcom/myscript/nebo/penpanel/WritingSettings;", "contentType", "", "colorPolicyRepository", "Lcom/myscript/nebo/common/ColorPolicyRepository;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "workDispatcher", "<init>", "(Lcom/myscript/nebo/penpanel/InkSettings;Lcom/myscript/nebo/penpanel/WritingSettings;Ljava/lang/String;Lcom/myscript/nebo/common/ColorPolicyRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "currentPageBackgroundColor", "", "selectedColorIndex", "getSelectedColorIndex", "()I", "setSelectedColorIndex", "(I)V", "value", "", "rawColors", "setRawColors", "(Ljava/util/List;)V", "selectedColorInList", "getSelectedColorInList", "_colors", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/penpanel/ColorPill;", "colors", "Landroidx/lifecycle/LiveData;", "getColors", "()Landroidx/lifecycle/LiveData;", "_toolbarConfiguration", "Lcom/myscript/snt/core/ToolbarConfiguration;", "toolbarConfiguration", "getToolbarConfiguration", "_appliedToolConfig", "Lcom/myscript/snt/core/ToolConfiguration;", "appliedToolConfig", "getAppliedToolConfig", "_tools", "Lcom/myscript/nebo/penpanel/ToolPill;", "tools", "kotlin.jvm.PlatformType", "getTools", "_colorNone", "Lcom/myscript/nebo/penpanel/ColorNonePill;", "colorNone", "getColorNone", "_selectedToolType", "Lcom/myscript/snt/core/ToolType;", "selectedToolType", "getSelectedToolType", "()Landroidx/lifecycle/MutableLiveData;", "Lorg/jspecify/annotations/Nullable;", "previouslySelectedToolType", "setPreviouslySelectedToolType", "(Lcom/myscript/snt/core/ToolType;)V", "_selectedColor", "selectedColor", "getSelectedColor", "pageController", "Lcom/myscript/snt/core/PageController;", "runOnPageController", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "canInvertColors", "", "switchToPreviousTool", "switchBetweenEraserAndPreviousTool", "updateToolbarState", "colorPolicyChanged", "onCurrentToolChanged", "Lcom/myscript/nebo/penpanel/ToolbarConfigurationListener;", "bindPageController", "unbindPageController", "onCleared", "toolAsToolPill", "toolConfiguration", "updateColorList", "newSelectedIndex", "newColors", "resetColors", "selectColorAt", FirebaseAnalytics.Param.INDEX, "selectColor", "color", "removeColorAt", "removeColor", "removeSelectedColor", "addColor", "duplicateSelectedColor", "updateSelectedColor", "moveColor", "fromPosition", "toPosition", "colorsStateUpdate", "updateLogic", "Lkotlin/Function0;", "saveSelectedColor", "changeTool", "toolType", "applyToolConfiguration", "applyColor", "canSelectColor", "getSelectedToolTypeValue", "findToolConfigurationByType", "availableThicknessRatios", "", "activateNoneColor", "configureNoneColor", "feedbackColor", "setPageBackgroundColor", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolbarViewModel extends ViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int UNSELECTED = -1;
    private final MutableLiveData<ToolConfiguration> _appliedToolConfig;
    private final MutableLiveData<ColorNonePill> _colorNone;
    private final MutableLiveData<List<ColorPill>> _colors;
    private final MutableLiveData<Integer> _selectedColor;
    private final MutableLiveData<ToolType> _selectedToolType;
    private final MutableLiveData<ToolbarConfiguration> _toolbarConfiguration;
    private final MutableLiveData<List<ToolPill>> _tools;
    private final boolean canInvertColors;
    private final ColorPolicyRepository colorPolicyRepository;
    private int currentPageBackgroundColor;
    private final InkSettings inkSettings;
    private final CoroutineDispatcher mainDispatcher;
    private final ToolbarConfigurationListener onCurrentToolChanged;
    private PageController pageController;
    private ToolType previouslySelectedToolType;
    private List<Integer> rawColors;
    private final LiveData<Integer> selectedColor;
    private int selectedColorIndex;
    private final MutableLiveData<ToolType> selectedToolType;
    private final LiveData<List<ToolPill>> tools;
    private final CoroutineDispatcher workDispatcher;
    private final WritingSettings writingSettings;

    /* JADX INFO: compiled from: ToolbarViewModel.kt */
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

    public final int addColor() {
        return addColor$default(this, 0, 1, null);
    }

    public ToolbarViewModel(InkSettings inkSettings, WritingSettings writingSettings, String contentType, ColorPolicyRepository colorPolicyRepository, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workDispatcher) {
        Intrinsics.checkNotNullParameter(inkSettings, "inkSettings");
        Intrinsics.checkNotNullParameter(writingSettings, "writingSettings");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(colorPolicyRepository, "colorPolicyRepository");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.inkSettings = inkSettings;
        this.writingSettings = writingSettings;
        this.colorPolicyRepository = colorPolicyRepository;
        this.mainDispatcher = mainDispatcher;
        this.workDispatcher = workDispatcher;
        this.currentPageBackgroundColor = -1;
        this.selectedColorIndex = -1;
        this.rawColors = CollectionsKt.toList(inkSettings.getColors());
        this._colors = new MutableLiveData<>();
        this._toolbarConfiguration = new MutableLiveData<>();
        this._appliedToolConfig = new MutableLiveData<>();
        MutableLiveData<List<ToolPill>> mutableLiveData = new MutableLiveData<>();
        this._tools = mutableLiveData;
        this.tools = Transformations.distinctUntilChanged(mutableLiveData);
        this._colorNone = new MutableLiveData<>();
        MutableLiveData<ToolType> mutableLiveData2 = new MutableLiveData<>();
        this._selectedToolType = mutableLiveData2;
        this.selectedToolType = mutableLiveData2;
        ToolType value = mutableLiveData2.getValue();
        this.previouslySelectedToolType = value == null ? ToolType.None : value;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this._selectedColor = mutableLiveData3;
        this.selectedColor = Transformations.distinctUntilChanged(mutableLiveData3);
        this.canInvertColors = !Intrinsics.areEqual(contentType, ContentTypes.PDF);
        updateColorList$default(this, this.selectedColorIndex, CollectionsKt.toList(inkSettings.getColors()), false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), mainDispatcher, null, new C67061(null), 2, null);
        ToolConfiguration toolConfigurationFindToolByType = writingSettings.findToolByType(ToolType.Pen);
        if (toolConfigurationFindToolByType == null) {
            throw new IllegalStateException("A Pen MUST be defined in WritingSettings".toString());
        }
        ToolbarConfiguration defaultToolbarConfiguration = ToolbarController.getDefaultToolbarConfiguration(contentType, writingSettings.isActivePenModeEnabled(), toolConfigurationFindToolByType);
        Intrinsics.checkNotNull(defaultToolbarConfiguration);
        updateToolbarState$default(this, defaultToolbarConfiguration, writingSettings, false, 4, null);
        this.onCurrentToolChanged = new ToolbarConfigurationListener(new Function1() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToolbarViewModel.onCurrentToolChanged$lambda$0(this.f$0, (ToolbarConfiguration) obj);
            }
        });
    }

    public /* synthetic */ ToolbarViewModel(InkSettings inkSettings, WritingSettings writingSettings, String str, ColorPolicyRepository colorPolicyRepository, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(inkSettings, writingSettings, str, colorPolicyRepository, (i & 16) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 32) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    public final int getSelectedColorIndex() {
        return this.selectedColorIndex;
    }

    public final void setSelectedColorIndex(int i) {
        this.selectedColorIndex = i;
    }

    private final void setRawColors(List<Integer> list) {
        if (!Intrinsics.areEqual(this.rawColors, list)) {
            list = ColorExt.asOpaqueColors(list);
        }
        this.rawColors = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSelectedColorInList() {
        int i = this.selectedColorIndex;
        if (i != -1) {
            return this.rawColors.get(i).intValue();
        }
        return 0;
    }

    public final LiveData<List<ColorPill>> getColors() {
        return Transformations.distinctUntilChanged(this._colors);
    }

    public final LiveData<ToolbarConfiguration> getToolbarConfiguration() {
        return this._toolbarConfiguration;
    }

    public final LiveData<ToolConfiguration> getAppliedToolConfig() {
        return this._appliedToolConfig;
    }

    public final LiveData<List<ToolPill>> getTools() {
        return this.tools;
    }

    public final LiveData<ColorNonePill> getColorNone() {
        return this._colorNone;
    }

    public final MutableLiveData<ToolType> getSelectedToolType() {
        return this.selectedToolType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreviouslySelectedToolType(ToolType toolType) {
        if (this.previouslySelectedToolType != toolType) {
            this.previouslySelectedToolType = toolType;
        }
    }

    public final LiveData<Integer> getSelectedColor() {
        return this.selectedColor;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$runOnPageController$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$runOnPageController$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {162}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {163}, m1615s = {}, m1616v = 2)
    static final class C67141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PageController, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ PageController $pc;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C67141(Function2<? super PageController, ? super Continuation<? super Unit>, ? extends Object> function2, PageController pageController, Continuation<? super C67141> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$pc = pageController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67141(this.$block, this.$pc, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<PageController, Continuation<? super Unit>, Object> function2 = this.$block;
                PageController pageController = this.$pc;
                this.label = 1;
                if (function2.invoke(pageController, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void runOnPageController(Function2<? super PageController, ? super Continuation<? super Unit>, ? extends Object> block) {
        PageController pageController = this.pageController;
        if (pageController == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.workDispatcher, null, new C67141(block, pageController, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {172}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {177}, m1615s = {}, m1616v = 2)
    static final class C67061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67061(Continuation<? super C67061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ToolbarViewModel.this.new C67061(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowAsFlow = FlowLiveDataConversions.asFlow(ToolbarViewModel.this.colorPolicyRepository.getColorPolicy());
                final ToolbarViewModel toolbarViewModel = ToolbarViewModel.this;
                this.label = 1;
                if (flowAsFlow.collect(new FlowCollector() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((IColorInversionPolicy) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(IColorInversionPolicy iColorInversionPolicy, Continuation<? super Unit> continuation) {
                        ToolbarConfiguration value = toolbarViewModel.getToolbarConfiguration().getValue();
                        if (value == null) {
                            return Unit.INSTANCE;
                        }
                        toolbarViewModel.updateToolbarState(value, null, true);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ToolbarViewModel.this._selectedToolType.setValue(ToolType.None);
            ToolbarViewModel.this.setPreviouslySelectedToolType(ToolType.None);
            ToolbarViewModel.this._selectedColor.setValue(Boxing.boxInt(0));
            return Unit.INSTANCE;
        }
    }

    public final void switchToPreviousTool() {
        if (this.previouslySelectedToolType != ToolType.None) {
            changeTool(this.previouslySelectedToolType);
        }
    }

    public final void switchBetweenEraserAndPreviousTool() {
        if (ToolType.Eraser == this._selectedToolType.getValue()) {
            changeTool(this.previouslySelectedToolType);
        } else {
            changeTool(ToolType.Eraser);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$updateToolbarState$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$updateToolbarState$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $colorPolicyChanged;
        final /* synthetic */ ToolbarConfiguration $toolbarConfiguration;
        final /* synthetic */ WritingSettings $writingSettings;
        int label;
        final /* synthetic */ ToolbarViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67181(ToolbarConfiguration toolbarConfiguration, ToolbarViewModel toolbarViewModel, WritingSettings writingSettings, boolean z, Continuation<? super C67181> continuation) {
            super(2, continuation);
            this.$toolbarConfiguration = toolbarConfiguration;
            this.this$0 = toolbarViewModel;
            this.$writingSettings = writingSettings;
            this.$colorPolicyChanged = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67181(this.$toolbarConfiguration, this.this$0, this.$writingSettings, this.$colorPolicyChanged, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            ToolConfiguration toolConfigurationFindToolByType;
            Object next;
            String property;
            ToolType selectedToolType;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ToolType selectedToolType2 = this.$toolbarConfiguration.getSelectedToolType();
            ToolbarConfiguration toolbarConfiguration = (ToolbarConfiguration) this.this$0._toolbarConfiguration.getValue();
            Integer numBoxInt = null;
            if (selectedToolType2 != (toolbarConfiguration != null ? toolbarConfiguration.getSelectedToolType() : null)) {
                ToolbarViewModel toolbarViewModel = this.this$0;
                ToolbarConfiguration toolbarConfiguration2 = (ToolbarConfiguration) toolbarViewModel._toolbarConfiguration.getValue();
                if (toolbarConfiguration2 == null || (selectedToolType = toolbarConfiguration2.getSelectedToolType()) == null) {
                    selectedToolType = ToolType.None;
                }
                toolbarViewModel.setPreviouslySelectedToolType(selectedToolType);
            }
            this.this$0._toolbarConfiguration.setValue(this.$toolbarConfiguration);
            List<ToolConfiguration> listOfTools = ToolbarConfigurationExt.getListOfTools(this.$toolbarConfiguration);
            if (this.$writingSettings != null) {
                Iterator<T> it = listOfTools.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((ToolConfiguration) next).getType() == ToolType.Highlighter) {
                        break;
                    }
                }
                ToolConfiguration toolConfiguration = (ToolConfiguration) next;
                ToolConfiguration toolConfigurationFindToolByType2 = this.$writingSettings.findToolByType(ToolType.Highlighter);
                if (toolConfiguration != null && toolConfigurationFindToolByType2 != null) {
                    toolConfiguration.setColor(toolConfigurationFindToolByType2.getColor2());
                    String str = ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR;
                    ToolConfiguration toolConfigurationFindToolByType3 = this.$writingSettings.findToolByType(ToolType.Highlighter);
                    if (toolConfigurationFindToolByType3 == null || (property = toolConfigurationFindToolByType3.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR)) == null) {
                        property = ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_FALSE;
                    }
                    toolConfiguration.setProperty(str, property);
                }
            }
            MutableLiveData mutableLiveData = this.this$0._tools;
            List<ToolConfiguration> listOfTools2 = ToolbarConfigurationExt.getListOfTools(this.$toolbarConfiguration);
            ToolbarViewModel toolbarViewModel2 = this.this$0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOfTools2, 10));
            Iterator<T> it2 = listOfTools2.iterator();
            while (it2.hasNext()) {
                arrayList.add(toolbarViewModel2.toolAsToolPill((ToolConfiguration) it2.next()));
            }
            mutableLiveData.setValue(arrayList);
            ToolbarConfiguration toolbarConfiguration3 = this.$toolbarConfiguration;
            ToolType selectedToolType3 = toolbarConfiguration3.getSelectedToolType();
            Intrinsics.checkNotNullExpressionValue(selectedToolType3, "getSelectedToolType(...)");
            ToolConfiguration toolConfigurationFindToolByType4 = ToolbarConfigurationExt.findToolByType(toolbarConfiguration3, selectedToolType3);
            boolean zAreEqual = Intrinsics.areEqual(toolConfigurationFindToolByType4 != null ? toolConfigurationFindToolByType4.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR) : null, ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_TRUE);
            boolean z = false;
            int selectedColor = zAreEqual ? 0 : this.$toolbarConfiguration.getSelectedColor();
            this.this$0._selectedColor.setValue(Boxing.boxInt(selectedColor));
            int opaque = ColorExt.getOpaque(selectedColor);
            ToolType selectedToolType4 = this.$toolbarConfiguration.getSelectedToolType();
            this.this$0._selectedToolType.setValue(selectedToolType4);
            if (!zAreEqual) {
                if (selectedColor != 0) {
                    numBoxInt = Boxing.boxInt(opaque);
                } else if ((selectedToolType4 == ToolType.Pen || selectedToolType4 == ToolType.Highlighter) && (toolConfigurationFindToolByType = ToolbarConfigurationExt.findToolByType(this.$toolbarConfiguration, selectedToolType4)) != null) {
                    numBoxInt = Boxing.boxInt(ColorExt.getOpaque(toolConfigurationFindToolByType.getColor2()));
                }
            }
            int selectedColorIndex = -1;
            if (numBoxInt == null || numBoxInt.intValue() == 0) {
                i = -1;
            } else {
                Iterator it3 = this.this$0.rawColors.iterator();
                i = 0;
                while (it3.hasNext()) {
                    int opaque2 = ColorExt.getOpaque(((Number) it3.next()).intValue());
                    if (numBoxInt != null && opaque2 == numBoxInt.intValue()) {
                        break;
                    }
                    i++;
                }
                i = -1;
            }
            if (i >= 0 && i < this.this$0.rawColors.size()) {
                selectedColorIndex = (numBoxInt == null || this.this$0.getSelectedColorIndex() == -1 || ColorExt.getOpaque(this.this$0.getSelectedColorInList()) != numBoxInt.intValue()) ? i : this.this$0.getSelectedColorIndex();
            }
            ToolbarViewModel toolbarViewModel3 = this.this$0;
            toolbarViewModel3.updateColorList(selectedColorIndex, toolbarViewModel3.rawColors, this.$colorPolicyChanged);
            boolean z2 = selectedToolType4 == ToolType.Highlighter;
            boolean z3 = z2 && !this.$toolbarConfiguration.isPaused();
            if (zAreEqual && selectedToolType4 == ToolType.Highlighter && z3) {
                z = true;
            }
            this.this$0._colorNone.setValue(new ColorNonePill(z2, z, z3));
            return Unit.INSTANCE;
        }
    }

    static /* synthetic */ void updateToolbarState$default(ToolbarViewModel toolbarViewModel, ToolbarConfiguration toolbarConfiguration, WritingSettings writingSettings, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            writingSettings = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        toolbarViewModel.updateToolbarState(toolbarConfiguration, writingSettings, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateToolbarState(ToolbarConfiguration toolbarConfiguration, WritingSettings writingSettings, boolean colorPolicyChanged) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67181(toolbarConfiguration, this, writingSettings, colorPolicyChanged, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCurrentToolChanged$lambda$0(ToolbarViewModel toolbarViewModel, ToolbarConfiguration toolbarConfiguration) {
        if (toolbarConfiguration == null) {
            return Unit.INSTANCE;
        }
        updateToolbarState$default(toolbarViewModel, toolbarConfiguration, null, false, 6, null);
        return Unit.INSTANCE;
    }

    public final void bindPageController(PageController pageController) {
        PageController pageControllerNewRef;
        ToolType selectedToolType;
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        if (this.pageController == null && (pageControllerNewRef = PageController.newRef(pageController)) != null) {
            this.pageController = pageControllerNewRef;
            ToolbarConfiguration value = getToolbarConfiguration().getValue();
            if (value == null || (selectedToolType = value.getSelectedToolType()) == null) {
                selectedToolType = ToolType.None;
            }
            runOnPageController(new C67101(selectedToolType == ToolType.None, this, selectedToolType, null));
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$bindPageController$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/snt/core/PageController;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$bindPageController$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67101 extends SuspendLambda implements Function2<PageController, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $firstTime;
        final /* synthetic */ ToolType $selectedToolType;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ToolbarViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67101(boolean z, ToolbarViewModel toolbarViewModel, ToolType toolType, Continuation<? super C67101> continuation) {
            super(2, continuation);
            this.$firstTime = z;
            this.this$0 = toolbarViewModel;
            this.$selectedToolType = toolType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C67101 c67101 = new C67101(this.$firstTime, this.this$0, this.$selectedToolType, continuation);
            c67101.L$0 = obj;
            return c67101;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PageController pageController, Continuation<? super Unit> continuation) {
            return ((C67101) create(pageController, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            PageController pageController = (PageController) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!this.$firstTime) {
                this.this$0.writingSettings.update();
            }
            List<ToolConfiguration> toolConfigurations = this.this$0.writingSettings.getToolConfigurations();
            ToolbarViewModel toolbarViewModel = this.this$0;
            synchronized (toolConfigurations) {
                list = CollectionsKt.toList(toolbarViewModel.writingSettings.getToolConfigurations());
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                pageController.configureTool((ToolConfiguration) it.next());
            }
            pageController.enableActivePen(this.this$0.writingSettings.isActivePenModeEnabled());
            pageController.setToolbarConfigurationListener(this.this$0.onCurrentToolChanged);
            if (!this.$firstTime) {
                ToolType toolTypeCurrentToolType = pageController.currentToolType();
                ToolType toolType = this.$selectedToolType;
                if (toolTypeCurrentToolType != toolType) {
                    pageController.setTool(toolType);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void unbindPageController() {
        PageController pageController = this.pageController;
        if (pageController == null) {
            return;
        }
        this.pageController = null;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.workDispatcher, null, new C67161(pageController, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$unbindPageController$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$unbindPageController$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageController $pc;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67161(PageController pageController, Continuation<? super C67161> continuation) {
            super(2, continuation);
            this.$pc = pageController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67161(this.$pc, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                this.$pc.setToolbarConfigurationListener(null);
                this.$pc.delete();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.$pc.delete();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$onCleared$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$onCleared$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67131(Continuation<? super C67131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ToolbarViewModel.this.new C67131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ToolbarViewModel.this.setPreviouslySelectedToolType(ToolType.None);
                ToolbarViewModel.this._selectedToolType.setValue(ToolType.None);
                ToolbarViewModel.this._selectedColor.setValue(Boxing.boxInt(0));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67131(null), 2, null);
        this.onCurrentToolChanged.close();
        unbindPageController();
        super.onCleared();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ToolPill toolAsToolPill(ToolConfiguration toolConfiguration) {
        int iInvertColor;
        if (Intrinsics.areEqual(toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR), ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_TRUE)) {
            iInvertColor = 0;
        } else {
            iInvertColor = this.canInvertColors ? this.colorPolicyRepository.invertColor(toolConfiguration.getColor2()) : toolConfiguration.getColor2();
        }
        return new ToolPill(iInvertColor, toolConfiguration);
    }

    static /* synthetic */ void updateColorList$default(ToolbarViewModel toolbarViewModel, int i, List list, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        toolbarViewModel.updateColorList(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColorList(int newSelectedIndex, List<Integer> newColors, boolean colorPolicyChanged) {
        boolean z = true;
        if (newSelectedIndex == this.selectedColorIndex && !colorPolicyChanged && (Intrinsics.areEqual(this.rawColors, newColors) || Arrays.equals(CollectionsKt.toIntArray(newColors), CollectionsKt.toIntArray(this.rawColors)))) {
            z = false;
        }
        this.selectedColorIndex = newSelectedIndex;
        setRawColors(newColors);
        if (z) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67171(null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$updateColorList$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$updateColorList$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67171(Continuation<? super C67171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ToolbarViewModel.this.new C67171(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ToolbarViewModel.this._colors.setValue(ToolbarViewModelKt.toColorPills(ToolbarViewModel.this.rawColors, ToolbarViewModel.this.getSelectedColorIndex(), ToolbarViewModel.this.canInvertColors ? ToolbarViewModel.this.colorPolicyRepository.getColorPolicy().getValue() : new IdentityColorInversionPolicy()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void resetColors(final List<Integer> newColors) {
        Intrinsics.checkNotNullParameter(newColors, "newColors");
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.resetColors$lambda$0(newColors, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetColors$lambda$0(List list, ToolbarViewModel toolbarViewModel) {
        updateColorList$default(toolbarViewModel, list.isEmpty() ? -1 : 0, toolbarViewModel.inkSettings.resetColors(list), false, 4, null);
        return Unit.INSTANCE;
    }

    public final void selectColorAt(final int index) {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.selectColorAt$lambda$0(index, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectColorAt$lambda$0(int i, ToolbarViewModel toolbarViewModel) {
        if (i < 0 || i >= toolbarViewModel.rawColors.size()) {
            i = -1;
        }
        updateColorList$default(toolbarViewModel, i, toolbarViewModel.rawColors, false, 4, null);
        return Unit.INSTANCE;
    }

    public final void selectColor(final int color) {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.selectColor$lambda$0(this.f$0, color);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectColor$lambda$0(ToolbarViewModel toolbarViewModel, int i) {
        if (toolbarViewModel.getSelectedColorInList() != i) {
            toolbarViewModel.selectColorAt(toolbarViewModel.rawColors.indexOf(Integer.valueOf(i)));
        }
        return Unit.INSTANCE;
    }

    public final void removeColorAt(final int index) {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.removeColorAt$lambda$0(index, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeColorAt$lambda$0(int i, ToolbarViewModel toolbarViewModel) {
        if (i >= 0 && i < toolbarViewModel.rawColors.size()) {
            List list = CollectionsKt.toList(toolbarViewModel.inkSettings.removeColorAt(i));
            updateColorList$default(toolbarViewModel, list.isEmpty() ? -1 : RangesKt.coerceIn(toolbarViewModel.selectedColorIndex, (ClosedRange<Integer>) CollectionsKt.getIndices(list)), list, false, 4, null);
        }
        return Unit.INSTANCE;
    }

    public final void removeColor(final int color) {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.removeColor$lambda$0(this.f$0, color);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeColor$lambda$0(ToolbarViewModel toolbarViewModel, int i) {
        toolbarViewModel.removeColorAt(toolbarViewModel.rawColors.indexOf(Integer.valueOf(i)));
        return Unit.INSTANCE;
    }

    public final void removeSelectedColor() {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.removeSelectedColor$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeSelectedColor$lambda$0(ToolbarViewModel toolbarViewModel) {
        toolbarViewModel.removeColorAt(toolbarViewModel.selectedColorIndex);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ int addColor$default(ToolbarViewModel toolbarViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = INSTANCE.getRandomColor();
        }
        return toolbarViewModel.addColor(i);
    }

    public final int addColor(final int color) {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.addColor$lambda$0(this.f$0, color);
            }
        });
        return color;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addColor$lambda$0(ToolbarViewModel toolbarViewModel, int i) {
        updateColorList$default(toolbarViewModel, r2.size() - 1, CollectionsKt.toList(toolbarViewModel.inkSettings.addColor(i)), false, 4, null);
        return Unit.INSTANCE;
    }

    public final int duplicateSelectedColor() {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.duplicateSelectedColor$lambda$0(this.f$0);
            }
        });
        return getSelectedColorInList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit duplicateSelectedColor$lambda$0(ToolbarViewModel toolbarViewModel) {
        updateColorList$default(toolbarViewModel, toolbarViewModel.selectedColorIndex + 1, CollectionsKt.toList(toolbarViewModel.inkSettings.duplicateColorAt(toolbarViewModel.selectedColorIndex)), false, 4, null);
        return Unit.INSTANCE;
    }

    public final void updateSelectedColor(final int color) {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.updateSelectedColor$lambda$0(this.f$0, color);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSelectedColor$lambda$0(ToolbarViewModel toolbarViewModel, int i) {
        updateColorList$default(toolbarViewModel, toolbarViewModel.selectedColorIndex, CollectionsKt.toList(toolbarViewModel.inkSettings.modifyColorAt(i, toolbarViewModel.selectedColorIndex)), false, 4, null);
        return Unit.INSTANCE;
    }

    public final void moveColor(final int fromPosition, final int toPosition) {
        colorsStateUpdate(new Function0() { // from class: com.myscript.nebo.penpanel.ToolbarViewModel$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ToolbarViewModel.moveColor$lambda$0(fromPosition, toPosition, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit moveColor$lambda$0(int i, int i2, ToolbarViewModel toolbarViewModel) {
        int i3;
        if (i == i2) {
            return Unit.INSTANCE;
        }
        int i4 = toolbarViewModel.selectedColorIndex;
        if (i4 == i) {
            i3 = i2;
        } else {
            if (i + 1 <= i4 && i4 <= i2) {
                i4--;
            } else if (i2 <= i4 && i4 <= i - 1) {
                i4++;
            }
            i3 = i4;
        }
        updateColorList$default(toolbarViewModel, i3, CollectionsKt.toList(toolbarViewModel.inkSettings.moveColors(i, i2)), false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$colorsStateUpdate$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$colorsStateUpdate$1", m1609f = "ToolbarViewModel.kt", m1610i = {0, 0}, m1611l = {459}, m1612m = "invokeSuspend", m1613n = {"previousColor", "newColor"}, m1614nl = {463}, m1615s = {"I$0", "I$1"}, m1616v = 2)
    static final class C67121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $updateLogic;
        int I$0;
        int I$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67121(Function0<Unit> function0, Continuation<? super C67121> continuation) {
            super(2, continuation);
            this.$updateLogic = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ToolbarViewModel.this.new C67121(this.$updateLogic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int selectedColorInList = ToolbarViewModel.this.getSelectedColorInList();
                this.$updateLogic.invoke();
                int selectedColorInList2 = ToolbarViewModel.this.getSelectedColorInList();
                if (selectedColorInList != selectedColorInList2) {
                    this.I$0 = selectedColorInList;
                    this.I$1 = selectedColorInList2;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass1(ToolbarViewModel.this, selectedColorInList2, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$colorsStateUpdate$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: ToolbarViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$colorsStateUpdate$1$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $newColor;
            int label;
            final /* synthetic */ ToolbarViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ToolbarViewModel toolbarViewModel, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = toolbarViewModel;
                this.$newColor = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$newColor, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.applyColor(this.$newColor);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void colorsStateUpdate(Function0<Unit> updateLogic) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C67121(updateLogic, null), 2, null);
    }

    public final void saveSelectedColor(ToolConfiguration toolConfiguration) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
        InkSettings inkSettings = this.inkSettings;
        ToolType type = toolConfiguration.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        inkSettings.setSelectedColor(type, toolConfiguration.getColor2());
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$changeTool$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/snt/core/PageController;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$changeTool$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67111 extends SuspendLambda implements Function2<PageController, Continuation<? super Unit>, Object> {
        final /* synthetic */ ToolType $toolType;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ToolbarViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67111(ToolType toolType, ToolbarViewModel toolbarViewModel, Continuation<? super C67111> continuation) {
            super(2, continuation);
            this.$toolType = toolType;
            this.this$0 = toolbarViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C67111 c67111 = new C67111(this.$toolType, this.this$0, continuation);
            c67111.L$0 = obj;
            return c67111;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PageController pageController, Continuation<? super Unit> continuation) {
            return ((C67111) create(pageController, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ToolConfiguration toolConfigurationFindToolConfigurationByType;
            PageController pageController = (PageController) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            pageController.setTool(this.$toolType);
            if (this.$toolType == ToolType.Keyboard) {
                pageController.callKeyboardCallbacksAgain();
            }
            if (this.$toolType == ToolType.Highlighter && (toolConfigurationFindToolConfigurationByType = this.this$0.findToolConfigurationByType(ToolType.Highlighter)) != null) {
                ToolbarViewModel toolbarViewModel = this.this$0;
                if (Intrinsics.areEqual(toolConfigurationFindToolConfigurationByType.getProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR), ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_TRUE)) {
                    toolConfigurationFindToolConfigurationByType.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR, ColorExt.getToHex(ColorExt.getToRGBA(toolbarViewModel.currentPageBackgroundColor)));
                }
                pageController.configureTool(toolConfigurationFindToolConfigurationByType);
            }
            return Unit.INSTANCE;
        }
    }

    public final void changeTool(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        runOnPageController(new C67111(toolType, this, null));
    }

    public final void applyToolConfiguration(ToolConfiguration toolConfiguration) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
        this._appliedToolConfig.setValue(toolConfiguration);
        float thicknessRatio = toolConfiguration.getThicknessRatio();
        InkSettings inkSettings = this.inkSettings;
        ToolType type = toolConfiguration.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        inkSettings.setSelectedThicknessRatio(type, thicknessRatio);
        if (toolConfiguration.getType() == ToolType.Eraser) {
            InkSettings inkSettings2 = this.inkSettings;
            String property = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY);
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
            inkSettings2.setEraserPolicy(property);
        }
        if (toolConfiguration.getType() == ToolType.Pen) {
            InkSettings inkSettings3 = this.inkSettings;
            String property2 = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER);
            Intrinsics.checkNotNullExpressionValue(property2, "getProperty(...)");
            inkSettings3.setPenStroker(property2);
        }
        if (toolConfiguration.getType() == ToolType.Lasso) {
            InkSettings inkSettings4 = this.inkSettings;
            String property3 = toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE);
            Intrinsics.checkNotNullExpressionValue(property3, "getProperty(...)");
            inkSettings4.setLassoShape(property3);
        }
        runOnPageController(new C67091(toolConfiguration, this, null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$applyToolConfiguration$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/snt/core/PageController;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$applyToolConfiguration$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67091 extends SuspendLambda implements Function2<PageController, Continuation<? super Unit>, Object> {
        final /* synthetic */ ToolConfiguration $toolConfiguration;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ToolbarViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67091(ToolConfiguration toolConfiguration, ToolbarViewModel toolbarViewModel, Continuation<? super C67091> continuation) {
            super(2, continuation);
            this.$toolConfiguration = toolConfiguration;
            this.this$0 = toolbarViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C67091 c67091 = new C67091(this.$toolConfiguration, this.this$0, continuation);
            c67091.L$0 = obj;
            return c67091;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PageController pageController, Continuation<? super Unit> continuation) {
            return ((C67091) create(pageController, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PageController pageController = (PageController) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String strPageType = pageController.pageType();
            if (this.$toolConfiguration.getType() == ToolType.Highlighter && (Intrinsics.areEqual(strPageType, ContentTypes.RAW_CONTENT) || Intrinsics.areEqual(strPageType, ContentTypes.PDF))) {
                String property = this.$toolConfiguration.getProperty(ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY);
                if (Intrinsics.areEqual(property, ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH) || Intrinsics.areEqual(property, ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART)) {
                    InkSettings inkSettings = this.this$0.inkSettings;
                    Intrinsics.checkNotNull(property);
                    inkSettings.setHighlighterPolicy(property);
                }
            }
            pageController.configureTool(this.$toolConfiguration);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, com.myscript.snt.core.ToolConfiguration] */
    public final void applyColor(int color) {
        ?? FindToolConfigurationByType;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.selectedToolType.getValue() == ToolType.Highlighter && (FindToolConfigurationByType = findToolConfigurationByType(ToolType.Highlighter)) != 0) {
            String str = ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_FALSE;
            FindToolConfigurationByType.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR, str);
            InkSettings inkSettings = this.inkSettings;
            Intrinsics.checkNotNull(str);
            inkSettings.setHighlighterClearMode(str);
            objectRef.element = FindToolConfigurationByType;
        }
        runOnPageController(new C67082(objectRef, color, null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$applyColor$2 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/snt/core/PageController;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$applyColor$2", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67082 extends SuspendLambda implements Function2<PageController, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $color;
        final /* synthetic */ Ref.ObjectRef<ToolConfiguration> $selectedHighlighterCfg;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67082(Ref.ObjectRef<ToolConfiguration> objectRef, int i, Continuation<? super C67082> continuation) {
            super(2, continuation);
            this.$selectedHighlighterCfg = objectRef;
            this.$color = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C67082 c67082 = new C67082(this.$selectedHighlighterCfg, this.$color, continuation);
            c67082.L$0 = obj;
            return c67082;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PageController pageController, Continuation<? super Unit> continuation) {
            return ((C67082) create(pageController, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PageController pageController = (PageController) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ToolConfiguration toolConfiguration = this.$selectedHighlighterCfg.element;
            if (toolConfiguration != null) {
                pageController.configureTool(toolConfiguration);
            }
            pageController.setColor(this.$color);
            return Unit.INSTANCE;
        }
    }

    public final boolean canSelectColor() {
        ToolbarConfiguration value = getToolbarConfiguration().getValue();
        if (value == null) {
            return false;
        }
        return value.getSelectedToolType() != ToolType.None || value.isPaused();
    }

    public final ToolType getSelectedToolTypeValue() {
        ToolType selectedToolType;
        ToolbarConfiguration value = this._toolbarConfiguration.getValue();
        return (value == null || (selectedToolType = value.getSelectedToolType()) == null) ? ToolType.None : selectedToolType;
    }

    public final ToolConfiguration findToolConfigurationByType(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        return ToolbarConfigurationExt.findToolByType(this._toolbarConfiguration.getValue(), toolType);
    }

    public final List<Float> availableThicknessRatios(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        int i = WhenMappings.$EnumSwitchMapping$0[toolType.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.15f), Float.valueOf(0.25f), Float.valueOf(0.35f), Float.valueOf(0.5f), Float.valueOf(0.7f), Float.valueOf(1.0f)}) : CollectionsKt.emptyList();
    }

    public final void activateNoneColor() {
        ToolConfiguration toolConfigurationConfigureNoneColor = configureNoneColor(this.currentPageBackgroundColor);
        if (toolConfigurationConfigureNoneColor != null) {
            String str = ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR_TRUE;
            toolConfigurationConfigureNoneColor.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_CLEAR, str);
            InkSettings inkSettings = this.inkSettings;
            Intrinsics.checkNotNull(str);
            inkSettings.setHighlighterClearMode(str);
            runOnPageController(new C67071(toolConfigurationConfigureNoneColor, null));
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$activateNoneColor$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/snt/core/PageController;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$activateNoneColor$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67071 extends SuspendLambda implements Function2<PageController, Continuation<? super Unit>, Object> {
        final /* synthetic */ ToolConfiguration $highlighterConfiguration;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67071(ToolConfiguration toolConfiguration, Continuation<? super C67071> continuation) {
            super(2, continuation);
            this.$highlighterConfiguration = toolConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C67071 c67071 = new C67071(this.$highlighterConfiguration, continuation);
            c67071.L$0 = obj;
            return c67071;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PageController pageController, Continuation<? super Unit> continuation) {
            return ((C67071) create(pageController, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PageController pageController = (PageController) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            pageController.configureTool(this.$highlighterConfiguration);
            return Unit.INSTANCE;
        }
    }

    private final ToolConfiguration configureNoneColor(int feedbackColor) {
        ToolConfiguration toolConfigurationFindToolConfigurationByType = findToolConfigurationByType(ToolType.Highlighter);
        if (toolConfigurationFindToolConfigurationByType == null) {
            return null;
        }
        toolConfigurationFindToolConfigurationByType.setProperty(ToolPropertyExt.TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR, ColorExt.getToHex(ColorExt.getToRGBA(feedbackColor)));
        return toolConfigurationFindToolConfigurationByType;
    }

    public final void setPageBackgroundColor(int color) {
        this.currentPageBackgroundColor = color;
        ToolConfiguration toolConfigurationConfigureNoneColor = configureNoneColor(color);
        if (toolConfigurationConfigureNoneColor != null) {
            runOnPageController(new C67151(toolConfigurationConfigureNoneColor, null));
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.ToolbarViewModel$setPageBackgroundColor$1 */
    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/snt/core/PageController;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.penpanel.ToolbarViewModel$setPageBackgroundColor$1", m1609f = "ToolbarViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67151 extends SuspendLambda implements Function2<PageController, Continuation<? super Unit>, Object> {
        final /* synthetic */ ToolConfiguration $highlighterConfiguration;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67151(ToolConfiguration toolConfiguration, Continuation<? super C67151> continuation) {
            super(2, continuation);
            this.$highlighterConfiguration = toolConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C67151 c67151 = new C67151(this.$highlighterConfiguration, continuation);
            c67151.L$0 = obj;
            return c67151;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PageController pageController, Continuation<? super Unit> continuation) {
            return ((C67151) create(pageController, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PageController pageController = (PageController) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            pageController.configureTool(this.$highlighterConfiguration);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ToolbarViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolbarViewModel$Companion;", "", "<init>", "()V", "UNSELECTED", "", "randomColor", "getRandomColor", "()I", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getRandomColor() {
            return ColorExt.getOpaque(Color.HSVToColor(new float[]{Random.INSTANCE.nextInt(360), Random.INSTANCE.nextFloat() + 0.5f, Random.INSTANCE.nextFloat() + 0.5f}));
        }
    }
}
