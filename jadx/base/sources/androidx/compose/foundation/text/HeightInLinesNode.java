package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.node.LayoutModifierNodeKt;
import androidx.compose.p004ui.node.ObserverModifierNode;
import androidx.compose.p004ui.node.ObserverModifierNodeKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.TextStyleKt;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.State;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HeightInLinesModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J#\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, m1599d2 = {"Landroidx/compose/foundation/text/HeightInLinesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minLines", "", "maxLines", "<init>", "(Landroidx/compose/ui/text/TextStyle;II)V", "dirty", "", "precomputedMinLinesHeight", "precomputedMaxLinesHeight", "resolvedStyle", "fontResolutionState", "Landroidx/compose/runtime/State;", "", "requireResolvedStyle", "requireFontResolutionState", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "onAttach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "onObservedReadsChanged", "onFontResolutionStateChanged", "onLayoutDirectionChange", "onDensityChange", "onDetach", "update", "computeHeights", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class HeightInLinesNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode, ObserverModifierNode {
    private boolean dirty;
    private State<? extends Object> fontResolutionState;
    private int maxLines;
    private int minLines;
    private TextStyle resolvedStyle;
    private final boolean shouldAutoInvalidate;
    private TextStyle textStyle;
    private int precomputedMinLinesHeight = -1;
    private int precomputedMaxLinesHeight = -1;

    public HeightInLinesNode(TextStyle textStyle, int i, int i2) {
        this.textStyle = textStyle;
        this.minLines = i;
        this.maxLines = i2;
    }

    private final TextStyle requireResolvedStyle() {
        TextStyle textStyle = this.resolvedStyle;
        if (textStyle != null) {
            return textStyle;
        }
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Resolved style is not set.");
        throw new KotlinNothingValueException();
    }

    private final State<Object> requireFontResolutionState() {
        State<? extends Object> state = this.fontResolutionState;
        if (state != null) {
            return state;
        }
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Font resolution state is not set.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        FontFamily.Resolver resolver = (FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFontFamilyResolver());
        this.resolvedStyle = TextStyleKt.resolveDefaults(this.textStyle, DelegatableNodeKt.requireLayoutDirection(this));
        FontFamily fontFamily = requireResolvedStyle().getFontFamily();
        FontWeight fontWeight = requireResolvedStyle().getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontStyle fontStyleM10485getFontStyle4Lr2A7w = requireResolvedStyle().m10485getFontStyle4Lr2A7w();
        int iM10570unboximpl = fontStyleM10485getFontStyle4Lr2A7w != null ? fontStyleM10485getFontStyle4Lr2A7w.m10570unboximpl() : FontStyle.INSTANCE.m10574getNormal_LCdwA();
        FontSynthesis fontSynthesisM10486getFontSynthesisZQGJjVo = requireResolvedStyle().m10486getFontSynthesisZQGJjVo();
        this.fontResolutionState = resolver.mo10539resolveDPcqOEQ(fontFamily, fontWeight, iM10570unboximpl, fontSynthesisM10486getFontSynthesisZQGJjVo != null ? fontSynthesisM10486getFontSynthesisZQGJjVo.m10583unboximpl() : FontSynthesis.INSTANCE.m10584getAllGVVA2EU());
        ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.text.HeightInLinesNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HeightInLinesNode.onAttach$lambda$0(this.f$0);
            }
        });
        this.dirty = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttach$lambda$0(HeightInLinesNode heightInLinesNode) {
        heightInLinesNode.requireFontResolutionState().getValue();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM10971getMinHeightimpl;
        int iM10969getMaxHeightimpl;
        if (this.dirty) {
            computeHeights(measureScope, requireResolvedStyle(), (FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFontFamilyResolver()));
            this.dirty = false;
        }
        int i = this.precomputedMinLinesHeight;
        if (i != -1) {
            iM10971getMinHeightimpl = RangesKt.coerceIn(i, Constraints.m10971getMinHeightimpl(j), Constraints.m10969getMaxHeightimpl(j));
        } else {
            iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(j);
        }
        int i2 = iM10971getMinHeightimpl;
        int i3 = this.precomputedMaxLinesHeight;
        if (i3 != -1) {
            iM10969getMaxHeightimpl = RangesKt.coerceIn(i3, Constraints.m10971getMinHeightimpl(j), Constraints.m10969getMaxHeightimpl(j));
        } else {
            iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(j);
        }
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, i2, iM10969getMaxHeightimpl, 3, null));
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.HeightInLinesNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeightInLinesNode.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        onFontResolutionStateChanged();
    }

    private final void onFontResolutionStateChanged() {
        if (this.fontResolutionState != null) {
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.text.HeightInLinesNode$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HeightInLinesNode.onFontResolutionStateChanged$lambda$0(this.f$0);
                }
            });
        }
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFontResolutionStateChanged$lambda$0(HeightInLinesNode heightInLinesNode) {
        heightInLinesNode.requireFontResolutionState().getValue();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.node.DelegatableNode
    public void onLayoutDirectionChange() {
        this.resolvedStyle = TextStyleKt.resolveDefaults(this.textStyle, DelegatableNodeKt.requireLayoutDirection(this));
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.p004ui.node.DelegatableNode, androidx.compose.p004ui.node.PointerInputModifierNode
    public void onDensityChange() {
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.resolvedStyle = null;
        this.fontResolutionState = null;
        this.dirty = false;
    }

    public final void update(TextStyle textStyle, int minLines, int maxLines) {
        if (Intrinsics.areEqual(this.textStyle, textStyle) && this.minLines == minLines && this.maxLines == maxLines) {
            return;
        }
        this.textStyle = textStyle;
        this.minLines = minLines;
        this.maxLines = maxLines;
        this.resolvedStyle = TextStyleKt.resolveDefaults(textStyle, DelegatableNodeKt.requireLayoutDirection(this));
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    private final void computeHeights(Density density, TextStyle resolvedStyle, FontFamily.Resolver fontFamilyResolver) {
        int iComputeSizeForDefaultText = (int) (TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1) & 4294967295L);
        int iComputeSizeForDefaultText2 = ((int) (TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2) & 4294967295L)) - iComputeSizeForDefaultText;
        int i = this.minLines;
        this.precomputedMinLinesHeight = i == 1 ? -1 : ((i - 1) * iComputeSizeForDefaultText2) + iComputeSizeForDefaultText;
        int i2 = this.maxLines;
        this.precomputedMaxLinesHeight = i2 != Integer.MAX_VALUE ? iComputeSizeForDefaultText + (iComputeSizeForDefaultText2 * (i2 - 1)) : -1;
    }
}
