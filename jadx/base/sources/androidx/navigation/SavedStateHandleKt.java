package androidx.navigation;

import androidx.lifecycle.SavedStateHandle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: SavedStateHandle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"androidx/navigation/SavedStateHandleKt__SavedStateHandleKt"}, m1600k = 4, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SavedStateHandleKt {
    public static final /* synthetic */ <T> T toRoute(SavedStateHandle savedStateHandle, Map<KType, NavType<?>> map) {
        return (T) SavedStateHandleKt__SavedStateHandleKt.toRoute(savedStateHandle, map);
    }

    public static final <T> T toRoute(SavedStateHandle savedStateHandle, KClass<T> kClass, Map<KType, NavType<?>> map) {
        return (T) SavedStateHandleKt__SavedStateHandleKt.toRoute(savedStateHandle, kClass, map);
    }
}
