package com.revenuecat.purchases.p036ui.revenuecatui.components.image;

import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/image/PreviewParameters;", "", "imageWidth", "Lkotlin/UInt;", "imageHeight", "viewSize", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "fitMode", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "(IILcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFitMode", "()Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "getImageHeight-pVg5ArA", "()I", "I", "getImageWidth-pVg5ArA", "getViewSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class PreviewParameters {
    private final FitMode fitMode;
    private final int imageHeight;
    private final int imageWidth;
    private final Size viewSize;

    public /* synthetic */ PreviewParameters(int i, int i2, Size size, FitMode fitMode, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, size, fitMode);
    }

    private PreviewParameters(int i, int i2, Size viewSize, FitMode fitMode) {
        Intrinsics.checkNotNullParameter(viewSize, "viewSize");
        Intrinsics.checkNotNullParameter(fitMode, "fitMode");
        this.imageWidth = i;
        this.imageHeight = i2;
        this.viewSize = viewSize;
        this.fitMode = fitMode;
    }

    /* JADX INFO: renamed from: getImageWidth-pVg5ArA, reason: not valid java name and from getter */
    public final int getImageWidth() {
        return this.imageWidth;
    }

    /* JADX INFO: renamed from: getImageHeight-pVg5ArA, reason: not valid java name and from getter */
    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final Size getViewSize() {
        return this.viewSize;
    }

    public final FitMode getFitMode() {
        return this.fitMode;
    }
}
