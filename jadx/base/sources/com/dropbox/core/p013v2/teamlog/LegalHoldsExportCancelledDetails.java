package com.dropbox.core.p013v2.teamlog;

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

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsExportCancelledDetails {

    @Nonnull
    protected final String exportName;

    @Nonnull
    protected final String legalHoldId;

    @Nonnull
    protected final String name;

    public LegalHoldsExportCancelledDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'exportName' is null");
        }
        this.exportName = str3;
    }

    @Nonnull
    public String getLegalHoldId() {
        return this.legalHoldId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getExportName() {
        return this.exportName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.legalHoldId, this.name, this.exportName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsExportCancelledDetails legalHoldsExportCancelledDetails = (LegalHoldsExportCancelledDetails) obj;
        String str5 = this.legalHoldId;
        String str6 = legalHoldsExportCancelledDetails.legalHoldId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = legalHoldsExportCancelledDetails.name) || str.equals(str2)) && ((str3 = this.exportName) == (str4 = legalHoldsExportCancelledDetails.exportName) || str3.equals(str4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: MethodInvokeVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
        	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
        	at jadx.core.utils.Utils.collectionMap(Utils.java:252)
        	at jadx.core.dex.nodes.MethodNode.getThrows(MethodNode.java:490)
        	at jadx.core.dex.visitors.methods.MutableMethodDetails.<init>(MutableMethodDetails.java:25)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.resolveTypeVars(MethodInvokeVisitor.java:250)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:116)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:98)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.lambda$visit$0(MethodInvokeVisitor.java:73)
        	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:301)
        	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:304)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:71)
        */
    public java.lang.String toStringMultiline() {
        /*
            r2 = this;
            com.dropbox.core.v2.teamlog.LegalHoldsExportCancelledDetails$Serializer r0 = com.dropbox.core.v2.teamlog.LegalHoldsExportCancelledDetails.Serializer.INSTANCE
            r1 = 1
            java.lang.String r0 = r0.serialize(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dropbox.core.p013v2.teamlog.LegalHoldsExportCancelledDetails.toStringMultiline():java.lang.String");
    }

    static class Serializer extends StructSerializer<LegalHoldsExportCancelledDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsExportCancelledDetails legalHoldsExportCancelledDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(legalHoldsExportCancelledDetails.legalHoldId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsExportCancelledDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("export_name");
            StoneSerializers.string().serialize(legalHoldsExportCancelledDetails.exportName, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsExportCancelledDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("legal_hold_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("export_name".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"legal_hold_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"export_name\" missing.");
                }
                LegalHoldsExportCancelledDetails legalHoldsExportCancelledDetails = new LegalHoldsExportCancelledDetails(strDeserialize, strDeserialize2, strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsExportCancelledDetails, legalHoldsExportCancelledDetails.toStringMultiline());
                return legalHoldsExportCancelledDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
