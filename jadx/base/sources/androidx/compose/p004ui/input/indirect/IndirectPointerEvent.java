package androidx.compose.p004ui.input.indirect;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IndirectPointerEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\n\u0082\u0001\u0001\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, m1599d2 = {"Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "getChanges", "()Ljava/util/List;", "type", "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "getType-4ZHQPSE", "()I", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "getPrimaryDirectionalMotionAxis-nZO2Niw", "Landroidx/compose/ui/input/indirect/PlatformIndirectPointerEvent;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface IndirectPointerEvent {
    List<IndirectPointerInputChange> getChanges();

    /* JADX INFO: renamed from: getPrimaryDirectionalMotionAxis-nZO2Niw */
    int mo8971getPrimaryDirectionalMotionAxisnZO2Niw();

    /* JADX INFO: renamed from: getType-4ZHQPSE */
    int mo8972getType4ZHQPSE();
}
