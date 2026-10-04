package androidx.window.area;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: WindowAreaSessionPresenter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, m1599d2 = {"Landroidx/window/area/WindowAreaSessionPresenter;", "Landroidx/window/area/WindowAreaSession;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "window", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "setContentView", "", "view", "Landroid/view/View;", "window_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public interface WindowAreaSessionPresenter extends WindowAreaSession {
    Context getContext();

    Window getWindow();

    void setContentView(View view);
}
