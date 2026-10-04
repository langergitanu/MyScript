package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Message.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0002\u001a!\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"MESSAGE_CRC_BYTE_LEN", "", "MAX_MESSAGE_SIZE", "MAX_HEADER_SIZE", "emptyByteArray", "", "buildMessage", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageBuilder;", "", "Lkotlin/ExtensionFunctionType;", "aws-event-stream"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MessageKt {
    public static final int MAX_HEADER_SIZE = 131072;
    public static final int MAX_MESSAGE_SIZE = 25165824;
    public static final int MESSAGE_CRC_BYTE_LEN = 4;

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] emptyByteArray() {
        return new byte[0];
    }

    @InternalApi
    public static final Message buildMessage(Function1<? super MessageBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MessageBuilder messageBuilder = new MessageBuilder();
        block.invoke(messageBuilder);
        return messageBuilder.build();
    }
}
