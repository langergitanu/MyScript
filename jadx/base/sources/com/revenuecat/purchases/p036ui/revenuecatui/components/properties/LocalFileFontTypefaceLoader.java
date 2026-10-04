package com.revenuecat.purchases.p036ui.revenuecatui.components.properties;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.p004ui.text.font.AndroidFont;
import androidx.compose.p004ui.text.font.FontStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalFileFont.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/LocalFileFontTypefaceLoader;", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "()V", "awaitLoad", "Landroid/graphics/Typeface;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fallbackTypeface", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/LocalFileFont;", "reason", "", "loadBlocking", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class LocalFileFontTypefaceLoader implements AndroidFont.TypefaceLoader {
    public static final LocalFileFontTypefaceLoader INSTANCE = new LocalFileFontTypefaceLoader();

    private LocalFileFontTypefaceLoader() {
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Object awaitLoad(Context context, AndroidFont androidFont, Continuation<? super Typeface> continuation) {
        return loadBlocking(context, androidFont);
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Typeface loadBlocking(Context context, AndroidFont font) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(font, "font");
        LocalFileFont localFileFont = font instanceof LocalFileFont ? (LocalFileFont) font : null;
        if (localFileFont == null) {
            Logger.INSTANCE.m1584e("Expected font to be LocalFileFont, but was " + font.getClass().getSimpleName() + ". Falling back to default typeface.");
            return fallbackTypeface(font);
        }
        try {
            Typeface typefaceLoad = localFileFont.getFileTypefaceLoader().load(localFileFont.getFile());
            return typefaceLoad == null ? fallbackTypeface(localFileFont, "loader returned null") : typefaceLoad;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = th.getClass().getSimpleName();
            }
            Intrinsics.checkNotNullExpressionValue(message, "e.message ?: e.javaClass.simpleName");
            return fallbackTypeface(localFileFont, message);
        }
    }

    private final Typeface fallbackTypeface(LocalFileFont font, String reason) {
        Logger.INSTANCE.m1584e("Failed to load downloaded font from " + font.getFile().getPath() + " (" + reason + "). Falling back to default typeface.");
        return fallbackTypeface(font);
    }

    private final Typeface fallbackTypeface(AndroidFont font) {
        if (Build.VERSION.SDK_INT >= 28) {
            Typeface typefaceCreate = Typeface.create(Typeface.DEFAULT, font.getWeight().getWeight(), FontStyle.m10567equalsimpl0(font.getStyle(), FontStyle.INSTANCE.m10573getItalic_LCdwA()));
            Intrinsics.checkNotNullExpressionValue(typefaceCreate, "{\n            Typeface.c…ntStyle.Italic)\n        }");
            return typefaceCreate;
        }
        Typeface typeface = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(typeface, "{\n            Typeface.DEFAULT\n        }");
        return typeface;
    }
}
