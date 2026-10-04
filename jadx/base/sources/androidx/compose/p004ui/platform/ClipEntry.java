package androidx.compose.p004ui.platform;

import android.content.ClipData;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Landroidx/compose/ui/platform/ClipEntry;", "", "clipData", "Landroid/content/ClipData;", "<init>", "(Landroid/content/ClipData;)V", "getClipData", "()Landroid/content/ClipData;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "getClipMetadata", "()Landroidx/compose/ui/platform/ClipMetadata;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ClipEntry {
    public static final int $stable = 8;
    private final ClipData clipData;

    public ClipEntry(ClipData clipData) {
        this.clipData = clipData;
    }

    public final ClipData getClipData() {
        return this.clipData;
    }

    public final ClipMetadata getClipMetadata() {
        return AndroidClipboardManager_androidKt.toClipMetadata(this.clipData.getDescription());
    }
}
