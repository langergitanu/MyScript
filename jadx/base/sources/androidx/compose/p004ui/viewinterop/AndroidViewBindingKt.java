package androidx.compose.p004ui.viewinterop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.viewbinding.C1489R;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ViewKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidViewBinding.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001aÁ\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00182\u0006\u0010\u0019\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u001a\u001a\u001b\u0010\u001b\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001c\u001a$\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u0011H\u0002¨\u0006!"}, m1599d2 = {"AndroidViewBinding", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "factory", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "inflater", "Landroid/view/ViewGroup;", "parent", "", "attachToParent", "modifier", "Landroidx/compose/ui/Modifier;", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "onReset", "onRelease", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "setBinding", "Landroid/view/View;", "binding", "(Landroid/view/View;Landroidx/viewbinding/ViewBinding;)V", "getBinding", "(Landroid/view/View;)Landroidx/viewbinding/ViewBinding;", "forEachFragmentContainerView", "viewGroup", "action", "Landroidx/fragment/app/FragmentContainerView;", "ui-viewbinding"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidViewBindingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$1(Function3 function3, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        AndroidViewBinding(function3, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$9(Function3 function3, Modifier modifier, Function1 function1, Function1 function12, Function1 function13, int i, int i2, Composer composer, int i3) {
        AndroidViewBinding(function3, modifier, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$0$0(ViewBinding viewBinding) {
        return Unit.INSTANCE;
    }

    public static final <T extends ViewBinding> void AndroidViewBinding(final Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends T> function3, Modifier modifier, Function1<? super T, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final Function1<? super T, Unit> function12;
        Function1<? super T, Unit> function13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1985291610);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidViewBinding)N(factory,modifier,update)76@4010L2,78@4022L91:AndroidViewBinding.kt#z33iqn");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function12 = function1;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -899751576, "CC(remember):AndroidViewBinding.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$0$0((ViewBinding) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function13 = (Function1) objRememberedValue;
            } else {
                function13 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985291610, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:77)");
            }
            AndroidViewBinding(function3, modifier3, null, null, function13, composerStartRestartGroup, (i3 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | (i3 & 112) | (57344 & (i3 << 6)), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            function12 = function13;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidViewBindingKt.AndroidViewBinding$lambda$1(function3, modifier2, function12, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$2$0(ViewBinding viewBinding) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$3$0(ViewBinding viewBinding) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends ViewBinding> void AndroidViewBinding(final Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends T> function3, Modifier modifier, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12, Function1<? super T, Unit> function13, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Function1<? super T, Unit> function14;
        int i6;
        final Function1<? super T, Unit> function15;
        final Function1<? super T, Unit> function16;
        final Modifier modifier3;
        final Function1<? super T, Unit> function17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function1<? super T, Unit> function18;
        Composer composerStartRestartGroup = composer.startRestartGroup(509101952);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidViewBinding)N(factory,modifier,onReset,onRelease,update)146@8940L2,147@8971L2,149@9009L7,154@9284L254,163@9576L7,165@9619L383,174@10139L1062,194@11220L41,164@9588L1680:AndroidViewBinding.kt#z33iqn");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
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
                    i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function14 = function12;
                        i3 |= composerStartRestartGroup.changedInstance(function14) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 != 0) {
                        if ((i & 24576) == 0) {
                            function15 = function13;
                            i3 |= composerStartRestartGroup.changedInstance(function15) ? 16384 : 8192;
                        }
                        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function16 = function1;
                            modifier3 = modifier2;
                            function17 = function14;
                        } else {
                            Modifier modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            Function1 function19 = null;
                            final Function1<? super T, Unit> function110 = i4 != 0 ? null : function1;
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function18 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function18 = function14;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function15 = (Function1) objRememberedValue2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                            }
                            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localView);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            View view = (View) objConsume;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            boolean zChanged = composerStartRestartGroup.changed(view);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                try {
                                    objRememberedValue3 = ViewKt.findFragment(view);
                                } catch (IllegalStateException unused) {
                                    objRememberedValue3 = null;
                                }
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            final Fragment fragment = (Fragment) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContext);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Context context = (Context) objConsume2;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            boolean zChangedInstance = ((i3 & 14) == 4) | composerStartRestartGroup.changedInstance(fragment);
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            Function1 function111 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (function110 != null) {
                                composerStartRestartGroup.startReplaceGroup(1128074793);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                                boolean zChanged2 = composerStartRestartGroup.changed(function110);
                                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function110, (View) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function19 = (Function1) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1128074792);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            boolean zChangedInstance2 = ((i3 & 7168) == 2048) | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function18, fragment, context, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            Function1 function112 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            boolean z = (57344 & i3) == 16384;
                            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (z || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function15, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Function1<? super T, Unit> function113 = function18;
                            AndroidView_androidKt.AndroidView(function111, modifier4, function19, function112, (Function1) objRememberedValue7, composerStartRestartGroup, i3 & 112, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function17 = function113;
                            function16 = function110;
                            modifier3 = modifier4;
                        }
                        final Function1<? super T, Unit> function114 = function15;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function16, function17, function114, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 24576;
                    function15 = function13;
                    if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    }
                    final Function1 function1142 = function15;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function14 = function12;
                i6 = i2 & 16;
                if (i6 != 0) {
                }
                function15 = function13;
                if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                }
                final Function1 function11422 = function15;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function14 = function12;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            function15 = function13;
            if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            final Function1 function114222 = function15;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function14 = function12;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        function15 = function13;
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        final Function1 function1142222 = function15;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View AndroidViewBinding$lambda$5$0(Fragment fragment, Function3 function3, Context context) {
        LayoutInflater layoutInflaterFrom;
        if (fragment == null || (layoutInflaterFrom = fragment.getLayoutInflater()) == null) {
            layoutInflaterFrom = LayoutInflater.from(context);
        }
        ViewBinding viewBinding = (ViewBinding) function3.invoke(layoutInflaterFrom, new FrameLayout(context), false);
        View root = viewBinding.getRoot();
        setBinding(root, viewBinding);
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$6$0$0(Function1 function1, View view) {
        function1.invoke(getBinding(view));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$7$0(Function1 function1, Fragment fragment, Context context, View view) {
        FragmentManager childFragmentManager;
        function1.invoke(getBinding(view));
        final FragmentManager supportFragmentManager = null;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            if (fragment == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
                if (fragmentActivity != null) {
                    supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                }
            } else {
                supportFragmentManager = childFragmentManager;
            }
            forEachFragmentContainerView(viewGroup, new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0$0$0(supportFragmentManager, (FragmentContainerView) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$7$0$0$0(FragmentManager fragmentManager, FragmentContainerView fragmentContainerView) {
        Fragment fragmentFindFragmentById = fragmentManager != null ? fragmentManager.findFragmentById(fragmentContainerView.getId()) : null;
        if (fragmentFindFragmentById != null && !fragmentManager.isStateSaved()) {
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
            fragmentTransactionBeginTransaction.commitNow();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$8$0(Function1 function1, View view) {
        function1.invoke(getBinding(view));
        return Unit.INSTANCE;
    }

    private static final <T extends ViewBinding> void setBinding(View view, T t) {
        view.setTag(C1489R.id.binding_reference, t);
    }

    private static final <T extends ViewBinding> T getBinding(View view) {
        Object tag = view.getTag(C1489R.id.binding_reference);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type T of androidx.compose.ui.viewinterop.AndroidViewBindingKt.getBinding");
        return (T) tag;
    }

    private static final void forEachFragmentContainerView(ViewGroup viewGroup, Function1<? super FragmentContainerView, Unit> function1) {
        if (viewGroup instanceof FragmentContainerView) {
            function1.invoke(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            if (childAt instanceof ViewGroup) {
                forEachFragmentContainerView((ViewGroup) childAt, function1);
            }
        }
    }
}
