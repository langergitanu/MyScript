package com.myscript.nebo.p034ui.compose;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AndroidAlertDialog_androidKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.p004ui.window.AndroidDialog_androidKt;
import androidx.compose.p004ui.window.DialogProperties;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.window.core.layout.WindowSizeClass;
import com.myscript.android.utils.C6014R;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: NativeSignInDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aA\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a\u008e\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f21\u0010\u0010\u001a-\b\u0001\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a9\u0010\u001b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003¢\u0006\u0002\u0010\u001e¨\u0006\u001f²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\f\u0010!\u001a\u0004\u0018\u00010\"X\u008a\u008e\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u008a\u008e\u0002"}, m1599d2 = {"NativeSignInDialogContent", "", "onGoogleSignIn", "Lkotlin/Function0;", "onOtherSignIn", "onDismiss", "showProgress", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "NativeSignInDialog", "show", "onClose", "googleSignInHelper", "Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper;", "googleServerClientId", "", "startNativeLogin", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "googleIdToken", "Lkotlin/coroutines/Continuation;", "", "isOnline", "onLoginCanceled", "onWebViewLogin", "(ZLkotlin/jvm/functions/Function0;Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NoInternetDialog", "onCancel", "onTryAgain", "(ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_standardRelease", "showNoInternet", "pendingAction", "Lcom/myscript/nebo/ui/compose/PendingSignInAction;", "signInJob", "Lkotlinx/coroutines/Job;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NativeSignInDialogKt {

    /* JADX INFO: compiled from: NativeSignInDialog.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PendingSignInAction.values().length];
            try {
                iArr[PendingSignInAction.Google.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PendingSignInAction.Other.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialog$lambda$20(boolean z, Function0 function0, GoogleSignInHelper googleSignInHelper, String str, Function2 function2, boolean z2, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        NativeSignInDialog(z, function0, googleSignInHelper, str, function2, z2, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialogContent$lambda$1(Function0 function0, Function0 function02, Function0 function03, boolean z, int i, int i2, Composer composer, int i3) {
        NativeSignInDialogContent(function0, function02, function03, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoInternetDialog$lambda$0(boolean z, boolean z2, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NoInternetDialog(z, z2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoInternetDialog$lambda$3(boolean z, boolean z2, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NoInternetDialog(z, z2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void NativeSignInDialogContent(final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1377605781);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NativeSignInDialogContent)N(onGoogleSignIn,onOtherSignIn,onDismiss,showProgress)68@2779L5510,65@2655L5634:NativeSignInDialog.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function03) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z2;
            } else {
                final boolean z4 = i4 == 0 ? z2 : false;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1377605781, i3, -1, "com.myscript.nebo.ui.compose.NativeSignInDialogContent (NativeSignInDialog.kt:64)");
                }
                AndroidDialog_androidKt.Dialog(function03, new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-617838348, true, new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NativeSignInDialogKt.NativeSignInDialogContent$lambda$0(function03, z4, function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 432, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NativeSignInDialogKt.NativeSignInDialogContent$lambda$1(function0, function02, function03, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        z2 = z;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialogContent$lambda$0(final Function0 function0, final boolean z, final Function0 function02, final Function0 function03, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C75@2999L5284,69@2789L5494:NativeSignInDialog.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617838348, i, -1, "com.myscript.nebo.ui.compose.NativeSignInDialogContent.<anonymous> (NativeSignInDialog.kt:69)");
            }
            CardKt.m4173CardFjzlyU(PaddingKt.m2856paddingVpY3zN4$default(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND), 1, null), C1486Dp.m11017constructorimpl(32), 0.0f, 2, null), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16)), 0L, 0L, null, C1486Dp.m11017constructorimpl(8), ComposableLambdaKt.rememberComposableLambda(-1361157967, true, new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NativeSignInDialogKt.NativeSignInDialogContent$lambda$0$0(function0, z, function02, function03, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1769478, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialogContent$lambda$0$0(Function0 function0, final boolean z, Function0 function02, Function0 function03, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C76@3013L5260:NativeSignInDialog.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1361157967, i, -1, "com.myscript.nebo.ui.compose.NativeSignInDialogContent.<anonymous>.<anonymous> (NativeSignInDialog.kt:76)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1269447597, "C78@3203L6,80@3270L41,82@3401L6,90@3760L40,79@3234L661,95@3913L4346:NativeSignInDialog.kt#h09ego");
            final long jM4207getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4207getSurface0d7_KjU();
            Painter painterPainterResource = PainterResources_androidKt.painterResource(C6014R.drawable.ic_close, composer, 0);
            long jM4202getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU();
            float f = 16;
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(ClickableKt.m2062clickableoSLSa3U$default(ClipKt.clip(PaddingKt.m2854padding3ABfNKs(AlphaKt.alpha(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), 0.66f), C1486Dp.m11017constructorimpl(8)), RoundedCornerShapeKt.getCircleShape()), false, null, null, null, function0, 15, null), C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, -1564956621, "CC(remember):NativeSignInDialog.kt#9igjgp");
            boolean zChanged = composer.changed(jM4207getSurface0d7_KjU);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NativeSignInDialogKt.NativeSignInDialogContent$lambda$0$0$0$0$0(jM4207getSurface0d7_KjU, (DrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f2 = 20;
            IconKt.m4300Iconww6aTOc(painterPainterResource, (String) null, PaddingKt.m2854padding3ABfNKs(SizeKt.m2924size3ABfNKs(DrawModifierKt.drawBehind(modifierM2854padding3ABfNKs, (Function1) objRememberedValue), C1486Dp.m11017constructorimpl(f2)), C1486Dp.m11017constructorimpl(2)), jM4202getOnSurface0d7_KjU, composer, Painter.$stable | 48, 0);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            float f3 = 24;
            float f4 = 48;
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(f3), C1486Dp.m11017constructorimpl(f4));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM2855paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1117373995, "C103@4275L51,104@4370L10,102@4242L390,112@4650L3595:NativeSignInDialog.kt#h09ego");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.sign_in_dialog_title, composer, 0), PaddingKt.m2858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(f2), 7, null), 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getH5(), composer, 196656, 0, 64988);
            Arrangement.Vertical verticalM2534spacedByD5KLDUw = Arrangement.Absolute.INSTANCE.m2534spacedByD5KLDUw(C1486Dp.m11017constructorimpl(36), Alignment.INSTANCE.getCenterVertically());
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM2534spacedByD5KLDUw, centerHorizontally2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1968862895, "C118@4949L54,119@5051L10,120@5115L6,117@4912L461,129@5554L6,130@5645L6,135@5896L282,141@6231L142,148@6536L1166,131@5682L2020:NativeSignInDialog.kt#h09ego");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.sign_in_dialog_subtitle, composer, 0), PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(f), 0.0f, 2, null), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBody2(), composer, 48, 0, 65016);
            long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
            final long jM4202getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU();
            RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f3));
            ButtonColors buttonColorsM4162buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(jM8147copywmQWz5c$default, jM4202getOnSurface0d7_KjU2, jM8147copywmQWz5c$default, jM4202getOnSurface0d7_KjU2, composer, ButtonDefaults.$stable << 12, 0);
            float f5 = 0;
            ButtonKt.Button(function02, SizeKt.m2912heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(f4), 0.0f, 2, null), !z, null, ButtonDefaults.INSTANCE.m4163elevationR_JCAzs(C1486Dp.m11017constructorimpl(f5), C1486Dp.m11017constructorimpl(f5), 0.0f, 0.0f, 0.0f, composer, (ButtonDefaults.$stable << 15) | 54, 28), roundedCornerShapeM3235RoundedCornerShape0680j_4, null, buttonColorsM4162buttonColorsro_MJ88, null, ComposableLambdaKt.rememberComposableLambda(-448929009, true, new Function3() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NativeSignInDialogKt.NativeSignInDialogContent$lambda$0$0$0$1$0$0(z, jM4202getOnSurface0d7_KjU2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306416, 328);
            Composer composer2 = composer;
            if (!z) {
                composer2.startReplaceGroup(-1966073795);
                ComposerKt.sourceInformation(composer2, "176@7856L58,178@8012L10,179@8080L6,175@7815L390");
                TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.sign_in_dialog_other_method, composer2, 0), ClickableKt.m2062clickableoSLSa3U$default(Modifier.INSTANCE, false, null, null, null, function03, 15, null), MaterialTheme.INSTANCE.getColors(composer2, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), TextUnitKt.getSp(17), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBody2(), composer, 3072, 0, 65520);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1965677181);
                composer2.endReplaceGroup();
            }
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialogContent$lambda$0$0$0$0$0(long j, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m8710drawCircleVaOC9Bg$default(drawBehind, j, 0.0f, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialogContent$lambda$0$0$0$1$0$0(boolean z, long j, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C149@6562L1118:NativeSignInDialog.kt#h09ego");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-448929009, i, -1, "com.myscript.nebo.ui.compose.NativeSignInDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NativeSignInDialog.kt:149)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal horizontalM2533spacedByD5KLDUw = Arrangement.Absolute.INSTANCE.m2533spacedByD5KLDUw(C1486Dp.m11017constructorimpl(12), Alignment.INSTANCE.getCenterHorizontally());
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM2533spacedByD5KLDUw, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1681848216, "C167@7528L45,166@7483L171:NativeSignInDialog.kt#h09ego");
            if (z) {
                composer.startReplaceGroup(1681880796);
                ComposerKt.sourceInformation(composer, "154@6850L243");
                ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(20)), j, C1486Dp.m11017constructorimpl(2), 0L, 0, composer, 390, 24);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1682160106);
                ComposerKt.sourceInformation(composer, "161@7216L42,160@7163L261");
                ImageKt.Image(PainterResources_androidKt.painterResource(C6079R.drawable.ic_google_logo, composer, 0), (String) null, SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(20)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 432, 120);
                composer.endReplaceGroup();
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.google_sign_in, composer, 0), (Modifier) null, 0L, TextUnitKt.getSp(17), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3072, 0, 131062);
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

    public static final void NativeSignInDialog(final boolean z, final Function0<Unit> onClose, final GoogleSignInHelper googleSignInHelper, final String googleServerClientId, final Function2<? super String, ? super Continuation<? super Boolean>, ? extends Object> startNativeLogin, final boolean z2, Function0<Unit> function0, Function0<Unit> function02, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function03;
        Function0<Unit> function04;
        Composer composer2;
        final Function0<Unit> function05;
        Function0<Unit> function06;
        Function0<Unit> function07;
        Function0<Unit> function08;
        MutableState mutableState;
        int i4;
        String str;
        Function0<Unit> function09;
        Function0<Unit> function010;
        final MutableState mutableState2;
        int i5;
        int i6;
        GoogleSignInHelper googleSignInHelper2;
        MutableState mutableState3;
        CoroutineScope coroutineScope;
        Context context;
        final MutableState mutableState4;
        Composer composer3;
        final Context context2;
        Object obj;
        int i7;
        final Function0<Unit> function011;
        final MutableState mutableState5;
        int i8;
        Function0<Unit> function012;
        final MutableState mutableState6;
        final MutableState mutableState7;
        int i9;
        int i10;
        Composer composer4;
        int i11;
        final CoroutineScope coroutineScope2;
        final MutableState mutableState8;
        Object obj2;
        int i12;
        final Function0<Unit> function013;
        final MutableState mutableState9;
        MutableState mutableState10;
        MutableState mutableState11;
        final Function0<Unit> function014;
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(googleSignInHelper, "googleSignInHelper");
        Intrinsics.checkNotNullParameter(googleServerClientId, "googleServerClientId");
        Intrinsics.checkNotNullParameter(startNativeLogin, "startNativeLogin");
        Composer composerStartRestartGroup = composer.startRestartGroup(-43547585);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NativeSignInDialog)N(show,onClose,googleSignInHelper,googleServerClientId,startNativeLogin,isOnline,onLoginCanceled,onWebViewLogin)206@9015L2,207@9052L2,209@9091L7,210@9124L24,211@9173L34,212@9234L34,213@9294L55,214@9371L39,217@9490L34,217@9469L55,264@10965L79,268@11067L168,261@10868L374:NativeSignInDialog.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(googleSignInHelper) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(googleServerClientId) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(startNativeLogin) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
        }
        int i13 = i2 & 64;
        if (i13 != 0) {
            i3 |= 1572864;
            function03 = function0;
        } else {
            function03 = function0;
            if ((i & 1572864) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function03) ? 1048576 : 524288;
            }
        }
        int i14 = i2 & 128;
        if (i14 != 0) {
            i3 |= 12582912;
            function04 = function02;
        } else {
            function04 = function02;
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
            }
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function05 = function04;
        } else {
            if (i13 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100452385, "CC(remember):NativeSignInDialog.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function06 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function06 = function03;
            }
            if (i14 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100453569, "CC(remember):NativeSignInDialog.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function07 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function07 = function04;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-43547585, i3, -1, "com.myscript.nebo.ui.compose.NativeSignInDialog (NativeSignInDialog.kt:208)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context3 = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100457473, "CC(remember):NativeSignInDialog.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue4 = mutableStateMutableStateOf$default;
            }
            MutableState mutableState12 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100459425, "CC(remember):NativeSignInDialog.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                function08 = function06;
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                function08 = function06;
            }
            MutableState mutableState13 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100461366, "CC(remember):NativeSignInDialog.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState13;
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                mutableState = mutableState13;
            }
            MutableState mutableState14 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100463814, "CC(remember):NativeSignInDialog.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                objRememberedValue7 = mutableStateMutableStateOf$default2;
            }
            MutableState mutableState15 = (MutableState) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Boolean boolValueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100467617, "CC(remember):NativeSignInDialog.kt#9igjgp");
            int i15 = i3 & 14;
            MutableState mutableState16 = mutableState15;
            boolean z3 = i15 == 4;
            NativeSignInDialogKt$NativeSignInDialog$3$1 nativeSignInDialogKt$NativeSignInDialog$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || nativeSignInDialogKt$NativeSignInDialog$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                nativeSignInDialogKt$NativeSignInDialog$3$1RememberedValue = new NativeSignInDialogKt$NativeSignInDialog$3$1(z, mutableState12, null);
                composerStartRestartGroup.updateRememberedValue(nativeSignInDialogKt$NativeSignInDialog$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) nativeSignInDialogKt$NativeSignInDialog$3$1RememberedValue, composerStartRestartGroup, i15);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-244239761);
                ComposerKt.sourceInformation(composerStartRestartGroup, "250@10556L41,251@10627L40,252@10693L111,249@10500L356");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100501736, "CC(remember):NativeSignInDialog.kt#9igjgp");
                int i16 = i3 & 458752;
                i5 = 29360128;
                int i17 = i3 & 7168;
                int i18 = i3 & 112;
                int i19 = i3 & 29360128;
                boolean zChangedInstance = (i16 == 131072) | composerStartRestartGroup.changedInstance(coroutineScope3) | composerStartRestartGroup.changedInstance(googleSignInHelper) | composerStartRestartGroup.changedInstance(context3) | (i17 == 2048) | composerStartRestartGroup.changedInstance(startNativeLogin) | (i18 == 32) | (i19 == 8388608);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    context2 = context3;
                    i7 = i3;
                    function011 = function07;
                    mutableState5 = mutableState12;
                    i8 = i19;
                    function012 = function08;
                    mutableState6 = mutableState16;
                    mutableState7 = mutableState;
                    i9 = i17;
                    i10 = i18;
                    composer4 = composerStartRestartGroup;
                    i11 = i16;
                    str = "CC(remember):NativeSignInDialog.kt#9igjgp";
                    coroutineScope2 = coroutineScope3;
                    mutableState8 = mutableState14;
                    obj = new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NativeSignInDialogKt.NativeSignInDialog$lambda$15$0(z2, onClose, function011, coroutineScope2, mutableState6, googleSignInHelper, context2, googleServerClientId, mutableState5, startNativeLogin, mutableState8, mutableState7);
                        }
                    };
                    composer4.updateRememberedValue(obj);
                } else {
                    context2 = context3;
                    i7 = i3;
                    obj = objRememberedValue8;
                    function011 = function07;
                    mutableState5 = mutableState12;
                    i8 = i19;
                    function012 = function08;
                    mutableState6 = mutableState16;
                    mutableState7 = mutableState;
                    i9 = i17;
                    i10 = i18;
                    composer4 = composerStartRestartGroup;
                    i11 = i16;
                    str = "CC(remember):NativeSignInDialog.kt#9igjgp";
                    coroutineScope2 = coroutineScope3;
                    mutableState8 = mutableState14;
                }
                Function0 function015 = (Function0) obj;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerStart(composer4, 1100504007, str);
                int i20 = i10;
                boolean zChangedInstance2 = (i11 == 131072) | composer4.changedInstance(coroutineScope2) | composer4.changedInstance(googleSignInHelper) | composer4.changedInstance(context2) | (i9 == 2048) | composer4.changedInstance(startNativeLogin) | (i20 == 32) | (i8 == 8388608);
                Object objRememberedValue9 = composer4.rememberedValue();
                if (zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    i12 = i20;
                    obj2 = new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NativeSignInDialogKt.NativeSignInDialog$lambda$16$0(z2, onClose, function011, coroutineScope2, mutableState6, googleSignInHelper, context2, googleServerClientId, mutableState5, startNativeLogin, mutableState8, mutableState7);
                        }
                    };
                    function013 = onClose;
                    function09 = function011;
                    mutableState9 = mutableState6;
                    mutableState3 = mutableState5;
                    mutableState10 = mutableState8;
                    mutableState11 = mutableState7;
                    coroutineScope = coroutineScope2;
                    googleSignInHelper2 = googleSignInHelper;
                    context = context2;
                    composer4.updateRememberedValue(obj2);
                } else {
                    function013 = onClose;
                    i12 = i20;
                    obj2 = objRememberedValue9;
                    function09 = function011;
                    mutableState9 = mutableState6;
                    mutableState3 = mutableState5;
                    mutableState10 = mutableState8;
                    mutableState11 = mutableState7;
                    coroutineScope = coroutineScope2;
                    googleSignInHelper2 = googleSignInHelper;
                    context = context2;
                }
                Function0 function016 = (Function0) obj2;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerStart(composer4, 1100506190, str);
                boolean z4 = (i12 == 32) | ((i7 & 3670016) == 1048576);
                Object objRememberedValue10 = composer4.rememberedValue();
                if (z4 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    function014 = function012;
                    objRememberedValue10 = new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NativeSignInDialogKt.NativeSignInDialog$lambda$17$0(function013, function014, mutableState9);
                        }
                    };
                    composer4.updateRememberedValue(objRememberedValue10);
                } else {
                    function014 = function012;
                }
                ComposerKt.sourceInformationMarkerEnd(composer4);
                function010 = function014;
                mutableState16 = mutableState9;
                i6 = 32;
                Composer composer5 = composer4;
                mutableState2 = mutableState10;
                i4 = i7;
                mutableState4 = mutableState11;
                NativeSignInDialogContent(function015, function016, (Function0) objRememberedValue10, NativeSignInDialog$lambda$3(mutableState3), composer5, 0, 0);
                composerStartRestartGroup = composer5;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i4 = i3;
                str = "CC(remember):NativeSignInDialog.kt#9igjgp";
                function09 = function07;
                function010 = function08;
                mutableState2 = mutableState14;
                i5 = 29360128;
                i6 = 32;
                googleSignInHelper2 = googleSignInHelper;
                mutableState3 = mutableState12;
                coroutineScope = coroutineScope3;
                context = context3;
                mutableState4 = mutableState;
                composerStartRestartGroup.startReplaceGroup(-243882269);
                composerStartRestartGroup.endReplaceGroup();
            }
            boolean zNativeSignInDialog$lambda$6 = NativeSignInDialog$lambda$6(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100514862, str);
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NativeSignInDialogKt.NativeSignInDialog$lambda$18$0(mutableState4, mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            Function0 function017 = (Function0) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1100518215, str);
            boolean zChangedInstance3 = ((i4 & 458752) == 131072) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(googleSignInHelper2) | composerStartRestartGroup.changedInstance(context) | ((i4 & 7168) == 2048) | composerStartRestartGroup.changedInstance(startNativeLogin) | ((i4 & 112) == i6) | ((i4 & i5) == 8388608);
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                final MutableState mutableState17 = mutableState4;
                composer3 = composerStartRestartGroup;
                final MutableState mutableState18 = mutableState2;
                final GoogleSignInHelper googleSignInHelper3 = googleSignInHelper2;
                final Context context4 = context;
                final CoroutineScope coroutineScope4 = coroutineScope;
                final MutableState mutableState19 = mutableState3;
                final Function0<Unit> function018 = function09;
                final MutableState mutableState20 = mutableState16;
                Function0 function019 = new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NativeSignInDialogKt.NativeSignInDialog$lambda$19$0(mutableState17, mutableState18, z2, onClose, function018, coroutineScope4, mutableState20, googleSignInHelper3, context4, googleServerClientId, mutableState19, startNativeLogin);
                    }
                };
                composer3.updateRememberedValue(function019);
                objRememberedValue12 = function019;
            } else {
                composer3 = composerStartRestartGroup;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer2 = composer3;
            NoInternetDialog(zNativeSignInDialog$lambda$6, z2, function017, (Function0) objRememberedValue12, composer2, ((i4 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function05 = function09;
            function03 = function010;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function020 = function03;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return NativeSignInDialogKt.NativeSignInDialog$lambda$20(z, onClose, googleSignInHelper, googleServerClientId, startNativeLogin, z2, function020, function05, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final boolean NativeSignInDialog$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NativeSignInDialog$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean NativeSignInDialog$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void NativeSignInDialog$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final PendingSignInAction NativeSignInDialog$lambda$9(MutableState<PendingSignInAction> mutableState) {
        return mutableState.getValue();
    }

    private static final Job NativeSignInDialog$lambda$12(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    private static final void NativeSignInDialog$launchGoogleSignIn(CoroutineScope coroutineScope, MutableState<Job> mutableState, GoogleSignInHelper googleSignInHelper, Context context, String str, MutableState<Boolean> mutableState2, Function2<? super String, ? super Continuation<? super Boolean>, ? extends Object> function2, Function0<Unit> function0) {
        Job jobNativeSignInDialog$lambda$12 = NativeSignInDialog$lambda$12(mutableState);
        if (jobNativeSignInDialog$lambda$12 != null) {
            Job.DefaultImpls.cancel$default(jobNativeSignInDialog$lambda$12, (CancellationException) null, 1, (Object) null);
        }
        mutableState.setValue(BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1(googleSignInHelper, context, str, mutableState2, function2, function0, null), 3, null));
    }

    private static final void NativeSignInDialog$tryAction(boolean z, Function0<Unit> function0, Function0<Unit> function02, CoroutineScope coroutineScope, MutableState<Job> mutableState, GoogleSignInHelper googleSignInHelper, Context context, String str, MutableState<Boolean> mutableState2, Function2<? super String, ? super Continuation<? super Boolean>, ? extends Object> function2, MutableState<PendingSignInAction> mutableState3, MutableState<Boolean> mutableState4, PendingSignInAction pendingSignInAction) {
        if (z) {
            int i = WhenMappings.$EnumSwitchMapping$0[pendingSignInAction.ordinal()];
            if (i == 1) {
                NativeSignInDialog$launchGoogleSignIn(coroutineScope, mutableState, googleSignInHelper, context, str, mutableState2, function2, function0);
                return;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                function0.invoke();
                function02.invoke();
                return;
            }
        }
        mutableState3.setValue(pendingSignInAction);
        NativeSignInDialog$lambda$7(mutableState4, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialog$lambda$15$0(boolean z, Function0 function0, Function0 function02, CoroutineScope coroutineScope, MutableState mutableState, GoogleSignInHelper googleSignInHelper, Context context, String str, MutableState mutableState2, Function2 function2, MutableState mutableState3, MutableState mutableState4) {
        NativeSignInDialog$tryAction(z, function0, function02, coroutineScope, mutableState, googleSignInHelper, context, str, mutableState2, function2, mutableState3, mutableState4, PendingSignInAction.Google);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialog$lambda$16$0(boolean z, Function0 function0, Function0 function02, CoroutineScope coroutineScope, MutableState mutableState, GoogleSignInHelper googleSignInHelper, Context context, String str, MutableState mutableState2, Function2 function2, MutableState mutableState3, MutableState mutableState4) {
        NativeSignInDialog$tryAction(z, function0, function02, coroutineScope, mutableState, googleSignInHelper, context, str, mutableState2, function2, mutableState3, mutableState4, PendingSignInAction.Other);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialog$lambda$17$0(Function0 function0, Function0 function02, MutableState mutableState) {
        Job jobNativeSignInDialog$lambda$12 = NativeSignInDialog$lambda$12(mutableState);
        if (jobNativeSignInDialog$lambda$12 != null) {
            Job.DefaultImpls.cancel$default(jobNativeSignInDialog$lambda$12, (CancellationException) null, 1, (Object) null);
        }
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialog$lambda$18$0(MutableState mutableState, MutableState mutableState2) {
        NativeSignInDialog$lambda$7(mutableState, false);
        mutableState2.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeSignInDialog$lambda$19$0(MutableState mutableState, MutableState mutableState2, boolean z, Function0 function0, Function0 function02, CoroutineScope coroutineScope, MutableState mutableState3, GoogleSignInHelper googleSignInHelper, Context context, String str, MutableState mutableState4, Function2 function2) {
        NativeSignInDialog$lambda$7(mutableState, false);
        PendingSignInAction pendingSignInActionNativeSignInDialog$lambda$9 = NativeSignInDialog$lambda$9(mutableState2);
        mutableState2.setValue(null);
        if (pendingSignInActionNativeSignInDialog$lambda$9 != null) {
            NativeSignInDialog$tryAction(z, function0, function02, coroutineScope, mutableState3, googleSignInHelper, context, str, mutableState4, function2, mutableState2, mutableState, pendingSignInActionNativeSignInDialog$lambda$9);
        }
        return Unit.INSTANCE;
    }

    private static final void NoInternetDialog(final boolean z, final boolean z2, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1443675891);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoInternetDialog)N(show,isOnline,onCancel,onTryAgain)295@11824L175,290@11648L150,286@11415L591:NativeSignInDialog.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1443675891, i2, -1, "com.myscript.nebo.ui.compose.NoInternetDialog (NativeSignInDialog.kt:283)");
            }
            if (!z) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    function2 = new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NativeSignInDialogKt.NoInternetDialog$lambda$0(z, z2, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                return;
            }
            z3 = z2;
            AndroidAlertDialog_androidKt.m4102AlertDialog6oU6zVQ(function0, ComposableLambdaKt.rememberComposableLambda(1869632965, true, new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NativeSignInDialogKt.NoInternetDialog$lambda$1(function02, z3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-2014723965, true, new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NativeSignInDialogKt.NoInternetDialog$lambda$2(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableSingletons$NativeSignInDialogKt.INSTANCE.getLambda$338064866$app_standardRelease(), ComposableSingletons$NativeSignInDialogKt.INSTANCE.m13443getLambda$1604113599$app_standardRelease(), null, 0L, 0L, null, composerStartRestartGroup, ((i2 >> 6) & 14) | 224304, 964);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z3 = z2;
            composerStartRestartGroup.skipToGroupEnd();
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z4 = z3;
            function2 = new Function2() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NativeSignInDialogKt.NoInternetDialog$lambda$3(z, z4, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoInternetDialog$lambda$2(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C291@11662L126:NativeSignInDialog.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2014723965, i, -1, "com.myscript.nebo.ui.compose.NoInternetDialog.<anonymous> (NativeSignInDialog.kt:291)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$NativeSignInDialogKt.INSTANCE.getLambda$1376509158$app_standardRelease(), composer, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoInternetDialog$lambda$1(Function0 function0, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C296@11838L151:NativeSignInDialog.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1869632965, i, -1, "com.myscript.nebo.ui.compose.NoInternetDialog.<anonymous> (NativeSignInDialog.kt:296)");
            }
            ButtonKt.TextButton(function0, null, z, null, null, null, null, null, null, ComposableSingletons$NativeSignInDialogKt.INSTANCE.getLambda$965898792$app_standardRelease(), composer, 805306368, TypedValues.PositionType.TYPE_PERCENT_X);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
