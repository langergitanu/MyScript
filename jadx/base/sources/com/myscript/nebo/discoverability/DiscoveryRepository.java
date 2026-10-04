package com.myscript.nebo.discoverability;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DiscoveryRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/DiscoveryRepository;", "Lcom/myscript/nebo/discoverability/IDiscoveryRepository;", "discoveryDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "<init>", "(Landroidx/datastore/core/DataStore;)V", "isDiscovered", "", "feature", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "(Lcom/myscript/nebo/discoverability/IDiscoverableFeature;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discover", "", "isDiscoverable", "defaultValue", "(Lcom/myscript/nebo/discoverability/IDiscoverableFeature;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDiscoverable", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Provider", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DiscoveryRepository implements IDiscoveryRepository {
    public static final int $stable = 8;
    private final DataStore<Preferences> discoveryDataStore;

    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/DiscoveryRepository$Provider;", "", "provideDiscoveryRepository", "Lcom/myscript/nebo/discoverability/DiscoveryRepository;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        DiscoveryRepository provideDiscoveryRepository();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoveryRepository$isDiscoverable$1 */
    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoveryRepository", m1609f = "DiscoveryRepository.kt", m1610i = {0, 0}, m1611l = {26}, m1612m = "isDiscoverable", m1613n = {"feature", "defaultValue"}, m1614nl = {-1}, m1615s = {"L$0", "Z$0"}, m1616v = 2)
    static final class C62021 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C62021(Continuation<? super C62021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoveryRepository.this.isDiscoverable(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoveryRepository$isDiscovered$1 */
    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoveryRepository", m1609f = "DiscoveryRepository.kt", m1610i = {0}, m1611l = {16}, m1612m = "isDiscovered", m1613n = {"feature"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
    static final class C62031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C62031(Continuation<? super C62031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoveryRepository.this.isDiscovered(null, this);
        }
    }

    public DiscoveryRepository(DataStore<Preferences> discoveryDataStore) {
        Intrinsics.checkNotNullParameter(discoveryDataStore, "discoveryDataStore");
        this.discoveryDataStore = discoveryDataStore;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.discoverability.IDiscoveryRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object isDiscovered(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Boolean> continuation) {
        C62031 c62031;
        Boolean bool;
        if (continuation instanceof C62031) {
            c62031 = (C62031) continuation;
            if ((c62031.label & Integer.MIN_VALUE) != 0) {
                c62031.label -= Integer.MIN_VALUE;
            } else {
                c62031 = new C62031(continuation);
            }
        }
        Object objFirstOrNull = c62031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            Flow<Preferences> data = this.discoveryDataStore.getData();
            c62031.L$0 = iDiscoverableFeature;
            c62031.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(data, c62031);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iDiscoverableFeature = (IDiscoverableFeature) c62031.L$0;
            ResultKt.throwOnFailure(objFirstOrNull);
        }
        Preferences preferences = (Preferences) objFirstOrNull;
        return Boxing.boxBoolean((preferences == null || (bool = (Boolean) preferences.get(PreferencesKeys.booleanKey(iDiscoverableFeature.getDiscoveryKey()))) == null) ? false : bool.booleanValue());
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoveryRepository$discover$2 */
    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoveryRepository$discover$2", m1609f = "DiscoveryRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62012 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDiscoverableFeature $feature;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62012(IDiscoverableFeature iDiscoverableFeature, Continuation<? super C62012> continuation) {
            super(2, continuation);
            this.$feature = iDiscoverableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62012 c62012 = new C62012(this.$feature, continuation);
            c62012.L$0 = obj;
            return c62012;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((C62012) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mutablePreferences.set(PreferencesKeys.booleanKey(this.$feature.getDiscoveryKey()), Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.discoverability.IDiscoveryRepository
    public Object discover(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(this.discoveryDataStore, new C62012(iDiscoverableFeature, null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.discoverability.IDiscoveryRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object isDiscoverable(IDiscoverableFeature iDiscoverableFeature, boolean z, Continuation<? super Boolean> continuation) {
        C62021 c62021;
        Boolean bool;
        if (continuation instanceof C62021) {
            c62021 = (C62021) continuation;
            if ((c62021.label & Integer.MIN_VALUE) != 0) {
                c62021.label -= Integer.MIN_VALUE;
            } else {
                c62021 = new C62021(continuation);
            }
        }
        Object objFirstOrNull = c62021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62021.label;
        boolean zBooleanValue = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            Flow<Preferences> data = this.discoveryDataStore.getData();
            c62021.L$0 = iDiscoverableFeature;
            c62021.Z$0 = z;
            c62021.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(data, c62021);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c62021.Z$0;
            iDiscoverableFeature = (IDiscoverableFeature) c62021.L$0;
            ResultKt.throwOnFailure(objFirstOrNull);
        }
        Preferences preferences = (Preferences) objFirstOrNull;
        if (preferences != null && (bool = (Boolean) preferences.get(PreferencesKeys.booleanKey(iDiscoverableFeature.getPrerequisiteKey()))) != null) {
            zBooleanValue = bool.booleanValue();
        } else if (!z) {
            zBooleanValue = false;
        }
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoveryRepository$setDiscoverable$2 */
    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoveryRepository$setDiscoverable$2", m1609f = "DiscoveryRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62042 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDiscoverableFeature $feature;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62042(IDiscoverableFeature iDiscoverableFeature, Continuation<? super C62042> continuation) {
            super(2, continuation);
            this.$feature = iDiscoverableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62042 c62042 = new C62042(this.$feature, continuation);
            c62042.L$0 = obj;
            return c62042;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((C62042) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mutablePreferences.set(PreferencesKeys.booleanKey(this.$feature.getPrerequisiteKey()), Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.discoverability.IDiscoveryRepository
    public Object setDiscoverable(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(this.discoveryDataStore, new C62042(iDiscoverableFeature, null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoveryRepository$clear$2 */
    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoveryRepository$clear$2", m1609f = "DiscoveryRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62002 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C62002(Continuation<? super C62002> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62002 c62002 = new C62002(continuation);
            c62002.L$0 = obj;
            return c62002;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((C62002) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mutablePreferences.clear();
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.discoverability.IDiscoveryRepository
    public Object clear(Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(this.discoveryDataStore, new C62002(null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }
}
