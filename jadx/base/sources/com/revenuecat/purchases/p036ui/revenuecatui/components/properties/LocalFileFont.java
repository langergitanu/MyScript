package com.revenuecat.purchases.p036ui.revenuecatui.components.properties;

import androidx.compose.p004ui.text.font.AndroidFont;
import androidx.compose.p004ui.text.font.FontLoadingStrategy;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontVariation;
import androidx.compose.p004ui.text.font.FontWeight;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalFileFont.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u0007X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/LocalFileFont;", "Landroidx/compose/ui/text/font/AndroidFont;", "file", "Ljava/io/File;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "fileTypefaceLoader", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FileTypefaceLoader;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILcom/revenuecat/purchases/ui/revenuecatui/components/properties/FileTypefaceLoader;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFile", "()Ljava/io/File;", "getFileTypefaceLoader", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FileTypefaceLoader;", "getStyle-_-LCdwA", "()I", "I", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class LocalFileFont extends AndroidFont {
    private final File file;
    private final FileTypefaceLoader fileTypefaceLoader;
    private final int style;
    private final FontWeight weight;

    public /* synthetic */ LocalFileFont(File file, FontWeight fontWeight, int i, FileTypefaceLoader fileTypefaceLoader, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, fontWeight, i, fileTypefaceLoader);
    }

    public final File getFile() {
        return this.file;
    }

    @Override // androidx.compose.p004ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.p004ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: from getter */
    public int getStyle() {
        return this.style;
    }

    public final FileTypefaceLoader getFileTypefaceLoader() {
        return this.fileTypefaceLoader;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private LocalFileFont(File file, FontWeight weight, int i, FileTypefaceLoader fileTypefaceLoader) {
        super(FontLoadingStrategy.INSTANCE.m10559getBlockingPKNRLFQ(), LocalFileFontTypefaceLoader.INSTANCE, FontVariation.INSTANCE.m10590Settings6EWAqTQ(weight, i, new FontVariation.Setting[0]), null);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(fileTypefaceLoader, "fileTypefaceLoader");
        this.file = file;
        this.weight = weight;
        this.style = i;
        this.fileTypefaceLoader = fileTypefaceLoader;
    }

    public String toString() {
        return "LocalFileFont(file=" + this.file + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m10569toStringimpl(getStyle())) + ')';
    }
}
