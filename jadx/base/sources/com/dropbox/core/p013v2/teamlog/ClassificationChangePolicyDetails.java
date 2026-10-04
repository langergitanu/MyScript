package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ClassificationPolicyEnumWrapper;
import com.dropbox.core.p013v2.teamlog.ClassificationType;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class ClassificationChangePolicyDetails {

    @Nonnull
    protected final ClassificationType classificationType;

    @Nonnull
    protected final ClassificationPolicyEnumWrapper newValue;

    @Nonnull
    protected final ClassificationPolicyEnumWrapper previousValue;

    public ClassificationChangePolicyDetails(@Nonnull ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper, @Nonnull ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper2, @Nonnull ClassificationType classificationType) {
        if (classificationPolicyEnumWrapper == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = classificationPolicyEnumWrapper;
        if (classificationPolicyEnumWrapper2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = classificationPolicyEnumWrapper2;
        if (classificationType == null) {
            throw new IllegalArgumentException("Required value for 'classificationType' is null");
        }
        this.classificationType = classificationType;
    }

    @Nonnull
    public ClassificationPolicyEnumWrapper getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public ClassificationPolicyEnumWrapper getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ClassificationType getClassificationType() {
        return this.classificationType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue, this.classificationType});
    }

    public boolean equals(Object obj) {
        ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper;
        ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper2;
        ClassificationType classificationType;
        ClassificationType classificationType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ClassificationChangePolicyDetails classificationChangePolicyDetails = (ClassificationChangePolicyDetails) obj;
        ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper3 = this.previousValue;
        ClassificationPolicyEnumWrapper classificationPolicyEnumWrapper4 = classificationChangePolicyDetails.previousValue;
        return (classificationPolicyEnumWrapper3 == classificationPolicyEnumWrapper4 || classificationPolicyEnumWrapper3.equals(classificationPolicyEnumWrapper4)) && ((classificationPolicyEnumWrapper = this.newValue) == (classificationPolicyEnumWrapper2 = classificationChangePolicyDetails.newValue) || classificationPolicyEnumWrapper.equals(classificationPolicyEnumWrapper2)) && ((classificationType = this.classificationType) == (classificationType2 = classificationChangePolicyDetails.classificationType) || classificationType.equals(classificationType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ClassificationChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ClassificationChangePolicyDetails classificationChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            ClassificationPolicyEnumWrapper.Serializer.INSTANCE.serialize(classificationChangePolicyDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            ClassificationPolicyEnumWrapper.Serializer.INSTANCE.serialize(classificationChangePolicyDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("classification_type");
            ClassificationType.Serializer.INSTANCE.serialize(classificationChangePolicyDetails.classificationType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ClassificationChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ClassificationPolicyEnumWrapper classificationPolicyEnumWrapperDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ClassificationPolicyEnumWrapper classificationPolicyEnumWrapperDeserialize2 = null;
                ClassificationType classificationTypeDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        classificationPolicyEnumWrapperDeserialize = ClassificationPolicyEnumWrapper.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        classificationPolicyEnumWrapperDeserialize2 = ClassificationPolicyEnumWrapper.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("classification_type".equals(currentName)) {
                        classificationTypeDeserialize = ClassificationType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (classificationPolicyEnumWrapperDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (classificationPolicyEnumWrapperDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (classificationTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"classification_type\" missing.");
                }
                ClassificationChangePolicyDetails classificationChangePolicyDetails = new ClassificationChangePolicyDetails(classificationPolicyEnumWrapperDeserialize, classificationPolicyEnumWrapperDeserialize2, classificationTypeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(classificationChangePolicyDetails, classificationChangePolicyDetails.toStringMultiline());
                return classificationChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
