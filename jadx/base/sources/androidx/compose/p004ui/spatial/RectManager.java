package androidx.compose.p004ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.compose.p004ui.Actual_jvmAndAndroidKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusTargetModifierNode;
import androidx.compose.p004ui.focus.FocusTargetNode;
import androidx.compose.p004ui.geometry.InlineClassHelperKt;
import androidx.compose.p004ui.geometry.MutableRect;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.Matrix;
import androidx.compose.p004ui.graphics.MatrixKt;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.node.DelegatableNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.DelegatingNode;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.LayoutNodeKt;
import androidx.compose.p004ui.node.MeasurePassDelegate;
import androidx.compose.p004ui.node.NodeChain;
import androidx.compose.p004ui.node.NodeCoordinator;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.node.OwnedLayer;
import androidx.compose.p004ui.semantics.SemanticsInfo;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.runtime.collection.MutableVector;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: RectManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u001f\u001a\u00020\u0016J5\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0006\u0010+\u001a\u00020\u0016J\u0006\u0010,\u001a\u00020\u0016J\u000e\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u0016J\u0016\u00100\u001a\u0004\u0018\u00010\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J:\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u0002082\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u001609J:\u0010;\u001a\u0002032\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u0002082\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u001609J\u0010\u0010<\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010\u0001J\u000e\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0004J\u001e\u0010@\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u0018J\u000e\u0010C\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0004J\u0015\u0010D\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u0004¢\u0006\u0004\bE\u0010FJ\f\u0010G\u001a\u00020\u0016*\u00020\u0004H\u0002J\u0010\u0010H\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0004H\u0002J\u0010\u0010K\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0004H\u0002J\u0014\u0010L\u001a\u00020\u0016*\u00020M2\u0006\u0010N\u001a\u00020JH\u0002J\f\u0010O\u001a\u00020\u0018*\u00020MH\u0002J\u0013\u0010P\u001a\u00020\"*\u00020\u0004H\u0002¢\u0006\u0004\bQ\u0010FJ\u000e\u0010R\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0004J\u001d\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020'H\u0000¢\u0006\u0002\bVJ7\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020'2\u0006\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020'2\u0006\u0010]\u001a\u00020'H\u0000¢\u0006\u0002\b^J1\u0010_\u001a\u00020\u0018*\u0002082\u0006\u0010Y\u001a\u00020'2\u0006\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020'H\u0000¢\u0006\u0002\b`J\u0019\u0010a\u001a\u00020\u0018*\u00020\u00042\u0006\u0010b\u001a\u00020\u0004H\u0000¢\u0006\u0002\bcJ\u000e\u0010d\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, m1599d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "executeDelayed", "Landroidx/compose/ui/spatial/ExecuteDelayed;", "<init>", "(Landroidx/collection/IntObjectMap;Landroidx/compose/ui/spatial/ExecuteDelayed;)V", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "getThrottledCallbacks$ui$annotations", "()V", "getThrottledCallbacks$ui", "()Landroidx/compose/ui/spatial/ThrottledCallbacks;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "isDirty", "", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "scheduledDispatchDeadline", "", "dispatchLambda", "invalidate", "updateOffsets", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "windowWidth", "", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "resetOffsets", "dispatchCallbacks", "scheduleDebounceCallback", "ensureSomethingScheduled", "removeScheduledCallback", "registerOnChangedCallback", "callback", "registerOnRectChangedCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnGlobalLayoutCallback", "unregisterOnChangedCallback", "token", "invalidateCallbacksFor", "layoutNode", "updateFlagsFor", "focusable", "gesturable", "recalculateRectIfDirty", "getOffsetFromRectListFor", "getOffsetFromRectListFor-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "resetHasPositionalLayerTransformationsForSubtreeIfNeeded", "insertOrUpdateTransformedNodeSubhierarchy", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "insertOrUpdateTransformedNode", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "hasPositionalLayerTransformations", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "remove", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui", "findFocusableNodeFromRect", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "containerId", "findFocusableNodeFromRect$ui", "intersects", "intersects$ui", "isDescendantOf", TtmlNode.RUBY_CONTAINER, "isDescendantOf$ui", "unsetHasCallbacksFor", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList<Function0<Unit>> callbacks;
    private final Function0<Unit> dispatchLambda;
    private Object dispatchToken;
    private final ExecuteDelayed executeDelayed;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap<LayoutNode> layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    /* JADX WARN: Multi-variable type inference failed */
    public RectManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getThrottledCallbacks$ui$annotations() {
    }

    public RectManager(IntObjectMap<LayoutNode> intObjectMap, ExecuteDelayed executeDelayed) {
        this.layoutNodes = intObjectMap;
        this.executeDelayed = executeDelayed;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList<>(0, 1, null);
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.dispatchToken = null;
                RectManager rectManager = this.this$0;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        };
        this.cachedRect = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ RectManager(IntObjectMap intObjectMap, ExecuteDelayUsingPostAndRemove executeDelayUsingPostAndRemove, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IntObjectMapKt.intObjectMapOf() : intObjectMap, (i & 2) != 0 ? ExecuteDelayUsingPostAndRemove.INSTANCE : executeDelayUsingPostAndRemove);
    }

    public final RectList getRects() {
        return this.rects;
    }

    /* JADX INFO: renamed from: getThrottledCallbacks$ui, reason: from getter */
    public final ThrottledCallbacks getThrottledCallbacks() {
        return this.throttledCallbacks;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    /* JADX INFO: renamed from: updateOffsets-gTq6Wqs, reason: not valid java name */
    public final void m10217updateOffsetsgTq6Wqs(long screenOffset, long windowOffset, float[] viewToWindowMatrix, int windowWidth, int windowHeight) {
        int iM10220analyzeComponents58bKbWc = RectManagerKt.m10220analyzeComponents58bKbWc(viewToWindowMatrix);
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if ((iM10220analyzeComponents58bKbWc & 2) != 0) {
            viewToWindowMatrix = null;
        }
        this.isScreenOrWindowDirty = throttledCallbacks.m10234updateOffsetsLDcG7Xg(screenOffset, windowOffset, viewToWindowMatrix, windowWidth, windowHeight) || this.isScreenOrWindowDirty;
    }

    public final void resetOffsets() {
        this.isScreenOrWindowDirty = this.throttledCallbacks.m10234updateOffsetsLDcG7Xg(IntOffset.INSTANCE.m11156getZeronOccac(), IntOffset.INSTANCE.m11156getZeronOccac(), null, 0, 0);
    }

    public final void dispatchCallbacks() {
        removeScheduledCallback();
        long jCurrentTimeMillis = Actual_jvmAndAndroidKt.currentTimeMillis();
        boolean z = this.isDirty;
        boolean z2 = z || this.isScreenOrWindowDirty;
        if (z) {
            this.isDirty = false;
            MutableObjectList<Function0<Unit>> mutableObjectList = this.callbacks;
            Object[] objArr = mutableObjectList.content;
            int i = mutableObjectList._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((Function0) objArr[i2]).invoke();
            }
            RectList rectList = this.rects;
            long[] jArr = rectList.items;
            int i3 = rectList.itemsSize;
            for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
                long j = jArr[i4 + 2];
                if ((((int) (j >> 60)) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(33554431 & ((int) j), jArr[i4], jArr[i4 + 1], jCurrentTimeMillis);
                }
            }
            this.rects.clearUpdated();
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            this.throttledCallbacks.fireOnRectChangedEntries(jCurrentTimeMillis);
        }
        if (z2) {
            this.throttledCallbacks.fireGlobalChangeEntries(jCurrentTimeMillis);
        }
        if (this.isFragmented) {
            this.isFragmented = false;
            this.rects.defragment();
        }
        this.throttledCallbacks.triggerDebounced(jCurrentTimeMillis);
        if (this.throttledCallbacks.getMinDebounceDeadline() > 0) {
            scheduleDebounceCallback(true);
        }
    }

    public final void scheduleDebounceCallback(boolean ensureSomethingScheduled) {
        boolean z = (ensureSomethingScheduled && this.dispatchToken == null) ? false : true;
        long minDebounceDeadline = this.throttledCallbacks.getMinDebounceDeadline();
        if (minDebounceDeadline >= 0 || !z) {
            if (this.scheduledDispatchDeadline == minDebounceDeadline && z) {
                return;
            }
            Object obj = this.dispatchToken;
            if (obj != null) {
                this.executeDelayed.removeDelayedExecution(obj);
            }
            long jCurrentTimeMillis = Actual_jvmAndAndroidKt.currentTimeMillis();
            long jMax = Math.max(minDebounceDeadline, ((long) 16) + jCurrentTimeMillis);
            this.scheduledDispatchDeadline = jMax;
            this.dispatchToken = this.executeDelayed.executeDelayed(jMax - jCurrentTimeMillis, this.dispatchLambda);
        }
    }

    public final void removeScheduledCallback() {
        Object obj = this.dispatchToken;
        if (obj != null) {
            this.executeDelayed.removeDelayedExecution(obj);
            this.dispatchToken = null;
        }
    }

    public final Object registerOnChangedCallback(Function0<Unit> callback) {
        this.callbacks.add(callback);
        return callback;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        DelegatableNode.RegistrationHandle registrationHandleRegisterOnRectChanged = this.throttledCallbacks.registerOnRectChanged(id, throttleMillis, debounceMillis, node, callback);
        if (DelegatableNodeKt.requireLayoutNode(node.getNode()).getAddedToRectList()) {
            this.rects.updateHasCallbacks(id, true);
        }
        invalidate();
        scheduleDebounceCallback(true);
        return registrationHandleRegisterOnRectChanged;
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalLayoutCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        return this.throttledCallbacks.registerOnGlobalChange(id, throttleMillis, debounceMillis, node, callback);
    }

    public final void unregisterOnChangedCallback(Object token) {
        if ((TypeIntrinsics.isFunctionOfArity(token, 0) ? (Function0) token : null) == null) {
            return;
        }
        this.callbacks.remove(token);
    }

    public final void invalidateCallbacksFor(LayoutNode layoutNode) {
        if (layoutNode.getAddedToRectList()) {
            this.isDirty = true;
            this.rects.markUpdated(layoutNode.getSemanticsId());
        }
        scheduleDebounceCallback(true);
    }

    public final void updateFlagsFor(LayoutNode layoutNode, boolean focusable, boolean gesturable) {
        if (layoutNode.isAttached()) {
            this.rects.updateFlagsFor(layoutNode.getSemanticsId(), focusable, gesturable);
        }
    }

    public final void recalculateRectIfDirty(LayoutNode layoutNode) {
        long jM11155getMaxnOccac;
        if (layoutNode.isPlaced() && layoutNode.getRectInParentDirty()) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if (parent$ui != null && !parent$ui.getHasPositionalLayerTransformationsInOffsetFromRoot()) {
                if (parent$ui.getOuterToInnerOffsetDirty()) {
                    parent$ui.setOuterToInnerOffsetDirty$ui(false);
                    parent$ui.m9857setOuterToInnerOffsetgyyYBs$ui(m10215outerToInnerOffsetBjo55l4(parent$ui));
                }
                jM11155getMaxnOccac = parent$ui.getOuterToInnerOffset();
            } else if (parent$ui == null) {
                jM11155getMaxnOccac = IntOffset.INSTANCE.m11156getZeronOccac();
            } else {
                jM11155getMaxnOccac = IntOffset.INSTANCE.m11155getMaxnOccac();
            }
            NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
            if (RectManagerKt.m10221isSetgyyYBs(jM11155getMaxnOccac) && !hasPositionalLayerTransformations(outerCoordinator$ui)) {
                if (!layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot()) {
                    long jM11149plusqkQi6aY = IntOffset.m11149plusqkQi6aY(jM11155getMaxnOccac, outerCoordinator$ui.getPosition());
                    MeasurePassDelegate measurePassDelegate$ui = layoutNode.getMeasurePassDelegate$ui();
                    int measuredWidth = measurePassDelegate$ui.getMeasuredWidth();
                    int measuredHeight = measurePassDelegate$ui.getMeasuredHeight();
                    int semanticsId = layoutNode.getSemanticsId();
                    if (!layoutNode.getAddedToRectList()) {
                        layoutNode.setAddedToRectList$ui(true);
                        boolean zM9903hasH91voCI$ui = layoutNode.getNodes().m9903hasH91voCI$ui(NodeKind.m9943constructorimpl(1024));
                        boolean zM9903hasH91voCI$ui2 = layoutNode.getNodes().m9903hasH91voCI$ui(NodeKind.m9943constructorimpl(16));
                        boolean zContainsKey = this.throttledCallbacks.getRectChangedMap().containsKey(semanticsId);
                        if (parent$ui != null) {
                            this.rects.insertBasedOnParentOffset(semanticsId, parent$ui.getSemanticsId(), IntOffset.m11145getXimpl(jM11149plusqkQi6aY), IntOffset.m11146getYimpl(jM11149plusqkQi6aY), measuredWidth, measuredHeight, zM9903hasH91voCI$ui, zM9903hasH91voCI$ui2, zContainsKey);
                        } else {
                            RectList.insert$default(this.rects, semanticsId, IntOffset.m11145getXimpl(jM11149plusqkQi6aY), IntOffset.m11146getYimpl(jM11149plusqkQi6aY), IntOffset.m11145getXimpl(jM11149plusqkQi6aY) + measuredWidth, IntOffset.m11146getYimpl(jM11149plusqkQi6aY) + measuredHeight, 0, zM9903hasH91voCI$ui, zM9903hasH91voCI$ui2, zContainsKey, 0, 544, null);
                        }
                    } else if (parent$ui != null) {
                        this.rects.moveBasedOnParentOffset(semanticsId, parent$ui.getSemanticsId(), IntOffset.m11145getXimpl(jM11149plusqkQi6aY), IntOffset.m11146getYimpl(jM11149plusqkQi6aY), measuredWidth, measuredHeight);
                    } else {
                        this.rects.move(semanticsId, IntOffset.m11145getXimpl(jM11149plusqkQi6aY), IntOffset.m11146getYimpl(jM11149plusqkQi6aY), IntOffset.m11145getXimpl(jM11149plusqkQi6aY) + measuredWidth, IntOffset.m11146getYimpl(jM11149plusqkQi6aY) + measuredHeight);
                    }
                } else {
                    insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                    resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNode);
                }
            } else {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
            }
            layoutNode.setRectInParentDirty$ui(false);
            invalidate();
            scheduleDebounceCallback(true);
        }
    }

    /* JADX INFO: renamed from: getOffsetFromRectListFor-Bjo55l4, reason: not valid java name */
    public final long m10216getOffsetFromRectListForBjo55l4(LayoutNode layoutNode) {
        long topLeft = this.rects.getTopLeft(layoutNode.getSemanticsId());
        if (topLeft == Long.MAX_VALUE) {
            return IntOffset.INSTANCE.m11155getMaxnOccac();
        }
        return IntOffset.m11139constructorimpl((((long) ((int) (topLeft >> 32))) << 32) | (((long) ((int) topLeft)) & 4294967295L));
    }

    private final void resetHasPositionalLayerTransformationsForSubtreeIfNeeded(LayoutNode layoutNode) {
        if (!layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot() || hasPositionalLayerTransformations(layoutNode.getOuterCoordinator$ui())) {
            return;
        }
        layoutNode.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(false);
        if (layoutNode.getOuterToInnerOffsetDirty()) {
            layoutNode.m9857setOuterToInnerOffsetgyyYBs$ui(m10215outerToInnerOffsetBjo55l4(layoutNode));
            layoutNode.setOuterToInnerOffsetDirty$ui(false);
        }
        if (IntOffset.m11144equalsimpl0(layoutNode.getOuterToInnerOffset(), IntOffset.INSTANCE.m11155getMaxnOccac())) {
            return;
        }
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNodeArr[i]);
        }
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        insertOrUpdateTransformedNode(layoutNode);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.isPlaced()) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
            }
        }
    }

    private final void insertOrUpdateTransformedNode(LayoutNode layoutNode) {
        layoutNode.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(true);
        NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
        MeasurePassDelegate measurePassDelegate$ui = layoutNode.getMeasurePassDelegate$ui();
        int measuredWidth = measurePassDelegate$ui.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        boundingRectInRoot(outerCoordinator$ui, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        boolean addedToRectList = layoutNode.getAddedToRectList();
        layoutNode.setAddedToRectList$ui(true);
        if (!addedToRectList || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            RectList.insert$default(this.rects, semanticsId, left, top, right, bottom, parent$ui != null ? parent$ui.getSemanticsId() : -1, layoutNode.getNodes().m9903hasH91voCI$ui(NodeKind.m9943constructorimpl(1024)), layoutNode.getNodes().m9903hasH91voCI$ui(NodeKind.m9943constructorimpl(16)), this.throttledCallbacks.getRectChangedMap().containsKey(semanticsId), 0, 512, null);
        }
        layoutNode.setRectInParentDirty$ui(false);
        invalidate();
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
            if (nodeCoordinator == layoutNode.getOuterCoordinator$ui() && !layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot()) {
                long jM10216getOffsetFromRectListForBjo55l4 = m10216getOffsetFromRectListForBjo55l4(layoutNode);
                if (!IntOffset.m11144equalsimpl0(jM10216getOffsetFromRectListForBjo55l4, IntOffset.INSTANCE.m11155getMaxnOccac())) {
                    float fM11145getXimpl = IntOffset.m11145getXimpl(jM10216getOffsetFromRectListForBjo55l4);
                    mutableRect.m7888translatek4lQ0M(Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m11146getYimpl(jM10216getOffsetFromRectListForBjo55l4))) & 4294967295L) | (Float.floatToRawIntBits(fM11145getXimpl) << 32)));
                    return;
                }
            }
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                float[] fArrMo10000getUnderlyingMatrixsQKQjiQ = layer.mo10000getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m8419isIdentity58bKbWc(fArrMo10000getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m8402mapimpl(fArrMo10000getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
            long position = nodeCoordinator.getPosition();
            float fM11145getXimpl2 = IntOffset.m11145getXimpl(position);
            mutableRect.m7888translatek4lQ0M(Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m11146getYimpl(position))) & 4294967295L) | (Float.floatToRawIntBits(fM11145getXimpl2) << 32)));
            nodeCoordinator = nodeCoordinator.getWrappedBy();
        }
    }

    private final boolean hasPositionalLayerTransformations(NodeCoordinator nodeCoordinator) {
        OwnedLayer layer = nodeCoordinator.getLayer();
        return (layer == null || MatrixKt.m8419isIdentity58bKbWc(layer.mo10000getUnderlyingMatrixsQKQjiQ())) ? false : true;
    }

    /* JADX INFO: renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    private final long m10215outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
        long jM11156getZeronOccac = IntOffset.INSTANCE.m11156getZeronOccac();
        for (NodeCoordinator innerCoordinator$ui = layoutNode.getInnerCoordinator$ui(); innerCoordinator$ui != null && innerCoordinator$ui != outerCoordinator$ui; innerCoordinator$ui = innerCoordinator$ui.getWrappedBy()) {
            if (hasPositionalLayerTransformations(innerCoordinator$ui)) {
                return IntOffset.INSTANCE.m11155getMaxnOccac();
            }
            jM11156getZeronOccac = IntOffset.m11149plusqkQi6aY(jM11156getZeronOccac, innerCoordinator$ui.getPosition());
        }
        return jM11156getZeronOccac;
    }

    public final void remove(LayoutNode layoutNode) {
        if (layoutNode.getAddedToRectList()) {
            this.rects.remove(layoutNode.getSemanticsId());
            layoutNode.setAddedToRectList$ui(false);
            layoutNode.setRectInParentDirty$ui(true);
            invalidate();
            this.isFragmented = true;
        }
    }

    public final boolean isTargetDrawnFirst$ui(int targetId, int otherId) {
        LayoutNode parent$ui;
        LayoutNode parent$ui2;
        LayoutNode parent$ui3 = this.layoutNodes.get(targetId);
        if (parent$ui3 != null && (parent$ui = this.layoutNodes.get(otherId)) != null && parent$ui3.getDepth() != 0 && parent$ui.getDepth() != 0) {
            while (parent$ui3.getDepth() > parent$ui.getDepth()) {
                parent$ui3 = parent$ui3.getParent$ui();
                if (parent$ui3 == null) {
                    return false;
                }
            }
            if (parent$ui3 == parent$ui) {
                return false;
            }
            while (parent$ui.getDepth() > parent$ui3.getDepth()) {
                parent$ui = parent$ui.getParent$ui();
                if (parent$ui == null) {
                    return false;
                }
            }
            if (parent$ui3 == parent$ui) {
                return false;
            }
            LayoutNode layoutNode = parent$ui;
            LayoutNode layoutNode2 = layoutNode;
            LayoutNode layoutNode3 = parent$ui3;
            while (parent$ui3 != layoutNode) {
                LayoutNode parent$ui4 = parent$ui3.getParent$ui();
                if (parent$ui4 == null || (parent$ui2 = layoutNode.getParent$ui()) == null) {
                    return false;
                }
                layoutNode3 = parent$ui3;
                parent$ui3 = parent$ui4;
                layoutNode2 = layoutNode;
                layoutNode = parent$ui2;
            }
            if (layoutNode3.getMeasurePassDelegate$ui().getZIndex() == layoutNode2.getMeasurePassDelegate$ui().getZIndex()) {
                return layoutNode3.getPlaceOrder$ui() < layoutNode2.getPlaceOrder$ui();
            }
            if (layoutNode3.getMeasurePassDelegate$ui().getZIndex() < layoutNode2.getMeasurePassDelegate$ui().getZIndex()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final FocusTargetModifierNode findFocusableNodeFromRect$ui(int left, int top, int right, int bottom, int containerId) {
        int i;
        LayoutNode layoutNode;
        int i2;
        LayoutNode layoutNode2;
        byte b;
        Modifier.Node nodePop;
        FocusTargetNode focusTargetNode;
        int i3;
        LayoutNode layoutNode3;
        boolean z;
        int i4;
        LayoutNode layoutNode4;
        int i5;
        MutableVector mutableVector;
        SemanticsInfo semanticsInfoRequireSemanticsInfo;
        RectManager rectManager = this;
        LayoutNode layoutNode5 = rectManager.layoutNodes.get(containerId);
        if (layoutNode5 == null) {
            return null;
        }
        FocusTargetNode activeFocusTargetNode = LayoutNodeKt.requireOwner(layoutNode5).getFocusOwner().getActiveFocusTargetNode();
        int semanticsId = (activeFocusTargetNode == null || (semanticsInfoRequireSemanticsInfo = DelegatableNodeKt.requireSemanticsInfo(activeFocusTargetNode)) == null) ? -1 : semanticsInfoRequireSemanticsInfo.getSemanticsId();
        RectList rectList = rectManager.rects;
        int i6 = top;
        long j = (((long) i6) & 4294967295L) | (((long) left) << 32);
        long j2 = (((long) bottom) & 4294967295L) | (((long) right) << 32);
        long[] jArr = rectList.items;
        int i7 = rectList.itemsSize;
        int depth = Integer.MAX_VALUE;
        FocusTargetNode focusTargetNode2 = null;
        int i8 = 0;
        while (i8 < jArr.length - 2 && i8 < i7) {
            int i9 = i8;
            long j3 = jArr[i8 + 2];
            boolean z2 = true;
            if ((((int) (j3 >> 61)) & 1) != 0) {
                if (((((j2 - jArr[i9]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i9 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0 || (layoutNode2 = rectManager.layoutNodes.get((i2 = ((int) j3) & 33554431))) == null) {
                    i = depth;
                    layoutNode = layoutNode5;
                } else {
                    if (semanticsId == i2) {
                        b = -1;
                        if (semanticsId != -1) {
                            return null;
                        }
                    } else {
                        b = -1;
                    }
                    if (layoutNode2.getDepth() >= depth || !rectManager.isDescendantOf$ui(layoutNode2, layoutNode5)) {
                        i = depth;
                        layoutNode = layoutNode5;
                    } else {
                        NodeChain nodes = layoutNode2.getNodes();
                        int iM9943constructorimpl = NodeKind.m9943constructorimpl(1024);
                        if ((nodes.getAggregateChildKindSet() & iM9943constructorimpl) == 0) {
                            i = depth;
                            layoutNode = layoutNode5;
                            nodePop = null;
                            focusTargetNode = (FocusTargetNode) nodePop;
                            if (focusTargetNode == null) {
                            }
                        } else {
                            Modifier.Node head = nodes.getHead();
                            while (head != null) {
                                if ((head.getKindSet() & iM9943constructorimpl) != 0) {
                                    MutableVector mutableVector2 = null;
                                    nodePop = head;
                                    while (nodePop != null) {
                                        if (nodePop instanceof FocusTargetNode) {
                                            i = depth;
                                            layoutNode = layoutNode5;
                                            break;
                                        }
                                        if ((nodePop.getKindSet() & iM9943constructorimpl) == 0 || !(nodePop instanceof DelegatingNode)) {
                                            i3 = depth;
                                            layoutNode3 = layoutNode5;
                                            z = true;
                                        } else {
                                            Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                            int i10 = 0;
                                            while (delegate != null) {
                                                if ((delegate.getKindSet() & iM9943constructorimpl) != 0) {
                                                    i10++;
                                                    i4 = depth;
                                                    if (i10 == 1) {
                                                        nodePop = delegate;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            i5 = i10;
                                                            layoutNode4 = layoutNode5;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            i5 = i10;
                                                            layoutNode4 = layoutNode5;
                                                            mutableVector = mutableVector2;
                                                        }
                                                        if (nodePop != null) {
                                                            if (mutableVector != null) {
                                                                mutableVector.add(nodePop);
                                                            }
                                                            nodePop = null;
                                                        }
                                                        if (mutableVector != null) {
                                                            mutableVector.add(delegate);
                                                        }
                                                        mutableVector2 = mutableVector;
                                                        i10 = i5;
                                                        delegate = delegate.getChild();
                                                        depth = i4;
                                                        layoutNode5 = layoutNode4;
                                                    }
                                                } else {
                                                    i4 = depth;
                                                }
                                                layoutNode4 = layoutNode5;
                                                delegate = delegate.getChild();
                                                depth = i4;
                                                layoutNode5 = layoutNode4;
                                            }
                                            i3 = depth;
                                            layoutNode3 = layoutNode5;
                                            z = true;
                                            if (i10 == 1) {
                                            }
                                            z2 = z;
                                            depth = i3;
                                            layoutNode5 = layoutNode3;
                                        }
                                        nodePop = DelegatableNodeKt.pop(mutableVector2);
                                        z2 = z;
                                        depth = i3;
                                        layoutNode5 = layoutNode3;
                                    }
                                }
                                i = depth;
                                boolean z3 = z2;
                                layoutNode = layoutNode5;
                                if ((head.getAggregateChildKindSet() & iM9943constructorimpl) == 0) {
                                    break;
                                }
                                head = head.getChild();
                                z2 = z3;
                                depth = i;
                                layoutNode5 = layoutNode;
                            }
                            i = depth;
                            layoutNode = layoutNode5;
                            nodePop = null;
                            focusTargetNode = (FocusTargetNode) nodePop;
                            if (focusTargetNode == null) {
                                if (intersects$ui(focusTargetNode, left, i6, right, bottom)) {
                                    depth = layoutNode2.getDepth();
                                    focusTargetNode2 = focusTargetNode;
                                }
                            }
                        }
                    }
                    depth = i;
                }
                depth = i;
            } else {
                i = depth;
                layoutNode = layoutNode5;
                depth = i;
            }
            i8 = i9 + 3;
            rectManager = this;
            i6 = top;
            layoutNode5 = layoutNode;
        }
        return focusTargetNode2;
    }

    public final boolean isDescendantOf$ui(LayoutNode layoutNode, LayoutNode layoutNode2) {
        int depth = layoutNode.getDepth() - layoutNode2.getDepth();
        if (depth <= 0) {
            return false;
        }
        for (int i = 0; i < depth; i++) {
            layoutNode = layoutNode.getParent$ui();
            if (layoutNode == null) {
                return false;
            }
        }
        return layoutNode == layoutNode2;
    }

    public final void unsetHasCallbacksFor(LayoutNode layoutNode) {
        this.rects.updateHasCallbacks(layoutNode.getSemanticsId(), false);
    }

    public final boolean intersects$ui(DelegatableNode delegatableNode, int i, int i2, int i3, int i4) {
        NodeCoordinator nodeCoordinatorM9797requireCoordinator64DMado = DelegatableNodeKt.m9797requireCoordinator64DMado(delegatableNode, NodeKind.m9943constructorimpl(1024));
        LayoutNode layoutNode = nodeCoordinatorM9797requireCoordinator64DMado.getLayoutNode();
        if (Intrinsics.areEqual(nodeCoordinatorM9797requireCoordinator64DMado, layoutNode.getOuterCoordinator$ui())) {
            return true;
        }
        long jMo9636localToRootMKHz9U = layoutNode.getOuterCoordinator$ui().mo9636localToRootMKHz9U(LayoutCoordinates.m9632localPositionOfS_NoaFU$default(layoutNode.getOuterCoordinator$ui(), nodeCoordinatorM9797requireCoordinator64DMado, 0L, false, 6, null));
        long jMo9633getSizeYbymL2g = nodeCoordinatorM9797requireCoordinator64DMado.mo9633getSizeYbymL2g();
        int iRound = Math.round(Float.intBitsToFloat((int) (jMo9636localToRootMKHz9U >> 32)));
        int i5 = ((int) (jMo9633getSizeYbymL2g >> 32)) + iRound;
        int iRound2 = Math.round(Float.intBitsToFloat((int) (jMo9636localToRootMKHz9U & 4294967295L)));
        return i < i5 && i3 > iRound && i2 < ((int) (jMo9633getSizeYbymL2g & 4294967295L)) + iRound2 && i4 > iRound2;
    }
}
