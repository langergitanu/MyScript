package com.myscript.nebo.inspector;

import android.widget.TextView;
import androidx.media3.extractor.p007ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: NeboInspectorActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboInspectorActivity$onCreate$3$1", m1609f = "NeboInspectorActivity.kt", m1610i = {}, m1611l = {86}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m1615s = {}, m1616v = 2)
final class NeboInspectorActivity$onCreate$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InspectorInformation $information;
    final /* synthetic */ TextView $this_apply;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboInspectorActivity$onCreate$3$1(TextView textView, InspectorInformation inspectorInformation, Continuation<? super NeboInspectorActivity$onCreate$3$1> continuation) {
        super(2, continuation);
        this.$this_apply = textView;
        this.$information = inspectorInformation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboInspectorActivity$onCreate$3$1(this.$this_apply, this.$information, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboInspectorActivity$onCreate$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboInspectorActivity$onCreate$3$1$1 */
    /* JADX INFO: compiled from: NeboInspectorActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboInspectorActivity$onCreate$3$1$1", m1609f = "NeboInspectorActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ InspectorInformation $information;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66041(InspectorInformation inspectorInformation, Continuation<? super C66041> continuation) {
            super(2, continuation);
            this.$information = inspectorInformation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C66041(this.$information, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C66041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return InspectorInformationKt.toJson$default(this.$information, false, 1, null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TextView textView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextView textView2 = this.$this_apply;
            this.L$0 = textView2;
            this.label = 1;
            Object objWithContext = BuildersKt.withContext(Dispatchers.getDefault(), new C66041(this.$information, null), this);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            textView = textView2;
            obj = objWithContext;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            textView = (TextView) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        textView.setText((CharSequence) obj);
        return Unit.INSTANCE;
    }
}
