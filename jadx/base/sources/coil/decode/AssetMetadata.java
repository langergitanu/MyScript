package coil.decode;

import coil.decode.ImageSource;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, m1599d2 = {"Lcoil/decode/AssetMetadata;", "Lcoil/decode/ImageSource$Metadata;", "filePath", "", "<init>", "(Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "fileName", "getFileName$annotations", "()V", "getFileName", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class AssetMetadata extends ImageSource.Metadata {
    private final String filePath;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to filePath as it supports assets inside subfolders.")
    public static /* synthetic */ void getFileName$annotations() {
    }

    public AssetMetadata(String str) {
        this.filePath = str;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFileName() {
        return StringsKt.substringAfterLast$default(this.filePath, JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
    }
}
