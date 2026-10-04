package com.myscript.snt.core;

import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.Box;
import com.myscript.atk.core.ButtonType;
import com.myscript.atk.core.ChildPageSpec;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.IMessageListener;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.IURIListener;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.Json;
import com.myscript.atk.core.KeyboardAction;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.MotionPredictionParams;
import com.myscript.atk.core.Page;
import com.myscript.atk.core.PageFormat;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.PointerType;
import com.myscript.atk.core.Rectangle;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.SWIGVectorChildPageSpec;
import com.myscript.atk.core.SWIGVectorMimeType;
import com.myscript.atk.core.SWIGVectorPointerInfo;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.atk.core.Selection;
import com.myscript.atk.core.SelectionState;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.p021ui.ActionMenuEntry;
import com.myscript.atk.p021ui.IActionMenuListener;
import com.myscript.atk.p021ui.MenuType;
import com.myscript.atk.p021ui.SWIGActionMenuEntryList;
import com.myscript.atk.text.ClipboardConfiguration;
import com.myscript.atk.text.CursorPlatformBehavior;
import com.myscript.atk.text.IKeyboardListener;
import com.myscript.atk.text.INativeClipboard;
import com.myscript.atk.text.KeyboardListenerTransaction;
import com.myscript.atk.text.UserDictionary;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class PageController implements AutoCloseable, IChildPageManager {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PageController(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PageController pageController) {
        if (pageController == null) {
            return 0L;
        }
        return pageController.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_PageController(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public void notifyKeyboardListenerAtMostOnce(Runnable runnable) {
        KeyboardListenerTransaction keyboardListenerTransactionStartKeyboardListenerTransaction = startKeyboardListenerTransaction();
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                if (keyboardListenerTransactionStartKeyboardListenerTransaction != null) {
                    try {
                        keyboardListenerTransactionStartKeyboardListenerTransaction.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (keyboardListenerTransactionStartKeyboardListenerTransaction != null) {
            keyboardListenerTransactionStartKeyboardListenerTransaction.close();
        }
    }

    public static SWIGTYPE_p_std__mapT_std__string_std__string_t getDefaultOptionContext() {
        return new SWIGTYPE_p_std__mapT_std__string_std__string_t(NeboEngineJNI.PageController_DefaultOptionContext_get(), true);
    }

    public static SWIGTYPE_p_std__mapT_std__string_std__string_t getFreeformTypesetOptionContext() {
        return new SWIGTYPE_p_std__mapT_std__string_std__string_t(NeboEngineJNI.PageController_FreeformTypesetOptionContext_get(), true);
    }

    public static SWIGTYPE_p_std__mapT_std__string_std__string_t getNoStackingOptionContext() {
        return new SWIGTYPE_p_std__mapT_std__string_std__string_t(NeboEngineJNI.PageController_NoStackingOptionContext_get(), true);
    }

    public TextBox updateTextBox(TextBox textBox, String str, SWIGTYPE_p_atk__core__ActiveBackend__TextType sWIGTYPE_p_atk__core__ActiveBackend__TextType) {
        long jPageController_updateTextBox__SWIG_0 = NeboEngineJNI.PageController_updateTextBox__SWIG_0(this.swigCPtr, this, TextBox.getCPtr(textBox), textBox, str.getBytes(), SWIGTYPE_p_atk__core__ActiveBackend__TextType.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__TextType));
        if (jPageController_updateTextBox__SWIG_0 == 0) {
            return null;
        }
        return new TextBox(jPageController_updateTextBox__SWIG_0, true);
    }

    public TextBox updateTextBox(TextBox textBox, String str) {
        long jPageController_updateTextBox__SWIG_1 = NeboEngineJNI.PageController_updateTextBox__SWIG_1(this.swigCPtr, this, TextBox.getCPtr(textBox), textBox, str.getBytes());
        if (jPageController_updateTextBox__SWIG_1 == 0) {
            return null;
        }
        return new TextBox(jPageController_updateTextBox__SWIG_1, true);
    }

    public SelectionState getCurrentActiveInputManagerState() {
        return SelectionState.swigToEnum(NeboEngineJNI.PageController_getCurrentActiveInputManagerState(this.swigCPtr, this));
    }

    public void insertText(String str, int i, int i2, boolean z) {
        NeboEngineJNI.PageController_insertText__SWIG_0(this.swigCPtr, this, str.getBytes(), i, i2, z);
    }

    public void insertText(String str, int i, int i2) {
        NeboEngineJNI.PageController_insertText__SWIG_1(this.swigCPtr, this, str.getBytes(), i, i2);
    }

    public void insertText(String str, int i) {
        NeboEngineJNI.PageController_insertText__SWIG_2(this.swigCPtr, this, str.getBytes(), i);
    }

    public void insertText(String str) {
        NeboEngineJNI.PageController_insertText__SWIG_3(this.swigCPtr, this, str.getBytes());
    }

    public void keyboardAction(KeyboardAction keyboardAction) {
        NeboEngineJNI.PageController_keyboardAction(this.swigCPtr, this, keyboardAction.swigValue());
    }

    public void setCursorIndex(int i, int i2) {
        NeboEngineJNI.PageController_setCursorIndex(this.swigCPtr, this, i, i2);
    }

    public void unsetCursor(int i) {
        NeboEngineJNI.PageController_unsetCursor(this.swigCPtr, this, i);
    }

    public void setCursorPosition(int i, PointerInfo pointerInfo, boolean z) {
        NeboEngineJNI.PageController_setCursorPosition(this.swigCPtr, this, i, PointerInfo.getCPtr(pointerInfo), pointerInfo, z);
    }

    public void callKeyboardCallbacksAgain() {
        NeboEngineJNI.PageController_callKeyboardCallbacksAgain(this.swigCPtr, this);
    }

    public void setCursorPlatformBehavior(CursorPlatformBehavior cursorPlatformBehavior) {
        NeboEngineJNI.PageController_setCursorPlatformBehavior(this.swigCPtr, this, CursorPlatformBehavior.getCPtr(cursorPlatformBehavior), cursorPlatformBehavior);
    }

    public void setClipboardConfiguration(ClipboardConfiguration clipboardConfiguration) {
        NeboEngineJNI.PageController_setClipboardConfiguration(this.swigCPtr, this, ClipboardConfiguration.getCPtr(clipboardConfiguration), clipboardConfiguration);
    }

    public void setSmallTypesetExtraStyle(String str) {
        NeboEngineJNI.PageController_setSmallTypesetExtraStyle(this.swigCPtr, this, str.getBytes());
    }

    public void setBigTypesetExtraStyle(String str) {
        NeboEngineJNI.PageController_setBigTypesetExtraStyle(this.swigCPtr, this, str.getBytes());
    }

    public void setWritingPosition(String str) {
        NeboEngineJNI.PageController_setWritingPosition(this.swigCPtr, this, str.getBytes());
    }

    public void init() {
        NeboEngineJNI.PageController_init(this.swigCPtr, this);
    }

    public boolean configure(String str, String str2, String str3) {
        return NeboEngineJNI.PageController_configure__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public boolean configure(String str, String str2) {
        return NeboEngineJNI.PageController_configure__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void setTypesetListener(ITypesetListener iTypesetListener) {
        NeboEngineJNI.PageController_setTypesetListener(this.swigCPtr, this, iTypesetListener);
    }

    public void recognize() {
        NeboEngineJNI.PageController_recognize(this.swigCPtr, this);
    }

    public void convertSelection() {
        NeboEngineJNI.PageController_convertSelection(this.swigCPtr, this);
    }

    public void convert() {
        NeboEngineJNI.PageController_convert(this.swigCPtr, this);
    }

    public void remove() {
        NeboEngineJNI.PageController_remove(this.swigCPtr, this);
    }

    public void clear() {
        NeboEngineJNI.PageController_clear(this.swigCPtr, this);
    }

    public void undo() {
        NeboEngineJNI.PageController_undo(this.swigCPtr, this);
    }

    public void preUndo() {
        NeboEngineJNI.PageController_preUndo(this.swigCPtr, this);
    }

    public void postUndo() {
        NeboEngineJNI.PageController_postUndo(this.swigCPtr, this);
    }

    public void redo() {
        NeboEngineJNI.PageController_redo(this.swigCPtr, this);
    }

    public void preRedo() {
        NeboEngineJNI.PageController_preRedo(this.swigCPtr, this);
    }

    public void postRedo() {
        NeboEngineJNI.PageController_postRedo(this.swigCPtr, this);
    }

    public void resize() {
        NeboEngineJNI.PageController_resize(this.swigCPtr, this);
    }

    public void copy() {
        NeboEngineJNI.PageController_copy__SWIG_0(this.swigCPtr, this);
    }

    public void copy(GridBox gridBox, Page page) {
        NeboEngineJNI.PageController_copy__SWIG_1(this.swigCPtr, this, GridBox.getCPtr(gridBox), gridBox, Page.getCPtr(page), page);
    }

    public void copy(GridBox gridBox, Selection selection, boolean z, String str, SWIGTYPE_p_atk__core__SelectionSourceFlags sWIGTYPE_p_atk__core__SelectionSourceFlags, Page page) {
        NeboEngineJNI.PageController_copy__SWIG_2(this.swigCPtr, this, GridBox.getCPtr(gridBox), gridBox, Selection.getCPtr(selection), selection, z, str.getBytes(), SWIGTYPE_p_atk__core__SelectionSourceFlags.getCPtr(sWIGTYPE_p_atk__core__SelectionSourceFlags), Page.getCPtr(page), page);
    }

    public void textify(MenuType menuType) {
        NeboEngineJNI.PageController_textify(this.swigCPtr, this, menuType.swigValue());
    }

    public void listify(String str, MenuType menuType) {
        NeboEngineJNI.PageController_listify(this.swigCPtr, this, str.getBytes(), menuType.swigValue());
    }

    public void setInlineSelectionOverrideStyle(String str) {
        NeboEngineJNI.PageController_setInlineSelectionOverrideStyle(this.swigCPtr, this, str.getBytes());
    }

    public SWIGTYPE_p_std__pairT_atk__core__Point_float_t cursorDimensionAtCharIndex(int i) {
        return new SWIGTYPE_p_std__pairT_atk__core__Point_float_t(NeboEngineJNI.PageController_cursorDimensionAtCharIndex(this.swigCPtr, this, i), true);
    }

    public void bypassSessionTimerOnce(boolean z) {
        NeboEngineJNI.PageController_bypassSessionTimerOnce(this.swigCPtr, this, z);
    }

    public void bypassCurrentSessionTimer() {
        NeboEngineJNI.PageController_bypassCurrentSessionTimer(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__ComponentData_t componentData() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__ComponentData_t(NeboEngineJNI.PageController_componentData(this.swigCPtr, this), true);
    }

    public String activeAreaId() {
        return new String(NeboEngineJNI.PageController_activeAreaId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String defaultActiveAreaId() {
        return new String(NeboEngineJNI.PageController_defaultActiveAreaId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String defaultLayoutGroupId() {
        return new String(NeboEngineJNI.PageController_defaultLayoutGroupId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean loadActiveAreaData(String str) {
        return NeboEngineJNI.PageController_loadActiveAreaData(this.swigCPtr, this, str.getBytes());
    }

    public boolean isEmpty() {
        return NeboEngineJNI.PageController_isEmpty(this.swigCPtr, this);
    }

    public boolean isBusy() {
        return NeboEngineJNI.PageController_isBusy(this.swigCPtr, this);
    }

    public boolean hasSelection() {
        return NeboEngineJNI.PageController_hasSelection(this.swigCPtr, this);
    }

    public boolean isIndentActionAllowed() {
        return NeboEngineJNI.PageController_isIndentActionAllowed(this.swigCPtr, this);
    }

    public boolean isConvertActionAllowed() {
        return NeboEngineJNI.PageController_isConvertActionAllowed(this.swigCPtr, this);
    }

    public static boolean onlyContainsText(Page page, boolean z) {
        return NeboEngineJNI.PageController_onlyContainsText(Page.getCPtr(page), page, z);
    }

    public static boolean atLeastContainsOneText(Page page, Selection selection) {
        return NeboEngineJNI.PageController_atLeastContainsOneText(Page.getCPtr(page), page, Selection.getCPtr(selection), selection);
    }

    public InlineSelectionTextType currentInlineSelectionTextType() {
        return InlineSelectionTextType.swigToEnum(NeboEngineJNI.PageController_currentInlineSelectionTextType(this.swigCPtr, this));
    }

    public Selection contentSelection() {
        return new Selection(NeboEngineJNI.PageController_contentSelection(this.swigCPtr, this), true);
    }

    public Extent contentExtent(Selection.ExtentPolicy extentPolicy) {
        return new Extent(NeboEngineJNI.PageController_contentExtent__SWIG_0(this.swigCPtr, this, extentPolicy.swigValue()), true);
    }

    public Extent contentExtent() {
        return new Extent(NeboEngineJNI.PageController_contentExtent__SWIG_1(this.swigCPtr, this), true);
    }

    public Selection contentSelectionFromGroup() {
        return new Selection(NeboEngineJNI.PageController_contentSelectionFromGroup(this.swigCPtr, this), true);
    }

    public void monitor(SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t) {
        NeboEngineJNI.PageController_monitor(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t));
    }

    public void unmonitor(SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t) {
        NeboEngineJNI.PageController_unmonitor(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t));
    }

    public boolean createSectionAt(SWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t sWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t) {
        return NeboEngineJNI.PageController_createSectionAt(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t));
    }

    public void clean() {
        NeboEngineJNI.PageController_clean(this.swigCPtr, this);
    }

    public void preventUndo() {
        NeboEngineJNI.PageController_preventUndo(this.swigCPtr, this);
    }

    public void releaseCurrentSelection() {
        NeboEngineJNI.PageController_releaseCurrentSelection(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t boxFactory() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t(NeboEngineJNI.PageController_boxFactory(this.swigCPtr, this), true);
    }

    public Renderer getRenderer() {
        long jPageController_getRenderer = NeboEngineJNI.PageController_getRenderer(this.swigCPtr, this);
        if (jPageController_getRenderer == 0) {
            return null;
        }
        return new Renderer(jPageController_getRenderer, true);
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t activeTool() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t(NeboEngineJNI.PageController_activeTool(this.swigCPtr, this), true);
    }

    public void setActiveToolKind(SWIGTYPE_p_atk__core__Tool__Kind sWIGTYPE_p_atk__core__Tool__Kind) {
        NeboEngineJNI.PageController_setActiveToolKind(this.swigCPtr, this, SWIGTYPE_p_atk__core__Tool__Kind.getCPtr(sWIGTYPE_p_atk__core__Tool__Kind));
    }

    public SWIGTYPE_p_atk__core__Tool__Kind activeToolKind() {
        return new SWIGTYPE_p_atk__core__Tool__Kind(NeboEngineJNI.PageController_activeToolKind(this.swigCPtr, this), true);
    }

    public LayoutGrid getGrid() {
        long jPageController_getGrid = NeboEngineJNI.PageController_getGrid(this.swigCPtr, this);
        if (jPageController_getGrid == 0) {
            return null;
        }
        return new LayoutGrid(jPageController_getGrid, true);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__BackendDispatcher_t backendDispatcher() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__BackendDispatcher_t(NeboEngineJNI.PageController_backendDispatcher(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__PlatformInputDispatcher_t inputDispatcher() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__PlatformInputDispatcher_t(NeboEngineJNI.PageController_inputDispatcher(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__PageLayoutListener_t pageLayoutListener() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__PageLayoutListener_t(NeboEngineJNI.PageController_pageLayoutListener(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t mainBackend() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t(NeboEngineJNI.PageController_mainBackend(this.swigCPtr, this), true);
    }

    public String fullPageMainBoxId() {
        return new String(NeboEngineJNI.PageController_fullPageMainBoxId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setGridStrategy(IGridFactoryStrategy iGridFactoryStrategy) {
        NeboEngineJNI.PageController_setGridStrategy(this.swigCPtr, this, IGridFactoryStrategy.getCPtr(iGridFactoryStrategy), iGridFactoryStrategy);
    }

    public boolean setGridAndStylesheet(LayoutGrid layoutGrid, boolean z, boolean z2, float f) {
        return NeboEngineJNI.PageController_setGridAndStylesheet__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, z, z2, f);
    }

    public boolean setGridAndStylesheet(LayoutGrid layoutGrid, boolean z, boolean z2) {
        return NeboEngineJNI.PageController_setGridAndStylesheet__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, z, z2);
    }

    public boolean setGridAndStylesheet(LayoutGrid layoutGrid, boolean z) {
        return NeboEngineJNI.PageController_setGridAndStylesheet__SWIG_2(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, z);
    }

    public boolean setGridAndStylesheet(LayoutGrid layoutGrid) {
        return NeboEngineJNI.PageController_setGridAndStylesheet__SWIG_3(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public boolean computeGrid(float f, float f2, Point point, Point point2, float f3, float f4, boolean z, boolean z2, CompactMode compactMode, float f5, boolean z3) {
        return NeboEngineJNI.PageController_computeGrid__SWIG_0(this.swigCPtr, this, f, f2, Point.getCPtr(point), point, Point.getCPtr(point2), point2, f3, f4, z, z2, compactMode.swigValue(), f5, z3);
    }

    public boolean computeGrid(float f, float f2, Point point, Point point2, float f3, float f4, boolean z, boolean z2, CompactMode compactMode, float f5) {
        return NeboEngineJNI.PageController_computeGrid__SWIG_1(this.swigCPtr, this, f, f2, Point.getCPtr(point), point, Point.getCPtr(point2), point2, f3, f4, z, z2, compactMode.swigValue(), f5);
    }

    public boolean computeGrid(float f, float f2, Point point, Point point2, float f3, float f4, boolean z, boolean z2, CompactMode compactMode) {
        return NeboEngineJNI.PageController_computeGrid__SWIG_2(this.swigCPtr, this, f, f2, Point.getCPtr(point), point, Point.getCPtr(point2), point2, f3, f4, z, z2, compactMode.swigValue());
    }

    public void refreshSpaceInformation() {
        NeboEngineJNI.PageController_refreshSpaceInformation(this.swigCPtr, this);
    }

    public void refreshEmphasisInformation() {
        NeboEngineJNI.PageController_refreshEmphasisInformation(this.swigCPtr, this);
    }

    public Box getBox(int i) {
        long jPageController_getBox__SWIG_0 = NeboEngineJNI.PageController_getBox__SWIG_0(this.swigCPtr, this, i);
        if (jPageController_getBox__SWIG_0 == 0) {
            return null;
        }
        return new Box(jPageController_getBox__SWIG_0, true);
    }

    public Box getBox(String str) {
        long jPageController_getBox__SWIG_1 = NeboEngineJNI.PageController_getBox__SWIG_1(this.swigCPtr, this, str.getBytes());
        if (jPageController_getBox__SWIG_1 == 0) {
            return null;
        }
        return new Box(jPageController_getBox__SWIG_1, true);
    }

    public Box boxByContentFieldId(String str) {
        long jPageController_boxByContentFieldId = NeboEngineJNI.PageController_boxByContentFieldId(this.swigCPtr, this, str.getBytes());
        if (jPageController_boxByContentFieldId == 0) {
            return null;
        }
        return new Box(jPageController_boxByContentFieldId, true);
    }

    @Deprecated
    public Box boxAt(Point point) {
        long jPageController_boxAt = NeboEngineJNI.PageController_boxAt(this.swigCPtr, this, Point.getCPtr(point), point);
        if (jPageController_boxAt == 0) {
            return null;
        }
        return new Box(jPageController_boxAt, true);
    }

    public String getBoxLabel(String str) {
        return new String(NeboEngineJNI.PageController_getBoxLabel(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public String contentTypeAt(Point point) {
        return new String(NeboEngineJNI.PageController_contentTypeAt(this.swigCPtr, this, Point.getCPtr(point), point), StandardCharsets.UTF_8);
    }

    public boolean shouldPreserveImageProperties() {
        return NeboEngineJNI.PageController_shouldPreserveImageProperties__SWIG_0(this.swigCPtr, this);
    }

    public boolean shouldPreserveImageProperties(Point point) {
        return NeboEngineJNI.PageController_shouldPreserveImageProperties__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public boolean shouldPreserveImageProperties(float f, float f2) {
        return NeboEngineJNI.PageController_shouldPreserveImageProperties__SWIG_2(this.swigCPtr, this, f, f2);
    }

    public boolean isZoomIndicatorCompatible() {
        return NeboEngineJNI.PageController_isZoomIndicatorCompatible__SWIG_0(this.swigCPtr, this);
    }

    public static boolean isZoomIndicatorCompatible(String str) {
        return NeboEngineJNI.PageController_isZoomIndicatorCompatible__SWIG_1(str.getBytes());
    }

    public boolean isChildPageNavigationCompatible() {
        return NeboEngineJNI.PageController_isChildPageNavigationCompatible__SWIG_0(this.swigCPtr, this);
    }

    public static boolean isChildPageNavigationCompatible(String str) {
        return NeboEngineJNI.PageController_isChildPageNavigationCompatible__SWIG_1(str.getBytes());
    }

    public List<String> getSupportedAddBlockTypes() {
        return new SWIGVectorString(NeboEngineJNI.PageController_getSupportedAddBlockTypes(this.swigCPtr, this), true);
    }

    public List<String> getSupportedAddBlockTypesAt(Point point) {
        return new SWIGVectorString(NeboEngineJNI.PageController_getSupportedAddBlockTypesAt__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public List<String> getSupportedAddBlockTypesAt(float f, float f2) {
        return new SWIGVectorString(NeboEngineJNI.PageController_getSupportedAddBlockTypesAt__SWIG_1(this.swigCPtr, this, f, f2), true);
    }

    public CompositeBox createBlock(String str) {
        long jPageController_createBlock__SWIG_0 = NeboEngineJNI.PageController_createBlock__SWIG_0(this.swigCPtr, this, str.getBytes());
        if (jPageController_createBlock__SWIG_0 == 0) {
            return null;
        }
        return new CompositeBox(jPageController_createBlock__SWIG_0, true);
    }

    public CompositeBox createBlock(Point point, String str) {
        long jPageController_createBlock__SWIG_1 = NeboEngineJNI.PageController_createBlock__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point, str.getBytes());
        if (jPageController_createBlock__SWIG_1 == 0) {
            return null;
        }
        return new CompositeBox(jPageController_createBlock__SWIG_1, true);
    }

    public CompositeBox createBlock(Point point, String str, boolean z) {
        long jPageController_createBlock__SWIG_2 = NeboEngineJNI.PageController_createBlock__SWIG_2(this.swigCPtr, this, Point.getCPtr(point), point, str.getBytes(), z);
        if (jPageController_createBlock__SWIG_2 == 0) {
            return null;
        }
        return new CompositeBox(jPageController_createBlock__SWIG_2, true);
    }

    public void updateBlocksSettings(String str, String str2, boolean z) {
        NeboEngineJNI.PageController_updateBlocksSettings(this.swigCPtr, this, str.getBytes(), str2.getBytes(), z);
    }

    public boolean isActivePenEnabled() {
        return NeboEngineJNI.PageController_isActivePenEnabled(this.swigCPtr, this);
    }

    public boolean isSpaceManagementActivable(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_isSpaceManagementActivable(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void spaceManagement(PointerInfo pointerInfo) {
        NeboEngineJNI.PageController_spaceManagement(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void reAttachAll() {
        NeboEngineJNI.PageController_reAttachAll(this.swigCPtr, this);
    }

    public void addImages(List<ImageParameter> list) {
        SWIGVectorImageParameter sWIGVectorImageParameter = new SWIGVectorImageParameter(list);
        NeboEngineJNI.PageController_addImages(this.swigCPtr, this, SWIGVectorImageParameter.getCPtr(sWIGVectorImageParameter), sWIGVectorImageParameter);
    }

    public boolean addImage(ImageParameter imageParameter) {
        return NeboEngineJNI.PageController_addImage__SWIG_0(this.swigCPtr, this, ImageParameter.getCPtr(imageParameter), imageParameter);
    }

    public boolean addImage(String str, String str2) {
        return NeboEngineJNI.PageController_addImage__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public boolean setBackgroundImage(String str, String str2, Rectangle.FitOption fitOption) {
        return NeboEngineJNI.PageController_setBackgroundImage__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), fitOption.swigValue());
    }

    public boolean setBackgroundImage(String str, String str2) {
        return NeboEngineJNI.PageController_setBackgroundImage__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public String getSelectedImage(String str, Point point, SWIGAngle sWIGAngle) {
        return new String(NeboEngineJNI.PageController_getSelectedImage(this.swigCPtr, this, str.getBytes(), Point.getCPtr(point), point, SWIGAngle.getCPtr(sWIGAngle), sWIGAngle), StandardCharsets.UTF_8);
    }

    public String replaceSelectedImage(String str, String str2) {
        return new String(NeboEngineJNI.PageController_replaceSelectedImage(this.swigCPtr, this, str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public String importObjectAt(CompositeBox compositeBox, String str, String str2, Point point, float f, Extent extent, boolean z, boolean z2, boolean z3) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_0(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z, z2, z3), StandardCharsets.UTF_8);
    }

    public String importObjectAt(CompositeBox compositeBox, String str, String str2, Point point, float f, Extent extent, boolean z, boolean z2) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_1(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z, z2), StandardCharsets.UTF_8);
    }

    public String importObjectAt(CompositeBox compositeBox, String str, String str2, Point point, float f, Extent extent, boolean z) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_2(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z), StandardCharsets.UTF_8);
    }

    public String importObjectAt(CompositeBox compositeBox, String str, String str2, Point point, float f, Extent extent) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_3(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public String importObjectAt(CompositeBox compositeBox, String str, String str2, Point point, float f) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_4(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f), StandardCharsets.UTF_8);
    }

    public String importObjectAt(CompositeBox compositeBox, String str, String str2, Point point) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_5(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point), StandardCharsets.UTF_8);
    }

    public String importObjectAt(CompositeBox compositeBox, String str, String str2) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_6(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public String importObjectAt(String str, String str2, Point point, float f, Extent extent, boolean z, boolean z2, boolean z3) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_7(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z, z2, z3), StandardCharsets.UTF_8);
    }

    public String importObjectAt(String str, String str2, Point point, float f, Extent extent, boolean z, boolean z2) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_8(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z, z2), StandardCharsets.UTF_8);
    }

    public String importObjectAt(String str, String str2, Point point, float f, Extent extent, boolean z) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_9(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z), StandardCharsets.UTF_8);
    }

    public String importObjectAt(String str, String str2, Point point, float f, Extent extent) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_10(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public String importObjectAt(String str, String str2, Point point, float f) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_11(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point, f), StandardCharsets.UTF_8);
    }

    public String importObjectAt(String str, String str2, Point point) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_12(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Point.getCPtr(point), point), StandardCharsets.UTF_8);
    }

    public String importObjectAt(String str, String str2) {
        return new String(NeboEngineJNI.PageController_importObjectAt__SWIG_13(this.swigCPtr, this, str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(CompositeBox compositeBox, String str, String str2, Extent extent, float f, boolean z, boolean z2, boolean z3) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_0(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f, z, z2, z3), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(CompositeBox compositeBox, String str, String str2, Extent extent, float f, boolean z, boolean z2) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_1(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f, z, z2), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(CompositeBox compositeBox, String str, String str2, Extent extent, float f, boolean z) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_2(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f, z), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(CompositeBox compositeBox, String str, String str2, Extent extent, float f) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_3(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(CompositeBox compositeBox, String str, String str2, Extent extent) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_4(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(String str, String str2, Extent extent, float f, boolean z, boolean z2, boolean z3) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_5(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f, z, z2, z3), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(String str, String str2, Extent extent, float f, boolean z, boolean z2) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_6(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f, z, z2), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(String str, String str2, Extent extent, float f, boolean z) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_7(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f, z), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(String str, String str2, Extent extent, float f) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_8(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, f), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(String str, String str2, Extent extent) {
        return new String(NeboEngineJNI.PageController_importObjectToExtent__SWIG_9(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public Selection importBackgroundObject(CompositeBox compositeBox, String str, String str2, Rectangle.FitOption fitOption, boolean z) {
        return new Selection(NeboEngineJNI.PageController_importBackgroundObject__SWIG_0(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), fitOption.swigValue(), z), true);
    }

    public Selection importBackgroundObject(CompositeBox compositeBox, String str, String str2, Rectangle.FitOption fitOption) {
        return new Selection(NeboEngineJNI.PageController_importBackgroundObject__SWIG_1(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes(), fitOption.swigValue()), true);
    }

    public Selection importBackgroundObject(CompositeBox compositeBox, String str, String str2) {
        return new Selection(NeboEngineJNI.PageController_importBackgroundObject__SWIG_2(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox, str.getBytes(), str2.getBytes()), true);
    }

    public Selection importBackgroundObject(String str, String str2, Rectangle.FitOption fitOption, boolean z) {
        return new Selection(NeboEngineJNI.PageController_importBackgroundObject__SWIG_3(this.swigCPtr, this, str.getBytes(), str2.getBytes(), fitOption.swigValue(), z), true);
    }

    public Selection importBackgroundObject(String str, String str2, Rectangle.FitOption fitOption) {
        return new Selection(NeboEngineJNI.PageController_importBackgroundObject__SWIG_4(this.swigCPtr, this, str.getBytes(), str2.getBytes(), fitOption.swigValue()), true);
    }

    public Selection importBackgroundObject(String str, String str2) {
        return new Selection(NeboEngineJNI.PageController_importBackgroundObject__SWIG_5(this.swigCPtr, this, str.getBytes(), str2.getBytes()), true);
    }

    public Selection backgroundObject(CompositeBox compositeBox) {
        return new Selection(NeboEngineJNI.PageController_backgroundObject__SWIG_0(this.swigCPtr, this, CompositeBox.getCPtr(compositeBox), compositeBox), true);
    }

    public Selection backgroundObject() {
        return new Selection(NeboEngineJNI.PageController_backgroundObject__SWIG_1(this.swigCPtr, this), true);
    }

    public String updateObjectAt(String str, String str2, String str3, Point point, float f, Extent extent, boolean z, boolean z2) {
        return new String(NeboEngineJNI.PageController_updateObjectAt__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z, z2), StandardCharsets.UTF_8);
    }

    public String updateObjectAt(String str, String str2, String str3, Point point, float f, Extent extent, boolean z) {
        return new String(NeboEngineJNI.PageController_updateObjectAt__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z), StandardCharsets.UTF_8);
    }

    public String updateObjectAt(String str, String str2, String str3, Point point, float f, Extent extent) {
        return new String(NeboEngineJNI.PageController_updateObjectAt__SWIG_2(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public String updateObjectAt(String str, String str2, String str3, Point point, float f) {
        return new String(NeboEngineJNI.PageController_updateObjectAt__SWIG_3(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f), StandardCharsets.UTF_8);
    }

    public String updateObjectAt(String str, String str2, String str3, Point point) {
        return new String(NeboEngineJNI.PageController_updateObjectAt__SWIG_4(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point), StandardCharsets.UTF_8);
    }

    public String updateObjectAt(String str, String str2, String str3) {
        return new String(NeboEngineJNI.PageController_updateObjectAt__SWIG_5(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes()), StandardCharsets.UTF_8);
    }

    public String updateObjectToExtent(String str, String str2, String str3, Extent extent, float f, boolean z, boolean z2) {
        return new String(NeboEngineJNI.PageController_updateObjectToExtent__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent, f, z, z2), StandardCharsets.UTF_8);
    }

    public String updateObjectToExtent(String str, String str2, String str3, Extent extent, float f, boolean z) {
        return new String(NeboEngineJNI.PageController_updateObjectToExtent__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent, f, z), StandardCharsets.UTF_8);
    }

    public String updateObjectToExtent(String str, String str2, String str3, Extent extent, float f) {
        return new String(NeboEngineJNI.PageController_updateObjectToExtent__SWIG_2(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent, f), StandardCharsets.UTF_8);
    }

    public String updateObjectToExtent(String str, String str2, String str3, Extent extent) {
        return new String(NeboEngineJNI.PageController_updateObjectToExtent__SWIG_3(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public boolean setObjectVisible(String str, boolean z) {
        return NeboEngineJNI.PageController_setObjectVisible__SWIG_0(this.swigCPtr, this, str.getBytes(), z);
    }

    public boolean setObjectVisible(String str) {
        return NeboEngineJNI.PageController_setObjectVisible__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public boolean objectVisible(String str) {
        return NeboEngineJNI.PageController_objectVisible(this.swigCPtr, this, str.getBytes());
    }

    public boolean setObjectInteractivity(String str, SWIGTYPE_p_atk__core__Interactivity sWIGTYPE_p_atk__core__Interactivity) {
        return NeboEngineJNI.PageController_setObjectInteractivity__SWIG_0(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_atk__core__Interactivity.getCPtr(sWIGTYPE_p_atk__core__Interactivity));
    }

    public boolean setObjectInteractivity(String str) {
        return NeboEngineJNI.PageController_setObjectInteractivity__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public SWIGTYPE_p_atk__core__Interactivity objectInteractivity(String str) {
        return new SWIGTYPE_p_atk__core__Interactivity(NeboEngineJNI.PageController_objectInteractivity(this.swigCPtr, this, str.getBytes()), true);
    }

    public boolean updateObjectUserData(String str, String str2) {
        return NeboEngineJNI.PageController_updateObjectUserData(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public boolean retrieveObjectUserData(String str, String str2) {
        return NeboEngineJNI.PageController_retrieveObjectUserData(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void addReflowSessionListener(IReflowSessionListener iReflowSessionListener) {
        NeboEngineJNI.PageController_addReflowSessionListener(this.swigCPtr, this, iReflowSessionListener);
    }

    public void removeReflowSessionListener(IReflowSessionListener iReflowSessionListener) {
        NeboEngineJNI.PageController_removeReflowSessionListener(this.swigCPtr, this, iReflowSessionListener);
    }

    public void addGesturesNotificationListener(IGesturesNotificationListener iGesturesNotificationListener) {
        NeboEngineJNI.PageController_addGesturesNotificationListener(this.swigCPtr, this, iGesturesNotificationListener);
    }

    public void removeGesturesNotificationListener(IGesturesNotificationListener iGesturesNotificationListener) {
        NeboEngineJNI.PageController_removeGesturesNotificationListener(this.swigCPtr, this, iGesturesNotificationListener);
    }

    public void addKeyboardListener(IKeyboardListener iKeyboardListener) {
        NeboEngineJNI.PageController_addKeyboardListener(this.swigCPtr, this, iKeyboardListener);
    }

    public void removeKeyboardListener(IKeyboardListener iKeyboardListener) {
        NeboEngineJNI.PageController_removeKeyboardListener(this.swigCPtr, this, iKeyboardListener);
    }

    public KeyboardListenerTransaction startKeyboardListenerTransaction() {
        return new KeyboardListenerTransaction(NeboEngineJNI.PageController_startKeyboardListenerTransaction(this.swigCPtr, this), true);
    }

    public void addMessageListener(IMessageListener iMessageListener) {
        NeboEngineJNI.PageController_addMessageListener(this.swigCPtr, this, iMessageListener);
    }

    public void removeMessageListener(IMessageListener iMessageListener) {
        NeboEngineJNI.PageController_removeMessageListener(this.swigCPtr, this, iMessageListener);
    }

    public void addURIListener(IURIListener iURIListener) {
        NeboEngineJNI.PageController_addURIListener(this.swigCPtr, this, iURIListener);
    }

    public void removeURIListener(IURIListener iURIListener) {
        NeboEngineJNI.PageController_removeURIListener(this.swigCPtr, this, iURIListener);
    }

    public void addPageStateListener(IPageStateListener iPageStateListener) {
        NeboEngineJNI.PageController_addPageStateListener(this.swigCPtr, this, iPageStateListener);
    }

    public void removePageStateListener(IPageStateListener iPageStateListener) {
        NeboEngineJNI.PageController_removePageStateListener(this.swigCPtr, this, iPageStateListener);
    }

    public void addEventListener(IEventListener iEventListener) {
        NeboEngineJNI.PageController_addEventListener(this.swigCPtr, this, iEventListener);
    }

    public void removeEventListener(IEventListener iEventListener) {
        NeboEngineJNI.PageController_removeEventListener(this.swigCPtr, this, iEventListener);
    }

    public void setAutoScrollListener(IAutoScrollListener iAutoScrollListener) {
        NeboEngineJNI.PageController_setAutoScrollListener(this.swigCPtr, this, iAutoScrollListener);
    }

    public void setRendererListener(IRendererListener iRendererListener) {
        NeboEngineJNI.PageController_setRendererListener(this.swigCPtr, this, iRendererListener);
    }

    public void setActionMenuListener(IActionMenuListener iActionMenuListener) {
        NeboEngineJNI.PageController_setActionMenuListener(this.swigCPtr, this, iActionMenuListener);
    }

    public void setNativeClipboard(INativeClipboard iNativeClipboard) {
        NeboEngineJNI.PageController_setNativeClipboard(this.swigCPtr, this, iNativeClipboard);
    }

    public void setViewport(Extent extent, ViewTransform viewTransform, boolean z) {
        NeboEngineJNI.PageController_setViewport__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, ViewTransform.getCPtr(viewTransform), viewTransform, z);
    }

    public void setViewport(Extent extent, float f, boolean z) {
        NeboEngineJNI.PageController_setViewport__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent, f, z);
    }

    public void setViewport(Extent extent, float f) {
        NeboEngineJNI.PageController_setViewport__SWIG_2(this.swigCPtr, this, Extent.getCPtr(extent), extent, f);
    }

    public void setViewport(Extent extent) {
        NeboEngineJNI.PageController_setViewport__SWIG_3(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public Extent viewport() {
        return new Extent(NeboEngineJNI.PageController_viewport(this.swigCPtr, this), true);
    }

    public void saveScrollPosition() {
        NeboEngineJNI.PageController_saveScrollPosition(this.swigCPtr, this);
    }

    public Json getScrollPosition(Json json, long j) {
        return new Json(NeboEngineJNI.PageController_getScrollPosition(this.swigCPtr, this, Json.getCPtr(json), json, j), true);
    }

    public void enableGestures() {
        NeboEngineJNI.PageController_enableGestures(this.swigCPtr, this);
    }

    public void disableGestures(SWIGTYPE_p_atk__core__GesturePolicy sWIGTYPE_p_atk__core__GesturePolicy) {
        NeboEngineJNI.PageController_disableGestures__SWIG_0(this.swigCPtr, this, SWIGTYPE_p_atk__core__GesturePolicy.getCPtr(sWIGTYPE_p_atk__core__GesturePolicy));
    }

    public void disableGestures() {
        NeboEngineJNI.PageController_disableGestures__SWIG_1(this.swigCPtr, this);
    }

    public void setSearchController(SearchController searchController, PageKey pageKey) {
        NeboEngineJNI.PageController_setSearchController(this.swigCPtr, this, SearchController.getCPtr(searchController), searchController, PageKey.getCPtr(pageKey), pageKey);
    }

    public ScrollBarBehavior scrollBehavior() {
        return new ScrollBarBehavior(NeboEngineJNI.PageController_scrollBehavior(this.swigCPtr, this), true);
    }

    public boolean isFingerWritingAllowed() {
        return NeboEngineJNI.PageController_isFingerWritingAllowed(this.swigCPtr, this);
    }

    public boolean isZoomSupported() {
        return NeboEngineJNI.PageController_isZoomSupported(this.swigCPtr, this);
    }

    public boolean isSwipeToIndentSupported() {
        return NeboEngineJNI.PageController_isSwipeToIndentSupported(this.swigCPtr, this);
    }

    public boolean reflow() {
        return NeboEngineJNI.PageController_reflow(this.swigCPtr, this);
    }

    public boolean reflowWithLimit(float f) {
        return NeboEngineJNI.PageController_reflowWithLimit(this.swigCPtr, this, f);
    }

    public void setViewbox(float f, float f2, float f3, float f4) {
        NeboEngineJNI.PageController_setViewbox(this.swigCPtr, this, f, f2, f3, f4);
    }

    public boolean canUndo() {
        return NeboEngineJNI.PageController_canUndo(this.swigCPtr, this);
    }

    public boolean canRedo() {
        return NeboEngineJNI.PageController_canRedo(this.swigCPtr, this);
    }

    public boolean isUndoRedoAvailable() {
        return NeboEngineJNI.PageController_isUndoRedoAvailable(this.swigCPtr, this);
    }

    public void setStyleClasses(String str) {
        NeboEngineJNI.PageController_setStyleClasses(this.swigCPtr, this, str.getBytes());
    }

    public void applyStyleSelector(SWIGTYPE_p_atk__core__Tool__Kind sWIGTYPE_p_atk__core__Tool__Kind, String str, String str2) {
        NeboEngineJNI.PageController_applyStyleSelector__SWIG_0(this.swigCPtr, this, SWIGTYPE_p_atk__core__Tool__Kind.getCPtr(sWIGTYPE_p_atk__core__Tool__Kind), str.getBytes(), str2.getBytes());
    }

    public void applyStyleSelector(SWIGTYPE_p_atk__core__Tool__Kind sWIGTYPE_p_atk__core__Tool__Kind, String str) {
        NeboEngineJNI.PageController_applyStyleSelector__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_atk__core__Tool__Kind.getCPtr(sWIGTYPE_p_atk__core__Tool__Kind), str.getBytes());
    }

    public InkStyle style() {
        return new InkStyle(NeboEngineJNI.PageController_style(this.swigCPtr, this), true);
    }

    public boolean isWritingInput(PointerType pointerType) {
        return NeboEngineJNI.PageController_isWritingInput(this.swigCPtr, this, pointerType.swigValue());
    }

    public boolean isOverCheckableItem(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_isOverCheckableItem(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public boolean hasSelectionAt(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_hasSelectionAt(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void clearInteractionState() {
        NeboEngineJNI.PageController_clearInteractionState(this.swigCPtr, this);
    }

    public Extent selectionExtent() {
        return new Extent(NeboEngineJNI.PageController_selectionExtent(this.swigCPtr, this), true);
    }

    public List<String> selectedIds() {
        return new SWIGVectorString(NeboEngineJNI.PageController_selectedIds(this.swigCPtr, this), true);
    }

    public String boxTypeFromId(String str) {
        return new String(NeboEngineJNI.PageController_boxTypeFromId(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public boolean onTap(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_onTap(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public boolean onDoubleTap(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_onDoubleTap(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public boolean onLongPress(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_onLongPress(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public boolean onSwipe(PointerInfo pointerInfo, boolean z) {
        return NeboEngineJNI.PageController_onSwipe(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo, z);
    }

    public boolean isCaptureAllowed(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_isCaptureAllowed(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void penDown(PointerInfo pointerInfo) {
        NeboEngineJNI.PageController_penDown(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void penMove(List<PointerInfo> list) {
        SWIGVectorPointerInfo sWIGVectorPointerInfo = new SWIGVectorPointerInfo(list);
        NeboEngineJNI.PageController_penMove__SWIG_0(this.swigCPtr, this, SWIGVectorPointerInfo.getCPtr(sWIGVectorPointerInfo), sWIGVectorPointerInfo);
    }

    public void penMove(PointerInfo pointerInfo) {
        NeboEngineJNI.PageController_penMove__SWIG_1(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void penMove(int i, float[] fArr, float[] fArr2, float[] fArr3, long[] jArr, PointerType pointerType, ButtonType buttonType, int i2) {
        NeboEngineJNI.PageController_penMove__SWIG_2(this.swigCPtr, this, i, fArr, fArr2, fArr3, jArr, pointerType.swigValue(), buttonType.swigValue(), i2);
    }

    public void penMove(int i, float[] fArr, float[] fArr2, float[] fArr3, long[] jArr, PointerType pointerType, ButtonType buttonType) {
        NeboEngineJNI.PageController_penMove__SWIG_3(this.swigCPtr, this, i, fArr, fArr2, fArr3, jArr, pointerType.swigValue(), buttonType.swigValue());
    }

    public void penUp(PointerInfo pointerInfo) {
        NeboEngineJNI.PageController_penUp(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void penAbort(int i) {
        NeboEngineJNI.PageController_penAbort__SWIG_0(this.swigCPtr, this, i);
    }

    public void penAbort() {
        NeboEngineJNI.PageController_penAbort__SWIG_1(this.swigCPtr, this);
    }

    public boolean dragBegin(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_dragBegin(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public boolean dragMove(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_dragMove(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public boolean dragEnd(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_dragEnd(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public boolean dragAbort() {
        return NeboEngineJNI.PageController_dragAbort(this.swigCPtr, this);
    }

    public void setDefaultLanguage(String str, boolean z) {
        NeboEngineJNI.PageController_setDefaultLanguage__SWIG_0(this.swigCPtr, this, str.getBytes(), z);
    }

    public void setDefaultLanguage(String str) {
        NeboEngineJNI.PageController_setDefaultLanguage__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public void addResourceSearchDir(String str) {
        NeboEngineJNI.PageController_addResourceSearchDir(this.swigCPtr, this, str.getBytes());
    }

    public void addResourceSearchDirs(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        NeboEngineJNI.PageController_addResourceSearchDirs(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void reloadUserDictionary(UserDictionary userDictionary) {
        NeboEngineJNI.PageController_reloadUserDictionary(this.swigCPtr, this, UserDictionary.getCPtr(userDictionary), userDictionary);
    }

    public C6918x9ef02c5c lineBreaks(TextBox textBox) {
        return new C6918x9ef02c5c(NeboEngineJNI.PageController_lineBreaks(this.swigCPtr, this, TextBox.getCPtr(textBox), textBox), true);
    }

    public SWIGTYPE_p_std__mapT_int_atk__text__ListItemInfo_t listItems(TextBox textBox) {
        return new SWIGTYPE_p_std__mapT_int_atk__text__ListItemInfo_t(NeboEngineJNI.PageController_listItems(this.swigCPtr, this, TextBox.getCPtr(textBox), textBox), true);
    }

    public void paste() {
        NeboEngineJNI.PageController_paste(this.swigCPtr, this);
    }

    public List<MimeType> getSupportedExportMimeTypes() {
        return new SWIGVectorMimeType(NeboEngineJNI.PageController_getSupportedExportMimeTypes(this.swigCPtr, this), true);
    }

    public static boolean isKeyboardCompatible(String str) {
        return NeboEngineJNI.PageController_isKeyboardCompatible(str.getBytes());
    }

    public static boolean canConfigureBackgroundColor(String str) {
        return NeboEngineJNI.PageController_canConfigureBackgroundColor(str.getBytes());
    }

    public static boolean canConfigureBackgroundPattern(String str) {
        return NeboEngineJNI.PageController_canConfigureBackgroundPattern(str.getBytes());
    }

    public void setWaitIdleForExport(boolean z) {
        NeboEngineJNI.PageController_setWaitIdleForExport(this.swigCPtr, this, z);
    }

    public String exportRawText(Box box, boolean z) {
        return new String(NeboEngineJNI.PageController_exportRawText__SWIG_0(this.swigCPtr, this, Box.getCPtr(box), box, z), StandardCharsets.UTF_8);
    }

    public String exportRawText(Box box) {
        return new String(NeboEngineJNI.PageController_exportRawText__SWIG_1(this.swigCPtr, this, Box.getCPtr(box), box), StandardCharsets.UTF_8);
    }

    public boolean exportToPNG(Box box, String str, IRendererListener iRendererListener, int i) {
        return NeboEngineJNI.PageController_exportToPNG__SWIG_0(this.swigCPtr, this, Box.getCPtr(box), box, str.getBytes(), iRendererListener, i);
    }

    public boolean exportToPNG(Box box, String str, IRendererListener iRendererListener) {
        return NeboEngineJNI.PageController_exportToPNG__SWIG_1(this.swigCPtr, this, Box.getCPtr(box), box, str.getBytes(), iRendererListener);
    }

    public boolean exportToSVG(Box box, String str, IRendererListener iRendererListener) {
        return NeboEngineJNI.PageController_exportToSVG(this.swigCPtr, this, Box.getCPtr(box), box, str.getBytes(), iRendererListener);
    }

    public boolean exportToJiix(GridBox gridBox, String str, SWIGTYPE_p_atk__core__ExchangeFormat__OptionType sWIGTYPE_p_atk__core__ExchangeFormat__OptionType, SWIGTYPE_p_NeboJiixWriter__MakeIdFunction sWIGTYPE_p_NeboJiixWriter__MakeIdFunction) {
        return NeboEngineJNI.PageController_exportToJiix__SWIG_0(this.swigCPtr, this, GridBox.getCPtr(gridBox), gridBox, str.getBytes(), SWIGTYPE_p_atk__core__ExchangeFormat__OptionType.getCPtr(sWIGTYPE_p_atk__core__ExchangeFormat__OptionType), SWIGTYPE_p_NeboJiixWriter__MakeIdFunction.getCPtr(sWIGTYPE_p_NeboJiixWriter__MakeIdFunction));
    }

    public boolean exportToJiix(GridBox gridBox, SWIGTYPE_p_std__ostream sWIGTYPE_p_std__ostream, SWIGTYPE_p_atk__core__ExchangeFormat__OptionType sWIGTYPE_p_atk__core__ExchangeFormat__OptionType, SWIGTYPE_p_NeboJiixWriter__MakeIdFunction sWIGTYPE_p_NeboJiixWriter__MakeIdFunction) {
        return NeboEngineJNI.PageController_exportToJiix__SWIG_1(this.swigCPtr, this, GridBox.getCPtr(gridBox), gridBox, SWIGTYPE_p_std__ostream.getCPtr(sWIGTYPE_p_std__ostream), SWIGTYPE_p_atk__core__ExchangeFormat__OptionType.getCPtr(sWIGTYPE_p_atk__core__ExchangeFormat__OptionType), SWIGTYPE_p_NeboJiixWriter__MakeIdFunction.getCPtr(sWIGTYPE_p_NeboJiixWriter__MakeIdFunction));
    }

    public Json exportToJiix(GridBox gridBox, SWIGTYPE_p_atk__core__ExchangeFormat__OptionType sWIGTYPE_p_atk__core__ExchangeFormat__OptionType, SWIGTYPE_p_NeboJiixWriter__MakeIdFunction sWIGTYPE_p_NeboJiixWriter__MakeIdFunction) {
        return new Json(NeboEngineJNI.PageController_exportToJiix__SWIG_2(this.swigCPtr, this, GridBox.getCPtr(gridBox), gridBox, SWIGTYPE_p_atk__core__ExchangeFormat__OptionType.getCPtr(sWIGTYPE_p_atk__core__ExchangeFormat__OptionType), SWIGTYPE_p_NeboJiixWriter__MakeIdFunction.getCPtr(sWIGTYPE_p_NeboJiixWriter__MakeIdFunction)), true);
    }

    public TextSelectionWithContext textSelectionWithContext() {
        return new TextSelectionWithContext(NeboEngineJNI.PageController_textSelectionWithContext(this.swigCPtr, this), true);
    }

    public boolean exportCurrentSelectionToPNG(String str, IRendererListener iRendererListener, int i) {
        return NeboEngineJNI.PageController_exportCurrentSelectionToPNG__SWIG_0(this.swigCPtr, this, str.getBytes(), iRendererListener, i);
    }

    public boolean exportCurrentSelectionToPNG(String str, IRendererListener iRendererListener) {
        return NeboEngineJNI.PageController_exportCurrentSelectionToPNG__SWIG_1(this.swigCPtr, this, str.getBytes(), iRendererListener);
    }

    public String exportCurrentSelectionToText() {
        return new String(NeboEngineJNI.PageController_exportCurrentSelectionToText(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String exportCurrentSelectionContextToText() {
        return new String(NeboEngineJNI.PageController_exportCurrentSelectionContextToText(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean isActivePenAvailable() {
        return NeboEngineJNI.PageController_isActivePenAvailable(this.swigCPtr, this);
    }

    public boolean isClearAllAvailable() {
        return NeboEngineJNI.PageController_isClearAllAvailable(this.swigCPtr, this);
    }

    public boolean isClearAllAnnotationsAvailable() {
        return NeboEngineJNI.PageController_isClearAllAnnotationsAvailable(this.swigCPtr, this);
    }

    public boolean isTypesetAvailable() {
        return NeboEngineJNI.PageController_isTypesetAvailable(this.swigCPtr, this);
    }

    public boolean hasContent() {
        return NeboEngineJNI.PageController_hasContent(this.swigCPtr, this);
    }

    public boolean hasContentToClear() {
        return NeboEngineJNI.PageController_hasContentToClear(this.swigCPtr, this);
    }

    public boolean hasContentToTypeset() {
        return NeboEngineJNI.PageController_hasContentToTypeset(this.swigCPtr, this);
    }

    public void typesetAll() {
        NeboEngineJNI.PageController_typesetAll(this.swigCPtr, this);
    }

    public void stack() {
        NeboEngineJNI.PageController_stack(this.swigCPtr, this);
    }

    public static boolean isConversionPreviewSupported(String str) {
        return NeboEngineJNI.PageController_isConversionPreviewSupported__SWIG_0(str.getBytes());
    }

    public boolean isConversionPreviewSupported() {
        return NeboEngineJNI.PageController_isConversionPreviewSupported__SWIG_1(this.swigCPtr, this);
    }

    public void addDecorationNotificationListener(SWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t sWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t) {
        NeboEngineJNI.PageController_addDecorationNotificationListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t));
    }

    public void removeDecorationNotificationListener(SWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t sWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t) {
        NeboEngineJNI.PageController_removeDecorationNotificationListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__DecorationListener_t));
    }

    public SWIGTYPE_p_snt__CompositeBoxManager activeBlockManager() {
        long jPageController_activeBlockManager = NeboEngineJNI.PageController_activeBlockManager(this.swigCPtr, this);
        if (jPageController_activeBlockManager == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__CompositeBoxManager(jPageController_activeBlockManager, true);
    }

    public Extent getEmptySpace(float f, float f2) {
        return new Extent(NeboEngineJNI.PageController_getEmptySpace(this.swigCPtr, this, f, f2), true);
    }

    public SmartGuideManager getSmartGuideManager() {
        long jPageController_getSmartGuideManager = NeboEngineJNI.PageController_getSmartGuideManager(this.swigCPtr, this);
        if (jPageController_getSmartGuideManager == 0) {
            return null;
        }
        return new SmartGuideManager(jPageController_getSmartGuideManager, true);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__PageContentEditor_t pageContentEditor() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__PageContentEditor_t(NeboEngineJNI.PageController_pageContentEditor(this.swigCPtr, this), true);
    }

    public void removeListenersFromSmartGuide() {
        NeboEngineJNI.PageController_removeListenersFromSmartGuide(this.swigCPtr, this);
    }

    public void createContentField(String str, String str2) {
        NeboEngineJNI.PageController_createContentField__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void createContentField(String str) {
        NeboEngineJNI.PageController_createContentField__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public TextBox insertText(String str, SWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t sWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t, Extent extent, SWIGTYPE_p_atk__text__TextBoxType sWIGTYPE_p_atk__text__TextBoxType, SWIGTYPE_p_atk__text__TextAlignment sWIGTYPE_p_atk__text__TextAlignment) {
        long jPageController_insertText__SWIG_4 = NeboEngineJNI.PageController_insertText__SWIG_4(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t.getCPtr(sWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t), Extent.getCPtr(extent), extent, SWIGTYPE_p_atk__text__TextBoxType.getCPtr(sWIGTYPE_p_atk__text__TextBoxType), SWIGTYPE_p_atk__text__TextAlignment.getCPtr(sWIGTYPE_p_atk__text__TextAlignment));
        if (jPageController_insertText__SWIG_4 == 0) {
            return null;
        }
        return new TextBox(jPageController_insertText__SWIG_4, true);
    }

    public TextBox insertText(String str, SWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t sWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t, Extent extent, SWIGTYPE_p_atk__text__TextBoxType sWIGTYPE_p_atk__text__TextBoxType) {
        long jPageController_insertText__SWIG_5 = NeboEngineJNI.PageController_insertText__SWIG_5(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t.getCPtr(sWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t), Extent.getCPtr(extent), extent, SWIGTYPE_p_atk__text__TextBoxType.getCPtr(sWIGTYPE_p_atk__text__TextBoxType));
        if (jPageController_insertText__SWIG_5 == 0) {
            return null;
        }
        return new TextBox(jPageController_insertText__SWIG_5, true);
    }

    public TextBox insertText(String str, SWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t sWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t, Extent extent) {
        long jPageController_insertText__SWIG_6 = NeboEngineJNI.PageController_insertText__SWIG_6(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t.getCPtr(sWIGTYPE_p_std__vectorT_atk__text__StyleSpan_t), Extent.getCPtr(extent), extent);
        if (jPageController_insertText__SWIG_6 == 0) {
            return null;
        }
        return new TextBox(jPageController_insertText__SWIG_6, true);
    }

    public TextBox pasteText(String str, Point point) {
        long jPageController_pasteText = NeboEngineJNI.PageController_pasteText(this.swigCPtr, this, str.getBytes(), Point.getCPtr(point), point);
        if (jPageController_pasteText == 0) {
            return null;
        }
        return new TextBox(jPageController_pasteText, true);
    }

    public void removeBox(String str) {
        NeboEngineJNI.PageController_removeBox(this.swigCPtr, this, str.getBytes());
    }

    public void resetStyles() {
        NeboEngineJNI.PageController_resetStyles(this.swigCPtr, this);
    }

    public boolean isModified(Extent extent, ModificationState modificationState) {
        return NeboEngineJNI.PageController_isModified(this.swigCPtr, this, Extent.getCPtr(extent), extent, modificationState.swigValue());
    }

    public void reTypeset(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        NeboEngineJNI.PageController_reTypeset__SWIG_0(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void reTypeset() {
        NeboEngineJNI.PageController_reTypeset__SWIG_1(this.swigCPtr, this);
    }

    public RecoContext recoContext() {
        return new RecoContext(NeboEngineJNI.PageController_recoContext(this.swigCPtr, this), true);
    }

    public String workingDirPath() {
        return new String(NeboEngineJNI.PageController_workingDirPath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean isIdle() {
        return NeboEngineJNI.PageController_isIdle(this.swigCPtr, this);
    }

    public void waitForIdle() {
        NeboEngineJNI.PageController_waitForIdle(this.swigCPtr, this);
    }

    public String automaticPageTitle() {
        return new String(NeboEngineJNI.PageController_automaticPageTitle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean isCopyAuthorized(String str) {
        return NeboEngineJNI.PageController_isCopyAuthorized(this.swigCPtr, this, str.getBytes());
    }

    public void copyRedirect() {
        NeboEngineJNI.PageController_copyRedirect(this.swigCPtr, this);
    }

    public void copyAs(Selection selection, String str, SWIGTYPE_p_atk__core__SelectionSourceFlags sWIGTYPE_p_atk__core__SelectionSourceFlags, String str2) {
        NeboEngineJNI.PageController_copyAs__SWIG_0(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes(), SWIGTYPE_p_atk__core__SelectionSourceFlags.getCPtr(sWIGTYPE_p_atk__core__SelectionSourceFlags), str2.getBytes());
    }

    public void copyAs(Selection selection, String str, SWIGTYPE_p_atk__core__SelectionSourceFlags sWIGTYPE_p_atk__core__SelectionSourceFlags) {
        NeboEngineJNI.PageController_copyAs__SWIG_1(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes(), SWIGTYPE_p_atk__core__SelectionSourceFlags.getCPtr(sWIGTYPE_p_atk__core__SelectionSourceFlags));
    }

    public void copyAs(Selection selection, String str) {
        NeboEngineJNI.PageController_copyAs__SWIG_2(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes());
    }

    public void copyAs(String str, SWIGTYPE_p_atk__core__SelectionSourceFlags sWIGTYPE_p_atk__core__SelectionSourceFlags, String str2) {
        NeboEngineJNI.PageController_copyAs__SWIG_3(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_atk__core__SelectionSourceFlags.getCPtr(sWIGTYPE_p_atk__core__SelectionSourceFlags), str2.getBytes());
    }

    public void copyAs(String str, SWIGTYPE_p_atk__core__SelectionSourceFlags sWIGTYPE_p_atk__core__SelectionSourceFlags) {
        NeboEngineJNI.PageController_copyAs__SWIG_4(this.swigCPtr, this, str.getBytes(), SWIGTYPE_p_atk__core__SelectionSourceFlags.getCPtr(sWIGTYPE_p_atk__core__SelectionSourceFlags));
    }

    public void copyAs(String str) {
        NeboEngineJNI.PageController_copyAs__SWIG_5(this.swigCPtr, this, str.getBytes());
    }

    public boolean isPasteAuthorized(String str) {
        return NeboEngineJNI.PageController_isPasteAuthorized(this.swigCPtr, this, str.getBytes());
    }

    public void pasteInline(String str) {
        NeboEngineJNI.PageController_pasteInline(this.swigCPtr, this, str.getBytes());
    }

    public void configureTool(ToolConfiguration toolConfiguration) {
        NeboEngineJNI.PageController_configureTool(this.swigCPtr, this, ToolConfiguration.getCPtr(toolConfiguration), toolConfiguration);
    }

    public void setTool(ToolType toolType) {
        NeboEngineJNI.PageController_setTool(this.swigCPtr, this, toolType.swigValue());
    }

    public boolean isCurrentToolPenDown() {
        return NeboEngineJNI.PageController_isCurrentToolPenDown(this.swigCPtr, this);
    }

    public void dropColorAt(int i, Point point) {
        NeboEngineJNI.PageController_dropColorAt(this.swigCPtr, this, i, Point.getCPtr(point), point);
    }

    public float getScaleAtPosition(PointerInfo pointerInfo) {
        return NeboEngineJNI.PageController_getScaleAtPosition(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void setPageHeight(float f) {
        NeboEngineJNI.PageController_setPageHeight(this.swigCPtr, this, f);
    }

    public String pageType() {
        return new String(NeboEngineJNI.PageController_pageType(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void autoActivateSmartPen() {
        NeboEngineJNI.PageController_autoActivateSmartPen(this.swigCPtr, this);
    }

    public void setColor(int i) {
        NeboEngineJNI.PageController_setColor(this.swigCPtr, this, i);
    }

    public void setThicknessRatio(float f) {
        NeboEngineJNI.PageController_setThicknessRatio(this.swigCPtr, this, f);
    }

    public void setPressureSensitivity(float f) {
        NeboEngineJNI.PageController_setPressureSensitivity(this.swigCPtr, this, f);
    }

    public SelectionState selectionState() {
        return SelectionState.swigToEnum(NeboEngineJNI.PageController_selectionState(this.swigCPtr, this));
    }

    public void setToolbarConfigurationListener(IToolbarConfigurationListener iToolbarConfigurationListener) {
        NeboEngineJNI.PageController_setToolbarConfigurationListener(this.swigCPtr, this, iToolbarConfigurationListener);
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t currentTool() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t(NeboEngineJNI.PageController_currentTool(this.swigCPtr, this), true);
    }

    public ToolType currentToolType() {
        return ToolType.swigToEnum(NeboEngineJNI.PageController_currentToolType(this.swigCPtr, this));
    }

    public float currentToolWidth() {
        return NeboEngineJNI.PageController_currentToolWidth(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__shared_ptrT_DataCollect_t dataCollect() {
        return new SWIGTYPE_p_std__shared_ptrT_DataCollect_t(NeboEngineJNI.PageController_dataCollect(this.swigCPtr, this), true);
    }

    public boolean isReadOnly() {
        return NeboEngineJNI.PageController_isReadOnly(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__ReflowSession_t reflowSession() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__ReflowSession_t(NeboEngineJNI.PageController_reflowSession(this.swigCPtr, this), true);
    }

    public void setProperty(String str, String str2) {
        NeboEngineJNI.PageController_setProperty__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void setProperty(String str, boolean z) {
        NeboEngineJNI.PageController_setProperty__SWIG_1(this.swigCPtr, this, str.getBytes(), z);
    }

    public void setProperties(SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        NeboEngineJNI.PageController_setProperties(this.swigCPtr, this, SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t));
    }

    public String getProperty(String str) {
        return new String(NeboEngineJNI.PageController_getProperty(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public boolean getBoolProperty(String str) {
        return NeboEngineJNI.PageController_getBoolProperty(this.swigCPtr, this, str.getBytes());
    }

    public void scrollToStroke(String str, String str2) {
        NeboEngineJNI.PageController_scrollToStroke(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void scrollTo(float f, float f2) {
        NeboEngineJNI.PageController_scrollTo(this.swigCPtr, this, f, f2);
    }

    public void setBackgroundColor(int i) {
        NeboEngineJNI.PageController_setBackgroundColor(this.swigCPtr, this, i);
    }

    public void setColorInversionPolicy(IColorInversionPolicy iColorInversionPolicy) {
        NeboEngineJNI.PageController_setColorInversionPolicy(this.swigCPtr, this, iColorInversionPolicy);
    }

    public void setTheme(String str, boolean z) {
        NeboEngineJNI.PageController_setTheme(this.swigCPtr, this, str.getBytes(), z);
    }

    public void setPageRowid(long j) {
        NeboEngineJNI.PageController_setPageRowid(this.swigCPtr, this, j);
    }

    public long pageRowid() {
        return NeboEngineJNI.PageController_pageRowid(this.swigCPtr, this);
    }

    public void setBackgroundPattern(BackgroundPattern backgroundPattern) {
        NeboEngineJNI.PageController_setBackgroundPattern__SWIG_0(this.swigCPtr, this, backgroundPattern.swigValue());
    }

    public void setBackgroundPattern(BackgroundPattern backgroundPattern, float[] fArr) {
        NeboEngineJNI.PageController_setBackgroundPattern__SWIG_1(this.swigCPtr, this, backgroundPattern.swigValue(), fArr);
    }

    public void checkForLongPage() {
        NeboEngineJNI.PageController_checkForLongPage(this.swigCPtr, this);
    }

    public String pageInfos(boolean z) {
        return new String(NeboEngineJNI.PageController_pageInfos__SWIG_0(this.swigCPtr, this, z), StandardCharsets.UTF_8);
    }

    public String pageInfos() {
        return new String(NeboEngineJNI.PageController_pageInfos__SWIG_1(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setHasMissingAttachment(boolean z) {
        NeboEngineJNI.PageController_setHasMissingAttachment(this.swigCPtr, this, z);
    }

    public boolean hasMissingAttachment() {
        return NeboEngineJNI.PageController_hasMissingAttachment(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public List<ChildPageSpec> getChildPageList() {
        return new SWIGVectorChildPageSpec(NeboEngineJNI.PageController_getChildPageList(this.swigCPtr, this), true);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public ChildPageSpec getChildPageSpec(String str) {
        return new ChildPageSpec(NeboEngineJNI.PageController_getChildPageSpec(this.swigCPtr, this, str.getBytes()), true);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String getChildPageIdAtPageNumber(long j) {
        return new String(NeboEngineJNI.PageController_getChildPageIdAtPageNumber(this.swigCPtr, this, j), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String getChildPageIdAt(Point point) {
        return new String(NeboEngineJNI.PageController_getChildPageIdAt(this.swigCPtr, this, Point.getCPtr(point), point), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String childPageCustomAttribute(String str, String str2) {
        return new String(NeboEngineJNI.PageController_childPageCustomAttribute(this.swigCPtr, this, str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public void childPageSetCustomAttribute(String str, String str2, String str3) {
        NeboEngineJNI.PageController_childPageSetCustomAttribute(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String getChildPageIdDisplayed() {
        return new String(NeboEngineJNI.PageController_getChildPageIdDisplayed(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String createChildPage(String str, boolean z) {
        return new String(NeboEngineJNI.PageController_createChildPage__SWIG_0(this.swigCPtr, this, str.getBytes(), z), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String createChildPage(String str) {
        return new String(NeboEngineJNI.PageController_createChildPage__SWIG_1(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String duplicateChildPage(String str, boolean z) {
        return new String(NeboEngineJNI.PageController_duplicateChildPage__SWIG_0(this.swigCPtr, this, str.getBytes(), z), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String duplicateChildPage(String str) {
        return new String(NeboEngineJNI.PageController_duplicateChildPage__SWIG_1(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public void moveChildPage(String str, String str2, boolean z) {
        NeboEngineJNI.PageController_moveChildPage__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), z);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public void moveChildPage(String str, String str2) {
        NeboEngineJNI.PageController_moveChildPage__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public void removeChildPage(String str) {
        NeboEngineJNI.PageController_removeChildPage(this.swigCPtr, this, str.getBytes());
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public void displayChildPage(String str) {
        NeboEngineJNI.PageController_displayChildPage(this.swigCPtr, this, str.getBytes());
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String getChildPageText(String str, boolean z) {
        return new String(NeboEngineJNI.PageController_getChildPageText__SWIG_0(this.swigCPtr, this, str.getBytes(), z), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public String getChildPageText(String str) {
        return new String(NeboEngineJNI.PageController_getChildPageText__SWIG_1(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public int getNumberOfChildPages() {
        return NeboEngineJNI.PageController_getNumberOfChildPages(this.swigCPtr, this);
    }

    public String nextPageId(String str) {
        return new String(NeboEngineJNI.PageController_nextPageId(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public String prevPageId(String str) {
        return new String(NeboEngineJNI.PageController_prevPageId(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public List<ActionMenuEntry> getChildPageActionMenuEntries(String str) {
        return new SWIGActionMenuEntryList(NeboEngineJNI.PageController_getChildPageActionMenuEntries(this.swigCPtr, this, str.getBytes()), true);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public void addChildPageListener(IChildPageListener iChildPageListener) {
        NeboEngineJNI.PageController_addChildPageListener(this.swigCPtr, this, iChildPageListener);
    }

    @Override // com.myscript.snt.core.IChildPageManager
    public void removeChildPageListener(IChildPageListener iChildPageListener) {
        NeboEngineJNI.PageController_removeChildPageListener(this.swigCPtr, this, iChildPageListener);
    }

    public boolean isWriting() {
        return NeboEngineJNI.PageController_isWriting(this.swigCPtr, this);
    }

    public Extent forcedPageSize() {
        return new Extent(NeboEngineJNI.PageController_forcedPageSize(this.swigCPtr, this), true);
    }

    public String toString() {
        return new String(NeboEngineJNI.PageController_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void pasteAt2(float f, float f2) {
        NeboEngineJNI.PageController_pasteAt2(this.swigCPtr, this, f, f2);
    }

    public void cut() {
        NeboEngineJNI.PageController_cut(this.swigCPtr, this);
    }

    public static PageController newRef(PageController pageController) {
        long jPageController_newRef = NeboEngineJNI.PageController_newRef(getCPtr(pageController), pageController);
        if (jPageController_newRef == 0) {
            return null;
        }
        return new PageController(jPageController_newRef, true);
    }

    public ViewTransform getViewTransform() {
        long jPageController_getViewTransform = NeboEngineJNI.PageController_getViewTransform(this.swigCPtr, this);
        if (jPageController_getViewTransform == 0) {
            return null;
        }
        return new ViewTransform(jPageController_getViewTransform, true);
    }

    public String getFilePath() {
        return new String(NeboEngineJNI.PageController_getFilePath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean exportAllToText(String str) {
        return NeboEngineJNI.PageController_exportAllToText(this.swigCPtr, this, str.getBytes());
    }

    public boolean exportAllToHTML(String str) {
        return NeboEngineJNI.PageController_exportAllToHTML(this.swigCPtr, this, str.getBytes());
    }

    public boolean exportAllToPDF(String str, PageFormat.Formats formats) {
        return NeboEngineJNI.PageController_exportAllToPDF(this.swigCPtr, this, str.getBytes(), formats.swigValue());
    }

    public boolean exportAllToPNG(String str, IRendererListener iRendererListener) {
        return NeboEngineJNI.PageController_exportAllToPNG(this.swigCPtr, this, str.getBytes(), iRendererListener);
    }

    public boolean exportAllToSVG(String str, IRendererListener iRendererListener) {
        return NeboEngineJNI.PageController_exportAllToSVG(this.swigCPtr, this, str.getBytes(), iRendererListener);
    }

    public boolean exportAllToDocx(String str, IRendererListener iRendererListener) {
        return NeboEngineJNI.PageController_exportAllToDocx(this.swigCPtr, this, str.getBytes(), iRendererListener);
    }

    public boolean exportAllToJiix(String str) {
        return NeboEngineJNI.PageController_exportAllToJiix(this.swigCPtr, this, str.getBytes());
    }

    public boolean exportBoxToJiix(String str, String str2) {
        return NeboEngineJNI.PageController_exportBoxToJiix(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public boolean exportBoxToHTML(String str, String str2) {
        return NeboEngineJNI.PageController_exportBoxToHTML(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public String updateTextBox2(String str, String str2, boolean z) {
        return new String(NeboEngineJNI.PageController_updateTextBox2(this.swigCPtr, this, str.getBytes(), str2.getBytes(), z), StandardCharsets.UTF_8);
    }

    public boolean exportToPNG2(String str, String str2, IRendererListener iRendererListener, int i) {
        return NeboEngineJNI.PageController_exportToPNG2__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), iRendererListener, i);
    }

    public boolean exportToPNG2(String str, String str2, IRendererListener iRendererListener) {
        return NeboEngineJNI.PageController_exportToPNG2__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), iRendererListener);
    }

    public String getBoxId(int i) {
        return new String(NeboEngineJNI.PageController_getBoxId(this.swigCPtr, this, i), StandardCharsets.UTF_8);
    }

    public Extent getBoxExtent(String str) {
        return new Extent(NeboEngineJNI.PageController_getBoxExtent(this.swigCPtr, this, str.getBytes()), true);
    }

    public void setMotionPredictionParams(MotionPredictionParams motionPredictionParams) {
        NeboEngineJNI.PageController_setMotionPredictionParams(this.swigCPtr, this, MotionPredictionParams.getCPtr(motionPredictionParams), motionPredictionParams);
    }

    public void setEnablePartialInvalidates(boolean z) {
        NeboEngineJNI.PageController_setEnablePartialInvalidates(this.swigCPtr, this, z);
    }

    public void updateKeyboardModifiers(boolean z, boolean z2, boolean z3) {
        NeboEngineJNI.PageController_updateKeyboardModifiers(this.swigCPtr, this, z, z2, z3);
    }

    public void enableTapInteractionsToShowKeyboard(boolean z) {
        NeboEngineJNI.PageController_enableTapInteractionsToShowKeyboard(this.swigCPtr, this, z);
    }

    public void setEraserStylusButton(boolean z) {
        NeboEngineJNI.PageController_setEraserStylusButton(this.swigCPtr, this, z);
    }

    public void enableActivePen(boolean z) {
        NeboEngineJNI.PageController_enableActivePen(this.swigCPtr, this, z);
    }

    public void enableFreeformAligmentGuides(boolean z) {
        NeboEngineJNI.PageController_enableFreeformAligmentGuides(this.swigCPtr, this, z);
    }

    public boolean getFreeformAlignmentGuides() {
        return NeboEngineJNI.PageController_getFreeformAlignmentGuides(this.swigCPtr, this);
    }

    public enum InlineSelectionTextType {
        MIX_HANDWRITING_TYPESET,
        ONLY_HANDWRITING,
        ONLY_TYPESET,
        PDF_CONTENT,
        NONE;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static InlineSelectionTextType swigToEnum(int i) {
            InlineSelectionTextType[] inlineSelectionTextTypeArr = (InlineSelectionTextType[]) InlineSelectionTextType.class.getEnumConstants();
            if (i < inlineSelectionTextTypeArr.length && i >= 0) {
                InlineSelectionTextType inlineSelectionTextType = inlineSelectionTextTypeArr[i];
                if (inlineSelectionTextType.swigValue == i) {
                    return inlineSelectionTextType;
                }
            }
            for (InlineSelectionTextType inlineSelectionTextType2 : inlineSelectionTextTypeArr) {
                if (inlineSelectionTextType2.swigValue == i) {
                    return inlineSelectionTextType2;
                }
            }
            throw new IllegalArgumentException("No enum " + InlineSelectionTextType.class + " with value " + i);
        }

        InlineSelectionTextType() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        InlineSelectionTextType(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        InlineSelectionTextType(InlineSelectionTextType inlineSelectionTextType) {
            int i = inlineSelectionTextType.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
