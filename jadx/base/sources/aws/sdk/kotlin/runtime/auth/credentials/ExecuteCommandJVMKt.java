package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.OsFamily;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.yalantis.ucrop.UCrop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlin.p039io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: executeCommandJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0002\u0010\f¨\u0006\r"}, m1599d2 = {"executeCommand", "Lkotlin/Pair;", "", "", "command", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "maxOutputLengthBytes", "", "timeoutMillis", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;JJLaws/smithy/kotlin/runtime/time/Clock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExecuteCommandJVMKt {

    /* JADX INFO: compiled from: executeCommandJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OsFamily.values().length];
            try {
                iArr[OsFamily.Windows.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ Object executeCommand$default(String str, PlatformProvider platformProvider, long j, long j2, Clock clock, Continuation continuation, int i, Object obj) {
        if ((i & 16) != 0) {
            clock = Clock.System.INSTANCE;
        }
        return executeCommand(str, platformProvider, j, j2, clock, continuation);
    }

    public static final Object executeCommand(String str, PlatformProvider platformProvider, long j, long j2, Clock clock, Continuation<? super Pair<Integer, String>> continuation) {
        ArrayList arrayList = new ArrayList();
        if (WhenMappings.$EnumSwitchMapping$0[platformProvider.getOs().getFamily().ordinal()] == 1) {
            arrayList.add("cmd.exe");
            arrayList.add("/C");
        } else {
            arrayList.add("sh");
            arrayList.add("-c");
        }
        arrayList.add(str);
        return BuildersKt.withContext(Dispatchers.getIO(), new C30072(arrayList, j2, j, null), continuation);
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ExecuteCommandJVMKt$executeCommand$2 */
    /* JADX INFO: compiled from: executeCommandJVM.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, m1599d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ExecuteCommandJVMKt$executeCommand$2", m1609f = "executeCommandJVM.kt", m1610i = {0, 0, 0, 0}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m1612m = "invokeSuspend", m1613n = {"process", "reader", "output", "buffer"}, m1614nl = {UCrop.REQUEST_CROP}, m1615s = {"L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
    static final class C30072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends String>>, Object> {
        final /* synthetic */ ArrayList<String> $cmd;
        final /* synthetic */ long $maxOutputLengthBytes;
        final /* synthetic */ long $timeoutMillis;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30072(ArrayList<String> arrayList, long j, long j2, Continuation<? super C30072> continuation) {
            super(2, continuation);
            this.$cmd = arrayList;
            this.$timeoutMillis = j;
            this.$maxOutputLengthBytes = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30072(this.$cmd, this.$timeoutMillis, this.$maxOutputLengthBytes, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<Integer, String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, String>> continuation) {
            return ((C30072) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            BufferedReader bufferedReader;
            StringBuilder sb;
            Process process;
            String text;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Process processStart = new ProcessBuilder(new String[0]).command(this.$cmd).start();
                InputStream inputStream = processStart.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader2 = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                StringBuilder sb2 = new StringBuilder();
                char[] cArr = new char[1024];
                this.L$0 = processStart;
                this.L$1 = bufferedReader2;
                this.L$2 = sb2;
                this.L$3 = SpillingKt.nullOutSpilledVariable(cArr);
                this.label = 1;
                if (TimeoutKt.withTimeout(this.$timeoutMillis, new AnonymousClass1(bufferedReader2, cArr, sb2, this.$maxOutputLengthBytes, processStart, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bufferedReader = bufferedReader2;
                sb = sb2;
                process = processStart;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sb = (StringBuilder) this.L$2;
                bufferedReader = (BufferedReader) this.L$1;
                process = (Process) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            bufferedReader.close();
            if (process.exitValue() == 0) {
                text = sb.toString();
            } else {
                InputStream errorStream = process.getErrorStream();
                Intrinsics.checkNotNullExpressionValue(errorStream, "getErrorStream(...)");
                Reader inputStreamReader2 = new InputStreamReader(errorStream, Charsets.UTF_8);
                BufferedReader bufferedReader3 = inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192);
                try {
                    text = TextStreamsKt.readText(bufferedReader3);
                    CloseableKt.closeFinally(bufferedReader3, null);
                } finally {
                }
            }
            Intrinsics.checkNotNull(text);
            return TuplesKt.m1606to(Boxing.boxInt(process.exitValue()), text);
        }

        /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ExecuteCommandJVMKt$executeCommand$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: executeCommandJVM.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ExecuteCommandJVMKt$executeCommand$2$1", m1609f = "executeCommandJVM.kt", m1610i = {}, m1611l = {65}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {67}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
            final /* synthetic */ char[] $buffer;
            final /* synthetic */ long $maxOutputLengthBytes;
            final /* synthetic */ StringBuilder $output;
            final /* synthetic */ Process $process;
            final /* synthetic */ BufferedReader $reader;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, long j, Process process, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$reader = bufferedReader;
                this.$buffer = cArr;
                this.$output = sb;
                this.$maxOutputLengthBytes = j;
                this.$process = process;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$reader, this.$buffer, this.$output, this.$maxOutputLengthBytes, this.$process, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                while (this.$reader.read(this.$buffer) != -1) {
                    this.$output.append(this.$buffer);
                    if (this.$output.length() > this.$maxOutputLengthBytes) {
                        throw new CredentialsProviderException("Process output exceeded limit of " + this.$maxOutputLengthBytes + " bytes", null, 2, null);
                    }
                }
                this.label = 1;
                Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C91881(this.$process, null), this);
                return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
            }

            /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ExecuteCommandJVMKt$executeCommand$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: executeCommandJVM.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ExecuteCommandJVMKt$executeCommand$2$1$1", m1609f = "executeCommandJVM.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
            static final class C91881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
                final /* synthetic */ Process $process;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C91881(Process process, Continuation<? super C91881> continuation) {
                    super(2, continuation);
                    this.$process = process;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C91881(this.$process, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
                    return ((C91881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxInt(this.$process.waitFor());
                }
            }
        }
    }
}
