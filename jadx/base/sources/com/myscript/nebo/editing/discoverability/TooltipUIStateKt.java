package com.myscript.nebo.editing.discoverability;

import android.R;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.discoverability.p024ui.TooltipIllustration;
import com.myscript.nebo.discoverability.p024ui.TooltipPosition;
import com.myscript.nebo.discoverability.p024ui.TooltipType;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import com.myscript.nebo.penpanel.C6693R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TooltipUIState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"toTooltipState", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "visible", "", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooltipUIStateKt {
    public static /* synthetic */ TooltipUIState toTooltipState$default(EditingDiscoverableFeature editingDiscoverableFeature, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return toTooltipState(editingDiscoverableFeature, z);
    }

    public static final TooltipUIState toTooltipState(EditingDiscoverableFeature editingDiscoverableFeature, boolean z) {
        Intrinsics.checkNotNullParameter(editingDiscoverableFeature, "<this>");
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.DocumentFeature) {
            int i = C6079R.string.discovery_editing_document_title;
            int i2 = C6079R.string.discovery_editing_document_message;
            TooltipIllustration.Video video = new TooltipIllustration.Video(C6079R.raw.tooltip_video_document);
            return new TooltipUIState(i, i2, video, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Modal, z, EditingDiscoverableFeature.DocumentFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.NotebookFeature) {
            int i3 = C6079R.string.discovery_editing_notebook_title;
            int i4 = C6079R.string.discovery_editing_notebook_message;
            TooltipIllustration.Video video2 = new TooltipIllustration.Video(C6079R.raw.tooltip_video_notebook);
            return new TooltipUIState(i3, i4, video2, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Modal, z, EditingDiscoverableFeature.NotebookFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.BoardFeature) {
            int i5 = C6079R.string.discovery_editing_board_title;
            int i6 = C6079R.string.discovery_editing_board_message;
            TooltipIllustration.Video video3 = new TooltipIllustration.Video(C6079R.raw.tooltip_video_board);
            return new TooltipUIState(i5, i6, video3, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Modal, z, EditingDiscoverableFeature.BoardFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.PdfFeature) {
            int i7 = C6079R.string.discovery_editing_pdf_title;
            int i8 = C6079R.string.discovery_editing_pdf_message;
            TooltipIllustration.Video video4 = new TooltipIllustration.Video(C6079R.raw.tooltip_video_pdf);
            return new TooltipUIState(i7, i8, video4, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Modal, z, EditingDiscoverableFeature.PdfFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.AIExplainFeature) {
            int i9 = C6079R.string.discovery_editing_ai_title;
            int i10 = C6079R.string.discovery_editing_ai_message;
            TooltipIllustration.DrawableIllustration drawableIllustration = new TooltipIllustration.DrawableIllustration(C6079R.drawable.tooltip_ai);
            return new TooltipUIState(i9, i10, drawableIllustration, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Small, z, EditingDiscoverableFeature.AIExplainFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.PenOptionsFeature) {
            int i11 = C6079R.string.discovery_editing_pen_options_title;
            int i12 = C6079R.string.discovery_editing_pen_options_message;
            TooltipIllustration.DrawableIllustration drawableIllustration2 = new TooltipIllustration.DrawableIllustration(C6693R.drawable.ic_pen);
            return new TooltipUIState(i11, i12, drawableIllustration2, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Small, z, EditingDiscoverableFeature.PenOptionsFeature.INSTANCE.getDestination(), TooltipPosition.Bottom);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.AIQuizFeature) {
            int i13 = C6079R.string.discovery_editing_ai_quiz_title;
            int i14 = C6079R.string.discovery_editing_ai_quiz_message;
            TooltipIllustration.DrawableIllustration drawableIllustration3 = new TooltipIllustration.DrawableIllustration(C6079R.drawable.tooltip_ai);
            return new TooltipUIState(i13, i14, drawableIllustration3, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Small, z, EditingDiscoverableFeature.AIQuizFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.PdfAddPageFeature) {
            int i15 = C6079R.string.discovery_editing_pdf_add_page_title;
            int i16 = C6079R.string.discovery_editing_pdf_add_page_message;
            TooltipIllustration.DrawableIllustration drawableIllustration4 = new TooltipIllustration.DrawableIllustration(R.drawable.ic_menu_add);
            return new TooltipUIState(i15, i16, drawableIllustration4, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Small, z, EditingDiscoverableFeature.PdfAddPageFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.PdfOptimizationFeature) {
            int i17 = C6079R.string.app_more_menu_pdf_optimization;
            int i18 = C6079R.string.pdf_optim_tooltip_description;
            TooltipIllustration.DrawableIllustration drawableIllustration5 = new TooltipIllustration.DrawableIllustration(C6079R.drawable.ic_pdf);
            return new TooltipUIState(i17, i18, drawableIllustration5, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Small, z, EditingDiscoverableFeature.PdfOptimizationFeature.INSTANCE.getDestination(), TooltipPosition.Bottom);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.DocumentConvertTextFeature) {
            int i19 = C6079R.string.discovery_editing_document_convert_text_title;
            int i20 = C6079R.string.discovery_editing_document_convert_text_message;
            TooltipIllustration.LottieJson lottieJson = new TooltipIllustration.LottieJson("convert_documents.json");
            return new TooltipUIState(i19, i20, lottieJson, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Large, z, EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.ConvertTextFeature) {
            int i21 = C6079R.string.discovery_editing_convert_text_title;
            int i22 = C6079R.string.discovery_editing_convert_text_message;
            TooltipIllustration.LottieJson lottieJson2 = new TooltipIllustration.LottieJson("convert.json");
            return new TooltipUIState(i21, i22, lottieJson2, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Large, z, EditingDiscoverableFeature.DocumentConvertTextFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (editingDiscoverableFeature instanceof EditingDiscoverableFeature.ScratchOutGestureFeature) {
            int i23 = C6079R.string.discovery_editing_scratch_out_gesture_title;
            int i24 = C6079R.string.discovery_editing_scratch_out_gesture_message;
            TooltipIllustration.LottieJson lottieJson3 = new TooltipIllustration.LottieJson("scratch.json");
            return new TooltipUIState(i23, i24, lottieJson3, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Large, z, EditingDiscoverableFeature.ScratchOutGestureFeature.INSTANCE.getDestination(), null, 128, null);
        }
        if (!(editingDiscoverableFeature instanceof EditingDiscoverableFeature.ShapesFeature)) {
            throw new NoWhenBranchMatchedException();
        }
        int i25 = C6079R.string.discovery_editing_shapes_on_hold_title;
        int i26 = C6079R.string.discovery_editing_shapes_on_hold_message;
        TooltipIllustration.LottieJson lottieJson4 = new TooltipIllustration.LottieJson("shaped.json");
        return new TooltipUIState(i25, i26, lottieJson4, EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().indexOf(editingDiscoverableFeature), TooltipType.Large, z, EditingDiscoverableFeature.ShapesFeature.INSTANCE.getDestination(), null, 128, null);
    }
}
