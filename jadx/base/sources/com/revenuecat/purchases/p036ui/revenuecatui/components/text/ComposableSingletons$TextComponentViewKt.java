package com.revenuecat.purchases.p036ui.revenuecatui.components.text;

import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ComposableSingletons$TextComponentViewKt {
    public static final ComposableSingletons$TextComponentViewKt INSTANCE = new ComposableSingletons$TextComponentViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2925lambda1 = ComposableLambdaKt.composableLambdaInstance(765510784, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C213@9387L19,206@9051L370:TextComponentView.kt#fyu9x8");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(765510784, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt.lambda-1.<anonymous> (TextComponentView.kt:206)");
                }
                TextComponentViewKt.TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Experience Pro today!", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 34, (65520 & 8) != 0 ? FontWeight.REGULAR : FontWeight.EXTRA_BOLD, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, null, composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2926lambda2 = ComposableLambdaKt.composableLambdaInstance(55915153, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C205@9003L7,205@8971L460:TextComponentView.kt#fyu9x8");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(55915153, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt.lambda-2.<anonymous> (TextComponentView.kt:205)");
                }
                ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localTextStyle);
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextKt.ProvideTextStyle(TextStyle.m10466copyp1EtxEg$default((TextStyle) objConsume, Color.INSTANCE.m8175getBlue0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), ComposableSingletons$TextComponentViewKt.INSTANCE.m14016getLambda1$revenuecatui_defaultsRelease(), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14016getLambda1$revenuecatui_defaultsRelease() {
        return f2925lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14017getLambda2$revenuecatui_defaultsRelease() {
        return f2926lambda2;
    }
}
