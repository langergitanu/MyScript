package aws.sdk.kotlin.runtime.config.profile;

import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AwsConfigLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt$loadAwsSharedConfig$2$1", m1609f = "AwsConfigLoader.kt", m1610i = {}, m1611l = {45, 50}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {42, 47}, m1615s = {}, m1616v = 2)
final class AwsConfigLoaderKt$loadAwsSharedConfig$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AwsSharedConfig>, Object> {
    final /* synthetic */ Logger $logger;
    final /* synthetic */ PlatformProvider $platform;
    final /* synthetic */ AwsConfigurationSource $source;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AwsConfigLoaderKt$loadAwsSharedConfig$2$1(Logger logger, PlatformProvider platformProvider, AwsConfigurationSource awsConfigurationSource, Continuation<? super AwsConfigLoaderKt$loadAwsSharedConfig$2$1> continuation) {
        super(2, continuation);
        this.$logger = logger;
        this.$platform = platformProvider;
        this.$source = awsConfigurationSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AwsConfigLoaderKt$loadAwsSharedConfig$2$1(this.$logger, this.$platform, this.$source, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AwsSharedConfig> continuation) {
        return ((AwsConfigLoaderKt$loadAwsSharedConfig$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Map[] mapArr;
        Logger logger;
        FileType fileType;
        Map[] mapArr2;
        int i;
        Logger logger2;
        FileType fileType2;
        Map[] mapArr3;
        Map[] mapArr4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mapArr = new Map[2];
            logger = this.$logger;
            fileType = FileType.CONFIGURATION;
            this.L$0 = mapArr;
            this.L$1 = mapArr;
            this.L$2 = logger;
            this.L$3 = fileType;
            this.I$0 = 0;
            this.label = 1;
            obj = this.$platform.readFileOrNull(this.$source.getConfigPath(), this);
            if (obj != coroutine_suspended) {
                mapArr2 = mapArr;
                i = 0;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = this.I$0;
            fileType2 = (FileType) this.L$3;
            logger2 = (Logger) this.L$2;
            mapArr3 = (Map[]) this.L$1;
            mapArr4 = (Map[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            byte[] bArr = (byte[]) obj;
            mapArr3[i3] = AwsConfigParserKt.parse(logger2, fileType2, bArr != null ? StringsKt.decodeToString(bArr) : null);
            return AwsConfigParserKt.toSharedConfig(AwsConfigLoaderKt.mergeFiles(mapArr4), this.$source);
        }
        i = this.I$0;
        fileType = (FileType) this.L$3;
        logger = (Logger) this.L$2;
        Map[] mapArr5 = (Map[]) this.L$1;
        Map[] mapArr6 = (Map[]) this.L$0;
        ResultKt.throwOnFailure(obj);
        mapArr2 = mapArr5;
        mapArr = mapArr6;
        byte[] bArr2 = (byte[]) obj;
        mapArr2[i] = AwsConfigParserKt.parse(logger, fileType, bArr2 != null ? StringsKt.decodeToString(bArr2) : null);
        logger2 = this.$logger;
        FileType fileType3 = FileType.CREDENTIAL;
        this.L$0 = mapArr;
        this.L$1 = mapArr;
        this.L$2 = logger2;
        this.L$3 = fileType3;
        this.I$0 = 1;
        this.label = 2;
        Object fileOrNull = this.$platform.readFileOrNull(this.$source.getCredentialsPath(), this);
        if (fileOrNull != coroutine_suspended) {
            fileType2 = fileType3;
            obj = fileOrNull;
            mapArr3 = mapArr;
            mapArr4 = mapArr3;
            byte[] bArr3 = (byte[]) obj;
            mapArr3[i3] = AwsConfigParserKt.parse(logger2, fileType2, bArr3 != null ? StringsKt.decodeToString(bArr3) : null);
            return AwsConfigParserKt.toSharedConfig(AwsConfigLoaderKt.mergeFiles(mapArr4), this.$source);
        }
        return coroutine_suspended;
    }
}
