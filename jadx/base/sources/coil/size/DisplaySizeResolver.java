package coil.size;

import android.content.Context;
import android.util.DisplayMetrics;
import coil.size.Dimension;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplaySizeResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcoil/size/DisplaySizeResolver;", "Lcoil/size/SizeResolver;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class DisplaySizeResolver implements SizeResolver {
    private final Context context;

    public DisplaySizeResolver(Context context) {
        this.context = context;
    }

    @Override // coil.size.SizeResolver
    public Object size(Continuation<? super Size> continuation) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        Dimension.Pixels pixelsDimension = Dimensions.Dimension(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new Size(pixelsDimension, pixelsDimension);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DisplaySizeResolver) && Intrinsics.areEqual(this.context, ((DisplaySizeResolver) other).context);
    }

    public int hashCode() {
        return this.context.hashCode();
    }
}
