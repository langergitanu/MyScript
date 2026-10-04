package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import androidx.compose.p004ui.text.font.FontFamily;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.FontFamilyXmlParser;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PaywallResourceProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0016J$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0017J+\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 H\u0016¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallResourceProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationName", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "resources", "Landroid/content/res/Resources;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/res/Resources;)V", "getApplicationName", "getAssetFontPaths", "", "names", "", "getAssetManager", "Landroid/content/res/AssetManager;", "getCachedFontFamilyOrStartDownload", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "getLocale", "Ljava/util/Locale;", "getResourceIdentifier", "", "name", "type", "getString", "resId", "formatArgs", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getXmlFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "resourceId", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallResourceProvider implements ResourceProvider {
    public static final int $stable = 8;
    private final String applicationName;
    private final String packageName;
    private final Resources resources;

    public PaywallResourceProvider(String applicationName, String packageName, Resources resources) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.applicationName = applicationName;
        this.packageName = packageName;
        this.resources = resources;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PaywallResourceProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        String strApplicationName = PaywallResourceProviderKt.applicationName(applicationContext);
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this(strApplicationName, packageName, resources);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    public String getApplicationName() {
        return this.applicationName;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    public String getString(int resId, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = this.resources.getString(resId, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(resId, *formatArgs)");
        return string;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    public Locale getLocale() {
        Locale locale = this.resources.getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "resources.configuration.locales.get(0)");
        return locale;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    public int getResourceIdentifier(String name, String type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return this.resources.getIdentifier(name, type, this.packageName);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    public FontFamily getXmlFontFamily(int resourceId) {
        try {
            XmlResourceParser xml = this.resources.getXml(resourceId);
            Intrinsics.checkNotNullExpressionValue(xml, "try {\n            resour…    return null\n        }");
            try {
                return FontFamilyXmlParser.INSTANCE.parse(xml);
            } catch (Throwable th) {
                try {
                    Object resourceEntryNameOrNull = PaywallResourceProviderKt.getResourceEntryNameOrNull(this.resources, resourceId);
                    Logger logger = Logger.INSTANCE;
                    StringBuilder sb = new StringBuilder("Error parsing XML font family with resource ID ");
                    if (resourceEntryNameOrNull == null) {
                        resourceEntryNameOrNull = Integer.valueOf(resourceId);
                    }
                    logger.m1585e(sb.append(resourceEntryNameOrNull).toString(), th);
                    return null;
                } finally {
                    xml.close();
                }
            }
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> getAssetFontPaths(List<String> names) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(names, "names");
        List<String> assets_fonts_dirs = ResourceProvider.INSTANCE.getASSETS_FONTS_DIRS();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(assets_fonts_dirs, 10)), 16));
        for (Object obj : assets_fonts_dirs) {
            linkedHashMap.put(obj, this.resources.getAssets().list((String) obj));
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = names.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            String str4 = StringsKt.endsWith$default(str3, ".ttf", false, 2, (Object) null) ? str3 : str3 + ".ttf";
            Iterator<T> it2 = ResourceProvider.INSTANCE.getASSETS_FONTS_DIRS().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str = null;
                    break;
                }
                String str5 = (String) it2.next();
                String[] strArr = (String[]) linkedHashMap2.get(str5);
                if (strArr != null) {
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            str2 = null;
                            break;
                        }
                        str2 = strArr[i];
                        if (Intrinsics.areEqual(str2, str4)) {
                            break;
                        }
                        i++;
                    }
                    str = str2 != null ? str5 + JsonPointer.SEPARATOR + str2 : null;
                    if (str != null) {
                        break;
                    }
                }
            }
            Pair pairM1606to = str != null ? TuplesKt.m1606to(str3, str) : null;
            if (pairM1606to != null) {
                arrayList.add(pairM1606to);
            }
        }
        Map<String, String> map = MapsKt.toMap(arrayList);
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    public DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        if (Purchases.INSTANCE.isConfigured()) {
            return Purchases.INSTANCE.getSharedInstance().getCachedFontFamilyOrStartDownload(fontInfo);
        }
        Logger.INSTANCE.m1584e("getCachedFontFileOrStartDownload called before Purchases is configured. Returning null.");
        return null;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider
    /* JADX INFO: renamed from: getAssetManager */
    public AssetManager getMockAssetManager() {
        return this.resources.getAssets();
    }
}
