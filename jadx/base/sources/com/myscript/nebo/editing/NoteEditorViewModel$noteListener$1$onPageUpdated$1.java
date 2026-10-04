package com.myscript.nebo.editing;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NoteEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$noteListener$1$onPageUpdated$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class NoteEditorViewModel$noteListener$1$onPageUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentFolderName;
    final /* synthetic */ String $newFolderName;
    final /* synthetic */ String $newName;
    final /* synthetic */ String $newNoteLanguage;
    int label;
    final /* synthetic */ NoteEditorViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NoteEditorViewModel$noteListener$1$onPageUpdated$1(NoteEditorViewModel noteEditorViewModel, String str, String str2, String str3, String str4, Continuation<? super NoteEditorViewModel$noteListener$1$onPageUpdated$1> continuation) {
        super(2, continuation);
        this.this$0 = noteEditorViewModel;
        this.$newName = str;
        this.$newFolderName = str2;
        this.$currentFolderName = str3;
        this.$newNoteLanguage = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoteEditorViewModel$noteListener$1$onPageUpdated$1(this.this$0, this.$newName, this.$newFolderName, this.$currentFolderName, this.$newNoteLanguage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NoteEditorViewModel$noteListener$1$onPageUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData mutableLiveData = this.this$0._noteProperties;
            NoteProperties openNoteProperties = this.this$0.getOpenNoteProperties();
            String str = this.$newName;
            String str2 = this.$newFolderName;
            if (str2 == null) {
                str2 = this.$currentFolderName;
            }
            mutableLiveData.setValue(NoteProperties.copy$default(openNoteProperties, null, str, str2, this.$newNoteLanguage, null, 17, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
