package com.myscript.atk.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Renderer implements AutoCloseable {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Renderer(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Renderer renderer) {
        if (renderer == null) {
            return 0L;
        }
        return renderer.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Renderer(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public Renderer(Layout layout, SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t, SWIGTYPE_p_TileConfiguration sWIGTYPE_p_TileConfiguration) {
        this(ATKCoreJNI.new_Renderer__SWIG_0(Layout.getCPtr(layout), layout, SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t), SWIGTYPE_p_TileConfiguration.getCPtr(sWIGTYPE_p_TileConfiguration)), true);
    }

    public Renderer(Layout layout, SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t) {
        this(ATKCoreJNI.new_Renderer__SWIG_1(Layout.getCPtr(layout), layout, SWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__ProcessMonitor_t)), true);
    }

    public Renderer(Layout layout) {
        this(ATKCoreJNI.new_Renderer__SWIG_2(Layout.getCPtr(layout), layout), true);
    }

    public Layout getLayout() {
        return new Layout(ATKCoreJNI.Renderer_getLayout(this.swigCPtr, this), true);
    }

    public void setView(IPageView iPageView, ViewTransform viewTransform, String str) {
        ATKCoreJNI.Renderer_setView(this.swigCPtr, this, iPageView, ViewTransform.getCPtr(viewTransform), viewTransform, str.getBytes());
    }

    public ViewTransform viewTransform(boolean z) {
        long jRenderer_viewTransform__SWIG_0 = ATKCoreJNI.Renderer_viewTransform__SWIG_0(this.swigCPtr, this, z);
        if (jRenderer_viewTransform__SWIG_0 == 0) {
            return null;
        }
        return new ViewTransform(jRenderer_viewTransform__SWIG_0, true);
    }

    public ViewTransform viewTransform() {
        long jRenderer_viewTransform__SWIG_1 = ATKCoreJNI.Renderer_viewTransform__SWIG_1(this.swigCPtr, this);
        if (jRenderer_viewTransform__SWIG_1 == 0) {
            return null;
        }
        return new ViewTransform(jRenderer_viewTransform__SWIG_1, true);
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__TilesManager_t tilesManager() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__TilesManager_t(ATKCoreJNI.Renderer_tilesManager(this.swigCPtr, this), true);
    }

    public void setTempClipArea(Extent extent) {
        ATKCoreJNI.Renderer_setTempClipArea(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public long addTemporary(LayoutItem layoutItem, Transform transform, int i, float f, float f2, boolean z, boolean z2) {
        return ATKCoreJNI.Renderer_addTemporary__SWIG_0(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, Transform.getCPtr(transform), transform, i, f, f2, z, z2);
    }

    public long addTemporary(LayoutItem layoutItem, Transform transform, int i, float f, float f2, boolean z) {
        return ATKCoreJNI.Renderer_addTemporary__SWIG_1(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, Transform.getCPtr(transform), transform, i, f, f2, z);
    }

    public long addTemporary(LayoutItem layoutItem, Transform transform, int i, float f, float f2) {
        return ATKCoreJNI.Renderer_addTemporary__SWIG_2(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, Transform.getCPtr(transform), transform, i, f, f2);
    }

    public long addTemporary(LayoutItem layoutItem, Transform transform, int i, float f) {
        return ATKCoreJNI.Renderer_addTemporary__SWIG_3(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, Transform.getCPtr(transform), transform, i, f);
    }

    public long addTemporary(LayoutItem layoutItem, Transform transform, int i) {
        return ATKCoreJNI.Renderer_addTemporary__SWIG_4(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, Transform.getCPtr(transform), transform, i);
    }

    public long addTemporary(LayoutItem layoutItem, Transform transform) {
        return ATKCoreJNI.Renderer_addTemporary__SWIG_5(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, Transform.getCPtr(transform), transform);
    }

    public long addTemporary(LayoutItem layoutItem) {
        return ATKCoreJNI.Renderer_addTemporary__SWIG_6(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent, Transform transform, int i, float f, boolean z, float f2, boolean z2, boolean z3) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_0(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform, i, f, z, f2, z2, z3);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent, Transform transform, int i, float f, boolean z, float f2, boolean z2) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform, i, f, z, f2, z2);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent, Transform transform, int i, float f, boolean z, float f2) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_2(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform, i, f, z, f2);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent, Transform transform, int i, float f, boolean z) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_3(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform, i, f, z);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent, Transform transform, int i, float f) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_4(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform, i, f);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent, Transform transform, int i) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_5(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform, i);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent, Transform transform) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_6(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform);
    }

    public long addTemporaries(SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t, Extent extent) {
        return ATKCoreJNI.Renderer_addTemporaries__SWIG_7(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t), Extent.getCPtr(extent), extent);
    }

    public void updateTemporary(long j, float f) {
        ATKCoreJNI.Renderer_updateTemporary__SWIG_0(this.swigCPtr, this, j, f);
    }

    public void updateTemporary(long j, Transform transform) {
        ATKCoreJNI.Renderer_updateTemporary__SWIG_1(this.swigCPtr, this, j, Transform.getCPtr(transform), transform);
    }

    public Transform getTemporaryTransform(long j) {
        return new Transform(ATKCoreJNI.Renderer_getTemporaryTransform(this.swigCPtr, this, j), true);
    }

    public void updateTemporary(long j, Transform transform, int i, float f) {
        ATKCoreJNI.Renderer_updateTemporary__SWIG_2(this.swigCPtr, this, j, Transform.getCPtr(transform), transform, i, f);
    }

    public void updateTemporary(long j, Transform transform, int i) {
        ATKCoreJNI.Renderer_updateTemporary__SWIG_3(this.swigCPtr, this, j, Transform.getCPtr(transform), transform, i);
    }

    public void updateTemporary(long j, LayoutItem layoutItem) {
        ATKCoreJNI.Renderer_updateTemporary__SWIG_4(this.swigCPtr, this, j, LayoutItem.getCPtr(layoutItem), layoutItem);
    }

    public void resfreshTemporary(long j) {
        ATKCoreJNI.Renderer_resfreshTemporary(this.swigCPtr, this, j);
    }

    public void removeTemporary(long j) {
        ATKCoreJNI.Renderer_removeTemporary(this.swigCPtr, this, j);
    }

    public void applyAnimation(long j, SWIGTYPE_p_std__shared_ptrT_atk__core__animation__Animation_t sWIGTYPE_p_std__shared_ptrT_atk__core__animation__Animation_t) {
        ATKCoreJNI.Renderer_applyAnimation(this.swigCPtr, this, j, SWIGTYPE_p_std__shared_ptrT_atk__core__animation__Animation_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__animation__Animation_t));
    }

    public void restrictToLayers(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.Renderer_restrictToLayers(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void addToCutSelection(Selection selection) {
        ATKCoreJNI.Renderer_addToCutSelection(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }

    public void removeFromCutSelection(Selection selection) {
        ATKCoreJNI.Renderer_removeFromCutSelection(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }

    public void draw(Extent extent, InvalidateType invalidateType, Object obj) {
        ATKCoreJNI.Renderer_draw__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, invalidateType.swigValue(), obj);
    }

    public void draw(Extent extent, InvalidateType invalidateType) {
        ATKCoreJNI.Renderer_draw__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent, invalidateType.swigValue());
    }

    public void drawWithoutOffscreenRendering(Extent extent, InvalidateType invalidateType, Object obj) {
        ATKCoreJNI.Renderer_drawWithoutOffscreenRendering__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, invalidateType.swigValue(), obj);
    }

    public void drawWithoutOffscreenRendering(Extent extent, InvalidateType invalidateType) {
        ATKCoreJNI.Renderer_drawWithoutOffscreenRendering__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent, invalidateType.swigValue());
    }

    public void drawSync(Extent extent, InvalidateType invalidateType, Object obj) {
        ATKCoreJNI.Renderer_drawSync__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, invalidateType.swigValue(), obj);
    }

    public void drawSync(Extent extent, InvalidateType invalidateType) {
        ATKCoreJNI.Renderer_drawSync__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent, invalidateType.swigValue());
    }

    public void drawCapture(Extent extent, Object obj) {
        ATKCoreJNI.Renderer_drawCapture__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, obj);
    }

    public void drawCapture(Extent extent) {
        ATKCoreJNI.Renderer_drawCapture__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public boolean hasCaptureStrokes(boolean z) {
        return ATKCoreJNI.Renderer_hasCaptureStrokes__SWIG_0(this.swigCPtr, this, z);
    }

    public boolean hasCaptureStrokes() {
        return ATKCoreJNI.Renderer_hasCaptureStrokes__SWIG_1(this.swigCPtr, this);
    }

    public boolean isUserWriting() {
        return ATKCoreJNI.Renderer_isUserWriting(this.swigCPtr, this);
    }

    public void setViewport(Extent extent, ViewTransform viewTransform, boolean z) {
        ATKCoreJNI.Renderer_setViewport(this.swigCPtr, this, Extent.getCPtr(extent), extent, ViewTransform.getCPtr(viewTransform), viewTransform, z);
    }

    public Extent clampExtentToViewPort(Extent extent, float f, float f2) {
        return new Extent(ATKCoreJNI.Renderer_clampExtentToViewPort__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, f, f2), true);
    }

    public Extent clampExtentToViewPort(Extent extent, float f) {
        return new Extent(ATKCoreJNI.Renderer_clampExtentToViewPort__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent, f), true);
    }

    public Extent clampExtentToViewPort(Extent extent) {
        return new Extent(ATKCoreJNI.Renderer_clampExtentToViewPort__SWIG_2(this.swigCPtr, this, Extent.getCPtr(extent), extent), true);
    }

    public void useTiles(SWIGTYPE_p_TileConfiguration sWIGTYPE_p_TileConfiguration) {
        ATKCoreJNI.Renderer_useTiles(this.swigCPtr, this, SWIGTYPE_p_TileConfiguration.getCPtr(sWIGTYPE_p_TileConfiguration));
    }

    public void recreateDrawingSurfaces() {
        ATKCoreJNI.Renderer_recreateDrawingSurfaces(this.swigCPtr, this);
    }

    public void pauseRendering(boolean z) {
        ATKCoreJNI.Renderer_pauseRendering__SWIG_0(this.swigCPtr, this, z);
    }

    public void pauseRendering() {
        ATKCoreJNI.Renderer_pauseRendering__SWIG_1(this.swigCPtr, this);
    }

    public void resumeRendering() {
        ATKCoreJNI.Renderer_resumeRendering(this.swigCPtr, this);
    }

    public void forceRedraw() {
        ATKCoreJNI.Renderer_forceRedraw(this.swigCPtr, this);
    }

    public void startIntensiveOperations() {
        ATKCoreJNI.Renderer_startIntensiveOperations(this.swigCPtr, this);
    }

    public void endIntensiveOperations() {
        ATKCoreJNI.Renderer_endIntensiveOperations(this.swigCPtr, this);
    }

    public static Renderer newRef(Renderer renderer) {
        long jRenderer_newRef = ATKCoreJNI.Renderer_newRef(getCPtr(renderer), renderer);
        if (jRenderer_newRef == 0) {
            return null;
        }
        return new Renderer(jRenderer_newRef, true);
    }
}
