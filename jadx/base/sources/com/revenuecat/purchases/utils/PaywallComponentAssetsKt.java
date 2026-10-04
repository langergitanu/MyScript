package com.revenuecat.purchases.utils;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.FallbackHeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialComponent;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.PartialVideoComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabControlComponent;
import com.revenuecat.purchases.paywalls.components.TabControlToggleComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.WebViewComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallComponentAssets.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\u0000\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\bH\u0002\u001a\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u0004\u0018\u00010\tH\u0002\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\nH\u0002\u001aD\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\"\b\b\u0000\u0010\f*\u00020\r*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u000f\u0018\u00010\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0011H\u0002¨\u0006\u0012"}, m1599d2 = {"baseComponentsConfig", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsConfig;", "Lcom/revenuecat/purchases/Offering;", "collectAssets", "Lcom/revenuecat/purchases/utils/PaywallComponentAssets;", "findImageUris", "", "Landroid/net/Uri;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "imageUris", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "extract", "Lkotlin/Function1;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallComponentAssetsKt {
    public static final PaywallComponentsConfig baseComponentsConfig(Offering offering) {
        ComponentsConfig componentsConfig;
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        if (paywallComponents != null) {
            Object objM13641getDatad1pmJ48 = paywallComponents.m13641getDatad1pmJ48();
            Throwable thM14502exceptionOrNullimpl = kotlin.Result.m14502exceptionOrNullimpl(objM13641getDatad1pmJ48);
            if (thM14502exceptionOrNullimpl != null) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Error deserializing paywall components data for '" + offering.getIdentifier() + "'. Skipping its assets.", thM14502exceptionOrNullimpl);
                objM13641getDatad1pmJ48 = null;
            }
            PaywallComponentsData paywallComponentsData = (PaywallComponentsData) objM13641getDatad1pmJ48;
            if (paywallComponentsData != null && (componentsConfig = paywallComponentsData.getComponentsConfig()) != null) {
                return componentsConfig.getBase();
            }
        }
        return null;
    }

    public static final PaywallComponentAssets collectAssets(PaywallComponentsConfig paywallComponentsConfig) {
        Intrinsics.checkNotNullParameter(paywallComponentsConfig, "<this>");
        Set mutableSet = CollectionsKt.toMutableSet(findImageUris(paywallComponentsConfig.getBackground()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        StackComponent[] stackComponentArr = new StackComponent[3];
        stackComponentArr[0] = paywallComponentsConfig.getStack();
        HeaderComponent header = paywallComponentsConfig.getHeader();
        stackComponentArr[1] = header != null ? header.getStack() : null;
        StickyFooterComponent stickyFooter = paywallComponentsConfig.getStickyFooter();
        stackComponentArr[2] = stickyFooter != null ? stickyFooter.getStack() : null;
        Iterator it = CollectionsKt.listOfNotNull((Object[]) stackComponentArr).iterator();
        while (it.hasNext()) {
            for (PaywallComponent paywallComponent : PaywallComponentFilterExtensionKt.flatten((StackComponent) it.next())) {
                CollectionsKt.addAll(mutableSet, findImageUris(paywallComponent));
                if (paywallComponent instanceof WebViewComponent) {
                    linkedHashSet.add(((WebViewComponent) paywallComponent).getUrl());
                }
            }
        }
        return new PaywallComponentAssets(mutableSet, linkedHashSet);
    }

    private static final Set<Uri> findImageUris(PaywallComponent paywallComponent) {
        if (paywallComponent instanceof StackComponent) {
            StackComponent stackComponent = (StackComponent) paywallComponent;
            return SetsKt.plus((Set) findImageUris(stackComponent.getBackground()), (Iterable) imageUris(stackComponent.getOverrides(), new Function1<PartialStackComponent, Set<? extends Uri>>() { // from class: com.revenuecat.purchases.utils.PaywallComponentAssetsKt.findImageUris.1
                @Override // kotlin.jvm.functions.Function1
                public final Set<Uri> invoke(PartialStackComponent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return PaywallComponentAssetsKt.findImageUris(it.getBackground());
                }
            }));
        }
        if (paywallComponent instanceof IconComponent) {
            IconComponent iconComponent = (IconComponent) paywallComponent;
            return SetsKt.setOf(Uri.parse(iconComponent.getBaseUrl()).buildUpon().appendEncodedPath(iconComponent.getFormats().getWebp()).build());
        }
        if (paywallComponent instanceof CarouselComponent) {
            CarouselComponent carouselComponent = (CarouselComponent) paywallComponent;
            return SetsKt.plus((Set) findImageUris(carouselComponent.getBackground()), (Iterable) imageUris(carouselComponent.getOverrides(), new Function1<PartialCarouselComponent, Set<? extends Uri>>() { // from class: com.revenuecat.purchases.utils.PaywallComponentAssetsKt.findImageUris.2
                @Override // kotlin.jvm.functions.Function1
                public final Set<Uri> invoke(PartialCarouselComponent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return PaywallComponentAssetsKt.findImageUris(it.getBackground());
                }
            }));
        }
        if (paywallComponent instanceof TabsComponent) {
            TabsComponent tabsComponent = (TabsComponent) paywallComponent;
            return SetsKt.plus((Set) findImageUris(tabsComponent.getBackground()), (Iterable) imageUris(tabsComponent.getOverrides(), new Function1<PartialTabsComponent, Set<? extends Uri>>() { // from class: com.revenuecat.purchases.utils.PaywallComponentAssetsKt.findImageUris.3
                @Override // kotlin.jvm.functions.Function1
                public final Set<Uri> invoke(PartialTabsComponent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return PaywallComponentAssetsKt.findImageUris(it.getBackground());
                }
            }));
        }
        if (paywallComponent instanceof ImageComponent) {
            ImageComponent imageComponent = (ImageComponent) paywallComponent;
            return SetsKt.plus((Set) findImageUris(imageComponent.getSource()), (Iterable) imageUris(imageComponent.getOverrides(), new Function1<PartialImageComponent, Set<? extends Uri>>() { // from class: com.revenuecat.purchases.utils.PaywallComponentAssetsKt.findImageUris.4
                @Override // kotlin.jvm.functions.Function1
                public final Set<Uri> invoke(PartialImageComponent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ThemeImageUrls source = it.getSource();
                    Set<Uri> setFindImageUris = source != null ? PaywallComponentAssetsKt.findImageUris(source) : null;
                    return setFindImageUris == null ? SetsKt.emptySet() : setFindImageUris;
                }
            }));
        }
        if (paywallComponent instanceof VideoComponent) {
            VideoComponent videoComponent = (VideoComponent) paywallComponent;
            ThemeImageUrls fallbackSource = videoComponent.getFallbackSource();
            Set<Uri> setFindImageUris = fallbackSource != null ? findImageUris(fallbackSource) : null;
            if (setFindImageUris == null) {
                setFindImageUris = SetsKt.emptySet();
            }
            return SetsKt.plus((Set) setFindImageUris, (Iterable) imageUris(videoComponent.getOverrides(), new Function1<PartialVideoComponent, Set<? extends Uri>>() { // from class: com.revenuecat.purchases.utils.PaywallComponentAssetsKt.findImageUris.5
                @Override // kotlin.jvm.functions.Function1
                public final Set<Uri> invoke(PartialVideoComponent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ThemeImageUrls fallbackSource2 = it.getFallbackSource();
                    Set<Uri> setFindImageUris2 = fallbackSource2 != null ? PaywallComponentAssetsKt.findImageUris(fallbackSource2) : null;
                    return setFindImageUris2 == null ? SetsKt.emptySet() : setFindImageUris2;
                }
            }));
        }
        if (paywallComponent instanceof ButtonComponent ? true : paywallComponent instanceof CountdownComponent ? true : paywallComponent instanceof FallbackHeaderComponent ? true : paywallComponent instanceof HeaderComponent ? true : paywallComponent instanceof PackageComponent ? true : paywallComponent instanceof PurchaseButtonComponent ? true : paywallComponent instanceof StickyFooterComponent ? true : paywallComponent instanceof TabControlButtonComponent ? true : paywallComponent instanceof TabControlComponent ? true : paywallComponent instanceof TabControlToggleComponent ? true : paywallComponent instanceof TextComponent ? true : paywallComponent instanceof TimelineComponent ? true : paywallComponent instanceof WebViewComponent) {
            return SetsKt.emptySet();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final <T extends PartialComponent> Set<Uri> imageUris(List<ComponentOverride<T>> list, Function1<? super T, ? extends Set<? extends Uri>> function1) {
        if (list == null) {
            return SetsKt.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(linkedHashSet, function1.invoke(((ComponentOverride) it.next()).getProperties()));
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<Uri> findImageUris(Background background) {
        URL webpLowRes;
        String string;
        URL webpLowRes2;
        String string2;
        Uri uri = null;
        if (background instanceof Background.Image) {
            Uri[] uriArr = new Uri[2];
            Background.Image image = (Background.Image) background;
            uriArr[0] = Uri.parse(image.getValue().getLight().getWebpLowRes().toString());
            ImageUrls dark = image.getValue().getDark();
            if (dark != null && (webpLowRes2 = dark.getWebpLowRes()) != null && (string2 = webpLowRes2.toString()) != null) {
                uri = Uri.parse(string2);
            }
            uriArr[1] = uri;
            return SetsKt.setOfNotNull((Object[]) uriArr);
        }
        if (!(background instanceof Background.Video)) {
            if ((background instanceof Background.Color ? true : background instanceof Background.Unknown) || background == null) {
                return SetsKt.emptySet();
            }
            throw new NoWhenBranchMatchedException();
        }
        Uri[] uriArr2 = new Uri[2];
        Background.Video video = (Background.Video) background;
        uriArr2[0] = Uri.parse(video.getFallbackImage().getLight().getWebpLowRes().toString());
        ImageUrls dark2 = video.getFallbackImage().getDark();
        if (dark2 != null && (webpLowRes = dark2.getWebpLowRes()) != null && (string = webpLowRes.toString()) != null) {
            uri = Uri.parse(string);
        }
        uriArr2[1] = uri;
        return SetsKt.setOfNotNull((Object[]) uriArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<Uri> findImageUris(ThemeImageUrls themeImageUrls) {
        URL webpLowRes;
        String string;
        Uri[] uriArr = new Uri[2];
        uriArr[0] = Uri.parse(themeImageUrls.getLight().getWebpLowRes().toString());
        ImageUrls dark = themeImageUrls.getDark();
        uriArr[1] = (dark == null || (webpLowRes = dark.getWebpLowRes()) == null || (string = webpLowRes.toString()) == null) ? null : Uri.parse(string);
        return SetsKt.setOfNotNull((Object[]) uriArr);
    }
}
