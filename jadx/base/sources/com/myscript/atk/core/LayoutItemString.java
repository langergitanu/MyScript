package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemString extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemString(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemString_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemString layoutItemString) {
        if (layoutItemString == null) {
            return 0L;
        }
        return layoutItemString.swigCPtr;
    }

    @Override // com.myscript.atk.core.LayoutItem
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.LayoutItem
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutItemString(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public String getLabel() {
        return new String(ATKCoreJNI.LayoutItemString_getLabel(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int getGlyphCount() {
        return ATKCoreJNI.LayoutItemString_getGlyphCount(this.swigCPtr, this);
    }

    public Glyph getGlyphAt(int i) {
        return new Glyph(ATKCoreJNI.LayoutItemString_getGlyphAt(this.swigCPtr, this, i), true);
    }

    public boolean isGlyphSelected(int i) {
        return ATKCoreJNI.LayoutItemString_isGlyphSelected(this.swigCPtr, this, i);
    }

    public int getStyleCount() {
        return ATKCoreJNI.LayoutItemString_getStyleCount(this.swigCPtr, this);
    }

    public InkStyle getStyleAt(int i) {
        return new InkStyle(ATKCoreJNI.LayoutItemString_getStyleAt(this.swigCPtr, this, i), true);
    }

    public String getStyleClassesAt(int i) {
        return new String(ATKCoreJNI.LayoutItemString_getStyleClassesAt(this.swigCPtr, this, i), StandardCharsets.UTF_8);
    }

    public String getOverrideStyleAt(int i) {
        return new String(ATKCoreJNI.LayoutItemString_getOverrideStyleAt(this.swigCPtr, this, i), StandardCharsets.UTF_8);
    }

    public boolean containsStretchedGlyphs() {
        return ATKCoreJNI.LayoutItemString_containsStretchedGlyphs(this.swigCPtr, this);
    }

    public LayoutItemString(Glyph glyph, SWIGTYPE_p_myscript__document__Layout sWIGTYPE_p_myscript__document__Layout, String str, String str2) {
        this(ATKCoreJNI.new_LayoutItemString(Glyph.getCPtr(glyph), glyph, SWIGTYPE_p_myscript__document__Layout.getCPtr(sWIGTYPE_p_myscript__document__Layout), str.getBytes(), str2.getBytes()), true);
    }

    public int getStyleRangeAt_fromGlyph(int i) {
        return ATKCoreJNI.LayoutItemString_getStyleRangeAt_fromGlyph(this.swigCPtr, this, i);
    }

    public int getStyleRangeAt_toGlyph(int i) {
        return ATKCoreJNI.LayoutItemString_getStyleRangeAt_toGlyph(this.swigCPtr, this, i);
    }
}
