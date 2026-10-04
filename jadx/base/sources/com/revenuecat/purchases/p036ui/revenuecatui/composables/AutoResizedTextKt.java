package com.revenuecat.purchases.p036ui.revenuecatui.composables;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.common.C2181C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoResizedText.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002"}, m1599d2 = {"AutoResizedText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "style", "Landroidx/compose/ui/text/TextStyle;", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_TEXT_ALIGN, "Landroidx/compose/ui/text/style/TextAlign;", "AutoResizedText-W72HBGU", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsRelease", "resizedTextStyle", "shouldDraw", ""}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class AutoResizedTextKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /* JADX INFO: renamed from: AutoResizedText-W72HBGU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m14040AutoResizedTextW72HBGU(final String text, Modifier modifier, long j, TextStyle textStyle, FontWeight fontWeight, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        long jM8184getUnspecified0d7_KjU;
        TextStyle bodySmall;
        int i6;
        FontWeight bold;
        int i7;
        int iM10895getCentere0LSkKk;
        int i8;
        Modifier modifier3;
        FontWeight fontWeight2;
        Object objRememberedValue;
        final MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        final long jM10484getFontSizeXSAIIZE;
        Object objRememberedValue3;
        boolean zChanged;
        Object objRememberedValue4;
        TextStyle textStyle2;
        Composer composer2;
        final long j2;
        final FontWeight fontWeight3;
        final int i9;
        final TextStyle textStyle3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(1940856369);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoResizedText)P(4,2,0:c#ui.graphics.Color,3!,5:c#ui.text.style.TextAlign)30@1137L46,33@1206L46,44@1470L101,51@1656L526,38@1299L890:AutoResizedText.kt#51odh9");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    jM8184getUnspecified0d7_KjU = j;
                    i4 |= composerStartRestartGroup.changed(jM8184getUnspecified0d7_KjU) ? 256 : 128;
                }
                if ((i2 & 3072) == 0) {
                    if ((i3 & 8) == 0) {
                        bodySmall = textStyle;
                        int i11 = composerStartRestartGroup.changed(bodySmall) ? 2048 : 1024;
                        i4 |= i11;
                    } else {
                        bodySmall = textStyle;
                    }
                    i4 |= i11;
                } else {
                    bodySmall = textStyle;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i2 & 24576) == 0) {
                        bold = fontWeight;
                        i4 |= composerStartRestartGroup.changed(bold) ? 16384 : 8192;
                    }
                    if ((196608 & i2) != 0) {
                        if ((i3 & 32) == 0) {
                            i7 = i;
                            int i12 = composerStartRestartGroup.changed(i7) ? 131072 : 65536;
                            i4 |= i12;
                        } else {
                            i7 = i;
                        }
                        i4 |= i12;
                    } else {
                        i7 = i;
                    }
                    if ((i4 & 74899) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "26@992L10");
                        if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                            }
                        } else {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                jM8184getUnspecified0d7_KjU = Color.INSTANCE.m8184getUnspecified0d7_KjU();
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                                bodySmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall();
                            }
                            if (i6 != 0) {
                                bold = FontWeight.INSTANCE.getBold();
                            }
                            if ((i3 & 32) == 0) {
                                iM10895getCentere0LSkKk = TextAlign.INSTANCE.m10895getCentere0LSkKk();
                                i8 = i4 & (-458753);
                                modifier3 = modifier2;
                                fontWeight2 = bold;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1940856369, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.AutoResizedText (AutoResizedText.kt:29)");
                            }
                            composerStartRestartGroup.startReplaceGroup(583049355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bodySmall, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(583051563);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            composerStartRestartGroup.endReplaceGroup();
                            jM10484getFontSizeXSAIIZE = bodySmall.m10484getFontSizeXSAIIZE();
                            composerStartRestartGroup.startReplaceGroup(583060066);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AutoResizedTextKt$AutoResizedText$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                        invoke2(contentDrawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ContentDrawScope drawWithContent) {
                                        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                                        if (AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$4(mutableState2)) {
                                            drawWithContent.drawContent();
                                        }
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue3);
                            TextStyle textStyleAutoResizedText_W72HBGU$lambda$1 = AutoResizedText_W72HBGU$lambda$1(mutableState);
                            TextAlign textAlignM10888boximpl = TextAlign.m10888boximpl(iM10895getCentere0LSkKk);
                            composerStartRestartGroup.startReplaceGroup(583066443);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                            zChanged = ((((i8 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(bodySmall)) || (i8 & 3072) == 2048) | composerStartRestartGroup.changed(jM10484getFontSizeXSAIIZE);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                final TextStyle textStyle4 = bodySmall;
                                textStyle2 = textStyle4;
                                objRememberedValue4 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AutoResizedTextKt$AutoResizedText$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult result) {
                                        Intrinsics.checkNotNullParameter(result, "result");
                                        if (!result.getDidOverflowWidth()) {
                                            AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$5(mutableState2, true);
                                            return;
                                        }
                                        if (TextUnitKt.m11229isUnspecifiedR2X_6o(textStyle4.m10484getFontSizeXSAIIZE())) {
                                            MutableState<TextStyle> mutableState3 = mutableState;
                                            mutableState3.setValue(TextStyle.m10466copyp1EtxEg$default(AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$1(mutableState3), 0L, jM10484getFontSizeXSAIIZE, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
                                        }
                                        long jM10484getFontSizeXSAIIZE2 = AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$1(mutableState).m10484getFontSizeXSAIIZE();
                                        TextUnitKt.m11224checkArithmeticR2X_6o(jM10484getFontSizeXSAIIZE2);
                                        long jPack = TextUnitKt.pack(TextUnit.m11209getRawTypeimpl(jM10484getFontSizeXSAIIZE2), (float) (((double) TextUnit.m11211getValueimpl(jM10484getFontSizeXSAIIZE2)) * 0.95d));
                                        MutableState<TextStyle> mutableState4 = mutableState;
                                        mutableState4.setValue(TextStyle.m10466copyp1EtxEg$default(AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$1(mutableState4), 0L, jPack, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                textStyle2 = bodySmall;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifier5 = modifier3;
                            composer2 = composerStartRestartGroup;
                            long j3 = jM8184getUnspecified0d7_KjU;
                            TextKt.m5868Text4IGK_g(text, modifierDrawWithContent, j3, 0L, (FontStyle) null, fontWeight2, (FontFamily) null, 0L, (TextDecoration) null, textAlignM10888boximpl, 0L, 0, false, 0, 0, (Function1) objRememberedValue4, textStyleAutoResizedText_W72HBGU$lambda$1, composer2, (i8 & 910) | ((i8 << 3) & 458752) | ((i8 << 12) & C2181C.ENCODING_PCM_DOUBLE), RendererCapabilities.DECODER_SUPPORT_MASK, 28120);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j2 = j3;
                            fontWeight3 = fontWeight2;
                            i9 = iM10895getCentere0LSkKk;
                            textStyle3 = textStyle2;
                            modifier4 = modifier5;
                        }
                        i8 = i4;
                        modifier3 = modifier2;
                        fontWeight2 = bold;
                        iM10895getCentere0LSkKk = i7;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.startReplaceGroup(583049355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(583051563);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        jM10484getFontSizeXSAIIZE = bodySmall.m10484getFontSizeXSAIIZE();
                        composerStartRestartGroup.startReplaceGroup(583060066);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierDrawWithContent2 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue3);
                        TextStyle textStyleAutoResizedText_W72HBGU$lambda$12 = AutoResizedText_W72HBGU$lambda$1(mutableState);
                        TextAlign textAlignM10888boximpl2 = TextAlign.m10888boximpl(iM10895getCentere0LSkKk);
                        composerStartRestartGroup.startReplaceGroup(583066443);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                        if (((i8 & 7168) ^ 3072) > 2048) {
                            zChanged = ((((i8 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(bodySmall)) || (i8 & 3072) == 2048) | composerStartRestartGroup.changed(jM10484getFontSizeXSAIIZE);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                final TextStyle textStyle42 = bodySmall;
                                textStyle2 = textStyle42;
                                objRememberedValue4 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AutoResizedTextKt$AutoResizedText$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult result) {
                                        Intrinsics.checkNotNullParameter(result, "result");
                                        if (!result.getDidOverflowWidth()) {
                                            AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$5(mutableState2, true);
                                            return;
                                        }
                                        if (TextUnitKt.m11229isUnspecifiedR2X_6o(textStyle42.m10484getFontSizeXSAIIZE())) {
                                            MutableState<TextStyle> mutableState3 = mutableState;
                                            mutableState3.setValue(TextStyle.m10466copyp1EtxEg$default(AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$1(mutableState3), 0L, jM10484getFontSizeXSAIIZE, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
                                        }
                                        long jM10484getFontSizeXSAIIZE2 = AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$1(mutableState).m10484getFontSizeXSAIIZE();
                                        TextUnitKt.m11224checkArithmeticR2X_6o(jM10484getFontSizeXSAIIZE2);
                                        long jPack = TextUnitKt.pack(TextUnit.m11209getRawTypeimpl(jM10484getFontSizeXSAIIZE2), (float) (((double) TextUnit.m11211getValueimpl(jM10484getFontSizeXSAIIZE2)) * 0.95d));
                                        MutableState<TextStyle> mutableState4 = mutableState;
                                        mutableState4.setValue(TextStyle.m10466copyp1EtxEg$default(AutoResizedTextKt.AutoResizedText_W72HBGU$lambda$1(mutableState4), 0L, jPack, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                composerStartRestartGroup.endReplaceGroup();
                                Modifier modifier52 = modifier3;
                                composer2 = composerStartRestartGroup;
                                long j32 = jM8184getUnspecified0d7_KjU;
                                TextKt.m5868Text4IGK_g(text, modifierDrawWithContent2, j32, 0L, (FontStyle) null, fontWeight2, (FontFamily) null, 0L, (TextDecoration) null, textAlignM10888boximpl2, 0L, 0, false, 0, 0, (Function1) objRememberedValue4, textStyleAutoResizedText_W72HBGU$lambda$12, composer2, (i8 & 910) | ((i8 << 3) & 458752) | ((i8 << 12) & C2181C.ENCODING_PCM_DOUBLE), RendererCapabilities.DECODER_SUPPORT_MASK, 28120);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                j2 = j32;
                                fontWeight3 = fontWeight2;
                                i9 = iM10895getCentere0LSkKk;
                                textStyle3 = textStyle2;
                                modifier4 = modifier52;
                            }
                        } else {
                            zChanged = ((((i8 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(bodySmall)) || (i8 & 3072) == 2048) | composerStartRestartGroup.changed(jM10484getFontSizeXSAIIZE);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                            }
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier2;
                        j2 = jM8184getUnspecified0d7_KjU;
                        textStyle3 = bodySmall;
                        fontWeight3 = bold;
                        i9 = i7;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AutoResizedTextKt$AutoResizedText$3
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
                                AutoResizedTextKt.m14040AutoResizedTextW72HBGU(text, modifier4, j2, textStyle3, fontWeight3, i9, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                bold = fontWeight;
                if ((196608 & i2) != 0) {
                }
                if ((i4 & 74899) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "26@992L10");
                    if ((i2 & 1) == 0) {
                        if (i10 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i3 & 8) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i3 & 32) == 0) {
                            i8 = i4;
                            modifier3 = modifier2;
                            fontWeight2 = bold;
                            iM10895getCentere0LSkKk = i7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.startReplaceGroup(583049355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(583051563);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        jM10484getFontSizeXSAIIZE = bodySmall.m10484getFontSizeXSAIIZE();
                        composerStartRestartGroup.startReplaceGroup(583060066);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierDrawWithContent22 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue3);
                        TextStyle textStyleAutoResizedText_W72HBGU$lambda$122 = AutoResizedText_W72HBGU$lambda$1(mutableState);
                        TextAlign textAlignM10888boximpl22 = TextAlign.m10888boximpl(iM10895getCentere0LSkKk);
                        composerStartRestartGroup.startReplaceGroup(583066443);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AutoResizedText.kt#9igjgp");
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            jM8184getUnspecified0d7_KjU = j;
            if ((i2 & 3072) == 0) {
            }
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            bold = fontWeight;
            if ((196608 & i2) != 0) {
            }
            if ((i4 & 74899) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        jM8184getUnspecified0d7_KjU = j;
        if ((i2 & 3072) == 0) {
        }
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        bold = fontWeight;
        if ((196608 & i2) != 0) {
        }
        if ((i4 & 74899) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle AutoResizedText_W72HBGU$lambda$1(MutableState<TextStyle> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AutoResizedText_W72HBGU$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AutoResizedText_W72HBGU$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }
}
