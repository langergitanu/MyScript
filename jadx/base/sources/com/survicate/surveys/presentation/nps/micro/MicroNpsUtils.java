package com.survicate.surveys.presentation.nps.micro;

import android.content.Context;
import android.content.res.Resources;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroNpsUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/MicroNpsUtils;", "", "<init>", "()V", "PORTRAIT_HORIZONTAL_TOP_ROW_ITEM_COUNT", "", "PORTRAIT_HORIZONTAL_TOP_ROW_SPACINGS_COUNT", "computePortraitHorizontalSizes", "Lcom/survicate/surveys/presentation/nps/micro/MicroNpsUtils$NpsItemMetrics;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "screenWidth", "NpsItemMetrics", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroNpsUtils {
    public static final MicroNpsUtils INSTANCE = new MicroNpsUtils();
    private static final int PORTRAIT_HORIZONTAL_TOP_ROW_ITEM_COUNT = 6;
    private static final int PORTRAIT_HORIZONTAL_TOP_ROW_SPACINGS_COUNT = 5;

    private MicroNpsUtils() {
    }

    public final NpsItemMetrics computePortraitHorizontalSizes(Context context, int screenWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int dimension = ((int) resources.getDimension(C8369R.dimen.survicate_micro_page_padding)) * 2;
        return new NpsItemMetrics((int) (Math.min((screenWidth - dimension) - (5 * r1), resources.getDimension(C8369R.dimen.survicate_micro_question_nps_portrait_horizontal_max_item_size) * 6) / ((double) 6)), (int) resources.getDimension(C8369R.dimen.survicate_micro_question_nps_portrait_horizontal_item_spacing));
    }

    /* JADX INFO: compiled from: MicroNpsUtils.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/MicroNpsUtils$NpsItemMetrics;", "", "itemSizePx", "", "innerSpacingPx", "<init>", "(II)V", "getItemSizePx", "()I", "getInnerSpacingPx", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class NpsItemMetrics {
        private final int innerSpacingPx;
        private final int itemSizePx;

        public static /* synthetic */ NpsItemMetrics copy$default(NpsItemMetrics npsItemMetrics, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = npsItemMetrics.itemSizePx;
            }
            if ((i3 & 2) != 0) {
                i2 = npsItemMetrics.innerSpacingPx;
            }
            return npsItemMetrics.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getItemSizePx() {
            return this.itemSizePx;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getInnerSpacingPx() {
            return this.innerSpacingPx;
        }

        public final NpsItemMetrics copy(int itemSizePx, int innerSpacingPx) {
            return new NpsItemMetrics(itemSizePx, innerSpacingPx);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NpsItemMetrics)) {
                return false;
            }
            NpsItemMetrics npsItemMetrics = (NpsItemMetrics) other;
            return this.itemSizePx == npsItemMetrics.itemSizePx && this.innerSpacingPx == npsItemMetrics.innerSpacingPx;
        }

        public int hashCode() {
            return (Integer.hashCode(this.itemSizePx) * 31) + Integer.hashCode(this.innerSpacingPx);
        }

        public String toString() {
            return "NpsItemMetrics(itemSizePx=" + this.itemSizePx + ", innerSpacingPx=" + this.innerSpacingPx + ')';
        }

        public NpsItemMetrics(int i, int i2) {
            this.itemSizePx = i;
            this.innerSpacingPx = i2;
        }

        public final int getItemSizePx() {
            return this.itemSizePx;
        }

        public final int getInnerSpacingPx() {
            return this.innerSpacingPx;
        }
    }
}
