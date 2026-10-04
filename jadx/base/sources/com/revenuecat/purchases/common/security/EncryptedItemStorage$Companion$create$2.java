package com.revenuecat.purchases.common.security;

import com.revenuecat.purchases.common.security.EncryptedItemStorage;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EncryptedItemStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/revenuecat/purchases/common/security/EncryptedItemStorage$Partition;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.security.EncryptedItemStorage$Companion$create$2", m1609f = "EncryptedItemStorage.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class EncryptedItemStorage$Companion$create$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends EncryptedItemStorage.Partition, ? extends EncryptedItemStorage.Partition>>, Object> {
    final /* synthetic */ File $backupFile;
    final /* synthetic */ File $noBackupFile;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EncryptedItemStorage$Companion$create$2(File file, File file2, Continuation<? super EncryptedItemStorage$Companion$create$2> continuation) {
        super(2, continuation);
        this.$backupFile = file;
        this.$noBackupFile = file2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EncryptedItemStorage$Companion$create$2(this.$backupFile, this.$noBackupFile, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends EncryptedItemStorage.Partition, ? extends EncryptedItemStorage.Partition>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<EncryptedItemStorage.Partition, EncryptedItemStorage.Partition>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<EncryptedItemStorage.Partition, EncryptedItemStorage.Partition>> continuation) {
        return ((EncryptedItemStorage$Companion$create$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return TuplesKt.m1606to(new EncryptedItemStorage.Partition(this.$backupFile, EncryptedItemStorage.INSTANCE.loadStore$purchases_defaultsRelease(this.$backupFile)), new EncryptedItemStorage.Partition(this.$noBackupFile, EncryptedItemStorage.INSTANCE.loadStore$purchases_defaultsRelease(this.$noBackupFile)));
    }
}
