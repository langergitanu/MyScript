package androidx.compose.material3.tokens;

import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.GenericFontFamily;
import kotlin.Metadata;

/* JADX INFO: compiled from: TypographyTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b=\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007¨\u0006B"}, m1599d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "<init>", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "BodyLargeEmphasized", "getBodyLargeEmphasized", "BodyMediumEmphasized", "getBodyMediumEmphasized", "BodySmallEmphasized", "getBodySmallEmphasized", "DisplayLargeEmphasized", "getDisplayLargeEmphasized", "DisplayMediumEmphasized", "getDisplayMediumEmphasized", "DisplaySmallEmphasized", "getDisplaySmallEmphasized", "HeadlineLargeEmphasized", "getHeadlineLargeEmphasized", "HeadlineMediumEmphasized", "getHeadlineMediumEmphasized", "HeadlineSmallEmphasized", "getHeadlineSmallEmphasized", "LabelLargeEmphasized", "getLabelLargeEmphasized", "LabelMediumEmphasized", "getLabelMediumEmphasized", "LabelSmallEmphasized", "getLabelSmallEmphasized", "TitleLargeEmphasized", "getTitleLargeEmphasized", "TitleMediumEmphasized", "getTitleMediumEmphasized", "TitleSmallEmphasized", "getTitleSmallEmphasized", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class TypographyTokens {
    public static final int $stable = 0;
    private static final TextStyle BodyLarge;
    private static final TextStyle BodyLargeEmphasized;
    private static final TextStyle BodyMedium;
    private static final TextStyle BodyMediumEmphasized;
    private static final TextStyle BodySmall;
    private static final TextStyle BodySmallEmphasized;
    private static final TextStyle DisplayLarge;
    private static final TextStyle DisplayLargeEmphasized;
    private static final TextStyle DisplayMedium;
    private static final TextStyle DisplayMediumEmphasized;
    private static final TextStyle DisplaySmall;
    private static final TextStyle DisplaySmallEmphasized;
    private static final TextStyle HeadlineLarge;
    private static final TextStyle HeadlineLargeEmphasized;
    private static final TextStyle HeadlineMedium;
    private static final TextStyle HeadlineMediumEmphasized;
    private static final TextStyle HeadlineSmall;
    private static final TextStyle HeadlineSmallEmphasized;
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    private static final TextStyle LabelLarge;
    private static final TextStyle LabelLargeEmphasized;
    private static final TextStyle LabelMedium;
    private static final TextStyle LabelMediumEmphasized;
    private static final TextStyle LabelSmall;
    private static final TextStyle LabelSmallEmphasized;
    private static final TextStyle TitleLarge;
    private static final TextStyle TitleLargeEmphasized;
    private static final TextStyle TitleMedium;
    private static final TextStyle TitleMediumEmphasized;
    private static final TextStyle TitleSmall;
    private static final TextStyle TitleSmallEmphasized;

    private TypographyTokens() {
    }

    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    static {
        TextStyle defaultTextStyle = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyLargeFont = TypeScaleTokens.INSTANCE.getBodyLargeFont();
        BodyLarge = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle, 0L, TypeScaleTokens.INSTANCE.m7077getBodyLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyLargeWeight(), null, null, bodyLargeFont, null, TypeScaleTokens.INSTANCE.m7078getBodyLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7076getBodyLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle2 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyMediumFont = TypeScaleTokens.INSTANCE.getBodyMediumFont();
        BodyMedium = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle2, 0L, TypeScaleTokens.INSTANCE.m7083getBodyMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyMediumWeight(), null, null, bodyMediumFont, null, TypeScaleTokens.INSTANCE.m7084getBodyMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7082getBodyMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle3 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodySmallFont = TypeScaleTokens.INSTANCE.getBodySmallFont();
        BodySmall = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle3, 0L, TypeScaleTokens.INSTANCE.m7089getBodySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodySmallWeight(), null, null, bodySmallFont, null, TypeScaleTokens.INSTANCE.m7090getBodySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7088getBodySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle4 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayLargeFont = TypeScaleTokens.INSTANCE.getDisplayLargeFont();
        DisplayLarge = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle4, 0L, TypeScaleTokens.INSTANCE.m7095getDisplayLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayLargeWeight(), null, null, displayLargeFont, null, TypeScaleTokens.INSTANCE.m7096getDisplayLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7094getDisplayLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle5 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayMediumFont = TypeScaleTokens.INSTANCE.getDisplayMediumFont();
        DisplayMedium = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle5, 0L, TypeScaleTokens.INSTANCE.m7101getDisplayMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayMediumWeight(), null, null, displayMediumFont, null, TypeScaleTokens.INSTANCE.m7102getDisplayMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7100getDisplayMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle6 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displaySmallFont = TypeScaleTokens.INSTANCE.getDisplaySmallFont();
        DisplaySmall = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle6, 0L, TypeScaleTokens.INSTANCE.m7107getDisplaySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplaySmallWeight(), null, null, displaySmallFont, null, TypeScaleTokens.INSTANCE.m7108getDisplaySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7106getDisplaySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle7 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineLargeFont = TypeScaleTokens.INSTANCE.getHeadlineLargeFont();
        HeadlineLarge = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle7, 0L, TypeScaleTokens.INSTANCE.m7113getHeadlineLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineLargeWeight(), null, null, headlineLargeFont, null, TypeScaleTokens.INSTANCE.m7114getHeadlineLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7112getHeadlineLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle8 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineMediumFont = TypeScaleTokens.INSTANCE.getHeadlineMediumFont();
        HeadlineMedium = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle8, 0L, TypeScaleTokens.INSTANCE.m7119getHeadlineMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineMediumWeight(), null, null, headlineMediumFont, null, TypeScaleTokens.INSTANCE.m7120getHeadlineMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7118getHeadlineMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle9 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineSmallFont = TypeScaleTokens.INSTANCE.getHeadlineSmallFont();
        HeadlineSmall = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle9, 0L, TypeScaleTokens.INSTANCE.m7125getHeadlineSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineSmallWeight(), null, null, headlineSmallFont, null, TypeScaleTokens.INSTANCE.m7126getHeadlineSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7124getHeadlineSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle10 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelLargeFont = TypeScaleTokens.INSTANCE.getLabelLargeFont();
        LabelLarge = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle10, 0L, TypeScaleTokens.INSTANCE.m7131getLabelLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelLargeWeight(), null, null, labelLargeFont, null, TypeScaleTokens.INSTANCE.m7132getLabelLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7130getLabelLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle11 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelMediumFont = TypeScaleTokens.INSTANCE.getLabelMediumFont();
        LabelMedium = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle11, 0L, TypeScaleTokens.INSTANCE.m7137getLabelMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelMediumWeight(), null, null, labelMediumFont, null, TypeScaleTokens.INSTANCE.m7138getLabelMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7136getLabelMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle12 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelSmallFont = TypeScaleTokens.INSTANCE.getLabelSmallFont();
        LabelSmall = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle12, 0L, TypeScaleTokens.INSTANCE.m7143getLabelSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelSmallWeight(), null, null, labelSmallFont, null, TypeScaleTokens.INSTANCE.m7144getLabelSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7142getLabelSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle13 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleLargeFont = TypeScaleTokens.INSTANCE.getTitleLargeFont();
        TitleLarge = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle13, 0L, TypeScaleTokens.INSTANCE.m7149getTitleLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleLargeWeight(), null, null, titleLargeFont, null, TypeScaleTokens.INSTANCE.m7150getTitleLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7148getTitleLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle14 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleMediumFont = TypeScaleTokens.INSTANCE.getTitleMediumFont();
        TitleMedium = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle14, 0L, TypeScaleTokens.INSTANCE.m7155getTitleMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleMediumWeight(), null, null, titleMediumFont, null, TypeScaleTokens.INSTANCE.m7156getTitleMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7154getTitleMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle15 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleSmallFont = TypeScaleTokens.INSTANCE.getTitleSmallFont();
        TitleSmall = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle15, 0L, TypeScaleTokens.INSTANCE.m7161getTitleSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleSmallWeight(), null, null, titleSmallFont, null, TypeScaleTokens.INSTANCE.m7162getTitleSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7160getTitleSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle16 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyLargeEmphasizedFont = TypeScaleTokens.INSTANCE.getBodyLargeEmphasizedFont();
        BodyLargeEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle16, 0L, TypeScaleTokens.INSTANCE.m7074getBodyLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyLargeEmphasizedWeight(), null, null, bodyLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7075getBodyLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7073getBodyLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle17 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyMediumEmphasizedFont = TypeScaleTokens.INSTANCE.getBodyMediumEmphasizedFont();
        BodyMediumEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle17, 0L, TypeScaleTokens.INSTANCE.m7080getBodyMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyMediumEmphasizedWeight(), null, null, bodyMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7081getBodyMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7079getBodyMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle18 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodySmallEmphasizedFont = TypeScaleTokens.INSTANCE.getBodySmallEmphasizedFont();
        BodySmallEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle18, 0L, TypeScaleTokens.INSTANCE.m7086getBodySmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodySmallEmphasizedWeight(), null, null, bodySmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7087getBodySmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7085getBodySmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle19 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayLargeEmphasizedFont = TypeScaleTokens.INSTANCE.getDisplayLargeEmphasizedFont();
        DisplayLargeEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle19, 0L, TypeScaleTokens.INSTANCE.m7092getDisplayLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayLargeEmphasizedWeight(), null, null, displayLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7093getDisplayLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7091getDisplayLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle20 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayMediumEmphasizedFont = TypeScaleTokens.INSTANCE.getDisplayMediumEmphasizedFont();
        DisplayMediumEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle20, 0L, TypeScaleTokens.INSTANCE.m7098getDisplayMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayMediumEmphasizedWeight(), null, null, displayMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7099getDisplayMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7097getDisplayMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle21 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displaySmallEmphasizedFont = TypeScaleTokens.INSTANCE.getDisplaySmallEmphasizedFont();
        DisplaySmallEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle21, 0L, TypeScaleTokens.INSTANCE.m7104getDisplaySmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplaySmallEmphasizedWeight(), null, null, displaySmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7105getDisplaySmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7103getDisplaySmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle22 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineLargeEmphasizedFont = TypeScaleTokens.INSTANCE.getHeadlineLargeEmphasizedFont();
        HeadlineLargeEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle22, 0L, TypeScaleTokens.INSTANCE.m7110getHeadlineLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineLargeEmphasizedWeight(), null, null, headlineLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7111getHeadlineLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7109getHeadlineLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle23 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineMediumEmphasizedFont = TypeScaleTokens.INSTANCE.getHeadlineMediumEmphasizedFont();
        HeadlineMediumEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle23, 0L, TypeScaleTokens.INSTANCE.m7116getHeadlineMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineMediumEmphasizedWeight(), null, null, headlineMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7117getHeadlineMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7115getHeadlineMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle24 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineSmallEmphasizedFont = TypeScaleTokens.INSTANCE.getHeadlineSmallEmphasizedFont();
        HeadlineSmallEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle24, 0L, TypeScaleTokens.INSTANCE.m7122getHeadlineSmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineSmallEmphasizedWeight(), null, null, headlineSmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7123getHeadlineSmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7121getHeadlineSmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle25 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelLargeEmphasizedFont = TypeScaleTokens.INSTANCE.getLabelLargeEmphasizedFont();
        LabelLargeEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle25, 0L, TypeScaleTokens.INSTANCE.m7128getLabelLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelLargeEmphasizedWeight(), null, null, labelLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7129getLabelLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7127getLabelLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle26 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelMediumEmphasizedFont = TypeScaleTokens.INSTANCE.getLabelMediumEmphasizedFont();
        LabelMediumEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle26, 0L, TypeScaleTokens.INSTANCE.m7134getLabelMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelMediumEmphasizedWeight(), null, null, labelMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7135getLabelMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7133getLabelMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle27 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelSmallEmphasizedFont = TypeScaleTokens.INSTANCE.getLabelSmallEmphasizedFont();
        LabelSmallEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle27, 0L, TypeScaleTokens.INSTANCE.m7140getLabelSmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelSmallEmphasizedWeight(), null, null, labelSmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7141getLabelSmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7139getLabelSmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle28 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleLargeEmphasizedFont = TypeScaleTokens.INSTANCE.getTitleLargeEmphasizedFont();
        TitleLargeEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle28, 0L, TypeScaleTokens.INSTANCE.m7146getTitleLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleLargeEmphasizedWeight(), null, null, titleLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7147getTitleLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7145getTitleLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle29 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleMediumEmphasizedFont = TypeScaleTokens.INSTANCE.getTitleMediumEmphasizedFont();
        TitleMediumEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle29, 0L, TypeScaleTokens.INSTANCE.m7152getTitleMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleMediumEmphasizedWeight(), null, null, titleMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7153getTitleMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7151getTitleMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle30 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleSmallEmphasizedFont = TypeScaleTokens.INSTANCE.getTitleSmallEmphasizedFont();
        TitleSmallEmphasized = TextStyle.m10466copyp1EtxEg$default(defaultTextStyle30, 0L, TypeScaleTokens.INSTANCE.m7158getTitleSmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleSmallEmphasizedWeight(), null, null, titleSmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m7159getTitleSmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m7157getTitleSmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
    }

    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }

    public final TextStyle getBodyLargeEmphasized() {
        return BodyLargeEmphasized;
    }

    public final TextStyle getBodyMediumEmphasized() {
        return BodyMediumEmphasized;
    }

    public final TextStyle getBodySmallEmphasized() {
        return BodySmallEmphasized;
    }

    public final TextStyle getDisplayLargeEmphasized() {
        return DisplayLargeEmphasized;
    }

    public final TextStyle getDisplayMediumEmphasized() {
        return DisplayMediumEmphasized;
    }

    public final TextStyle getDisplaySmallEmphasized() {
        return DisplaySmallEmphasized;
    }

    public final TextStyle getHeadlineLargeEmphasized() {
        return HeadlineLargeEmphasized;
    }

    public final TextStyle getHeadlineMediumEmphasized() {
        return HeadlineMediumEmphasized;
    }

    public final TextStyle getHeadlineSmallEmphasized() {
        return HeadlineSmallEmphasized;
    }

    public final TextStyle getLabelLargeEmphasized() {
        return LabelLargeEmphasized;
    }

    public final TextStyle getLabelMediumEmphasized() {
        return LabelMediumEmphasized;
    }

    public final TextStyle getLabelSmallEmphasized() {
        return LabelSmallEmphasized;
    }

    public final TextStyle getTitleLargeEmphasized() {
        return TitleLargeEmphasized;
    }

    public final TextStyle getTitleMediumEmphasized() {
        return TitleMediumEmphasized;
    }

    public final TextStyle getTitleSmallEmphasized() {
        return TitleSmallEmphasized;
    }
}
