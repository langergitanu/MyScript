package com.myscript.atk.core.p020ui;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;

/* JADX INFO: loaded from: classes4.dex */
public class CustomTextSpan extends TextAppearanceSpan {
    public static final Parcelable.Creator<CustomTextSpan> CREATOR = new Parcelable.Creator<CustomTextSpan>() { // from class: com.myscript.atk.core.ui.CustomTextSpan.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomTextSpan createFromParcel(Parcel parcel) {
            return new CustomTextSpan(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomTextSpan[] newArray(int i) {
            return new CustomTextSpan[i];
        }
    };
    private float mLetterSpacing;
    private Typeface mTypeface;

    @Override // android.text.style.TextAppearanceSpan, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CustomTextSpan(Typeface typeface, int i, int i2, float f) {
        this(typeface, i, i2, f, -16777216);
    }

    public CustomTextSpan(Typeface typeface, int i, int i2, float f, int i3) {
        super("", i, i2, ColorStateList.valueOf(i3), ColorStateList.valueOf(i3));
        this.mTypeface = typeface;
        this.mLetterSpacing = f;
    }

    protected CustomTextSpan(Parcel parcel) {
        super(parcel);
    }

    @Override // android.text.style.TextAppearanceSpan, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    @Override // android.text.style.TextAppearanceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint);
        ColorStateList textColor = getTextColor();
        if (textColor != null) {
            textColor.getColorForState(textPaint.drawableState, 0);
            textPaint.setColor(textColor.getColorForState(textPaint.drawableState, 0));
        }
        ColorStateList linkTextColor = getLinkTextColor();
        if (linkTextColor != null) {
            textPaint.linkColor = linkTextColor.getColorForState(textPaint.drawableState, 0);
        }
    }

    @Override // android.text.style.TextAppearanceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint);
    }

    private void applyCustomTypeFace(TextPaint textPaint) {
        Typeface typefaceCreate;
        int textStyle = getTextStyle();
        if (this.mTypeface != null || textStyle != 0) {
            Typeface typeface = textPaint.getTypeface();
            int style = textStyle | (typeface != null ? typeface.getStyle() : 0);
            Typeface typeface2 = this.mTypeface;
            if (typeface2 != null) {
                typefaceCreate = Typeface.create(typeface2, style);
            } else if (typeface == null) {
                typefaceCreate = Typeface.defaultFromStyle(style);
            } else {
                typefaceCreate = Typeface.create(typeface, style);
            }
            int i = style & (~typefaceCreate.getStyle());
            if ((i & 1) != 0) {
                textPaint.setFakeBoldText(true);
            }
            if ((i & 2) != 0) {
                textPaint.setTextSkewX(-0.25f);
            }
            textPaint.setTypeface(typefaceCreate);
        }
        int textSize = getTextSize();
        if (textSize > 0) {
            textPaint.setTextSize(textSize);
        }
        textPaint.setLetterSpacing(this.mLetterSpacing);
    }
}
