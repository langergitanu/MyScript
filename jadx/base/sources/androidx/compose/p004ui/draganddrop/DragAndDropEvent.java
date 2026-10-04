package androidx.compose.p004ui.draganddrop;

import android.view.DragEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: DragAndDrop.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "dragEvent", "Landroid/view/DragEvent;", "<init>", "(Landroid/view/DragEvent;)V", "getDragEvent$ui", "()Landroid/view/DragEvent;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DragAndDropEvent {
    public static final int $stable = 8;
    private final DragEvent dragEvent;

    public DragAndDropEvent(DragEvent dragEvent) {
        this.dragEvent = dragEvent;
    }

    /* JADX INFO: renamed from: getDragEvent$ui, reason: from getter */
    public final DragEvent getDragEvent() {
        return this.dragEvent;
    }
}
