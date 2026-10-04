package com.myscript.nebo.dms.core;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel", m1609f = "LibraryViewModel.kt", m1610i = {0, 1}, m1611l = {712, 713}, m1612m = "collapseToolbar-VtjQ1oo", m1613n = {TtmlNode.ANNOTATION_POSITION_AFTER, TtmlNode.ANNOTATION_POSITION_AFTER}, m1614nl = {713, PDFACompliance.e_PDFA7_2_4}, m1615s = {"J$0", "J$0"}, m1616v = 2)
final class LibraryViewModel$collapseToolbar$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LibraryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$collapseToolbar$1(LibraryViewModel libraryViewModel, Continuation<? super LibraryViewModel$collapseToolbar$1> continuation) {
        super(continuation);
        this.this$0 = libraryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m12967collapseToolbarVtjQ1oo(0L, this);
    }
}
