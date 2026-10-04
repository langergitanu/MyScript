package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ExpressionType;
import aws.sdk.kotlin.services.p010s3.model.InputSerialization;
import aws.sdk.kotlin.services.p010s3.model.OutputSerialization;
import aws.sdk.kotlin.services.p010s3.model.RequestProgress;
import aws.sdk.kotlin.services.p010s3.model.ScanRange;
import aws.sdk.kotlin.services.p010s3.model.SelectObjectContentRequest;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: SelectObjectContentOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, m1599d2 = {"serializeSelectObjectContentOperationBody", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SelectObjectContentOperationSerializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] serializeSelectObjectContentOperationBody(ExecutionContext executionContext, SelectObjectContentRequest selectObjectContentRequest) {
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("Expression"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("ExpressionType"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("InputSerialization"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("OutputSerialization"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("RequestProgress"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("ScanRange"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("SelectObjectContentRequest"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        String expression = selectObjectContentRequest.getExpression();
        if (expression != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, expression);
        }
        ExpressionType expressionType = selectObjectContentRequest.getExpressionType();
        if (expressionType != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, expressionType.getValue());
        }
        InputSerialization inputSerialization = selectObjectContentRequest.getInputSerialization();
        if (inputSerialization != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, inputSerialization, C3603xc9ad54f4.INSTANCE);
        }
        OutputSerialization outputSerialization = selectObjectContentRequest.getOutputSerialization();
        if (outputSerialization != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor4, outputSerialization, C3604xc9ad58b5.INSTANCE);
        }
        RequestProgress requestProgress = selectObjectContentRequest.getRequestProgress();
        if (requestProgress != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor5, requestProgress, C3605xc9ad5c76.INSTANCE);
        }
        ScanRange scanRange = selectObjectContentRequest.getScanRange();
        if (scanRange != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor6, scanRange, C3606xc9ad6037.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}
