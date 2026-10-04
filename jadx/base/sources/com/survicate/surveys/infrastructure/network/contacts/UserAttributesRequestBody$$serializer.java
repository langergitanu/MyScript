package com.survicate.surveys.infrastructure.network.contacts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: UserAttributesRequestBody.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class UserAttributesRequestBody$$serializer implements GeneratedSerializer<UserAttributesRequestBody> {
    public static final UserAttributesRequestBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private UserAttributesRequestBody$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        UserAttributesRequestBody$$serializer userAttributesRequestBody$$serializer = new UserAttributesRequestBody$$serializer();
        INSTANCE = userAttributesRequestBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.infrastructure.network.contacts.UserAttributesRequestBody", userAttributesRequestBody$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("user", false);
        pluginGeneratedSerialDescriptor.addElement("respondent", false);
        pluginGeneratedSerialDescriptor.addElement("attributes", false);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.TAG_METADATA, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ContactsApiModels$User$$serializer.INSTANCE, ContactsApiModels$Respondent$$serializer.INSTANCE, UserAttributesRequestBody.$childSerializers[2].getValue(), ContactsApiModels$Metadata$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final UserAttributesRequestBody deserialize(Decoder decoder) {
        int i;
        ContactsApiModels.User user;
        ContactsApiModels.Respondent respondent;
        List list;
        ContactsApiModels.Metadata metadata;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = UserAttributesRequestBody.$childSerializers;
        ContactsApiModels.User user2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ContactsApiModels.User user3 = (ContactsApiModels.User) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ContactsApiModels$User$$serializer.INSTANCE, null);
            ContactsApiModels.Respondent respondent2 = (ContactsApiModels.Respondent) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ContactsApiModels$Respondent$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            user = user3;
            metadata = (ContactsApiModels.Metadata) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, ContactsApiModels$Metadata$$serializer.INSTANCE, null);
            i = 15;
            respondent = respondent2;
        } else {
            boolean z = true;
            int i2 = 0;
            ContactsApiModels.Respondent respondent3 = null;
            List list2 = null;
            ContactsApiModels.Metadata metadata2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    user2 = (ContactsApiModels.User) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ContactsApiModels$User$$serializer.INSTANCE, user2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    respondent3 = (ContactsApiModels.Respondent) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ContactsApiModels$Respondent$$serializer.INSTANCE, respondent3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    metadata2 = (ContactsApiModels.Metadata) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, ContactsApiModels$Metadata$$serializer.INSTANCE, metadata2);
                    i2 |= 8;
                }
            }
            i = i2;
            user = user2;
            respondent = respondent3;
            list = list2;
            metadata = metadata2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new UserAttributesRequestBody(i, user, respondent, list, metadata, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, UserAttributesRequestBody value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        UserAttributesRequestBody.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
