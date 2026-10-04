package com.myscript.nebo.grid;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0028R;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.myscript.android.utils.ColorExt;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.common.view.ViewHolderTouchDelegate;
import com.myscript.nebo.dms.DragPageClipDataHelper;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.imageloading.GlideApp;
import com.myscript.nebo.note.p030ui.compose.CoverKt;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PageType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridItemViewHolder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002IJB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010)\u001a\u00020*J*\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u0010%\u001a\u0004\u0018\u00010&J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u000201H\u0016J\u0018\u00104\u001a\u00020*2\u0006\u00100\u001a\u0002012\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u0016H\u0016J \u00109\u001a\u00020*2\u0006\u00108\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0016J\u0010\u0010<\u001a\u00020*2\u0006\u00108\u001a\u00020\u0016H\u0016J\u0018\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0010\u0010A\u001a\u00020*2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010B\u001a\u00020*2\u0006\u0010>\u001a\u00020?H\u0002J4\u0010C\u001a\u00020*2\u0006\u0010>\u001a\u00020?2\u0006\u0010D\u001a\u0002012\b\b\u0001\u0010E\u001a\u00020\u00072\b\b\u0001\u0010F\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0006\u0010G\u001a\u00020*J\u0006\u0010H\u001a\u00020*R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/myscript/nebo/common/view/ViewHolderTouchDelegate$Listener;", "parent", "Landroid/view/ViewGroup;", "layoutRes", "", "<init>", "(Landroid/view/ViewGroup;I)V", "value", "Lcom/myscript/snt/core/PageKey;", "pageKey", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "itemThumbnail", "Landroid/widget/ImageView;", "cover", "Landroidx/compose/ui/platform/ComposeView;", "pageMetadata", "Landroid/widget/TextView;", "loadingProgress", "Landroid/view/View;", "selectedView", "multiPageBackground", "title", "bottomBar", "topInfoBackground", "topInfoImage", "topInfoCount", "errorIcon", "fileExtensionColor", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "thumbnailLoadingListener", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "callback", "Lcom/myscript/nebo/grid/GridItemViewHolder$Callback;", "touchDelegate", "Lcom/myscript/nebo/common/view/ViewHolderTouchDelegate;", "unbind", "", "bind", "pageModel", "Lcom/myscript/nebo/dms/core/model/PageModel;", "thumbnailPath", "", "isSelected", "", "isDragging", "isDragConfirmed", "onSelectedChanged", "id", "", "onDragStarted", "v", "onContextClick", "x", "y", "onClick", "setupTopInfoSearch", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "count", "setupTopInfoCorrupted", "hideTopInfo", "setupTopInfo", "visible", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "image", "stopLongPressTimer", "onDragStopped", "Callback", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ViewHolderTouchDelegate.Listener {
    private static final int MAX_SEARCH_COUNT = 99;
    private final View bottomBar;
    private Callback callback;
    private final ComposeView cover;
    private final ImageView errorIcon;
    private final int fileExtensionColor;
    private final RequestManager glideRequestManager;
    private final ImageView itemThumbnail;
    private final View loadingProgress;
    private final View multiPageBackground;
    private PageKey pageKey;
    private final TextView pageMetadata;
    private final View selectedView;
    private final RequestListener<Drawable> thumbnailLoadingListener;
    private final TextView title;
    private final ImageView topInfoBackground;
    private final TextView topInfoCount;
    private final ImageView topInfoImage;
    private final ViewHolderTouchDelegate touchDelegate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final int GRID_VIEW_PAGE_ITEM_TYPE = C6079R.layout.grid_view_page_item;
    public static final int GRID_VIEW_PDF_ITEM_TYPE = C6079R.layout.grid_view_pdf_item;

    /* JADX INFO: compiled from: GridItemViewHolder.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridItemViewHolder$Callback;", "", "isDragging", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "isDragConfirmed", "onPageClicked", "", "onSelectionChanged", "selected", "onDragStarted", "view", "Landroid/view/View;", "onMoreButtonClicked", "x", "", "y", "onBottomBarClicked", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        boolean isDragConfirmed(PageKey pageKey);

        boolean isDragging(PageKey pageKey);

        void onBottomBarClicked(PageKey pageKey);

        boolean onDragStarted(View view, PageKey pageKey);

        void onMoreButtonClicked(int x, int y, PageKey pageKey);

        void onPageClicked(PageKey pageKey);

        void onSelectionChanged(PageKey pageKey, boolean selected);
    }

    @JvmStatic
    public static final int getLayoutRes(int i) {
        return INSTANCE.getLayoutRes(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridItemViewHolder(ViewGroup parent, int i) {
        super(LayoutInflater.from(parent.getContext()).inflate(i, (ViewGroup) null));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = this.itemView.findViewById(C6079R.id.grid_view_page_item_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.itemThumbnail = (ImageView) viewFindViewById;
        this.cover = (ComposeView) this.itemView.findViewById(C6079R.id.grid_view_container_cover);
        View viewFindViewById2 = this.itemView.findViewById(C6079R.id.grid_view_page_item_toolbar_metadata);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.pageMetadata = (TextView) viewFindViewById2;
        View viewFindViewById3 = this.itemView.findViewById(C6079R.id.grid_view_page_item_loading_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.loadingProgress = viewFindViewById3;
        View viewFindViewById4 = this.itemView.findViewById(C6079R.id.grid_view_page_item_selected);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.selectedView = viewFindViewById4;
        this.multiPageBackground = this.itemView.findViewById(C6079R.id.pdf_background_effect);
        View viewFindViewById5 = this.itemView.findViewById(C6079R.id.grid_view_page_item_toolbar_page_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById5;
        this.title = textView;
        View viewFindViewById6 = this.itemView.findViewById(C6079R.id.grid_view_page_item_bottom_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.bottomBar = viewFindViewById6;
        View viewFindViewById7 = this.itemView.findViewById(C6079R.id.grid_view_page_item_top_info_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.topInfoBackground = (ImageView) viewFindViewById7;
        View viewFindViewById8 = this.itemView.findViewById(C6079R.id.grid_view_page_item_top_info_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.topInfoImage = (ImageView) viewFindViewById8;
        View viewFindViewById9 = this.itemView.findViewById(C6079R.id.grid_view_page_item_top_info_count);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.topInfoCount = (TextView) viewFindViewById9;
        View viewFindViewById10 = this.itemView.findViewById(C6079R.id.grid_view_page_item_error_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.errorIcon = (ImageView) viewFindViewById10;
        this.fileExtensionColor = textView.getTextColors().getColorForState(new int[]{-16842910}, 0);
        GridItemViewHolder gridItemViewHolder = this;
        viewFindViewById6.setOnClickListener(gridItemViewHolder);
        this.itemView.setOnClickListener(gridItemViewHolder);
        this.touchDelegate = new ViewHolderTouchDelegate(this.itemView, DragPageClipDataHelper.DRAG_PAGE_MIME, this);
        RequestManager requestManagerWith = Glide.with(this.itemView.getContext());
        Intrinsics.checkNotNullExpressionValue(requestManagerWith, "with(...)");
        this.glideRequestManager = requestManagerWith;
        this.thumbnailLoadingListener = new RequestListener<Drawable>() { // from class: com.myscript.nebo.grid.GridItemViewHolder.1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                Intrinsics.checkNotNullParameter(target, "target");
                GridItemViewHolder.this.loadingProgress.setVisibility(8);
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(model, "model");
                Intrinsics.checkNotNullParameter(target, "target");
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                GridItemViewHolder.this.loadingProgress.setVisibility(8);
                return false;
            }
        };
    }

    public final PageKey getPageKey() {
        return this.pageKey;
    }

    public final void unbind() {
        this.glideRequestManager.clear(this.itemThumbnail);
    }

    public final void bind(final PageModel pageModel, String thumbnailPath, boolean isSelected, Callback callback) {
        String string;
        String str;
        String string2;
        ComposeView composeView;
        Intrinsics.checkNotNullParameter(pageModel, "pageModel");
        Context context = this.itemView.getContext();
        this.touchDelegate.bind(pageModel.getPageKey(), isSelected);
        this.callback = callback;
        this.itemView.setSelected(isSelected);
        this.selectedView.setVisibility(isSelected ? 0 : 8);
        View view = this.multiPageBackground;
        if (view == null) {
            int backgroundColor = pageModel.getBackgroundColor();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Integer numValueOf = Integer.valueOf(PageBackgroundUtilsKt.resolveBackgroundColor(backgroundColor, DarkModeUtils.isDarkMode(itemView)));
            if (numValueOf.intValue() == -16777216) {
                numValueOf = null;
            }
            this.itemView.findViewById(C6079R.id.grid_view_page_item_thumbnail_container).setBackgroundColor(numValueOf != null ? numValueOf.intValue() : context.getResources().getColor(C6183R.color.black_thumbnail_background_special_case, context.getTheme()));
        } else {
            view.setVisibility(!pageModel.isContainer() && pageModel.getChildPageCount() > 1 ? 0 : 8);
        }
        boolean zIsCorrupted = pageModel.isCorrupted();
        pageModel.getLastModificationDate();
        this.pageKey = pageModel.getPageKey();
        String title = pageModel.getTitle();
        if (title.length() == 0) {
            string = context.getString(C6079R.string.untitled_page);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else {
            string = title;
        }
        String str2 = string;
        String fileExtension = pageModel.getFileExtension();
        TextView textView = this.title;
        String str3 = fileExtension;
        if (str3 != null && str3.length() != 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.append(str3, new ForegroundColorSpan(this.fileExtensionColor), 0);
            str = spannableStringBuilder;
        } else {
            str = str2;
        }
        textView.setText(str);
        this.title.setEnabled(title.length() > 0);
        this.pageMetadata.setGravity(8388659);
        TextView textView2 = this.pageMetadata;
        if (!pageModel.isSupported()) {
            string2 = context.getString(C6079R.string.grid_view_page_item_update_required);
        } else if (pageModel.isLanguageMissing()) {
            string2 = context.getString(C6079R.string.grid_view_page_item_missing_language);
        } else if (pageModel.isContainer() || !pageModel.isEmpty()) {
            string2 = pageModel.getDateDetailsRes() != 0 ? context.getResources().getString(pageModel.getDateDetailsRes(), CommonUtils.formatTimestampToSimpleDateString(context, pageModel.getDateToDisplay())) : CommonUtils.formatTimestampToString(context, pageModel.getDateToDisplay());
        } else {
            string2 = context.getString(C6079R.string.grid_view_page_item_no_content);
        }
        textView2.setText(string2);
        this.errorIcon.setVisibility(pageModel.isLanguageMissing() || !pageModel.isSupported() ? 0 : 8);
        this.itemView.setTag(C6079R.id.page_id_page_view_key, this.pageKey);
        Intrinsics.checkNotNull(context);
        hideTopInfo(context);
        if (zIsCorrupted) {
            setupTopInfoCorrupted(context);
        }
        if (pageModel.getHitCount() > 0) {
            setupTopInfoSearch(context, pageModel.getHitCount());
        }
        boolean zIsContainer = pageModel.isContainer();
        ComposeView composeView2 = this.cover;
        if (composeView2 != null) {
            composeView2.setVisibility(zIsContainer ? 0 : 8);
        }
        if (zIsContainer && (composeView = this.cover) != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1432747054, true, new Function2() { // from class: com.myscript.nebo.grid.GridItemViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GridItemViewHolder.bind$lambda$2(pageModel, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        }
        this.itemThumbnail.setVisibility((pageModel.isEmpty() || zIsContainer) ? 4 : 0);
        int dimensionPixelSize = pageModel.getPageType() == PageType.RawContent ? context.getResources().getDimensionPixelSize(C6079R.dimen.grid_item_thumbnail_padding) : 0;
        this.itemThumbnail.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        if (!pageModel.isEmpty() || zIsCorrupted) {
            if (thumbnailPath == null) {
                this.loadingProgress.setVisibility(0);
                Glide.with(context).clear(this.itemThumbnail);
            } else {
                this.loadingProgress.setVisibility(8);
                Intrinsics.checkNotNull(GlideApp.with(context).load(new File(thumbnailPath)).listener(this.thumbnailLoadingListener).fitCenter().override(this.itemView.getMeasuredWidth(), this.itemView.getMeasuredHeight()).into(this.itemThumbnail));
            }
            if (zIsCorrupted) {
                this.loadingProgress.setVisibility(8);
            }
        } else {
            this.itemThumbnail.setImageBitmap(null);
            this.loadingProgress.setVisibility(8);
        }
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        itemView2.setVisibility(isDragging() ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$2(PageModel pageModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C158@8143L225:GridItemViewHolder.kt#egc4u2");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1432747054, i, -1, "com.myscript.nebo.grid.GridItemViewHolder.bind.<anonymous> (GridItemViewHolder.kt:158)");
            }
            CoverKt.m13292CoverxKlaLpw(CoverKt.getCoverData(pageModel), !CoverKt.isPortrait(pageModel) ? SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null) : Modifier.INSTANCE, false, 0.0f, 0.0f, 0.0f, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public boolean isDragging() {
        PageKey pageKey = this.pageKey;
        if (pageKey == null) {
            return false;
        }
        Callback callback = this.callback;
        Boolean boolValueOf = callback != null ? Boolean.valueOf(callback.isDragging(pageKey)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public boolean isDragConfirmed() {
        PageKey pageKey = this.pageKey;
        if (pageKey == null) {
            return false;
        }
        Callback callback = this.callback;
        Boolean boolValueOf = callback != null ? Boolean.valueOf(callback.isDragConfirmed(pageKey)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public void onSelectedChanged(boolean isSelected, Object id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onSelectionChanged((PageKey) id, isSelected);
        }
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public boolean onDragStarted(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        PageKey pageKey = this.pageKey;
        if (pageKey == null) {
            return false;
        }
        Callback callback = this.callback;
        Boolean boolValueOf = callback != null ? Boolean.valueOf(callback.onDragStarted(v, pageKey)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public void onContextClick(View v, int x, int y) {
        Callback callback;
        Intrinsics.checkNotNullParameter(v, "v");
        PageKey pageKey = this.pageKey;
        if (pageKey == null || (callback = this.callback) == null) {
            return;
        }
        callback.onMoreButtonClicked(x, y, pageKey);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        PageKey pageKey = this.pageKey;
        if (pageKey != null) {
            if (v.getId() == C6079R.id.grid_view_page_item_bottom_bar) {
                Callback callback = this.callback;
                if (callback != null) {
                    callback.onBottomBarClicked(pageKey);
                    return;
                }
                return;
            }
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onPageClicked(pageKey);
            }
        }
    }

    private final void setupTopInfoSearch(Context context, int count) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0028R.attr.colorPrimary, typedValue, true);
        setupTopInfo(context, true, typedValue.data, 0, count);
    }

    private final void setupTopInfoCorrupted(Context context) {
        setupTopInfo(context, true, ResourcesCompat.getColor(context.getResources(), C6079R.color.corrupted_banner_background, context.getTheme()), C6079R.drawable.ic_warning, 0);
    }

    private final void hideTopInfo(Context context) {
        setupTopInfo(context, false, 0, 0, 0);
    }

    private final void setupTopInfo(Context context, boolean visible, int backgroundColor, int image, int count) {
        int iIntValue = ((Number) ColorExt.getBrightnessAwareValue$default(backgroundColor, -1, -16777216, 0.0f, 8, null)).intValue();
        if (!visible) {
            this.topInfoBackground.setVisibility(8);
            this.topInfoImage.setVisibility(8);
            this.topInfoCount.setVisibility(8);
            return;
        }
        if (backgroundColor != 0) {
            this.topInfoBackground.setVisibility(0);
            this.topInfoBackground.setColorFilter(backgroundColor, PorterDuff.Mode.SRC_IN);
        } else {
            this.topInfoBackground.setVisibility(8);
        }
        if (image != 0) {
            this.topInfoImage.setVisibility(0);
            this.topInfoImage.setImageResource(image);
            this.topInfoImage.setColorFilter(iIntValue, PorterDuff.Mode.SRC_IN);
        } else {
            this.topInfoImage.setVisibility(8);
        }
        if (count > 0) {
            this.topInfoCount.setVisibility(0);
            this.topInfoCount.setText(count > MAX_SEARCH_COUNT ? context.getString(C6079R.string.search_ninety_nine) : String.valueOf(count));
            this.topInfoCount.setTextColor(iIntValue);
            return;
        }
        this.topInfoCount.setVisibility(8);
    }

    public final void stopLongPressTimer() {
        this.touchDelegate.stopLongClickTimer();
    }

    public final void onDragStopped() {
        this.touchDelegate.onDragStopped();
    }

    /* JADX INFO: compiled from: GridItemViewHolder.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridItemViewHolder$Companion;", "", "<init>", "()V", "MAX_SEARCH_COUNT", "", "GRID_VIEW_PAGE_ITEM_TYPE", "GRID_VIEW_PDF_ITEM_TYPE", "getLayoutRes", "viewType", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int getLayoutRes(int viewType) {
            return viewType;
        }

        private Companion() {
        }
    }
}
