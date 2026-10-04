package com.survicate.surveys.presentation.theming;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.FontSource;
import com.survicate.surveys.SurvicateFontSystem;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.storage.interfaces.SurvicateFontSystemProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\f*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\f*\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\f*\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/presentation/theming/SurvicateFontProvider;", "Lcom/survicate/surveys/presentation/theming/FontProvider;", "fontSystemProvider", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SurvicateFontSystemProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Lcom/survicate/surveys/infrastructure/storage/interfaces/SurvicateFontSystemProvider;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "assetTypefaceCache", "", "", "Lkotlin/Result;", "Landroid/graphics/Typeface;", "provideFont", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "fontType", "Lcom/survicate/surveys/presentation/theming/FontType;", "loadFont", "loadFallbackFont", "getSourceFor", "Lcom/survicate/surveys/FontSource;", "Lcom/survicate/surveys/SurvicateFontSystem;", "load", "Lcom/survicate/surveys/FontSource$ResId;", "Lcom/survicate/surveys/FontSource$AssetPath;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateFontProvider implements FontProvider {
    private final Map<String, Result<Typeface>> assetTypefaceCache;
    private final SurvicateFontSystemProvider fontSystemProvider;
    private final SdkLogger logger;

    /* JADX INFO: compiled from: FontProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FontType.values().length];
            try {
                iArr[FontType.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FontType.REGULAR_ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FontType.BOLD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FontType.BOLD_ITALIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SurvicateFontProvider(SurvicateFontSystemProvider fontSystemProvider, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(fontSystemProvider, "fontSystemProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.fontSystemProvider = fontSystemProvider;
        this.logger = logger;
        this.assetTypefaceCache = new LinkedHashMap();
    }

    @Override // com.survicate.surveys.presentation.theming.FontProvider
    public Typeface provideFont(Context context, FontType fontType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontType, "fontType");
        Typeface typefaceLoadFont = loadFont(context, fontType);
        return typefaceLoadFont == null ? loadFallbackFont(context, fontType) : typefaceLoadFont;
    }

    private final Typeface loadFont(Context context, FontType fontType) {
        Typeface typefaceLoadFont = loadFont(getSourceFor(this.fontSystemProvider.provideFontSystem(), fontType), context);
        if (typefaceLoadFont == null) {
            this.logger.error(LogTags.PRESENTATION, "Font not found for fontType: " + fontType);
        }
        return typefaceLoadFont;
    }

    private final Typeface loadFallbackFont(Context context, FontType fontType) {
        return loadFont(getSourceFor(SurvicateFontSystem.INSTANCE.getDefault(), fontType), context);
    }

    private final FontSource getSourceFor(SurvicateFontSystem survicateFontSystem, FontType fontType) {
        int i = WhenMappings.$EnumSwitchMapping$0[fontType.ordinal()];
        if (i == 1) {
            return survicateFontSystem.getRegular();
        }
        if (i == 2) {
            return survicateFontSystem.getRegularItalic();
        }
        if (i == 3) {
            return survicateFontSystem.getBold();
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return survicateFontSystem.getBoldItalic();
    }

    private final Typeface loadFont(FontSource fontSource, Context context) {
        if (fontSource instanceof FontSource.ResId) {
            return load((FontSource.ResId) fontSource, context);
        }
        if (fontSource instanceof FontSource.AssetPath) {
            return load((FontSource.AssetPath) fontSource, context);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Typeface load(FontSource.ResId resId, Context context) {
        try {
            return ResourcesCompat.getFont(context, resId.getResId());
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private final Typeface load(FontSource.AssetPath assetPath, Context context) {
        Object objM14499constructorimpl;
        Map<String, Result<Typeface>> map = this.assetTypefaceCache;
        String path = assetPath.getPath();
        Result<Typeface> resultM14498boximpl = map.get(path);
        if (resultM14498boximpl == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(Typeface.createFromAsset(context.getAssets(), assetPath.getPath()));
            } catch (Exception e) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(e));
            }
            resultM14498boximpl = Result.m14498boximpl(objM14499constructorimpl);
            map.put(path, resultM14498boximpl);
        }
        Object value = resultM14498boximpl.getValue();
        if (Result.m14505isFailureimpl(value)) {
            value = null;
        }
        return (Typeface) value;
    }
}
