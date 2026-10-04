package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class Glyph extends InkStroke {
    private transient long swigCPtr;

    public Glyph(long j, boolean z) {
        super(ATKCoreJNI.Glyph_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(Glyph glyph) {
        if (glyph == null) {
            return 0L;
        }
        return glyph.swigCPtr;
    }

    @Override // com.myscript.atk.core.InkStroke
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.InkStroke
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Glyph(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public String getLabel() {
        return new String(ATKCoreJNI.Glyph_getLabel(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public Parallelogram getParallelogram() {
        return new Parallelogram(ATKCoreJNI.Glyph_getParallelogram(this.swigCPtr, this), true);
    }

    public boolean hasLines() {
        return ATKCoreJNI.Glyph_hasLines(this.swigCPtr, this);
    }

    public GlyphLines getLines() {
        return new GlyphLines(ATKCoreJNI.Glyph_getLines(this.swigCPtr, this), true);
    }

    public int getAlternateCount() {
        return ATKCoreJNI.Glyph_getAlternateCount(this.swigCPtr, this);
    }

    public IGlyph_getAlternateAt_result_t getAlternateAt(int i) {
        return new IGlyph_getAlternateAt_result_t(ATKCoreJNI.Glyph_getAlternateAt(this.swigCPtr, this, i), true);
    }

    public Glyph(InputCharacter inputCharacter, Extent extent, String str) {
        this(ATKCoreJNI.new_Glyph__SWIG_0(InputCharacter.getCPtr(inputCharacter), inputCharacter, Extent.getCPtr(extent), str.getBytes()), true);
    }

    public Glyph(InputCharacter inputCharacter, Parallelogram parallelogram, String str) {
        this(ATKCoreJNI.new_Glyph__SWIG_1(InputCharacter.getCPtr(inputCharacter), inputCharacter, Parallelogram.getCPtr(parallelogram), parallelogram, str.getBytes()), true);
    }

    public Glyph(InputCharacter inputCharacter, Parallelogram parallelogram, GlyphLines glyphLines, String str) {
        this(ATKCoreJNI.new_Glyph__SWIG_2(InputCharacter.getCPtr(inputCharacter), inputCharacter, Parallelogram.getCPtr(parallelogram), parallelogram, GlyphLines.getCPtr(glyphLines), glyphLines, str.getBytes()), true);
    }

    public boolean hasSlices() {
        return ATKCoreJNI.Glyph_hasSlices(this.swigCPtr, this);
    }

    public GlyphSlices getSlices() {
        return new GlyphSlices(ATKCoreJNI.Glyph_getSlices(this.swigCPtr, this), true);
    }

    public float getParallelogramX() {
        return ATKCoreJNI.Glyph_getParallelogramX(this.swigCPtr, this);
    }

    public float getParallelogramY() {
        return ATKCoreJNI.Glyph_getParallelogramY(this.swigCPtr, this);
    }

    public float getParallelogramUX() {
        return ATKCoreJNI.Glyph_getParallelogramUX(this.swigCPtr, this);
    }

    public float getParallelogramVX() {
        return ATKCoreJNI.Glyph_getParallelogramVX(this.swigCPtr, this);
    }

    public float getParallelogramUY() {
        return ATKCoreJNI.Glyph_getParallelogramUY(this.swigCPtr, this);
    }

    public float getParallelogramVY() {
        return ATKCoreJNI.Glyph_getParallelogramVY(this.swigCPtr, this);
    }

    public float getSlicesLeft() {
        return ATKCoreJNI.Glyph_getSlicesLeft(this.swigCPtr, this);
    }

    public float getSlicesRight() {
        return ATKCoreJNI.Glyph_getSlicesRight(this.swigCPtr, this);
    }

    public float getLinesBaseLine() {
        return ATKCoreJNI.Glyph_getLinesBaseLine(this.swigCPtr, this);
    }
}
