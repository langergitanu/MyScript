package androidx.media3.common;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: compiled from: PlayerExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@kotlin.Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0087@¢\u0006\u0002\u0010\b\u001aE\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00020\r\"\u00020\u000b2\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0087@¢\u0006\u0002\u0010\u000e\u001a;\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0082@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"listen", "", "Landroidx/media3/common/Player;", "onEvents", "Lkotlin/Function2;", "Landroidx/media3/common/Player$Events;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/media3/common/Player;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listenTo", "firstEvent", "", "otherEvents", "", "(Landroidx/media3/common/Player;I[ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listenImpl", "events", "(Landroidx/media3/common/Player;Landroidx/media3/common/Player$Events;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib-common-ktx_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PlayerExtensionsKt {

    /* JADX INFO: renamed from: androidx.media3.common.PlayerExtensionsKt$listen$1 */
    /* JADX INFO: compiled from: PlayerExtensions.kt */
    @kotlin.Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.common.PlayerExtensionsKt", m1609f = "PlayerExtensions.kt", m1610i = {}, m1611l = {47, 49}, m1612m = "listen", m1613n = {}, m1615s = {})
    static final class C21971 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C21971(Continuation<? super C21971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerExtensionsKt.listen(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.common.PlayerExtensionsKt$listenImpl$1 */
    /* JADX INFO: compiled from: PlayerExtensions.kt */
    @kotlin.Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.common.PlayerExtensionsKt", m1609f = "PlayerExtensions.kt", m1610i = {0, 0, 0, 0}, m1611l = {157}, m1612m = "listenImpl", m1613n = {"$this$listenImpl", "events", "onEvents", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, m1615s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C21991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C21991(Continuation<? super C21991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerExtensionsKt.listenImpl(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.common.PlayerExtensionsKt$listenTo$1 */
    /* JADX INFO: compiled from: PlayerExtensions.kt */
    @kotlin.Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.common.PlayerExtensionsKt", m1609f = "PlayerExtensions.kt", m1610i = {}, m1611l = {85, 87}, m1612m = "listenTo", m1613n = {}, m1615s = {})
    static final class C22001 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C22001(Continuation<? super C22001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerExtensionsKt.listenTo(null, 0, null, null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (listenImpl(r6, null, r7, r0) == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r8, r4, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object listen(Player player, Function2<? super Player, ? super Player.Events, Unit> function2, Continuation<?> continuation) {
        C21971 c21971;
        if (continuation instanceof C21971) {
            c21971 = (C21971) continuation;
            if ((c21971.label & Integer.MIN_VALUE) != 0) {
                c21971.label -= Integer.MIN_VALUE;
            } else {
                c21971 = new C21971(continuation);
            }
        }
        Object obj = c21971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c21971.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                throw new KotlinNothingValueException();
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new KotlinNothingValueException();
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(Looper.myLooper(), player.getApplicationLooper())) {
            c21971.label = 1;
        } else {
            Handler handlerCreateAsync = HandlerCompat.createAsync(player.getApplicationLooper());
            Intrinsics.checkNotNullExpressionValue(handlerCreateAsync, "createAsync(...)");
            HandlerDispatcher handlerDispatcherFrom$default = HandlerDispatcherKt.from$default(handlerCreateAsync, null, 1, null);
            C21982 c21982 = new C21982(player, function2, null);
            c21971.label = 2;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: androidx.media3.common.PlayerExtensionsKt$listen$2 */
    /* JADX INFO: compiled from: PlayerExtensions.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.common.PlayerExtensionsKt$listen$2", m1609f = "PlayerExtensions.kt", m1610i = {}, m1611l = {50}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C21982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Function2<Player, Player.Events, Unit> $onEvents;
        final /* synthetic */ Player $this_listen;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C21982(Player player, Function2<? super Player, ? super Player.Events, Unit> function2, Continuation<? super C21982> continuation) {
            super(2, continuation);
            this.$this_listen = player;
            this.$onEvents = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21982(this.$this_listen, this.$onEvents, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            return ((C21982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PlayerExtensionsKt.listenImpl(this.$this_listen, null, this.$onEvents, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (listenImpl(r5, r9, r8, r0) == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object listenTo(Player player, int i, int[] iArr, Function2<? super Player, ? super Player.Events, Unit> function2, Continuation<?> continuation) {
        C22001 c22001;
        if (continuation instanceof C22001) {
            c22001 = (C22001) continuation;
            if ((c22001.label & Integer.MIN_VALUE) != 0) {
                c22001.label -= Integer.MIN_VALUE;
            } else {
                c22001 = new C22001(continuation);
            }
        }
        Object obj = c22001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22001.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                throw new KotlinNothingValueException();
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new KotlinNothingValueException();
        }
        ResultKt.throwOnFailure(obj);
        Player.Events events = new Player.Events(new FlagSet.Builder().add(i).addAll(Arrays.copyOf(iArr, iArr.length)).build());
        if (Intrinsics.areEqual(Looper.myLooper(), player.getApplicationLooper())) {
            c22001.label = 1;
        } else {
            Handler handlerCreateAsync = HandlerCompat.createAsync(player.getApplicationLooper());
            Intrinsics.checkNotNullExpressionValue(handlerCreateAsync, "createAsync(...)");
            HandlerDispatcher handlerDispatcherFrom$default = HandlerDispatcherKt.from$default(handlerCreateAsync, null, 1, null);
            C22012 c22012 = new C22012(player, events, function2, null);
            c22001.label = 2;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: androidx.media3.common.PlayerExtensionsKt$listenTo$2 */
    /* JADX INFO: compiled from: PlayerExtensions.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.common.PlayerExtensionsKt$listenTo$2", m1609f = "PlayerExtensions.kt", m1610i = {}, m1611l = {88}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C22012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Function2<Player, Player.Events, Unit> $onEvents;
        final /* synthetic */ Player.Events $playerEvents;
        final /* synthetic */ Player $this_listenTo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C22012(Player player, Player.Events events, Function2<? super Player, ? super Player.Events, Unit> function2, Continuation<? super C22012> continuation) {
            super(2, continuation);
            this.$this_listenTo = player;
            this.$playerEvents = events;
            this.$onEvents = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22012(this.$this_listenTo, this.$playerEvents, this.$onEvents, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            return ((C22012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PlayerExtensionsKt.listenImpl(this.$this_listenTo, this.$playerEvents, this.$onEvents, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, androidx.media3.common.PlayerListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object listenImpl(Player player, Player.Events events, Function2<? super Player, ? super Player.Events, Unit> function2, Continuation<?> continuation) throws Throwable {
        C21991 c21991;
        final Ref.ObjectRef objectRef;
        PlayerListener playerListener;
        Throwable th;
        if (continuation instanceof C21991) {
            c21991 = (C21991) continuation;
            if ((c21991.label & Integer.MIN_VALUE) != 0) {
                c21991.label -= Integer.MIN_VALUE;
            } else {
                c21991 = new C21991(continuation);
            }
        }
        Object obj = c21991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c21991.label;
        PlayerListener playerListener2 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            objectRef = new Ref.ObjectRef();
            try {
                c21991.L$0 = player;
                c21991.L$1 = events;
                c21991.L$2 = function2;
                c21991.L$3 = objectRef;
                c21991.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c21991), 1);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                objectRef.element = new PlayerListener(events, function2, cancellableContinuationImpl2);
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.media3.common.PlayerExtensionsKt$listenImpl$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th2) {
                        PlayerListener playerListener3;
                        if (objectRef.element == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                            playerListener3 = null;
                        } else {
                            playerListener3 = objectRef.element;
                        }
                        playerListener3.getIsCancelled().set(true);
                    }
                });
                if (objectRef.element == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                    playerListener = null;
                } else {
                    playerListener = (PlayerListener) objectRef.element;
                }
                player.addListener(playerListener);
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c21991);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th2) {
                th = th2;
                if (objectRef.element != 0) {
                }
                player.removeListener(playerListener2);
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.ObjectRef objectRef2 = (Ref.ObjectRef) c21991.L$3;
            Player player2 = (Player) c21991.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                objectRef = objectRef2;
                player = player2;
            } catch (Throwable th3) {
                th = th3;
                objectRef = objectRef2;
                player = player2;
                if (objectRef.element != 0) {
                    Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                } else {
                    playerListener2 = (PlayerListener) objectRef.element;
                }
                player.removeListener(playerListener2);
                throw th;
            }
        }
        throw new KotlinNothingValueException();
    }
}
