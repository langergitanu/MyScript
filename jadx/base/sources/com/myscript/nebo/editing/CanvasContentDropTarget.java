package com.myscript.nebo.editing;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.DragEvent;
import android.view.View;
import androidx.appcompat.C0028R;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.DragAndDropPermissionsCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.survicate.surveys.TextRecallingManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CanvasContentDropTarget.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0088\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n\u0012K\u0010\r\u001aG\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\r\u001aG\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Lcom/myscript/nebo/editing/CanvasContentDropTarget;", "Landroid/view/View$OnDragListener;", "highlightView", "Landroid/view/View;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "canDrop", "Lkotlin/Function0;", "", "requestPermissions", "Lkotlin/Function1;", "Landroid/view/DragEvent;", "Landroidx/core/view/DragAndDropPermissionsCompat;", "onContentDropped", "Lkotlin/Function3;", "Lcom/myscript/nebo/editing/CanvasContentDropTarget$DroppedContent;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.CONTENT, "", "x", "y", "", "<init>", "(Landroid/view/View;Lcom/myscript/nebo/log/TechnicalLogger;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "onDrag", "view", NotificationCompat.CATEGORY_EVENT, "handleDrop", "resolveDroppedContent", "contentResolver", "Landroid/content/ContentResolver;", "clipData", "Landroid/content/ClipData;", "setHighlighted", "highlighted", "DroppedContent", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CanvasContentDropTarget implements View.OnDragListener {
    private static final int DROP_HIGHLIGHT_FILL_ALPHA = 40;
    private static final String MIME_TYPE_IMAGE_ANY = "image/*";
    private static final String MIME_TYPE_TEXT_ANY = "text/*";
    private static final String TAG = "CanvasContentDropTarget";
    private final Function0<Boolean> canDrop;
    private final View highlightView;
    private final TechnicalLogger logger;
    private final Function3<DroppedContent, Float, Float, Unit> onContentDropped;
    private final Function1<DragEvent, DragAndDropPermissionsCompat> requestPermissions;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasContentDropTarget(View highlightView, TechnicalLogger logger, Function0<Boolean> canDrop, Function1<? super DragEvent, DragAndDropPermissionsCompat> requestPermissions, Function3<? super DroppedContent, ? super Float, ? super Float, Unit> onContentDropped) {
        Intrinsics.checkNotNullParameter(highlightView, "highlightView");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(canDrop, "canDrop");
        Intrinsics.checkNotNullParameter(requestPermissions, "requestPermissions");
        Intrinsics.checkNotNullParameter(onContentDropped, "onContentDropped");
        this.highlightView = highlightView;
        this.logger = logger;
        this.canDrop = canDrop;
        this.requestPermissions = requestPermissions;
        this.onContentDropped = onContentDropped;
    }

    /* JADX INFO: compiled from: CanvasContentDropTarget.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/editing/CanvasContentDropTarget$DroppedContent;", "", "imageUri", "Landroid/net/Uri;", "text", "", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "getImageUri", "()Landroid/net/Uri;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class DroppedContent {
        public static final int $stable = 8;
        private final Uri imageUri;
        private final String text;

        public static /* synthetic */ DroppedContent copy$default(DroppedContent droppedContent, Uri uri, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = droppedContent.imageUri;
            }
            if ((i & 2) != 0) {
                str = droppedContent.text;
            }
            return droppedContent.copy(uri, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getImageUri() {
            return this.imageUri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final DroppedContent copy(Uri imageUri, String text) {
            return new DroppedContent(imageUri, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DroppedContent)) {
                return false;
            }
            DroppedContent droppedContent = (DroppedContent) other;
            return Intrinsics.areEqual(this.imageUri, droppedContent.imageUri) && Intrinsics.areEqual(this.text, droppedContent.text);
        }

        public int hashCode() {
            Uri uri = this.imageUri;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.text;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "DroppedContent(imageUri=" + this.imageUri + ", text=" + this.text + ")";
        }

        public DroppedContent(Uri uri, String str) {
            this.imageUri = uri;
            this.text = str;
        }

        public final Uri getImageUri() {
            return this.imageUri;
        }

        public final String getText() {
            return this.text;
        }
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent event) {
        ClipDescription clipDescription;
        ClipDescription clipDescription2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (event.getAction()) {
            case 1:
                return this.canDrop.invoke().booleanValue() && (((clipDescription = event.getClipDescription()) != null && clipDescription.hasMimeType(MIME_TYPE_IMAGE_ANY)) || ((clipDescription2 = event.getClipDescription()) != null && clipDescription2.hasMimeType(MIME_TYPE_TEXT_ANY)));
            case 2:
                return true;
            case 3:
                setHighlighted(false);
                return handleDrop(view, event);
            case 4:
                setHighlighted(false);
                return true;
            case 5:
                setHighlighted(true);
                return true;
            case 6:
                setHighlighted(false);
                return true;
            default:
                return false;
        }
    }

    private final boolean handleDrop(View view, final DragEvent event) {
        final DroppedContent droppedContentResolveDroppedContent;
        ClipData clipData = event.getClipData();
        if (clipData != null) {
            ContentResolver contentResolver = view.getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            droppedContentResolveDroppedContent = resolveDroppedContent(contentResolver, clipData);
        } else {
            droppedContentResolveDroppedContent = null;
        }
        if (droppedContentResolveDroppedContent == null) {
            TechnicalLoggerExt.logAction(this.logger, TAG, "Drop rejected", new Function0() { // from class: com.myscript.nebo.editing.CanvasContentDropTarget$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CanvasContentDropTarget.handleDrop$lambda$1();
                }
            });
            return false;
        }
        if (droppedContentResolveDroppedContent.getImageUri() != null && this.requestPermissions.invoke(event) == null) {
            TechnicalLoggerExt.logAction(this.logger, TAG, "Drop rejected", new Function0() { // from class: com.myscript.nebo.editing.CanvasContentDropTarget$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CanvasContentDropTarget.handleDrop$lambda$2();
                }
            });
            return false;
        }
        TechnicalLoggerExt.logAction(this.logger, TAG, "Content dropped on canvas", new Function0() { // from class: com.myscript.nebo.editing.CanvasContentDropTarget$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CanvasContentDropTarget.handleDrop$lambda$3(droppedContentResolveDroppedContent, event);
            }
        });
        this.onContentDropped.invoke(droppedContentResolveDroppedContent, Float.valueOf(event.getX()), Float.valueOf(event.getY()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleDrop$lambda$1() {
        return "no supported image or text item in clip data";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleDrop$lambda$2() {
        return "permission grant refused for image uri";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleDrop$lambda$3(DroppedContent droppedContent, DragEvent dragEvent) {
        return droppedContent + " (" + dragEvent.getX() + TextRecallingManager.ANSWER_SEPARATOR + dragEvent.getY() + ")";
    }

    private final DroppedContent resolveDroppedContent(ContentResolver contentResolver, ClipData clipData) {
        CharSequence text;
        int mimeTypeCount = clipData.getDescription().getMimeTypeCount();
        int itemCount = clipData.getItemCount();
        String string = null;
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            Uri uri = itemAt.getUri();
            if (uri != null) {
                String type = contentResolver.getType(uri);
                if (type == null) {
                    type = mimeTypeCount == clipData.getItemCount() ? clipData.getDescription().getMimeType(i) : null;
                }
                if (type != null && (ArraysKt.contains(ImageImporter.INSTANCE.getSUPPORTED_IMAGE_MIMETYPES(), type) || StringsKt.startsWith$default(type, "image/", false, 2, (Object) null))) {
                    return new DroppedContent(uri, null);
                }
            }
            if (string == null && ((text = itemAt.getText()) == null || (string = text.toString()) == null || StringsKt.isBlank(string))) {
                string = null;
            }
        }
        if (string != null) {
            return new DroppedContent(null, string);
        }
        return null;
    }

    private final void setHighlighted(boolean highlighted) {
        GradientDrawable gradientDrawable;
        View view = this.highlightView;
        if (highlighted) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int iResolveColorAttribute = ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setStroke(this.highlightView.getResources().getDimensionPixelSize(C6079R.dimen.canvas_drop_target_stroke_width), iResolveColorAttribute);
            gradientDrawable2.setColor(ColorUtils.setAlphaComponent(iResolveColorAttribute, 40));
            gradientDrawable = gradientDrawable2;
        } else {
            gradientDrawable = null;
        }
        view.setForeground(gradientDrawable);
    }
}
