package com.myscript.nebo.rating;

import android.os.Bundle;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RatingInviteDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.rating.RatingInviteDialogKt$RatingInviteDialog$1$1", m1609f = "RatingInviteDialog.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class RatingInviteDialogKt$RatingInviteDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $origin;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingInviteDialogKt$RatingInviteDialog$1$1(String str, Continuation<? super RatingInviteDialogKt$RatingInviteDialog$1$1> continuation) {
        super(2, continuation);
        this.$origin = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RatingInviteDialogKt$RatingInviteDialog$1$1(this.$origin, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RatingInviteDialogKt$RatingInviteDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        NeboFirebaseEvent neboFirebaseEvent = NeboFirebaseEvent.PreRatingDisplay;
        final String str = this.$origin;
        neboFirebaseEvent.log(new Function1() { // from class: com.myscript.nebo.rating.RatingInviteDialogKt$RatingInviteDialog$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return RatingInviteDialogKt$RatingInviteDialog$1$1.invokeSuspend$lambda$0(str, (Bundle) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(String str, Bundle bundle) {
        bundle.putString("origin", str);
        return Unit.INSTANCE;
    }
}
