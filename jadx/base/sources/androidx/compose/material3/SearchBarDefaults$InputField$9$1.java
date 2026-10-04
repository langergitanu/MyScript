package androidx.compose.material3;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.material3.SearchBarDefaults$InputField$9$1", m1609f = "SearchBar.kt", m1610i = {}, m1611l = {1442}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class SearchBarDefaults$InputField$9$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ State<Boolean> $focused$delegate;
    final /* synthetic */ SearchBarState $searchBarState;
    final /* synthetic */ TextFieldState $textFieldState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchBarDefaults$InputField$9$1(SearchBarState searchBarState, TextFieldState textFieldState, CoroutineScope coroutineScope, State<Boolean> state, Continuation<? super SearchBarDefaults$InputField$9$1> continuation) {
        super(2, continuation);
        this.$searchBarState = searchBarState;
        this.$textFieldState = textFieldState;
        this.$coroutineScope = coroutineScope;
        this.$focused$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchBarDefaults$InputField$9$1(this.$searchBarState, this.$textFieldState, this.$coroutineScope, this.$focused$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchBarDefaults$InputField$9$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!SearchBarKt.isExpanded(this.$searchBarState)) {
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = this.$textFieldState.getText().length();
                final TextFieldState textFieldState = this.$textFieldState;
                this.label = 1;
                if (FlowKt.onEach(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$9$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return textFieldState.getText();
                    }
                }), new C10832(intRef, this.$searchBarState, this.$coroutineScope, this.$focused$delegate, null)).collect(new FlowCollector() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$9$1.3
                    public final Object emit(CharSequence charSequence, Continuation<? super Unit> continuation) {
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CharSequence) obj2, (Continuation<? super Unit>) continuation);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarDefaults$InputField$9$1$2 */
    /* JADX INFO: compiled from: SearchBar.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "it", ""}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.material3.SearchBarDefaults$InputField$9$1$2", m1609f = "SearchBar.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C10832 extends SuspendLambda implements Function2<CharSequence, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $coroutineScope;
        final /* synthetic */ State<Boolean> $focused$delegate;
        final /* synthetic */ Ref.IntRef $prevLength;
        final /* synthetic */ SearchBarState $searchBarState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10832(Ref.IntRef intRef, SearchBarState searchBarState, CoroutineScope coroutineScope, State<Boolean> state, Continuation<? super C10832> continuation) {
            super(2, continuation);
            this.$prevLength = intRef;
            this.$searchBarState = searchBarState;
            this.$coroutineScope = coroutineScope;
            this.$focused$delegate = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10832 c10832 = new C10832(this.$prevLength, this.$searchBarState, this.$coroutineScope, this.$focused$delegate, continuation);
            c10832.L$0 = obj;
            return c10832;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CharSequence charSequence, Continuation<? super Unit> continuation) {
            return ((C10832) create(charSequence, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int length = ((CharSequence) this.L$0).length();
            if (length > this.$prevLength.element && SearchBarDefaults.InputField$lambda$5(this.$focused$delegate) && !SearchBarKt.isExpanded(this.$searchBarState)) {
                BuildersKt__Builders_commonKt.launch$default(this.$coroutineScope, null, null, new AnonymousClass1(this.$searchBarState, null), 3, null);
            }
            this.$prevLength.element = length;
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.material3.SearchBarDefaults$InputField$9$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SearchBar.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.material3.SearchBarDefaults$InputField$9$1$2$1", m1609f = "SearchBar.kt", m1610i = {}, m1611l = {1438}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SearchBarState $searchBarState;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SearchBarState searchBarState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$searchBarState = searchBarState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$searchBarState, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$searchBarState.animateToExpanded(this) == coroutine_suspended) {
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
    }
}
