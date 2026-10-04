package com.revenuecat.purchases.p036ui.revenuecatui.data;

import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.SimpleSheetState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptySet;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PaywallState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "", "Error", "Loaded", "Loading", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loading;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PaywallState {

    /* JADX INFO: compiled from: PaywallState.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loading;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "()V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Loading implements PaywallState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }
    }

    /* JADX INFO: compiled from: PaywallState.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class Error implements PaywallState {
        public static final int $stable = 0;
        private final String errorMessage;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.errorMessage;
            }
            return error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Error copy(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new Error(errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.errorMessage, ((Error) other).errorMessage);
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return "Error(errorMessage=" + this.errorMessage + ')';
        }

        public Error(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
            Logger.INSTANCE.m1584e("Paywall transitioned to error state: " + errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    /* JADX INFO: compiled from: PaywallState.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "offering", "Lcom/revenuecat/purchases/Offering;", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "Components", "Legacy", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public interface Loaded extends PaywallState {
        Offering getOffering();

        /* JADX INFO: compiled from: PaywallState.kt */
        @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\rHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007J\t\u0010'\u001a\u00020(HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "offering", "Lcom/revenuecat/purchases/Offering;", "templateConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "selectedPackage", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "shouldDisplayDismissButton", "", "validationWarning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;ZLcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;)V", "Landroidx/compose/runtime/MutableState;", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;Landroidx/compose/runtime/MutableState;ZLcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;)V", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "getSelectedPackage", "()Landroidx/compose/runtime/MutableState;", "getShouldDisplayDismissButton", "()Z", "getTemplateConfiguration", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "getValidationWarning", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "selectPackage", "", "packageInfo", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Legacy implements Loaded {
            public static final int $stable = 0;
            private final Offering offering;
            private final MutableState<TemplateConfiguration.PackageInfo> selectedPackage;
            private final boolean shouldDisplayDismissButton;
            private final TemplateConfiguration templateConfiguration;
            private final PaywallWarning validationWarning;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Legacy copy$default(Legacy legacy, Offering offering, TemplateConfiguration templateConfiguration, MutableState mutableState, boolean z, PaywallWarning paywallWarning, int i, Object obj) {
                if ((i & 1) != 0) {
                    offering = legacy.offering;
                }
                if ((i & 2) != 0) {
                    templateConfiguration = legacy.templateConfiguration;
                }
                if ((i & 4) != 0) {
                    mutableState = legacy.selectedPackage;
                }
                if ((i & 8) != 0) {
                    z = legacy.shouldDisplayDismissButton;
                }
                if ((i & 16) != 0) {
                    paywallWarning = legacy.validationWarning;
                }
                PaywallWarning paywallWarning2 = paywallWarning;
                MutableState mutableState2 = mutableState;
                return legacy.copy(offering, templateConfiguration, mutableState2, z, paywallWarning2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Offering getOffering() {
                return this.offering;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final TemplateConfiguration getTemplateConfiguration() {
                return this.templateConfiguration;
            }

            public final MutableState<TemplateConfiguration.PackageInfo> component3() {
                return this.selectedPackage;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getShouldDisplayDismissButton() {
                return this.shouldDisplayDismissButton;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final PaywallWarning getValidationWarning() {
                return this.validationWarning;
            }

            public final Legacy copy(Offering offering, TemplateConfiguration templateConfiguration, MutableState<TemplateConfiguration.PackageInfo> selectedPackage, boolean shouldDisplayDismissButton, PaywallWarning validationWarning) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
                return new Legacy(offering, templateConfiguration, selectedPackage, shouldDisplayDismissButton, validationWarning);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Legacy)) {
                    return false;
                }
                Legacy legacy = (Legacy) other;
                return Intrinsics.areEqual(this.offering, legacy.offering) && Intrinsics.areEqual(this.templateConfiguration, legacy.templateConfiguration) && Intrinsics.areEqual(this.selectedPackage, legacy.selectedPackage) && this.shouldDisplayDismissButton == legacy.shouldDisplayDismissButton && Intrinsics.areEqual(this.validationWarning, legacy.validationWarning);
            }

            public int hashCode() {
                int iHashCode = ((((((this.offering.hashCode() * 31) + this.templateConfiguration.hashCode()) * 31) + this.selectedPackage.hashCode()) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31;
                PaywallWarning paywallWarning = this.validationWarning;
                return iHashCode + (paywallWarning == null ? 0 : paywallWarning.hashCode());
            }

            public String toString() {
                return "Legacy(offering=" + this.offering + ", templateConfiguration=" + this.templateConfiguration + ", selectedPackage=" + this.selectedPackage + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", validationWarning=" + this.validationWarning + ')';
            }

            public Legacy(Offering offering, TemplateConfiguration templateConfiguration, MutableState<TemplateConfiguration.PackageInfo> selectedPackage, boolean z, PaywallWarning paywallWarning) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
                this.offering = offering;
                this.templateConfiguration = templateConfiguration;
                this.selectedPackage = selectedPackage;
                this.shouldDisplayDismissButton = z;
                this.validationWarning = paywallWarning;
            }

            public /* synthetic */ Legacy(Offering offering, TemplateConfiguration templateConfiguration, MutableState mutableState, boolean z, PaywallWarning paywallWarning, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(offering, templateConfiguration, (MutableState<TemplateConfiguration.PackageInfo>) mutableState, z, (i & 16) != 0 ? null : paywallWarning);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded
            public Offering getOffering() {
                return this.offering;
            }

            public final TemplateConfiguration getTemplateConfiguration() {
                return this.templateConfiguration;
            }

            public final MutableState<TemplateConfiguration.PackageInfo> getSelectedPackage() {
                return this.selectedPackage;
            }

            public final boolean getShouldDisplayDismissButton() {
                return this.shouldDisplayDismissButton;
            }

            public final PaywallWarning getValidationWarning() {
                return this.validationWarning;
            }

            public /* synthetic */ Legacy(Offering offering, TemplateConfiguration templateConfiguration, TemplateConfiguration.PackageInfo packageInfo, boolean z, PaywallWarning paywallWarning, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(offering, templateConfiguration, packageInfo, z, (i & 16) != 0 ? null : paywallWarning);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Legacy(Offering offering, TemplateConfiguration templateConfiguration, TemplateConfiguration.PackageInfo selectedPackage, boolean z, PaywallWarning paywallWarning) {
                this(offering, templateConfiguration, (MutableState<TemplateConfiguration.PackageInfo>) SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(selectedPackage, null, 2, null), z, paywallWarning);
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
            }

            public final void selectPackage(TemplateConfiguration.PackageInfo packageInfo) {
                Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
                this.selectedPackage.setValue(packageInfo);
            }
        }

        /* JADX INFO: compiled from: PaywallState.kt */
        @Metadata(m1598d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0004²\u0001³\u0001Bû\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020*\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0,¢\u0006\u0002\u0010-J\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001J\u0015\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u00012\u0007\u0010¡\u0001\u001a\u00020\u0015H\u0002J\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0015J\t\u0010£\u0001\u001a\u0004\u0018\u00010NJ\b\u0010¤\u0001\u001a\u00030¥\u0001J\u0019\u0010¦\u0001\u001a\u00030¥\u00012\u0007\u0010§\u0001\u001a\u00020NH\u0000¢\u0006\u0003\b¨\u0001J5\u0010©\u0001\u001a\u00030¥\u00012\f\b\u0002\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\t¢\u0006\u0003\u0010¬\u0001J\u0010\u0010©\u0001\u001a\u00030¥\u00012\u0006\u0010\u007f\u001a\u00020\u0015J\u001c\u0010l\u001a\u0004\u0018\u00010m*\n\u0012\u0005\u0012\u00030 \u00010\u00ad\u0001H\u0002¢\u0006\u0003\u0010®\u0001J\u001c\u0010¯\u0001\u001a\u00020\u0013*\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b°\u0001\u0010±\u0001R\u0011\u0010.\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b2\u00103R'\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002050\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R+\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b>\u00100\"\u0004\b?\u0010@R\u001b\u0010C\u001a\u00020D8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u0011\u0010I\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bL\u00107R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bM\u00107R/\u0010O\u001a\u0004\u0018\u00010N2\b\u0010<\u001a\u0004\u0018\u00010N8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010B\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR&\u0010U\u001a\u00020\"2\u0006\u0010<\u001a\u00020\"8F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R&\u0010\\\u001a\u00020\"2\u0006\u0010<\u001a\u00020\"8F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010W\"\u0004\b^\u0010YR\u0010\u0010_\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020D8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010H\u001a\u0004\bb\u0010FR1\u0010d\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00138B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bh\u0010B\u001a\u0004\be\u00103\"\u0004\bf\u0010gR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bi\u00100R\u001d\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bk\u00107R\u001d\u0010l\u001a\u0004\u0018\u00010m8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010H\u001a\u0004\bn\u0010oR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00150tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010u\u001a\u00020v8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\by\u0010H\u001a\u0004\bw\u0010xR\u001c\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010\u00150{X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010|\u001a\u0004\u0018\u00010N8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010H\u001a\u0004\b}\u0010QR2\u0010\u007f\u001a\u0004\u0018\u00010\u00152\b\u0010<\u001a\u0004\u0018\u00010\u00158B@BX\u0082\u008e\u0002¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010B\u001a\u0005\b\u0080\u0001\u00103\"\u0005\b\u0081\u0001\u0010gR0\u0010\u0083\u0001\u001a\u00020\"2\u0006\u0010<\u001a\u00020\"8F@BX\u0086\u008e\u0002¢\u0006\u0016\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0005\b\u0084\u0001\u0010W\"\u0005\b\u0085\u0001\u0010YR\u0014\u0010\u0088\u0001\u001a\u00020$¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0012\u0010\n\u001a\u00020\t¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u00100R\u0012\u0010\u0002\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010[R\u0013\u0010)\u001a\u00020*¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010[R\u0015\u0010\u0090\u0001\u001a\u00030\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u00103R!\u0010\u0095\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0t0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010'\u001a\u0004\u0018\u00010(¢\u0006\n\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006´\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "header", "stickyFooter", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "mainStackHasHeroImage", "", "showPricesWithDecimals", "variableConfig", "Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "offering", "Lcom/revenuecat/purchases/Offering;", "locales", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "storefrontCountryCode", "", "dateProvider", "Lkotlin/Function0;", "Ljava/util/Date;", Keys.PACKAGES, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "defaultCustomVariables", "initialLocaleList", "Landroidx/compose/ui/text/intl/LocaleList;", "initialSelectedTabIndex", "", "initialSheetState", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "workflowScreen", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;", "stateStore", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "viewModelActionInProgress", "Landroidx/compose/runtime/State;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;ZZLcom/revenuecat/purchases/UiConfig$VariableConfig;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;Ljava/util/Map;Ljava/util/Map;Landroidx/compose/ui/text/intl/LocaleList;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;Landroidx/compose/runtime/State;)V", "actionInProgress", "getActionInProgress", "()Z", "appUserID", "getAppUserID", "()Ljava/lang/String;", "availableStorefrontCountryLocalesByLanguage", "Ljava/util/Locale;", "getAvailableStorefrontCountryLocalesByLanguage", "()Ljava/util/Map;", "availableStorefrontCountryLocalesByLanguage$delegate", "Lkotlin/Lazy;", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "<set-?>", "clickScopedActionInProgress", "getClickScopedActionInProgress", "setClickScopedActionInProgress", "(Z)V", "clickScopedActionInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "currencyLocale", "Landroidx/compose/ui/text/intl/Locale;", "getCurrencyLocale", "()Landroidx/compose/ui/text/intl/Locale;", "currencyLocale$delegate", "Landroidx/compose/runtime/State;", "currentDate", "getCurrentDate", "()Ljava/util/Date;", "getCustomVariables", "getDefaultCustomVariables", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "defaultPackageInfo", "getDefaultPackageInfo", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "setDefaultPackageInfo", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;)V", "defaultPackageInfo$delegate", "footerHeightPx", "getFooterHeightPx", "()I", "setFooterHeightPx$revenuecatui_defaultsRelease", "(I)V", "getHeader", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "headerHeightPx", "getHeaderHeightPx", "setHeaderHeightPx$revenuecatui_defaultsRelease", "initialSelectedPackageOutsideTabs", "initialSelectedPackageUniqueId", "locale", "getLocale", "locale$delegate", "localeId", "getLocaleId-uqtKvyA", "setLocaleId-_KYeFs0", "(Ljava/lang/String;)V", "localeId$delegate", "getMainStackHasHeroImage", "mergedCustomVariables", "getMergedCustomVariables", "mostExpensivePricePerMonthMicros", "", "getMostExpensivePricePerMonthMicros", "()Ljava/lang/Long;", "mostExpensivePricePerMonthMicros$delegate", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "packagesOutsideTabsUniqueIds", "", "selectedOfferEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getSelectedOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "selectedOfferEligibility$delegate", "selectedPackageByTab", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "selectedPackageInfo", "getSelectedPackageInfo", "selectedPackageInfo$delegate", "selectedPackageUniqueId", "getSelectedPackageUniqueId", "setSelectedPackageUniqueId", "selectedPackageUniqueId$delegate", "selectedTabIndex", "getSelectedTabIndex", "setSelectedTabIndex", "selectedTabIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "sheet", "getSheet", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "getShowPricesWithDecimals", "getStack", "getStateStore", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "getStickyFooter", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "getStorefrontCountryCode", "tabsByUniqueId", "getVariableConfig", "()Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "getVariableDataProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "visibleFallbackForHiddenDefaultOutsideTabs", "getWorkflowScreen", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;", "defaultPackageForPackageRowAnalytics", "Lcom/revenuecat/purchases/Package;", "findPackageInfoByUniqueId", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "uniqueId", "peekDefaultPackageUniqueIdAfterSheetDismiss", "peekSelectedPackageInfoAfterSheetDismiss", "resetToDefaultPackage", "", "setDefaultPackage", "info", "setDefaultPackage$revenuecatui_defaultsRelease", "update", "localeList", "Landroid/os/LocaleList;", "(Landroid/os/LocaleList;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "", "(Ljava/util/List;)Ljava/lang/Long;", "toLocaleId", "toLocaleId-8pYHj4M", "(Landroidx/compose/ui/text/intl/LocaleList;)Ljava/lang/String;", "AvailablePackages", "SelectedPackageInfo", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Components implements Loaded {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: availableStorefrontCountryLocalesByLanguage$delegate, reason: from kotlin metadata */
            private final Lazy availableStorefrontCountryLocalesByLanguage;
            private final BackgroundStyles background;

            /* JADX INFO: renamed from: clickScopedActionInProgress$delegate, reason: from kotlin metadata */
            private final MutableState clickScopedActionInProgress;

            /* JADX INFO: renamed from: currencyLocale$delegate, reason: from kotlin metadata */
            private final State currencyLocale;
            private final Map<String, CustomVariableValue> customVariables;
            private final Function0<Date> dateProvider;
            private final Map<String, CustomVariableValue> defaultCustomVariables;

            /* JADX INFO: renamed from: defaultPackageInfo$delegate, reason: from kotlin metadata */
            private final MutableState defaultPackageInfo;
            private int footerHeightPx;
            private final ComponentStyle header;
            private int headerHeightPx;
            private final String initialSelectedPackageOutsideTabs;
            private final String initialSelectedPackageUniqueId;

            /* JADX INFO: renamed from: locale$delegate, reason: from kotlin metadata */
            private final State locale;

            /* JADX INFO: renamed from: localeId$delegate, reason: from kotlin metadata */
            private final MutableState localeId;
            private final NonEmptySet<LocaleId> locales;
            private final boolean mainStackHasHeroImage;
            private final Map<String, CustomVariableValue> mergedCustomVariables;

            /* JADX INFO: renamed from: mostExpensivePricePerMonthMicros$delegate, reason: from kotlin metadata */
            private final State mostExpensivePricePerMonthMicros;
            private final Offering offering;
            private final AvailablePackages packages;
            private final Set<String> packagesOutsideTabsUniqueIds;
            private final PurchasesType purchases;

            /* JADX INFO: renamed from: selectedOfferEligibility$delegate, reason: from kotlin metadata */
            private final State selectedOfferEligibility;
            private final SnapshotStateMap<Integer, String> selectedPackageByTab;

            /* JADX INFO: renamed from: selectedPackageInfo$delegate, reason: from kotlin metadata */
            private final State selectedPackageInfo;

            /* JADX INFO: renamed from: selectedPackageUniqueId$delegate, reason: from kotlin metadata */
            private final MutableState selectedPackageUniqueId;

            /* JADX INFO: renamed from: selectedTabIndex$delegate, reason: from kotlin metadata */
            private final MutableIntState selectedTabIndex;
            private final SimpleSheetState sheet;
            private final boolean showPricesWithDecimals;
            private final ComponentStyle stack;
            private final PaywallStateStore stateStore;
            private final ComponentStyle stickyFooter;
            private final String storefrontCountryCode;
            private final Map<String, Set<Integer>> tabsByUniqueId;
            private final UiConfig.VariableConfig variableConfig;
            private final VariableDataProvider variableDataProvider;
            private final State<Boolean> viewModelActionInProgress;
            private final String visibleFallbackForHiddenDefaultOutsideTabs;
            private final WorkflowScreenContext workflowScreen;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0131  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Components(ComponentStyle stack, ComponentStyle componentStyle, ComponentStyle componentStyle2, BackgroundStyles background, boolean z, boolean z2, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, Offering offering, NonEmptySet<LocaleId> locales, String str, Function0<? extends Date> dateProvider, AvailablePackages packages, Map<String, ? extends CustomVariableValue> customVariables, Map<String, ? extends CustomVariableValue> defaultCustomVariables, LocaleList initialLocaleList, Integer num, SimpleSheetState initialSheetState, PurchasesType purchases, WorkflowScreenContext workflowScreenContext, PaywallStateStore stateStore, State<Boolean> viewModelActionInProgress) {
                Object next;
                String uniqueId;
                AvailablePackages.Info infoDefaultSelection;
                Object next2;
                Intrinsics.checkNotNullParameter(stack, "stack");
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
                Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(locales, "locales");
                Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
                Intrinsics.checkNotNullParameter(packages, "packages");
                Intrinsics.checkNotNullParameter(customVariables, "customVariables");
                Intrinsics.checkNotNullParameter(defaultCustomVariables, "defaultCustomVariables");
                Intrinsics.checkNotNullParameter(initialLocaleList, "initialLocaleList");
                Intrinsics.checkNotNullParameter(initialSheetState, "initialSheetState");
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                Intrinsics.checkNotNullParameter(stateStore, "stateStore");
                Intrinsics.checkNotNullParameter(viewModelActionInProgress, "viewModelActionInProgress");
                this.stack = stack;
                this.header = componentStyle;
                this.stickyFooter = componentStyle2;
                this.background = background;
                this.mainStackHasHeroImage = z;
                this.showPricesWithDecimals = z2;
                this.variableConfig = variableConfig;
                this.variableDataProvider = variableDataProvider;
                this.offering = offering;
                this.locales = locales;
                this.storefrontCountryCode = str;
                this.dateProvider = dateProvider;
                this.packages = packages;
                this.customVariables = customVariables;
                this.defaultCustomVariables = defaultCustomVariables;
                this.purchases = purchases;
                this.workflowScreen = workflowScreenContext;
                this.stateStore = stateStore;
                this.viewModelActionInProgress = viewModelActionInProgress;
                this.mergedCustomVariables = MapsKt.plus(defaultCustomVariables, customVariables);
                Iterator<T> it = packages.getPackagesOutsideTabs().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    AvailablePackages.Info info = (AvailablePackages.Info) next;
                    if (info.isSelectedByDefault() && PaywallStateKt.resolvesVisible(info, this.mergedCustomVariables)) {
                        break;
                    }
                }
                AvailablePackages.Info info2 = (AvailablePackages.Info) next;
                this.initialSelectedPackageOutsideTabs = info2 != null ? info2.getUniqueId() : null;
                List<AvailablePackages.Info> packagesOutsideTabs = this.packages.getPackagesOutsideTabs();
                List<AvailablePackages.Info> list = packagesOutsideTabs;
                if ((list instanceof Collection) && list.isEmpty()) {
                    packagesOutsideTabs = null;
                } else {
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (((AvailablePackages.Info) it2.next()).isSelectedByDefault()) {
                            break;
                        }
                    }
                    packagesOutsideTabs = null;
                }
                if (packagesOutsideTabs != null) {
                    Iterator<T> it3 = packagesOutsideTabs.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            if (PaywallStateKt.resolvesVisible((AvailablePackages.Info) next2, this.mergedCustomVariables)) {
                                break;
                            }
                        } else {
                            next2 = null;
                            break;
                        }
                    }
                    AvailablePackages.Info info3 = (AvailablePackages.Info) next2;
                    uniqueId = info3 != null ? info3.getUniqueId() : null;
                }
                this.visibleFallbackForHiddenDefaultOutsideTabs = uniqueId;
                List<AvailablePackages.Info> packagesOutsideTabs2 = this.packages.getPackagesOutsideTabs();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator<T> it4 = packagesOutsideTabs2.iterator();
                while (it4.hasNext()) {
                    linkedHashSet.add(((AvailablePackages.Info) it4.next()).getUniqueId());
                }
                this.packagesOutsideTabsUniqueIds = linkedHashSet;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Integer, List<AvailablePackages.Info>> entry : this.packages.getPackagesByTab().entrySet()) {
                    int iIntValue = entry.getKey().intValue();
                    Iterator<T> it5 = entry.getValue().iterator();
                    while (it5.hasNext()) {
                        String uniqueId2 = ((AvailablePackages.Info) it5.next()).getUniqueId();
                        linkedHashMap.put(uniqueId2, SetsKt.plus((Set<? extends Integer>) linkedHashMap.getOrDefault(uniqueId2, SetsKt.emptySet()), Integer.valueOf(iIntValue)));
                    }
                }
                this.tabsByUniqueId = linkedHashMap;
                this.localeId = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LocaleId.m13797boximpl(m14176toLocaleId8pYHj4M(initialLocaleList)), null, 2, null);
                this.availableStorefrontCountryLocalesByLanguage = LazyKt.lazy(new Function0<Map<String, ? extends Locale>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$availableStorefrontCountryLocalesByLanguage$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Map<String, ? extends Locale> invoke() {
                        return PaywallStateKt.getAvailableStorefrontCountryLocalesByLanguage$default(this.this$0.getStorefrontCountryCode(), null, 2, null);
                    }
                });
                this.locale = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.text.intl.Locale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$locale$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final androidx.compose.p004ui.text.intl.Locale invoke() {
                        return LocalizationKt.m13902toComposeLocale_KYeFs0(this.this$0.m14174getLocaleIduqtKvyA());
                    }
                });
                this.currencyLocale = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.text.intl.Locale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$currencyLocale$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final androidx.compose.p004ui.text.intl.Locale invoke() {
                        String storefrontCountryCode = this.this$0.getStorefrontCountryCode();
                        if (storefrontCountryCode == null || StringsKt.isBlank(storefrontCountryCode)) {
                            return this.this$0.getLocale();
                        }
                        String lowerCase = this.this$0.getLocale().getLanguage().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        Locale javaLocale = (Locale) this.this$0.getAvailableStorefrontCountryLocalesByLanguage().get(lowerCase);
                        if (javaLocale == null && (javaLocale = (Locale) CollectionsKt.firstOrNull(this.this$0.getAvailableStorefrontCountryLocalesByLanguage().values())) == null) {
                            Locale.Builder locale = new Locale.Builder().setLocale(LocalizationKt.toJavaLocale(this.this$0.getLocale()));
                            String upperCase = this.this$0.getStorefrontCountryCode().toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            javaLocale = locale.setRegion(upperCase).build();
                        }
                        Intrinsics.checkNotNullExpressionValue(javaLocale, "javaLocale");
                        return LocalizationKt.toComposeLocale(javaLocale);
                    }
                });
                SnapshotStateMap<Integer, String> snapshotStateMapMutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
                Map<Integer, List<AvailablePackages.Info>> packagesByTab = this.packages.getPackagesByTab();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(packagesByTab.size()));
                Iterator<T> it6 = packagesByTab.entrySet().iterator();
                while (it6.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it6.next();
                    Object key = entry2.getKey();
                    AvailablePackages.Info infoDefaultSelection2 = PaywallStateKt.defaultSelection((List) entry2.getValue(), this.mergedCustomVariables);
                    linkedHashMap2.put(key, infoDefaultSelection2 != null ? infoDefaultSelection2.getUniqueId() : null);
                }
                snapshotStateMapMutableStateMapOf.putAll(linkedHashMap2);
                this.selectedPackageByTab = snapshotStateMapMutableStateMapOf;
                this.selectedTabIndex = SnapshotIntStateKt.mutableIntStateOf(num != null ? num.intValue() : 0);
                String uniqueId3 = this.initialSelectedPackageOutsideTabs;
                if (uniqueId3 == null && (uniqueId3 = snapshotStateMapMutableStateMapOf.get(Integer.valueOf(getSelectedTabIndex()))) == null) {
                    List<AvailablePackages.Info> list2 = this.packages.getPackagesByTab().get(Integer.valueOf(getSelectedTabIndex()));
                    uniqueId3 = (list2 == null || (infoDefaultSelection = PaywallStateKt.defaultSelection(list2, this.mergedCustomVariables)) == null) ? null : infoDefaultSelection.getUniqueId();
                    if (uniqueId3 == null) {
                        uniqueId3 = this.visibleFallbackForHiddenDefaultOutsideTabs;
                    }
                }
                this.initialSelectedPackageUniqueId = uniqueId3;
                this.selectedPackageUniqueId = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(uniqueId3, null, 2, null);
                this.defaultPackageInfo = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                this.selectedPackageInfo = SnapshotStateKt.derivedStateOf(new Function0<SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$selectedPackageInfo$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                        PaywallState.Loaded.Components.AvailablePackages.Info infoFindPackageInfoByUniqueId;
                        String selectedPackageUniqueId = this.this$0.getSelectedPackageUniqueId();
                        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = null;
                        if (selectedPackageUniqueId != null && (infoFindPackageInfoByUniqueId = this.this$0.findPackageInfoByUniqueId(selectedPackageUniqueId)) != null) {
                            selectedPackageInfo = new PaywallState.Loaded.Components.SelectedPackageInfo(infoFindPackageInfoByUniqueId.getPkg(), infoFindPackageInfoByUniqueId.getResolvedOffer(), selectedPackageUniqueId, PackageExtensionsKt.calculateOfferEligibility(infoFindPackageInfoByUniqueId.getResolvedOffer(), infoFindPackageInfoByUniqueId.getPkg()));
                        }
                        return selectedPackageInfo == null ? this.this$0.getDefaultPackageInfo() : selectedPackageInfo;
                    }
                });
                this.selectedOfferEligibility = SnapshotStateKt.derivedStateOf(new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$selectedOfferEligibility$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OfferEligibility invoke() {
                        OfferEligibility offerEligibility;
                        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = this.this$0.getSelectedPackageInfo();
                        return (selectedPackageInfo == null || (offerEligibility = selectedPackageInfo.getOfferEligibility()) == null) ? OfferEligibility.Ineligible.INSTANCE : offerEligibility;
                    }
                });
                this.mostExpensivePricePerMonthMicros = SnapshotStateKt.derivedStateOf(new Function0<Long>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Long invoke() {
                        PaywallState.Loaded.Components components = this.this$0;
                        List<PaywallState.Loaded.Components.AvailablePackages.Info> packagesOutsideTabs3 = components.packages.getPackagesOutsideTabs();
                        List<PaywallState.Loaded.Components.AvailablePackages.Info> listEmptyList = this.this$0.packages.getPackagesByTab().get(Integer.valueOf(this.this$0.getSelectedTabIndex()));
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        return components.mostExpensivePricePerMonthMicros(CollectionsKt.plus((Collection) packagesOutsideTabs3, (Iterable) listEmptyList));
                    }
                });
                this.clickScopedActionInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                this.sheet = initialSheetState;
            }

            public final ComponentStyle getStack() {
                return this.stack;
            }

            public final ComponentStyle getHeader() {
                return this.header;
            }

            public final ComponentStyle getStickyFooter() {
                return this.stickyFooter;
            }

            public final BackgroundStyles getBackground() {
                return this.background;
            }

            public final boolean getMainStackHasHeroImage() {
                return this.mainStackHasHeroImage;
            }

            public final boolean getShowPricesWithDecimals() {
                return this.showPricesWithDecimals;
            }

            public final UiConfig.VariableConfig getVariableConfig() {
                return this.variableConfig;
            }

            public final VariableDataProvider getVariableDataProvider() {
                return this.variableDataProvider;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded
            public Offering getOffering() {
                return this.offering;
            }

            public final String getStorefrontCountryCode() {
                return this.storefrontCountryCode;
            }

            public /* synthetic */ Components(ComponentStyle componentStyle, ComponentStyle componentStyle2, ComponentStyle componentStyle3, BackgroundStyles backgroundStyles, boolean z, boolean z2, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, Offering offering, NonEmptySet nonEmptySet, String str, Function0 function0, AvailablePackages availablePackages, Map map, Map map2, LocaleList localeList, Integer num, SimpleSheetState simpleSheetState, PurchasesType purchasesType, WorkflowScreenContext workflowScreenContext, PaywallStateStore paywallStateStore, State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(componentStyle, componentStyle2, componentStyle3, backgroundStyles, (i & 16) != 0 ? false : z, z2, variableConfig, variableDataProvider, offering, nonEmptySet, str, function0, availablePackages, (i & 8192) != 0 ? MapsKt.emptyMap() : map, (i & 16384) != 0 ? MapsKt.emptyMap() : map2, (32768 & i) != 0 ? LocaleList.INSTANCE.getCurrent() : localeList, (65536 & i) != 0 ? null : num, (131072 & i) != 0 ? new SimpleSheetState() : simpleSheetState, purchasesType, (524288 & i) != 0 ? null : workflowScreenContext, (1048576 & i) != 0 ? new PaywallStateStore(MapsKt.emptyMap()) : paywallStateStore, (i & 2097152) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null) : state);
            }

            public final Map<String, CustomVariableValue> getCustomVariables() {
                return this.customVariables;
            }

            public final Map<String, CustomVariableValue> getDefaultCustomVariables() {
                return this.defaultCustomVariables;
            }

            public final WorkflowScreenContext getWorkflowScreen() {
                return this.workflowScreen;
            }

            public final PaywallStateStore getStateStore() {
                return this.stateStore;
            }

            public final Map<String, CustomVariableValue> getMergedCustomVariables() {
                return this.mergedCustomVariables;
            }

            public final Store getStore() {
                return this.purchases.getStore();
            }

            /* JADX INFO: compiled from: PaywallState.kt */
            @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001bB-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "", "packagesOutsideTabs", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "packagesByTab", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "hasAnyPackages", "", "getHasAnyPackages", "()Z", "getPackagesByTab", "()Ljava/util/Map;", "getPackagesOutsideTabs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "merge", "with", "toString", "", "Info", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
            public static final /* data */ class AvailablePackages {
                public static final int $stable = 8;
                private final Map<Integer, List<Info>> packagesByTab;
                private final List<Info> packagesOutsideTabs;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AvailablePackages copy$default(AvailablePackages availablePackages, List list, Map map, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = availablePackages.packagesOutsideTabs;
                    }
                    if ((i & 2) != 0) {
                        map = availablePackages.packagesByTab;
                    }
                    return availablePackages.copy(list, map);
                }

                public final List<Info> component1() {
                    return this.packagesOutsideTabs;
                }

                public final Map<Integer, List<Info>> component2() {
                    return this.packagesByTab;
                }

                public final AvailablePackages copy(List<Info> packagesOutsideTabs, Map<Integer, ? extends List<Info>> packagesByTab) {
                    Intrinsics.checkNotNullParameter(packagesOutsideTabs, "packagesOutsideTabs");
                    Intrinsics.checkNotNullParameter(packagesByTab, "packagesByTab");
                    return new AvailablePackages(packagesOutsideTabs, packagesByTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AvailablePackages)) {
                        return false;
                    }
                    AvailablePackages availablePackages = (AvailablePackages) other;
                    return Intrinsics.areEqual(this.packagesOutsideTabs, availablePackages.packagesOutsideTabs) && Intrinsics.areEqual(this.packagesByTab, availablePackages.packagesByTab);
                }

                public int hashCode() {
                    return (this.packagesOutsideTabs.hashCode() * 31) + this.packagesByTab.hashCode();
                }

                public String toString() {
                    return "AvailablePackages(packagesOutsideTabs=" + this.packagesOutsideTabs + ", packagesByTab=" + this.packagesByTab + ')';
                }

                /* JADX WARN: Multi-variable type inference failed */
                public AvailablePackages(List<Info> packagesOutsideTabs, Map<Integer, ? extends List<Info>> packagesByTab) {
                    Intrinsics.checkNotNullParameter(packagesOutsideTabs, "packagesOutsideTabs");
                    Intrinsics.checkNotNullParameter(packagesByTab, "packagesByTab");
                    this.packagesOutsideTabs = packagesOutsideTabs;
                    this.packagesByTab = packagesByTab;
                }

                public final List<Info> getPackagesOutsideTabs() {
                    return this.packagesOutsideTabs;
                }

                public final Map<Integer, List<Info>> getPackagesByTab() {
                    return this.packagesByTab;
                }

                /* JADX INFO: compiled from: PaywallState.kt */
                @Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003JU\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010¨\u0006*"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "", "pkg", "Lcom/revenuecat/purchases/Package;", "isSelectedByDefault", "", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "visible", "visibilityOverrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPackagePartial;", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "(Lcom/revenuecat/purchases/Package;ZLcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;ZLjava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;)V", "()Z", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getPkg", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "uniqueId", "", "getUniqueId", "()Ljava/lang/String;", "getVisibilityOverrides", "()Ljava/util/List;", "getVisible", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
                public static final /* data */ class Info {
                    public static final int $stable = 8;
                    private final boolean isSelectedByDefault;
                    private final OfferEligibility offerEligibility;
                    private final Package pkg;
                    private final ResolvedOffer resolvedOffer;
                    private final String uniqueId;
                    private final List<PresentedOverride<PresentedPackagePartial>> visibilityOverrides;
                    private final boolean visible;

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ Info copy$default(Info info, Package r1, boolean z, ResolvedOffer resolvedOffer, boolean z2, List list, OfferEligibility offerEligibility, int i, Object obj) {
                        if ((i & 1) != 0) {
                            r1 = info.pkg;
                        }
                        if ((i & 2) != 0) {
                            z = info.isSelectedByDefault;
                        }
                        if ((i & 4) != 0) {
                            resolvedOffer = info.resolvedOffer;
                        }
                        if ((i & 8) != 0) {
                            z2 = info.visible;
                        }
                        if ((i & 16) != 0) {
                            list = info.visibilityOverrides;
                        }
                        if ((i & 32) != 0) {
                            offerEligibility = info.offerEligibility;
                        }
                        List list2 = list;
                        OfferEligibility offerEligibility2 = offerEligibility;
                        return info.copy(r1, z, resolvedOffer, z2, list2, offerEligibility2);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final Package getPkg() {
                        return this.pkg;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final boolean getIsSelectedByDefault() {
                        return this.isSelectedByDefault;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final ResolvedOffer getResolvedOffer() {
                        return this.resolvedOffer;
                    }

                    /* JADX INFO: renamed from: component4, reason: from getter */
                    public final boolean getVisible() {
                        return this.visible;
                    }

                    public final List<PresentedOverride<PresentedPackagePartial>> component5() {
                        return this.visibilityOverrides;
                    }

                    /* JADX INFO: renamed from: component6, reason: from getter */
                    public final OfferEligibility getOfferEligibility() {
                        return this.offerEligibility;
                    }

                    public final Info copy(Package pkg, boolean isSelectedByDefault, ResolvedOffer resolvedOffer, boolean visible, List<PresentedOverride<PresentedPackagePartial>> visibilityOverrides, OfferEligibility offerEligibility) {
                        Intrinsics.checkNotNullParameter(pkg, "pkg");
                        Intrinsics.checkNotNullParameter(visibilityOverrides, "visibilityOverrides");
                        return new Info(pkg, isSelectedByDefault, resolvedOffer, visible, visibilityOverrides, offerEligibility);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Info)) {
                            return false;
                        }
                        Info info = (Info) other;
                        return Intrinsics.areEqual(this.pkg, info.pkg) && this.isSelectedByDefault == info.isSelectedByDefault && Intrinsics.areEqual(this.resolvedOffer, info.resolvedOffer) && this.visible == info.visible && Intrinsics.areEqual(this.visibilityOverrides, info.visibilityOverrides) && Intrinsics.areEqual(this.offerEligibility, info.offerEligibility);
                    }

                    public int hashCode() {
                        int iHashCode = ((this.pkg.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31;
                        ResolvedOffer resolvedOffer = this.resolvedOffer;
                        int iHashCode2 = (((((iHashCode + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31) + Boolean.hashCode(this.visible)) * 31) + this.visibilityOverrides.hashCode()) * 31;
                        OfferEligibility offerEligibility = this.offerEligibility;
                        return iHashCode2 + (offerEligibility != null ? offerEligibility.hashCode() : 0);
                    }

                    public String toString() {
                        return "Info(pkg=" + this.pkg + ", isSelectedByDefault=" + this.isSelectedByDefault + ", resolvedOffer=" + this.resolvedOffer + ", visible=" + this.visible + ", visibilityOverrides=" + this.visibilityOverrides + ", offerEligibility=" + this.offerEligibility + ')';
                    }

                    public Info(Package pkg, boolean z, ResolvedOffer resolvedOffer, boolean z2, List<PresentedOverride<PresentedPackagePartial>> visibilityOverrides, OfferEligibility offerEligibility) {
                        SubscriptionOption option;
                        Intrinsics.checkNotNullParameter(pkg, "pkg");
                        Intrinsics.checkNotNullParameter(visibilityOverrides, "visibilityOverrides");
                        this.pkg = pkg;
                        this.isSelectedByDefault = z;
                        this.resolvedOffer = resolvedOffer;
                        this.visible = z2;
                        this.visibilityOverrides = visibilityOverrides;
                        this.offerEligibility = offerEligibility;
                        ResolvedOffer resolvedOffer2 = this.resolvedOffer;
                        String str = null;
                        ResolvedOffer.ConfiguredOffer configuredOffer = resolvedOffer2 instanceof ResolvedOffer.ConfiguredOffer ? (ResolvedOffer.ConfiguredOffer) resolvedOffer2 : null;
                        if (configuredOffer != null && (option = configuredOffer.getOption()) != null) {
                            str = option.get$id();
                        }
                        this.uniqueId = str != null ? this.pkg.getIdentifier() + AbstractJsonLexerKt.COLON + str : this.pkg.getIdentifier();
                    }

                    public final Package getPkg() {
                        return this.pkg;
                    }

                    public final boolean isSelectedByDefault() {
                        return this.isSelectedByDefault;
                    }

                    public final ResolvedOffer getResolvedOffer() {
                        return this.resolvedOffer;
                    }

                    public final boolean getVisible() {
                        return this.visible;
                    }

                    public /* synthetic */ Info(Package r2, boolean z, ResolvedOffer resolvedOffer, boolean z2, List list, OfferEligibility offerEligibility, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this(r2, z, (i & 4) != 0 ? null : resolvedOffer, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? null : offerEligibility);
                    }

                    public final List<PresentedOverride<PresentedPackagePartial>> getVisibilityOverrides() {
                        return this.visibilityOverrides;
                    }

                    public final OfferEligibility getOfferEligibility() {
                        return this.offerEligibility;
                    }

                    public final String getUniqueId() {
                        return this.uniqueId;
                    }
                }

                public final AvailablePackages merge(AvailablePackages with) {
                    List<Info> list = this.packagesOutsideTabs;
                    List<Info> listEmptyList = with != null ? with.packagesOutsideTabs : null;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List listPlus = CollectionsKt.plus((Collection) list, (Iterable) listEmptyList);
                    Map<Integer, List<Info>> mapEmptyMap = this.packagesByTab;
                    if (mapEmptyMap.isEmpty()) {
                        Map<Integer, List<Info>> map = with != null ? with.packagesByTab : null;
                        mapEmptyMap = map == null ? MapsKt.emptyMap() : map;
                    }
                    return new AvailablePackages(listPlus, mapEmptyMap);
                }

                public final boolean getHasAnyPackages() {
                    return (this.packagesOutsideTabs.isEmpty() && this.packagesByTab.isEmpty()) ? false : true;
                }
            }

            /* JADX INFO: compiled from: PaywallState.kt */
            @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "uniqueId", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;)V", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getUniqueId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
            public static final /* data */ class SelectedPackageInfo {
                public static final int $stable = 8;
                private final OfferEligibility offerEligibility;
                private final Package rcPackage;
                private final ResolvedOffer resolvedOffer;
                private final String uniqueId;

                public static /* synthetic */ SelectedPackageInfo copy$default(SelectedPackageInfo selectedPackageInfo, Package r1, ResolvedOffer resolvedOffer, String str, OfferEligibility offerEligibility, int i, Object obj) {
                    if ((i & 1) != 0) {
                        r1 = selectedPackageInfo.rcPackage;
                    }
                    if ((i & 2) != 0) {
                        resolvedOffer = selectedPackageInfo.resolvedOffer;
                    }
                    if ((i & 4) != 0) {
                        str = selectedPackageInfo.uniqueId;
                    }
                    if ((i & 8) != 0) {
                        offerEligibility = selectedPackageInfo.offerEligibility;
                    }
                    return selectedPackageInfo.copy(r1, resolvedOffer, str, offerEligibility);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Package getRcPackage() {
                    return this.rcPackage;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final ResolvedOffer getResolvedOffer() {
                    return this.resolvedOffer;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final String getUniqueId() {
                    return this.uniqueId;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final OfferEligibility getOfferEligibility() {
                    return this.offerEligibility;
                }

                public final SelectedPackageInfo copy(Package rcPackage, ResolvedOffer resolvedOffer, String uniqueId, OfferEligibility offerEligibility) {
                    Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    Intrinsics.checkNotNullParameter(offerEligibility, "offerEligibility");
                    return new SelectedPackageInfo(rcPackage, resolvedOffer, uniqueId, offerEligibility);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof SelectedPackageInfo)) {
                        return false;
                    }
                    SelectedPackageInfo selectedPackageInfo = (SelectedPackageInfo) other;
                    return Intrinsics.areEqual(this.rcPackage, selectedPackageInfo.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, selectedPackageInfo.resolvedOffer) && Intrinsics.areEqual(this.uniqueId, selectedPackageInfo.uniqueId) && Intrinsics.areEqual(this.offerEligibility, selectedPackageInfo.offerEligibility);
                }

                public int hashCode() {
                    int iHashCode = this.rcPackage.hashCode() * 31;
                    ResolvedOffer resolvedOffer = this.resolvedOffer;
                    return ((((iHashCode + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31) + this.uniqueId.hashCode()) * 31) + this.offerEligibility.hashCode();
                }

                public String toString() {
                    return "SelectedPackageInfo(rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", uniqueId=" + this.uniqueId + ", offerEligibility=" + this.offerEligibility + ')';
                }

                public SelectedPackageInfo(Package rcPackage, ResolvedOffer resolvedOffer, String uniqueId, OfferEligibility offerEligibility) {
                    Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    Intrinsics.checkNotNullParameter(offerEligibility, "offerEligibility");
                    this.rcPackage = rcPackage;
                    this.resolvedOffer = resolvedOffer;
                    this.uniqueId = uniqueId;
                    this.offerEligibility = offerEligibility;
                }

                public /* synthetic */ SelectedPackageInfo(Package r1, ResolvedOffer resolvedOffer, String str, OfferEligibility offerEligibility, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(r1, (i & 2) != 0 ? null : resolvedOffer, str, offerEligibility);
                }

                public final Package getRcPackage() {
                    return this.rcPackage;
                }

                public final ResolvedOffer getResolvedOffer() {
                    return this.resolvedOffer;
                }

                public final String getUniqueId() {
                    return this.uniqueId;
                }

                public final OfferEligibility getOfferEligibility() {
                    return this.offerEligibility;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: getLocaleId-uqtKvyA, reason: not valid java name */
            public final String m14174getLocaleIduqtKvyA() {
                return ((LocaleId) this.localeId.getValue()).m13803unboximpl();
            }

            /* JADX INFO: renamed from: setLocaleId-_KYeFs0, reason: not valid java name */
            private final void m14175setLocaleId_KYeFs0(String str) {
                this.localeId.setValue(LocaleId.m13797boximpl(str));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Map<String, Locale> getAvailableStorefrontCountryLocalesByLanguage() {
                return (Map) this.availableStorefrontCountryLocalesByLanguage.getValue();
            }

            public final androidx.compose.p004ui.text.intl.Locale getLocale() {
                return (androidx.compose.p004ui.text.intl.Locale) this.locale.getValue();
            }

            public final androidx.compose.p004ui.text.intl.Locale getCurrencyLocale() {
                return (androidx.compose.p004ui.text.intl.Locale) this.currencyLocale.getValue();
            }

            private final void setSelectedTabIndex(int i) {
                this.selectedTabIndex.setIntValue(i);
            }

            public final int getSelectedTabIndex() {
                return this.selectedTabIndex.getIntValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public final String getSelectedPackageUniqueId() {
                return (String) this.selectedPackageUniqueId.getValue();
            }

            private final void setSelectedPackageUniqueId(String str) {
                this.selectedPackageUniqueId.setValue(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public final SelectedPackageInfo getDefaultPackageInfo() {
                return (SelectedPackageInfo) this.defaultPackageInfo.getValue();
            }

            private final void setDefaultPackageInfo(SelectedPackageInfo selectedPackageInfo) {
                this.defaultPackageInfo.setValue(selectedPackageInfo);
            }

            public final void setDefaultPackage$revenuecatui_defaultsRelease(SelectedPackageInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                if (getDefaultPackageInfo() == null) {
                    setDefaultPackageInfo(info);
                }
            }

            public final SelectedPackageInfo getSelectedPackageInfo() {
                return (SelectedPackageInfo) this.selectedPackageInfo.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final AvailablePackages.Info findPackageInfoByUniqueId(String uniqueId) {
                Object obj;
                Object next;
                Iterator<T> it = this.packages.getPackagesOutsideTabs().iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((AvailablePackages.Info) next).getUniqueId(), uniqueId)) {
                        break;
                    }
                }
                AvailablePackages.Info info = (AvailablePackages.Info) next;
                if (info != null) {
                    return info;
                }
                Iterator it2 = CollectionsKt.flatten(this.packages.getPackagesByTab().values()).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (Intrinsics.areEqual(((AvailablePackages.Info) next2).getUniqueId(), uniqueId)) {
                        obj = next2;
                        break;
                    }
                }
                return (AvailablePackages.Info) obj;
            }

            public final OfferEligibility getSelectedOfferEligibility() {
                return (OfferEligibility) this.selectedOfferEligibility.getValue();
            }

            public final Long getMostExpensivePricePerMonthMicros() {
                return (Long) this.mostExpensivePricePerMonthMicros.getValue();
            }

            public final Date getCurrentDate() {
                return this.dateProvider.invoke();
            }

            public final String getAppUserID() {
                return this.purchases.getAppUserID();
            }

            public final /* synthetic */ int getHeaderHeightPx() {
                return this.headerHeightPx;
            }

            public final /* synthetic */ void setHeaderHeightPx$revenuecatui_defaultsRelease(int i) {
                this.headerHeightPx = i;
            }

            public final /* synthetic */ int getFooterHeightPx() {
                return this.footerHeightPx;
            }

            public final /* synthetic */ void setFooterHeightPx$revenuecatui_defaultsRelease(int i) {
                this.footerHeightPx = i;
            }

            private final void setClickScopedActionInProgress(boolean z) {
                this.clickScopedActionInProgress.setValue(Boolean.valueOf(z));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final boolean getClickScopedActionInProgress() {
                return ((Boolean) this.clickScopedActionInProgress.getValue()).booleanValue();
            }

            public final boolean getActionInProgress() {
                return this.viewModelActionInProgress.getValue().booleanValue() || getClickScopedActionInProgress();
            }

            public final SimpleSheetState getSheet() {
                return this.sheet;
            }

            public static /* synthetic */ void update$default(Components components, android.os.LocaleList localeList, Integer num, Boolean bool, int i, Object obj) {
                if ((i & 1) != 0) {
                    localeList = null;
                }
                if ((i & 2) != 0) {
                    num = null;
                }
                if ((i & 4) != 0) {
                    bool = null;
                }
                components.update(localeList, num, bool);
            }

            public final void update(android.os.LocaleList localeList, Integer selectedTabIndex, Boolean clickScopedActionInProgress) {
                AvailablePackages.Info infoDefaultSelection;
                if (localeList != null) {
                    String languageTags = localeList.toLanguageTags();
                    Intrinsics.checkNotNullExpressionValue(languageTags, "localeList.toLanguageTags()");
                    m14175setLocaleId_KYeFs0(m14176toLocaleId8pYHj4M(new LocaleList(languageTags)));
                }
                if (selectedTabIndex != null) {
                    setSelectedTabIndex(selectedTabIndex.intValue());
                    if (getSelectedPackageUniqueId() != null && CollectionsKt.contains(this.packagesOutsideTabsUniqueIds, getSelectedPackageUniqueId())) {
                        return;
                    }
                    String uniqueId = this.selectedPackageByTab.get(selectedTabIndex);
                    if (uniqueId == null && (uniqueId = this.initialSelectedPackageOutsideTabs) == null) {
                        List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(selectedTabIndex);
                        if (list == null || (infoDefaultSelection = PaywallStateKt.defaultSelection(list, this.mergedCustomVariables)) == null) {
                            uniqueId = null;
                        } else {
                            if (!infoDefaultSelection.isSelectedByDefault()) {
                                Logger.INSTANCE.m1587w("Could not find a visible default package for tab " + selectedTabIndex + ". Using the first visible package instead.");
                            }
                            uniqueId = infoDefaultSelection.getUniqueId();
                        }
                        if (uniqueId == null) {
                            uniqueId = this.visibleFallbackForHiddenDefaultOutsideTabs;
                        }
                    }
                    setSelectedPackageUniqueId(uniqueId);
                }
                if (clickScopedActionInProgress != null) {
                    setClickScopedActionInProgress(clickScopedActionInProgress.booleanValue());
                }
            }

            public final void update(String selectedPackageUniqueId) {
                Intrinsics.checkNotNullParameter(selectedPackageUniqueId, "selectedPackageUniqueId");
                setSelectedPackageUniqueId(selectedPackageUniqueId);
                int selectedTabIndex = getSelectedTabIndex();
                Set<Integer> set = this.tabsByUniqueId.get(selectedPackageUniqueId);
                if (set == null || !set.contains(Integer.valueOf(selectedTabIndex))) {
                    return;
                }
                this.selectedPackageByTab.put(Integer.valueOf(selectedTabIndex), selectedPackageUniqueId);
            }

            public final void resetToDefaultPackage() {
                setSelectedPackageUniqueId(peekDefaultPackageUniqueIdAfterSheetDismiss());
            }

            public final String peekDefaultPackageUniqueIdAfterSheetDismiss() {
                AvailablePackages.Info infoFirstVisible;
                AvailablePackages.Info infoAuthoredDefaultIfVisible;
                String uniqueId;
                List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(Integer.valueOf(getSelectedTabIndex()));
                if (list != null && (infoAuthoredDefaultIfVisible = PaywallStateKt.authoredDefaultIfVisible(list, this.mergedCustomVariables)) != null && (uniqueId = infoAuthoredDefaultIfVisible.getUniqueId()) != null) {
                    return uniqueId;
                }
                String str = this.initialSelectedPackageOutsideTabs;
                if (str != null || (str = this.selectedPackageByTab.get(Integer.valueOf(getSelectedTabIndex()))) != null) {
                    return str;
                }
                String uniqueId2 = (list == null || (infoFirstVisible = PaywallStateKt.firstVisible(list, this.mergedCustomVariables)) == null) ? null : infoFirstVisible.getUniqueId();
                return uniqueId2 == null ? this.visibleFallbackForHiddenDefaultOutsideTabs : uniqueId2;
            }

            public final SelectedPackageInfo peekSelectedPackageInfoAfterSheetDismiss() {
                String strPeekDefaultPackageUniqueIdAfterSheetDismiss = peekDefaultPackageUniqueIdAfterSheetDismiss();
                AvailablePackages.Info infoFindPackageInfoByUniqueId = strPeekDefaultPackageUniqueIdAfterSheetDismiss != null ? findPackageInfoByUniqueId(strPeekDefaultPackageUniqueIdAfterSheetDismiss) : null;
                if (strPeekDefaultPackageUniqueIdAfterSheetDismiss == null || infoFindPackageInfoByUniqueId == null) {
                    return null;
                }
                return new SelectedPackageInfo(infoFindPackageInfoByUniqueId.getPkg(), infoFindPackageInfoByUniqueId.getResolvedOffer(), strPeekDefaultPackageUniqueIdAfterSheetDismiss, PackageExtensionsKt.calculateOfferEligibility(infoFindPackageInfoByUniqueId.getResolvedOffer(), infoFindPackageInfoByUniqueId.getPkg()));
            }

            public final Package defaultPackageForPackageRowAnalytics() {
                AvailablePackages.Info infoFindPackageInfoByUniqueId;
                String strPeekDefaultPackageUniqueIdAfterSheetDismiss = peekDefaultPackageUniqueIdAfterSheetDismiss();
                if (strPeekDefaultPackageUniqueIdAfterSheetDismiss == null || (infoFindPackageInfoByUniqueId = findPackageInfoByUniqueId(strPeekDefaultPackageUniqueIdAfterSheetDismiss)) == null) {
                    return null;
                }
                return infoFindPackageInfoByUniqueId.getPkg();
            }

            /* JADX INFO: renamed from: toLocaleId-8pYHj4M, reason: not valid java name */
            private final String m14176toLocaleId8pYHj4M(LocaleList localeList) {
                String localeId;
                String preferredUILocaleOverride = this.purchases.getPreferredUILocaleOverride();
                LocaleList localeList2 = localeList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(localeList2, 10));
                Iterator<androidx.compose.p004ui.text.intl.Locale> it = localeList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(LocaleId.m13797boximpl(LocalizationKt.toLocaleId(it.next())));
                }
                List listPlus = CollectionsKt.plus((Collection<? extends Object>) arrayList, this.locales.getHead());
                LocaleId localeId2 = null;
                if (preferredUILocaleOverride != null) {
                    try {
                        localeId = LocalizationKt.toLocaleId(LocalizationKt.toComposeLocale(LocaleHelpersKt.createLocaleFromString(preferredUILocaleOverride)));
                    } catch (Exception unused) {
                        localeId = null;
                    }
                    if (localeId != null) {
                        listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(LocaleId.m13797boximpl(localeId)), (Iterable) listPlus);
                    }
                }
                Iterator it2 = listPlus.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String strM13896getBestMatch64pKzr8 = LocalizationKt.m13896getBestMatch64pKzr8(this.locales, ((LocaleId) it2.next()).m13803unboximpl());
                    LocaleId localeIdM13797boximpl = strM13896getBestMatch64pKzr8 != null ? LocaleId.m13797boximpl(strM13896getBestMatch64pKzr8) : null;
                    if (localeIdM13797boximpl != null) {
                        localeId2 = localeIdM13797boximpl;
                        break;
                    }
                }
                if (localeId2 != null) {
                    return localeId2.m13803unboximpl();
                }
                throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Long mostExpensivePricePerMonthMicros(List<AvailablePackages.Info> list) {
                Object next;
                Iterator it = SequencesKt.mapNotNull(SequencesKt.map(CollectionsKt.asSequence(list), new Function1<AvailablePackages.Info, StoreProduct>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$4
                    @Override // kotlin.jvm.functions.Function1
                    public final StoreProduct invoke(PaywallState.Loaded.Components.AvailablePackages.Info info) {
                        Intrinsics.checkNotNullParameter(info, "info");
                        return info.getPkg().getProduct();
                    }
                }), new Function1<StoreProduct, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$5
                    @Override // kotlin.jvm.functions.Function1
                    public final Price invoke(StoreProduct product) {
                        Intrinsics.checkNotNullParameter(product, "product");
                        return StoreProduct.pricePerMonth$default(product, null, 1, null);
                    }
                }).iterator();
                if (it.hasNext()) {
                    next = it.next();
                    if (it.hasNext()) {
                        long amountMicros = ((Price) next).getAmountMicros();
                        do {
                            Object next2 = it.next();
                            long amountMicros2 = ((Price) next2).getAmountMicros();
                            if (amountMicros < amountMicros2) {
                                next = next2;
                                amountMicros = amountMicros2;
                            }
                        } while (it.hasNext());
                    }
                } else {
                    next = null;
                }
                Price price = (Price) next;
                if (price != null) {
                    return Long.valueOf(price.getAmountMicros());
                }
                return null;
            }
        }
    }
}
