package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.SharingPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class PaperDocSharingPolicy extends RefPaperDoc {

    @Nonnull
    protected final SharingPolicy sharingPolicy;

    public PaperDocSharingPolicy(@Nonnull String str, @Nonnull SharingPolicy sharingPolicy) {
        super(str);
        if (sharingPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharingPolicy' is null");
        }
        this.sharingPolicy = sharingPolicy;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    @Nonnull
    public SharingPolicy getSharingPolicy() {
        return this.sharingPolicy;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.sharingPolicy});
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public boolean equals(Object obj) {
        SharingPolicy sharingPolicy;
        SharingPolicy sharingPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperDocSharingPolicy paperDocSharingPolicy = (PaperDocSharingPolicy) obj;
        return (this.docId == paperDocSharingPolicy.docId || this.docId.equals(paperDocSharingPolicy.docId)) && ((sharingPolicy = this.sharingPolicy) == (sharingPolicy2 = paperDocSharingPolicy.sharingPolicy) || sharingPolicy.equals(sharingPolicy2));
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocSharingPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocSharingPolicy paperDocSharingPolicy, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(paperDocSharingPolicy.docId, jsonGenerator);
            jsonGenerator.writeFieldName("sharing_policy");
            SharingPolicy.Serializer.INSTANCE.serialize(paperDocSharingPolicy.sharingPolicy, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocSharingPolicy deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharingPolicy sharingPolicyDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sharing_policy".equals(currentName)) {
                        sharingPolicyDeserialize = SharingPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                if (sharingPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sharing_policy\" missing.");
                }
                PaperDocSharingPolicy paperDocSharingPolicy = new PaperDocSharingPolicy(strDeserialize, sharingPolicyDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocSharingPolicy, paperDocSharingPolicy.toStringMultiline());
                return paperDocSharingPolicy;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
