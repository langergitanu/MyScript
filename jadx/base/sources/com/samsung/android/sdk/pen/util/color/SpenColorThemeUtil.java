package com.samsung.android.sdk.pen.util.color;

import android.content.Context;
import android.util.Log;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: SpenColorThemeUtil.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\b\u0010\u0014\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenColorThemeUtil;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mCurrentTheme", "Lcom/samsung/android/sdk/pen/util/color/SpenIColorTheme;", "close", "", "theme", "", "colorTheme", "getColorTheme", "()I", "setColorTheme", "(I)V", "getColor", "color", "closeCurrentTheme", "getThemeObject", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public class SpenColorThemeUtil {
    public static final int COLOR_THEME_NORMAL = 0;
    public static final int COLOR_THEME_REVERSE = 1;
    private static final String TAG = "SpenColorThemeUtil";
    private Context mContext;
    private SpenIColorTheme mCurrentTheme = new SpenNormalColorTheme();

    public SpenColorThemeUtil(Context context) {
        this.mContext = context;
    }

    public final void close() {
        this.mContext = null;
        closeCurrentTheme();
    }

    public final void setColorTheme(int i) {
        Log.i(TAG, "setColorTheme() theme=" + i);
        if (getColorTheme() != i) {
            closeCurrentTheme();
            this.mCurrentTheme = getThemeObject(i);
        }
    }

    public final int getColorTheme() {
        SpenIColorTheme spenIColorTheme = this.mCurrentTheme;
        if (spenIColorTheme == null) {
            return -1;
        }
        if (spenIColorTheme instanceof SpenNormalColorTheme) {
            return 0;
        }
        return spenIColorTheme instanceof SpenReverseColorTheme ? 1 : -1;
    }

    public final int getColor(int color) {
        SpenIColorTheme spenIColorTheme = this.mCurrentTheme;
        if (spenIColorTheme != null) {
            return spenIColorTheme.getColor(color);
        }
        return -1;
    }

    private final void closeCurrentTheme() {
        SpenIColorTheme spenIColorTheme = this.mCurrentTheme;
        if (spenIColorTheme != null) {
            spenIColorTheme.close();
        }
        this.mCurrentTheme = null;
    }

    private final SpenIColorTheme getThemeObject(int theme) {
        if (theme == 0) {
            return new SpenNormalColorTheme();
        }
        if (theme != 1) {
            return null;
        }
        return new SpenReverseColorTheme(this.mContext);
    }
}
