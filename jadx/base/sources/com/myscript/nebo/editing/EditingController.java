package com.myscript.nebo.editing;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.MotionPredictionParams;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.IUpdatableRendering;
import com.myscript.atk.text.CursorPlatformBehavior;
import com.myscript.atk.text.SetCursorBehavior;
import com.myscript.nebo.editing.debug.DebugView;
import com.myscript.nebo.editing.impl.keyboard.InputModel;
import com.myscript.nebo.editing.impl.keyboard.KeyboardListener;
import com.myscript.nebo.editing.impl.keyboard.RenderingViewKeyboardHandler;
import com.myscript.nebo.editing.impl.keyboard.cursor.CursorsView;
import com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager;
import com.myscript.nebo.editing.impl.p027ui.ContextualMenuManager;
import com.myscript.nebo.editing.impl.p027ui.CustomRenderedItemsConfiguration;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import com.myscript.nebo.editing.impl.p027ui.ITouchFeature;
import com.myscript.nebo.editing.impl.p027ui.NeboPageView;
import com.myscript.nebo.editing.impl.p027ui.NestedScrollableSwipeFilter;
import com.myscript.nebo.editing.impl.p027ui.RendererWrapper;
import com.myscript.nebo.editing.impl.p027ui.RendererWrapperImpl;
import com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactory;
import com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactoryProvider;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.snt.core.CompactMode;
import com.myscript.snt.core.IPageStateListener;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PaperSize;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes7.dex */
public class EditingController implements DocumentTouchController.ScrollListener, DocumentTouchController.ZoomListener, DocumentRenderingView.OnResizeListener {
    private static final boolean DBG = false;
    private static final CursorPlatformBehavior NEBO_ANDROID_CURSOR_BEHAVIOR;
    private static final int SEARCH_MARGIN_RESULT = 100;
    private static final String TAG = "EditingController";
    private static final float ZOOM_RATIO_OUTSIDE_LIMITS = 1.5f;
    private static final float ZOOM_STEP_FACTOR = 1.2f;
    private static final ExecutorService mPageControllerExecutor;
    private final ContextualMenuManager mContextualMenuManager;
    private DebugView mDebugView;
    private final DocumentTouchController mDocumentTouchController;
    private float mFontSize;
    private final InputModel mInputModel;
    private RenderingViewKeyboardHandler mKeyboardHandler;
    private final KeyboardListener mKeyboardListener;
    private float mLineHeight;
    private TechnicalLogger mLogger;
    private NeboPageView mPageView;
    private final RendererWrapper mRendererWrapper;
    private DocumentRenderingView mRenderingView;
    private final SelectionCursorManager mSelectionCursorManager;
    private SizeChangedListener mSizeChangedListener;
    private IUpdatableRendering mUpdatableRendering;
    private ZoomChangedListener mZoomChangedListener;
    private ZoomController mZoomController;
    private final PenConfig mPenConfigDelegate = new PenConfig() { // from class: com.myscript.nebo.editing.EditingController.1
        @Override // com.myscript.nebo.editing.EditingController.PenConfig
        public void setActivePenEnabled(boolean z) {
        }

        @Override // com.myscript.nebo.editing.EditingController.PenConfig
        public void setPenColor(int i) {
        }

        @Override // com.myscript.nebo.editing.EditingController.PenConfig
        public void setPenStroker(int i) {
        }

        @Override // com.myscript.nebo.editing.EditingController.PenConfig
        public void setPenWidth(float f) {
        }
    };
    private final IPageStateListener mPageStateListener = new IPageStateListener() { // from class: com.myscript.nebo.editing.EditingController.2
        @Override // com.myscript.snt.core.IPageStateListener
        public void pageStateChanged(boolean z, boolean z2, boolean z3) {
        }

        @Override // com.myscript.snt.core.IPageStateListener
        public void contentSizeChanged(Extent extent) {
            if (!EditingController.this.mLockResizeNotifications) {
                EditingController.this.resizeViews(extent);
            }
            if (extent != null) {
                extent.delete();
            }
        }

        @Override // com.myscript.snt.core.IPageStateListener
        public void initViewportRequested(float f, float f2, float f3) {
            EditingController.this.updateViewport(f, f2, f3, false);
        }

        @Override // com.myscript.snt.core.IPageStateListener
        public void updateViewportRequested(float f, float f2, float f3) {
            EditingController.this.updateViewport(f, f2, f3, true);
        }
    };
    private final AtomicReference<PageController> mPageController = new AtomicReference<>(null);
    private boolean mLockResizeNotifications = false;

    public interface PenConfig {
        void setActivePenEnabled(boolean z);

        void setPenColor(int i);

        void setPenStroker(int i);

        void setPenWidth(float f);
    }

    public interface SizeChangedListener {
        void afterOnSizeChanged(int i, int i2);

        void beforeOnSizeChanged(int i, int i2);
    }

    public interface ZoomChangedListener {
        void onZoomChanged(float f, boolean z);
    }

