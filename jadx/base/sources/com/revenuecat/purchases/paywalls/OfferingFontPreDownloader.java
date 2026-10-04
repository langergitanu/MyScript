package com.revenuecat.purchases.paywalls;

import android.content.Context;
import androidx.media3.common.C2181C;
import com.fasterxml.jackson.core.JsonPointer;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfoKt;
import com.revenuecat.purchases.utils.Result;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OfferingFontPreDownloader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0003R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/OfferingFontPreDownloader;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "fontLoader", "Lcom/revenuecat/purchases/paywalls/FontLoader;", "(Landroid/content/Context;Lcom/revenuecat/purchases/paywalls/FontLoader;)V", "assetsFontsDirs", "", "", "genericFonts", "", "isBundled", "", "info", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "preDownloadFontsIfNeeded", "", "fonts", "", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig;", "preDownloadOfferingFontsIfNeeded", "offerings", "Lcom/revenuecat/purchases/Offerings;", "getAssetFontPath", "name", "getResourceIdentifier", "", "type", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class OfferingFontPreDownloader {
    private final List<String> assetsFontsDirs;
    private final Context context;
    private final FontLoader fontLoader;
    private final Set<String> genericFonts;

    public OfferingFontPreDownloader(Context context, FontLoader fontLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontLoader, "fontLoader");
        this.context = context;
        this.fontLoader = fontLoader;
        this.assetsFontsDirs = CollectionsKt.listOf((Object[]) new String[]{"fonts", "public/assets"});
        this.genericFonts = SetsKt.setOf((Object[]) new String[]{C2181C.SANS_SERIF_NAME, C2181C.SERIF_NAME, "monospace"});
    }

    public final void preDownloadOfferingFontsIfNeeded(Offerings offerings) {
        List listEmptyList;
        UiConfig uiConfig;
        UiConfig.AppConfig app;
        Map fonts;
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Iterator<T> it = offerings.getAll().values().iterator();
        do {
            listEmptyList = null;
            if (!it.hasNext()) {
                break;
            }
            Offering.PaywallComponents paywallComponents = ((Offering) it.next()).getPaywallComponents();
            if (paywallComponents != null && (uiConfig = paywallComponents.getUiConfig()) != null && (app = uiConfig.getApp()) != null && (fonts = app.getFonts()) != null) {
                listEmptyList = fonts.values();
            }
        } while (listEmptyList == null);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        preDownloadFontsIfNeeded(listEmptyList);
    }

    public final void preDownloadFontsIfNeeded(Collection<UiConfig.AppConfig.FontsConfig> fonts) {
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Collection<UiConfig.AppConfig.FontsConfig> collection = fonts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((UiConfig.AppConfig.FontsConfig) it.next()).getAndroid());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof UiConfig.AppConfig.FontsConfig.FontInfo.Name) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) obj2;
            if ((DownloadableFontInfoKt.toDownloadableFontInfo(name) instanceof Result.Success) && !isBundled(name)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name2 = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) obj3;
            try {
                new URL(name2.getUrl());
                arrayList4.add(obj3);
            } catch (MalformedURLException e) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Malformed URL for font: " + name2.getValue() + ". Skipping download.", e);
            }
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            this.fontLoader.getCachedFontFamilyOrStartDownload((UiConfig.AppConfig.FontsConfig.FontInfo.Name) it2.next());
        }
    }

    private final boolean isBundled(UiConfig.AppConfig.FontsConfig.FontInfo.Name info) {
        if (info.getValue().length() == 0) {
            return false;
        }
        return (!this.genericFonts.contains(info.getValue()) && getResourceIdentifier(this.context, info.getValue(), "font") == 0 && getAssetFontPath(this.context, info.getValue()) == null) ? false : true;
    }

    private final int getResourceIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getAssetFontPath(Context context, String str) throws IOException {
        String str2;
        String str3;
        if (!StringsKt.endsWith$default(str, ".ttf", false, 2, (Object) null)) {
            str = str + ".ttf";
        }
        for (String str4 : this.assetsFontsDirs) {
            String[] list = context.getResources().getAssets().list(str4);
            if (list != null) {
                int length = list.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str3 = null;
                        break;
                    }
                    str3 = list[i];
                    if (Intrinsics.areEqual(str3, str)) {
                        break;
                    }
                    i++;
                }
                str2 = str3 != null ? str4 + JsonPointer.SEPARATOR + str3 : null;
            }
            if (str2 != null) {
                return str2;
            }
        }
        return null;
    }
}
