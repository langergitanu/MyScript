package com.revenuecat.purchases.p036ui.revenuecatui.components.timeline;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.ZIndexModifierKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.node.Ref;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.LayoutReference;
import androidx.constraintlayout.compose.RawConstraintSet;
import com.revenuecat.purchases.p036ui.revenuecatui.components.iconcomponent.IconComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.text.TextComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1 */
/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$contentDelegate$1"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class C7812x9800cf94 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ Ref $compositionSource;
    final /* synthetic */ MutableState $contentTracker;
    final /* synthetic */ MutableState $end;
    final /* synthetic */ ConstraintLayoutScope $scope;
    final /* synthetic */ MutableState $start;
    final /* synthetic */ PaywallState.Loaded.Components $state$inlined;
    final /* synthetic */ TimelineComponentState $timelineState$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7812x9800cf94(MutableState mutableState, Ref ref, ConstraintLayoutScope constraintLayoutScope, Channel channel, MutableState mutableState2, MutableState mutableState3, TimelineComponentState timelineComponentState, PaywallState.Loaded.Components components) {
        super(2);
        this.$contentTracker = mutableState;
        this.$compositionSource = ref;
        this.$scope = constraintLayoutScope;
        this.$channel = channel;
        this.$start = mutableState2;
        this.$end = mutableState3;
        this.$timelineState$inlined = timelineComponentState;
        this.$state$inlined = components;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(Composer composer, int i) {
        Object obj;
        int i2;
        float fM11017constructorimpl;
        Iterator it;
        float fM11017constructorimpl2;
        float fM11017constructorimpl3;
        int i3;
        PaddingValues paddingValuesM2847PaddingValues0680j_4;
        ArrayList arrayList;
        int i4;
        Object obj2;
        IconComponentStyle icon;
        Size size;
        SizeConstraint height;
        C1486Dp c1486DpDpOrNull;
        ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor;
        ConstrainedLayoutReference constrainedLayoutReference;
        ConstrainedLayoutReference constrainedLayoutReference2;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C381@17480L14,383@17562L681,383@17551L692:ConstraintLayout.kt#fysre8");
        int i5 = 2;
        if ((i & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-74958949, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
            }
            this.$contentTracker.setValue(Unit.INSTANCE);
            if (this.$compositionSource.getValue() == CompositionSource.Unknown) {
                this.$compositionSource.setValue(CompositionSource.Content);
            }
            this.$scope.reset();
            ConstraintLayoutScope constraintLayoutScope = this.$scope;
            composer2.startReplaceGroup(-425493899);
            ComposerKt.sourceInformation(composer2, "C83@4232L174:TimelineComponentView.kt#1cibm8");
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            composer2.startReplaceGroup(-290820944);
            ComposerKt.sourceInformation(composer2, "CC(remember):TimelineComponentView.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new C7818x84728ef8(this.$timelineState$inlined));
                composer2.updateRememberedValue(objRememberedValue);
            }
            State state = (State) objRememberedValue;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-290812107);
            ComposerKt.sourceInformation(composer2, "*100@4937L80,98@4807L225,106@5108L699,105@5046L987,131@6191L788,128@6047L947");
            Iterator it2 = this.$timelineState$inlined.getItems().iterator();
            Composer composer3 = composer2;
            while (true) {
                obj = null;
                i2 = 1;
                if (!it2.hasNext()) {
                    break;
                }
                TimelineComponentState.ItemState itemState = (TimelineComponentState.ItemState) it2.next();
                ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope.createRefs();
                ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
                ConstrainedLayoutReference constrainedLayoutReferenceComponent4 = constrainedLayoutReferencesCreateRefs.component4();
                ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                LayoutReference[] layoutReferenceArr = new LayoutReference[3];
                layoutReferenceArr[0] = constrainedLayoutReferenceComponent1;
                layoutReferenceArr[1] = constrainedLayoutReferenceComponent2;
                layoutReferenceArr[i5] = constrainedLayoutReferenceComponent3;
                ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorM11311createBottomBarrier3ABfNKs$default = ConstraintLayoutBaseScope.m11311createBottomBarrier3ABfNKs$default(constraintLayoutScope2, layoutReferenceArr, 0.0f, i5, null);
                ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2 = (ConstraintLayoutBaseScope.HorizontalAnchor) CollectionsKt.lastOrNull((List) arrayList2);
                arrayList3.add(constrainedLayoutReferenceComponent1);
                ArrayList arrayList4 = arrayList3;
                arrayList2.add(ConstraintLayoutBaseScope.m11311createBottomBarrier3ABfNKs$default(constraintLayoutScope2, new LayoutReference[]{constrainedLayoutReferenceComponent4}, 0.0f, i5, null));
                Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(this.$timelineState$inlined.getItemSpacing()));
                composer3.startReplaceGroup(-290798478);
                ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                boolean zChanged = composer3.changed(horizontalAnchorM11311createBottomBarrier3ABfNKs$default);
                Object objRememberedValue2 = composer3.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$1$1(horizontalAnchorM11311createBottomBarrier3ABfNKs$default);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                composer3.endReplaceGroup();
                SpacerKt.Spacer(constraintLayoutScope.constrainAs(modifierM2910height3ABfNKs, constrainedLayoutReferenceComponent4, (Function1) objRememberedValue2), composer3, 0);
                Modifier.Companion companion = Modifier.INSTANCE;
                composer3.startReplaceGroup(-290792387);
                ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                boolean zChanged2 = composer3.changed(this.$timelineState$inlined) | composer3.changed(horizontalAnchor2) | composer3.changed(constrainedLayoutReferenceComponent2) | composer3.changed(constrainedLayoutReferenceComponent3);
                Object objRememberedValue3 = composer3.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    horizontalAnchor = horizontalAnchor2;
                    Object timelineComponentViewKt$TimelineComponentView$2$2$1 = new TimelineComponentViewKt$TimelineComponentView$2$2$1(this.$timelineState$inlined, horizontalAnchor, constrainedLayoutReferenceComponent2, constrainedLayoutReferenceComponent3, state);
                    constrainedLayoutReference = constrainedLayoutReferenceComponent2;
                    constrainedLayoutReference2 = constrainedLayoutReferenceComponent3;
                    objRememberedValue3 = (Function1) timelineComponentViewKt$TimelineComponentView$2$2$1;
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    horizontalAnchor = horizontalAnchor2;
                    constrainedLayoutReference = constrainedLayoutReferenceComponent2;
                    constrainedLayoutReference2 = constrainedLayoutReferenceComponent3;
                }
                composer3.endReplaceGroup();
                Modifier modifierConstrainAs = constraintLayoutScope.constrainAs(companion, constrainedLayoutReferenceComponent1, (Function1) objRememberedValue3);
                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierConstrainAs);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer3);
                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 341218704, "C121@5841L178:TimelineComponentView.kt#1cibm8");
                IconComponentViewKt.IconComponentView(itemState.getIcon(), this.$state$inlined, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composer, 0, 0);
                Composer composer4 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                TextComponentStyle title = itemState.getTitle();
                PaywallState.Loaded.Components components = this.$state$inlined;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                composer4.startReplaceGroup(-290757642);
                ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                boolean zChanged3 = composer4.changed(this.$timelineState$inlined) | composer4.changed(constrainedLayoutReferenceComponent1) | composer4.changed(horizontalAnchor);
                Object objRememberedValue4 = composer4.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$4$1(this.$timelineState$inlined, constrainedLayoutReferenceComponent1, horizontalAnchor);
                    composer4.updateRememberedValue(objRememberedValue4);
                }
                composer4.endReplaceGroup();
                TextComponentViewKt.TextComponentView(title, components, constraintLayoutScope.constrainAs(companion2, constrainedLayoutReference, (Function1) objRememberedValue4), null, composer4, 0, 8);
                TextComponentStyle description = itemState.getDescription();
                composer4.startReplaceGroup(-290731176);
                ComposerKt.sourceInformation(composer4, "*155@7202L325,152@7048L498");
                if (description != null) {
                    PaywallState.Loaded.Components components2 = this.$state$inlined;
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    composer4.startReplaceGroup(149598086);
                    ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                    boolean zChanged4 = composer4.changed(constrainedLayoutReference) | composer4.changed(this.$timelineState$inlined);
                    Object objRememberedValue5 = composer4.rememberedValue();
                    if (zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$5$1$1(constrainedLayoutReference, this.$timelineState$inlined);
                        composer4.updateRememberedValue(objRememberedValue5);
                    }
                    composer4.endReplaceGroup();
                    TextComponentViewKt.TextComponentView(description, components2, constraintLayoutScope.constrainAs(companion3, constrainedLayoutReference2, (Function1) objRememberedValue5), null, composer4, 0, 8);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                composer4.endReplaceGroup();
                arrayList3 = arrayList4;
                i5 = 2;
                composer3 = composer4;
            }
            ArrayList arrayList5 = arrayList3;
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(-290710782);
            ComposerKt.sourceInformation(composer3, "");
            Iterator it3 = this.$timelineState$inlined.getItems().iterator();
            int i6 = 0;
            while (it3.hasNext()) {
                int i7 = i6 + 1;
                TimelineComponentState.ItemState itemState2 = (TimelineComponentState.ItemState) it3.next();
                boolean z = i6 == this.$timelineState$inlined.getItems().size() - i2 ? i2 : 0;
                ArrayList arrayList6 = arrayList5;
                ConstrainedLayoutReference constrainedLayoutReference3 = (ConstrainedLayoutReference) arrayList6.get(i6);
                ConstrainedLayoutReference constrainedLayoutReference4 = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList6, i7);
                TimelineComponentStyle.ConnectorStyle connector = itemState2.getConnector();
                composer3.startReplaceGroup(-290702701);
                ComposerKt.sourceInformation(composer3, "*172@7964L548,191@8991L843,204@9884L15,186@8726L1193");
                if (connector == null) {
                    it = it3;
                    i4 = i2;
                    i3 = i7;
                    arrayList = arrayList6;
                    obj2 = obj;
                } else {
                    ConstrainedLayoutReference constrainedLayoutReferenceCreateRef = constraintLayoutScope.createRef();
                    Object size2 = itemState2.getIcon().getSize();
                    composer3.startReplaceGroup(149622693);
                    ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                    boolean zChanged5 = composer3.changed(size2) | composer3.changed(constrainedLayoutReferenceCreateRef);
                    Object objRememberedValue6 = composer3.rememberedValue();
                    if (zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        SizeConstraint height2 = itemState2.getIcon().getSize().getHeight();
                        if ((height2 instanceof SizeConstraint.Fixed ? (SizeConstraint.Fixed) height2 : null) != null) {
                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(r3.getValue()) / 2);
                        } else {
                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                        }
                        C1486Dp c1486DpTimelineComponentView$lambda$13$lambda$1 = TimelineComponentViewKt.TimelineComponentView$lambda$13$lambda$1(state);
                        if (c1486DpTimelineComponentView$lambda$13$lambda$1 != null) {
                            int iM11031unboximpl = (int) c1486DpTimelineComponentView$lambda$13$lambda$1.m11031unboximpl();
                            it = it3;
                            fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(iM11031unboximpl - (itemState2.getConnector() != null ? r15.getWidth() : 0)) / 2);
                        } else {
                            it = it3;
                            fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(0);
                        }
                        objRememberedValue6 = TuplesKt.m1606to(C1486Dp.m11015boximpl(fM11017constructorimpl2), C1486Dp.m11015boximpl(fM11017constructorimpl));
                        composer3.updateRememberedValue(objRememberedValue6);
                    } else {
                        it = it3;
                    }
                    Pair pair = (Pair) objRememberedValue6;
                    composer3.endReplaceGroup();
                    TimelineComponentState.ItemState itemState3 = (TimelineComponentState.ItemState) CollectionsKt.getOrNull(this.$timelineState$inlined.getItems(), i7);
                    if (itemState3 != null && (icon = itemState3.getIcon()) != null && (size = icon.getSize()) != null && (height = size.getHeight()) != null && (c1486DpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(height)) != null) {
                        fM11017constructorimpl3 = c1486DpDpOrNull.m11031unboximpl();
                    } else {
                        fM11017constructorimpl3 = C1486Dp.m11017constructorimpl(0);
                    }
                    float fM11017constructorimpl4 = C1486Dp.m11017constructorimpl(fM11017constructorimpl3 / 2);
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    TimelineComponentStyle.ConnectorStyle connector2 = itemState2.getConnector();
                    if (connector2 == null || (paddingValuesM2847PaddingValues0680j_4 = connector2.getMargin()) == null) {
                        i3 = i7;
                        paddingValuesM2847PaddingValues0680j_4 = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0));
                    } else {
                        i3 = i7;
                    }
                    arrayList = arrayList6;
                    i4 = 1;
                    Modifier modifierZIndex = ZIndexModifierKt.zIndex(OffsetKt.m2811offsetVpY3zN4$default(PaddingKt.padding(companion4, paddingValuesM2847PaddingValues0680j_4), 0.0f, ((C1486Dp) pair.getSecond()).m11031unboximpl(), 1, null), -1.0f);
                    composer3.startReplaceGroup(149655852);
                    ComposerKt.sourceInformation(composer3, "CC(remember):TimelineComponentView.kt#9igjgp");
                    boolean zChanged6 = composer3.changed(pair) | composer3.changed(itemState2) | composer3.changed(constrainedLayoutReference3) | composer3.changed(z) | composer3.changed(constrainedLayoutReference4) | composer3.changed(fM11017constructorimpl4);
                    Object objRememberedValue7 = composer3.rememberedValue();
                    if (zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = (Function1) new TimelineComponentViewKt$TimelineComponentView$2$6$1$1(pair, itemState2, constrainedLayoutReference3, z, constrainedLayoutReference4, fM11017constructorimpl4);
                        composer3.updateRememberedValue(objRememberedValue7);
                    }
                    composer3.endReplaceGroup();
                    obj2 = null;
                    BoxKt.Box(OverlayKt.overlay$default(constraintLayoutScope.constrainAs(modifierZIndex, constrainedLayoutReferenceCreateRef, (Function1) objRememberedValue7), ColorStyleKt.getForCurrentTheme(connector.getColor(), composer3, 0), null, 2, null), composer3, 0);
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
                composer3.endReplaceGroup();
                obj = obj2;
                i2 = i4;
                it3 = it;
                i6 = i3;
                arrayList5 = arrayList;
            }
            composer3.endReplaceGroup();
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer3, -1730039667, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = composer3.changedInstance(this.$scope) | composer3.changedInstance(this.$channel);
            final ConstraintLayoutScope constraintLayoutScope3 = this.$scope;
            final MutableState mutableState = this.$start;
            final MutableState mutableState2 = this.$end;
            final Channel channel = this.$channel;
            Object objRememberedValue8 = composer3.rememberedValue();
            if (zChangedInstance || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope3.getContainerObject().mo11498clone());
                        if (mutableState.getValue() == null || mutableState2.getValue() == null) {
                            mutableState.setValue(rawConstraintSet);
                            mutableState2.setValue(mutableState.getValue());
                        } else {
                            channel.mo16021trySendJP2dKIU(rawConstraintSet);
                        }
                    }
                };
                composer3.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.SideEffect((Function0) objRememberedValue8, composer3, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
