package com.myscript.nebo.editing.impl.p027ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: RendererWrapper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u001c\u0010\u001b\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u001c\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u0003H&J\u0016\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180 H&J\u0012\u0010!\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&¨\u0006\"À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/RendererWrapper;", "", "handleRenderingRequest", "", "canvas", "Landroid/graphics/Canvas;", "invalidateType", "", "bind", "renderer", "Lcom/myscript/atk/core/Renderer;", "viewTransform", "Lcom/myscript/atk/core/ViewTransform;", "unbind", "setSize", "width", "height", "scrollAt", "x", "y", "release", "extentToViewRect", "", TtmlNode.ATTR_TTS_EXTENT, "Lcom/myscript/atk/core/Extent;", "outRect", "Landroid/graphics/Rect;", "setPageBounds", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "refreshCustomRenderedItems", "setExtentsForSearch", "extents", "", "setSelectedHitExtent", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RendererWrapper {
    void bind(Renderer renderer, ViewTransform viewTransform);

    boolean extentToViewRect(Extent extent, Rect outRect);

    void handleRenderingRequest(Canvas canvas, int invalidateType);

    void refreshCustomRenderedItems();

    void release();

    void scrollAt(int x, int y);

    void setExtentsForSearch(List<? extends Extent> extents);

    void setPageBounds(Extent extent, int backgroundColor);

    void setSelectedHitExtent(Extent extent);

    void setSize(int width, int height);

    void unbind();
}
