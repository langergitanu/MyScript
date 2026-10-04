package com.myscript.nebo.editing;

import com.myscript.atk.core.MimeType;
import com.myscript.atk.text.SWIGClipboard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AndroidNativeClipboard.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0082\b¨\u0006\b"}, m1599d2 = {"getOrNull", "", "Lcom/myscript/atk/text/SWIGClipboard;", "mimeType", "Lcom/myscript/atk/core/MimeType;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AndroidNativeClipboardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getOrNull(SWIGClipboard sWIGClipboard, MimeType mimeType) {
        if (sWIGClipboard.hasKey(mimeType)) {
            return sWIGClipboard.get(mimeType);
        }
        return null;
    }

    private static final String getOrElse(SWIGClipboard sWIGClipboard, MimeType mimeType, Function0<String> function0) {
        String orNull = getOrNull(sWIGClipboard, mimeType);
        return orNull == null ? function0.invoke() : orNull;
    }
}
