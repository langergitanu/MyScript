package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class Sprite {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Sprite(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Sprite sprite) {
        if (sprite == null) {
            return 0L;
        }
        return sprite.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Sprite(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Sprite(long j) {
        this(ATKCoreJNI.new_Sprite__SWIG_0(j), true);
    }

    public Sprite(long j, Rectangle rectangle, Extent extent, Transform transform) {
        this(ATKCoreJNI.new_Sprite__SWIG_1(j, Rectangle.getCPtr(rectangle), rectangle, Extent.getCPtr(extent), extent, Transform.getCPtr(transform), transform), true);
    }

    public Sprite(Sprite sprite) {
        this(ATKCoreJNI.new_Sprite__SWIG_2(getCPtr(sprite), sprite), true);
    }

    public void crop(Extent extent) {
        ATKCoreJNI.Sprite_crop(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public void setSrcRectangle(Rectangle rectangle) {
        ATKCoreJNI.Sprite_srcRectangle_set(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle);
    }

    public Rectangle getSrcRectangle() {
        long jSprite_srcRectangle_get = ATKCoreJNI.Sprite_srcRectangle_get(this.swigCPtr, this);
        if (jSprite_srcRectangle_get == 0) {
            return null;
        }
        return new Rectangle(jSprite_srcRectangle_get, false);
    }

    public void setDestExtent(Extent extent) {
        ATKCoreJNI.Sprite_destExtent_set(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public Extent getDestExtent() {
        long jSprite_destExtent_get = ATKCoreJNI.Sprite_destExtent_get(this.swigCPtr, this);
        if (jSprite_destExtent_get == 0) {
            return null;
        }
        return new Extent(jSprite_destExtent_get, false);
    }

    public void setDeltaTransform(Transform transform) {
        ATKCoreJNI.Sprite_deltaTransform_set(this.swigCPtr, this, Transform.getCPtr(transform), transform);
    }

    public Transform getDeltaTransform() {
        long jSprite_deltaTransform_get = ATKCoreJNI.Sprite_deltaTransform_get(this.swigCPtr, this);
        if (jSprite_deltaTransform_get == 0) {
            return null;
        }
        return new Transform(jSprite_deltaTransform_get, false);
    }

    public void setInitTransform(Transform transform) {
        ATKCoreJNI.Sprite_initTransform_set(this.swigCPtr, this, Transform.getCPtr(transform), transform);
    }

    public Transform getInitTransform() {
        long jSprite_initTransform_get = ATKCoreJNI.Sprite_initTransform_get(this.swigCPtr, this);
        if (jSprite_initTransform_get == 0) {
            return null;
        }
        return new Transform(jSprite_initTransform_get, false);
    }

    public void setColor(int i) {
        ATKCoreJNI.Sprite_color_set(this.swigCPtr, this, i);
    }

    public int getColor() {
        return ATKCoreJNI.Sprite_color_get(this.swigCPtr, this);
    }

    public long getBatchID() {
        return ATKCoreJNI.Sprite_batchID_get(this.swigCPtr, this);
    }
}
