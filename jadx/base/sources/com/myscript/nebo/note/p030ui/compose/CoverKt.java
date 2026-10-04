package com.myscript.nebo.note.p030ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.note.Orientation;
import com.myscript.snt.dms.CoverColorUtilsExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: cover.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aI\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001eH\u0007¢\u0006\u0004\b!\u0010\"\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\r*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000f\"\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0014\u001a\u00020\t*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, m1599d2 = {"colorsWithGradient", "", "Landroidx/compose/ui/graphics/Color;", "getColorsWithGradient", "()Ljava/util/List;", "colorsPlain", "getColorsPlain", "coverColorsList", "Lkotlinx/collections/immutable/PersistentList;", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "getCoverColorsList", "()Lkotlinx/collections/immutable/PersistentList;", "isPortrait", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "(Lcom/myscript/nebo/dms/core/model/PageModel;)Z", "orientation", "Lcom/myscript/nebo/note/Orientation;", "getOrientation", "(Lcom/myscript/nebo/dms/core/model/PageModel;)Lcom/myscript/nebo/note/Orientation;", "coverData", "getCoverData", "(Lcom/myscript/nebo/dms/core/model/PageModel;)Lcom/myscript/nebo/note/ui/compose/CoverData;", "Cover", "", "cover", "modifier", "Landroidx/compose/ui/Modifier;", "showBackground", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elasticWidth", "elasticOffsetEnd", "Cover-xKlaLpw", "(Lcom/myscript/nebo/note/ui/compose/CoverData;Landroidx/compose/ui/Modifier;ZFFFLandroidx/compose/runtime/Composer;II)V", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CoverKt {
    private static final List<Color> colorsPlain;
    private static final List<Color> colorsWithGradient;
    private static final PersistentList<CoverData> coverColorsList;

    /* JADX INFO: compiled from: cover.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Portrait.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Cover_xKlaLpw$lambda$1(CoverData coverData, Modifier modifier, boolean z, float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        m13292CoverxKlaLpw(coverData, modifier, z, f, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final List<Color> getColorsWithGradient() {
        return colorsWithGradient;
    }

    static {
        List<Color> listListOf = CollectionsKt.listOf((Object[]) new Color[]{Color.m8138boximpl(ColorKt.Color(4288884990L)), Color.m8138boximpl(ColorKt.Color(4293209721L)), Color.m8138boximpl(ColorKt.Color(4281216726L)), Color.m8138boximpl(ColorKt.Color(4279934975L)), Color.m8138boximpl(ColorKt.Color(4278577802L)), Color.m8138boximpl(ColorKt.Color(4289255004L)), Color.m8138boximpl(ColorKt.Color(4293779716L)), Color.m8138boximpl(ColorKt.Color(4294945543L)), Color.m8138boximpl(ColorKt.Color(4294125633L))});
        colorsWithGradient = listListOf;
        colorsPlain = CollectionsKt.listOf((Object[]) new Color[]{Color.m8138boximpl(ColorKt.Color(4291590399L)), Color.m8138boximpl(ColorKt.Color(4294938044L)), Color.m8138boximpl(ColorKt.Color(4286156799L)), Color.m8138boximpl(ColorKt.Color(4286495231L)), Color.m8138boximpl(ColorKt.Color(4287823825L)), Color.m8138boximpl(ColorKt.Color(4291952517L)), Color.m8138boximpl(ColorKt.Color(4294966163L)), Color.m8138boximpl(ColorKt.Color(4294955902L)), Color.m8138boximpl(ColorKt.Color(4294929516L))});
        List<Color> list = listListOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            long jM8158unboximpl = ((Color) it.next()).m8158unboximpl();
            arrayList.add(ExtensionsKt.persistentListOf(Color.m8138boximpl(jM8158unboximpl), Color.m8138boximpl(ColorKt.Color(CoverColorUtilsExt.computeGradientEndColor(ColorKt.m8202toArgb8_81llA(jM8158unboximpl))))));
        }
        ArrayList arrayList2 = arrayList;
        List<Color> list2 = colorsPlain;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            long jM8158unboximpl2 = ((Color) it2.next()).m8158unboximpl();
            arrayList3.add(ExtensionsKt.persistentListOf(Color.m8138boximpl(ColorKt.Color(ColorKt.m8202toArgb8_81llA(jM8158unboximpl2))), Color.m8138boximpl(ColorKt.Color(ColorKt.m8202toArgb8_81llA(jM8158unboximpl2)))));
        }
        List<Pair> listZip = CollectionsKt.zip(arrayList2, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Pair pair : listZip) {
            CollectionsKt.addAll(arrayList4, CollectionsKt.listOf((Object[]) new CoverData[]{new CoverData((ImmutableList) pair.getFirst(), null, 2, null), new CoverData((ImmutableList) pair.getSecond(), null, 2, null)}));
        }
        coverColorsList = ExtensionsKt.toPersistentList(arrayList4);
    }

    public static final List<Color> getColorsPlain() {
        return colorsPlain;
    }

    public static final PersistentList<CoverData> getCoverColorsList() {
        return coverColorsList;
    }

    public static final boolean isPortrait(PageModel pageModel) {
        Intrinsics.checkNotNullParameter(pageModel, "<this>");
        return pageModel.getPaperSize().isPortrait();
    }

    public static final Orientation getOrientation(PageModel pageModel) {
        Intrinsics.checkNotNullParameter(pageModel, "<this>");
        return pageModel.getPaperSize().isPortrait() ? Orientation.Portrait : Orientation.Landscape;
    }

    public static final CoverData getCoverData(PageModel pageModel) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(pageModel, "<this>");
        List<Integer> coverColors = pageModel.getCoverColors();
        int size = coverColors.size();
        int i = 0;
        if (size == 0) {
            ArrayList arrayList2 = new ArrayList(2);
            while (i < 2) {
                arrayList2.add(Color.m8138boximpl(Color.INSTANCE.m8181getMagenta0d7_KjU()));
                i++;
            }
            arrayList = arrayList2;
        } else if (size == 1) {
            ArrayList arrayList3 = new ArrayList(2);
            while (i < 2) {
                arrayList3.add(Color.m8138boximpl(ColorKt.Color(((Number) CollectionsKt.first((List) coverColors)).intValue())));
                i++;
            }
            arrayList = arrayList3;
        } else {
            List<Integer> list = coverColors;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList4.add(Color.m8138boximpl(ColorKt.Color(((Number) it.next()).intValue())));
            }
            arrayList = arrayList4;
        }
        return new CoverData(ExtensionsKt.toImmutableList(arrayList), getOrientation(pageModel));
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX INFO: renamed from: Cover-xKlaLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m13292CoverxKlaLpw(final CoverData cover, Modifier modifier, boolean z, float f, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        float fM11017constructorimpl;
        int i6;
        float fM11017constructorimpl2;
        int i7;
        float f4;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifierBackground$default;
        Intrinsics.checkNotNullParameter(cover, "cover");
        Composer composerStartRestartGroup = composer.startRestartGroup(1142341752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Cover)N(cover,modifier,showBackground,cornerRadius:c#ui.unit.Dp,elasticWidth:c#ui.unit.Dp,elasticOffsetEnd:c#ui.unit.Dp)111@3892L6,111@3827L597:cover.kt#ku1rws");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(cover) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
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
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        fM11017constructorimpl = f;
                        i3 |= composerStartRestartGroup.changed(fM11017constructorimpl) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 != 0) {
                        if ((i & 24576) == 0) {
                            fM11017constructorimpl2 = f2;
                            i3 |= composerStartRestartGroup.changed(fM11017constructorimpl2) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                            f4 = f3;
                        } else {
                            f4 = f3;
                            if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                                i3 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
                            }
                        }
                        if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            f5 = f4;
                        } else {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i5 != 0) {
                                fM11017constructorimpl = C1486Dp.m11017constructorimpl(16);
                            }
                            if (i6 != 0) {
                                fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(10);
                            }
                            float fM11017constructorimpl3 = i7 != 0 ? C1486Dp.m11017constructorimpl(16) : f4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1142341752, i3, -1, "com.myscript.nebo.note.ui.compose.Cover (cover.kt:96)");
                            }
                            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(ClipKt.clip(modifier2, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(fM11017constructorimpl)), 0.75f, false, 2, null);
                            int i9 = WhenMappings.$EnumSwitchMapping$0[cover.getOrientation().ordinal()];
                            if (i9 == 1) {
                                modifierBackground$default = BackgroundKt.background$default(modifierAspectRatio$default, Brush.Companion.m8103verticalGradient8A3gB4$default(Brush.INSTANCE, cover.getColors(), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                            } else {
                                if (i9 != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                modifierBackground$default = BackgroundKt.background$default(AspectRatioKt.aspectRatio$default(ClipKt.clip(modifier2, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(fM11017constructorimpl)), 1.3333334f, false, 2, null), Brush.Companion.m8103verticalGradient8A3gB4$default(Brush.INSTANCE, cover.getColors(), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                            }
                            Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(modifierAspectRatio$default, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), z2 ? 0.05f : 0.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1083713995, "C112@4006L412:cover.kt#ku1rws");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
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
                            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1781969795, "C115@4068L340:cover.kt#ku1rws");
                            BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.m2929width3ABfNKs(PaddingKt.m2858paddingqDBjuR0$default(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterEnd()), 0.0f, 0.0f, fM11017constructorimpl3, 0.0f, 11, null), fM11017constructorimpl2), 0.0f, 1, null), Color.m8147copywmQWz5c$default(Color.INSTANCE.m8174getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f5 = fM11017constructorimpl3;
                        }
                        final boolean z3 = z2;
                        final float f6 = fM11017constructorimpl;
                        final float f7 = fM11017constructorimpl2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.CoverKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CoverKt.Cover_xKlaLpw$lambda$1(cover, modifier3, z3, f6, f7, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 24576;
                    fM11017constructorimpl2 = f2;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                    }
                    final boolean z32 = z2;
                    final float f62 = fM11017constructorimpl;
                    final float f72 = fM11017constructorimpl2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                fM11017constructorimpl = f;
                i6 = i2 & 16;
                if (i6 != 0) {
                }
                fM11017constructorimpl2 = f2;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                }
                final boolean z322 = z2;
                final float f622 = fM11017constructorimpl;
                final float f722 = fM11017constructorimpl2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            fM11017constructorimpl = f;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            fM11017constructorimpl2 = f2;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
            }
            final boolean z3222 = z2;
            final float f6222 = fM11017constructorimpl;
            final float f7222 = fM11017constructorimpl2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        fM11017constructorimpl = f;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        fM11017constructorimpl2 = f2;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
        }
        final boolean z32222 = z2;
        final float f62222 = fM11017constructorimpl;
        final float f72222 = fM11017constructorimpl2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
