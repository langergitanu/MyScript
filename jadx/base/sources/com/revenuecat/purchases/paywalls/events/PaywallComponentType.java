package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: PaywallEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType;", "", "(Ljava/lang/String;I)V", "TAB", "SWITCH", "CAROUSEL", "BUTTON", "TEXT", "PACKAGE", "PACKAGE_SELECTION_SHEET", "PURCHASE_BUTTON", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public enum PaywallComponentType {
    TAB,
    SWITCH,
    CAROUSEL,
    BUTTON,
    TEXT,
    PACKAGE,
    PACKAGE_SELECTION_SHEET,
    PURCHASE_BUTTON;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallComponentType.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.paywalls.events.PaywallComponentType", PaywallComponentType.values(), new String[]{"tab", "switch", "carousel", "button", "text", Keys.PACKAGE, "package_selection_sheet", PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME}, new Annotation[][]{null, null, null, null, null, null, null, null}, null);
        }
    });

    /* JADX INFO: compiled from: PaywallEvent.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) PaywallComponentType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<PaywallComponentType> serializer() {
            return get$cachedSerializer();
        }
    }
}
