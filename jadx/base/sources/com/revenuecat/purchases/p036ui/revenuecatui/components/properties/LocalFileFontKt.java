package com.revenuecat.purchases.p036ui.revenuecatui.components.properties;

import android.graphics.Typeface;
import androidx.compose.p004ui.text.font.AndroidFont;
import androidx.compose.p004ui.text.font.FontWeight;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalFileFont.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, m1599d2 = {"DefaultFileTypefaceLoader", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FileTypefaceLoader;", "localFileFont", "Landroidx/compose/ui/text/font/AndroidFont;", "file", "Ljava/io/File;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "fileTypefaceLoader", "localFileFont-Ej4NQ78", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILcom/revenuecat/purchases/ui/revenuecatui/components/properties/FileTypefaceLoader;)Landroidx/compose/ui/text/font/AndroidFont;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class LocalFileFontKt {
    private static final FileTypefaceLoader DefaultFileTypefaceLoader = new FileTypefaceLoader() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.LocalFileFontKt$$ExternalSyntheticLambda0
        @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.properties.FileTypefaceLoader
        public final Typeface load(File file) {
            return LocalFileFontKt.DefaultFileTypefaceLoader$lambda$0(file);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface DefaultFileTypefaceLoader$lambda$0(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new Typeface.Builder(file).build();
    }

    /* JADX INFO: renamed from: localFileFont-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ AndroidFont m13959localFileFontEj4NQ78$default(File file, FontWeight fontWeight, int i, FileTypefaceLoader fileTypefaceLoader, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            fileTypefaceLoader = DefaultFileTypefaceLoader;
        }
        return m13958localFileFontEj4NQ78(file, fontWeight, i, fileTypefaceLoader);
    }

    /* JADX INFO: renamed from: localFileFont-Ej4NQ78, reason: not valid java name */
    public static final /* synthetic */ AndroidFont m13958localFileFontEj4NQ78(File file, FontWeight weight, int i, FileTypefaceLoader fileTypefaceLoader) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(fileTypefaceLoader, "fileTypefaceLoader");
        return new LocalFileFont(file, weight, i, fileTypefaceLoader, null);
    }
}
