package aws.smithy.kotlin.runtime.auth.awssigning;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultAwsSignerJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"DefaultAwsSigner", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "getDefaultAwsSigner", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/auth/awssigning/DefaultAwsSignerBuilder;", "", "Lkotlin/ExtensionFunctionType;", "signatureCalculator", "Laws/smithy/kotlin/runtime/auth/awssigning/BaseSigV4SignatureCalculator;", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "getSignatureCalculator", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;)Laws/smithy/kotlin/runtime/auth/awssigning/BaseSigV4SignatureCalculator;", "aws-signing-default"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultAwsSignerJVMKt {
    private static final AwsSigner DefaultAwsSigner = new DefaultAwsSignerImpl(null, null, null, 7, null);

    /* JADX INFO: compiled from: DefaultAwsSignerJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AwsSigningAlgorithm.values().length];
            try {
                iArr[AwsSigningAlgorithm.SIGV4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AwsSigningAlgorithm.SIGV4_ASYMMETRIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final AwsSigner getDefaultAwsSigner() {
        return DefaultAwsSigner;
    }

    public static final AwsSigner DefaultAwsSigner(Function1<? super DefaultAwsSignerBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DefaultAwsSignerBuilder defaultAwsSignerBuilder = new DefaultAwsSignerBuilder();
        block.invoke(defaultAwsSignerBuilder);
        return defaultAwsSignerBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSigV4SignatureCalculator getSignatureCalculator(AwsSigningAlgorithm awsSigningAlgorithm) {
        int i = WhenMappings.$EnumSwitchMapping$0[awsSigningAlgorithm.ordinal()];
        if (i == 1) {
            return SignatureCalculator.INSTANCE.getSigV4();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return SignatureCalculator.INSTANCE.getSigV4a();
    }
}
