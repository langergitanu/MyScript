package com.revenuecat.purchases.p036ui.revenuecatui.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.text.font.AndroidFontKt;
import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontFamilyKt;
import androidx.compose.p004ui.text.font.FontKt;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.googlefonts.GoogleFont;
import androidx.compose.p004ui.text.googlefonts.GoogleFontKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.p036ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallKt;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.fonts.GoogleFontProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.fonts.PaywallFont;
import com.revenuecat.purchases.p036ui.revenuecatui.fonts.PaywallFontFamily;
import com.revenuecat.purchases.p036ui.revenuecatui.fonts.TypographyType;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.SdkConfigurationStateKt;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.Resumable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PaywallActivity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0015J\u001c\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0013H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivity;", "Landroidx/activity/ComponentActivity;", "()V", "exitOfferLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityArgs;", "createResultIntent", "Landroid/content/Intent;", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getArgs", "getFontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "launchExitOfferActivity", "", "exitOffering", "Lcom/revenuecat/purchases/Offering;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismissRequest", "onSaveInstanceState", "outState", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallActivity extends ComponentActivity {
    public static final String ARGS_EXTRA = "paywall_args";
    public static final String RESULT_EXTRA = "paywall_result";
    private final ActivityResultLauncher<PaywallActivityArgs> exitOfferLauncher = registerForActivityResult(new PaywallContract(), new ActivityResultCallback() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            PaywallActivity.exitOfferLauncher$lambda$0(this.f$0, (PaywallResult) obj);
        }
    });
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitOfferLauncher$lambda$0(PaywallActivity paywallActivity, PaywallResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        paywallActivity.setResult(-1, paywallActivity.createResultIntent(result));
        paywallActivity.finish();
    }

    private final PaywallActivityArgs getArgs() {
        if (Build.VERSION.SDK_INT >= 33) {
            return (PaywallActivityArgs) getIntent().getParcelableExtra(ARGS_EXTRA, PaywallActivityArgs.class);
        }
        return (PaywallActivityArgs) getIntent().getParcelableExtra(ARGS_EXTRA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FontProvider getFontProvider() {
        Map<TypographyType, PaywallFontFamily> fonts;
        ArrayList arrayList;
        List<PaywallFont> fonts2;
        Font fontM10622FontwCLgNak;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PaywallActivityArgs args = getArgs();
        if (args == null || (fonts = args.getFonts()) == null) {
            return null;
        }
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(fonts.size()));
        Iterator<T> it = fonts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            PaywallFontFamily paywallFontFamily = (PaywallFontFamily) entry.getValue();
            if (paywallFontFamily == null || (fonts2 = paywallFontFamily.getFonts()) == null) {
                arrayList = null;
            } else {
                List<PaywallFont> list = fonts2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (PaywallFont paywallFont : list) {
                    if (paywallFont instanceof PaywallFont.ResourceFont) {
                        PaywallFont.ResourceFont resourceFont = (PaywallFont.ResourceFont) paywallFont;
                        fontM10622FontwCLgNak = FontKt.m10548FontYpTlLL0$default(resourceFont.getResourceId(), resourceFont.getFontWeight(), FontStyle.m10565constructorimpl(resourceFont.getFontStyle()), 0, 8, null);
                    } else if (paywallFont instanceof PaywallFont.AssetFont) {
                        PaywallFont.AssetFont assetFont = (PaywallFont.AssetFont) paywallFont;
                        String path = assetFont.getPath();
                        AssetManager assets = getAssets();
                        Intrinsics.checkNotNullExpressionValue(assets, "assets");
                        fontM10622FontwCLgNak = AndroidFontKt.m10517FontMuC2MFs$default(path, assets, assetFont.getFontWeight(), FontStyle.m10565constructorimpl(assetFont.getFontStyle()), null, 16, null);
                    } else if (paywallFont instanceof PaywallFont.GoogleFont) {
                        PaywallFont.GoogleFont googleFont = (PaywallFont.GoogleFont) paywallFont;
                        GoogleFontProvider fontProvider = googleFont.getFontProvider();
                        Object googleProvider = linkedHashMap.get(fontProvider);
                        if (googleProvider == null) {
                            googleProvider = fontProvider.toGoogleProvider();
                            linkedHashMap.put(fontProvider, googleProvider);
                        }
                        fontM10622FontwCLgNak = GoogleFontKt.m10622FontwCLgNak(new GoogleFont(googleFont.getFontName(), false, 2, null), (GoogleFont.Provider) googleProvider, googleFont.getFontWeight(), FontStyle.m10565constructorimpl(googleFont.getFontStyle()));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList2.add(fontM10622FontwCLgNak);
                }
                arrayList = arrayList2;
            }
            linkedHashMap2.put(key, arrayList != null ? FontFamilyKt.FontFamily(arrayList) : null);
        }
        return new FontProvider() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.getFontProvider.1
            @Override // com.revenuecat.purchases.p036ui.revenuecatui.fonts.FontProvider
            public FontFamily getFont(TypographyType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return linkedHashMap2.get(type);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity$onCreate$compositeListener$1] */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String requiredEntitlementIdentifier;
        Integer nonSerializableArgsKey;
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        SdkConfigurationStateKt.restoreSdkConfigurationIfNeeded(this, savedInstanceState);
        final PaywallActivityArgs args = getArgs();
        boolean z = false;
        if (!(args != null ? args.getWasLaunchedThroughSDK() : false) && !Purchases.INSTANCE.isConfigured()) {
            Logger.INSTANCE.m1584e("PaywallActivity was launched incorrectly. Please use PaywallActivityLauncher, or Paywall/PaywallDialog/PaywallFooter composables to display the Paywall.");
            finish();
            return;
        }
        PaywallActivityNonSerializableArgs paywallActivityNonSerializableArgs = (args == null || (nonSerializableArgsKey = args.getNonSerializableArgsKey()) == null) ? null : PaywallActivityNonSerializableArgsStore.INSTANCE.get(nonSerializableArgsKey.intValue());
        if ((args != null ? args.getNonSerializableArgsKey() : null) != null && paywallActivityNonSerializableArgs == null) {
            Logger.INSTANCE.m1587w("PaywallActivity was recreated after process death causing PurchaseLogic and/or PaywallListener to be lost. Finishing activity.");
            setResult(-1, createResultIntent(PaywallResult.Cancelled.INSTANCE));
            finish();
            return;
        }
        final PaywallListener listener = paywallActivityNonSerializableArgs != null ? paywallActivityNonSerializableArgs.getListener() : null;
        final PaywallPurchaseLogic purchaseLogic = paywallActivityNonSerializableArgs != null ? paywallActivityNonSerializableArgs.getPurchaseLogic() : null;
        final ?? r6 = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity$onCreate$compositeListener$1
            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchasePackageInitiated(rcPackage, resume);
                } else {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreInitiated(resume);
                } else {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCompleted(customerInfo, storeTransaction);
                }
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(new PaywallResult.Purchased(customerInfo)));
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                PaywallResult.Error error2;
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseError(error);
                }
                if (error.getCode() == PurchasesErrorCode.PurchaseCancelledError) {
                    error2 = PaywallResult.Cancelled.INSTANCE;
                } else {
                    error2 = new PaywallResult.Error(error);
                }
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(error2));
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreCompleted(customerInfo);
                }
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(new PaywallResult.Restored(customerInfo)));
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreError(error);
                }
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(new PaywallResult.Error(error)));
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onWebCheckoutOpened() {
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onWebCheckoutOpened();
                }
            }

            @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
            public void onUrlOpened(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onUrlOpened(url);
                }
            }
        };
        if (args != null && args.getEdgeToEdge()) {
            z = true;
        }
        if (z) {
            EdgeToEdge.enable$default(this, null, null, 3, null);
        }
        final OfferingSelection.IdAndPresentedOfferingContext offeringIdAndPresentedOfferingContext = args != null ? args.getOfferingIdAndPresentedOfferingContext() : null;
        final Function1<CustomerInfo, Boolean> function1ShouldDisplayBlockForEntitlementIdentifier = (args == null || (requiredEntitlementIdentifier = args.getRequiredEntitlementIdentifier()) == null) ? null : HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(requiredEntitlementIdentifier);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(2032214180, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C208@8988L1709,208@8974L1723:PaywallActivity.kt#majwzs");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2032214180, i, -1, "com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.<anonymous> (PaywallActivity.kt:208)");
                    }
                    final PaywallActivity paywallActivity = PaywallActivity.this;
                    final OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = offeringIdAndPresentedOfferingContext;
                    final PaywallActivityArgs paywallActivityArgs = args;
                    final PaywallActivity$onCreate$compositeListener$1 paywallActivity$onCreate$compositeListener$1 = r6;
                    final PaywallPurchaseLogic paywallPurchaseLogic = purchaseLogic;
                    final Function1<CustomerInfo, Boolean> function1 = function1ShouldDisplayBlockForEntitlementIdentifier;
                    MaterialThemeKt.MaterialTheme(null, null, null, ComposableLambdaKt.rememberComposableLambda(-588670640, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C213@9300L1383,211@9204L1479:PaywallActivity.kt#majwzs");
                            if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-588670640, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.<anonymous>.<anonymous> (PaywallActivity.kt:211)");
                                }
                                WindowInsets WindowInsets = WindowInsetsKt.WindowInsets(0, 0, 0, 0);
                                final PaywallActivity paywallActivity2 = paywallActivity;
                                final OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext2 = idAndPresentedOfferingContext;
                                final PaywallActivityArgs paywallActivityArgs2 = paywallActivityArgs;
                                final PaywallActivity$onCreate$compositeListener$1 paywallActivity$onCreate$compositeListener$12 = paywallActivity$onCreate$compositeListener$1;
                                final PaywallPurchaseLogic paywallPurchaseLogic2 = paywallPurchaseLogic;
                                final Function1<CustomerInfo, Boolean> function12 = function1;
                                ScaffoldKt.m5487ScaffoldTvnljyQ(null, null, null, null, null, 0, 0L, 0L, WindowInsets, ComposableLambdaKt.rememberComposableLambda(2025926559, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                                        invoke(paddingValues, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(PaddingValues anonymous$parameter$0$, Composer composer3, int i3) {
                                        Map<String, CustomVariableValue> mapEmptyMap;
                                        Intrinsics.checkNotNullParameter(anonymous$parameter$0$, "$anonymous$parameter$0$");
                                        ComposerKt.sourceInformation(composer3, "C214@9327L1338:PaywallActivity.kt#majwzs");
                                        if ((i3 & 17) != 16 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2025926559, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (PaywallActivity.kt:214)");
                                            }
                                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            final PaywallActivity paywallActivity3 = paywallActivity2;
                                            OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext3 = idAndPresentedOfferingContext2;
                                            PaywallActivityArgs paywallActivityArgs3 = paywallActivityArgs2;
                                            PaywallActivity$onCreate$compositeListener$1 paywallActivity$onCreate$compositeListener$13 = paywallActivity$onCreate$compositeListener$12;
                                            PaywallPurchaseLogic paywallPurchaseLogic3 = paywallPurchaseLogic2;
                                            Function1<CustomerInfo, Boolean> function13 = function12;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxSize$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer3);
                                            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023280106, "C218@9518L56,227@10109L18,230@10291L169,235@10507L87,235@10486L108,239@10620L23:PaywallActivity.kt#majwzs");
                                            composer3.startReplaceGroup(1035100146);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):PaywallActivity.kt#9igjgp");
                                            boolean zChangedInstance = composer3.changedInstance(paywallActivity3);
                                            Object objRememberedValue = composer3.rememberedValue();
                                            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity$onCreate$1$1$1$1$paywallOptions$1$1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        paywallActivity3.onDismissRequest(null, null);
                                                    }
                                                };
                                                composer3.updateRememberedValue(objRememberedValue);
                                            }
                                            composer3.endReplaceGroup();
                                            PaywallOptions.Builder purchaseLogic2 = new PaywallOptions.Builder((Function0) objRememberedValue).setOfferingSelection$revenuecatui_defaultsRelease((OfferingSelection) idAndPresentedOfferingContext3).setFontProvider(paywallActivity3.getFontProvider()).setShouldDisplayDismissButton(paywallActivityArgs3 != null ? paywallActivityArgs3.getShouldDisplayDismissButton() : true).setListener(paywallActivity$onCreate$compositeListener$13).setPurchaseLogic(paywallPurchaseLogic3);
                                            composer3.startReplaceGroup(1035119020);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):PaywallActivity.kt#9igjgp");
                                            boolean zChangedInstance2 = composer3.changedInstance(paywallActivity3);
                                            Object objRememberedValue2 = composer3.rememberedValue();
                                            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue2 = (KFunction) new PaywallActivity$onCreate$1$1$1$1$paywallOptions$2$1(paywallActivity3);
                                                composer3.updateRememberedValue(objRememberedValue2);
                                            }
                                            composer3.endReplaceGroup();
                                            PaywallOptions.Builder dismissRequestWithExitOffering$revenuecatui_defaultsRelease = purchaseLogic2.setDismissRequestWithExitOffering$revenuecatui_defaultsRelease((Function2<? super Offering, ? super PaywallResult, Unit>) ((KFunction) objRememberedValue2));
                                            if (paywallActivityArgs3 == null || (mapEmptyMap = paywallActivityArgs3.getCustomVariables()) == null) {
                                                mapEmptyMap = MapsKt.emptyMap();
                                            }
                                            PaywallOptions paywallOptionsBuild = dismissRequestWithExitOffering$revenuecatui_defaultsRelease.setCustomVariables(mapEmptyMap).build();
                                            PaywallViewModel paywallViewModel = InternalPaywallKt.getPaywallViewModel(paywallOptionsBuild, function13, composer3, 0, 0);
                                            Unit unit = Unit.INSTANCE;
                                            composer3.startReplaceGroup(1035131825);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):PaywallActivity.kt#9igjgp");
                                            boolean zChanged = composer3.changed(paywallViewModel);
                                            Object objRememberedValue3 = composer3.rememberedValue();
                                            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue3 = (Function2) new PaywallActivity$onCreate$1$1$1$1$1$1(paywallViewModel, null);
                                                composer3.updateRememberedValue(objRememberedValue3);
                                            }
                                            composer3.endReplaceGroup();
                                            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer3, 6);
                                            PaywallKt.Paywall(paywallOptionsBuild, composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54), composer2, 805306368, 255);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composer, 54), composer, 3072, 7);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDismissRequest(Offering exitOffering, PaywallResult result) {
        if (result != null) {
            setResult(-1, createResultIntent(result));
        }
        if (exitOffering != null) {
            launchExitOfferActivity(exitOffering);
        } else {
            finish();
        }
    }

    private final void launchExitOfferActivity(Offering exitOffering) {
        PaywallActivityArgs args = getArgs();
        if (args == null) {
            finish();
        } else {
            this.exitOfferLauncher.launch(PaywallActivityArgs.copy$default(args, null, new OfferingSelection.IdAndPresentedOfferingContext(exitOffering.getIdentifier(), null), null, false, false, false, null, null, 253, null));
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        SdkConfigurationStateKt.saveSdkConfiguration(outState);
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createResultIntent(PaywallResult result) {
        Intent intentPutExtra = new Intent().putExtra(RESULT_EXTRA, result);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(RESULT_EXTRA, result)");
        return intentPutExtra;
    }
}
