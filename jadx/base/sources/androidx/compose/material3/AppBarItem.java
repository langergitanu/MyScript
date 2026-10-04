package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppBarDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\r\u0010\u0002\u001a\u00020\u0003H'¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m1599d2 = {"Landroidx/compose/material3/AppBarItem;", "", "AppbarContent", "", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "Landroidx/compose/material3/AppBarMenuState;", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public interface AppBarItem {
    void AppbarContent(Composer composer, int i);

    void MenuContent(AppBarMenuState appBarMenuState, Composer composer, int i);
}
