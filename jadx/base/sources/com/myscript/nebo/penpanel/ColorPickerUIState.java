package com.myscript.nebo.penpanel;

import kotlin.Metadata;

/* JADX INFO: compiled from: ColorPickerViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J©\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fHÆ\u0001J\u0014\u00108\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010;\u001a\u00020<HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010#R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#¨\u0006="}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPickerUIState;", "", "hue", "", "saturationStartColor", "saturationEndColor", "saturationThumbColor", "saturationMaxValue", "saturationCurrentValue", "brightnessStartColor", "brightnessEndColor", "brightnessThumbColor", "brightnessMaxValue", "brightnessCurrentValue", "shouldSetProgress", "", "currentColor", "initialColor", "isEnabled", "showColorAccuracyDisclaimer", "<init>", "(IIIIIIIIIIIZIIZZ)V", "getHue", "()I", "getSaturationStartColor", "getSaturationEndColor", "getSaturationThumbColor", "getSaturationMaxValue", "getSaturationCurrentValue", "getBrightnessStartColor", "getBrightnessEndColor", "getBrightnessThumbColor", "getBrightnessMaxValue", "getBrightnessCurrentValue", "getShouldSetProgress", "()Z", "getCurrentColor", "getInitialColor", "getShowColorAccuracyDisclaimer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ColorPickerUIState {
    private final int brightnessCurrentValue;
    private final int brightnessEndColor;
    private final int brightnessMaxValue;
    private final int brightnessStartColor;
    private final int brightnessThumbColor;
    private final int currentColor;
    private final int hue;
    private final int initialColor;
    private final boolean isEnabled;
    private final int saturationCurrentValue;
    private final int saturationEndColor;
    private final int saturationMaxValue;
    private final int saturationStartColor;
    private final int saturationThumbColor;
    private final boolean shouldSetProgress;
    private final boolean showColorAccuracyDisclaimer;

    public static /* synthetic */ ColorPickerUIState copy$default(ColorPickerUIState colorPickerUIState, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, int i12, int i13, boolean z2, boolean z3, int i14, Object obj) {
        int i15 = (i14 & 1) != 0 ? colorPickerUIState.hue : i;
        return colorPickerUIState.copy(i15, (i14 & 2) != 0 ? colorPickerUIState.saturationStartColor : i2, (i14 & 4) != 0 ? colorPickerUIState.saturationEndColor : i3, (i14 & 8) != 0 ? colorPickerUIState.saturationThumbColor : i4, (i14 & 16) != 0 ? colorPickerUIState.saturationMaxValue : i5, (i14 & 32) != 0 ? colorPickerUIState.saturationCurrentValue : i6, (i14 & 64) != 0 ? colorPickerUIState.brightnessStartColor : i7, (i14 & 128) != 0 ? colorPickerUIState.brightnessEndColor : i8, (i14 & 256) != 0 ? colorPickerUIState.brightnessThumbColor : i9, (i14 & 512) != 0 ? colorPickerUIState.brightnessMaxValue : i10, (i14 & 1024) != 0 ? colorPickerUIState.brightnessCurrentValue : i11, (i14 & 2048) != 0 ? colorPickerUIState.shouldSetProgress : z, (i14 & 4096) != 0 ? colorPickerUIState.currentColor : i12, (i14 & 8192) != 0 ? colorPickerUIState.initialColor : i13, (i14 & 16384) != 0 ? colorPickerUIState.isEnabled : z2, (i14 & 32768) != 0 ? colorPickerUIState.showColorAccuracyDisclaimer : z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHue() {
        return this.hue;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getBrightnessMaxValue() {
        return this.brightnessMaxValue;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getBrightnessCurrentValue() {
        return this.brightnessCurrentValue;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShouldSetProgress() {
        return this.shouldSetProgress;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getCurrentColor() {
        return this.currentColor;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getInitialColor() {
        return this.initialColor;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getShowColorAccuracyDisclaimer() {
        return this.showColorAccuracyDisclaimer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSaturationStartColor() {
        return this.saturationStartColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSaturationEndColor() {
        return this.saturationEndColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSaturationThumbColor() {
        return this.saturationThumbColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSaturationMaxValue() {
        return this.saturationMaxValue;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSaturationCurrentValue() {
        return this.saturationCurrentValue;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getBrightnessStartColor() {
        return this.brightnessStartColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getBrightnessEndColor() {
        return this.brightnessEndColor;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getBrightnessThumbColor() {
        return this.brightnessThumbColor;
    }

    public final ColorPickerUIState copy(int hue, int saturationStartColor, int saturationEndColor, int saturationThumbColor, int saturationMaxValue, int saturationCurrentValue, int brightnessStartColor, int brightnessEndColor, int brightnessThumbColor, int brightnessMaxValue, int brightnessCurrentValue, boolean shouldSetProgress, int currentColor, int initialColor, boolean isEnabled, boolean showColorAccuracyDisclaimer) {
        return new ColorPickerUIState(hue, saturationStartColor, saturationEndColor, saturationThumbColor, saturationMaxValue, saturationCurrentValue, brightnessStartColor, brightnessEndColor, brightnessThumbColor, brightnessMaxValue, brightnessCurrentValue, shouldSetProgress, currentColor, initialColor, isEnabled, showColorAccuracyDisclaimer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorPickerUIState)) {
            return false;
        }
        ColorPickerUIState colorPickerUIState = (ColorPickerUIState) other;
        return this.hue == colorPickerUIState.hue && this.saturationStartColor == colorPickerUIState.saturationStartColor && this.saturationEndColor == colorPickerUIState.saturationEndColor && this.saturationThumbColor == colorPickerUIState.saturationThumbColor && this.saturationMaxValue == colorPickerUIState.saturationMaxValue && this.saturationCurrentValue == colorPickerUIState.saturationCurrentValue && this.brightnessStartColor == colorPickerUIState.brightnessStartColor && this.brightnessEndColor == colorPickerUIState.brightnessEndColor && this.brightnessThumbColor == colorPickerUIState.brightnessThumbColor && this.brightnessMaxValue == colorPickerUIState.brightnessMaxValue && this.brightnessCurrentValue == colorPickerUIState.brightnessCurrentValue && this.shouldSetProgress == colorPickerUIState.shouldSetProgress && this.currentColor == colorPickerUIState.currentColor && this.initialColor == colorPickerUIState.initialColor && this.isEnabled == colorPickerUIState.isEnabled && this.showColorAccuracyDisclaimer == colorPickerUIState.showColorAccuracyDisclaimer;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Integer.hashCode(this.hue) * 31) + Integer.hashCode(this.saturationStartColor)) * 31) + Integer.hashCode(this.saturationEndColor)) * 31) + Integer.hashCode(this.saturationThumbColor)) * 31) + Integer.hashCode(this.saturationMaxValue)) * 31) + Integer.hashCode(this.saturationCurrentValue)) * 31) + Integer.hashCode(this.brightnessStartColor)) * 31) + Integer.hashCode(this.brightnessEndColor)) * 31) + Integer.hashCode(this.brightnessThumbColor)) * 31) + Integer.hashCode(this.brightnessMaxValue)) * 31) + Integer.hashCode(this.brightnessCurrentValue)) * 31) + Boolean.hashCode(this.shouldSetProgress)) * 31) + Integer.hashCode(this.currentColor)) * 31) + Integer.hashCode(this.initialColor)) * 31) + Boolean.hashCode(this.isEnabled)) * 31) + Boolean.hashCode(this.showColorAccuracyDisclaimer);
    }

    public String toString() {
        return "ColorPickerUIState(hue=" + this.hue + ", saturationStartColor=" + this.saturationStartColor + ", saturationEndColor=" + this.saturationEndColor + ", saturationThumbColor=" + this.saturationThumbColor + ", saturationMaxValue=" + this.saturationMaxValue + ", saturationCurrentValue=" + this.saturationCurrentValue + ", brightnessStartColor=" + this.brightnessStartColor + ", brightnessEndColor=" + this.brightnessEndColor + ", brightnessThumbColor=" + this.brightnessThumbColor + ", brightnessMaxValue=" + this.brightnessMaxValue + ", brightnessCurrentValue=" + this.brightnessCurrentValue + ", shouldSetProgress=" + this.shouldSetProgress + ", currentColor=" + this.currentColor + ", initialColor=" + this.initialColor + ", isEnabled=" + this.isEnabled + ", showColorAccuracyDisclaimer=" + this.showColorAccuracyDisclaimer + ")";
    }

    public ColorPickerUIState(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, int i12, int i13, boolean z2, boolean z3) {
        this.hue = i;
        this.saturationStartColor = i2;
        this.saturationEndColor = i3;
        this.saturationThumbColor = i4;
        this.saturationMaxValue = i5;
        this.saturationCurrentValue = i6;
        this.brightnessStartColor = i7;
        this.brightnessEndColor = i8;
        this.brightnessThumbColor = i9;
        this.brightnessMaxValue = i10;
        this.brightnessCurrentValue = i11;
        this.shouldSetProgress = z;
        this.currentColor = i12;
        this.initialColor = i13;
        this.isEnabled = z2;
        this.showColorAccuracyDisclaimer = z3;
    }

    public final int getHue() {
        return this.hue;
    }

    public final int getSaturationStartColor() {
        return this.saturationStartColor;
    }

    public final int getSaturationEndColor() {
        return this.saturationEndColor;
    }

    public final int getSaturationThumbColor() {
        return this.saturationThumbColor;
    }

    public final int getSaturationMaxValue() {
        return this.saturationMaxValue;
    }

    public final int getSaturationCurrentValue() {
        return this.saturationCurrentValue;
    }

    public final int getBrightnessStartColor() {
        return this.brightnessStartColor;
    }

    public final int getBrightnessEndColor() {
        return this.brightnessEndColor;
    }

    public final int getBrightnessThumbColor() {
        return this.brightnessThumbColor;
    }

    public final int getBrightnessMaxValue() {
        return this.brightnessMaxValue;
    }

    public final int getBrightnessCurrentValue() {
        return this.brightnessCurrentValue;
    }

    public final boolean getShouldSetProgress() {
        return this.shouldSetProgress;
    }

    public final int getCurrentColor() {
        return this.currentColor;
    }

    public final int getInitialColor() {
        return this.initialColor;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean getShowColorAccuracyDisclaimer() {
        return this.showColorAccuracyDisclaimer;
    }
}
