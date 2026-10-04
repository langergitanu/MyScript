package com.myscript.nebo.p022ai.presentation.compose.quiz;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.res.VectorResources_androidKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.p022ai.C6091R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIQuizCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$AIQuizCardKt {
    public static final ComposableSingletons$AIQuizCardKt INSTANCE = new ComposableSingletons$AIQuizCardKt();

    /* JADX INFO: renamed from: lambda$-3060994, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f2899lambda$3060994 = ComposableLambdaKt.composableLambdaInstance(-3060994, false, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AIQuizCardKt.lambda__3060994$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$804366404 = ComposableLambdaKt.composableLambdaInstance(804366404, false, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AIQuizCardKt.lambda_804366404$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$353261577 = ComposableLambdaKt.composableLambdaInstance(353261577, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AIQuizCardKt.lambda_353261577$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1819726079, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2897lambda$1819726079 = ComposableLambdaKt.composableLambdaInstance(-1819726079, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AIQuizCardKt.lambda__1819726079$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$586045290 = ComposableLambdaKt.composableLambdaInstance(586045290, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AIQuizCardKt.lambda_586045290$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2111959021, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2898lambda$2111959021 = ComposableLambdaKt.composableLambdaInstance(-2111959021, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AIQuizCardKt.lambda__2111959021$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> lambda$704447508 = ComposableLambdaKt.composableLambdaInstance(704447508, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AIQuizCardKt.lambda_704447508$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$162885909 = ComposableLambdaKt.composableLambdaInstance(162885909, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AIQuizCardKt.lambda_162885909$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1819726079$nebo_ai_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m12900getLambda$1819726079$nebo_ai_release() {
        return f2897lambda$1819726079;
    }

    /* JADX INFO: renamed from: getLambda$-2111959021$nebo_ai_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m12901getLambda$2111959021$nebo_ai_release() {
        return f2898lambda$2111959021;
    }

    /* JADX INFO: renamed from: getLambda$-3060994$nebo_ai_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12902getLambda$3060994$nebo_ai_release() {
        return f2899lambda$3060994;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$162885909$nebo_ai_release() {
        return lambda$162885909;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$353261577$nebo_ai_release() {
        return lambda$353261577;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$586045290$nebo_ai_release() {
        return lambda$586045290;
    }

    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> getLambda$704447508$nebo_ai_release() {
        return lambda$704447508;
    }

    public final Function2<Composer, Integer, Unit> getLambda$804366404$nebo_ai_release() {
        return lambda$804366404;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__3060994$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C186@7811L46,188@7958L6,185@7775L217:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-3060994, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$-3060994.<anonymous> (AIQuizCard.kt:185)");
            }
            IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_more_vert, composer, 0), "Overflow Menu", (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_804366404$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C213@8836L46,215@8967L6,212@8788L209:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(804366404, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$804366404.<anonymous> (AIQuizCard.kt:212)");
            }
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_close, composer, 6), "close", (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_353261577$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C348@13594L39,348@13582L52:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(353261577, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$353261577.<anonymous> (AIQuizCard.kt:348)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_submit, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1819726079$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C410@15414L49,408@15312L170:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1819726079, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$-1819726079.<anonymous> (AIQuizCard.kt:408)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_button_true, composer, 0), PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(10), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_586045290$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C424@15981L50,422@15879L171:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586045290, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$586045290.<anonymous> (AIQuizCard.kt:422)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_button_false, composer, 0), PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(10), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2111959021$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C477@17852L50,476@17819L102:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2111959021, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$-2111959021.<anonymous> (AIQuizCard.kt:476)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_button_retry, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_704447508$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C513@19591L233:AIQuizCard.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(704447508, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$704447508.<anonymous> (AIQuizCard.kt:513)");
        }
        ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(SizeKt.m2916requiredSize3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(18)), Color.INSTANCE.m8178getGray0d7_KjU(), C1486Dp.m11017constructorimpl(2), 0L, 0, composer, 438, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_162885909$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C537@20264L437:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(162885909, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizCardKt.lambda$162885909.<anonymous> (AIQuizCard.kt:537)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerVertically, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, 340060351, "C542@20445L58,541@20416L102,544@20531L160:AIQuizCard.kt#nf75a9");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_button_next_question, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(18)), Color.INSTANCE.m8178getGray0d7_KjU(), C1486Dp.m11017constructorimpl(2), 0L, 0, composer, 438, 24);
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
}
