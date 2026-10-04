package com.samsung.android.sdk.pen.setting.util;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenSettingUtilOutlineProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilOutlineProvider;", "", "<init>", "()V", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenSettingUtilOutlineProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: SpenSettingUtilOutlineProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b¨\u0006\r"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilOutlineProvider$Companion;", "", "<init>", "()V", "getCircleOutlineProvider", "Landroid/view/ViewOutlineProvider;", "getRoundRectOutlineProvider", "radius", "", "leftTopRadius", "rightTopRadius", "rightBottomRadius", "leftBottomRadius", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewOutlineProvider getCircleOutlineProvider() {
            return new ViewOutlineProvider() { // from class: com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOutlineProvider$Companion$getCircleOutlineProvider$1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(outline, "outline");
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            };
        }

        public final ViewOutlineProvider getRoundRectOutlineProvider(float radius) {
            return getRoundRectOutlineProvider(radius, radius, radius, radius);
        }

        public final ViewOutlineProvider getRoundRectOutlineProvider(final float leftTopRadius, final float rightTopRadius, final float rightBottomRadius, final float leftBottomRadius) {
            return new ViewOutlineProvider() { // from class: com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOutlineProvider$Companion$getRoundRectOutlineProvider$1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(outline, "outline");
                    Path path = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                    float f = leftTopRadius;
                    float f2 = rightTopRadius;
                    float f3 = rightBottomRadius;
                    float f4 = leftBottomRadius;
                    path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
                    path.close();
                    if (Build.VERSION.SDK_INT >= 30) {
                        outline.setPath(path);
                    } else {
                        outline.setConvexPath(path);
                    }
                }
            };
        }
    }
}
