package com.myscript.nebo.purchase;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.p019ui.compose.AdaptiveModalDialogKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.dms.gdrive.C6278R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.p034ui.compose.NativeSignInDialogKt;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.purchase.PaywallViewModel;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import com.myscript.nebo.sso.p032ui.login.LoginActivityHelperKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.Resumable;
import java.io.FileNotFoundException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Paywall.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001aC\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001aq\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u001c\u0010\u001a\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001eH\u0007¢\u0006\u0002\u0010 \u001au\u0010!\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u001c\u0010\u001a\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001eH\u0007¢\u0006\u0002\u0010\"\u001a \u0010#\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010&¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\f\u0010-\u001a\u0004\u0018\u00010.X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u000200X\u008a\u0084\u0002"}, m1599d2 = {"PaywallScreen", "", "paywallViewModel", "Lcom/myscript/nebo/purchase/PaywallViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "placementId", "", "onPurchased", "Lkotlin/Function0;", "onNotifyFirebasePaywallDisplay", "onNotifyFirebasePurchaseConfirmation", "Lkotlin/Function1;", "(Lcom/myscript/nebo/purchase/PaywallViewModel;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PaywallDialog", "showPopup", "", "origin", "onDismiss", "(ZLcom/myscript/nebo/purchase/PaywallViewModel;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LoadingLayout", "(Landroidx/compose/runtime/Composer;I)V", "PaywallLayout", "offering", "Lcom/revenuecat/purchases/Offering;", "onCheckSubscription", "onPurchaseInitiated", "Lkotlin/coroutines/Continuation;", "", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lcom/revenuecat/purchases/Offering;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "FetchedPaywall", "(Lcom/revenuecat/purchases/Offering;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "PaywallTheme", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_standardRelease", "paywallState", "Lcom/myscript/nebo/purchase/PaywallViewModel$PaywallState;", "showNativeSignIn", "networkState", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "preloaderLottieComposition", "Lcom/airbnb/lottie/LottieComposition;", "preloaderProgress", ""}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PaywallKt {

    /* JADX INFO: compiled from: Paywall.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaywallViewModel.State.values().length];
            try {
                iArr[PaywallViewModel.State.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallViewModel.State.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallViewModel.State.Subscribed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FetchedPaywall$lambda$1(Offering offering, Function0 function0, Function0 function02, Function1 function1, Function0 function03, Map map, int i, int i2, Composer composer, int i3) {
        FetchedPaywall(offering, function0, function02, function1, function03, map, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingLayout$lambda$1(int i, Composer composer, int i2) throws FileNotFoundException {
        LoadingLayout(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$1(boolean z, PaywallViewModel paywallViewModel, String str, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        PaywallDialog(z, paywallViewModel, str, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallLayout$lambda$1(Offering offering, Function0 function0, Function1 function1, Function0 function02, Modifier modifier, Map map, int i, int i2, Composer composer, int i3) {
        PaywallLayout(offering, function0, function1, function02, modifier, map, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$14(PaywallViewModel paywallViewModel, Modifier modifier, String str, Function0 function0, Function0 function02, Function1 function1, int i, int i2, Composer composer, int i3) throws FileNotFoundException {
        PaywallScreen(paywallViewModel, modifier, str, function0, function02, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallTheme$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        PaywallTheme(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$2$0(final String str) {
        NeboFirebaseEvent.PurchaseConfirmation.log(new Function1() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallKt.PaywallScreen$lambda$2$0$0(str, (Bundle) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$2$0$0(String str, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        if (str != null) {
            log.putString("planType", str);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PaywallScreen(final PaywallViewModel paywallViewModel, Modifier modifier, String str, Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) throws FileNotFoundException {
        int i3;
        Modifier modifier2;
        int i4;
        String str2;
        int i5;
        Function0<Unit> function03;
        int i6;
        Function0<Unit> function04;
        int i7;
        final Function1<? super String, Unit> function12;
        final Modifier modifier3;
        final String str3;
        final Function0<Unit> function05;
        final Function0<Unit> function06;
        final Function1<? super String, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function07;
        final Function0<Unit> function08;
        Modifier modifier4;
        int i8;
        final MutableState mutableState;
        boolean z;
        Function1<? super String, Unit> function14;
        Intrinsics.checkNotNullParameter(paywallViewModel, "paywallViewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2120411340);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallScreen)N(paywallViewModel,modifier,placementId,onPurchased,onNotifyFirebasePaywallDisplay,onNotifyFirebasePurchaseConfirmation)72@3463L2,73@3516L3,74@3583L106,76@3726L7,77@3759L24,79@3834L29,82@3954L34,85@4204L40,87@4272L50,91@4457L721,89@4348L830,139@6164L742,139@6154L752:Paywall.kt#txrdfj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(paywallViewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    str2 = str;
                    i3 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function03 = function0;
                        i3 |= composerStartRestartGroup.changedInstance(function03) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 != 0) {
                        if ((i & 24576) == 0) {
                            function04 = function02;
                            i3 |= composerStartRestartGroup.changedInstance(function04) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                            function12 = function1;
                        } else {
                            function12 = function1;
                            if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function12) ? 131072 : 65536;
                            }
                        }
                        if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            str3 = str2;
                            function05 = function03;
                            function06 = function04;
                            function13 = function12;
                        } else {
                            Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                            String str4 = i4 != 0 ? null : str2;
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900794410, "CC(remember):Paywall.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda28
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function07 = (Function0) objRememberedValue;
                            } else {
                                function07 = function03;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900792713, "CC(remember):Paywall.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                function08 = (Function0) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function08 = function04;
                            }
                            if (i7 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900790466, "CC(remember):Paywall.kt#9igjgp");
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return PaywallKt.PaywallScreen$lambda$2$0((String) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function12 = (Function1) objRememberedValue3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2120411340, i3, -1, "com.myscript.nebo.purchase.PaywallScreen (Paywall.kt:75)");
                            }
                            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localContext);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Context context = (Context) objConsume;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(paywallViewModel.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                            final Offering offering = paywallViewModel.getOffering(str4);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900778666, "CC(remember):Paywall.kt#9igjgp");
                            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            MutableState mutableState2 = (MutableState) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Context applicationContext = context.getApplicationContext();
                            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
                            final NeboApplication neboApplication = (NeboApplication) applicationContext;
                            final State stateObserveAsState = LiveDataAdapterKt.observeAsState(neboApplication.provideNeboNetworkStateRepository().getNeboNetworkState(), NeboNetworkState.Offline.INSTANCE, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900768474, "CC(remember):Paywall.kt#9igjgp");
                            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = paywallViewModel.getCustomVariables();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            Map map = (Map) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900761883, "CC(remember):Paywall.kt#9igjgp");
                            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(paywallViewModel);
                            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                modifier4 = companion;
                            } else {
                                modifier4 = companion;
                                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
                                i8 = WhenMappings.$EnumSwitchMapping$0[PaywallScreen$lambda$3(stateCollectAsStateWithLifecycle).getState().ordinal()];
                                if (i8 != 1) {
                                    mutableState = mutableState2;
                                    z = true;
                                    function14 = function12;
                                    composerStartRestartGroup.startReplaceGroup(-1900737085);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "112@5254L15");
                                    LoadingLayout(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (i8 == 2) {
                                    composerStartRestartGroup.startReplaceGroup(-1900734559);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "116@5439L173,121@5649L194,128@5890L126,113@5310L749");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900731007, "CC(remember):Paywall.kt#9igjgp");
                                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(paywallViewModel) | ((458752 & i3) == 131072) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue8 = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return PaywallKt.PaywallScreen$lambda$10$0(paywallViewModel, function12, stateCollectAsStateWithLifecycle);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                    }
                                    Function0 function09 = (Function0) objRememberedValue8;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900724266, "CC(remember):Paywall.kt#9igjgp");
                                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(paywallViewModel);
                                    PaywallKt$PaywallScreen$5$1 paywallKt$PaywallScreen$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance3 || paywallKt$PaywallScreen$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        paywallKt$PaywallScreen$5$1RememberedValue = new PaywallKt$PaywallScreen$5$1(paywallViewModel, mutableState2, null);
                                        composerStartRestartGroup.updateRememberedValue(paywallKt$PaywallScreen$5$1RememberedValue);
                                    }
                                    Function1 function15 = (Function1) paywallKt$PaywallScreen$5$1RememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1900716622, "CC(remember):Paywall.kt#9igjgp");
                                    boolean zChangedInstance4 = ((i3 & 57344) == 16384) | composerStartRestartGroup.changedInstance(paywallViewModel) | composerStartRestartGroup.changedInstance(offering);
                                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance4 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue9 = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return PaywallKt.PaywallScreen$lambda$12$0(function08, paywallViewModel, offering);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    mutableState = mutableState2;
                                    function14 = function12;
                                    z = true;
                                    PaywallLayout(offering, function09, function15, (Function0) objRememberedValue9, modifier4, map, composerStartRestartGroup, 57344 & (i3 << 9), 0);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    if (i8 != 3) {
                                        composerStartRestartGroup.startReplaceGroup(-1900738376);
                                        composerStartRestartGroup.endReplaceGroup();
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    composerStartRestartGroup.startReplaceGroup(1207537385);
                                    composerStartRestartGroup.endReplaceGroup();
                                    function07.invoke();
                                    mutableState = mutableState2;
                                    z = true;
                                    function14 = function12;
                                }
                                String str5 = str4;
                                Function0<Unit> function010 = function08;
                                ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(1663044284, z, new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return PaywallKt.PaywallScreen$lambda$13(neboApplication, paywallViewModel, managedActivityResultLauncherRememberLauncherForActivityResult, context, mutableState, stateObserveAsState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str5;
                                function06 = function010;
                                function13 = function14;
                                function05 = function07;
                                modifier3 = modifier4;
                            }
                            objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PaywallKt.PaywallScreen$lambda$9$0(coroutineScope, paywallViewModel, (ActivityResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
                            i8 = WhenMappings.$EnumSwitchMapping$0[PaywallScreen$lambda$3(stateCollectAsStateWithLifecycle).getState().ordinal()];
                            if (i8 != 1) {
                            }
                            String str52 = str4;
                            Function0<Unit> function0102 = function08;
                            ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(1663044284, z, new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return PaywallKt.PaywallScreen$lambda$13(neboApplication, paywallViewModel, managedActivityResultLauncherRememberLauncherForActivityResult2, context, mutableState, stateObserveAsState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            str3 = str52;
                            function06 = function0102;
                            function13 = function14;
                            function05 = function07;
                            modifier3 = modifier4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return PaywallKt.PaywallScreen$lambda$14(paywallViewModel, modifier3, str3, function05, function06, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 24576;
                    function04 = function02;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function03 = function0;
                i6 = i2 & 16;
                if (i6 != 0) {
                }
                function04 = function02;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            str2 = str;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function03 = function0;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            function04 = function02;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        str2 = str;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function03 = function0;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        function04 = function02;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final boolean PaywallScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallScreen$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$9$0(CoroutineScope coroutineScope, PaywallViewModel paywallViewModel, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int resultCode = result.getResultCode();
        if (resultCode == -1) {
            Intent data = result.getData();
            Uri data2 = data != null ? data.getData() : null;
            if (data2 != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PaywallKt$PaywallScreen$loginLauncher$1$1$1(paywallViewModel, data2, null), 3, null);
            }
        } else if (resultCode == 0) {
            paywallViewModel.onLoginCanceled();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$10$0(PaywallViewModel paywallViewModel, final Function1 function1, final State state) {
        paywallViewModel.checkSubscription(new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallKt.PaywallScreen$lambda$10$0$0(function1, state);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$10$0$0(Function1 function1, State state) {
        ISubscriptionRepository.PlanType planType = PaywallScreen$lambda$3(state).getPlanType();
        function1.invoke(planType != null ? planType.getValue() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$12$0(Function0 function0, PaywallViewModel paywallViewModel, Offering offering) {
        function0.invoke();
        paywallViewModel.onPaywallDisplayed(offering);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$13(NeboApplication neboApplication, final PaywallViewModel paywallViewModel, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, final MutableState mutableState, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C144@6375L54,142@6253L28,150@6766L123,146@6528L38,147@6597L136,140@6174L726:Paywall.kt#txrdfj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1663044284, i, -1, "com.myscript.nebo.purchase.PaywallScreen.<anonymous> (Paywall.kt:140)");
            }
            boolean zPaywallScreen$lambda$5 = PaywallScreen$lambda$5(mutableState);
            GoogleSignInHelper googleSignInHelper = neboApplication.getGoogleSignInHelper();
            String strStringResource = StringResources_androidKt.stringResource(C6278R.string.google_server_client_id, composer, 0);
            boolean z = PaywallScreen$lambda$7(state) instanceof NeboNetworkState.Connected;
            ComposerKt.sourceInformationMarkerStart(composer, 457725688, "CC(remember):Paywall.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallKt.PaywallScreen$lambda$13$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 457742199, "CC(remember):Paywall.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(paywallViewModel);
            PaywallKt$PaywallScreen$7$2$1 paywallKt$PaywallScreen$7$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || paywallKt$PaywallScreen$7$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                paywallKt$PaywallScreen$7$2$1RememberedValue = new PaywallKt$PaywallScreen$7$2$1(paywallViewModel, null);
                composer.updateRememberedValue(paywallKt$PaywallScreen$7$2$1RememberedValue);
            }
            Function2 function2 = (Function2) paywallKt$PaywallScreen$7$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 457734498, "CC(remember):Paywall.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(paywallViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallKt.PaywallScreen$lambda$13$2$0(paywallViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function02 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 457736804, "CC(remember):Paywall.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(managedActivityResultLauncher) | composer.changedInstance(context);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallKt.PaywallScreen$lambda$13$3$0(managedActivityResultLauncher, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NativeSignInDialogKt.NativeSignInDialog(zPaywallScreen$lambda$5, function0, googleSignInHelper, strStringResource, function2, z, function02, (Function0) objRememberedValue3, composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$13$0$0(MutableState mutableState) {
        PaywallScreen$lambda$6(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$13$2$0(PaywallViewModel paywallViewModel) {
        paywallViewModel.onLoginCanceled();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallScreen$lambda$13$3$0(ManagedActivityResultLauncher managedActivityResultLauncher, Context context) {
        managedActivityResultLauncher.launch(LoginActivityHelperKt.getLoginActivityIntent(context, LoginOrigin.PremiumModal.getValue()));
        return Unit.INSTANCE;
    }

    public static final void PaywallDialog(final boolean z, final PaywallViewModel paywallViewModel, final String str, final Function0<Unit> onDismiss, final Function0<Unit> onPurchased, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paywallViewModel, "paywallViewModel");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onPurchased, "onPurchased");
        Composer composerStartRestartGroup = composer.startRestartGroup(-736816178);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallDialog)N(showPopup,paywallViewModel,origin,onDismiss,onPurchased)165@7103L1054,165@7090L1067:Paywall.kt#txrdfj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(paywallViewModel) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPurchased) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-736816178, i2, -1, "com.myscript.nebo.purchase.PaywallDialog (Paywall.kt:164)");
            }
            PaywallTheme(ComposableLambdaKt.rememberComposableLambda(1095631570, true, new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallKt.PaywallDialog$lambda$0(z, str, onDismiss, paywallViewModel, onPurchased, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallKt.PaywallDialog$lambda$1(z, paywallViewModel, str, onDismiss, onPurchased, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0(boolean z, final String str, final Function0 function0, final PaywallViewModel paywallViewModel, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C169@7234L183,175@7428L723,166@7113L1038:Paywall.kt#txrdfj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1095631570, i, -1, "com.myscript.nebo.purchase.PaywallDialog.<anonymous> (Paywall.kt:166)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 634955625, "CC(remember):Paywall.kt#9igjgp");
            boolean zChanged = composer.changed(str) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallKt.PaywallDialog$lambda$0$0$0(function0, str);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AdaptiveModalDialogKt.AdaptiveModalDialog(z, (Function0) objRememberedValue, false, ComposableLambdaKt.rememberComposableLambda(1270300504, true, new Function5() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function5
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    return PaywallKt.PaywallDialog$lambda$0$1(paywallViewModel, function02, str, (BoxScope) obj, ((Boolean) obj2).booleanValue(), (Function0) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composer, 54), composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0$0$0(Function0 function0, final String str) {
        NeboFirebaseEvent.PaywallModalDismissed.log(new Function1() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallKt.PaywallDialog$lambda$0$0$0$0(str, (Bundle) obj);
            }
        });
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0$0$0$0(String str, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        if (str != null) {
            log.putString("origin", str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0$1(PaywallViewModel paywallViewModel, Function0 function0, final String str, BoxScope AdaptiveModalDialog, boolean z, Function0 unused$var$, Composer composer, int i) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(AdaptiveModalDialog, "$this$AdaptiveModalDialog");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        ComposerKt.sourceInformation(composer, "C180@7663L169,185@7889L238,176@7450L691:Paywall.kt#txrdfj");
        if (!composer.shouldExecute((i & 1025) != 1024, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1270300504, i, -1, "com.myscript.nebo.purchase.PaywallDialog.<anonymous>.<anonymous> (Paywall.kt:176)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 988079969, "CC(remember):Paywall.kt#9igjgp");
            boolean zChanged = composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallKt.PaywallDialog$lambda$0$1$0$0(str);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function02 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 988087270, "CC(remember):Paywall.kt#9igjgp");
            boolean zChanged2 = composer.changed(str);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallKt.PaywallDialog$lambda$0$1$1$0(str, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PaywallScreen(paywallViewModel, null, SubscriptionRepository.FREEMIUM_PLACEMENT_ID, function0, function02, (Function1) objRememberedValue2, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0$1$0$0(final String str) {
        NeboFirebaseEvent.PaywallModalDisplay.log(new Function1() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallKt.PaywallDialog$lambda$0$1$0$0$0(str, (Bundle) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0$1$0$0$0(String str, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        if (str != null) {
            log.putString("origin", str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0$1$1$0(final String str, final String str2) {
        NeboFirebaseEvent.PurchaseConfirmation.log(new Function1() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallKt.PaywallDialog$lambda$0$1$1$0$0(str, str2, (Bundle) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallDialog$lambda$0$1$1$0$0(String str, String str2, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        if (str != null) {
            log.putString("origin", str);
        }
        if (str2 != null) {
            log.putString("type", str2);
        }
        return Unit.INSTANCE;
    }

    public static final void LoadingLayout(Composer composer, final int i) throws FileNotFoundException {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(847418075);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingLayout)198@8199L938:Paywall.kt#txrdfj");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847418075, i, -1, "com.myscript.nebo.purchase.LoadingLayout (Paywall.kt:197)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(48));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 823495104, "C204@8382L100,208@8517L168,214@8695L435:Paywall.kt#txrdfj");
            LottieCompositionResult lottieCompositionResultRememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.Asset.m12393boximpl(LottieCompositionSpec.Asset.m12394constructorimpl("paywall_loading.json")), null, null, null, null, null, composerStartRestartGroup, 6, 62);
            final LottieAnimationState lottieAnimationStateAnimateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(LoadingLayout$lambda$0$0(lottieCompositionResultRememberLottieComposition), true, false, false, null, 0.0f, Integer.MAX_VALUE, null, false, false, composerStartRestartGroup, 1572912, 956);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(32));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1850116989, "C221@9016L21,218@8831L221,224@9071L48,224@9066L54:Paywall.kt#txrdfj");
            float f = 320;
            Modifier modifierM2928sizeInqDBjuR0$default = SizeKt.m2928sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), 3, null);
            LottieComposition lottieCompositionLoadingLayout$lambda$0$0 = LoadingLayout$lambda$0$0(lottieCompositionResultRememberLottieComposition);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1325797780, "CC(remember):Paywall.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(lottieAnimationStateAnimateLottieCompositionAsState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(PaywallKt.LoadingLayout$lambda$0$1(lottieAnimationStateAnimateLottieCompositionAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LottieAnimationKt.LottieAnimation(lottieCompositionLoadingLayout$lambda$0$0, (Function0) objRememberedValue, modifierM2928sizeInqDBjuR0$default, false, false, false, false, null, false, null, null, null, false, false, null, null, false, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131064);
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.paywall_loading_message, composerStartRestartGroup, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 0, 0, 131070);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallKt.LoadingLayout$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final LottieComposition LoadingLayout$lambda$0$0(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LoadingLayout$lambda$0$1(LottieAnimationState lottieAnimationState) {
        return lottieAnimationState.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PaywallLayout(final Offering offering, final Function0<Unit> onCheckSubscription, final Function1<? super Continuation<? super Boolean>, ? extends Object> onPurchaseInitiated, final Function0<Unit> onNotifyFirebasePaywallDisplay, Modifier modifier, Map<String, ? extends CustomVariableValue> map, Composer composer, final int i, final int i2) {
        final Offering offering2;
        int i3;
        Modifier modifier2;
        int i4;
        Map<String, ? extends CustomVariableValue> mapEmptyMap;
        final Modifier modifier3;
        final Map<String, ? extends CustomVariableValue> map2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onCheckSubscription, "onCheckSubscription");
        Intrinsics.checkNotNullParameter(onPurchaseInitiated, "onPurchaseInitiated");
        Intrinsics.checkNotNullParameter(onNotifyFirebasePaywallDisplay, "onNotifyFirebasePaywallDisplay");
        Composer composerStartRestartGroup = composer.startRestartGroup(1369910902);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallLayout)N(offering,onCheckSubscription,onPurchaseInitiated,onNotifyFirebasePaywallDisplay,modifier,customVariables)240@9513L6,241@9535L1400,239@9440L1495:Paywall.kt#txrdfj");
        if ((i & 6) == 0) {
            offering2 = offering;
            i3 = (composerStartRestartGroup.changedInstance(offering2) ? 4 : 2) | i;
        } else {
            offering2 = offering;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCheckSubscription) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPurchaseInitiated) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNotifyFirebasePaywallDisplay) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    mapEmptyMap = map;
                    i3 |= composerStartRestartGroup.changedInstance(mapEmptyMap) ? 131072 : 65536;
                }
                if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    map2 = mapEmptyMap;
                } else {
                    Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1369910902, i3, -1, "com.myscript.nebo.purchase.PaywallLayout (Paywall.kt:238)");
                    }
                    final Map<String, ? extends CustomVariableValue> map3 = mapEmptyMap;
                    BoxWithConstraintsKt.BoxWithConstraints(BackgroundKt.m2016backgroundbw27NRU$default(modifier4, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4207getSurface0d7_KjU(), null, 2, null), null, false, ComposableLambdaKt.rememberComposableLambda(1953557088, true, new Function3() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PaywallKt.PaywallLayout$lambda$0(offering2, onCheckSubscription, onPurchaseInitiated, onNotifyFirebasePaywallDisplay, map3, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    map2 = map3;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PaywallKt.PaywallLayout$lambda$1(offering, onCheckSubscription, onPurchaseInitiated, onNotifyFirebasePaywallDisplay, modifier3, map2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            mapEmptyMap = map;
            if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        mapEmptyMap = map;
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallLayout$lambda$0(Offering offering, Function0 function0, Function1 function1, Function0 function02, Map map, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C263@10468L6,247@9831L1098:Paywall.kt#txrdfj");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1953557088, i2, -1, "com.myscript.nebo.purchase.PaywallLayout.<anonymous> (Paywall.kt:244)");
            }
            boolean z = C1486Dp.m11016compareTo0680j_4(BoxWithConstraints.mo2557getMaxWidthD9Ej5fM(), C1486Dp.m11017constructorimpl((float) 600)) < 0 || C1486Dp.m11016compareTo0680j_4(BoxWithConstraints.mo2556getMaxHeightD9Ej5fM(), C1486Dp.m11017constructorimpl((float) 500)) < 0;
            float f = 16;
            Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(BackgroundKt.m2016backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m2855paddingVpY3zN4(SizeKt.m2931widthInVpY3zN4$default(SizeKt.fillMaxHeight(BoxWithConstraints.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), z ? 1.0f : C1486Dp.m11016compareTo0680j_4(BoxWithConstraints.mo2557getMaxWidthD9Ej5fM(), BoxWithConstraints.mo2556getMaxHeightD9Ej5fM()) > 0 ? 0.85f : 0.55f), 0.0f, C1486Dp.m11017constructorimpl(550), 1, null), C1486Dp.m11017constructorimpl(z ? 12 : 48), C1486Dp.m11017constructorimpl(z ? 12 : 0)), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f))), MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4207getSurface0d7_KjU(), null, 2, null), 0.0f, z ? C1486Dp.m11017constructorimpl(24) : C1486Dp.m11017constructorimpl(f), 0.0f, 0.0f, 13, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2858paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1927004450, "C268@10653L2,266@10572L347:Paywall.kt#txrdfj");
            ComposerKt.sourceInformationMarkerStart(composer, -1170537844, "CC(remember):Paywall.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FetchedPaywall(offering, (Function0) objRememberedValue, function0, function1, function02, map, composer, 48, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FetchedPaywall(final Offering offering, final Function0<Unit> onDismiss, final Function0<Unit> onCheckSubscription, final Function1<? super Continuation<? super Boolean>, ? extends Object> onPurchaseInitiated, final Function0<Unit> onNotifyFirebasePaywallDisplay, Map<String, ? extends CustomVariableValue> map, Composer composer, final int i, final int i2) {
        int i3;
        Map<String, ? extends CustomVariableValue> map2;
        Map<String, ? extends CustomVariableValue> mapEmptyMap;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onCheckSubscription, "onCheckSubscription");
        Intrinsics.checkNotNullParameter(onPurchaseInitiated, "onPurchaseInitiated");
        Intrinsics.checkNotNullParameter(onNotifyFirebasePaywallDisplay, "onNotifyFirebasePaywallDisplay");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1412983664);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FetchedPaywall)N(offering,onDismiss,onCheckSubscription,onPurchaseInitiated,onNotifyFirebasePaywallDisplay,customVariables)287@11252L24,289@11303L48,289@11282L69,293@11357L744:Paywall.kt#txrdfj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(offering) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCheckSubscription) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPurchaseInitiated) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNotifyFirebasePaywallDisplay) ? 16384 : 8192;
        }
        int i4 = i2 & 32;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                map2 = map;
                i3 |= composerStartRestartGroup.changedInstance(map2) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                mapEmptyMap = map2;
            } else {
                mapEmptyMap = i4 != 0 ? MapsKt.emptyMap() : map2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1412983664, i3, -1, "com.myscript.nebo.purchase.FetchedPaywall (Paywall.kt:286)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -667624256, "CC(remember):Paywall.kt#9igjgp");
                boolean z = (i3 & 57344) == 16384;
                PaywallKt$FetchedPaywall$1$1 paywallKt$FetchedPaywall$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || paywallKt$FetchedPaywall$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    paywallKt$FetchedPaywall$1$1RememberedValue = new PaywallKt$FetchedPaywall$1$1(onNotifyFirebasePaywallDisplay, null);
                    composerStartRestartGroup.updateRememberedValue(paywallKt$FetchedPaywall$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) paywallKt$FetchedPaywall$1$1RememberedValue, composerStartRestartGroup, 6);
                com.revenuecat.purchases.p036ui.revenuecatui.PaywallKt.Paywall(new PaywallOptions.Builder(onDismiss).setOffering(offering).setCustomVariables(mapEmptyMap).setListener(new PaywallListener() { // from class: com.myscript.nebo.purchase.PaywallKt.FetchedPaywall.2
                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onPurchaseCancelled() {
                        super.onPurchaseCancelled();
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onPurchaseError(PurchasesError purchasesError) {
                        super.onPurchaseError(purchasesError);
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onPurchaseStarted(Package r1) {
                        super.onPurchaseStarted(r1);
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onRestoreCompleted(CustomerInfo customerInfo) {
                        super.onRestoreCompleted(customerInfo);
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onRestoreError(PurchasesError purchasesError) {
                        super.onRestoreError(purchasesError);
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onRestoreInitiated(Resumable resumable) {
                        super.onRestoreInitiated(resumable);
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onRestoreStarted() {
                        super.onRestoreStarted();
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onUrlOpened(String str) {
                        super.onUrlOpened(str);
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public /* bridge */ void onWebCheckoutOpened() {
                        super.onWebCheckoutOpened();
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                        onCheckSubscription.invoke();
                    }

                    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
                    public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                        Intrinsics.checkNotNullParameter(resume, "resume");
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PaywallKt$FetchedPaywall$2$onPurchasePackageInitiated$1(onPurchaseInitiated, resume, null), 3, null);
                    }
                }).build(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Map<String, ? extends CustomVariableValue> map3 = mapEmptyMap;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PaywallKt.FetchedPaywall$lambda$1(offering, onDismiss, onCheckSubscription, onPurchaseInitiated, onNotifyFirebasePaywallDisplay, map3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
        map2 = map;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final void PaywallTheme(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-288390541);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallTheme)N(content)316@12210L6,316@12236L21,316@12173L135:Paywall.kt#txrdfj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288390541, i2, -1, "com.myscript.nebo.purchase.PaywallTheme (Paywall.kt:315)");
            }
            Colors colors = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable);
            MaterialThemeKt.MaterialTheme(colors.m4195copypvPzIIM((8175 & 1) != 0 ? colors.m4203getPrimary0d7_KjU() : 0L, (8175 & 2) != 0 ? colors.m4204getPrimaryVariant0d7_KjU() : 0L, (8175 & 4) != 0 ? colors.m4205getSecondary0d7_KjU() : 0L, (8175 & 8) != 0 ? colors.m4206getSecondaryVariant0d7_KjU() : 0L, (8175 & 16) != 0 ? colors.m4196getBackground0d7_KjU() : 0L, (8175 & 32) != 0 ? colors.m4207getSurface0d7_KjU() : DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0) ? Color.INSTANCE.m8174getBlack0d7_KjU() : Color.INSTANCE.m8185getWhite0d7_KjU(), (8175 & 64) != 0 ? colors.m4197getError0d7_KjU() : 0L, (8175 & 128) != 0 ? colors.m4200getOnPrimary0d7_KjU() : 0L, (8175 & 256) != 0 ? colors.m4201getOnSecondary0d7_KjU() : 0L, (8175 & 512) != 0 ? colors.m4198getOnBackground0d7_KjU() : 0L, (8175 & 1024) != 0 ? colors.m4202getOnSurface0d7_KjU() : 0L, (8175 & 2048) != 0 ? colors.m4199getOnError0d7_KjU() : 0L, (8175 & 4096) != 0 ? colors.isLight() : false), null, null, content, composerStartRestartGroup, (i2 << 9) & 7168, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.purchase.PaywallKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallKt.PaywallTheme$lambda$0(content, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final PaywallViewModel.PaywallState PaywallScreen$lambda$3(State<PaywallViewModel.PaywallState> state) {
        return state.getValue();
    }

    private static final NeboNetworkState PaywallScreen$lambda$7(State<? extends NeboNetworkState> state) {
        return state.getValue();
    }
}
