package com.revenuecat.purchases.p036ui.revenuecatui.components.stack;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.layout.LayoutModifierKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.layout.SubcomposeLayoutKt;
import androidx.compose.p004ui.layout.SubcomposeMeasureScope;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.tooling.preview.PreviewParameter;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C2181C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WithOptionalBackgroundOverlayKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.ScrollableKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.WebViewComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: StackComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a»\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u00012 \b\u0002\u0010%\u001a\u001a\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\r\u0018\u00010&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010*\u001a\u0087\u0001\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010.\u001a\r\u0010/\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u00101\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u00102\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u00103\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\u0017\u00104\u001a\u00020\r2\b\b\u0001\u00105\u001a\u000206H\u0003¢\u0006\u0002\u00107\u001a\u0017\u00108\u001a\u00020\r2\b\b\u0001\u00105\u001a\u000206H\u0003¢\u0006\u0002\u00107\u001a\u0017\u00109\u001a\u00020\r2\b\b\u0001\u00105\u001a\u000206H\u0003¢\u0006\u0002\u00107\u001a\r\u0010:\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\u0017\u0010;\u001a\u00020\r2\b\b\u0001\u0010<\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010=\u001a\r\u0010>\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010?\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010@\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010A\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010B\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\u0017\u0010C\u001a\u00020\r2\b\b\u0001\u0010<\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010=\u001a\u0017\u0010D\u001a\u00020\r2\b\b\u0001\u0010<\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010=\u001a\u0017\u0010E\u001a\u00020\r2\b\b\u0001\u0010<\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010=\u001a\r\u0010F\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010G\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010H\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010I\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010J\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\r\u0010K\u001a\u00020\rH\u0003¢\u0006\u0002\u00100\u001a\u0093\u0001\u0010L\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020\u00012\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0003¢\u0006\u0002\u0010O\u001a\u0093\u0001\u0010P\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010M\u001a\u00020-2\u0006\u0010<\u001a\u00020\u00022\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0003¢\u0006\u0002\u0010Q\u001a\u0093\u0001\u0010R\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010M\u001a\u00020-2\u0006\u0010<\u001a\u00020\u00022\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0003¢\u0006\u0002\u0010Q\u001a\"\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010<\u001a\u00020\u00022\b\b\u0002\u0010V\u001a\u00020\u001aH\u0002\u001a4\u0010W\u001a\u00020#2\u0006\u0010,\u001a\u00020X2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020\\2\b\b\u0002\u0010]\u001a\u00020\\H\u0002\u001a\u0013\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_H\u0003¢\u0006\u0002\u0010a\u001aE\u0010b\u001a\u00020\r*\u00020'2\u0006\u0010M\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u00022\b\u0010V\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0003¢\u0006\u0002\u0010c\u001a\u001c\u0010d\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010e\u001a\u00020TH\u0002\u001a&\u0010f\u001a\u00020g*\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kH\u0002ø\u0001\u0000¢\u0006\u0004\bl\u0010m\u001a\u001c\u0010f\u001a\u00020g*\u00020g2\u0006\u0010n\u001a\u00020o2\u0006\u0010j\u001a\u00020kH\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006p²\u0006\n\u0010q\u001a\u00020rX\u008a\u0084\u0002²\u0006\n\u0010q\u001a\u00020rX\u008a\u0084\u0002"}, m1599d2 = {"isTop", "", "Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "(Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;)Z", "shouldIgnoreTopWindowInsets", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "getShouldIgnoreTopWindowInsets", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;)Z", "usesAllAvailableSpace", "Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "getUsesAllAvailableSpace", "(Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;)Z", "MainStackComponent", "", "stackState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "contentAlpha", "", "modifier", "Landroidx/compose/ui/Modifier;", "onStackClick", "Lkotlin/Function0;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "nestedBadge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "shouldApplyShadow", "overlay", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "StackComponentView", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;FLcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "StackComponentView_Preview_Children_Extend_Over_Parent", "(Landroidx/compose/runtime/Composer;I)V", "StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow", "StackComponentView_Preview_ContentAlpha", "StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children", "StackComponentView_Preview_Distribution_With_Spacing", TypedValues.Custom.S_DIMENSION, "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "(Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;Landroidx/compose/runtime/Composer;I)V", "StackComponentView_Preview_Distribution_Without_Spacing", "StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size", "StackComponentView_Preview_EdgeToEdgeBadge_Caller_Modifier_Applied_Twice", "StackComponentView_Preview_EdgeToEdge_Badge", "alignment", "(Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Landroidx/compose/runtime/Composer;I)V", "StackComponentView_Preview_Horizontal", "StackComponentView_Preview_HorizontalChildrenFillWidth", "StackComponentView_Preview_HorizontalDivider", "StackComponentView_Preview_NegativePaddingAndMarginClamped", "StackComponentView_Preview_NestedBadge_Caller_Modifier_Applied_Twice", "StackComponentView_Preview_Nested_Badge", "StackComponentView_Preview_Overlay_Badge", "StackComponentView_Preview_Pill_EdgeToEdge_Badge", "StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll", "StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll", "StackComponentView_Preview_Vertical", "StackComponentView_Preview_VerticalChildrenFillHeight", "StackComponentView_Preview_VerticalDivider", "StackComponentView_Preview_ZLayer", "StackWithLongEdgeToEdgeBadge", "badgeStack", "topBadge", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;ZLkotlin/jvm/functions/Function2;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "StackWithOverlaidBadge", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Lkotlin/jvm/functions/Function2;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "StackWithShortEdgeToEdgeBadge", "getOverlaidBadgeOffsetY", "", "height", "mainStackBorderWidthPx", "previewBadge", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "previewChildren", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "OverlaidBadge", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Ljava/lang/Float;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "headerOrInsetsTopPadding", "fallbackInsetPx", "makeAbsolute", "Landroidx/compose/foundation/shape/CornerSize;", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "makeAbsolute-12SF9DM", "(Landroidx/compose/foundation/shape/CornerSize;JLandroidx/compose/ui/unit/Density;)Landroidx/compose/foundation/shape/CornerSize;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "revenuecatui_defaultsRelease", "composeShape", "Landroidx/compose/ui/graphics/Shape;"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class StackComponentViewKt {

    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TwoDimensionalAlignment.values().length];
            try {
                iArr[TwoDimensionalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TwoDimensionalAlignment.TOP_LEADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TwoDimensionalAlignment.TOP_TRAILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM_LEADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM_TRAILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TwoDimensionalAlignment.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TwoDimensionalAlignment.LEADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TwoDimensionalAlignment.TRAILING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Badge.Style.values().length];
            try {
                iArr2[Badge.Style.Overlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Badge.Style.EdgeToEdge.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Badge.Style.Nested.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[FlexDistribution.values().length];
            try {
                iArr3[FlexDistribution.SPACE_AROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[FlexDistribution.SPACE_BETWEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[FlexDistribution.SPACE_EVENLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[FlexDistribution.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[FlexDistribution.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[FlexDistribution.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a A[PHI: r19
      0x010a: PHI (r19v15 int) = (r19v4 int), (r19v10 int), (r19v11 int) binds: [B:88:0x0108, B:98:0x0125, B:97:0x0122] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackComponentView(final StackComponentStyle style, final PaywallState.Loaded.Components state, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> clickHandler, Modifier modifier, Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, float f, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function0<Unit> function02;
        int i5;
        boolean z2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        int i9;
        StackComponentState stackComponentStateRememberUpdatedStackComponentState;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3;
        final Function0<Unit> function03;
        final float f2;
        final boolean z3;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(401418791);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView)P(8,7!1,5,6,3,4,2)142@8722L94:StackComponentView.kt#280jdz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(clickHandler) ? 256 : 128;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    function02 = function0;
                    i3 |= composerStartRestartGroup.changedInstance(function02) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                } else {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                        if ((i & 12582912) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                        }
                        i9 = i2 & 256;
                        int i11 = 100663296;
                        if (i9 != 0) {
                            i3 |= i11;
                        } else if ((i & 100663296) == 0) {
                            i11 = (i & 134217728) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker) ? 67108864 : 33554432;
                            i3 |= i11;
                        }
                        if ((i3 & 38347923) != 38347922 || !composerStartRestartGroup.getSkipping()) {
                            Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                            Function0<Unit> function04 = i4 == 0 ? null : function02;
                            boolean z4 = i5 == 0 ? true : z2;
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            float f3 = i8 == 0 ? 1.0f : f;
                            PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = i9 == 0 ? new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$$ExternalSyntheticLambda0
                                @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                                public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                                    Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                                }
                            } : paywallComponentInteractionTracker;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(401418791, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView (StackComponentView.kt:140)");
                            }
                            int i12 = i3 & 112;
                            stackComponentStateRememberUpdatedStackComponentState = StackComponentStateKt.rememberUpdatedStackComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
                            if (stackComponentStateRememberUpdatedStackComponentState.getVisible()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup2 != null) {
                                    final Function0<Unit> function05 = function04;
                                    final float f4 = f3;
                                    final Modifier modifier5 = modifier4;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    final boolean z5 = z4;
                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker5 = paywallComponentInteractionTracker4;
                                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView.2
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

                                        public final void invoke(Composer composer2, int i13) {
                                            StackComponentViewKt.StackComponentView(style, state, clickHandler, modifier5, function05, z5, mutableInteractionSource4, f4, paywallComponentInteractionTracker5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                            float f5 = f3;
                            PaywallComponentInteractionTracker paywallComponentInteractionTracker6 = paywallComponentInteractionTracker4;
                            BadgeStyle badge = stackComponentStateRememberUpdatedStackComponentState.getBadge();
                            if (badge != null) {
                                composerStartRestartGroup.startReplaceGroup(1458007695);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                int i13 = WhenMappings.$EnumSwitchMapping$1[badge.getStyle().ordinal()];
                                if (i13 == 1) {
                                    int i14 = i3;
                                    paywallComponentInteractionTracker2 = paywallComponentInteractionTracker6;
                                    composerStartRestartGroup.startReplaceGroup(1458011198);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "155@9011L469");
                                    int i15 = i14 << 12;
                                    StackWithOverlaidBadge(stackComponentStateRememberUpdatedStackComponentState, state, badge.getStackStyle(), badge.getAlignment(), clickHandler, paywallComponentInteractionTracker2, f5, modifier4, function04, z4, mutableInteractionSource5, composerStartRestartGroup, i12 | ((i14 << 6) & 57344) | ((i14 >> 9) & 458752) | ((i14 >> 3) & 3670016) | (i15 & 29360128) | (i15 & 234881024) | (i15 & C2181C.ENCODING_PCM_DOUBLE), (i14 >> 18) & 14, 0);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (i13 != 2) {
                                    if (i13 == 3) {
                                        composerStartRestartGroup.startReplaceGroup(878377274);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@10888L523");
                                        int i16 = (i3 & 1008) | ((i3 >> 15) & 7168) | ((i3 >> 9) & 57344);
                                        int i17 = i3 << 6;
                                        Function0<Unit> function06 = function04;
                                        Modifier modifier6 = modifier4;
                                        boolean z6 = z4;
                                        MainStackComponent(stackComponentStateRememberUpdatedStackComponentState, state, clickHandler, paywallComponentInteractionTracker6, f5, modifier6, function06, z6, mutableInteractionSource5, badge, false, null, composerStartRestartGroup, i16 | (i17 & 458752) | (i17 & 3670016) | (i17 & 29360128) | (i17 & 234881024), 0, 3072);
                                        z4 = z6;
                                        mutableInteractionSource5 = mutableInteractionSource5;
                                        modifier4 = modifier6;
                                        function04 = function06;
                                        f5 = f5;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1460404243);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    paywallComponentInteractionTracker2 = paywallComponentInteractionTracker6;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1458572701);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                    int i18 = WhenMappings.$EnumSwitchMapping$0[badge.getAlignment().ordinal()];
                                    if (i18 == 1 || i18 == 2) {
                                        int i19 = i3;
                                        paywallComponentInteractionTracker2 = paywallComponentInteractionTracker6;
                                        composerStartRestartGroup.startReplaceGroup(878339296);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "174@9701L529");
                                        int i20 = i19 << 12;
                                        StackWithLongEdgeToEdgeBadge(stackComponentStateRememberUpdatedStackComponentState, state, badge.getStackStyle(), isTop(badge.getAlignment()), clickHandler, paywallComponentInteractionTracker2, f5, modifier4, function04, z4, mutableInteractionSource5, composerStartRestartGroup, i12 | ((i19 << 6) & 57344) | ((i19 >> 9) & 458752) | ((i19 >> 3) & 3670016) | (i20 & 29360128) | (i20 & 234881024) | (i20 & C2181C.ENCODING_PCM_DOUBLE), (i19 >> 18) & 14, 0);
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(878357819);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "189@10280L524");
                                        int i21 = i3;
                                        paywallComponentInteractionTracker2 = paywallComponentInteractionTracker6;
                                        int i22 = i21 << 12;
                                        StackWithShortEdgeToEdgeBadge(stackComponentStateRememberUpdatedStackComponentState, state, badge.getStackStyle(), badge.getAlignment(), clickHandler, paywallComponentInteractionTracker2, f5, modifier4, function04, z4, mutableInteractionSource5, composerStartRestartGroup, i12 | ((i21 << 6) & 57344) | ((i21 >> 9) & 458752) | ((i21 >> 3) & 3670016) | (i22 & 29360128) | (i22 & 234881024) | (i22 & C2181C.ENCODING_PCM_DOUBLE), (i21 >> 18) & 14, 0);
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                int i23 = i3;
                                composerStartRestartGroup.startReplaceGroup(1460429105);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "220@11443L402");
                                int i24 = i23 << 6;
                                Modifier modifier7 = modifier4;
                                boolean z7 = z4;
                                Function0<Unit> function07 = function04;
                                MainStackComponent(stackComponentStateRememberUpdatedStackComponentState, state, clickHandler, paywallComponentInteractionTracker6, f5, modifier7, function07, z7, mutableInteractionSource5, null, false, null, composerStartRestartGroup, (i23 & 1008) | ((i23 >> 15) & 7168) | ((i23 >> 9) & 57344) | (i24 & 458752) | (i24 & 3670016) | (i24 & 29360128) | (i24 & 234881024), 0, RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK);
                                z4 = z7;
                                mutableInteractionSource5 = mutableInteractionSource5;
                                modifier4 = modifier7;
                                function04 = function07;
                                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker6;
                                f5 = f5;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            boolean z8 = z4;
                            paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
                            function03 = function04;
                            f2 = f5;
                            z3 = z8;
                            modifier3 = modifier4;
                            mutableInteractionSource3 = mutableInteractionSource5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier3 = modifier2;
                            function03 = function02;
                            z3 = z2;
                            f2 = f;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView.3
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

                                public final void invoke(Composer composer2, int i25) {
                                    StackComponentViewKt.StackComponentView(style, state, clickHandler, modifier3, function03, z3, mutableInteractionSource3, f2, paywallComponentInteractionTracker3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    i8 = i7;
                    i9 = i2 & 256;
                    int i112 = 100663296;
                    if (i9 != 0) {
                    }
                    if ((i3 & 38347923) != 38347922) {
                        if (i10 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i122 = i3 & 112;
                        stackComponentStateRememberUpdatedStackComponentState = StackComponentStateKt.rememberUpdatedStackComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
                        if (stackComponentStateRememberUpdatedStackComponentState.getVisible()) {
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z2 = z;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i2 & 256;
                int i1122 = 100663296;
                if (i9 != 0) {
                }
                if ((i3 & 38347923) != 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function02 = function0;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            z2 = z;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i2 & 256;
            int i11222 = 100663296;
            if (i9 != 0) {
            }
            if ((i3 & 38347923) != 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        function02 = function0;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        z2 = z;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i2 & 256;
        int i112222 = 100663296;
        if (i9 != 0) {
        }
        if ((i3 & 38347923) != 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackWithOverlaidBadge(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final StackComponentStyle stackComponentStyle, final TwoDimensionalAlignment twoDimensionalAlignment, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final PaywallComponentInteractionTracker paywallComponentInteractionTracker, final float f, Modifier modifier, Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        StackComponentState stackComponentState2;
        int i4;
        float f2;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int currentCompositeKeyHash;
        Composer composerM7248constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composer2;
        final Function0<Unit> function02;
        final boolean z2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2120090846);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackWithOverlaidBadge)P(9,10,1!4,7,8)249@12405L767:StackComponentView.kt#280jdz");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            stackComponentState2 = stackComponentState;
        } else if ((i & 6) == 0) {
            stackComponentState2 = stackComponentState;
            i4 = (composerStartRestartGroup.changed(stackComponentState2) ? 4 : 2) | i;
        } else {
            stackComponentState2 = stackComponentState;
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(components) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i4 |= composerStartRestartGroup.changed(stackComponentStyle) ? 256 : 128;
                }
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        i4 |= composerStartRestartGroup.changed(twoDimensionalAlignment) ? 2048 : 1024;
                    }
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
                        }
                        if ((i3 & 32) != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i4 |= (262144 & i) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker) ? 131072 : 65536;
                        }
                        if ((i3 & 64) != 0) {
                            i4 |= 1572864;
                        } else {
                            if ((i & 1572864) == 0) {
                                f2 = f;
                                i4 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
                            }
                            i5 = i3 & 128;
                            if (i5 != 0) {
                                if ((12582912 & i) == 0) {
                                    modifier2 = modifier;
                                    i4 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
                                }
                                i6 = i3 & 256;
                                if (i6 != 0) {
                                    i4 |= 100663296;
                                } else if ((i & 100663296) == 0) {
                                    i4 |= composerStartRestartGroup.changedInstance(function0) ? 67108864 : 33554432;
                                }
                                i7 = i3 & 512;
                                if (i7 != 0) {
                                    i4 |= 805306368;
                                } else if ((i & 805306368) == 0) {
                                    i4 |= composerStartRestartGroup.changed(z) ? 536870912 : 268435456;
                                }
                                i8 = i3 & 1024;
                                if (i8 != 0) {
                                    i9 = i8;
                                    i10 = i2 | 6;
                                } else if ((i2 & 6) == 0) {
                                    i9 = i8;
                                    i10 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i9 = i8;
                                    i10 = i2;
                                }
                                if ((i4 & 306783379) != 306783378 || (i10 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
                                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                                    Function0<Unit> function03 = i6 == 0 ? null : function0;
                                    boolean z3 = i7 == 0 ? true : z;
                                    MutableInteractionSource mutableInteractionSource3 = i9 == 0 ? null : mutableInteractionSource;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2120090846, i4, i10, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithOverlaidBadge (StackComponentView.kt:248)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                    int i11 = i10;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                                    Modifier modifier4 = companion;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function0<Unit> function04 = function03;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composerStartRestartGroup.startReusableNode();
                                    if (!composerStartRestartGroup.getInserting()) {
                                        composerStartRestartGroup.createNode(constructor);
                                    } else {
                                        composerStartRestartGroup.useNode();
                                    }
                                    composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (!composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2117277400, "C250@12440L369,*260@12865L7,263@12939L227:StackComponentView.kt#280jdz");
                                    int i12 = i4 >> 6;
                                    int i13 = i12 & 7168;
                                    int i14 = (i4 & WebSocketProtocol.PAYLOAD_SHORT) | (i12 & 896) | i13 | (57344 & i12) | (3670016 & i12) | (i12 & 29360128) | ((i11 << 24) & 234881024);
                                    composer2 = composerStartRestartGroup;
                                    boolean z4 = z3;
                                    int i15 = i4;
                                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                    MainStackComponent(stackComponentState2, components, function2, paywallComponentInteractionTracker, f2, null, function04, z4, mutableInteractionSource4, null, false, null, composer2, i14, 0, 3616);
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composer2.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    Density density = (Density) objConsume;
                                    BorderStyles border = stackComponentState.getBorder();
                                    Float fValueOf = border != null ? Float.valueOf(density.mo2191toPx0680j_4(border.m13936getWidthD9Ej5fM())) : null;
                                    int i16 = i15 << 3;
                                    OverlaidBadge(boxScopeInstance, stackComponentStyle, components, paywallComponentInteractionTracker, twoDimensionalAlignment, fValueOf, PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), composer2, ((i15 >> 3) & 112) | 6 | (i16 & 896) | i13 | (i16 & 57344), 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function02 = function04;
                                    z2 = z4;
                                    mutableInteractionSource2 = mutableInteractionSource4;
                                    modifier3 = modifier4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function02 = function0;
                                    z2 = z;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier2;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithOverlaidBadge.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i17) {
                                            StackComponentViewKt.StackWithOverlaidBadge(stackComponentState, components, stackComponentStyle, twoDimensionalAlignment, function2, paywallComponentInteractionTracker, f, modifier3, function02, z2, mutableInteractionSource2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i4 |= 12582912;
                            modifier2 = modifier;
                            i6 = i3 & 256;
                            if (i6 != 0) {
                            }
                            i7 = i3 & 512;
                            if (i7 != 0) {
                            }
                            i8 = i3 & 1024;
                            if (i8 != 0) {
                            }
                            if ((i4 & 306783379) != 306783378) {
                                if (i5 == 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i9 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int i112 = i10;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                                Modifier modifier42 = companion;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function0<Unit> function042 = function03;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (!composerStartRestartGroup.getInserting()) {
                                }
                                composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!composerM7248constructorimpl.getInserting()) {
                                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2117277400, "C250@12440L369,*260@12865L7,263@12939L227:StackComponentView.kt#280jdz");
                                    int i122 = i4 >> 6;
                                    int i132 = i122 & 7168;
                                    int i142 = (i4 & WebSocketProtocol.PAYLOAD_SHORT) | (i122 & 896) | i132 | (57344 & i122) | (3670016 & i122) | (i122 & 29360128) | ((i112 << 24) & 234881024);
                                    composer2 = composerStartRestartGroup;
                                    boolean z42 = z3;
                                    int i152 = i4;
                                    MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource3;
                                    MainStackComponent(stackComponentState2, components, function2, paywallComponentInteractionTracker, f2, null, function042, z42, mutableInteractionSource42, null, false, null, composer2, i142, 0, 3616);
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composer2.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    Density density2 = (Density) objConsume2;
                                    BorderStyles border2 = stackComponentState.getBorder();
                                    if (border2 != null) {
                                    }
                                    int i162 = i152 << 3;
                                    OverlaidBadge(boxScopeInstance2, stackComponentStyle, components, paywallComponentInteractionTracker, twoDimensionalAlignment, fValueOf, PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), composer2, ((i152 >> 3) & 112) | 6 | (i162 & 896) | i132 | (i162 & 57344), 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    function02 = function042;
                                    z2 = z42;
                                    mutableInteractionSource2 = mutableInteractionSource42;
                                    modifier3 = modifier42;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        f2 = f;
                        i5 = i3 & 128;
                        if (i5 != 0) {
                        }
                        modifier2 = modifier;
                        i6 = i3 & 256;
                        if (i6 != 0) {
                        }
                        i7 = i3 & 512;
                        if (i7 != 0) {
                        }
                        i8 = i3 & 1024;
                        if (i8 != 0) {
                        }
                        if ((i4 & 306783379) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    f2 = f;
                    i5 = i3 & 128;
                    if (i5 != 0) {
                    }
                    modifier2 = modifier;
                    i6 = i3 & 256;
                    if (i6 != 0) {
                    }
                    i7 = i3 & 512;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 1024;
                    if (i8 != 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                if ((i3 & 16) == 0) {
                }
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                f2 = f;
                i5 = i3 & 128;
                if (i5 != 0) {
                }
                modifier2 = modifier;
                i6 = i3 & 256;
                if (i6 != 0) {
                }
                i7 = i3 & 512;
                if (i7 != 0) {
                }
                i8 = i3 & 1024;
                if (i8 != 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) == 0) {
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            f2 = f;
            i5 = i3 & 128;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 256;
            if (i6 != 0) {
            }
            i7 = i3 & 512;
            if (i7 != 0) {
            }
            i8 = i3 & 1024;
            if (i8 != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        f2 = f;
        i5 = i3 & 128;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 256;
        if (i6 != 0) {
        }
        i7 = i3 & 512;
        if (i7 != 0) {
        }
        i8 = i3 & 1024;
        if (i8 != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackWithLongEdgeToEdgeBadge(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final StackComponentStyle stackComponentStyle, final boolean z, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final PaywallComponentInteractionTracker paywallComponentInteractionTracker, final float f, Modifier modifier, Function0<Unit> function0, boolean z2, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        final StackComponentStyle stackComponentStyle2;
        boolean z3;
        float f2;
        int i5;
        final Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        Function0<Unit> function02;
        boolean z4;
        MutableInteractionSource mutableInteractionSource2;
        boolean zChanged;
        Object objRememberedValue;
        final State state;
        boolean zChanged2;
        Object objRememberedValue2;
        Modifier modifierApplyIfNotNull;
        boolean zChangedInstance;
        Object objRememberedValue3;
        final Function0<Unit> function03;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        int i11;
        Modifier modifier3;
        Modifier modifier4;
        final Function0<Unit> function04;
        final boolean z6;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-135480327);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackWithLongEdgeToEdgeBadge)P(8,9!1,10!3,6,7)293@13955L76,297@14124L28,298@14160L7529,295@14037L7652:StackComponentView.kt#280jdz");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(stackComponentState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(components) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    stackComponentStyle2 = stackComponentStyle;
                    i4 |= composerStartRestartGroup.changed(stackComponentStyle2) ? 256 : 128;
                }
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                    }
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
                    }
                    if ((i3 & 32) == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                        i4 |= (i & 262144) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker) ? 131072 : 65536;
                    }
                    if ((i3 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            f2 = f;
                            i4 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
                        }
                        i5 = i3 & 128;
                        if (i5 != 0) {
                            i4 |= 12582912;
                            modifier2 = modifier;
                        } else {
                            modifier2 = modifier;
                            if ((i & 12582912) == 0) {
                                i4 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
                            }
                        }
                        i6 = i3 & 256;
                        if (i6 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function0) ? 67108864 : 33554432;
                        }
                        i7 = i3 & 512;
                        if (i7 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i4 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                        }
                        i8 = i3 & 1024;
                        if (i8 != 0) {
                            i9 = i8;
                            i10 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i9 = i8;
                            i10 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i9 = i8;
                            i10 = i2;
                        }
                        if ((i4 & 306783379) != 306783378 || (i10 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
                            companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                            function02 = i6 == 0 ? null : function0;
                            z4 = i7 == 0 ? true : z2;
                            mutableInteractionSource2 = i9 == 0 ? null : mutableInteractionSource;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-135480327, i4, i10, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge (StackComponentView.kt:291)");
                            }
                            ShadowStyles shadow = stackComponentState.getShadow();
                            composerStartRestartGroup.startReplaceGroup(-2045035647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*292@13896L32");
                            ShadowStyle shadowStyleRememberShadowStyle = shadow != null ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            Shape shape = stackComponentState.getShape();
                            int i12 = i10;
                            composerStartRestartGroup.startReplaceGroup(-2045033531);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(shape);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$composeShape$2$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final androidx.compose.p004ui.graphics.Shape invoke() {
                                        return ShapeKt.toShape(stackComponentState.getShape());
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            state = (State) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-2045028171);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.StackWithLongEdgeToEdgeBadge$lambda$5(state));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(companion, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                            composerStartRestartGroup.startReplaceGroup(-2045019518);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChangedInstance = ((i4 & 14) != 4) | ((i4 & 112) != 32) | composerStartRestartGroup.changedInstance(function2) | ((458752 & i4) != 131072 || ((i4 & 262144) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker))) | ((3670016 & i4) != 1048576) | ((234881024 & i4) != 67108864) | ((1879048192 & i4) != 536870912) | ((i12 & 14) != 4) | ((i4 & 896) != 256) | ((i4 & 7168) != 2048);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                function03 = function02;
                                final boolean z7 = z3;
                                z5 = z4;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                i11 = 0;
                                modifier3 = companion;
                                final float f3 = f2;
                                modifier4 = modifierApplyIfNotNull;
                                objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m13983invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                    }

                                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m13983invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, long j) {
                                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                        final StackComponentState stackComponentState2 = stackComponentState;
                                        final PaywallState.Loaded.Components components2 = components;
                                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function22 = function2;
                                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                                        final float f4 = f3;
                                        final Function0<Unit> function05 = function03;
                                        final boolean z8 = z5;
                                        final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                        final Placeable placeableMo9625measureBRTryo0 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("stack", ComposableLambdaKt.composableLambdaInstance(-486719645, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$stackMeasurable$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i13) {
                                                ComposerKt.sourceInformation(composer3, "C301@14285L367:StackComponentView.kt#280jdz");
                                                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-486719645, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:301)");
                                                    }
                                                    StackComponentViewKt.MainStackComponent(stackComponentState2, components2, function22, paywallComponentInteractionTracker2, f4, null, function05, z8, mutableInteractionSource5, null, false, null, composer3, 0, 6, 2592);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        })))).mo9625measureBRTryo0(j);
                                        final StackComponentStyle stackComponentStyle3 = stackComponentStyle2;
                                        final PaywallState.Loaded.Components components3 = components;
                                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function23 = function2;
                                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
                                        final Placeable placeableMo9625measureBRTryo02 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("badge", ComposableLambdaKt.composableLambdaInstance(1588772072, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$badgeMeasurable$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i13) {
                                                ComposerKt.sourceInformation(composer3, "C317@14846L635:StackComponentView.kt#280jdz");
                                                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1588772072, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:317)");
                                                    }
                                                    StackComponentViewKt.StackComponentView(StackComponentStyle.m14004copyh6c5tkY$default(stackComponentStyle3, null, null, false, new Size(SizeConstraint.Fill.INSTANCE, stackComponentStyle3.getSize().getHeight()), 0.0f, null, null, PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776535, null), components3, function23, null, null, false, null, 0.0f, paywallComponentInteractionTracker3, composer3, 0, 248);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        })))).mo9625measureBRTryo0(j);
                                        int height = placeableMo9625measureBRTryo02.getHeight();
                                        int width = placeableMo9625measureBRTryo0.getWidth();
                                        int height2 = placeableMo9625measureBRTryo0.getHeight() + height;
                                        final StackComponentStyle stackComponentStyle4 = stackComponentStyle2;
                                        final StackComponentState stackComponentState3 = stackComponentState;
                                        final boolean z9 = z7;
                                        final Placeable placeableMo9625measureBRTryo03 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("background", ComposableLambdaKt.composableLambdaInstance(-1793203189, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i13) {
                                                RoundedCornerShape roundedCornerShape;
                                                androidx.compose.p004ui.graphics.Shape rectangleShape;
                                                final RoundedCornerShape rectangleShape2;
                                                RoundedCornerShape roundedCornerShape2;
                                                ComposerKt.sourceInformation(composer3, "C408@20212L399,416@20625L136:StackComponentView.kt#280jdz");
                                                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1793203189, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:340)");
                                                    }
                                                    BackgroundStyles background = stackComponentStyle4.getBackground();
                                                    composer3.startReplaceGroup(-711863226);
                                                    ComposerKt.sourceInformation(composer3, "*340@15934L40");
                                                    BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composer3, 0);
                                                    composer3.endReplaceGroup();
                                                    BorderStyles border = stackComponentStyle4.getBorder();
                                                    composer3.startReplaceGroup(-711860098);
                                                    ComposerKt.sourceInformation(composer3, "*341@16032L32");
                                                    BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composer3, 0);
                                                    composer3.endReplaceGroup();
                                                    ShadowStyles shadow2 = stackComponentStyle4.getShadow();
                                                    composer3.startReplaceGroup(-711857218);
                                                    ComposerKt.sourceInformation(composer3, "*342@16122L32");
                                                    ShadowStyle shadowStyleRememberShadowStyle2 = shadow2 == null ? null : ShadowStyleKt.rememberShadowStyle(shadow2, composer3, 0);
                                                    composer3.endReplaceGroup();
                                                    CornerRadiuses cornerRadiuses = stackComponentStyle4.getShape().getCornerRadiuses();
                                                    if (cornerRadiuses instanceof CornerRadiuses.Percentage) {
                                                        composer3.startReplaceGroup(-592528956);
                                                        ComposerKt.sourceInformation(composer3, "*347@16550L7,348@16659L7,349@16774L7,350@16893L7");
                                                        androidx.compose.p004ui.graphics.Shape shape2 = ShapeKt.toShape(stackComponentStyle4.getShape());
                                                        RoundedCornerShape roundedCornerShape3 = shape2 instanceof RoundedCornerShape ? (RoundedCornerShape) shape2 : null;
                                                        if (roundedCornerShape3 == null) {
                                                            roundedCornerShape2 = null;
                                                        } else {
                                                            Placeable placeable = placeableMo9625measureBRTryo0;
                                                            CornerSize topStart = roundedCornerShape3.getTopStart();
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer3.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            CornerSize cornerSizeMakeAbsolute = StackComponentViewKt.makeAbsolute(topStart, placeable, (Density) objConsume);
                                                            CornerSize topEnd = roundedCornerShape3.getTopEnd();
                                                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer3.consume(localDensity2);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            CornerSize cornerSizeMakeAbsolute2 = StackComponentViewKt.makeAbsolute(topEnd, placeable, (Density) objConsume2);
                                                            CornerSize bottomEnd = roundedCornerShape3.getBottomEnd();
                                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer3.consume(localDensity3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            CornerSize cornerSizeMakeAbsolute3 = StackComponentViewKt.makeAbsolute(bottomEnd, placeable, (Density) objConsume3);
                                                            CornerSize bottomStart = roundedCornerShape3.getBottomStart();
                                                            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume4 = composer3.consume(localDensity4);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            roundedCornerShape2 = new RoundedCornerShape(cornerSizeMakeAbsolute, cornerSizeMakeAbsolute2, cornerSizeMakeAbsolute3, StackComponentViewKt.makeAbsolute(bottomStart, placeable, (Density) objConsume4));
                                                        }
                                                        if (roundedCornerShape2 != null) {
                                                            rectangleShape2 = roundedCornerShape2;
                                                        } else {
                                                            rectangleShape2 = RectangleShapeKt.getRectangleShape();
                                                        }
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        if (!(cornerRadiuses instanceof CornerRadiuses.C7411Dp)) {
                                                            composer3.startReplaceGroup(-712373002);
                                                            composer3.endReplaceGroup();
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        composer3.startReplaceGroup(-591736751);
                                                        ComposerKt.sourceInformation(composer3, "");
                                                        CornerRadiuses cornerRadiuses2 = stackComponentState3.getShape().getCornerRadiuses();
                                                        if (cornerRadiuses2 instanceof CornerRadiuses.C7411Dp) {
                                                            if (z9) {
                                                                CornerRadiuses.C7411Dp c7411Dp = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                CornerRadiuses.C7411Dp c7411Dp2 = (CornerRadiuses.C7411Dp) cornerRadiuses2;
                                                                rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.C7411Dp(c7411Dp.getTopLeading(), c7411Dp.getTopTrailing(), c7411Dp2.getBottomLeading(), c7411Dp2.getBottomTrailing())));
                                                            } else {
                                                                CornerRadiuses.C7411Dp c7411Dp3 = (CornerRadiuses.C7411Dp) cornerRadiuses2;
                                                                CornerRadiuses.C7411Dp c7411Dp4 = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.C7411Dp(c7411Dp3.getTopLeading(), c7411Dp3.getTopTrailing(), c7411Dp4.getBottomLeading(), c7411Dp4.getBottomTrailing())));
                                                            }
                                                        } else if (cornerRadiuses2 instanceof CornerRadiuses.Percentage) {
                                                            androidx.compose.p004ui.graphics.Shape shape3 = ShapeKt.toShape(stackComponentState3.getShape());
                                                            RoundedCornerShape roundedCornerShape4 = shape3 instanceof RoundedCornerShape ? (RoundedCornerShape) shape3 : null;
                                                            if (roundedCornerShape4 == null) {
                                                                roundedCornerShape = null;
                                                            } else {
                                                                boolean z10 = z9;
                                                                Placeable placeable2 = placeableMo9625measureBRTryo0;
                                                                if (z10) {
                                                                    composer3.startReplaceGroup(-10882751);
                                                                    ComposerKt.sourceInformation(composer3, "385@18967L7,389@19229L7");
                                                                    CornerRadiuses.C7411Dp c7411Dp5 = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                    CornerSize cornerSizeM3227CornerSize0680j_4 = CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp5.getTopLeading()));
                                                                    CornerSize cornerSizeM3227CornerSize0680j_42 = CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp5.getTopTrailing()));
                                                                    CornerSize bottomEnd2 = roundedCornerShape4.getBottomEnd();
                                                                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume5 = composer3.consume(localDensity5);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    CornerSize cornerSizeMakeAbsolute4 = StackComponentViewKt.makeAbsolute(bottomEnd2, placeable2, (Density) objConsume5);
                                                                    CornerSize bottomStart2 = roundedCornerShape4.getBottomStart();
                                                                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume6 = composer3.consume(localDensity6);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    roundedCornerShape = new RoundedCornerShape(cornerSizeM3227CornerSize0680j_4, cornerSizeM3227CornerSize0680j_42, cornerSizeMakeAbsolute4, StackComponentViewKt.makeAbsolute(bottomStart2, placeable2, (Density) objConsume6));
                                                                    composer3.endReplaceGroup();
                                                                } else {
                                                                    composer3.startReplaceGroup(-10043612);
                                                                    ComposerKt.sourceInformation(composer3, "396@19620L7,398@19783L7");
                                                                    CornerSize topStart2 = roundedCornerShape4.getTopStart();
                                                                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume7 = composer3.consume(localDensity7);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    CornerSize cornerSizeMakeAbsolute5 = StackComponentViewKt.makeAbsolute(topStart2, placeable2, (Density) objConsume7);
                                                                    CornerSize topEnd2 = roundedCornerShape4.getTopEnd();
                                                                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume8 = composer3.consume(localDensity8);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    CornerRadiuses.C7411Dp c7411Dp6 = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                    roundedCornerShape = new RoundedCornerShape(cornerSizeMakeAbsolute5, StackComponentViewKt.makeAbsolute(topEnd2, placeable2, (Density) objConsume8), CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp6.getBottomTrailing())), CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp6.getBottomLeading())));
                                                                    composer3.endReplaceGroup();
                                                                }
                                                            }
                                                            if (roundedCornerShape != null) {
                                                                rectangleShape2 = roundedCornerShape;
                                                                composer3.endReplaceGroup();
                                                            } else {
                                                                rectangleShape = RectangleShapeKt.getRectangleShape();
                                                            }
                                                        } else {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        rectangleShape2 = rectangleShape;
                                                        composer3.endReplaceGroup();
                                                    }
                                                    composer3.startReplaceGroup(-711725787);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    boolean zChanged3 = composer3.changed(shadowStyleRememberShadowStyle2) | composer3.changed(stackComponentStyle4) | composer3.changed(backgroundStyleRememberBackgroundStyle) | composer3.changed(borderStyleRememberBorderStyle);
                                                    final StackComponentStyle stackComponentStyle5 = stackComponentStyle4;
                                                    Object objRememberedValue4 = composer3.rememberedValue();
                                                    if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue4 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentStyle5.getMargin()), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$1
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                                return BackgroundKt.background(applyIfNotNull, it, rectangleShape2);
                                                            }
                                                        }), rectangleShape2, new Function2<Modifier, androidx.compose.p004ui.graphics.Shape, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$2
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Modifier invoke(Modifier applyIfNotNull, androidx.compose.p004ui.graphics.Shape it) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                                return ClipKt.clip(applyIfNotNull, it);
                                                            }
                                                        }), borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$3
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                                return BorderKt.border(applyIfNotNull, it, ShapeKt.toShape(stackComponentStyle5.getShape()));
                                                            }
                                                        });
                                                        composer3.updateRememberedValue(objRememberedValue4);
                                                    }
                                                    composer3.endReplaceGroup();
                                                    BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then((Modifier) objRememberedValue4), composer3, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        })))).mo9625measureBRTryo0(Constraints.INSTANCE.m10980fixedJhjzzOo(width, height2));
                                        final boolean z10 = z7;
                                        return MeasureScope.layout$default(SubcomposeLayout, width, height2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                invoke2(placementScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Placeable.PlacementScope layout) {
                                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo03, 0, 0, 0.0f, 4, null);
                                                if (z10) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo02, 0, 0, 0.0f, 4, null);
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo0, 0, placeableMo9625measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                    placeableMo9625measureBRTryo0.getHeight();
                                                    return;
                                                }
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo0, 0, 0, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo02, 0, placeableMo9625measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                placeableMo9625measureBRTryo02.getHeight();
                                            }
                                        }, 4, null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                modifier4 = modifierApplyIfNotNull;
                                modifier3 = companion;
                                function03 = function02;
                                z5 = z4;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                i11 = 0;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            SubcomposeLayoutKt.SubcomposeLayout(modifier4, (Function2) objRememberedValue3, composerStartRestartGroup, i11, i11);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function04 = function03;
                            z6 = z5;
                            composer2 = composerStartRestartGroup;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier2 = modifier3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function04 = function0;
                            z6 = z2;
                            composer2 = composerStartRestartGroup;
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithLongEdgeToEdgeBadge.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    StackComponentViewKt.StackWithLongEdgeToEdgeBadge(stackComponentState, components, stackComponentStyle, z, function2, paywallComponentInteractionTracker, f, modifier2, function04, z6, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    f2 = f;
                    i5 = i3 & 128;
                    if (i5 != 0) {
                    }
                    i6 = i3 & 256;
                    if (i6 != 0) {
                    }
                    i7 = i3 & 512;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 1024;
                    if (i8 != 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ShadowStyles shadow2 = stackComponentState.getShadow();
                        composerStartRestartGroup.startReplaceGroup(-2045035647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*292@13896L32");
                        if (shadow2 != null) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Shape shape2 = stackComponentState.getShape();
                        int i122 = i10;
                        composerStartRestartGroup.startReplaceGroup(-2045033531);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(shape2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$composeShape$2$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final androidx.compose.p004ui.graphics.Shape invoke() {
                                    return ShapeKt.toShape(stackComponentState.getShape());
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            state = (State) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-2045028171);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.StackWithLongEdgeToEdgeBadge$lambda$5(state));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(companion, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                                composerStartRestartGroup.startReplaceGroup(-2045019518);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                if ((458752 & i4) != 131072) {
                                    zChangedInstance = ((i4 & 14) != 4) | ((i4 & 112) != 32) | composerStartRestartGroup.changedInstance(function2) | ((458752 & i4) != 131072 || ((i4 & 262144) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker))) | ((3670016 & i4) != 1048576) | ((234881024 & i4) != 67108864) | ((1879048192 & i4) != 536870912) | ((i122 & 14) != 4) | ((i4 & 896) != 256) | ((i4 & 7168) != 2048);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                        function03 = function02;
                                        final boolean z72 = z3;
                                        z5 = z4;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        i11 = 0;
                                        modifier3 = companion;
                                        final float f32 = f2;
                                        modifier4 = modifierApplyIfNotNull;
                                        objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                return m13983invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                            }

                                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                            public final MeasureResult m13983invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, long j) {
                                                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                                final StackComponentState stackComponentState2 = stackComponentState;
                                                final PaywallState.Loaded.Components components2 = components;
                                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22 = function2;
                                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                                                final float f4 = f32;
                                                final Function0<Unit> function05 = function03;
                                                final boolean z8 = z5;
                                                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                                final Placeable placeableMo9625measureBRTryo0 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("stack", ComposableLambdaKt.composableLambdaInstance(-486719645, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$stackMeasurable$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i13) {
                                                        ComposerKt.sourceInformation(composer3, "C301@14285L367:StackComponentView.kt#280jdz");
                                                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-486719645, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:301)");
                                                            }
                                                            StackComponentViewKt.MainStackComponent(stackComponentState2, components2, function22, paywallComponentInteractionTracker2, f4, null, function05, z8, mutableInteractionSource5, null, false, null, composer3, 0, 6, 2592);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                })))).mo9625measureBRTryo0(j);
                                                final StackComponentStyle stackComponentStyle3 = stackComponentStyle2;
                                                final PaywallState.Loaded.Components components3 = components;
                                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function23 = function2;
                                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
                                                final Placeable placeableMo9625measureBRTryo02 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("badge", ComposableLambdaKt.composableLambdaInstance(1588772072, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$badgeMeasurable$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i13) {
                                                        ComposerKt.sourceInformation(composer3, "C317@14846L635:StackComponentView.kt#280jdz");
                                                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1588772072, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:317)");
                                                            }
                                                            StackComponentViewKt.StackComponentView(StackComponentStyle.m14004copyh6c5tkY$default(stackComponentStyle3, null, null, false, new Size(SizeConstraint.Fill.INSTANCE, stackComponentStyle3.getSize().getHeight()), 0.0f, null, null, PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776535, null), components3, function23, null, null, false, null, 0.0f, paywallComponentInteractionTracker3, composer3, 0, 248);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                })))).mo9625measureBRTryo0(j);
                                                int height = placeableMo9625measureBRTryo02.getHeight();
                                                int width = placeableMo9625measureBRTryo0.getWidth();
                                                int height2 = placeableMo9625measureBRTryo0.getHeight() + height;
                                                final StackComponentStyle stackComponentStyle4 = stackComponentStyle2;
                                                final StackComponentState stackComponentState3 = stackComponentState;
                                                final boolean z9 = z72;
                                                final Placeable placeableMo9625measureBRTryo03 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose("background", ComposableLambdaKt.composableLambdaInstance(-1793203189, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i13) {
                                                        RoundedCornerShape roundedCornerShape;
                                                        androidx.compose.p004ui.graphics.Shape rectangleShape;
                                                        final androidx.compose.p004ui.graphics.Shape rectangleShape2;
                                                        RoundedCornerShape roundedCornerShape2;
                                                        ComposerKt.sourceInformation(composer3, "C408@20212L399,416@20625L136:StackComponentView.kt#280jdz");
                                                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1793203189, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithLongEdgeToEdgeBadge.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:340)");
                                                            }
                                                            BackgroundStyles background = stackComponentStyle4.getBackground();
                                                            composer3.startReplaceGroup(-711863226);
                                                            ComposerKt.sourceInformation(composer3, "*340@15934L40");
                                                            BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composer3, 0);
                                                            composer3.endReplaceGroup();
                                                            BorderStyles border = stackComponentStyle4.getBorder();
                                                            composer3.startReplaceGroup(-711860098);
                                                            ComposerKt.sourceInformation(composer3, "*341@16032L32");
                                                            BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composer3, 0);
                                                            composer3.endReplaceGroup();
                                                            ShadowStyles shadow22 = stackComponentStyle4.getShadow();
                                                            composer3.startReplaceGroup(-711857218);
                                                            ComposerKt.sourceInformation(composer3, "*342@16122L32");
                                                            ShadowStyle shadowStyleRememberShadowStyle2 = shadow22 == null ? null : ShadowStyleKt.rememberShadowStyle(shadow22, composer3, 0);
                                                            composer3.endReplaceGroup();
                                                            CornerRadiuses cornerRadiuses = stackComponentStyle4.getShape().getCornerRadiuses();
                                                            if (cornerRadiuses instanceof CornerRadiuses.Percentage) {
                                                                composer3.startReplaceGroup(-592528956);
                                                                ComposerKt.sourceInformation(composer3, "*347@16550L7,348@16659L7,349@16774L7,350@16893L7");
                                                                androidx.compose.p004ui.graphics.Shape shape22 = ShapeKt.toShape(stackComponentStyle4.getShape());
                                                                RoundedCornerShape roundedCornerShape3 = shape22 instanceof RoundedCornerShape ? (RoundedCornerShape) shape22 : null;
                                                                if (roundedCornerShape3 == null) {
                                                                    roundedCornerShape2 = null;
                                                                } else {
                                                                    Placeable placeable = placeableMo9625measureBRTryo0;
                                                                    CornerSize topStart = roundedCornerShape3.getTopStart();
                                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume = composer3.consume(localDensity);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    CornerSize cornerSizeMakeAbsolute = StackComponentViewKt.makeAbsolute(topStart, placeable, (Density) objConsume);
                                                                    CornerSize topEnd = roundedCornerShape3.getTopEnd();
                                                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume2 = composer3.consume(localDensity2);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    CornerSize cornerSizeMakeAbsolute2 = StackComponentViewKt.makeAbsolute(topEnd, placeable, (Density) objConsume2);
                                                                    CornerSize bottomEnd = roundedCornerShape3.getBottomEnd();
                                                                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume3 = composer3.consume(localDensity3);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    CornerSize cornerSizeMakeAbsolute3 = StackComponentViewKt.makeAbsolute(bottomEnd, placeable, (Density) objConsume3);
                                                                    CornerSize bottomStart = roundedCornerShape3.getBottomStart();
                                                                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                    Object objConsume4 = composer3.consume(localDensity4);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                    roundedCornerShape2 = new RoundedCornerShape(cornerSizeMakeAbsolute, cornerSizeMakeAbsolute2, cornerSizeMakeAbsolute3, StackComponentViewKt.makeAbsolute(bottomStart, placeable, (Density) objConsume4));
                                                                }
                                                                if (roundedCornerShape2 != null) {
                                                                    rectangleShape2 = roundedCornerShape2;
                                                                } else {
                                                                    rectangleShape2 = RectangleShapeKt.getRectangleShape();
                                                                }
                                                                composer3.endReplaceGroup();
                                                            } else {
                                                                if (!(cornerRadiuses instanceof CornerRadiuses.C7411Dp)) {
                                                                    composer3.startReplaceGroup(-712373002);
                                                                    composer3.endReplaceGroup();
                                                                    throw new NoWhenBranchMatchedException();
                                                                }
                                                                composer3.startReplaceGroup(-591736751);
                                                                ComposerKt.sourceInformation(composer3, "");
                                                                CornerRadiuses cornerRadiuses2 = stackComponentState3.getShape().getCornerRadiuses();
                                                                if (cornerRadiuses2 instanceof CornerRadiuses.C7411Dp) {
                                                                    if (z9) {
                                                                        CornerRadiuses.C7411Dp c7411Dp = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                        CornerRadiuses.C7411Dp c7411Dp2 = (CornerRadiuses.C7411Dp) cornerRadiuses2;
                                                                        rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.C7411Dp(c7411Dp.getTopLeading(), c7411Dp.getTopTrailing(), c7411Dp2.getBottomLeading(), c7411Dp2.getBottomTrailing())));
                                                                    } else {
                                                                        CornerRadiuses.C7411Dp c7411Dp3 = (CornerRadiuses.C7411Dp) cornerRadiuses2;
                                                                        CornerRadiuses.C7411Dp c7411Dp4 = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                        rectangleShape = ShapeKt.toShape(new Shape.Rectangle(new CornerRadiuses.C7411Dp(c7411Dp3.getTopLeading(), c7411Dp3.getTopTrailing(), c7411Dp4.getBottomLeading(), c7411Dp4.getBottomTrailing())));
                                                                    }
                                                                } else if (cornerRadiuses2 instanceof CornerRadiuses.Percentage) {
                                                                    androidx.compose.p004ui.graphics.Shape shape3 = ShapeKt.toShape(stackComponentState3.getShape());
                                                                    RoundedCornerShape roundedCornerShape4 = shape3 instanceof RoundedCornerShape ? (RoundedCornerShape) shape3 : null;
                                                                    if (roundedCornerShape4 == null) {
                                                                        roundedCornerShape = null;
                                                                    } else {
                                                                        boolean z10 = z9;
                                                                        Placeable placeable2 = placeableMo9625measureBRTryo0;
                                                                        if (z10) {
                                                                            composer3.startReplaceGroup(-10882751);
                                                                            ComposerKt.sourceInformation(composer3, "385@18967L7,389@19229L7");
                                                                            CornerRadiuses.C7411Dp c7411Dp5 = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                            CornerSize cornerSizeM3227CornerSize0680j_4 = CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp5.getTopLeading()));
                                                                            CornerSize cornerSizeM3227CornerSize0680j_42 = CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp5.getTopTrailing()));
                                                                            CornerSize bottomEnd2 = roundedCornerShape4.getBottomEnd();
                                                                            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                            Object objConsume5 = composer3.consume(localDensity5);
                                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                            CornerSize cornerSizeMakeAbsolute4 = StackComponentViewKt.makeAbsolute(bottomEnd2, placeable2, (Density) objConsume5);
                                                                            CornerSize bottomStart2 = roundedCornerShape4.getBottomStart();
                                                                            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                            Object objConsume6 = composer3.consume(localDensity6);
                                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                            roundedCornerShape = new RoundedCornerShape(cornerSizeM3227CornerSize0680j_4, cornerSizeM3227CornerSize0680j_42, cornerSizeMakeAbsolute4, StackComponentViewKt.makeAbsolute(bottomStart2, placeable2, (Density) objConsume6));
                                                                            composer3.endReplaceGroup();
                                                                        } else {
                                                                            composer3.startReplaceGroup(-10043612);
                                                                            ComposerKt.sourceInformation(composer3, "396@19620L7,398@19783L7");
                                                                            CornerSize topStart2 = roundedCornerShape4.getTopStart();
                                                                            ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                            Object objConsume7 = composer3.consume(localDensity7);
                                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                            CornerSize cornerSizeMakeAbsolute5 = StackComponentViewKt.makeAbsolute(topStart2, placeable2, (Density) objConsume7);
                                                                            CornerSize topEnd2 = roundedCornerShape4.getTopEnd();
                                                                            ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                                                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                                            Object objConsume8 = composer3.consume(localDensity8);
                                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                            CornerRadiuses.C7411Dp c7411Dp6 = (CornerRadiuses.C7411Dp) cornerRadiuses;
                                                                            roundedCornerShape = new RoundedCornerShape(cornerSizeMakeAbsolute5, StackComponentViewKt.makeAbsolute(topEnd2, placeable2, (Density) objConsume8), CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp6.getBottomTrailing())), CornerSizeKt.m3227CornerSize0680j_4(C1486Dp.m11017constructorimpl((float) c7411Dp6.getBottomLeading())));
                                                                            composer3.endReplaceGroup();
                                                                        }
                                                                    }
                                                                    if (roundedCornerShape != null) {
                                                                        rectangleShape2 = roundedCornerShape;
                                                                        composer3.endReplaceGroup();
                                                                    } else {
                                                                        rectangleShape = RectangleShapeKt.getRectangleShape();
                                                                    }
                                                                } else {
                                                                    throw new NoWhenBranchMatchedException();
                                                                }
                                                                rectangleShape2 = rectangleShape;
                                                                composer3.endReplaceGroup();
                                                            }
                                                            composer3.startReplaceGroup(-711725787);
                                                            ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                            boolean zChanged3 = composer3.changed(shadowStyleRememberShadowStyle2) | composer3.changed(stackComponentStyle4) | composer3.changed(backgroundStyleRememberBackgroundStyle) | composer3.changed(borderStyleRememberBorderStyle);
                                                            final StackComponentStyle stackComponentStyle5 = stackComponentStyle4;
                                                            Object objRememberedValue4 = composer3.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                objRememberedValue4 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentStyle5.getMargin()), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$1
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                        Intrinsics.checkNotNullParameter(it, "it");
                                                                        return BackgroundKt.background(applyIfNotNull, it, rectangleShape2);
                                                                    }
                                                                }), rectangleShape2, new Function2<Modifier, androidx.compose.p004ui.graphics.Shape, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$2
                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Modifier invoke(Modifier applyIfNotNull, androidx.compose.p004ui.graphics.Shape it) {
                                                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                        Intrinsics.checkNotNullParameter(it, "it");
                                                                        return ClipKt.clip(applyIfNotNull, it);
                                                                    }
                                                                }), borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1$backgroundMeasurable$1$backgroundModifier$1$3
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                        Intrinsics.checkNotNullParameter(it, "it");
                                                                        return BorderKt.border(applyIfNotNull, it, ShapeKt.toShape(stackComponentStyle5.getShape()));
                                                                    }
                                                                });
                                                                composer3.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            composer3.endReplaceGroup();
                                                            BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then((Modifier) objRememberedValue4), composer3, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                })))).mo9625measureBRTryo0(Constraints.INSTANCE.m10980fixedJhjzzOo(width, height2));
                                                final boolean z10 = z72;
                                                return MeasureScope.layout$default(SubcomposeLayout, width, height2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackWithLongEdgeToEdgeBadge$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                        invoke2(placementScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(Placeable.PlacementScope layout) {
                                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo03, 0, 0, 0.0f, 4, null);
                                                        if (z10) {
                                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo02, 0, 0, 0.0f, 4, null);
                                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo0, 0, placeableMo9625measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                            placeableMo9625measureBRTryo0.getHeight();
                                                            return;
                                                        }
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo0, 0, 0, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo02, 0, placeableMo9625measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                        placeableMo9625measureBRTryo02.getHeight();
                                                    }
                                                }, 4, null);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        composerStartRestartGroup.endReplaceGroup();
                                        SubcomposeLayoutKt.SubcomposeLayout(modifier4, (Function2) objRememberedValue3, composerStartRestartGroup, i11, i11);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        function04 = function03;
                                        z6 = z5;
                                        composer2 = composerStartRestartGroup;
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                        modifier2 = modifier3;
                                    }
                                }
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z;
                if ((i3 & 16) == 0) {
                }
                if ((i3 & 32) == 0) {
                }
                if ((i3 & 64) != 0) {
                }
                f2 = f;
                i5 = i3 & 128;
                if (i5 != 0) {
                }
                i6 = i3 & 256;
                if (i6 != 0) {
                }
                i7 = i3 & 512;
                if (i7 != 0) {
                }
                i8 = i3 & 1024;
                if (i8 != 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            stackComponentStyle2 = stackComponentStyle;
            if ((i3 & 8) != 0) {
            }
            z3 = z;
            if ((i3 & 16) == 0) {
            }
            if ((i3 & 32) == 0) {
            }
            if ((i3 & 64) != 0) {
            }
            f2 = f;
            i5 = i3 & 128;
            if (i5 != 0) {
            }
            i6 = i3 & 256;
            if (i6 != 0) {
            }
            i7 = i3 & 512;
            if (i7 != 0) {
            }
            i8 = i3 & 1024;
            if (i8 != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        stackComponentStyle2 = stackComponentStyle;
        if ((i3 & 8) != 0) {
        }
        z3 = z;
        if ((i3 & 16) == 0) {
        }
        if ((i3 & 32) == 0) {
        }
        if ((i3 & 64) != 0) {
        }
        f2 = f;
        i5 = i3 & 128;
        if (i5 != 0) {
        }
        i6 = i3 & 256;
        if (i6 != 0) {
        }
        i7 = i3 & 512;
        if (i7 != 0) {
        }
        i8 = i3 & 1024;
        if (i8 != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackWithShortEdgeToEdgeBadge(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final StackComponentStyle stackComponentStyle, final TwoDimensionalAlignment twoDimensionalAlignment, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final PaywallComponentInteractionTracker paywallComponentInteractionTracker, final float f, Modifier modifier, Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        StackComponentStyle stackComponentStyle2;
        TwoDimensionalAlignment twoDimensionalAlignment2;
        Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22;
        float f2;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        CornerRadiuses cornerRadiuses;
        CornerRadiuses.C7411Dp c7411Dp;
        CornerRadiuses.C7411Dp c7411Dp2;
        final Function0<Unit> function02;
        final boolean z2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        CornerRadiuses.Percentage percentage;
        CornerRadiuses.Percentage percentage2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1943778097);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackWithShortEdgeToEdgeBadge)P(9,10,1!4,7,8)544@25346L303,534@24983L666:StackComponentView.kt#280jdz");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(stackComponentState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(components) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    stackComponentStyle2 = stackComponentStyle;
                    i4 |= composerStartRestartGroup.changed(stackComponentStyle2) ? 256 : 128;
                }
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        twoDimensionalAlignment2 = twoDimensionalAlignment;
                        i4 |= composerStartRestartGroup.changed(twoDimensionalAlignment2) ? 2048 : 1024;
                    }
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            function22 = function2;
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        }
                        if ((i3 & 32) != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i4 |= (262144 & i) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker) ? 131072 : 65536;
                        }
                        if ((i3 & 64) != 0) {
                            i4 |= 1572864;
                        } else {
                            if ((i & 1572864) == 0) {
                                f2 = f;
                                i4 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
                            }
                            i5 = i3 & 128;
                            if (i5 != 0) {
                                if ((12582912 & i) == 0) {
                                    modifier2 = modifier;
                                    i4 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
                                }
                                i6 = i3 & 256;
                                if (i6 != 0) {
                                    i4 |= 100663296;
                                } else if ((i & 100663296) == 0) {
                                    i4 |= composerStartRestartGroup.changedInstance(function0) ? 67108864 : 33554432;
                                }
                                i7 = i3 & 512;
                                if (i7 != 0) {
                                    i4 |= 805306368;
                                } else if ((i & 805306368) == 0) {
                                    i4 |= composerStartRestartGroup.changed(z) ? 536870912 : 268435456;
                                }
                                i8 = i3 & 1024;
                                if (i8 != 0) {
                                    i10 = i2 | 6;
                                    i9 = i8;
                                } else if ((i2 & 6) == 0) {
                                    i9 = i8;
                                    i10 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i9 = i8;
                                    i10 = i2;
                                }
                                if ((i4 & 306783379) != 306783378 || (i10 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
                                    if (i5 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    Function0<Unit> function03 = i6 == 0 ? null : function0;
                                    boolean z3 = i7 == 0 ? true : z;
                                    MutableInteractionSource mutableInteractionSource3 = i9 == 0 ? null : mutableInteractionSource;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1943778097, i4, i10, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithShortEdgeToEdgeBadge (StackComponentView.kt:464)");
                                    }
                                    cornerRadiuses = stackComponentStyle2.getShape().getCornerRadiuses();
                                    if (!(cornerRadiuses instanceof CornerRadiuses.Percentage)) {
                                        int i11 = WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment2.ordinal()];
                                        if (i11 == 3) {
                                            percentage = new CornerRadiuses.Percentage(0, 0, 0, ((CornerRadiuses.Percentage) cornerRadiuses).getBottomTrailing());
                                        } else if (i11 == 4) {
                                            percentage = new CornerRadiuses.Percentage(0, 0, ((CornerRadiuses.Percentage) cornerRadiuses).getBottomLeading(), 0);
                                        } else if (i11 == 5) {
                                            percentage = new CornerRadiuses.Percentage(0, ((CornerRadiuses.Percentage) cornerRadiuses).getTopTrailing(), 0, 0);
                                        } else if (i11 == 6) {
                                            percentage = new CornerRadiuses.Percentage(((CornerRadiuses.Percentage) cornerRadiuses).getTopLeading(), 0, 0, 0);
                                        } else {
                                            percentage2 = new CornerRadiuses.Percentage(0);
                                            c7411Dp2 = percentage2;
                                        }
                                        percentage2 = percentage;
                                        c7411Dp2 = percentage2;
                                    } else if (cornerRadiuses instanceof CornerRadiuses.C7411Dp) {
                                        int i12 = WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment2.ordinal()];
                                        if (i12 == 3) {
                                            c7411Dp = new CornerRadiuses.C7411Dp(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ((CornerRadiuses.C7411Dp) cornerRadiuses).getBottomTrailing());
                                        } else if (i12 == 4) {
                                            c7411Dp = new CornerRadiuses.C7411Dp(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ((CornerRadiuses.C7411Dp) cornerRadiuses).getBottomLeading(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                        } else if (i12 == 5) {
                                            c7411Dp = new CornerRadiuses.C7411Dp(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ((CornerRadiuses.C7411Dp) cornerRadiuses).getTopTrailing(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                        } else if (i12 == 6) {
                                            c7411Dp = new CornerRadiuses.C7411Dp(((CornerRadiuses.C7411Dp) cornerRadiuses).getTopLeading(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                        } else {
                                            c7411Dp = new CornerRadiuses.C7411Dp(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                        }
                                        c7411Dp2 = c7411Dp;
                                    } else {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    final CornerRadiuses cornerRadiuses2 = c7411Dp2;
                                    final TwoDimensionalAlignment twoDimensionalAlignment3 = twoDimensionalAlignment2;
                                    int i13 = i4;
                                    final StackComponentStyle stackComponentStyle3 = stackComponentStyle2;
                                    final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function23 = function22;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1856366451, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithShortEdgeToEdgeBadge.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                                            invoke(boxScope, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(BoxScope MainStackComponent, Composer composer2, int i14) {
                                            int i15;
                                            Intrinsics.checkNotNullParameter(MainStackComponent, "$this$MainStackComponent");
                                            ComposerKt.sourceInformation(composer2, "C545@25356L287:StackComponentView.kt#280jdz");
                                            if ((i14 & 6) == 0) {
                                                i15 = i14 | (composer2.changed(MainStackComponent) ? 4 : 2);
                                            } else {
                                                i15 = i14;
                                            }
                                            if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1856366451, i15, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithShortEdgeToEdgeBadge.<anonymous> (StackComponentView.kt:545)");
                                                }
                                                StackComponentViewKt.StackComponentView(StackComponentStyle.m14004copyh6c5tkY$default(stackComponentStyle3, null, null, false, null, 0.0f, null, null, null, new Shape.Rectangle(cornerRadiuses2), null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776959, null), components, function23, MainStackComponent.align(Modifier.INSTANCE, AlignmentKt.toAlignment(twoDimensionalAlignment3)), null, false, null, 0.0f, paywallComponentInteractionTracker, composer2, 0, PsExtractor.VIDEO_STREAM_MASK);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }, composerStartRestartGroup, 54);
                                    int i14 = i13 >> 6;
                                    int i15 = (i13 & WebSocketProtocol.PAYLOAD_SHORT) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128) | ((i10 << 24) & 234881024);
                                    Function0<Unit> function04 = function03;
                                    Modifier modifier4 = modifier2;
                                    boolean z4 = z3;
                                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                    MainStackComponent(stackComponentState, components, function2, paywallComponentInteractionTracker, f2, modifier4, function04, z4, mutableInteractionSource4, null, false, composableLambdaRememberComposableLambda, composerStartRestartGroup, i15, 48, 1536);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function02 = function04;
                                    z2 = z4;
                                    mutableInteractionSource2 = mutableInteractionSource4;
                                    modifier3 = modifier4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function02 = function0;
                                    z2 = z;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    modifier3 = modifier2;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithShortEdgeToEdgeBadge.2
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

                                        public final void invoke(Composer composer2, int i16) {
                                            StackComponentViewKt.StackWithShortEdgeToEdgeBadge(stackComponentState, components, stackComponentStyle, twoDimensionalAlignment, function2, paywallComponentInteractionTracker, f, modifier3, function02, z2, mutableInteractionSource2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i4 |= 12582912;
                            modifier2 = modifier;
                            i6 = i3 & 256;
                            if (i6 != 0) {
                            }
                            i7 = i3 & 512;
                            if (i7 != 0) {
                            }
                            i8 = i3 & 1024;
                            if (i8 != 0) {
                            }
                            if ((i4 & 306783379) != 306783378) {
                                if (i5 != 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i9 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                cornerRadiuses = stackComponentStyle2.getShape().getCornerRadiuses();
                                if (!(cornerRadiuses instanceof CornerRadiuses.Percentage)) {
                                }
                                final CornerRadiuses cornerRadiuses22 = c7411Dp2;
                                final TwoDimensionalAlignment twoDimensionalAlignment32 = twoDimensionalAlignment2;
                                int i132 = i4;
                                final StackComponentStyle stackComponentStyle32 = stackComponentStyle2;
                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function232 = function22;
                                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1856366451, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithShortEdgeToEdgeBadge.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                                        invoke(boxScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope MainStackComponent, Composer composer2, int i142) {
                                        int i152;
                                        Intrinsics.checkNotNullParameter(MainStackComponent, "$this$MainStackComponent");
                                        ComposerKt.sourceInformation(composer2, "C545@25356L287:StackComponentView.kt#280jdz");
                                        if ((i142 & 6) == 0) {
                                            i152 = i142 | (composer2.changed(MainStackComponent) ? 4 : 2);
                                        } else {
                                            i152 = i142;
                                        }
                                        if ((i152 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1856366451, i152, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackWithShortEdgeToEdgeBadge.<anonymous> (StackComponentView.kt:545)");
                                            }
                                            StackComponentViewKt.StackComponentView(StackComponentStyle.m14004copyh6c5tkY$default(stackComponentStyle32, null, null, false, null, 0.0f, null, null, null, new Shape.Rectangle(cornerRadiuses22), null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16776959, null), components, function232, MainStackComponent.align(Modifier.INSTANCE, AlignmentKt.toAlignment(twoDimensionalAlignment32)), null, false, null, 0.0f, paywallComponentInteractionTracker, composer2, 0, PsExtractor.VIDEO_STREAM_MASK);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }, composerStartRestartGroup, 54);
                                int i142 = i132 >> 6;
                                int i152 = (i132 & WebSocketProtocol.PAYLOAD_SHORT) | (i142 & 896) | (i142 & 7168) | (57344 & i142) | (458752 & i142) | (3670016 & i142) | (i142 & 29360128) | ((i10 << 24) & 234881024);
                                Function0<Unit> function042 = function03;
                                Modifier modifier42 = modifier2;
                                boolean z42 = z3;
                                MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource3;
                                MainStackComponent(stackComponentState, components, function2, paywallComponentInteractionTracker, f2, modifier42, function042, z42, mutableInteractionSource42, null, false, composableLambdaRememberComposableLambda2, composerStartRestartGroup, i152, 48, 1536);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function02 = function042;
                                z2 = z42;
                                mutableInteractionSource2 = mutableInteractionSource42;
                                modifier3 = modifier42;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        f2 = f;
                        i5 = i3 & 128;
                        if (i5 != 0) {
                        }
                        modifier2 = modifier;
                        i6 = i3 & 256;
                        if (i6 != 0) {
                        }
                        i7 = i3 & 512;
                        if (i7 != 0) {
                        }
                        i8 = i3 & 1024;
                        if (i8 != 0) {
                        }
                        if ((i4 & 306783379) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    function22 = function2;
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    f2 = f;
                    i5 = i3 & 128;
                    if (i5 != 0) {
                    }
                    modifier2 = modifier;
                    i6 = i3 & 256;
                    if (i6 != 0) {
                    }
                    i7 = i3 & 512;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 1024;
                    if (i8 != 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                twoDimensionalAlignment2 = twoDimensionalAlignment;
                if ((i3 & 16) == 0) {
                }
                function22 = function2;
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                f2 = f;
                i5 = i3 & 128;
                if (i5 != 0) {
                }
                modifier2 = modifier;
                i6 = i3 & 256;
                if (i6 != 0) {
                }
                i7 = i3 & 512;
                if (i7 != 0) {
                }
                i8 = i3 & 1024;
                if (i8 != 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            stackComponentStyle2 = stackComponentStyle;
            if ((i3 & 8) != 0) {
            }
            twoDimensionalAlignment2 = twoDimensionalAlignment;
            if ((i3 & 16) == 0) {
            }
            function22 = function2;
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            f2 = f;
            i5 = i3 & 128;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 256;
            if (i6 != 0) {
            }
            i7 = i3 & 512;
            if (i7 != 0) {
            }
            i8 = i3 & 1024;
            if (i8 != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        stackComponentStyle2 = stackComponentStyle;
        if ((i3 & 8) != 0) {
        }
        twoDimensionalAlignment2 = twoDimensionalAlignment;
        if ((i3 & 16) == 0) {
        }
        function22 = function2;
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        f2 = f;
        i5 = i3 & 128;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 256;
        if (i6 != 0) {
        }
        i7 = i3 & 512;
        if (i7 != 0) {
        }
        i8 = i3 & 1024;
        if (i8 != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OverlaidBadge(final BoxScope boxScope, final StackComponentStyle stackComponentStyle, final PaywallState.Loaded.Components components, final PaywallComponentInteractionTracker paywallComponentInteractionTracker, final TwoDimensionalAlignment twoDimensionalAlignment, final Float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        PaywallState.Loaded.Components components2;
        int i4;
        Modifier modifier2;
        boolean z;
        Object objRememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(945559375);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OverlaidBadge)P(1,5,2)572@26226L394,565@26000L627:StackComponentView.kt#280jdz");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(stackComponentStyle) ? 32 : 16;
            }
            if ((i2 & 2) == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    components2 = components;
                    i3 |= composerStartRestartGroup.changed(components2) ? 256 : 128;
                }
                if ((i2 & 4) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker) ? 2048 : 1024;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changed(twoDimensionalAlignment) ? 16384 : 8192;
                }
                if ((i2 & 16) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                    i3 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
                }
                i4 = i2 & 32;
                if (i4 == 0) {
                    if ((1572864 & i) == 0) {
                        modifier2 = modifier;
                        i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
                    }
                    if ((599187 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(945559375, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.OverlaidBadge (StackComponentView.kt:564)");
                        }
                        Modifier modifierAlign = boxScope.align(companion, AlignmentKt.toAlignment(twoDimensionalAlignment));
                        composerStartRestartGroup.startReplaceGroup(-827702348);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                        z = ((57344 & i3) != 16384) | ((458752 & i3) == 131072);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                    return m13982invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                }

                                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m13982invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                                    final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j);
                                    int width = placeableMo9625measureBRTryo0.getWidth();
                                    int height = placeableMo9625measureBRTryo0.getHeight();
                                    final TwoDimensionalAlignment twoDimensionalAlignment2 = twoDimensionalAlignment;
                                    final Float f2 = f;
                                    return MeasureScope.layout$default(layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope layout2) {
                                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                                            Placeable placeable = placeableMo9625measureBRTryo0;
                                            int height2 = placeable.getHeight();
                                            TwoDimensionalAlignment twoDimensionalAlignment3 = twoDimensionalAlignment2;
                                            Float f3 = f2;
                                            Placeable.PlacementScope.placeRelative$default(layout2, placeable, 0, StackComponentViewKt.getOverlaidBadgeOffsetY(height2, twoDimensionalAlignment3, f3 != null ? f3.floatValue() : 0.0f), 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierLayout = LayoutModifierKt.layout(modifierAlign, (Function3) objRememberedValue);
                        int i5 = i3 >> 3;
                        Modifier modifier4 = companion;
                        StackComponentView(stackComponentStyle, components2, new C76962(null), modifierLayout, null, false, null, 0.0f, paywallComponentInteractionTracker, composerStartRestartGroup, (i5 & 112) | (i5 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i3 << 15) & 234881024), PsExtractor.VIDEO_STREAM_MASK);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.OverlaidBadge.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i6) {
                                StackComponentViewKt.OverlaidBadge(boxScope, stackComponentStyle, components, paywallComponentInteractionTracker, twoDimensionalAlignment, f, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 1572864;
                modifier2 = modifier;
                if ((599187 & i3) == 599186) {
                    if (i4 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier modifierAlign2 = boxScope.align(companion, AlignmentKt.toAlignment(twoDimensionalAlignment));
                    composerStartRestartGroup.startReplaceGroup(-827702348);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                    z = ((57344 & i3) != 16384) | ((458752 & i3) == 131072);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m13982invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m13982invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Intrinsics.checkNotNullParameter(measurable, "measurable");
                                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j);
                                int width = placeableMo9625measureBRTryo0.getWidth();
                                int height = placeableMo9625measureBRTryo0.getHeight();
                                final TwoDimensionalAlignment twoDimensionalAlignment2 = twoDimensionalAlignment;
                                final Float f2 = f;
                                return MeasureScope.layout$default(layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope layout2) {
                                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                                        Placeable placeable = placeableMo9625measureBRTryo0;
                                        int height2 = placeable.getHeight();
                                        TwoDimensionalAlignment twoDimensionalAlignment3 = twoDimensionalAlignment2;
                                        Float f3 = f2;
                                        Placeable.PlacementScope.placeRelative$default(layout2, placeable, 0, StackComponentViewKt.getOverlaidBadgeOffsetY(height2, twoDimensionalAlignment3, f3 != null ? f3.floatValue() : 0.0f), 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierLayout2 = LayoutModifierKt.layout(modifierAlign2, (Function3) objRememberedValue);
                        int i52 = i3 >> 3;
                        Modifier modifier42 = companion;
                        StackComponentView(stackComponentStyle, components2, new C76962(null), modifierLayout2, null, false, null, 0.0f, paywallComponentInteractionTracker, composerStartRestartGroup, (i52 & 112) | (i52 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i3 << 15) & 234881024), PsExtractor.VIDEO_STREAM_MASK);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            components2 = components;
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            i4 = i2 & 32;
            if (i4 == 0) {
            }
            modifier2 = modifier;
            if ((599187 & i3) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 2) == 0) {
        }
        components2 = components;
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        if ((599187 & i3) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C76962 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C76962(Continuation<? super C76962> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C76962(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C76962) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0937  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x094c  */
    /* JADX WARN: Removed duplicated region for block: B:305:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MainStackComponent(final StackComponentState stackComponentState, final PaywallState.Loaded.Components components, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, final PaywallComponentInteractionTracker paywallComponentInteractionTracker, final float f, Modifier modifier, Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, BadgeStyle badgeStyle, boolean z2, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        PaywallState.Loaded.Components components2;
        Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22;
        float f2;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        boolean z3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z4;
        boolean zChanged;
        Object objRememberedValue;
        int i18;
        ShadowStyle shadowStyleRememberShadowStyle;
        boolean zChanged2;
        int i19;
        boolean zChanged3;
        Object objRememberedValue2;
        boolean zChanged4;
        Object objRememberedValue3;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Function0<Unit> function02;
        Modifier.Companion companionM2058clickableO2vRcR0$default;
        MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier4;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32;
        Composer composer2;
        final Modifier modifier5;
        final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function33;
        final BadgeStyle badgeStyle2;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z6;
        final Function0<Unit> function03;
        ShadowStyles shadow;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1697950038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainStackComponent)P(10,11!3,5,7!3,9)600@27310L11,606@27728L8367,753@36219L76,761@36555L251,768@36833L195,776@37059L99:StackComponentView.kt#280jdz");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(stackComponentState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                components2 = components;
                i4 |= composerStartRestartGroup.changed(components2) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function22 = function2;
                    i4 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
                }
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker) ? 2048 : 1024;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        f2 = f;
                        i4 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                    }
                    i5 = i3 & 32;
                    if (i5 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else {
                        if ((196608 & i) == 0) {
                            modifier2 = modifier;
                            i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                        }
                        i6 = i3 & 64;
                        if (i6 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
                        }
                        i7 = i3 & 128;
                        if (i7 != 0) {
                            i4 |= 12582912;
                            z3 = z;
                        } else {
                            z3 = z;
                            if ((i & 12582912) == 0) {
                                i4 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                            }
                        }
                        i8 = i3 & 256;
                        if (i8 == 0) {
                            if ((i & 100663296) == 0) {
                                i9 = i4 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432);
                            }
                            i10 = i3 & 512;
                            if (i10 == 0) {
                                i9 |= 805306368;
                                i11 = i10;
                            } else if ((i & 805306368) == 0) {
                                i11 = i10;
                                i9 |= composerStartRestartGroup.changed(badgeStyle) ? 536870912 : 268435456;
                            } else {
                                i11 = i10;
                            }
                            i12 = i9;
                            i13 = i3 & 1024;
                            if (i13 == 0) {
                                i15 = i2 | 6;
                                i14 = i13;
                            } else if ((i2 & 6) == 0) {
                                i14 = i13;
                                i15 = i2 | (composerStartRestartGroup.changed(z2) ? 4 : 2);
                            } else {
                                i14 = i13;
                                i15 = i2;
                            }
                            i16 = i3 & 2048;
                            if (i16 == 0) {
                                i15 |= 48;
                                i17 = i16;
                            } else if ((i2 & 48) == 0) {
                                i17 = i16;
                                i15 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
                            } else {
                                i17 = i16;
                            }
                            int i20 = i15;
                            if ((i12 & 306783379) == 306783378 || (i20 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
                                Modifier modifier6 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                                Function0<Unit> function04 = i6 == 0 ? null : function0;
                                boolean z7 = i7 == 0 ? true : z3;
                                MutableInteractionSource mutableInteractionSource5 = i8 == 0 ? null : mutableInteractionSource;
                                BadgeStyle badgeStyle3 = i11 == 0 ? null : badgeStyle;
                                z4 = i14 == 0 ? true : z2;
                                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function34 = i17 == 0 ? null : function3;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1697950038, i12, i20, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent (StackComponentView.kt:599)");
                                }
                                final WindowInsets safeDrawing = WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6);
                                final PaywallState.Loaded.Components components3 = components2;
                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function23 = function22;
                                final float f3 = f2;
                                final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1884046896, true, new Function4<Modifier, Modifier, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier7, Modifier modifier8, Composer composer3, Integer num) {
                                        invoke(modifier7, modifier8, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
                                    /* JADX WARN: Removed duplicated region for block: B:51:0x0178  */
                                    /* JADX WARN: Removed duplicated region for block: B:56:0x01d7  */
                                    /* JADX WARN: Removed duplicated region for block: B:72:0x025f  */
                                    /* JADX WARN: Removed duplicated region for block: B:75:0x02be  */
                                    /* JADX WARN: Removed duplicated region for block: B:80:0x031d  */
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final void invoke(Modifier outerModifier, Modifier rootModifier, Composer composer3, int i21) {
                                        Composer composer4;
                                        final int top;
                                        Object objRememberedValue4;
                                        final MutableState mutableState;
                                        Object objRememberedValue5;
                                        boolean zChanged5;
                                        final StackComponentState stackComponentState2;
                                        final WindowInsets windowInsets;
                                        final float f4;
                                        final PaywallState.Loaded.Components components4;
                                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function24;
                                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
                                        Object objRememberedValue6;
                                        Object objRememberedValue7;
                                        final MutableState mutableState2;
                                        Object objRememberedValue8;
                                        boolean zChanged6;
                                        final StackComponentState stackComponentState3;
                                        final WindowInsets windowInsets2;
                                        final float f5;
                                        final PaywallState.Loaded.Components components5;
                                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function25;
                                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3;
                                        Object objRememberedValue9;
                                        Intrinsics.checkNotNullParameter(outerModifier, "outerModifier");
                                        Intrinsics.checkNotNullParameter(rootModifier, "rootModifier");
                                        ComposerKt.sourceInformation(composer3, "C:StackComponentView.kt#280jdz");
                                        int i22 = (i21 & 6) == 0 ? i21 | (composer3.changed(outerModifier) ? 4 : 2) : i21;
                                        if ((i21 & 48) == 0) {
                                            i22 |= composer3.changed(rootModifier) ? 32 : 16;
                                        }
                                        if ((i22 & 147) != 146 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1884046896, i22, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous> (StackComponentView.kt:607)");
                                            }
                                            Orientation scrollOrientation = stackComponentState.getScrollOrientation();
                                            composer3.startReplaceGroup(-957953601);
                                            ComposerKt.sourceInformation(composer3, "*607@27823L21");
                                            boolean z8 = true;
                                            ScrollState scrollStateRememberScrollState = scrollOrientation == null ? null : ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                            composer3.endReplaceGroup();
                                            if (stackComponentState.getChildren().isEmpty()) {
                                                composer3.startReplaceGroup(368497433);
                                                ComposerKt.sourceInformation(composer3, "612@28117L143");
                                                BoxKt.Box(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), null, null, 6, null).then(rootModifier), composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(368906075);
                                                ComposerKt.sourceInformation(composer3, "");
                                                Dimension dimension = stackComponentState.getDimension();
                                                if (dimension instanceof Dimension.Horizontal) {
                                                    composer3.startReplaceGroup(368839084);
                                                    ComposerKt.sourceInformation(composer3, "624@28775L34,635@29463L143,638@29630L1087,625@28830L1887");
                                                    List children = stackComponentState.getChildren();
                                                    if (!(children instanceof Collection) || !children.isEmpty()) {
                                                        Iterator it = children.iterator();
                                                        while (it.hasNext()) {
                                                            if (Intrinsics.areEqual(((ComponentStyle) it.next()).getSize().getWidth(), SizeConstraint.Fill.INSTANCE)) {
                                                                break;
                                                            }
                                                        }
                                                        z8 = false;
                                                        composer3.startReplaceGroup(-957922940);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue7 = composer3.rememberedValue();
                                                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                                            composer3.updateRememberedValue(objRememberedValue7);
                                                        }
                                                        mutableState2 = (MutableState) objRememberedValue7;
                                                        composer3.endReplaceGroup();
                                                        Size size = stackComponentState.getSize();
                                                        Dimension.Horizontal horizontal = (Dimension.Horizontal) dimension;
                                                        float fM13979getSpacingD9Ej5fM = stackComponentState.m13979getSpacingD9Ej5fM();
                                                        Modifier modifierThen = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), null, AlignmentKt.toAlignment(horizontal.getAlignment()), 2, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.1
                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Modifier invoke(Modifier applyIfNotNull, ScrollState state, Orientation orientation) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(state, "state");
                                                                Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                                return ScrollableKt.scrollable(applyIfNotNull, state, orientation);
                                                            }
                                                        }).then(rootModifier);
                                                        composer3.startReplaceGroup(-957900815);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue8 = composer3.rememberedValue();
                                                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue8 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Modifier invoke(Modifier conditional) {
                                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                    return ModifierExtensionsKt.trackMainAxisUnbounded(conditional, true, mutableState2);
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue8);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierThen, z8, (Function1) objRememberedValue8);
                                                        composer3.startReplaceGroup(-957894527);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        zChanged6 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing) | composer3.changed(f3) | composer3.changed(components3) | composer3.changedInstance(function23) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                        stackComponentState3 = stackComponentState;
                                                        windowInsets2 = safeDrawing;
                                                        f5 = f3;
                                                        components5 = components3;
                                                        function25 = function23;
                                                        paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
                                                        objRememberedValue9 = composer3.rememberedValue();
                                                        if (!zChanged6 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue9 = (Function1) new Function1<HorizontalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(HorizontalStackScope horizontalStackScope) {
                                                                    invoke2(horizontalStackScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(HorizontalStackScope HorizontalStack) {
                                                                    Intrinsics.checkNotNullParameter(HorizontalStack, "$this$HorizontalStack");
                                                                    List children2 = stackComponentState3.getChildren();
                                                                    final MutableState<Boolean> mutableState3 = mutableState2;
                                                                    final StackComponentState stackComponentState4 = stackComponentState3;
                                                                    final WindowInsets windowInsets3 = windowInsets2;
                                                                    final float f6 = f5;
                                                                    final PaywallState.Loaded.Components components6 = components5;
                                                                    final Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function25;
                                                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                                                                    HorizontalStack.items(children2, ComposableLambdaKt.composableLambdaInstance(1874260288, true, new Function5<RowScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(5);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function5
                                                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                            invoke(rowScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(final RowScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                            int i25;
                                                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                            Intrinsics.checkNotNullParameter(child, "child");
                                                                            ComposerKt.sourceInformation(composer5, "C646@30136L99,651@30435L146,640@29725L944:StackComponentView.kt#280jdz");
                                                                            if ((i24 & 6) == 0) {
                                                                                i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                            } else {
                                                                                i25 = i24;
                                                                            }
                                                                            if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                                i25 |= composer5.changed(child) ? 256 : 128;
                                                                            }
                                                                            if ((i25 & 1155) != 1154 || !composer5.getSkipping()) {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1874260288, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:640)");
                                                                                }
                                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                                boolean z9 = Intrinsics.areEqual(child.getSize().getWidth(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                                composer5.startReplaceGroup(-1700346526);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean z10 = (i25 & 14) == 4;
                                                                                Object objRememberedValue10 = composer5.rememberedValue();
                                                                                if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$1$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return RowScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue10);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                Modifier modifierConditional2 = ModifierExtensionsKt.conditional(companion, z9, (Function1) objRememberedValue10);
                                                                                boolean z11 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                                composer5.startReplaceGroup(-1700336911);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean zChanged7 = composer5.changed(windowInsets3);
                                                                                final WindowInsets windowInsets4 = windowInsets3;
                                                                                Object objRememberedValue11 = composer5.rememberedValue();
                                                                                if (zChanged7 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$2$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue11);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional2, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            composer5.skipToGroupEnd();
                                                                        }
                                                                    }));
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue9);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        composer4 = composer3;
                                                        HorizontalStackKt.m13978HorizontalStackTN_CM5M(size, horizontal, fM13979getSpacingD9Ej5fM, modifierConditional, (Function1) objRememberedValue9, composer4, 0, 0);
                                                        composer4.endReplaceGroup();
                                                    } else {
                                                        z8 = false;
                                                        composer3.startReplaceGroup(-957922940);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue7 = composer3.rememberedValue();
                                                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                        }
                                                        mutableState2 = (MutableState) objRememberedValue7;
                                                        composer3.endReplaceGroup();
                                                        Size size2 = stackComponentState.getSize();
                                                        Dimension.Horizontal horizontal2 = (Dimension.Horizontal) dimension;
                                                        float fM13979getSpacingD9Ej5fM2 = stackComponentState.m13979getSpacingD9Ej5fM();
                                                        Modifier modifierThen2 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), null, AlignmentKt.toAlignment(horizontal2.getAlignment()), 2, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.1
                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Modifier invoke(Modifier applyIfNotNull, ScrollState state, Orientation orientation) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(state, "state");
                                                                Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                                return ScrollableKt.scrollable(applyIfNotNull, state, orientation);
                                                            }
                                                        }).then(rootModifier);
                                                        composer3.startReplaceGroup(-957900815);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue8 = composer3.rememberedValue();
                                                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                        }
                                                        composer3.endReplaceGroup();
                                                        Modifier modifierConditional2 = ModifierExtensionsKt.conditional(modifierThen2, z8, (Function1) objRememberedValue8);
                                                        composer3.startReplaceGroup(-957894527);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        zChanged6 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing) | composer3.changed(f3) | composer3.changed(components3) | composer3.changedInstance(function23) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                        stackComponentState3 = stackComponentState;
                                                        windowInsets2 = safeDrawing;
                                                        f5 = f3;
                                                        components5 = components3;
                                                        function25 = function23;
                                                        paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
                                                        objRememberedValue9 = composer3.rememberedValue();
                                                        if (!zChanged6) {
                                                            objRememberedValue9 = (Function1) new Function1<HorizontalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(HorizontalStackScope horizontalStackScope) {
                                                                    invoke2(horizontalStackScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(HorizontalStackScope HorizontalStack) {
                                                                    Intrinsics.checkNotNullParameter(HorizontalStack, "$this$HorizontalStack");
                                                                    List children2 = stackComponentState3.getChildren();
                                                                    final MutableState<Boolean> mutableState3 = mutableState2;
                                                                    final StackComponentState stackComponentState4 = stackComponentState3;
                                                                    final WindowInsets windowInsets3 = windowInsets2;
                                                                    final float f6 = f5;
                                                                    final PaywallState.Loaded.Components components6 = components5;
                                                                    final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function26 = function25;
                                                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                                                                    HorizontalStack.items(children2, ComposableLambdaKt.composableLambdaInstance(1874260288, true, new Function5<RowScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(5);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function5
                                                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                            invoke(rowScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(final RowScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                            int i25;
                                                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                            Intrinsics.checkNotNullParameter(child, "child");
                                                                            ComposerKt.sourceInformation(composer5, "C646@30136L99,651@30435L146,640@29725L944:StackComponentView.kt#280jdz");
                                                                            if ((i24 & 6) == 0) {
                                                                                i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                            } else {
                                                                                i25 = i24;
                                                                            }
                                                                            if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                                i25 |= composer5.changed(child) ? 256 : 128;
                                                                            }
                                                                            if ((i25 & 1155) != 1154 || !composer5.getSkipping()) {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1874260288, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:640)");
                                                                                }
                                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                                boolean z9 = Intrinsics.areEqual(child.getSize().getWidth(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                                composer5.startReplaceGroup(-1700346526);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean z10 = (i25 & 14) == 4;
                                                                                Object objRememberedValue10 = composer5.rememberedValue();
                                                                                if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$1$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return RowScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue10);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                Modifier modifierConditional22 = ModifierExtensionsKt.conditional(companion, z9, (Function1) objRememberedValue10);
                                                                                boolean z11 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                                composer5.startReplaceGroup(-1700336911);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean zChanged7 = composer5.changed(windowInsets3);
                                                                                final WindowInsets windowInsets4 = windowInsets3;
                                                                                Object objRememberedValue11 = composer5.rememberedValue();
                                                                                if (zChanged7 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$2$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue11);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional22, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            composer5.skipToGroupEnd();
                                                                        }
                                                                    }));
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue9);
                                                            composer3.endReplaceGroup();
                                                            composer4 = composer3;
                                                            HorizontalStackKt.m13978HorizontalStackTN_CM5M(size2, horizontal2, fM13979getSpacingD9Ej5fM2, modifierConditional2, (Function1) objRememberedValue9, composer4, 0, 0);
                                                            composer4.endReplaceGroup();
                                                        }
                                                    }
                                                } else if (dimension instanceof Dimension.Vertical) {
                                                    composer3.startReplaceGroup(371224131);
                                                    ComposerKt.sourceInformation(composer3, "663@30996L34,674@31685L144,677@31853L1432,664@31051L2234");
                                                    List children2 = stackComponentState.getChildren();
                                                    if (!(children2 instanceof Collection) || !children2.isEmpty()) {
                                                        Iterator it2 = children2.iterator();
                                                        while (it2.hasNext()) {
                                                            if (Intrinsics.areEqual(((ComponentStyle) it2.next()).getSize().getHeight(), SizeConstraint.Fill.INSTANCE)) {
                                                                break;
                                                            }
                                                        }
                                                        z8 = false;
                                                        composer3.startReplaceGroup(-957851868);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue4 = composer3.rememberedValue();
                                                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                                            composer3.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        mutableState = (MutableState) objRememberedValue4;
                                                        composer3.endReplaceGroup();
                                                        Size size3 = stackComponentState.getSize();
                                                        Dimension.Vertical vertical = (Dimension.Vertical) dimension;
                                                        float fM13979getSpacingD9Ej5fM3 = stackComponentState.m13979getSpacingD9Ej5fM();
                                                        Modifier modifierThen3 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), AlignmentKt.toAlignment(vertical.getAlignment()), null, 4, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.4
                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Modifier invoke(Modifier applyIfNotNull, ScrollState state, Orientation orientation) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(state, "state");
                                                                Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                                return ScrollableKt.scrollable(applyIfNotNull, state, orientation);
                                                            }
                                                        }).then(rootModifier);
                                                        composer3.startReplaceGroup(-957829710);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue5 = composer3.rememberedValue();
                                                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue5 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$5$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Modifier invoke(Modifier conditional) {
                                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                    return ModifierExtensionsKt.trackMainAxisUnbounded(conditional, false, mutableState);
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue5);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        Modifier modifierConditional3 = ModifierExtensionsKt.conditional(modifierThen3, z8, (Function1) objRememberedValue5);
                                                        composer3.startReplaceGroup(-957823046);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        zChanged5 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing) | composer3.changed(f3) | composer3.changed(components3) | composer3.changedInstance(function23) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                        stackComponentState2 = stackComponentState;
                                                        windowInsets = safeDrawing;
                                                        f4 = f3;
                                                        components4 = components3;
                                                        function24 = function23;
                                                        paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                                                        objRememberedValue6 = composer3.rememberedValue();
                                                        if (!zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue6 = (Function1) new Function1<VerticalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(VerticalStackScope verticalStackScope) {
                                                                    invoke2(verticalStackScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(VerticalStackScope VerticalStack) {
                                                                    Intrinsics.checkNotNullParameter(VerticalStack, "$this$VerticalStack");
                                                                    List children3 = stackComponentState2.getChildren();
                                                                    final MutableState<Boolean> mutableState3 = mutableState;
                                                                    final StackComponentState stackComponentState4 = stackComponentState2;
                                                                    final WindowInsets windowInsets3 = windowInsets;
                                                                    final float f6 = f4;
                                                                    final PaywallState.Loaded.Components components6 = components4;
                                                                    final Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function24;
                                                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker2;
                                                                    VerticalStack.items(children3, ComposableLambdaKt.composableLambdaInstance(-21646243, true, new Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(5);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function5
                                                                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                            invoke(columnScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(final ColumnScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                            int i25;
                                                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                            Intrinsics.checkNotNullParameter(child, "child");
                                                                            ComposerKt.sourceInformation(composer5, "CP(1)685@32364L99,694@33003L146,679@31952L1285:StackComponentView.kt#280jdz");
                                                                            if ((i24 & 6) == 0) {
                                                                                i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                            } else {
                                                                                i25 = i24;
                                                                            }
                                                                            if ((i24 & 48) == 0) {
                                                                                i25 |= composer5.changed(i23) ? 32 : 16;
                                                                            }
                                                                            if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                                i25 |= composer5.changed(child) ? 256 : 128;
                                                                            }
                                                                            if ((i25 & 1171) != 1170 || !composer5.getSkipping()) {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-21646243, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:679)");
                                                                                }
                                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                                boolean z9 = Intrinsics.areEqual(child.getSize().getHeight(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                                composer5.startReplaceGroup(-1700275230);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean z10 = (i25 & 14) == 4;
                                                                                Object objRememberedValue10 = composer5.rememberedValue();
                                                                                if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$1$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return ColumnScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue10);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                Modifier modifierConditional4 = ModifierExtensionsKt.conditional(companion, z9, (Function1) objRememberedValue10);
                                                                                boolean z11 = stackComponentState4.getApplyTopWindowInsets() && i23 == 0 && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                                composer5.startReplaceGroup(-1700254735);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean zChanged7 = composer5.changed(windowInsets3);
                                                                                final WindowInsets windowInsets4 = windowInsets3;
                                                                                Object objRememberedValue11 = composer5.rememberedValue();
                                                                                if (zChanged7 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$2$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue11);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional4, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            composer5.skipToGroupEnd();
                                                                        }
                                                                    }));
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue6);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        composer4 = composer3;
                                                        VerticalStackKt.m13985VerticalStackTN_CM5M(size3, vertical, fM13979getSpacingD9Ej5fM3, modifierConditional3, (Function1) objRememberedValue6, composer4, 0, 0);
                                                        composer4.endReplaceGroup();
                                                    } else {
                                                        z8 = false;
                                                        composer3.startReplaceGroup(-957851868);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue4 = composer3.rememberedValue();
                                                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        }
                                                        mutableState = (MutableState) objRememberedValue4;
                                                        composer3.endReplaceGroup();
                                                        Size size32 = stackComponentState.getSize();
                                                        Dimension.Vertical vertical2 = (Dimension.Vertical) dimension;
                                                        float fM13979getSpacingD9Ej5fM32 = stackComponentState.m13979getSpacingD9Ej5fM();
                                                        Modifier modifierThen32 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), AlignmentKt.toAlignment(vertical2.getAlignment()), null, 4, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.4
                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Modifier invoke(Modifier applyIfNotNull, ScrollState state, Orientation orientation) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(state, "state");
                                                                Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                                return ScrollableKt.scrollable(applyIfNotNull, state, orientation);
                                                            }
                                                        }).then(rootModifier);
                                                        composer3.startReplaceGroup(-957829710);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        objRememberedValue5 = composer3.rememberedValue();
                                                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                        }
                                                        composer3.endReplaceGroup();
                                                        Modifier modifierConditional32 = ModifierExtensionsKt.conditional(modifierThen32, z8, (Function1) objRememberedValue5);
                                                        composer3.startReplaceGroup(-957823046);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        zChanged5 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing) | composer3.changed(f3) | composer3.changed(components3) | composer3.changedInstance(function23) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                        stackComponentState2 = stackComponentState;
                                                        windowInsets = safeDrawing;
                                                        f4 = f3;
                                                        components4 = components3;
                                                        function24 = function23;
                                                        paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                                                        objRememberedValue6 = composer3.rememberedValue();
                                                        if (!zChanged5) {
                                                            objRememberedValue6 = (Function1) new Function1<VerticalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(VerticalStackScope verticalStackScope) {
                                                                    invoke2(verticalStackScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(VerticalStackScope VerticalStack) {
                                                                    Intrinsics.checkNotNullParameter(VerticalStack, "$this$VerticalStack");
                                                                    List children3 = stackComponentState2.getChildren();
                                                                    final MutableState<Boolean> mutableState3 = mutableState;
                                                                    final StackComponentState stackComponentState4 = stackComponentState2;
                                                                    final WindowInsets windowInsets3 = windowInsets;
                                                                    final float f6 = f4;
                                                                    final PaywallState.Loaded.Components components6 = components4;
                                                                    final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function26 = function24;
                                                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker2;
                                                                    VerticalStack.items(children3, ComposableLambdaKt.composableLambdaInstance(-21646243, true, new Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(5);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function5
                                                                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                            invoke(columnScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(final ColumnScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                            int i25;
                                                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                            Intrinsics.checkNotNullParameter(child, "child");
                                                                            ComposerKt.sourceInformation(composer5, "CP(1)685@32364L99,694@33003L146,679@31952L1285:StackComponentView.kt#280jdz");
                                                                            if ((i24 & 6) == 0) {
                                                                                i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                            } else {
                                                                                i25 = i24;
                                                                            }
                                                                            if ((i24 & 48) == 0) {
                                                                                i25 |= composer5.changed(i23) ? 32 : 16;
                                                                            }
                                                                            if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                                i25 |= composer5.changed(child) ? 256 : 128;
                                                                            }
                                                                            if ((i25 & 1171) != 1170 || !composer5.getSkipping()) {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-21646243, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:679)");
                                                                                }
                                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                                boolean z9 = Intrinsics.areEqual(child.getSize().getHeight(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                                composer5.startReplaceGroup(-1700275230);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean z10 = (i25 & 14) == 4;
                                                                                Object objRememberedValue10 = composer5.rememberedValue();
                                                                                if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$1$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return ColumnScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue10);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                Modifier modifierConditional4 = ModifierExtensionsKt.conditional(companion, z9, (Function1) objRememberedValue10);
                                                                                boolean z11 = stackComponentState4.getApplyTopWindowInsets() && i23 == 0 && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                                composer5.startReplaceGroup(-1700254735);
                                                                                ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                                boolean zChanged7 = composer5.changed(windowInsets3);
                                                                                final WindowInsets windowInsets4 = windowInsets3;
                                                                                Object objRememberedValue11 = composer5.rememberedValue();
                                                                                if (zChanged7 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                    objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$2$1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Modifier invoke(Modifier conditional) {
                                                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                        }
                                                                                    };
                                                                                    composer5.updateRememberedValue(objRememberedValue11);
                                                                                }
                                                                                composer5.endReplaceGroup();
                                                                                ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional4, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            composer5.skipToGroupEnd();
                                                                        }
                                                                    }));
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue6);
                                                            composer3.endReplaceGroup();
                                                            composer4 = composer3;
                                                            VerticalStackKt.m13985VerticalStackTN_CM5M(size32, vertical2, fM13979getSpacingD9Ej5fM32, modifierConditional32, (Function1) objRememberedValue6, composer4, 0, 0);
                                                            composer4.endReplaceGroup();
                                                        }
                                                    }
                                                } else {
                                                    composer4 = composer3;
                                                    if (dimension instanceof Dimension.ZLayer) {
                                                        composer4.startReplaceGroup(373775679);
                                                        ComposerKt.sourceInformation(composer4, "712@33883L2164");
                                                        composer4.startReplaceGroup(-957767010);
                                                        ComposerKt.sourceInformation(composer4, "708@33777L7");
                                                        if (!stackComponentState.getApplyTopWindowInsets() || stackComponentState.getIgnoreHeaderHeight()) {
                                                            top = 0;
                                                        } else {
                                                            WindowInsets windowInsets3 = safeDrawing;
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer4.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            top = windowInsets3.getTop((Density) objConsume);
                                                        }
                                                        composer4.endReplaceGroup();
                                                        Dimension.ZLayer zLayer = (Dimension.ZLayer) dimension;
                                                        Modifier modifierThen4 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size(outerModifier, stackComponentState.getSize(), AlignmentKt.toHorizontalAlignmentOrNull(zLayer.getAlignment()), AlignmentKt.toVerticalAlignmentOrNull(zLayer.getAlignment())), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.7
                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Modifier invoke(Modifier applyIfNotNull, ScrollState state, Orientation orientation) {
                                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                                Intrinsics.checkNotNullParameter(state, "state");
                                                                Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                                return ScrollableKt.scrollable(applyIfNotNull, state, orientation);
                                                            }
                                                        }).then(rootModifier);
                                                        Alignment alignment = AlignmentKt.toAlignment(zLayer.getAlignment());
                                                        StackComponentState stackComponentState4 = stackComponentState;
                                                        final PaywallState.Loaded.Components components6 = components3;
                                                        final WindowInsets windowInsets4 = safeDrawing;
                                                        float f6 = f3;
                                                        Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function23;
                                                        PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierThen4);
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer4.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer4);
                                                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -89672292, "C:StackComponentView.kt#280jdz");
                                                        composer4.startReplaceGroup(1798223283);
                                                        ComposerKt.sourceInformation(composer4, "*734@35268L398,740@35765L146,728@34861L1138");
                                                        for (ComponentStyle componentStyle : stackComponentState4.getChildren()) {
                                                            boolean z9 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(componentStyle);
                                                            Modifier.Companion companion = Modifier.INSTANCE;
                                                            boolean z10 = z9 && !stackComponentState4.getIgnoreHeaderHeight();
                                                            composer4.startReplaceGroup(194119182);
                                                            ComposerKt.sourceInformation(composer4, "CC(remember):StackComponentView.kt#9igjgp");
                                                            boolean zChanged7 = composer4.changed(components6) | composer4.changed(top);
                                                            Object objRememberedValue10 = composer4.rememberedValue();
                                                            if (zChanged7 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$8$1$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Modifier invoke(Modifier conditional) {
                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                        return StackComponentViewKt.headerOrInsetsTopPadding(conditional, components6, top);
                                                                    }
                                                                };
                                                                composer4.updateRememberedValue(objRememberedValue10);
                                                            }
                                                            composer4.endReplaceGroup();
                                                            Modifier modifierConditional4 = ModifierExtensionsKt.conditional(companion, z10, (Function1) objRememberedValue10);
                                                            boolean z11 = z9 && stackComponentState4.getIgnoreHeaderHeight();
                                                            composer4.startReplaceGroup(194134834);
                                                            ComposerKt.sourceInformation(composer4, "CC(remember):StackComponentView.kt#9igjgp");
                                                            boolean zChanged8 = composer4.changed(windowInsets4);
                                                            Object objRememberedValue11 = composer4.rememberedValue();
                                                            if (zChanged8 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$8$1$2$1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Modifier invoke(Modifier conditional) {
                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                        return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                    }
                                                                };
                                                                composer4.updateRememberedValue(objRememberedValue11);
                                                            }
                                                            composer4.endReplaceGroup();
                                                            Modifier modifierAlpha = AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional4, z11, (Function1) objRememberedValue11), f6);
                                                            Function2<PaywallAction, Continuation<? super Unit>, Object> function27 = function26;
                                                            PaywallState.Loaded.Components components7 = components6;
                                                            ComponentViewKt.ComponentView(componentStyle, components7, function27, modifierAlpha, paywallComponentInteractionTracker4, composer4, 0, 0);
                                                            components6 = components7;
                                                            function26 = function27;
                                                        }
                                                        composer4.endReplaceGroup();
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endReplaceGroup();
                                                    } else {
                                                        composer4.startReplaceGroup(376404448);
                                                        composer4.endReplaceGroup();
                                                    }
                                                }
                                                composer4.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composerStartRestartGroup, 54);
                                BackgroundStyles background = stackComponentState.getBackground();
                                composerStartRestartGroup.startReplaceGroup(1234109811);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*752@36152L40");
                                BackgroundStyle backgroundStyleRememberBackgroundStyle = background != null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                Shape shape = stackComponentState.getShape();
                                composerStartRestartGroup.startReplaceGroup(1234112175);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(shape);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$composeShape$2$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final androidx.compose.p004ui.graphics.Shape invoke() {
                                            return ShapeKt.toShape(stackComponentState.getShape());
                                        }
                                    });
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                final State state = (State) objRememberedValue;
                                composerStartRestartGroup.endReplaceGroup();
                                BorderStyles border = stackComponentState.getBorder();
                                composerStartRestartGroup.startReplaceGroup(1234115915);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*754@36343L32");
                                BorderStyle borderStyleRememberBorderStyle = border != null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1234118015);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*756@36458L32");
                                if (z4 || (shadow = stackComponentState.getShadow()) == null) {
                                    i18 = i12;
                                    shadowStyleRememberShadowStyle = null;
                                } else {
                                    i18 = i12;
                                    shadowStyleRememberShadowStyle = ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1234123102);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                zChanged2 = composerStartRestartGroup.changed(backgroundStyleRememberBackgroundStyle) | composerStartRestartGroup.changed(shadowStyleRememberShadowStyle);
                                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (zChanged2) {
                                    i19 = i20;
                                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    }
                                    Modifier modifier7 = (Modifier) objRememberedValue4;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1234131942);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                    int i21 = i18 & 14;
                                    zChanged3 = (i21 == 4) | composerStartRestartGroup.changed(borderStyleRememberBorderStyle);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = ModifierExtensionsKt.applyIfNotNull(Modifier.INSTANCE, borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$borderModifier$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                return PaddingKt.m2854padding3ABfNKs(BorderKt.border(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$11(state)), it.m13932getWidthD9Ej5fM());
                                            }
                                        });
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    final Modifier modifier8 = (Modifier) objRememberedValue2;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1234139078);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                    zChanged4 = (i21 != 4) | composerStartRestartGroup.changed(borderStyleRememberBorderStyle);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getPadding());
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    Modifier modifier9 = (Modifier) objRememberedValue3;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1234143423);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "781@37217L39");
                                    if (mutableInteractionSource5 != null) {
                                        composerStartRestartGroup.startReplaceGroup(1234144074);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue5;
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource5;
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1234146360);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "785@37437L7");
                                    if (function04 == null) {
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                                        modifier3 = modifier9;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localIndication);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        function02 = function04;
                                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                                        boolean z8 = z7;
                                        companionM2058clickableO2vRcR0$default = ClickableKt.m2058clickableO2vRcR0$default(companion, mutableInteractionSource6, (Indication) objConsume, z8, null, null, function02, 24, null);
                                        mutableInteractionSource2 = mutableInteractionSource6;
                                        z7 = z8;
                                    } else {
                                        modifier3 = modifier9;
                                        function02 = function04;
                                        companionM2058clickableO2vRcR0$default = Modifier.INSTANCE;
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function35 = function34;
                                    if (badgeStyle3 == null || function35 != null) {
                                        final Modifier modifier10 = modifier3;
                                        mutableInteractionSource3 = mutableInteractionSource5;
                                        modifier4 = modifier6;
                                        if (badgeStyle3 == null) {
                                            composerStartRestartGroup.startReplaceGroup(-391931112);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "874@41549L695");
                                            Modifier modifierThen = ClipKt.clip(modifier4.then(modifier7), MainStackComponent$lambda$11(state)).then(companionM2058clickableO2vRcR0$default).then(modifier8);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382058539, "C881@41831L82,881@41764L149,885@41927L307:StackComponentView.kt#280jdz");
                                            WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyleRememberBackgroundStyle, null, null, ComposableLambdaKt.rememberComposableLambda(-1179201261, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$5$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i22) {
                                                    ComposerKt.sourceInformation(composer3, "C882@41849L50:StackComponentView.kt#280jdz");
                                                    if ((i22 & 3) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1179201261, i22, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous> (StackComponentView.kt:882)");
                                                    }
                                                    composableLambdaRememberComposableLambda.invoke(modifier4, Modifier.INSTANCE.then(modifier10), composer3, Integer.valueOf(RendererCapabilities.DECODER_SUPPORT_MASK));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i18 >> 3) & 14) | 24576, 12);
                                            function32 = function35;
                                            StackComponentView(badgeStyle3.getStackStyle(), components, new StackComponentViewKt$MainStackComponent$5$2(null), boxScopeInstance.align(Modifier.INSTANCE, AlignmentKt.toAlignment(badgeStyle3.getAlignment())), null, false, null, 0.0f, paywallComponentInteractionTracker, composerStartRestartGroup, (i18 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i18 << 15) & 234881024), PsExtractor.VIDEO_STREAM_MASK);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            composerStartRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            function32 = function35;
                                            if (function32 != null) {
                                                composerStartRestartGroup.startReplaceGroup(-391209277);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "895@42287L364");
                                                Modifier modifierThen2 = ClipKt.clip(modifier4.then(modifier7), MainStackComponent$lambda$11(state)).then(companionM2058clickableO2vRcR0$default);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                                                Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM7248constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    composerM7248constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    composerM7248constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382743856, "C901@42531L88,901@42464L155,904@42632L9:StackComponentView.kt#280jdz");
                                                WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyleRememberBackgroundStyle, null, null, ComposableLambdaKt.rememberComposableLambda(1368748244, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$6$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i22) {
                                                        ComposerKt.sourceInformation(composer3, "C902@42549L56:StackComponentView.kt#280jdz");
                                                        if ((i22 & 3) == 2 && composer3.getSkipping()) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1368748244, i22, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous> (StackComponentView.kt:902)");
                                                        }
                                                        composableLambdaRememberComposableLambda.invoke(modifier4, modifier8.then(modifier10), composer3, Integer.valueOf(RendererCapabilities.DECODER_SUPPORT_MASK));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i18 >> 3) & 14) | 24576, 12);
                                                function32.invoke(boxScopeInstance2, composerStartRestartGroup, Integer.valueOf(6 | (i19 & 112)));
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                composerStartRestartGroup.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(-390844097);
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-395731805);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                        if (backgroundStyleRememberBackgroundStyle instanceof BackgroundStyle.Video) {
                                            composerStartRestartGroup.startReplaceGroup(-395763642);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "806@38163L572,796@37754L981");
                                            final Modifier modifier11 = modifier3;
                                            final Modifier modifier12 = modifier6;
                                            WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyleRememberBackgroundStyle, ClipKt.clip(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(modifier6, stackComponentState.getSize(), null, null, 6, null).then(modifier7), MainStackComponent$lambda$11(state)).then(companionM2058clickableO2vRcR0$default).then(modifier8), MainStackComponent$lambda$11(state), ComposableLambdaKt.rememberComposableLambda(-609159577, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.MainStackComponent.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i22) {
                                                    ComposerKt.sourceInformation(composer3, "C811@38370L125,814@38573L129,807@38181L540:StackComponentView.kt#280jdz");
                                                    if ((i22 & 3) != 2 || !composer3.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-609159577, i22, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous> (StackComponentView.kt:807)");
                                                        }
                                                        Function4<Modifier, Modifier, Composer, Integer, Unit> function4 = composableLambdaRememberComposableLambda;
                                                        Modifier modifier13 = modifier12;
                                                        Modifier modifierThen3 = Modifier.INSTANCE.then(modifier11);
                                                        boolean applyBottomWindowInsets = stackComponentState.getApplyBottomWindowInsets();
                                                        composer3.startReplaceGroup(-957615809);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        boolean zChanged5 = composer3.changed(safeDrawing);
                                                        final WindowInsets windowInsets = safeDrawing;
                                                        Object objRememberedValue6 = composer3.rememberedValue();
                                                        if (zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue6 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$1$1$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Modifier invoke(Modifier conditional) {
                                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                    return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets, WindowInsetsSides.INSTANCE.m2977getBottomJoeWqyM()));
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue6);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierThen3, applyBottomWindowInsets, (Function1) objRememberedValue6);
                                                        boolean applyHorizontalWindowInsets = stackComponentState.getApplyHorizontalWindowInsets();
                                                        composer3.startReplaceGroup(-957609309);
                                                        ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                        boolean zChanged6 = composer3.changed(safeDrawing);
                                                        final WindowInsets windowInsets2 = safeDrawing;
                                                        Object objRememberedValue7 = composer3.rememberedValue();
                                                        if (zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$1$2$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Modifier invoke(Modifier conditional) {
                                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                    return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets2, WindowInsetsSides.INSTANCE.m2979getHorizontalJoeWqyM()));
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(objRememberedValue7);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        function4.invoke(modifier13, ModifierExtensionsKt.conditional(modifierConditional, applyHorizontalWindowInsets, (Function1) objRememberedValue7), composer3, Integer.valueOf(RendererCapabilities.DECODER_SUPPORT_MASK));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer3.skipToGroupEnd();
                                                }
                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i18 >> 3) & 14) | 24576, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                            mutableInteractionSource3 = mutableInteractionSource5;
                                            modifier4 = modifier6;
                                        } else {
                                            Modifier modifier13 = modifier3;
                                            if (function02 != null) {
                                                composerStartRestartGroup.startReplaceGroup(-394626624);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "831@39712L1198");
                                                Function0<Unit> function05 = function02;
                                                Modifier modifierM2058clickableO2vRcR0$default = ClickableKt.m2058clickableO2vRcR0$default(modifier6, mutableInteractionSource2, null, z7, null, null, function05, 24, null);
                                                mutableInteractionSource3 = mutableInteractionSource5;
                                                modifier4 = modifier6;
                                                function02 = function05;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2058clickableO2vRcR0$default);
                                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composerStartRestartGroup.startReusableNode();
                                                if (composerStartRestartGroup.getInserting()) {
                                                    composerStartRestartGroup.createNode(constructor3);
                                                } else {
                                                    composerStartRestartGroup.useNode();
                                                }
                                                Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composerStartRestartGroup);
                                                Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM7248constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                    composerM7248constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                    composerM7248constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                }
                                                Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 380325701, "C844@40249L125,847@40452L129,839@40004L596,856@40869L7,851@40617L279:StackComponentView.kt#280jdz");
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                Modifier modifierThen3 = modifier7.then(modifier8).then(modifier13);
                                                boolean applyBottomWindowInsets = stackComponentState.getApplyBottomWindowInsets();
                                                composerStartRestartGroup.startReplaceGroup(-957555681);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged5 = composerStartRestartGroup.changed(safeDrawing);
                                                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue6 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$2$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(safeDrawing, WindowInsetsSides.INSTANCE.m2977getBottomJoeWqyM()));
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                                }
                                                composerStartRestartGroup.endReplaceGroup();
                                                Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierThen3, applyBottomWindowInsets, (Function1) objRememberedValue6);
                                                boolean applyHorizontalWindowInsets = stackComponentState.getApplyHorizontalWindowInsets();
                                                composerStartRestartGroup.startReplaceGroup(-957549181);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged6 = composerStartRestartGroup.changed(safeDrawing);
                                                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue7 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$2$2$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(safeDrawing, WindowInsetsSides.INSTANCE.m2979getHorizontalJoeWqyM()));
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                                }
                                                composerStartRestartGroup.endReplaceGroup();
                                                composableLambdaRememberComposableLambda.invoke(companion2, ModifierExtensionsKt.conditional(modifierConditional, applyHorizontalWindowInsets, (Function1) objRememberedValue7), composerStartRestartGroup, 390);
                                                ProvidableCompositionLocal<Indication> localIndication2 = IndicationKt.getLocalIndication();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composerStartRestartGroup.consume(localIndication2);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                BoxKt.Box(IndicationKt.indication(ClipKt.clip(PaddingKt.padding(boxScopeInstance3.matchParentSize(Modifier.INSTANCE), stackComponentState.getMargin()), MainStackComponent$lambda$11(state)), mutableInteractionSource2, (Indication) objConsume2), composerStartRestartGroup, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                composerStartRestartGroup.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource5;
                                                modifier4 = modifier6;
                                                composerStartRestartGroup.startReplaceGroup(-392543393);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "865@41165L117,868@41356L121,860@40940L552");
                                                Modifier modifierThen4 = modifier7.then(modifier8).then(modifier13);
                                                boolean applyBottomWindowInsets2 = stackComponentState.getApplyBottomWindowInsets();
                                                composerStartRestartGroup.startReplaceGroup(1234270488);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged7 = composerStartRestartGroup.changed(safeDrawing);
                                                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged7 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue8 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$3$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(safeDrawing, WindowInsetsSides.INSTANCE.m2977getBottomJoeWqyM()));
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                                }
                                                composerStartRestartGroup.endReplaceGroup();
                                                Modifier modifierConditional2 = ModifierExtensionsKt.conditional(modifierThen4, applyBottomWindowInsets2, (Function1) objRememberedValue8);
                                                boolean applyHorizontalWindowInsets2 = stackComponentState.getApplyHorizontalWindowInsets();
                                                composerStartRestartGroup.startReplaceGroup(1234276604);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                                boolean zChanged8 = composerStartRestartGroup.changed(safeDrawing);
                                                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged8 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue9 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$4$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(safeDrawing, WindowInsetsSides.INSTANCE.m2979getHorizontalJoeWqyM()));
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                                }
                                                composerStartRestartGroup.endReplaceGroup();
                                                composableLambdaRememberComposableLambda.invoke(modifier4, ModifierExtensionsKt.conditional(modifierConditional2, applyHorizontalWindowInsets2, (Function1) objRememberedValue9), composerStartRestartGroup, Integer.valueOf(((i18 >> 15) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK));
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        function32 = function35;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2 = composerStartRestartGroup;
                                    modifier5 = modifier4;
                                    function33 = function32;
                                    badgeStyle2 = badgeStyle3;
                                    z5 = z4;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    z6 = z7;
                                    function03 = function02;
                                } else {
                                    i19 = i20;
                                }
                                objRememberedValue4 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), shadowStyleRememberShadowStyle, new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$11(state));
                                    }
                                }), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return BackgroundKt.background(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$11(state));
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                Modifier modifier72 = (Modifier) objRememberedValue4;
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1234131942);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                int i212 = i18 & 14;
                                zChanged3 = (i212 == 4) | composerStartRestartGroup.changed(borderStyleRememberBorderStyle);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (zChanged3) {
                                    objRememberedValue2 = ModifierExtensionsKt.applyIfNotNull(Modifier.INSTANCE, borderStyleRememberBorderStyle, new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$borderModifier$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return PaddingKt.m2854padding3ABfNKs(BorderKt.border(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$11(state)), it.m13932getWidthD9Ej5fM());
                                        }
                                    });
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    final Modifier modifier82 = (Modifier) objRememberedValue2;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1234139078);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                    zChanged4 = (i212 != 4) | composerStartRestartGroup.changed(borderStyleRememberBorderStyle);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged4) {
                                        objRememberedValue3 = PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getPadding());
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        Modifier modifier92 = (Modifier) objRememberedValue3;
                                        composerStartRestartGroup.endReplaceGroup();
                                        composerStartRestartGroup.startReplaceGroup(1234143423);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "781@37217L39");
                                        if (mutableInteractionSource5 != null) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        composerStartRestartGroup.startReplaceGroup(1234146360);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "785@37437L7");
                                        if (function04 == null) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function352 = function34;
                                        if (badgeStyle3 == null) {
                                            final Modifier modifier102 = modifier3;
                                            mutableInteractionSource3 = mutableInteractionSource5;
                                            modifier4 = modifier6;
                                            if (badgeStyle3 == null) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            composer2 = composerStartRestartGroup;
                                            modifier5 = modifier4;
                                            function33 = function32;
                                            badgeStyle2 = badgeStyle3;
                                            z5 = z4;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            z6 = z7;
                                            function03 = function02;
                                        }
                                    }
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                badgeStyle2 = badgeStyle;
                                z5 = z2;
                                z6 = z3;
                                composer2 = composerStartRestartGroup;
                                modifier5 = modifier2;
                                function03 = function0;
                                mutableInteractionSource4 = mutableInteractionSource;
                                function33 = function3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.MainStackComponent.7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i22) {
                                        StackComponentViewKt.MainStackComponent(stackComponentState, components, function2, paywallComponentInteractionTracker, f, modifier5, function03, z6, mutableInteractionSource4, badgeStyle2, z5, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 100663296;
                        i9 = i4;
                        i10 = i3 & 512;
                        if (i10 == 0) {
                        }
                        i12 = i9;
                        i13 = i3 & 1024;
                        if (i13 == 0) {
                        }
                        i16 = i3 & 2048;
                        if (i16 == 0) {
                        }
                        int i202 = i15;
                        if ((i12 & 306783379) == 306783378) {
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i17 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final WindowInsets safeDrawing2 = WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6);
                            final PaywallState.Loaded.Components components32 = components2;
                            final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function232 = function22;
                            final float f32 = f2;
                            final Function4<? super Modifier, ? super Modifier, ? super Composer, ? super Integer, Unit> composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1884046896, true, new Function4<Modifier, Modifier, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier73, Modifier modifier83, Composer composer3, Integer num) {
                                    invoke(modifier73, modifier83, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
                                /* JADX WARN: Removed duplicated region for block: B:51:0x0178  */
                                /* JADX WARN: Removed duplicated region for block: B:56:0x01d7  */
                                /* JADX WARN: Removed duplicated region for block: B:72:0x025f  */
                                /* JADX WARN: Removed duplicated region for block: B:75:0x02be  */
                                /* JADX WARN: Removed duplicated region for block: B:80:0x031d  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke(Modifier outerModifier, Modifier rootModifier, Composer composer3, int i213) {
                                    Composer composer4;
                                    final int top;
                                    Object objRememberedValue42;
                                    final MutableState<Boolean> mutableState;
                                    Object objRememberedValue52;
                                    boolean zChanged52;
                                    final StackComponentState stackComponentState2;
                                    final WindowInsets windowInsets;
                                    final float f4;
                                    final PaywallState.Loaded.Components components4;
                                    final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function24;
                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
                                    Object objRememberedValue62;
                                    Object objRememberedValue72;
                                    final MutableState<Boolean> mutableState2;
                                    Object objRememberedValue82;
                                    boolean zChanged62;
                                    final StackComponentState stackComponentState3;
                                    final WindowInsets windowInsets2;
                                    final float f5;
                                    final PaywallState.Loaded.Components components5;
                                    final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function25;
                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker3;
                                    Object objRememberedValue92;
                                    Intrinsics.checkNotNullParameter(outerModifier, "outerModifier");
                                    Intrinsics.checkNotNullParameter(rootModifier, "rootModifier");
                                    ComposerKt.sourceInformation(composer3, "C:StackComponentView.kt#280jdz");
                                    int i22 = (i213 & 6) == 0 ? i213 | (composer3.changed(outerModifier) ? 4 : 2) : i213;
                                    if ((i213 & 48) == 0) {
                                        i22 |= composer3.changed(rootModifier) ? 32 : 16;
                                    }
                                    if ((i22 & 147) != 146 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1884046896, i22, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous> (StackComponentView.kt:607)");
                                        }
                                        Orientation scrollOrientation = stackComponentState.getScrollOrientation();
                                        composer3.startReplaceGroup(-957953601);
                                        ComposerKt.sourceInformation(composer3, "*607@27823L21");
                                        boolean z82 = true;
                                        ScrollState scrollStateRememberScrollState = scrollOrientation == null ? null : ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                        composer3.endReplaceGroup();
                                        if (stackComponentState.getChildren().isEmpty()) {
                                            composer3.startReplaceGroup(368497433);
                                            ComposerKt.sourceInformation(composer3, "612@28117L143");
                                            BoxKt.Box(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), null, null, 6, null).then(rootModifier), composer3, 0);
                                            composer3.endReplaceGroup();
                                        } else {
                                            composer3.startReplaceGroup(368906075);
                                            ComposerKt.sourceInformation(composer3, "");
                                            Dimension dimension = stackComponentState.getDimension();
                                            if (dimension instanceof Dimension.Horizontal) {
                                                composer3.startReplaceGroup(368839084);
                                                ComposerKt.sourceInformation(composer3, "624@28775L34,635@29463L143,638@29630L1087,625@28830L1887");
                                                List children = stackComponentState.getChildren();
                                                if (!(children instanceof Collection) || !children.isEmpty()) {
                                                    Iterator it = children.iterator();
                                                    while (it.hasNext()) {
                                                        if (Intrinsics.areEqual(((ComponentStyle) it.next()).getSize().getWidth(), SizeConstraint.Fill.INSTANCE)) {
                                                            break;
                                                        }
                                                    }
                                                    z82 = false;
                                                    composer3.startReplaceGroup(-957922940);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue72 = composer3.rememberedValue();
                                                    if (objRememberedValue72 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue72 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                                        composer3.updateRememberedValue(objRememberedValue72);
                                                    }
                                                    mutableState2 = (MutableState) objRememberedValue72;
                                                    composer3.endReplaceGroup();
                                                    Size size2 = stackComponentState.getSize();
                                                    Dimension.Horizontal horizontal2 = (Dimension.Horizontal) dimension;
                                                    float fM13979getSpacingD9Ej5fM2 = stackComponentState.m13979getSpacingD9Ej5fM();
                                                    Modifier modifierThen22 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), null, AlignmentKt.toAlignment(horizontal2.getAlignment()), 2, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.1
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(state2, "state");
                                                            Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                            return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                        }
                                                    }).then(rootModifier);
                                                    composer3.startReplaceGroup(-957900815);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue82 = composer3.rememberedValue();
                                                    if (objRememberedValue82 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue82 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$2$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Modifier invoke(Modifier conditional) {
                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                return ModifierExtensionsKt.trackMainAxisUnbounded(conditional, true, mutableState2);
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(objRememberedValue82);
                                                    }
                                                    composer3.endReplaceGroup();
                                                    Modifier modifierConditional22 = ModifierExtensionsKt.conditional(modifierThen22, z82, (Function1) objRememberedValue82);
                                                    composer3.startReplaceGroup(-957894527);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    zChanged62 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing2) | composer3.changed(f32) | composer3.changed(components32) | composer3.changedInstance(function232) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                    stackComponentState3 = stackComponentState;
                                                    windowInsets2 = safeDrawing2;
                                                    f5 = f32;
                                                    components5 = components32;
                                                    function25 = function232;
                                                    paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
                                                    objRememberedValue92 = composer3.rememberedValue();
                                                    if (!zChanged62 || objRememberedValue92 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue92 = (Function1) new Function1<HorizontalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(HorizontalStackScope horizontalStackScope) {
                                                                invoke2(horizontalStackScope);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(HorizontalStackScope HorizontalStack) {
                                                                Intrinsics.checkNotNullParameter(HorizontalStack, "$this$HorizontalStack");
                                                                List children2 = stackComponentState3.getChildren();
                                                                final MutableState<Boolean> mutableState3 = mutableState2;
                                                                final StackComponentState stackComponentState4 = stackComponentState3;
                                                                final WindowInsets windowInsets3 = windowInsets2;
                                                                final float f6 = f5;
                                                                final PaywallState.Loaded.Components components6 = components5;
                                                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function26 = function25;
                                                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                                                                HorizontalStack.items(children2, ComposableLambdaKt.composableLambdaInstance(1874260288, true, new Function5<RowScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(5);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function5
                                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                        invoke(rowScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(final RowScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                        int i25;
                                                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                        Intrinsics.checkNotNullParameter(child, "child");
                                                                        ComposerKt.sourceInformation(composer5, "C646@30136L99,651@30435L146,640@29725L944:StackComponentView.kt#280jdz");
                                                                        if ((i24 & 6) == 0) {
                                                                            i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                        } else {
                                                                            i25 = i24;
                                                                        }
                                                                        if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                            i25 |= composer5.changed(child) ? 256 : 128;
                                                                        }
                                                                        if ((i25 & 1155) != 1154 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1874260288, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:640)");
                                                                            }
                                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                            boolean z9 = Intrinsics.areEqual(child.getSize().getWidth(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                            composer5.startReplaceGroup(-1700346526);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean z10 = (i25 & 14) == 4;
                                                                            Object objRememberedValue10 = composer5.rememberedValue();
                                                                            if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$1$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return RowScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue10);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            Modifier modifierConditional222 = ModifierExtensionsKt.conditional(companion3, z9, (Function1) objRememberedValue10);
                                                                            boolean z11 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                            composer5.startReplaceGroup(-1700336911);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean zChanged72 = composer5.changed(windowInsets3);
                                                                            final WindowInsets windowInsets4 = windowInsets3;
                                                                            Object objRememberedValue11 = composer5.rememberedValue();
                                                                            if (zChanged72 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$2$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue11);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional222, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }));
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(objRememberedValue92);
                                                    }
                                                    composer3.endReplaceGroup();
                                                    composer4 = composer3;
                                                    HorizontalStackKt.m13978HorizontalStackTN_CM5M(size2, horizontal2, fM13979getSpacingD9Ej5fM2, modifierConditional22, (Function1) objRememberedValue92, composer4, 0, 0);
                                                    composer4.endReplaceGroup();
                                                } else {
                                                    z82 = false;
                                                    composer3.startReplaceGroup(-957922940);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue72 = composer3.rememberedValue();
                                                    if (objRememberedValue72 == Composer.INSTANCE.getEmpty()) {
                                                    }
                                                    mutableState2 = (MutableState) objRememberedValue72;
                                                    composer3.endReplaceGroup();
                                                    Size size22 = stackComponentState.getSize();
                                                    Dimension.Horizontal horizontal22 = (Dimension.Horizontal) dimension;
                                                    float fM13979getSpacingD9Ej5fM22 = stackComponentState.m13979getSpacingD9Ej5fM();
                                                    Modifier modifierThen222 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), null, AlignmentKt.toAlignment(horizontal22.getAlignment()), 2, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.1
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(state2, "state");
                                                            Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                            return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                        }
                                                    }).then(rootModifier);
                                                    composer3.startReplaceGroup(-957900815);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue82 = composer3.rememberedValue();
                                                    if (objRememberedValue82 == Composer.INSTANCE.getEmpty()) {
                                                    }
                                                    composer3.endReplaceGroup();
                                                    Modifier modifierConditional222 = ModifierExtensionsKt.conditional(modifierThen222, z82, (Function1) objRememberedValue82);
                                                    composer3.startReplaceGroup(-957894527);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    zChanged62 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing2) | composer3.changed(f32) | composer3.changed(components32) | composer3.changedInstance(function232) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                    stackComponentState3 = stackComponentState;
                                                    windowInsets2 = safeDrawing2;
                                                    f5 = f32;
                                                    components5 = components32;
                                                    function25 = function232;
                                                    paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
                                                    objRememberedValue92 = composer3.rememberedValue();
                                                    if (!zChanged62) {
                                                        objRememberedValue92 = (Function1) new Function1<HorizontalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(HorizontalStackScope horizontalStackScope) {
                                                                invoke2(horizontalStackScope);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(HorizontalStackScope HorizontalStack) {
                                                                Intrinsics.checkNotNullParameter(HorizontalStack, "$this$HorizontalStack");
                                                                List children2 = stackComponentState3.getChildren();
                                                                final MutableState<Boolean> mutableState3 = mutableState2;
                                                                final StackComponentState stackComponentState4 = stackComponentState3;
                                                                final WindowInsets windowInsets3 = windowInsets2;
                                                                final float f6 = f5;
                                                                final PaywallState.Loaded.Components components6 = components5;
                                                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function26 = function25;
                                                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                                                                HorizontalStack.items(children2, ComposableLambdaKt.composableLambdaInstance(1874260288, true, new Function5<RowScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(5);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function5
                                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                        invoke(rowScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(final RowScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                        int i25;
                                                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                        Intrinsics.checkNotNullParameter(child, "child");
                                                                        ComposerKt.sourceInformation(composer5, "C646@30136L99,651@30435L146,640@29725L944:StackComponentView.kt#280jdz");
                                                                        if ((i24 & 6) == 0) {
                                                                            i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                        } else {
                                                                            i25 = i24;
                                                                        }
                                                                        if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                            i25 |= composer5.changed(child) ? 256 : 128;
                                                                        }
                                                                        if ((i25 & 1155) != 1154 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1874260288, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:640)");
                                                                            }
                                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                            boolean z9 = Intrinsics.areEqual(child.getSize().getWidth(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                            composer5.startReplaceGroup(-1700346526);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean z10 = (i25 & 14) == 4;
                                                                            Object objRememberedValue10 = composer5.rememberedValue();
                                                                            if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$1$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return RowScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue10);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            Modifier modifierConditional2222 = ModifierExtensionsKt.conditional(companion3, z9, (Function1) objRememberedValue10);
                                                                            boolean z11 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                            composer5.startReplaceGroup(-1700336911);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean zChanged72 = composer5.changed(windowInsets3);
                                                                            final WindowInsets windowInsets4 = windowInsets3;
                                                                            Object objRememberedValue11 = composer5.rememberedValue();
                                                                            if (zChanged72 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$3$1$1$2$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue11);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional2222, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }));
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(objRememberedValue92);
                                                        composer3.endReplaceGroup();
                                                        composer4 = composer3;
                                                        HorizontalStackKt.m13978HorizontalStackTN_CM5M(size22, horizontal22, fM13979getSpacingD9Ej5fM22, modifierConditional222, (Function1) objRememberedValue92, composer4, 0, 0);
                                                        composer4.endReplaceGroup();
                                                    }
                                                }
                                            } else if (dimension instanceof Dimension.Vertical) {
                                                composer3.startReplaceGroup(371224131);
                                                ComposerKt.sourceInformation(composer3, "663@30996L34,674@31685L144,677@31853L1432,664@31051L2234");
                                                List children2 = stackComponentState.getChildren();
                                                if (!(children2 instanceof Collection) || !children2.isEmpty()) {
                                                    Iterator it2 = children2.iterator();
                                                    while (it2.hasNext()) {
                                                        if (Intrinsics.areEqual(((ComponentStyle) it2.next()).getSize().getHeight(), SizeConstraint.Fill.INSTANCE)) {
                                                            break;
                                                        }
                                                    }
                                                    z82 = false;
                                                    composer3.startReplaceGroup(-957851868);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue42 = composer3.rememberedValue();
                                                    if (objRememberedValue42 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue42 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                                        composer3.updateRememberedValue(objRememberedValue42);
                                                    }
                                                    mutableState = (MutableState) objRememberedValue42;
                                                    composer3.endReplaceGroup();
                                                    Size size32 = stackComponentState.getSize();
                                                    Dimension.Vertical vertical2 = (Dimension.Vertical) dimension;
                                                    float fM13979getSpacingD9Ej5fM32 = stackComponentState.m13979getSpacingD9Ej5fM();
                                                    Modifier modifierThen32 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), AlignmentKt.toAlignment(vertical2.getAlignment()), null, 4, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.4
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(state2, "state");
                                                            Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                            return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                        }
                                                    }).then(rootModifier);
                                                    composer3.startReplaceGroup(-957829710);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue52 = composer3.rememberedValue();
                                                    if (objRememberedValue52 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue52 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$5$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Modifier invoke(Modifier conditional) {
                                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                return ModifierExtensionsKt.trackMainAxisUnbounded(conditional, false, mutableState);
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(objRememberedValue52);
                                                    }
                                                    composer3.endReplaceGroup();
                                                    Modifier modifierConditional32 = ModifierExtensionsKt.conditional(modifierThen32, z82, (Function1) objRememberedValue52);
                                                    composer3.startReplaceGroup(-957823046);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    zChanged52 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing2) | composer3.changed(f32) | composer3.changed(components32) | composer3.changedInstance(function232) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                    stackComponentState2 = stackComponentState;
                                                    windowInsets = safeDrawing2;
                                                    f4 = f32;
                                                    components4 = components32;
                                                    function24 = function232;
                                                    paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                                                    objRememberedValue62 = composer3.rememberedValue();
                                                    if (!zChanged52 || objRememberedValue62 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue62 = (Function1) new Function1<VerticalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(VerticalStackScope verticalStackScope) {
                                                                invoke2(verticalStackScope);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(VerticalStackScope VerticalStack) {
                                                                Intrinsics.checkNotNullParameter(VerticalStack, "$this$VerticalStack");
                                                                List children3 = stackComponentState2.getChildren();
                                                                final MutableState<Boolean> mutableState3 = mutableState;
                                                                final StackComponentState stackComponentState4 = stackComponentState2;
                                                                final WindowInsets windowInsets3 = windowInsets;
                                                                final float f6 = f4;
                                                                final PaywallState.Loaded.Components components6 = components4;
                                                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function26 = function24;
                                                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker2;
                                                                VerticalStack.items(children3, ComposableLambdaKt.composableLambdaInstance(-21646243, true, new Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(5);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function5
                                                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                        invoke(columnScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(final ColumnScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                        int i25;
                                                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                        Intrinsics.checkNotNullParameter(child, "child");
                                                                        ComposerKt.sourceInformation(composer5, "CP(1)685@32364L99,694@33003L146,679@31952L1285:StackComponentView.kt#280jdz");
                                                                        if ((i24 & 6) == 0) {
                                                                            i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                        } else {
                                                                            i25 = i24;
                                                                        }
                                                                        if ((i24 & 48) == 0) {
                                                                            i25 |= composer5.changed(i23) ? 32 : 16;
                                                                        }
                                                                        if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                            i25 |= composer5.changed(child) ? 256 : 128;
                                                                        }
                                                                        if ((i25 & 1171) != 1170 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-21646243, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:679)");
                                                                            }
                                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                            boolean z9 = Intrinsics.areEqual(child.getSize().getHeight(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                            composer5.startReplaceGroup(-1700275230);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean z10 = (i25 & 14) == 4;
                                                                            Object objRememberedValue10 = composer5.rememberedValue();
                                                                            if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$1$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return ColumnScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue10);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            Modifier modifierConditional4 = ModifierExtensionsKt.conditional(companion3, z9, (Function1) objRememberedValue10);
                                                                            boolean z11 = stackComponentState4.getApplyTopWindowInsets() && i23 == 0 && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                            composer5.startReplaceGroup(-1700254735);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean zChanged72 = composer5.changed(windowInsets3);
                                                                            final WindowInsets windowInsets4 = windowInsets3;
                                                                            Object objRememberedValue11 = composer5.rememberedValue();
                                                                            if (zChanged72 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$2$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue11);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional4, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }));
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(objRememberedValue62);
                                                    }
                                                    composer3.endReplaceGroup();
                                                    composer4 = composer3;
                                                    VerticalStackKt.m13985VerticalStackTN_CM5M(size32, vertical2, fM13979getSpacingD9Ej5fM32, modifierConditional32, (Function1) objRememberedValue62, composer4, 0, 0);
                                                    composer4.endReplaceGroup();
                                                } else {
                                                    z82 = false;
                                                    composer3.startReplaceGroup(-957851868);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue42 = composer3.rememberedValue();
                                                    if (objRememberedValue42 == Composer.INSTANCE.getEmpty()) {
                                                    }
                                                    mutableState = (MutableState) objRememberedValue42;
                                                    composer3.endReplaceGroup();
                                                    Size size322 = stackComponentState.getSize();
                                                    Dimension.Vertical vertical22 = (Dimension.Vertical) dimension;
                                                    float fM13979getSpacingD9Ej5fM322 = stackComponentState.m13979getSpacingD9Ej5fM();
                                                    Modifier modifierThen322 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(outerModifier, stackComponentState.getSize(), AlignmentKt.toAlignment(vertical22.getAlignment()), null, 4, null), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.4
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(state2, "state");
                                                            Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                            return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                        }
                                                    }).then(rootModifier);
                                                    composer3.startReplaceGroup(-957829710);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    objRememberedValue52 = composer3.rememberedValue();
                                                    if (objRememberedValue52 == Composer.INSTANCE.getEmpty()) {
                                                    }
                                                    composer3.endReplaceGroup();
                                                    Modifier modifierConditional322 = ModifierExtensionsKt.conditional(modifierThen322, z82, (Function1) objRememberedValue52);
                                                    composer3.startReplaceGroup(-957823046);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):StackComponentView.kt#9igjgp");
                                                    zChanged52 = composer3.changed(stackComponentState) | composer3.changed(safeDrawing2) | composer3.changed(f32) | composer3.changed(components32) | composer3.changedInstance(function232) | composer3.changedInstance(paywallComponentInteractionTracker);
                                                    stackComponentState2 = stackComponentState;
                                                    windowInsets = safeDrawing2;
                                                    f4 = f32;
                                                    components4 = components32;
                                                    function24 = function232;
                                                    paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                                                    objRememberedValue62 = composer3.rememberedValue();
                                                    if (!zChanged52) {
                                                        objRememberedValue62 = (Function1) new Function1<VerticalStackScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(VerticalStackScope verticalStackScope) {
                                                                invoke2(verticalStackScope);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(VerticalStackScope VerticalStack) {
                                                                Intrinsics.checkNotNullParameter(VerticalStack, "$this$VerticalStack");
                                                                List children3 = stackComponentState2.getChildren();
                                                                final MutableState<Boolean> mutableState3 = mutableState;
                                                                final StackComponentState stackComponentState4 = stackComponentState2;
                                                                final WindowInsets windowInsets3 = windowInsets;
                                                                final float f6 = f4;
                                                                final PaywallState.Loaded.Components components6 = components4;
                                                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function26 = function24;
                                                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker2;
                                                                VerticalStack.items(children3, ComposableLambdaKt.composableLambdaInstance(-21646243, true, new Function5<ColumnScope, Integer, ComponentStyle, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(5);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function5
                                                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Integer num, ComponentStyle componentStyle, Composer composer5, Integer num2) {
                                                                        invoke(columnScope, num.intValue(), componentStyle, composer5, num2.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(final ColumnScope items, int i23, ComponentStyle child, Composer composer5, int i24) {
                                                                        int i25;
                                                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                                                        Intrinsics.checkNotNullParameter(child, "child");
                                                                        ComposerKt.sourceInformation(composer5, "CP(1)685@32364L99,694@33003L146,679@31952L1285:StackComponentView.kt#280jdz");
                                                                        if ((i24 & 6) == 0) {
                                                                            i25 = (composer5.changed(items) ? 4 : 2) | i24;
                                                                        } else {
                                                                            i25 = i24;
                                                                        }
                                                                        if ((i24 & 48) == 0) {
                                                                            i25 |= composer5.changed(i23) ? 32 : 16;
                                                                        }
                                                                        if ((i24 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                                                            i25 |= composer5.changed(child) ? 256 : 128;
                                                                        }
                                                                        if ((i25 & 1171) != 1170 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-21646243, i25, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.MainStackComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StackComponentView.kt:679)");
                                                                            }
                                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                            boolean z9 = Intrinsics.areEqual(child.getSize().getHeight(), SizeConstraint.Fill.INSTANCE) && !mutableState3.getValue().booleanValue();
                                                                            composer5.startReplaceGroup(-1700275230);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean z10 = (i25 & 14) == 4;
                                                                            Object objRememberedValue10 = composer5.rememberedValue();
                                                                            if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$1$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return ColumnScope.weight$default(items, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue10);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            Modifier modifierConditional4 = ModifierExtensionsKt.conditional(companion3, z9, (Function1) objRememberedValue10);
                                                                            boolean z11 = stackComponentState4.getApplyTopWindowInsets() && i23 == 0 && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(child);
                                                                            composer5.startReplaceGroup(-1700254735);
                                                                            ComposerKt.sourceInformation(composer5, "CC(remember):StackComponentView.kt#9igjgp");
                                                                            boolean zChanged72 = composer5.changed(windowInsets3);
                                                                            final WindowInsets windowInsets4 = windowInsets3;
                                                                            Object objRememberedValue11 = composer5.rememberedValue();
                                                                            if (zChanged72 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                                                objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$6$1$1$2$1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Modifier invoke(Modifier conditional) {
                                                                                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                                        return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                                    }
                                                                                };
                                                                                composer5.updateRememberedValue(objRememberedValue11);
                                                                            }
                                                                            composer5.endReplaceGroup();
                                                                            ComponentViewKt.ComponentView(child, components6, function26, AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional4, z11, (Function1) objRememberedValue11), f6), paywallComponentInteractionTracker4, composer5, (i25 >> 6) & 14, 0);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }));
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(objRememberedValue62);
                                                        composer3.endReplaceGroup();
                                                        composer4 = composer3;
                                                        VerticalStackKt.m13985VerticalStackTN_CM5M(size322, vertical22, fM13979getSpacingD9Ej5fM322, modifierConditional322, (Function1) objRememberedValue62, composer4, 0, 0);
                                                        composer4.endReplaceGroup();
                                                    }
                                                }
                                            } else {
                                                composer4 = composer3;
                                                if (dimension instanceof Dimension.ZLayer) {
                                                    composer4.startReplaceGroup(373775679);
                                                    ComposerKt.sourceInformation(composer4, "712@33883L2164");
                                                    composer4.startReplaceGroup(-957767010);
                                                    ComposerKt.sourceInformation(composer4, "708@33777L7");
                                                    if (!stackComponentState.getApplyTopWindowInsets() || stackComponentState.getIgnoreHeaderHeight()) {
                                                        top = 0;
                                                    } else {
                                                        WindowInsets windowInsets3 = safeDrawing2;
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer4.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        top = windowInsets3.getTop((Density) objConsume3);
                                                    }
                                                    composer4.endReplaceGroup();
                                                    Dimension.ZLayer zLayer = (Dimension.ZLayer) dimension;
                                                    Modifier modifierThen42 = ModifierExtensionsKt.applyIfNotNull(com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size(outerModifier, stackComponentState.getSize(), AlignmentKt.toHorizontalAlignmentOrNull(zLayer.getAlignment()), AlignmentKt.toVerticalAlignmentOrNull(zLayer.getAlignment())), scrollStateRememberScrollState, stackComponentState.getScrollOrientation(), new Function3<Modifier, ScrollState, Orientation, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1.7
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Modifier invoke(Modifier applyIfNotNull, ScrollState state2, Orientation orientation) {
                                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                                            Intrinsics.checkNotNullParameter(state2, "state");
                                                            Intrinsics.checkNotNullParameter(orientation, "orientation");
                                                            return ScrollableKt.scrollable(applyIfNotNull, state2, orientation);
                                                        }
                                                    }).then(rootModifier);
                                                    Alignment alignment = AlignmentKt.toAlignment(zLayer.getAlignment());
                                                    StackComponentState stackComponentState4 = stackComponentState;
                                                    final PaywallState.Loaded.Components components6 = components32;
                                                    final WindowInsets windowInsets4 = safeDrawing2;
                                                    float f6 = f32;
                                                    Function2<PaywallAction, Continuation<? super Unit>, Object> function26 = function232;
                                                    PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierThen42);
                                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor4);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    Composer composerM7248constructorimpl4 = Updater.m7248constructorimpl(composer4);
                                                    Updater.m7256setimpl(composerM7248constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m7256setimpl(composerM7248constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (composerM7248constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                        composerM7248constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                        composerM7248constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                    }
                                                    Updater.m7256setimpl(composerM7248constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -89672292, "C:StackComponentView.kt#280jdz");
                                                    composer4.startReplaceGroup(1798223283);
                                                    ComposerKt.sourceInformation(composer4, "*734@35268L398,740@35765L146,728@34861L1138");
                                                    for (ComponentStyle componentStyle : stackComponentState4.getChildren()) {
                                                        boolean z9 = stackComponentState4.getApplyTopWindowInsets() && !StackComponentViewKt.getShouldIgnoreTopWindowInsets(componentStyle);
                                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                                        boolean z10 = z9 && !stackComponentState4.getIgnoreHeaderHeight();
                                                        composer4.startReplaceGroup(194119182);
                                                        ComposerKt.sourceInformation(composer4, "CC(remember):StackComponentView.kt#9igjgp");
                                                        boolean zChanged72 = composer4.changed(components6) | composer4.changed(top);
                                                        Object objRememberedValue10 = composer4.rememberedValue();
                                                        if (zChanged72 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$8$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Modifier invoke(Modifier conditional) {
                                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                    return StackComponentViewKt.headerOrInsetsTopPadding(conditional, components6, top);
                                                                }
                                                            };
                                                            composer4.updateRememberedValue(objRememberedValue10);
                                                        }
                                                        composer4.endReplaceGroup();
                                                        Modifier modifierConditional4 = ModifierExtensionsKt.conditional(companion3, z10, (Function1) objRememberedValue10);
                                                        boolean z11 = z9 && stackComponentState4.getIgnoreHeaderHeight();
                                                        composer4.startReplaceGroup(194134834);
                                                        ComposerKt.sourceInformation(composer4, "CC(remember):StackComponentView.kt#9igjgp");
                                                        boolean zChanged82 = composer4.changed(windowInsets4);
                                                        Object objRememberedValue11 = composer4.rememberedValue();
                                                        if (zChanged82 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$stack$1$8$1$2$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Modifier invoke(Modifier conditional) {
                                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                                    return WindowInsetsPaddingKt.windowInsetsPadding(conditional, WindowInsetsKt.m2953onlybOOhFvg(windowInsets4, WindowInsetsSides.INSTANCE.m2983getTopJoeWqyM()));
                                                                }
                                                            };
                                                            composer4.updateRememberedValue(objRememberedValue11);
                                                        }
                                                        composer4.endReplaceGroup();
                                                        Modifier modifierAlpha = AlphaKt.alpha(ModifierExtensionsKt.conditional(modifierConditional4, z11, (Function1) objRememberedValue11), f6);
                                                        Function2<PaywallAction, Continuation<? super Unit>, Object> function27 = function26;
                                                        PaywallState.Loaded.Components components7 = components6;
                                                        ComponentViewKt.ComponentView(componentStyle, components7, function27, modifierAlpha, paywallComponentInteractionTracker4, composer4, 0, 0);
                                                        components6 = components7;
                                                        function26 = function27;
                                                    }
                                                    composer4.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceGroup();
                                                } else {
                                                    composer4.startReplaceGroup(376404448);
                                                    composer4.endReplaceGroup();
                                                }
                                            }
                                            composer4.endReplaceGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54);
                            BackgroundStyles background2 = stackComponentState.getBackground();
                            composerStartRestartGroup.startReplaceGroup(1234109811);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*752@36152L40");
                            if (background2 != null) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Shape shape2 = stackComponentState.getShape();
                            composerStartRestartGroup.startReplaceGroup(1234112175);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(shape2);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$composeShape$2$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final androidx.compose.p004ui.graphics.Shape invoke() {
                                        return ShapeKt.toShape(stackComponentState.getShape());
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                final State<? extends androidx.compose.p004ui.graphics.Shape> state2 = (State) objRememberedValue;
                                composerStartRestartGroup.endReplaceGroup();
                                BorderStyles border2 = stackComponentState.getBorder();
                                composerStartRestartGroup.startReplaceGroup(1234115915);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*754@36343L32");
                                if (border2 != null) {
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1234118015);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*756@36458L32");
                                if (z4) {
                                    i18 = i12;
                                    shadowStyleRememberShadowStyle = null;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1234123102);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                    zChanged2 = composerStartRestartGroup.changed(backgroundStyleRememberBackgroundStyle) | composerStartRestartGroup.changed(shadowStyleRememberShadowStyle);
                                    Object objRememberedValue42 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2) {
                                    }
                                    objRememberedValue42 = ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(Modifier.INSTANCE, stackComponentState.getMargin()), shadowStyleRememberShadowStyle, new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return ShadowKt.shadow(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$11(state2));
                                        }
                                    }), backgroundStyleRememberBackgroundStyle, new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$MainStackComponent$outerShapeModifier$1$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return BackgroundKt.background(applyIfNotNull, it, StackComponentViewKt.MainStackComponent$lambda$11(state2));
                                        }
                                    });
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue42);
                                    Modifier modifier722 = (Modifier) objRememberedValue42;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1234131942);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):StackComponentView.kt#9igjgp");
                                    int i2122 = i18 & 14;
                                    zChanged3 = (i2122 == 4) | composerStartRestartGroup.changed(borderStyleRememberBorderStyle);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged3) {
                                    }
                                }
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    modifier2 = modifier;
                    i6 = i3 & 64;
                    if (i6 != 0) {
                    }
                    i7 = i3 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i4;
                    i10 = i3 & 512;
                    if (i10 == 0) {
                    }
                    i12 = i9;
                    i13 = i3 & 1024;
                    if (i13 == 0) {
                    }
                    i16 = i3 & 2048;
                    if (i16 == 0) {
                    }
                    int i2022 = i15;
                    if ((i12 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                f2 = f;
                i5 = i3 & 32;
                if (i5 == 0) {
                }
                modifier2 = modifier;
                i6 = i3 & 64;
                if (i6 != 0) {
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i4;
                i10 = i3 & 512;
                if (i10 == 0) {
                }
                i12 = i9;
                i13 = i3 & 1024;
                if (i13 == 0) {
                }
                i16 = i3 & 2048;
                if (i16 == 0) {
                }
                int i20222 = i15;
                if ((i12 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function22 = function2;
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            f2 = f;
            i5 = i3 & 32;
            if (i5 == 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i4;
            i10 = i3 & 512;
            if (i10 == 0) {
            }
            i12 = i9;
            i13 = i3 & 1024;
            if (i13 == 0) {
            }
            i16 = i3 & 2048;
            if (i16 == 0) {
            }
            int i202222 = i15;
            if ((i12 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        components2 = components;
        if ((i3 & 4) == 0) {
        }
        function22 = function2;
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        f2 = f;
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i4;
        i10 = i3 & 512;
        if (i10 == 0) {
        }
        i12 = i9;
        i13 = i3 & 1024;
        if (i13 == 0) {
        }
        i16 = i3 & 2048;
        if (i16 == 0) {
        }
        int i2022222 = i15;
        if ((i12 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final boolean isTop(TwoDimensionalAlignment twoDimensionalAlignment) {
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment.ordinal()]) {
            case 1:
            case 3:
            case 4:
                return true;
            case 2:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ int getOverlaidBadgeOffsetY$default(int i, TwoDimensionalAlignment twoDimensionalAlignment, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 0.0f;
        }
        return getOverlaidBadgeOffsetY(i, twoDimensionalAlignment, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getOverlaidBadgeOffsetY(int i, TwoDimensionalAlignment twoDimensionalAlignment, float f) {
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment.ordinal()]) {
            case 1:
            case 3:
            case 4:
                return MathKt.roundToInt(-((i - f) / 2));
            case 2:
            case 5:
            case 6:
                return MathKt.roundToInt((i - f) / 2);
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CornerSize makeAbsolute(CornerSize cornerSize, Placeable placeable, Density density) {
        return m13981makeAbsolute12SF9DM(cornerSize, androidx.compose.p004ui.geometry.SizeKt.Size(placeable.getWidth(), placeable.getHeight()), density);
    }

    /* JADX INFO: renamed from: makeAbsolute-12SF9DM, reason: not valid java name */
    private static final CornerSize m13981makeAbsolute12SF9DM(CornerSize cornerSize, long j, Density density) {
        return CornerSizeKt.CornerSize(cornerSize.mo3226toPxTmRCtEA(j, density));
    }

    public static final boolean getUsesAllAvailableSpace(FlexDistribution flexDistribution) {
        Intrinsics.checkNotNullParameter(flexDistribution, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[flexDistribution.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getShouldIgnoreTopWindowInsets(ComponentStyle componentStyle) {
        if (componentStyle instanceof ImageComponentStyle) {
            return ((ImageComponentStyle) componentStyle).getIgnoreTopWindowInsets();
        }
        if (componentStyle instanceof VideoComponentStyle) {
            return ((VideoComponentStyle) componentStyle).getIgnoreTopWindowInsets();
        }
        if (componentStyle instanceof WebViewComponentStyle) {
            return ((WebViewComponentStyle) componentStyle).getIgnoreTopWindowInsets();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Vertical(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1372631849);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Vertical)991@45431L1643:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1372631849, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Vertical (StackComponentView.kt:990)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1587345289, "C996@45590L17,1028@47007L19,994@45502L1566:StackComponentView.kt#280jdz");
            float f = 16;
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(3), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Vertical$1$1(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Vertical.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_Vertical(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_NegativePaddingAndMarginClamped(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(99074730);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_NegativePaddingAndMarginClamped)1041@47524L1769:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(99074730, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_NegativePaddingAndMarginClamped (StackComponentView.kt:1037)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -320631682, "C1046@47683L17,1078@49226L19,1044@47595L1692:StackComponentView.kt#280jdz");
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(16), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))))), com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.PaddingKt.toPaddingValues$default(new Padding(-16.0d, -16.0d, -16.0d, -16.0d), false, 1, null), com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.PaddingKt.toPaddingValues$default(new Padding(-16.0d, -16.0d, -16.0d, -16.0d), false, 1, null), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(3), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7724x49a0f7d0(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_NegativePaddingAndMarginClamped.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_NegativePaddingAndMarginClamped(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-99980615);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll)1099@49825L1650:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99980615, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll (StackComponentView.kt:1087)");
            }
            IntRange intRange = new IntRange(0, 30);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(PreviewHelpersKt.previewTextComponentStyle("Hello " + ((IntIterator) it).nextInt(), (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0 ? true : true, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null));
            }
            ArrayList arrayList2 = arrayList;
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456327684, "C1136@51408L19,1102@49896L1573:StackComponentView.kt#280jdz");
            float f = 16;
            StackComponentView(new StackComponentStyle(arrayList2, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(3), null), null, Orientation.Vertical, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7735xc6ed5ba1(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Overlay_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1927454081);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Overlay_Badge)1158@52063L2038:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1927454081, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Overlay_Badge (StackComponentView.kt:1157)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -472937746, "C1171@52478L17,1207@54033L19,1169@52390L1705:StackComponentView.kt#280jdz");
            float f = 12;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(16), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(10), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(20), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(5), null), previewBadge$default(Badge.Style.Overlay, twoDimensionalAlignment, new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d, 20.0d, 20.0d, 20.0d)), null, PaddingKt.m2849PaddingValuesYgX7TsA$default(C1486Dp.m11017constructorimpl(8), 0.0f, 2, null), 8, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7729x1294adb3(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Overlay_Badge.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StackComponentViewKt.StackComponentView_Preview_Overlay_Badge(twoDimensionalAlignment, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_EdgeToEdge_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1687690690);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_EdgeToEdge_Badge)1218@54280L705:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1687690690, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_EdgeToEdge_Badge (StackComponentView.kt:1217)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 94392880, "C1226@54551L17,1235@54917L19,1224@54456L523:StackComponentView.kt#280jdz");
            composer2 = composerStartRestartGroup;
            StackComponentView(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(previewChildren(composerStartRestartGroup, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(20), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(5), null), (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.EdgeToEdge, twoDimensionalAlignment, new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7717xf49809ee(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_EdgeToEdge_Badge.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StackComponentViewKt.StackComponentView_Preview_EdgeToEdge_Badge(twoDimensionalAlignment, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Pill_EdgeToEdge_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1484368524);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Pill_EdgeToEdge_Badge)1246@55169L1604:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1484368524, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Pill_EdgeToEdge_Badge (StackComponentView.kt:1245)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 108037749, "C1251@55328L17,1282@56705L19,1249@55240L1527:StackComponentView.kt#280jdz");
            float f = 0;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(16), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), Shape.Pill.INSTANCE, new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(20), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(5), null), previewBadge$default(Badge.Style.EdgeToEdge, twoDimensionalAlignment, Shape.Pill.INSTANCE, null, null, 24, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7731xb239d87e(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Pill_EdgeToEdge_Badge.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StackComponentViewKt.StackComponentView_Preview_Pill_EdgeToEdge_Badge(twoDimensionalAlignment, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Nested_Badge(@PreviewParameter(provider = BadgeAlignmentProvider.class) final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1890270268);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Nested_Badge)1293@56948L1896:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(twoDimensionalAlignment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1890270268, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Nested_Badge (StackComponentView.kt:1292)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 543821991, "C1306@57363L17,1337@58776L19,1304@57275L1563:StackComponentView.kt#280jdz");
            float f = 20;
            float f2 = 0;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(16), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f2)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(10), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(5), null), previewBadge$default(Badge.Style.Nested, twoDimensionalAlignment, new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d, 20.0d, 20.0d, 20.0d)), null, null, 24, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Nested_Badge$1$1(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Nested_Badge.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StackComponentViewKt.StackComponentView_Preview_Nested_Badge(twoDimensionalAlignment, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Horizontal(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(537558075);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Horizontal)1347@59093L1644:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(537558075, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Horizontal (StackComponentView.kt:1346)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1111272646, "C1352@59252L17,1384@60669L19,1350@59164L1567:StackComponentView.kt#280jdz");
            float f = 16;
            StackComponentView(new StackComponentStyle(previewChildren(composerStartRestartGroup, 0), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(30), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(5), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Horizontal$1$1(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Horizontal.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_Horizontal(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Children_Extend_Over_Parent(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1849301685);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Children_Extend_Over_Parent)1393@60915L2057:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849301685, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Children_Extend_Over_Parent (StackComponentView.kt:1392)");
            }
            Modifier modifierM2016backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m2016backgroundbw27NRU$default(PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32)), Color.INSTANCE.m8178getGray0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884845424, "C1402@61214L17,1442@62904L19,1398@61035L1931:StackComponentView.kt#280jdz");
            float f = 0;
            float f2 = 16;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(previewChildren(composerStartRestartGroup, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(3), null), (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.Overlay, TwoDimensionalAlignment.TOP_TRAILING, new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null)), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f2), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f2)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7700x8f774f(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Children_Extend_Over_Parent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_Children_Extend_Over_Parent(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll */
    public static final void m1568x640f1d62(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-889520099);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll)1463@63508L1653:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-889520099, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll (StackComponentView.kt:1451)");
            }
            IntRange intRange = new IntRange(0, 10);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(PreviewHelpersKt.previewTextComponentStyle("Hello " + ((IntIterator) it).nextInt(), (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0 ? true : true, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null));
            }
            ArrayList arrayList2 = arrayList;
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1579483877, "C1500@65093L19,1466@63579L1576:StackComponentView.kt#280jdz");
            float f = 16;
            StackComponentView(new StackComponentStyle(arrayList2, new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(5), null), null, Orientation.Horizontal, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7733x71b6633d(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.m1568x640f1d62(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_ZLayer(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(665263624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_ZLayer)1511@65430L2581:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(665263624, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_ZLayer (StackComponentView.kt:1510)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(32));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 175980510, "C1564@67943L19,1514@65501L2504:StackComponentView.kt#280jdz");
            float f = 16;
            float f2 = 5;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU()))), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 24.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 24.0d), (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)}), new Dimension.ZLayer(TwoDimensionalAlignment.BOTTOM_TRAILING), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(20), C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(f2), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new StackComponentViewKt$StackComponentView_Preview_ZLayer$1$1(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_ZLayer.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_ZLayer(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_HorizontalChildrenFillWidth(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(94466939);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_HorizontalChildrenFillWidth)1608@69574L19,1573@68111L1517:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(94466939, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_HorizontalChildrenFillWidth (StackComponentView.kt:1572)");
            }
            float f = 16;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)}), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77201(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_HorizontalChildrenFillWidth.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_HorizontalChildrenFillWidth(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_HorizontalChildrenFillWidth$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_HorizontalChildrenFillWidth$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77201 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77201(Continuation<? super C77201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77201) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_VerticalChildrenFillHeight(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(89883392);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_VerticalChildrenFillHeight)1651@71176L19,1616@69727L1503:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(89883392, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_VerticalChildrenFillHeight (StackComponentView.kt:1615)");
            }
            float f = 16;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), SizeConstraint.Fill.INSTANCE), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), SizeConstraint.Fill.INSTANCE), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)}), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fixed(200, null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77381(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_VerticalChildrenFillHeight.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_VerticalChildrenFillHeight(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_VerticalChildrenFillHeight$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_VerticalChildrenFillHeight$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77381 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77381(Continuation<? super C77381> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77381(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77381) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size(@PreviewParameter(provider = DistributionProvider.class) Dimension dimension, Composer composer, final int i) {
        int i2;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(585047730);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size)1716@73805L19,1678@72127L1732:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(dimension) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585047730, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size (StackComponentView.kt:1672)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            TextComponentStyle[] textComponentStyleArr = new TextComponentStyle[3];
            textComponentStyleArr[0] = PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = AbstractJsonLexerKt.NULL;
            }
            textComponentStyleArr[1] = PreviewHelpersKt.previewTextComponentStyle(strName, (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            textComponentStyleArr[2] = PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            float f = 0;
            dimension2 = dimension;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) textComponentStyleArr), dimension, true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(16)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C77131(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            dimension2 = dimension;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size(dimension2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77131 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77131(Continuation<? super C77131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77131) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_Without_Spacing(@PreviewParameter(provider = DistributionProvider.class) Dimension dimension, Composer composer, final int i) {
        int i2;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1146712254);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_Without_Spacing)1769@75922L19,1731@74232L1744:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(dimension) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1146712254, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_Without_Spacing (StackComponentView.kt:1725)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            TextComponentStyle[] textComponentStyleArr = new TextComponentStyle[3];
            textComponentStyleArr[0] = PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = AbstractJsonLexerKt.NULL;
            }
            textComponentStyleArr[1] = PreviewHelpersKt.previewTextComponentStyle(strName, (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            textComponentStyleArr[2] = PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            float f = 0;
            dimension2 = dimension;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) textComponentStyleArr), dimension, true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(16)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C77111(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            dimension2 = dimension;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing(dimension2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77111 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77111(Continuation<? super C77111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77111) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children */
    public static final void m1565x279d95ed(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2040912590);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children)1818@77909L19,1777@76092L1871:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040912590, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children (StackComponentView.kt:1776)");
            }
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("SPACE_AROUND", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)}), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.SPACE_AROUND), true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), C1486Dp.m11017constructorimpl(8), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(16)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77071(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.m1565x279d95ed(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77071 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77071(Continuation<? super C77071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77071(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77071) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_With_Spacing(@PreviewParameter(provider = DistributionProvider.class) Dimension dimension, Composer composer, final int i) {
        int i2;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2060177158);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Distribution_With_Spacing)1871@80024L19,1833@78333L1745:StackComponentView.kt#280jdz");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(dimension) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2060177158, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_With_Spacing (StackComponentView.kt:1827)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            TextComponentStyle[] textComponentStyleArr = new TextComponentStyle[3];
            textComponentStyleArr[0] = PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = AbstractJsonLexerKt.NULL;
            }
            textComponentStyleArr[1] = PreviewHelpersKt.previewTextComponentStyle(strName, (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            textComponentStyleArr[2] = PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null);
            float f = 16;
            dimension2 = dimension;
            composer2 = composerStartRestartGroup;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) textComponentStyleArr), dimension, true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C77091(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            dimension2 = dimension;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_With_Spacing.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StackComponentViewKt.StackComponentView_Preview_Distribution_With_Spacing(dimension2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_With_Spacing$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_With_Spacing$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77091 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77091(Continuation<? super C77091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77091) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_HorizontalDivider(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1466582790);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_HorizontalDivider)1879@80168L1082:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1466582790, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_HorizontalDivider (StackComponentView.kt:1878)");
            }
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1819063567, "C1882@80247L50,1900@81123L19,1883@80306L879,1903@81194L50:StackComponentView.kt#280jdz");
            TextKt.m5868Text4IGK_g("There should be a divider below this text.", (Modifier) null, 0L, 0L, (FontStyle) null, (androidx.compose.p004ui.text.font.FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 6, 0, 131070);
            StackComponentView(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.emptyList(), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.SPACE_BETWEEN), (31966 & 4) != 0 ? true : true, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(1, null)), (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : C1486Dp.m11017constructorimpl(0), (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(ColorKt.Color$default(200, 200, 200, 0, 8, null))), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2849PaddingValuesYgX7TsA$default(0.0f, C1486Dp.m11017constructorimpl(40), 1, null), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C7722xd46a1234(null), null, null, false, null, 0.0f, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            composer2 = composerStartRestartGroup;
            TextKt.m5868Text4IGK_g("There should be a divider above this text.", (Modifier) null, 0L, 0L, (FontStyle) null, (androidx.compose.p004ui.text.font.FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 6, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_HorizontalDivider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_HorizontalDivider(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_VerticalDivider(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-843904936);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_VerticalDivider)1910@81338L1233:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843904936, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_VerticalDivider (StackComponentView.kt:1909)");
            }
            Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(100));
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2910height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1672201207, "C1914@81460L134,1932@82361L19,1918@81603L820,1935@82432L133:StackComponentView.kt#280jdz");
            composer2 = composerStartRestartGroup;
            TextKt.m5868Text4IGK_g("There should be a divider to the right of this text.", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (androidx.compose.p004ui.text.font.FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 6, 0, 131068);
            StackComponentView(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.emptyList(), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.SPACE_BETWEEN), (31966 & 4) != 0 ? true : true, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fixed(1, null), SizeConstraint.Fill.INSTANCE), (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : C1486Dp.m11017constructorimpl(0), (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(ColorKt.Color$default(200, 200, 200, 0, 8, null))), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2849PaddingValuesYgX7TsA$default(C1486Dp.m11017constructorimpl(40), 0.0f, 2, null), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C7740x3202ace2(null), null, null, false, null, 0.0f, null, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 504);
            TextKt.m5868Text4IGK_g("There should be a divider to the left of this text.", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (androidx.compose.p004ui.text.font.FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 6, 0, 131068);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_VerticalDivider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_VerticalDivider(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_ContentAlpha(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1355314342);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_ContentAlpha)1947@82743L17,1949@82789L19,1945@82656L215:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1355314342, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_ContentAlpha (StackComponentView.kt:1944)");
            }
            StackComponentView(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(previewChildren(composerStartRestartGroup, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77051(null), null, null, false, null, 0.6f, null, composerStartRestartGroup, 12583296, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_ContentAlpha.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.StackComponentView_Preview_ContentAlpha(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_ContentAlpha$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_ContentAlpha$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77051 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77051(Continuation<? super C77051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77051(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77051) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow */
    public static final void m1564x36266ba2(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1499195869);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow)1994@84908L19,1963@83463L1527:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1499195869, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow (StackComponentView.kt:1962)");
            }
            float f = 0;
            StackComponentView(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Nested", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8185getWhite0d7_KjU())), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(16)), (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : new Shape.Rectangle(new CornerRadiuses.C7411Dp(4.0d)), (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(24), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), null), (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8183getTransparent0d7_KjU())), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(32)), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : new Shape.Rectangle(new CornerRadiuses.C7411Dp(32.0d)), (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77021(null), null, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, false, null, 0.0f, null, composerStartRestartGroup, 24960, 488);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.m1564x36266ba2(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Clickable_With_Overflowing_Child_Shadow$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77021 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77021(Continuation<? super C77021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77021(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77021) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: StackComponentView_Preview_NestedBadge_Caller_Modifier_Applied_Twice */
    public static final void m1567x51f65523(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1034392508);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_NestedBadge_Caller_Modifier_Applied_Twice)2025@86277L19,2005@85324L1051:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1034392508, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_NestedBadge_Caller_Modifier_Applied_Twice (StackComponentView.kt:2004)");
            }
            StackComponentView(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Inner content", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8185getWhite0d7_KjU())), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(12)), (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : new Shape.Rectangle(new CornerRadiuses.C7411Dp(12.0d)), (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.Nested, TwoDimensionalAlignment.TOP_TRAILING, new Shape.Rectangle(new CornerRadiuses.C7411Dp(6.0d)), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77261(null), PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(40)), null, false, null, 0.0f, null, composerStartRestartGroup, 3456, 496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_NestedBadge_Caller_Modifier_Applied_Twice.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.m1567x51f65523(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_NestedBadge_Caller_Modifier_Applied_Twice$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_NestedBadge_Caller_Modifier_Applied_Twice$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77261 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77261(Continuation<? super C77261> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77261(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77261) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: StackComponentView_Preview_EdgeToEdgeBadge_Caller_Modifier_Applied_Twice */
    public static final void m1566x51d07065(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1538455354);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StackComponentView_Preview_EdgeToEdgeBadge_Caller_Modifier_Applied_Twice)2056@87670L19,2036@86713L1055:StackComponentView.kt#280jdz");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1538455354, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_EdgeToEdgeBadge_Caller_Modifier_Applied_Twice (StackComponentView.kt:2035)");
            }
            StackComponentView(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Inner content", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8185getWhite0d7_KjU())), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(12)), (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : new Shape.Rectangle(new CornerRadiuses.C7411Dp(12.0d)), (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.EdgeToEdge, TwoDimensionalAlignment.TOP_TRAILING, new Shape.Rectangle(new CornerRadiuses.C7411Dp(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77151(null), PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(40)), null, false, null, 0.0f, null, composerStartRestartGroup, 3456, 496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_EdgeToEdgeBadge_Caller_Modifier_Applied_Twice.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    StackComponentViewKt.m1566x51d07065(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_EdgeToEdgeBadge_Caller_Modifier_Applied_Twice$1 */
    /* JADX INFO: compiled from: StackComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_EdgeToEdgeBadge_Caller_Modifier_Applied_Twice$1", m1609f = "StackComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77151 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77151(Continuation<? super C77151> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77151(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77151) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    private static final List<TextComponentStyle> previewChildren(Composer composer, int i) {
        composer.startReplaceGroup(-407337990);
        ComposerKt.sourceInformation(composer, "C(previewChildren):StackComponentView.kt#280jdz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-407337990, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.previewChildren (StackComponentView.kt:2063)");
        }
        List<TextComponentStyle> listListOf = CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle("Hello", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("World", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)});
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return listListOf;
    }

    private static final BadgeStyle previewBadge(Badge.Style style, TwoDimensionalAlignment twoDimensionalAlignment, Shape shape, PaddingValues paddingValues, PaddingValues paddingValues2) {
        return new BadgeStyle(new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Badge", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(0), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(45.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8179getGreen0d7_KjU()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8186getYellow0d7_KjU()), 80.0f)}))), null, 2, null))), paddingValues, paddingValues2, shape, null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), style, twoDimensionalAlignment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier headerOrInsetsTopPadding(Modifier modifier, final PaywallState.Loaded.Components components, final int i) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.headerOrInsetsTopPadding.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m13984invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m13984invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final int headerHeightPx = components.getHeaderHeightPx() > 0 ? components.getHeaderHeightPx() : i;
                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(ConstraintsKt.m10990offsetNN6EwU$default(j, 0, -headerHeightPx, 1, null));
                return MeasureScope.layout$default(layout, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight() + headerHeightPx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.headerOrInsetsTopPadding.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.placeRelative$default(layout2, placeableMo9625measureBRTryo0, 0, headerHeightPx, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    static /* synthetic */ BadgeStyle previewBadge$default(Badge.Style style, TwoDimensionalAlignment twoDimensionalAlignment, Shape shape, PaddingValues paddingValues, PaddingValues paddingValues2, int i, Object obj) {
        if ((i & 8) != 0) {
            paddingValues = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0));
        }
        if ((i & 16) != 0) {
            paddingValues2 = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0));
        }
        return previewBadge(style, twoDimensionalAlignment, shape, paddingValues, paddingValues2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.p004ui.graphics.Shape StackWithLongEdgeToEdgeBadge$lambda$5(State<? extends androidx.compose.p004ui.graphics.Shape> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.p004ui.graphics.Shape MainStackComponent$lambda$11(State<? extends androidx.compose.p004ui.graphics.Shape> state) {
        return state.getValue();
    }
}