    public interface ZoomController {
        boolean checkZoomNotLocked();

        float currentZoom();

        void setZoomChangedListener(ZoomChangedListener zoomChangedListener);

        float zoom(float f, DocumentTouchController.ZoomListener.ZoomFromReference zoomFromReference, boolean z);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onHorizontalScrollDisabledChanged(boolean z) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoomEnded() {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoomStarted() {
    }

    static {
        CursorPlatformBehavior cursorPlatformBehavior = new CursorPlatformBehavior();
        NEBO_ANDROID_CURSOR_BEHAVIOR = cursorPlatformBehavior;
        cursorPlatformBehavior.setIsCursorSwapAllowed(true);
        cursorPlatformBehavior.setSetCursorBehavior(SetCursorBehavior.AT_TAP_LOCATION);
        cursorPlatformBehavior.setIsFullContext(false);
        mPageControllerExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.myscript.nebo.editing.EditingController$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return EditingController.lambda$static$0(runnable);
            }
        });
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "PageControllerWorker");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public EditingController(ViewGroup viewGroup, ContextualMenuManager contextualMenuManager) {
        this.mContextualMenuManager = contextualMenuManager;
        CursorsView cursorsView = null;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof IUpdatableRendering) {
                this.mUpdatableRendering = (IUpdatableRendering) childAt;
            }
            if (childAt instanceof DocumentRenderingView) {
                this.mRenderingView = (DocumentRenderingView) childAt;
            }
            if (childAt instanceof NestedScrollableSwipeFilter) {
                DocumentRenderingView documentRenderingView = (DocumentRenderingView) ((NestedScrollableSwipeFilter) childAt).getChildAt(0);
                this.mRenderingView = documentRenderingView;
                this.mUpdatableRendering = documentRenderingView;
            }
            if (childAt instanceof DebugView) {
                this.mDebugView = (DebugView) childAt;
            }
            if (childAt instanceof CursorsView) {
                cursorsView = (CursorsView) childAt;
            }
        }
        DocumentRenderingView documentRenderingView2 = this.mRenderingView;
        if (documentRenderingView2 == null) {
            throw new UnsupportedOperationException("DocumentRenderingView not found in view hierarchy");
        }
        if (this.mUpdatableRendering == null) {
            throw new UnsupportedOperationException("IUpdatableRendering implementation not found in view hierarchy");
        }
        this.mRendererWrapper = new RendererWrapperImpl(1, 1, CustomRenderedItemsConfiguration.from(documentRenderingView2.getContext()));
        DocumentTouchController documentTouchController = new DocumentTouchController((Context) Objects.requireNonNull(viewGroup.getContext()));
        this.mDocumentTouchController = documentTouchController;
        documentTouchController.setScrollEnabled(this.mRenderingView.isVerticalScrollBarEnabled() || this.mRenderingView.isHorizontalScrollBarEnabled());
        documentTouchController.addScrollListener(this);
        documentTouchController.addZoomListener(this);
        documentTouchController.addScrollListener(this.mRenderingView);
        this.mRenderingView.setEditingController(this);
        this.mRenderingView.setDocumentTouchController(documentTouchController);
        this.mRenderingView.setResizeListener(this);
        documentTouchController.setSize(this.mRenderingView.getWidth(), this.mRenderingView.getHeight());
        this.mFontSize = this.mRenderingView.getDefaultFontSize();
        this.mLineHeight = this.mRenderingView.getDefaultLineHeight();
        InputModel inputModel = new InputModel(new InputModel.ViewTransformProvider() { // from class: com.myscript.nebo.editing.EditingController$$ExternalSyntheticLambda0
            @Override // com.myscript.nebo.editing.impl.keyboard.InputModel.ViewTransformProvider
            public final ViewTransform getCurrentViewTransformNewRef() {
                return this.f$0.lambda$new$1();
            }
        });
        this.mInputModel = inputModel;
        final SelectionCursorManager selectionCursorManager = new SelectionCursorManager(this, this.mRenderingView, inputModel, this.mContextualMenuManager, documentTouchController, cursorsView);
        this.mSelectionCursorManager = selectionCursorManager;
        documentTouchController.addScrollListener(selectionCursorManager);
        documentTouchController.addZoomListener(selectionCursorManager);
        Objects.requireNonNull(selectionCursorManager);
        this.mKeyboardListener = new KeyboardListener(inputModel, new KeyboardListener.CursorSwappedListener() { // from class: com.myscript.nebo.editing.EditingController$$ExternalSyntheticLambda1
            @Override // com.myscript.nebo.editing.impl.keyboard.KeyboardListener.CursorSwappedListener
            public final void onCursorSwapped() {
                selectionCursorManager.swapCursors();
            }
        }, this.mRenderingView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ViewTransform lambda$new$1() {
        ViewTransform viewTransform;
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            viewTransform = null;
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
        return viewTransform;
    }

    public DocumentRenderingView getRenderingView() {
        return this.mRenderingView;
    }

    public Context getContext() {
        DocumentRenderingView documentRenderingView = this.mRenderingView;
        if (documentRenderingView != null) {
            return documentRenderingView.getContext();
        }
        return null;
    }

    public void setPageController(PageControllerState pageControllerState, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        setPageController(pageControllerState, z, z2, true, z3, z4, i);
    }

    public void setPageController(PageControllerState pageControllerState, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i) {
        PageController pageControllerNewRef;
        Context context = getContext();
        if (pageControllerState == null || context == null) {
            release();
            return;
        }
        if (this.mRenderingView == null || (pageControllerNewRef = PageController.newRef(pageControllerState.getPageController())) == null) {
            return;
        }
        this.mPageController.set(pageControllerNewRef);
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = new RenderingViewKeyboardHandler(this.mRenderingView, pageControllerNewRef, this.mInputModel, this.mSelectionCursorManager, this.mDocumentTouchController);
        this.mKeyboardHandler = renderingViewKeyboardHandler;
        this.mDocumentTouchController.addGestureListener(renderingViewKeyboardHandler);
        this.mDocumentTouchController.setSwipeEnabled(z);
        if (z) {
            pageControllerNewRef.addKeyboardListener(this.mKeyboardListener);
            pageControllerNewRef.setCursorPlatformBehavior(NEBO_ANDROID_CURSOR_BEHAVIOR);
            pageControllerNewRef.enableTapInteractionsToShowKeyboard(z2);
        }
        this.mLockResizeNotifications = true;
        pageControllerNewRef.addPageStateListener(this.mPageStateListener);
        this.mLockResizeNotifications = false;
        releaseRenderingData();
        this.mPageView = pageControllerState.getPageView();
        if (this.mUpdatableRendering != null) {
            Renderer renderer = pageControllerNewRef.getRenderer();
            try {
                ViewTransform viewTransform = pageControllerNewRef.getViewTransform();
                try {
                    this.mDocumentTouchController.configureRendering(pageControllerNewRef, viewTransform);
                    this.mPageView.setUpdatableRendering(this.mUpdatableRendering);
                    this.mPageView.setPixelSize(viewTransform.scaleY());
                    this.mRendererWrapper.bind(renderer, viewTransform);
                    this.mRenderingView.setRenderingThread(this.mRendererWrapper);
                    pageControllerNewRef.setEnablePartialInvalidates(true);
                    MotionPredictionParamsFactory motionPredictionParamsFactoryProvideMotionPredictionParamsFactory = ((MotionPredictionParamsFactoryProvider) this.mRenderingView.getContext().getApplicationContext()).provideMotionPredictionParamsFactory();
                    if (motionPredictionParamsFactoryProvideMotionPredictionParamsFactory.provideCustomMotionPredictionParams()) {
                        MotionPredictionParams motionPredictionParamsProvideMotionPredictionParams = motionPredictionParamsFactoryProvideMotionPredictionParamsFactory.provideMotionPredictionParams(getContext(), getRenderingView());
                        if (motionPredictionParamsProvideMotionPredictionParams != null) {
                            if (z5) {
                                motionPredictionParamsProvideMotionPredictionParams.setDurationMs(i);
                                motionPredictionParamsProvideMotionPredictionParams.setShowPredictionInRed(true);
                            }
                            pageControllerNewRef.setMotionPredictionParams(motionPredictionParamsProvideMotionPredictionParams);
                        } else {
                            MotionPredictionParams motionPredictionParamsDefaultMotionPredictionParams = motionPredictionParamsFactoryProvideMotionPredictionParamsFactory.defaultMotionPredictionParams();
                            if (z5) {
                                motionPredictionParamsDefaultMotionPredictionParams.setDurationMs(i);
                                motionPredictionParamsDefaultMotionPredictionParams.setShowPredictionInRed(true);
                            }
                            pageControllerNewRef.setMotionPredictionParams(motionPredictionParamsDefaultMotionPredictionParams);
                        }
                    } else {
                        MotionPredictionParams motionPredictionParamsDefaultMotionPredictionParams2 = motionPredictionParamsFactoryProvideMotionPredictionParamsFactory.defaultMotionPredictionParams();
                        if (z5) {
                            motionPredictionParamsDefaultMotionPredictionParams2.setDurationMs(i);
                            motionPredictionParamsDefaultMotionPredictionParams2.setShowPredictionInRed(true);
                        }
                        pageControllerNewRef.setMotionPredictionParams(motionPredictionParamsDefaultMotionPredictionParams2);
                    }
                    if (viewTransform != null) {
                        viewTransform.close();
                    }
                    if (renderer != null) {
                        renderer.close();
                    }
                } finally {
                }
            } finally {
            }
        } else {
            this.mRendererWrapper.unbind();
        }
        this.mRenderingView.configureKeyboardSupport(this.mKeyboardHandler);
        DebugView debugView = this.mDebugView;
        if (debugView != null) {
            debugView.setPageController(pageControllerNewRef);
        }
        scrollAtBottomByDefault(z4);
        setupDocumentViewPort();
        this.mRendererWrapper.setSize(this.mRenderingView.getWidth(), this.mRenderingView.getHeight());
    }

    public PageController getPageControllerNewRef() {
        return PageController.newRef(this.mPageController.get());
    }

    public Boolean isMagnifierShowing() {
        return this.mSelectionCursorManager.isMagnifierShowing();
    }

    private void releaseRenderingData() {
        NeboPageView neboPageView = this.mPageView;
        if (neboPageView != null) {
            neboPageView.setUpdatableRendering(null);
            this.mPageView = null;
        }
    }

    public void release() {
        releaseRenderingData();
        this.mRendererWrapper.release();
        this.mDocumentTouchController.release();
        DebugView debugView = this.mDebugView;
        if (debugView != null) {
            debugView.release();
            this.mDebugView = null;
        }
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandler;
        if (renderingViewKeyboardHandler != null) {
            this.mDocumentTouchController.removeGestureListener(renderingViewKeyboardHandler);
            this.mKeyboardHandler.unbind();
            this.mKeyboardHandler = null;
        }
        this.mSelectionCursorManager.hideCursorOrSelection();
        this.mSelectionCursorManager.cancelMessages();
        final PageController andSet = this.mPageController.getAndSet(null);
        if (andSet != null) {
            mPageControllerExecutor.execute(new Runnable() { // from class: com.myscript.nebo.editing.EditingController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$release$2(andSet);
                }
            });
        }
        DocumentRenderingView documentRenderingView = this.mRenderingView;
        if (documentRenderingView != null) {
            documentRenderingView.release();
        }
        this.mRenderingView = null;
        this.mUpdatableRendering = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(PageController pageController) {
        try {
            pageController.saveScrollPosition();
            pageController.removePageStateListener(this.mPageStateListener);
            pageController.removeKeyboardListener(this.mKeyboardListener);
            pageController.delete();
        } catch (Throwable th) {
            Log.w(TAG, "PageControllerExecutor failed", th);
            TechnicalLogger technicalLogger = this.mLogger;
            if (technicalLogger != null) {
                technicalLogger.logTrace("PageControllerExecutor failed: " + th);
            }
        }
    }

    public ITouchFeature getTouchFeatureImpl() {
        return this.mDocumentTouchController;
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollTo(int i, int i2) {
        scrollAt(i, i2, true);
        this.mContextualMenuManager.updateScrollPos(i, i2);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollEnd(int i, int i2) {
        scrollAt(i, i2, false);
        this.mContextualMenuManager.updateScrollPos(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[Catch: all -> 0x0025, SYNTHETIC, TryCatch #2 {all -> 0x0025, blocks: (B:14:0x0020, B:81:0x0125, B:78:0x0120, B:77:0x011d, B:74:0x0118), top: B:96:0x0020, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resizeViews(Extent extent) {
        ViewTransform viewTransform;
        ViewTransform viewTransform2;
        Throwable th;
        int iRound;
        boolean z;
        DocumentRenderingView documentRenderingView = this.mRenderingView;
        int width = documentRenderingView != null ? documentRenderingView.getWidth() : 0;
        DocumentRenderingView documentRenderingView2 = this.mRenderingView;
        int height = documentRenderingView2 != null ? documentRenderingView2.getHeight() : 0;
        if (width == 0 || height == 0) {
            return;
        }
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } finally {
            }
        } else {
            viewTransform = null;
        }
        ViewTransform viewTransform3 = viewTransform;
        if (pageControllerNewRef == null || viewTransform3 == null) {
            viewTransform2 = viewTransform3;
        } else {
            try {
                float fMapX = viewTransform3.mapX(extent.getXMin());
                float fMapX2 = viewTransform3.mapX(extent.getXMax());
                float fMapY = viewTransform3.mapY(extent.getYMin());
                float fMapY2 = viewTransform3.mapY(extent.getYMax());
                boolean isZoomAllowed = pageControllerNewRef.scrollBehavior().getIsZoomAllowed();
                float fZoomScale = viewTransform3.zoomScale();
                float f = 1.0f;
                if (isZoomAllowed && fZoomScale != 0.0f) {
                    f = 1.0f / fZoomScale;
                }
                Extent extentViewport = pageControllerNewRef.viewport();
                boolean zEmpty = extentViewport.empty();
                if (zEmpty) {
                    iRound = 0;
                } else {
                    try {
                        iRound = Math.round(viewTransform3.mapX(extentViewport.getXMin()));
                    } catch (Throwable th2) {
                        th = th2;
                        viewTransform2 = viewTransform3;
                        if (viewTransform2 != null) {
                        }
                    }
                }
                int iRound2 = !zEmpty ? Math.round(viewTransform3.mapY(extentViewport.getYMin())) : 0;
                float fMax = Math.max(fMapX, fMapX2);
                float fMax2 = Math.max(fMapY, fMapY2);
                float f2 = fMapY / f;
                float f3 = fMax2 / f;
                viewTransform2 = viewTransform3;
                try {
                    int iRound3 = Math.round(this.mDocumentTouchController.checkOverallHorizontalScrollPx(iRound, f, fMapX / f, fMax / f));
                    int iRound4 = Math.round(this.mDocumentTouchController.checkOverallVerticalScrollPx(iRound2, f, f2, f3));
                    boolean zIsEmpty = pageControllerNewRef.isEmpty();
                    boolean z2 = true;
                    if (isZoomAllowed) {
                        float minZoom = this.mDocumentTouchController.getMinZoom();
                        float maxZoom = this.mDocumentTouchController.getMaxZoom();
                        if (f >= minZoom) {
                            minZoom = f;
                        }
                        if (minZoom <= maxZoom) {
                            maxZoom = minZoom;
                        }
                        z = f != maxZoom;
                        f = maxZoom;
                    } else {
                        z = false;
                    }
                    boolean z3 = (zEmpty || (iRound == iRound3 && iRound2 == iRound4)) ? false : true;
                    pageControllerNewRef.setViewbox(iRound3, iRound4, extent.getWidth(), extent.getHeight());
                    if (!z3 || z || zIsEmpty) {
                        z2 = false;
                    }
                    this.mDocumentTouchController.setScrollsSettings(fMapX, fMax, fMapY, fMax2, iRound3, iRound4, f, z2);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (viewTransform2 != null) {
                        throw th;
                    }
                    try {
                        viewTransform2.close();
                        throw th;
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                viewTransform2 = viewTransform3;
            }
        }
        if (viewTransform2 != null) {
            viewTransform2.close();
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    public void updateViewport(float f, float f2, float f3, boolean z) {
        ViewTransform viewTransform;
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            viewTransform = null;
        }
        if (pageControllerNewRef != null && viewTransform != null) {
            try {
                ViewTransform viewTransform2 = new ViewTransform(viewTransform.dpiX(), viewTransform.dpiY());
                try {
                    viewTransform2.setZoomScale(1.0f / f3);
                    viewTransform2.setZoomOffset(viewTransform.zoomOffset());
                    int iRound = Math.round(viewTransform2.mapX(f));
                    int iRound2 = Math.round(viewTransform2.mapY(f2));
                    boolean z2 = Float.compare(viewTransform2.zoomScale(), viewTransform.zoomScale()) != 0;
                    if (z && !z2) {
                        this.mDocumentTouchController.animateScrollTo(iRound, iRound2);
                    } else {
                        this.mDocumentTouchController.setScrollsPositions(iRound, iRound2, f3, false);
                        this.mContextualMenuManager.updateScrollPos(iRound, iRound2);
                    }
                    this.mRendererWrapper.refreshCustomRenderedItems();
                    if (z) {
                        this.mDocumentTouchController.adjustToScrollRangesAnimated();
                    }
                    ZoomChangedListener zoomChangedListener = this.mZoomChangedListener;
                    if (zoomChangedListener != null) {
                        zoomChangedListener.onZoomChanged(f3, false);
                    }
                    viewTransform2.close();
                } finally {
                }
            } finally {
            }
        }
        if (viewTransform != null) {
            viewTransform.close();
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentRenderingView.OnResizeListener
    public void onBeforeResize(int i, int i2) {
        SizeChangedListener sizeChangedListener = this.mSizeChangedListener;
        if (sizeChangedListener != null) {
            sizeChangedListener.beforeOnSizeChanged(i, i2);
        }
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentRenderingView.OnResizeListener
    public void onResize(int i, int i2) {
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                pageControllerNewRef.saveScrollPosition();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
        this.mDocumentTouchController.setSize(i, i2);
        this.mRendererWrapper.setSize(i, i2);
        setupDocumentViewPort();
    }

    public void onFragmentSaveInstanceState() {
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandler;
        if (renderingViewKeyboardHandler != null) {
            renderingViewKeyboardHandler.enableFocusLostProcessing(false);
        }
    }

    public void onFragmentResume() {
        fakeTouch();
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandler;
        if (renderingViewKeyboardHandler != null) {
            renderingViewKeyboardHandler.enableFocusLostProcessing(true);
        }
    }

    public void enableKeyboard() {
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandler;
        if (renderingViewKeyboardHandler != null) {
            renderingViewKeyboardHandler.enableKeyboard();
        }
    }

    public void setPaperSize(PaperSize paperSize, int i) {
        Extent extent = paperSize.isUnlimited() ? null : new Extent(0.0f, 0.0f, paperSize.getWidth(), paperSize.getHeight());
        this.mRendererWrapper.setPageBounds(extent, i);
        this.mDocumentTouchController.setPaperSize(extent);
        DocumentRenderingView documentRenderingView = this.mRenderingView;
        if (documentRenderingView != null) {
            documentRenderingView.postInvalidate();
        }
    }

    public void setSearchHits(List<Extent> list) {
        this.mRendererWrapper.setExtentsForSearch(list);
        DocumentRenderingView documentRenderingView = this.mRenderingView;
        if (documentRenderingView != null) {
            documentRenderingView.postInvalidate();
        }
    }

    public void setSelectedHitIndex(Extent extent) {
        ViewTransform viewTransform;
        float x;
        float y;
        int i;
        int i2;
        if (this.mRenderingView == null) {
            return;
        }
        this.mRendererWrapper.setSelectedHitExtent(extent);
        if (extent == null) {
            return;
        }
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            viewTransform = null;
        }
        if (viewTransform != null) {
            try {
                Point map = viewTransform.map(extent.centroid());
                x = map.getX();
                y = map.getY();
            } finally {
            }
        } else {
            x = 0.0f;
            y = 0.0f;
        }
        if (viewTransform != null) {
            viewTransform.close();
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
        int horizontalScrollPos = this.mDocumentTouchController.getHorizontalScrollPos();
        int verticalScrollPos = this.mDocumentTouchController.getVerticalScrollPos();
        int width = this.mRenderingView.getWidth();
        int height = this.mRenderingView.getHeight();
        if (x > width + horizontalScrollPos) {
            i = ((int) x) - (width / 2);
        } else {
            i = x < ((float) horizontalScrollPos) ? ((int) x) - 100 : horizontalScrollPos;
        }
        if (y > height + verticalScrollPos) {
            i2 = ((int) y) - (height / 2);
        } else {
            i2 = y < ((float) verticalScrollPos) ? ((int) y) - 100 : verticalScrollPos;
        }
        if (horizontalScrollPos != i || verticalScrollPos != i2) {
            this.mDocumentTouchController.animateScrollTo(i, i2);
        }
        this.mRenderingView.postInvalidate();
    }

    public void setTextDisplaySettings(float f, float f2) {
        if (Float.compare(this.mFontSize, f) == 0 && Float.compare(this.mLineHeight, f2) == 0) {
            return;
        }
        this.mFontSize = f;
        this.mLineHeight = f2;
        setupDocumentViewPort();
    }

    public void setupDocumentViewPort() {
        DocumentRenderingView documentRenderingView = this.mRenderingView;
        if (documentRenderingView == null) {
            return;
        }
        int width = documentRenderingView.getWidth();
        int height = this.mRenderingView.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                this.mLockResizeNotifications = true;
                DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(this.mRenderingView.getContext());
                float f = width;
                float f2 = height;
                Point point = new Point(f, f2);
                Point point2 = new Point(f / fixedDisplayMetrics.density, f2 / fixedDisplayMetrics.density);
                TechnicalLogger technicalLogger = this.mLogger;
                if (technicalLogger != null) {
                    technicalLogger.logTrace("[" + TAG + "] Computing grid with " + fixedDisplayMetrics + ", Screen: " + point + ", Font-Size: " + this.mFontSize + ", Line-Height: " + this.mLineHeight);
                }
                pageControllerNewRef.computeGrid(fixedDisplayMetrics.xdpi, fixedDisplayMetrics.ydpi, point, point2, this.mFontSize, this.mLineHeight, true, true, CompactMode.DISABLED);
                pageControllerNewRef.reflow();
                this.mLockResizeNotifications = false;
            } finally {
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    public void computeGrid() {
        if (this.mRenderingView == null) {
            return;
        }
        this.mDocumentTouchController.cancelAnyZoomAdjustAnim();
        this.mDocumentTouchController.cancelAnyScroll();
        int width = this.mRenderingView.getWidth();
        int height = this.mRenderingView.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                this.mLockResizeNotifications = true;
                DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(this.mRenderingView.getContext());
                float f = width;
                float f2 = height;
                Point point = new Point(f, f2);
                Point point2 = new Point(f / fixedDisplayMetrics.density, f2 / fixedDisplayMetrics.density);
                TechnicalLogger technicalLogger = this.mLogger;
                if (technicalLogger != null) {
                    technicalLogger.logTrace("[" + TAG + "] Computing grid with " + fixedDisplayMetrics + ", Screen: " + point + ", Font-Size: " + this.mFontSize + ", Line-Height: " + this.mLineHeight);
                }
                pageControllerNewRef.computeGrid(fixedDisplayMetrics.xdpi, fixedDisplayMetrics.ydpi, point, point2, this.mFontSize, this.mLineHeight, true, true, CompactMode.DISABLED);
                this.mLockResizeNotifications = false;
                pageControllerNewRef.setProperty("scroll.restore.default.center.bottom.enable", false);
                adjustToScrollRanges();
            } finally {
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    public void adjustToScrollRanges() {
        this.mDocumentTouchController.adjustToScrollRanges();
    }

    public void fakeTouch() {
        DocumentRenderingView documentRenderingView = this.mRenderingView;
        if (documentRenderingView != null) {
            documentRenderingView.postInvalidate();
        }
    }

    public PenConfig getPenConfig() {
        return this.mPenConfigDelegate;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x005f A[Catch: all -> 0x000b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x000b, blocks: (B:4:0x0006, B:40:0x005f, B:50:0x0073, B:49:0x0070, B:52:0x0076, B:11:0x0013, B:13:0x002d, B:14:0x002e, B:38:0x0059, B:15:0x0030, B:18:0x0035, B:20:0x0039, B:21:0x003a, B:22:0x003c, B:24:0x0040, B:25:0x0042, B:28:0x0047, B:30:0x004b, B:31:0x004c, B:32:0x004e, B:35:0x0053, B:37:0x0057, B:46:0x006b), top: B:67:0x0006, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float zoom(float f, DocumentTouchController.ZoomListener.ZoomFromReference zoomFromReference, boolean z) {
        ViewTransform viewTransform;
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            viewTransform = null;
        }
        if (pageControllerNewRef == null || viewTransform == null) {
            if (viewTransform != null) {
                viewTransform.close();
            }
            if (pageControllerNewRef != null) {
                pageControllerNewRef.close();
            }
            return f;
        }
        try {
            Extent extentViewport = pageControllerNewRef.viewport();
            float xMin = extentViewport.getXMin();
            float yMin = extentViewport.getYMin();
            float width = extentViewport.getWidth();
            float height = extentViewport.getHeight();
            if (zoomFromReference == DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_TOP_CENTER) {
                width /= 2.0f;
            } else if (zoomFromReference != DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_TOP_RIGHT) {
                if (zoomFromReference != DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER_LEFT) {
                    if (zoomFromReference != DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER_RIGHT) {
                        if (zoomFromReference != DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_BOTTOM_LEFT) {
                            if (zoomFromReference == DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_BOTTOM_CENTER) {
                                width /= 2.0f;
                            } else if (zoomFromReference != DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_BOTTOM_RIGHT) {
                                if (zoomFromReference == DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER) {
                                    width /= 2.0f;
                                }
                            }
                            xMin += width;
                        }
                        yMin += height;
                    }
                    xMin += width;
                    height /= 2.0f;
                    yMin += height;
                } else {
                    height /= 2.0f;
                    yMin += height;
                }
                float fZoom = zoom(f, xMin, yMin, z);
                if (viewTransform != null) {
                    viewTransform.close();
                }
                if (pageControllerNewRef != null) {
                    pageControllerNewRef.close();
                }
                return fZoom;
            }
            xMin += width;
            float fZoom2 = zoom(f, xMin, yMin, z);
            if (viewTransform != null) {
            }
            if (pageControllerNewRef != null) {
            }
            return fZoom2;
        } finally {
        }
    }

    public float zoom(float f, float f2, float f3, boolean z) {
        ViewTransform viewTransform;
        if (this.mRenderingView == null) {
            return f;
        }
        float minZoom = this.mDocumentTouchController.getMinZoom();
        float fMin = Math.min(f, this.mDocumentTouchController.getMaxZoom() * 1.5f);
        float f4 = minZoom / 1.5f;
        if (f < f4) {
            fMin = f4;
        }
        int width = this.mRenderingView.getWidth();
        int height = this.mRenderingView.getHeight();
        if (width > 0 && height > 0) {
            PageController pageControllerNewRef = getPageControllerNewRef();
            if (pageControllerNewRef != null) {
                try {
                    viewTransform = pageControllerNewRef.getViewTransform();
                } catch (Throwable th) {
                    if (pageControllerNewRef != null) {
                        try {
                            pageControllerNewRef.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } else {
                viewTransform = null;
            }
            if (pageControllerNewRef != null && viewTransform != null) {
                try {
                    Extent extentViewport = pageControllerNewRef.viewport();
                    float xMin = extentViewport.getXMin();
                    float yMin = extentViewport.getYMin();
                    float fMapX = viewTransform.mapX(f2 - xMin);
                    float fMapY = viewTransform.mapY(f3 - yMin);
                    ViewTransform viewTransform2 = new ViewTransform(viewTransform.dpiX(), viewTransform.dpiY());
                    try {
                        viewTransform2.setZoomScale(1.0f / fMin);
                        float fMapX2 = viewTransform2.mapX(f2);
                        float fMapY2 = viewTransform2.mapY(f3);
                        this.mDocumentTouchController.setScrollsPositions(Math.round(fMapX2 - fMapX), Math.round(fMapY2 - fMapY), fMin, z);
                        this.mRendererWrapper.refreshCustomRenderedItems();
                        ZoomChangedListener zoomChangedListener = this.mZoomChangedListener;
                        if (zoomChangedListener != null) {
                            zoomChangedListener.onZoomChanged(fMin, z);
                        }
                        viewTransform2.close();
                    } finally {
                    }
                } finally {
                }
            }
            if (viewTransform != null) {
                viewTransform.close();
            }
            if (pageControllerNewRef != null) {
                pageControllerNewRef.close();
            }
        }
        return fMin;
    }

    public float zoomIn() {
        return zoom(currentZoom() * ZOOM_STEP_FACTOR, DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER, false);
    }

    public float zoomOut() {
        return zoom(currentZoom() / ZOOM_STEP_FACTOR, DocumentTouchController.ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER, false);
    }

    public float currentZoom() {
        return 1.0f / getZoomScale();
    }

    private float getZoomScale() {
        ViewTransform viewTransform;
        float fZoomScale;
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            viewTransform = null;
        }
        if (viewTransform != null) {
            try {
                fZoomScale = viewTransform.zoomScale();
            } finally {
            }
        } else {
            fZoomScale = 1.0f;
        }
        if (viewTransform != null) {
            viewTransform.close();
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
        return fZoomScale;
    }

    private void scrollAt(int i, int i2, boolean z) {
        ViewTransform viewTransform;
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            viewTransform = null;
        }
        if (viewTransform != null) {
            try {
                scrollAt(i, i2, 1.0f / viewTransform.zoomScale(), z);
            } finally {
            }
        }
        if (viewTransform != null) {
            viewTransform.close();
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    private void scrollAt(int i, int i2, float f, boolean z) {
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                if (this.mRenderingView != null) {
                    Extent extent = new Extent(i, i2, this.mRenderingView.getWidth() + i, this.mRenderingView.getHeight() + i2);
                    if (!extent.empty()) {
                        pageControllerNewRef.setViewport(extent, f, z);
                    }
                    this.mRenderingView.postInvalidate();
                }
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        this.mRendererWrapper.scrollAt(i, i2);
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoom(float f, float f2, float f3, boolean z) {
        ViewTransform viewTransform;
        ZoomController zoomController = this.mZoomController;
        if (zoomController == null || zoomController.checkZoomNotLocked()) {
            PageController pageControllerNewRef = getPageControllerNewRef();
            if (pageControllerNewRef != null) {
                try {
                    viewTransform = pageControllerNewRef.getViewTransform();
                } catch (Throwable th) {
                    if (pageControllerNewRef != null) {
                        try {
                            pageControllerNewRef.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } else {
                viewTransform = null;
            }
            if (pageControllerNewRef != null) {
                try {
                    if (this.mRenderingView != null) {
                        float fImapX = viewTransform.imapX(f2);
                        float fImapY = viewTransform.imapY(f3);
                        float fCurrentZoom = currentZoom() * f;
                        this.mDocumentTouchController.cancelAnyZoomAdjustAnim();
                        zoom(fCurrentZoom, fImapX, fImapY, z);
                    }
                } finally {
                }
            }
            if (viewTransform != null) {
                viewTransform.close();
            }
            if (pageControllerNewRef != null) {
                pageControllerNewRef.close();
            }
        }
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoom(float f, DocumentTouchController.ZoomListener.ZoomFromReference zoomFromReference, boolean z) {
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                if (this.mRenderingView != null) {
                    zoom(f, zoomFromReference, z);
                }
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoomAt(int i, int i2, float f, boolean z) {
        ZoomChangedListener zoomChangedListener;
        if (currentZoom() != f && (zoomChangedListener = this.mZoomChangedListener) != null) {
            zoomChangedListener.onZoomChanged(f, z);
        }
        scrollAt(i, i2, f, z);
    }

    public void setSizeChangedListener(SizeChangedListener sizeChangedListener) {
        this.mSizeChangedListener = sizeChangedListener;
    }

    public void setZoomChangedListener(ZoomChangedListener zoomChangedListener) {
        this.mZoomChangedListener = zoomChangedListener;
    }

    public Rect getVisibleRenderingArea() {
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandler;
        if (renderingViewKeyboardHandler != null) {
            return renderingViewKeyboardHandler.getVisibleRenderingArea();
        }
        return null;
    }

    public void setLogger(TechnicalLogger technicalLogger) {
        this.mLogger = technicalLogger;
        this.mContextualMenuManager.setLogger(technicalLogger);
    }

    public void setZoomController(ZoomController zoomController) {
        this.mZoomController = zoomController;
    }

    public void requestActionMenuDismiss() {
        if (this.mInputModel.hasPosition() || this.mInputModel.hasSelection()) {
            return;
        }
        this.mContextualMenuManager.requestActionMenuDismiss();
    }

    public void allowAdditionalSpaceForKeyboard(boolean z) {
        this.mDocumentTouchController.allowAdditionalSpaceForKeyboard(z);
    }

    public void scrollAtBottomByDefault(boolean z) {
        PageController pageControllerNewRef = getPageControllerNewRef();
        if (pageControllerNewRef != null) {
            try {
                pageControllerNewRef.setProperty("scroll.restore.default.center.bottom.enable", z);
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }
}
