package com.revenuecat.purchases.utils;

import android.content.Context;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.paywalls.PaywallAssetWarming;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.storage.DefaultFileRepository;
import com.revenuecat.purchases.storage.FileRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferingVideoPredownloader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/OfferingVideoPredownloader;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "assetWarming", "Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;", "fileRepository", "Lcom/revenuecat/purchases/storage/FileRepository;", "(Landroid/content/Context;Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;Lcom/revenuecat/purchases/storage/FileRepository;)V", "downloadVideos", "", "offering", "Lcom/revenuecat/purchases/Offering;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class OfferingVideoPredownloader {
    private final PaywallAssetWarming assetWarming;
    private final FileRepository fileRepository;

    public OfferingVideoPredownloader(Context context, PaywallAssetWarming assetWarming, FileRepository fileRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetWarming, "assetWarming");
        Intrinsics.checkNotNullParameter(fileRepository, "fileRepository");
        this.assetWarming = assetWarming;
        this.fileRepository = fileRepository;
    }

    public /* synthetic */ OfferingVideoPredownloader(Context context, PaywallAssetWarming paywallAssetWarming, DefaultFileRepository defaultFileRepository, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, paywallAssetWarming, (i & 4) != 0 ? new DefaultFileRepository(context, null, 2, null) : defaultFileRepository);
    }

    public final void downloadVideos(Offering offering) {
        PaywallComponentsConfig paywallComponentsConfigBaseComponentsConfig;
        StackComponent stack;
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.assetWarming.isAvailable() || (paywallComponentsConfigBaseComponentsConfig = PaywallComponentAssetsKt.baseComponentsConfig(offering)) == null || (stack = paywallComponentsConfigBaseComponentsConfig.getStack()) == null) {
            return;
        }
        List<PaywallComponent> listFlatten = PaywallComponentFilterExtensionKt.flatten(stack);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listFlatten) {
            if (obj instanceof VideoComponent) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.fileRepository.prefetch(OfferingVideoPredownloaderKt.checkedUrls(((VideoComponent) it.next()).getSource()));
        }
    }
}
