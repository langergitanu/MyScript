package androidx.compose.p004ui.autofill;

import android.view.ViewStructure;
import kotlin.Metadata;

/* JADX INFO: compiled from: AutofillUtils.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, m1599d2 = {"Landroidx/compose/ui/autofill/AutofillApi28Helper;", "", "<init>", "()V", "setMaxTextLength", "", "structure", "Landroid/view/ViewStructure;", "length", "", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AutofillApi28Helper {
    public static final int $stable = 0;
    public static final AutofillApi28Helper INSTANCE = new AutofillApi28Helper();

    private AutofillApi28Helper() {
    }

    public final void setMaxTextLength(ViewStructure structure, int length) {
        structure.setMaxTextLength(length);
    }
}
