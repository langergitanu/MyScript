package com.airbnb.lottie.compose;

import androidx.compose.p004ui.node.ModifierNodeElement;
import androidx.compose.p004ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LottieAnimationSizeNode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\f\u0010\u0018\u001a\u00020\u0016*\u00020\u0019H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieAnimationSizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcom/airbnb/lottie/compose/LottieAnimationSizeNode;", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "create", "equals", "", "other", "", "hashCode", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
public final /* data */ class LottieAnimationSizeElement extends ModifierNodeElement<LottieAnimationSizeNode> {
    public static final int $stable = 0;
    private final int height;
    private final int width;

    public static /* synthetic */ LottieAnimationSizeElement copy$default(LottieAnimationSizeElement lottieAnimationSizeElement, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = lottieAnimationSizeElement.width;
        }
        if ((i3 & 2) != 0) {
            i2 = lottieAnimationSizeElement.height;
        }
        return lottieAnimationSizeElement.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final LottieAnimationSizeElement copy(int width, int height) {
        return new LottieAnimationSizeElement(width, height);
    }

    public String toString() {
        return "LottieAnimationSizeElement(width=" + this.width + ", height=" + this.height + ")";
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public LottieAnimationSizeElement(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // androidx.compose.p004ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public LottieAnimationSizeNode getNode() {
        return new LottieAnimationSizeNode(this.width, this.height);
    }

    @Override // androidx.compose.p004ui.node.ModifierNodeElement
    public void update(LottieAnimationSizeNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setWidth(this.width);
        node.setHeight(this.height);
    }

    @Override // androidx.compose.p004ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("Lottie Size");
        inspectorInfo.getProperties().set("width", Integer.valueOf(this.width));
        inspectorInfo.getProperties().set("height", Integer.valueOf(this.height));
    }

    @Override // androidx.compose.p004ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LottieAnimationSizeElement)) {
            return false;
        }
        LottieAnimationSizeElement lottieAnimationSizeElement = (LottieAnimationSizeElement) other;
        return this.width == lottieAnimationSizeElement.width && this.height == lottieAnimationSizeElement.height;
    }

    @Override // androidx.compose.p004ui.node.ModifierNodeElement
    public int hashCode() {
        return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
    }
}
