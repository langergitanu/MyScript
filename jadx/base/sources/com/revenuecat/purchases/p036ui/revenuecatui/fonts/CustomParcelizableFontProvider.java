package com.revenuecat.purchases.p036ui.revenuecatui.fonts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomParcelizableFontProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/CustomParcelizableFontProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;", TtmlNode.ATTR_TTS_FONT_FAMILY, "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;", "(Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;)V", "getFont", "type", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/TypographyType;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CustomParcelizableFontProvider implements ParcelizableFontProvider {
    public static final int $stable = 0;
    private final PaywallFontFamily fontFamily;

    public CustomParcelizableFontProvider(PaywallFontFamily fontFamily) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        this.fontFamily = fontFamily;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.fonts.ParcelizableFontProvider
    public PaywallFontFamily getFont(TypographyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.fontFamily;
    }
}
