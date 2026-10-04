package com.myscript.nebo.p022ai.presentation.compose;

import androidx.compose.p004ui.unit.C1486Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AIContainerPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/FABProperties;", "", "size", "Landroidx/compose/ui/unit/Dp;", "margin", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-D9Ej5fM", "()F", "F", "getMargin-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-YgX7TsA", "(FF)Lcom/myscript/nebo/ai/presentation/compose/FABProperties;", "equals", "", "other", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FABProperties {
    public static final int $stable = 0;
    private final float margin;
    private final float size;

    public /* synthetic */ FABProperties(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* JADX INFO: renamed from: copy-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ FABProperties m12837copyYgX7TsA$default(FABProperties fABProperties, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fABProperties.size;
        }
        if ((i & 2) != 0) {
            f2 = fABProperties.margin;
        }
        return fABProperties.m12840copyYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMargin() {
        return this.margin;
    }

    /* JADX INFO: renamed from: copy-YgX7TsA, reason: not valid java name */
    public final FABProperties m12840copyYgX7TsA(float size, float margin) {
        return new FABProperties(size, margin, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FABProperties)) {
            return false;
        }
        FABProperties fABProperties = (FABProperties) other;
        return C1486Dp.m11022equalsimpl0(this.size, fABProperties.size) && C1486Dp.m11022equalsimpl0(this.margin, fABProperties.margin);
    }

    public int hashCode() {
        return (C1486Dp.m11023hashCodeimpl(this.size) * 31) + C1486Dp.m11023hashCodeimpl(this.margin);
    }

    public String toString() {
        return "FABProperties(size=" + C1486Dp.m11028toStringimpl(this.size) + ", margin=" + C1486Dp.m11028toStringimpl(this.margin) + ")";
    }

    private FABProperties(float f, float f2) {
        this.size = f;
        this.margin = f2;
    }

    /* JADX INFO: renamed from: getMargin-D9Ej5fM, reason: not valid java name */
    public final float m12841getMarginD9Ej5fM() {
        return this.margin;
    }

    /* JADX INFO: renamed from: getSize-D9Ej5fM, reason: not valid java name */
    public final float m12842getSizeD9Ej5fM() {
        return this.size;
    }
}
