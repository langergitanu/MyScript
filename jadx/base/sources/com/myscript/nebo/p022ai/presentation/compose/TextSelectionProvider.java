package com.myscript.nebo.p022ai.presentation.compose;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AIContainerViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/TextSelectionProvider;", "", "hasSelection", "", "getPageTextSelection", "Lcom/myscript/nebo/ai/presentation/compose/AiTextSelection;", "getAllPagesText", "childPageIds", "", "", "textSelectionWithContext", "availableTextInCurrentPage", "isPdfContext", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface TextSelectionProvider {
    AiTextSelection availableTextInCurrentPage();

    AiTextSelection getAllPagesText(List<String> childPageIds);

    AiTextSelection getPageTextSelection();

    boolean hasSelection();

    boolean isPdfContext();

    AiTextSelection textSelectionWithContext();

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ AiTextSelection getAllPagesText$default(TextSelectionProvider textSelectionProvider, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllPagesText");
        }
        if ((i & 1) != 0) {
            list = null;
        }
        return textSelectionProvider.getAllPagesText(list);
    }
}
