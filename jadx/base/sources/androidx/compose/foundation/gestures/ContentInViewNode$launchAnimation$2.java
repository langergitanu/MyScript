package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p004ui.unit.IntOffset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: ContentInViewNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", m1609f = "ContentInViewNode.kt", m1610i = {}, m1611l = {212}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdatableAnimationState $animationState;
    final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
    final /* synthetic */ long $viewportAdjustmentForReverseScroll;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, long j, Continuation<? super ContentInViewNode$launchAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
        this.$animationState = updatableAnimationState;
        this.$bringIntoViewSpec = bringIntoViewSpec;
        this.$viewportAdjustmentForReverseScroll = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, this.$animationState, this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewNode$launchAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                    this.this$0.isAnimationRunning = true;
                    this.label = 1;
                    if (this.this$0.scrollingLogic.scroll(MutatePriority.Default, new C03721(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, job, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.bringIntoViewRequests.resumeAndRemoveAll();
                this.this$0.isAnimationRunning = false;
                this.this$0.bringIntoViewRequests.cancelAndRemoveAll(null);
                this.this$0.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                throw e;
            }
        } catch (Throwable th) {
            this.this$0.isAnimationRunning = false;
            this.this$0.bringIntoViewRequests.cancelAndRemoveAll((Throwable) null);
            this.this$0.trackingFocusedChild = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1 */
    /* JADX INFO: compiled from: ContentInViewNode.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", m1609f = "ContentInViewNode.kt", m1610i = {}, m1611l = {219}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03721 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $animationJob;
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
        final /* synthetic */ long $viewportAdjustmentForReverseScroll;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03721(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, long j, Job job, Continuation<? super C03721> continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
            this.this$0 = contentInViewNode;
            this.$bringIntoViewSpec = bringIntoViewSpec;
            this.$viewportAdjustmentForReverseScroll = j;
            this.$animationJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03721 c03721 = new C03721(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, this.$animationJob, continuation);
            c03721.L$0 = obj;
            return c03721;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
            return ((C03721) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
                this.$animationState.setValue(this.this$0.m2227calculateScrollDeltaI_oMVgE(this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll));
                final UpdatableAnimationState updatableAnimationState = this.$animationState;
                final ContentInViewNode contentInViewNode = this.this$0;
                final Job job = this.$animationJob;
                Function1<? super Float, Unit> function1 = new Function1() { // from class: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ContentInViewNode$launchAnimation$2.C03721.invokeSuspend$lambda$0(contentInViewNode, updatableAnimationState, job, nestedScrollScope, ((Float) obj2).floatValue());
                    }
                };
                final ContentInViewNode contentInViewNode2 = this.this$0;
                final UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                final BringIntoViewSpec bringIntoViewSpec = this.$bringIntoViewSpec;
                this.label = 1;
                if (updatableAnimationState.animateToZero(function1, new Function0() { // from class: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ContentInViewNode$launchAnimation$2.C03721.invokeSuspend$lambda$1(contentInViewNode2, updatableAnimationState2, bringIntoViewSpec);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, Job job, NestedScrollScope nestedScrollScope, float f) {
            float f2 = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
            ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
            float fM2398toFloatk4lQ0M = f2 * scrollingLogic.m2398toFloatk4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(nestedScrollScope.mo2335scrollByOzD1aCk(scrollingLogic.m2396reverseIfNeededMKHz9U(scrollingLogic.m2399toOffsettuRUvjQ(f2 * f)), NestedScrollSource.INSTANCE.m9361getUserInputWNlRxjI())));
            if (Math.abs(fM2398toFloatk4lQ0M) < Math.abs(f)) {
                JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + fM2398toFloatk4lQ0M + " < " + f + ')', null, 2, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec) {
            ContentInViewNode contentInViewNode2;
            boolean zM2231isMaxVisibleEQwtKw$default;
            BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = contentInViewNode.bringIntoViewRequests;
            while (true) {
                if (bringIntoViewRequestPriorityQueue.requests.getSize() == 0) {
                    contentInViewNode2 = contentInViewNode;
                    break;
                }
                Rect rectInvoke = ((ContentInViewNode.Request) bringIntoViewRequestPriorityQueue.requests.last()).getCurrentBounds().invoke();
                if (rectInvoke == null) {
                    contentInViewNode2 = contentInViewNode;
                    zM2231isMaxVisibleEQwtKw$default = true;
                } else {
                    contentInViewNode2 = contentInViewNode;
                    zM2231isMaxVisibleEQwtKw$default = ContentInViewNode.m2231isMaxVisibleEQwtKw$default(contentInViewNode2, rectInvoke, 0L, 0L, 3, null);
                }
                if (!zM2231isMaxVisibleEQwtKw$default) {
                    break;
                }
                CancellableContinuation<Unit> continuation = ((ContentInViewNode.Request) bringIntoViewRequestPriorityQueue.requests.removeAt(bringIntoViewRequestPriorityQueue.requests.getSize() - 1)).getContinuation();
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m14499constructorimpl(unit));
                contentInViewNode = contentInViewNode2;
            }
            if (contentInViewNode2.trackingFocusedChild) {
                Rect rect = (Rect) contentInViewNode2.getFocusedRect.invoke();
                if (rect != null && ContentInViewNode.m2231isMaxVisibleEQwtKw$default(contentInViewNode2, rect, 0L, 0L, 3, null)) {
                    contentInViewNode2.trackingFocusedChild = false;
                }
            }
            updatableAnimationState.setValue(contentInViewNode2.m2227calculateScrollDeltaI_oMVgE(bringIntoViewSpec, IntOffset.INSTANCE.m11156getZeronOccac()));
            return Unit.INSTANCE;
        }
    }
}
