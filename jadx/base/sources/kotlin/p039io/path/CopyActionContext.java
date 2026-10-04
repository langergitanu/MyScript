package kotlin.p039io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.file.Path;
import kotlin.Metadata;

/* JADX INFO: compiled from: CopyActionContext.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0080\u0004¨\u0006\b"}, m1599d2 = {"Lkotlin/io/path/CopyActionContext;", "", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", TypedValues.AttributesType.S_TARGET, "followLinks", "", "kotlin-stdlib-jdk7"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CopyActionContext {
    CopyActionResult copyToIgnoringExistingDirectory(Path path, Path path2, boolean z);
}
