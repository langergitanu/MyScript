package androidx.compose.material3.adaptive;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.DpSize;
import androidx.window.core.layout.WindowSizeClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: WindowSizeClassHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, m1599d2 = {"computeFromDpSize", "Landroidx/window/core/layout/WindowSizeClass;", "Landroidx/window/core/layout/WindowSizeClass$Companion;", "windowSize", "Landroidx/compose/ui/unit/DpSize;", "supportedWidthSizeClasses", "", "Landroidx/compose/ui/unit/Dp;", "supportedHeightSizeClasses", "computeFromDpSize-NXuqAC8", "(Landroidx/window/core/layout/WindowSizeClass$Companion;JLjava/util/Set;Ljava/util/Set;)Landroidx/window/core/layout/WindowSizeClass;", "computeFromDpSizeV2", "computeFromDpSizeV2-NXuqAC8", "adaptive"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class WindowSizeClassHelperKt {
    /* JADX INFO: renamed from: computeFromDpSize-NXuqAC8$default, reason: not valid java name */
    public static /* synthetic */ WindowSizeClass m6160computeFromDpSizeNXuqAC8$default(WindowSizeClass.Companion companion, long j, Set set, Set set2, int i, Object obj) {
        if ((i & 2) != 0) {
            set = DpWidthSizeClasses.INSTANCE.getDefault();
        }
        if ((i & 4) != 0) {
            set2 = DpHeightSizeClasses.INSTANCE.getDefault();
        }
        return m6159computeFromDpSizeNXuqAC8(companion, j, set, set2);
    }

    /* JADX INFO: renamed from: computeFromDpSize-NXuqAC8, reason: not valid java name */
    public static final WindowSizeClass m6159computeFromDpSizeNXuqAC8(WindowSizeClass.Companion companion, long j, Set<C1486Dp> set, Set<C1486Dp> set2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (C1486Dp.m11016compareTo0680j_4(DpSize.m11115getWidthD9Ej5fM(j), ((C1486Dp) obj).m11031unboximpl()) >= 0) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fM11031unboximpl = ((C1486Dp) it.next()).m11031unboximpl();
        while (it.hasNext()) {
            fM11031unboximpl = Math.max(fM11031unboximpl, ((C1486Dp) it.next()).m11031unboximpl());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : set2) {
            if (C1486Dp.m11016compareTo0680j_4(DpSize.m11113getHeightD9Ej5fM(j), ((C1486Dp) obj2).m11031unboximpl()) >= 0) {
                arrayList2.add(obj2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fM11031unboximpl2 = ((C1486Dp) it2.next()).m11031unboximpl();
        while (it2.hasNext()) {
            fM11031unboximpl2 = Math.max(fM11031unboximpl2, ((C1486Dp) it2.next()).m11031unboximpl());
        }
        return new WindowSizeClass(fM11031unboximpl, fM11031unboximpl2);
    }

    /* JADX INFO: renamed from: computeFromDpSizeV2-NXuqAC8$default, reason: not valid java name */
    public static /* synthetic */ WindowSizeClass m6162computeFromDpSizeV2NXuqAC8$default(WindowSizeClass.Companion companion, long j, Set set, Set set2, int i, Object obj) {
        if ((i & 2) != 0) {
            set = DpWidthSizeClasses.INSTANCE.getDefaultV2();
        }
        if ((i & 4) != 0) {
            set2 = DpHeightSizeClasses.INSTANCE.getDefault();
        }
        return m6161computeFromDpSizeV2NXuqAC8(companion, j, set, set2);
    }

    /* JADX INFO: renamed from: computeFromDpSizeV2-NXuqAC8, reason: not valid java name */
    public static final WindowSizeClass m6161computeFromDpSizeV2NXuqAC8(WindowSizeClass.Companion companion, long j, Set<C1486Dp> set, Set<C1486Dp> set2) {
        return m6159computeFromDpSizeNXuqAC8(companion, j, set, set2);
    }
}
