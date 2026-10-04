package com.myscript.nebo.p022ai.presentation.compose.components;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.painter.Painter;
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
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.p022ai.C6091R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamingTextCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$StreamingTextCardKt {
    public static final ComposableSingletons$StreamingTextCardKt INSTANCE = new ComposableSingletons$StreamingTextCardKt();
    private static Function2<Composer, Integer, Unit> lambda$1388567345 = ComposableLambdaKt.composableLambdaInstance(1388567345, false, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreamingTextCardKt.lambda_1388567345$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1072615651, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2895lambda$1072615651 = ComposableLambdaKt.composableLambdaInstance(-1072615651, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StreamingTextCardKt.lambda__1072615651$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1926516486 = ComposableLambdaKt.composableLambdaInstance(1926516486, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StreamingTextCardKt.lambda_1926516486$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-419316763, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2896lambda$419316763 = ComposableLambdaKt.composableLambdaInstance(-419316763, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StreamingTextCardKt.lambda__419316763$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> lambda$562554207 = ComposableLambdaKt.composableLambdaInstance(562554207, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StreamingTextCardKt.lambda_562554207$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1072615651$nebo_ai_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m12861getLambda$1072615651$nebo_ai_release() {
        return f2895lambda$1072615651;
    }

    /* JADX INFO: renamed from: getLambda$-419316763$nebo_ai_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m12862getLambda$419316763$nebo_ai_release() {
        return f2896lambda$419316763;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1388567345$nebo_ai_release() {
        return lambda$1388567345;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1926516486$nebo_ai_release() {
        return lambda$1926516486;
    }

    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> getLambda$562554207$nebo_ai_release() {
        return lambda$562554207;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1388567345$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C84@3268L46,86@3439L6,83@3220L265:StreamingTextCard.kt#ysqczk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1388567345, i, -1, "com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt.lambda$1388567345.<anonymous> (StreamingTextCard.kt:83)");
            }
            IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_more_vert, composer, 0), "Overflow Menu", (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1072615651$lambda$0(RowScope DropdownMenuItem, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        ComposerKt.sourceInformation(composer, "C98@3931L32,98@3926L38:StreamingTextCard.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1072615651, i, -1, "com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt.lambda$-1072615651.<anonymous> (StreamingTextCard.kt:98)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_copy, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1926516486$lambda$0(RowScope DropdownMenuItem, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        ComposerKt.sourceInformation(composer, "C104@4235L39,104@4230L45:StreamingTextCard.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1926516486, i, -1, "com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt.lambda$1926516486.<anonymous> (StreamingTextCard.kt:104)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_add_to_note, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__419316763$lambda$0(RowScope DropdownMenuItem, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        ComposerKt.sourceInformation(composer, "C110@4530L37,110@4525L43:StreamingTextCard.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-419316763, i, -1, "com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt.lambda$-419316763.<anonymous> (StreamingTextCard.kt:110)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_try_again, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_562554207$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C148@6086L110,152@6278L56,153@6394L10,154@6470L6,151@6229L310:StreamingTextCard.kt#ysqczk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(562554207, i, -1, "com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$StreamingTextCardKt.lambda$562554207.<anonymous> (StreamingTextCard.kt:148)");
        }
        SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(8)), composer, 6);
        TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_generated_content_disclaimer, composer, 0), (Modifier) null, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBody2(), composer, 0, 0, 65530);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
