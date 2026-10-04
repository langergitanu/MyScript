package androidx.compose.p004ui.viewinterop;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.relocation.BringIntoViewModifierNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012,\u0010\u0002\u001a(\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J4\u0010\u0011\u001a\u00020\u00052,\u0010\u0002\u001a(\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0007R@\u0010\u0002\u001a(\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\tR#\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0012"}, m1599d2 = {"Landroidx/compose/ui/viewinterop/BringIntoViewNode;", "Landroidx/compose/ui/Modifier$Node;", "onRequesterReady", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/viewinterop/BringIntoViewRequester;", "Landroidx/compose/ui/viewinterop/OnRequesterReady;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnRequesterReady", "()Lkotlin/jvm/functions/Function1;", "setOnRequesterReady", "requester", "getRequester", "onAttach", "onDetach", "update", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class BringIntoViewNode extends Modifier.Node {
    private Function1<? super Function1<? super Rect, Unit>, Unit> onRequesterReady;
    private final Function1<Rect, Unit> requester = new Function1<Rect, Unit>() { // from class: androidx.compose.ui.viewinterop.BringIntoViewNode$requester$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
            invoke2(rect);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.BringIntoViewNode$requester$1$1 */
        /* JADX INFO: compiled from: AndroidViewHolder.android.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.ui.viewinterop.BringIntoViewNode$requester$1$1", m1609f = "AndroidViewHolder.android.kt", m1610i = {}, m1611l = {764}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class C14961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Rect $rect;
            int label;
            final /* synthetic */ BringIntoViewNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C14961(BringIntoViewNode bringIntoViewNode, Rect rect, Continuation<? super C14961> continuation) {
                super(2, continuation);
                this.this$0 = bringIntoViewNode;
                this.$rect = rect;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C14961(this.this$0, this.$rect, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C14961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    BringIntoViewNode bringIntoViewNode = this.this$0;
                    final Rect rect = this.$rect;
                    this.label = 1;
                    if (BringIntoViewModifierNodeKt.bringIntoView(bringIntoViewNode, new Function0<Rect>() { // from class: androidx.compose.ui.viewinterop.BringIntoViewNode.requester.1.1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Rect invoke() {
                            return rect;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Rect rect) {
            if (this.this$0.getIsAttached()) {
                BuildersKt__Builders_commonKt.launch$default(this.this$0.getCoroutineScope(), null, null, new C14961(this.this$0, rect, null), 3, null);
            }
        }
    };

    public BringIntoViewNode(Function1<? super Function1<? super Rect, Unit>, Unit> function1) {
        this.onRequesterReady = function1;
    }

    public final Function1<Function1<? super Rect, Unit>, Unit> getOnRequesterReady() {
        return this.onRequesterReady;
    }

    public final void setOnRequesterReady(Function1<? super Function1<? super Rect, Unit>, Unit> function1) {
        this.onRequesterReady = function1;
    }

    public final Function1<Rect, Unit> getRequester() {
        return this.requester;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.onRequesterReady.invoke(this.requester);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.onRequesterReady.invoke(null);
    }

    public final void update(Function1<? super Function1<? super Rect, Unit>, Unit> onRequesterReady) {
        this.onRequesterReady = onRequesterReady;
        if (getIsAttached()) {
            onRequesterReady.invoke(this.requester);
        }
    }
}
