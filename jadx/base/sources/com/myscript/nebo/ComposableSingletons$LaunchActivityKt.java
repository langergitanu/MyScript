package com.myscript.nebo;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import com.myscript.nebo.p034ui.compose.LanguageSelectionKt;
import com.myscript.nebo.p034ui.compose.PLSMigrationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LaunchActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$LaunchActivityKt {
    public static final ComposableSingletons$LaunchActivityKt INSTANCE = new ComposableSingletons$LaunchActivityKt();
    private static Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> lambda$1577729889 = ComposableLambdaKt.composableLambdaInstance(1577729889, false, new Function4() { // from class: com.myscript.nebo.ComposableSingletons$LaunchActivityKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$LaunchActivityKt.lambda_1577729889$lambda$0((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });
    private static Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> lambda$1516186841 = ComposableLambdaKt.composableLambdaInstance(1516186841, false, new Function4() { // from class: com.myscript.nebo.ComposableSingletons$LaunchActivityKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$LaunchActivityKt.lambda_1516186841$lambda$0((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2130552998, reason: not valid java name */
    private static Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> f2894lambda$2130552998 = ComposableLambdaKt.composableLambdaInstance(-2130552998, false, new Function4() { // from class: com.myscript.nebo.ComposableSingletons$LaunchActivityKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$LaunchActivityKt.lambda__2130552998$lambda$0((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1482325541, reason: not valid java name */
    private static Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> f2892lambda$1482325541 = ComposableLambdaKt.composableLambdaInstance(-1482325541, false, new Function4() { // from class: com.myscript.nebo.ComposableSingletons$LaunchActivityKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$LaunchActivityKt.lambda__1482325541$lambda$0((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-185870627, reason: not valid java name */
    private static Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> f2893lambda$185870627 = ComposableLambdaKt.composableLambdaInstance(-185870627, false, new Function4() { // from class: com.myscript.nebo.ComposableSingletons$LaunchActivityKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$LaunchActivityKt.lambda__185870627$lambda$0((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1482325541$app_standardRelease, reason: not valid java name */
    public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> m12779getLambda$1482325541$app_standardRelease() {
        return f2892lambda$1482325541;
    }

    /* JADX INFO: renamed from: getLambda$-185870627$app_standardRelease, reason: not valid java name */
    public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> m12780getLambda$185870627$app_standardRelease() {
        return f2893lambda$185870627;
    }

    /* JADX INFO: renamed from: getLambda$-2130552998$app_standardRelease, reason: not valid java name */
    public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> m12781getLambda$2130552998$app_standardRelease() {
        return f2894lambda$2130552998;
    }

    public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> getLambda$1516186841$app_standardRelease() {
        return lambda$1516186841;
    }

    public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> getLambda$1577729889$app_standardRelease() {
        return lambda$1577729889;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1577729889$lambda$0(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):LaunchActivity.kt#3ig9qq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1577729889, i, -1, "com.myscript.nebo.ComposableSingletons$LaunchActivityKt.lambda$1577729889.<anonymous> (LaunchActivity.kt:144)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1516186841$lambda$0(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)154@7002L23:LaunchActivity.kt#3ig9qq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1516186841, i, -1, "com.myscript.nebo.ComposableSingletons$LaunchActivityKt.lambda$1516186841.<anonymous> (LaunchActivity.kt:154)");
        }
        LanguageSelectionKt.LanguageSelectionPane(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2130552998$lambda$0(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)157@7138L111:LaunchActivity.kt#3ig9qq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2130552998, i, -1, "com.myscript.nebo.ComposableSingletons$LaunchActivityKt.lambda$-2130552998.<anonymous> (LaunchActivity.kt:157)");
        }
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
        ComposerKt.sourceInformationMarkerStart(composer, -1234920536, "C158@7196L27:LaunchActivity.kt#3ig9qq");
        ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(null, 0L, 0.0f, 0L, 0, composer, 0, 31);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1482325541$lambda$0(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)162@7363L18:LaunchActivity.kt#3ig9qq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1482325541, i, -1, "com.myscript.nebo.ComposableSingletons$LaunchActivityKt.lambda$-1482325541.<anonymous> (LaunchActivity.kt:162)");
        }
        PLSMigrationKt.PLSMigrationPane(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__185870627$lambda$0(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):LaunchActivity.kt#3ig9qq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-185870627, i, -1, "com.myscript.nebo.ComposableSingletons$LaunchActivityKt.lambda$-185870627.<anonymous> (LaunchActivity.kt:170)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
