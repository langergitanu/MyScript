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

/* JADX INFO: compiled from: IFeatureUsageMetrics.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/FeatureUsageMetrics;", "Lcom/myscript/nebo/discoverability/IFeatureUsageMetrics;", "Lcom/myscript/nebo/discoverability/IExtraMetrics;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "<init>", "(Landroidx/datastore/core/DataStore;)V", "recordVariableDeclaration", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVariableDeclarationsCount", "", "DiscoveryDataStoreKeys", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FeatureUsageMetrics implements IFeatureUsageMetrics, IExtraMetrics {
    public static final int $stable = 8;
    private final DataStore<Preferences> dataStore;

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.FeatureUsageMetrics$getVariableDeclarationsCount$1 */
    /* JADX INFO: compiled from: IFeatureUsageMetrics.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.FeatureUsageMetrics", m1609f = "IFeatureUsageMetrics.kt", m1610i = {}, m1611l = {26}, m1612m = "getVariableDeclarationsCount", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C62051 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C62051(Continuation<? super C62051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeatureUsageMetrics.this.getVariableDeclarationsCount(this);
        }
    }

    public FeatureUsageMetrics(DataStore<Preferences> dataStore) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.dataStore = dataStore;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.FeatureUsageMetrics$recordVariableDeclaration$2 */
    /* JADX INFO: compiled from: IFeatureUsageMetrics.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.FeatureUsageMetrics$recordVariableDeclaration$2", m1609f = "IFeatureUsageMetrics.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62062 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C62062(Continuation<? super C62062> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62062 c62062 = new C62062(continuation);
            c62062.L$0 = obj;
            return c62062;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((C62062) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Preferences.Key<Integer> variableDeclarationKey = DiscoveryDataStoreKeys.INSTANCE.getVariableDeclarationKey();
            Integer num = (Integer) mutablePreferences.get(DiscoveryDataStoreKeys.INSTANCE.getVariableDeclarationKey());
            mutablePreferences.set(variableDeclarationKey, Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.discoverability.IFeatureUsageMetrics
    public Object recordVariableDeclaration(Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(this.dataStore, new C62062(null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.discoverability.IFeatureUsageMetrics
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getVariableDeclarationsCount(Continuation<? super Integer> continuation) {
        C62051 c62051;
        Integer num;
        if (continuation instanceof C62051) {
            c62051 = (C62051) continuation;
            if ((c62051.label & Integer.MIN_VALUE) != 0) {
                c62051.label -= Integer.MIN_VALUE;
            } else {
                c62051 = new C62051(continuation);
            }
        }
        Object objFirstOrNull = c62051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62051.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            Flow<Preferences> data = this.dataStore.getData();
            c62051.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(data, c62051);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFirstOrNull);
        }
        Preferences preferences = (Preferences) objFirstOrNull;
        return Boxing.boxInt((preferences == null || (num = (Integer) preferences.get(DiscoveryDataStoreKeys.INSTANCE.getVariableDeclarationKey())) == null) ? 0 : num.intValue());
    }

    /* JADX INFO: compiled from: IFeatureUsageMetrics.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/FeatureUsageMetrics$DiscoveryDataStoreKeys;", "", "<init>", "()V", "variableDeclarationKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getVariableDeclarationKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class DiscoveryDataStoreKeys {
        public static final DiscoveryDataStoreKeys INSTANCE = new DiscoveryDataStoreKeys();
        private static final Preferences.Key<Integer> variableDeclarationKey = PreferencesKeys.intKey("variable_declaration_key");

        private DiscoveryDataStoreKeys() {
        }

        public final Preferences.Key<Integer> getVariableDeclarationKey() {
            return variableDeclarationKey;
        }
    }
}
