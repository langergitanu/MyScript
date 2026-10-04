package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.LabelType;
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
public class ObjectLabelAddedDetails {

    @Nonnull
    protected final LabelType labelType;

    public ObjectLabelAddedDetails(@Nonnull LabelType labelType) {
        if (labelType == null) {
            throw new IllegalArgumentException("Required value for 'labelType' is null");
        }
        this.labelType = labelType;
    }

    @Nonnull
    public LabelType getLabelType() {
        return this.labelType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.labelType});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LabelType labelType = this.labelType;
        LabelType labelType2 = ((ObjectLabelAddedDetails) obj).labelType;
        return labelType == labelType2 || labelType.equals(labelType2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ObjectLabelAddedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ObjectLabelAddedDetails objectLabelAddedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("label_type");
            LabelType.Serializer.INSTANCE.serialize(objectLabelAddedDetails.labelType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to analyze thrown exceptions
        java.util.ConcurrentModificationException
        	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
        	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.mergeExceptions(MethodThrowsVisitor.java:100)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:86)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
         */
        @Override // com.dropbox.core.stone.StructSerializer
        public ObjectLabelAddedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            LabelType labelTypeDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("label_type".equals(currentName)) {
                        labelTypeDeserialize = LabelType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (labelTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"label_type\" missing.");
                }
                ObjectLabelAddedDetails objectLabelAddedDetails = new ObjectLabelAddedDetails(labelTypeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(objectLabelAddedDetails, objectLabelAddedDetails.toStringMultiline());
                return objectLabelAddedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
