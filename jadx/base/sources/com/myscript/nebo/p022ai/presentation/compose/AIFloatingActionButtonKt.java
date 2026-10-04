package com.myscript.nebo.p022ai.presentation.compose;

import android.graphics.Rect;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.presentation.compose.components.AIDropdownMenuKt;
import com.myscript.nebo.p022ai.presentation.compose.components.AIDropdownOption;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.internal.p041ws.WebSocketProtocol;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AIFloatingActionButton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"AIFloatingActionButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "isLoading", "", "mode", "Lcom/myscript/nebo/ai/presentation/compose/AIMode;", "lastActiveMode", "showMenu", "dismissMenuRequest", "Lkotlin/Function0;", "onFabClick", "onMenuItemClick", "Lkotlin/Function1;", "Lcom/myscript/nebo/ai/presentation/compose/components/AIDropdownOption;", "actionsAvailability", "Lcom/myscript/nebo/ai/presentation/compose/ActionsAvailability;", "onAIButtonPositionChanged", "Landroid/graphics/Rect;", "(Landroidx/compose/ui/Modifier;ZLcom/myscript/nebo/ai/presentation/compose/AIMode;Lcom/myscript/nebo/ai/presentation/compose/AIMode;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/myscript/nebo/ai/presentation/compose/ActionsAvailability;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "nebo-ai_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIFloatingActionButtonKt {

    /* JADX INFO: compiled from: AIFloatingActionButton.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AIMode.values().length];
            try {
                iArr[AIMode.SUMMARIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIMode.EXPLAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AIMode.QUIZ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AIMode.MINIMIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIFloatingActionButton$lambda$1(Modifier modifier, boolean z, AIMode aIMode, AIMode aIMode2, boolean z2, Function0 function0, Function0 function02, Function1 function1, ActionsAvailability actionsAvailability, Function1 function12, int i, int i2, Composer composer, int i3) {
        AIFloatingActionButton(modifier, z, aIMode, aIMode2, z2, function0, function02, function1, actionsAvailability, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AIFloatingActionButton(Modifier modifier, final boolean z, final AIMode mode, final AIMode lastActiveMode, final boolean z2, final Function0<Unit> dismissMenuRequest, final Function0<Unit> onFabClick, final Function1<? super AIDropdownOption, Unit> onMenuItemClick, final ActionsAvailability actionsAvailability, final Function1<? super Rect, Unit> onAIButtonPositionChanged, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        int i4;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lastActiveMode, "lastActiveMode");
        Intrinsics.checkNotNullParameter(dismissMenuRequest, "dismissMenuRequest");
        Intrinsics.checkNotNullParameter(onFabClick, "onFabClick");
        Intrinsics.checkNotNullParameter(onMenuItemClick, "onMenuItemClick");
        Intrinsics.checkNotNullParameter(actionsAvailability, "actionsAvailability");
        Intrinsics.checkNotNullParameter(onAIButtonPositionChanged, "onAIButtonPositionChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1577088849);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIFloatingActionButton)N(modifier,isLoading,mode,lastActiveMode,showMenu,dismissMenuRequest,onFabClick,onMenuItemClick,actionsAvailability,onAIButtonPositionChanged)44@1685L2515:AIFloatingActionButton.kt#ez9f2c");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(mode.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(lastActiveMode.ordinal()) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(dismissMenuRequest) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onFabClick) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onMenuItemClick) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(actionsAvailability) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onAIButtonPositionChanged) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1577088849, i3, -1, "com.myscript.nebo.ai.presentation.compose.AIFloatingActionButton (AIFloatingActionButton.kt:43)");
            }
            Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.m2924size3ABfNKs(PaddingKt.m2854padding3ABfNKs(companion, C1486Dp.m11017constructorimpl(16)), C1486Dp.m11017constructorimpl(56)), Brush.Companion.m8097linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m8138boximpl(ColorKt.Color$default(0.0f, 0.58f, 1.0f, 0.0f, null, 24, null)), Color.m8138boximpl(ColorKt.Color$default(0.75f, 0.04f, 1.0f, 0.0f, null, 24, null))}), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape(), 0.0f, 4, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -164356575, "C92@3984L210:AIFloatingActionButton.kt#ez9f2c");
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-164404750);
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@1938L227");
                composer2 = composerStartRestartGroup;
                ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(SizeKt.m2924size3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), C1486Dp.m11017constructorimpl(32)), Color.INSTANCE.m8185getWhite0d7_KjU(), C1486Dp.m11017constructorimpl(2), 0L, 0, composer2, 432, 24);
                composerStartRestartGroup.endReplaceGroup();
                modifier3 = companion;
                i4 = i3;
            } else {
                composerStartRestartGroup.startReplaceGroup(-164102004);
                ComposerKt.sourceInformation(composerStartRestartGroup, "61@2316L451,71@2782L1182,59@2195L1769");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -975121960, "CC(remember):AIFloatingActionButton.kt#9igjgp");
                boolean z3 = (1879048192 & i3) == 536870912;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIFloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AIFloatingActionButtonKt.AIFloatingActionButton$lambda$0$0$0(onAIButtonPositionChanged, (LayoutCoordinates) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                i4 = i3;
                modifier3 = companion;
                IconButtonKt.IconButton(onFabClick, OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxSize$default, (Function1) objRememberedValue), false, null, ComposableLambdaKt.rememberComposableLambda(2073202293, true, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.AIFloatingActionButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AIFloatingActionButtonKt.AIFloatingActionButton$lambda$0$1(mode, lastActiveMode, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i3 >> 18) & 14) | 24576, 12);
                composer2.endReplaceGroup();
            }
            int i6 = (i4 >> 12) & WebSocketProtocol.PAYLOAD_SHORT;
            int i7 = i4 >> 15;
            AIDropdownMenuKt.AIDropdownMenu(z2, dismissMenuRequest, onMenuItemClick, actionsAvailability, composer2, i6 | (i7 & 896) | (i7 & 7168));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.AIFloatingActionButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIFloatingActionButtonKt.AIFloatingActionButton$lambda$1(modifier3, z, mode, lastActiveMode, z2, dismissMenuRequest, onFabClick, onMenuItemClick, actionsAvailability, onAIButtonPositionChanged, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIFloatingActionButton$lambda$0$0$0(Function1 function1, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(it);
        int i = (int) (jPositionInRoot >> 32);
        int i2 = (int) (jPositionInRoot & 4294967295L);
        function1.invoke(new Rect(MathKt.roundToInt(Float.intBitsToFloat(i)), MathKt.roundToInt(Float.intBitsToFloat(i2)), MathKt.roundToInt(Float.intBitsToFloat(i)) + ((int) (it.mo9633getSizeYbymL2g() >> 32)), MathKt.roundToInt(Float.intBitsToFloat(i2)) + ((int) (4294967295L & it.mo9633getSizeYbymL2g()))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIFloatingActionButton$lambda$0$1(AIMode aIMode, AIMode aIMode2, Composer composer, int i) throws XmlPullParserException, IOException {
        ImageVector imageVectorVectorResource;
        ComposerKt.sourceInformation(composer, "C72@2800L1150:AIFloatingActionButton.kt#ez9f2c");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2073202293, i, -1, "com.myscript.nebo.ai.presentation.compose.AIFloatingActionButton.<anonymous>.<anonymous> (AIFloatingActionButton.kt:72)");
            }
            Modifier modifierM2924size3ABfNKs = SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            int i2 = WhenMappings.$EnumSwitchMapping$0[aIMode.ordinal()];
            if (i2 == 1) {
                composer.startReplaceGroup(-517415934);
                ComposerKt.sourceInformation(composer, "75@2963L45");
                imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_list, composer, 6);
                composer.endReplaceGroup();
            } else if (i2 == 2) {
                composer.startReplaceGroup(-517412721);
                ComposerKt.sourceInformation(composer, "76@3063L58");
                imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_lightbulb_outline, composer, 6);
                composer.endReplaceGroup();
            } else if (i2 == 3) {
                composer.startReplaceGroup(-517409216);
                ComposerKt.sourceInformation(composer, "77@3173L43");
                imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6091R.drawable.ic_sparkles, composer, 6);
                composer.endReplaceGroup();
            } else if (i2 == 4) {
                composer.startReplaceGroup(1140284116);
                ComposerKt.sourceInformation(composer, "");
                int i3 = WhenMappings.$EnumSwitchMapping$0[aIMode2.ordinal()];
                if (i3 == 1) {
                    composer.startReplaceGroup(-517403710);
                    ComposerKt.sourceInformation(composer, "79@3345L45");
                    imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_list, composer, 6);
                    composer.endReplaceGroup();
                } else if (i3 == 2) {
                    composer.startReplaceGroup(-517400369);
                    ComposerKt.sourceInformation(composer, "80@3449L58");
                    imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_lightbulb_outline, composer, 6);
                    composer.endReplaceGroup();
                } else if (i3 == 3) {
                    composer.startReplaceGroup(-517396726);
                    ComposerKt.sourceInformation(composer, "81@3563L53");
                    imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_quiz_outline, composer, 6);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-517393472);
                    ComposerKt.sourceInformation(composer, "82@3665L43");
                    imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6091R.drawable.ic_sparkles, composer, 6);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-517389824);
                ComposerKt.sourceInformation(composer, "84@3779L43");
                imageVectorVectorResource = VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6091R.drawable.ic_sparkles, composer, 6);
                composer.endReplaceGroup();
            }
            IconKt.m4301Iconww6aTOc(imageVectorVectorResource, "FAB", modifierM2924size3ABfNKs, Color.INSTANCE.m8185getWhite0d7_KjU(), composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
