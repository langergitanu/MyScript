package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowScreenContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewContextInput.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bc\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0012HÆ\u0003Jy\u0010-\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewContextInput;", "", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "offering", "Lcom/revenuecat/purchases/Offering;", "componentPackage", "Lcom/revenuecat/purchases/Package;", "selectedPackage", "store", "Lcom/revenuecat/purchases/Store;", "storefrontCountryCode", "workflowScreen", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;", "locale", "darkMode", "", "(Ljava/util/Map;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/Store;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;Ljava/lang/String;Z)V", "getComponentPackage", "()Lcom/revenuecat/purchases/Package;", "getCustomVariables", "()Ljava/util/Map;", "getDarkMode", "()Z", "getLocale", "()Ljava/lang/String;", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "getSelectedPackage", "getStore", "()Lcom/revenuecat/purchases/Store;", "getStorefrontCountryCode", "getWorkflowScreen", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WebViewContextInput {
    public static final int $stable = 8;
    private final Package componentPackage;
    private final Map<String, CustomVariableValue> customVariables;
    private final boolean darkMode;
    private final String locale;
    private final Offering offering;
    private final Package selectedPackage;
    private final Store store;
    private final String storefrontCountryCode;
    private final WorkflowScreenContext workflowScreen;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebViewContextInput copy$default(WebViewContextInput webViewContextInput, Map map, Offering offering, Package r3, Package r4, Store store, String str, WorkflowScreenContext workflowScreenContext, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            map = webViewContextInput.customVariables;
        }
        if ((i & 2) != 0) {
            offering = webViewContextInput.offering;
        }
        if ((i & 4) != 0) {
            r3 = webViewContextInput.componentPackage;
        }
        if ((i & 8) != 0) {
            r4 = webViewContextInput.selectedPackage;
        }
        if ((i & 16) != 0) {
            store = webViewContextInput.store;
        }
        if ((i & 32) != 0) {
            str = webViewContextInput.storefrontCountryCode;
        }
        if ((i & 64) != 0) {
            workflowScreenContext = webViewContextInput.workflowScreen;
        }
        if ((i & 128) != 0) {
            str2 = webViewContextInput.locale;
        }
        if ((i & 256) != 0) {
            z = webViewContextInput.darkMode;
        }
        String str3 = str2;
        boolean z2 = z;
        String str4 = str;
        WorkflowScreenContext workflowScreenContext2 = workflowScreenContext;
        Store store2 = store;
        Package r5 = r3;
        return webViewContextInput.copy(map, offering, r5, r4, store2, str4, workflowScreenContext2, str3, z2);
    }

    public final Map<String, CustomVariableValue> component1() {
        return this.customVariables;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Offering getOffering() {
        return this.offering;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Package getComponentPackage() {
        return this.componentPackage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Package getSelectedPackage() {
        return this.selectedPackage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final WorkflowScreenContext getWorkflowScreen() {
        return this.workflowScreen;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final WebViewContextInput copy(Map<String, ? extends CustomVariableValue> customVariables, Offering offering, Package componentPackage, Package selectedPackage, Store store, String storefrontCountryCode, WorkflowScreenContext workflowScreen, String locale, boolean darkMode) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new WebViewContextInput(customVariables, offering, componentPackage, selectedPackage, store, storefrontCountryCode, workflowScreen, locale, darkMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebViewContextInput)) {
            return false;
        }
        WebViewContextInput webViewContextInput = (WebViewContextInput) other;
        return Intrinsics.areEqual(this.customVariables, webViewContextInput.customVariables) && Intrinsics.areEqual(this.offering, webViewContextInput.offering) && Intrinsics.areEqual(this.componentPackage, webViewContextInput.componentPackage) && Intrinsics.areEqual(this.selectedPackage, webViewContextInput.selectedPackage) && this.store == webViewContextInput.store && Intrinsics.areEqual(this.storefrontCountryCode, webViewContextInput.storefrontCountryCode) && Intrinsics.areEqual(this.workflowScreen, webViewContextInput.workflowScreen) && Intrinsics.areEqual(this.locale, webViewContextInput.locale) && this.darkMode == webViewContextInput.darkMode;
    }

    public int hashCode() {
        int iHashCode = this.customVariables.hashCode() * 31;
        Offering offering = this.offering;
        int iHashCode2 = (iHashCode + (offering == null ? 0 : offering.hashCode())) * 31;
        Package r1 = this.componentPackage;
        int iHashCode3 = (iHashCode2 + (r1 == null ? 0 : r1.hashCode())) * 31;
        Package r12 = this.selectedPackage;
        int iHashCode4 = (((iHashCode3 + (r12 == null ? 0 : r12.hashCode())) * 31) + this.store.hashCode()) * 31;
        String str = this.storefrontCountryCode;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        WorkflowScreenContext workflowScreenContext = this.workflowScreen;
        return ((((iHashCode5 + (workflowScreenContext != null ? workflowScreenContext.hashCode() : 0)) * 31) + this.locale.hashCode()) * 31) + Boolean.hashCode(this.darkMode);
    }

    public String toString() {
        return "WebViewContextInput(customVariables=" + this.customVariables + ", offering=" + this.offering + ", componentPackage=" + this.componentPackage + ", selectedPackage=" + this.selectedPackage + ", store=" + this.store + ", storefrontCountryCode=" + this.storefrontCountryCode + ", workflowScreen=" + this.workflowScreen + ", locale=" + this.locale + ", darkMode=" + this.darkMode + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebViewContextInput(Map<String, ? extends CustomVariableValue> customVariables, Offering offering, Package r4, Package r5, Store store, String str, WorkflowScreenContext workflowScreenContext, String locale, boolean z) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.customVariables = customVariables;
        this.offering = offering;
        this.componentPackage = r4;
        this.selectedPackage = r5;
        this.store = store;
        this.storefrontCountryCode = str;
        this.workflowScreen = workflowScreenContext;
        this.locale = locale;
        this.darkMode = z;
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public final Offering getOffering() {
        return this.offering;
    }

    public final Package getComponentPackage() {
        return this.componentPackage;
    }

    public final Package getSelectedPackage() {
        return this.selectedPackage;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    public final WorkflowScreenContext getWorkflowScreen() {
        return this.workflowScreen;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }
}
