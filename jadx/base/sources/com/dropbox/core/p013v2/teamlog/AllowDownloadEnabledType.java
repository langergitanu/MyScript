package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class AllowDownloadEnabledType {

    @Nonnull
    protected final String description;

    public AllowDownloadEnabledType(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'description' is null");
        }
        this.description = str;
    }

    @Nonnull
    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.description});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.description;
        String str2 = ((AllowDownloadEnabledType) obj).description;
        return str == str2 || str.equals(str2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AllowDownloadEnabledType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        /*  JADX ERROR: ConcurrentModificationException in pass: MethodInvokeVisitor
            java.util.ConcurrentModificationException
            	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
            	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
            	at jadx.core.utils.Utils.collectionMap(Utils.java:252)
            	at jadx.core.dex.nodes.MethodNode.getThrows(MethodNode.java:490)
            	at jadx.core.dex.visitors.methods.MutableMethodDetails.<init>(MutableMethodDetails.java:25)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.resolveTypeVars(MethodInvokeVisitor.java:250)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:113)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:98)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.lambda$visit$0(MethodInvokeVisitor.java:73)
            	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:301)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:71)
            */
        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(com.dropbox.core.p013v2.teamlog.AllowDownloadEnabledType r2, com.fasterxml.jackson.core.JsonGenerator r3, boolean r4) throws java.io.IOException {
            /*
                r1 = this;
                if (r4 != 0) goto L5
                r3.writeStartObject()
            L5:
                java.lang.String r0 = "description"
                r3.writeFieldName(r0)
                com.dropbox.core.stone.StoneSerializer r0 = com.dropbox.core.stone.StoneSerializers.string()
                java.lang.String r2 = r2.description
                r0.serialize(r2, r3)
                if (r4 != 0) goto L18
                r3.writeEndObject()
            L18:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dropbox.core.v2.teamlog.AllowDownloadEnabledType.Serializer.serialize(com.dropbox.core.v2.teamlog.AllowDownloadEnabledType, com.fasterxml.jackson.core.JsonGenerator, boolean):void");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AllowDownloadEnabledType deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
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
                    if ("description".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"description\" missing.");
                }
                AllowDownloadEnabledType allowDownloadEnabledType = new AllowDownloadEnabledType(strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(allowDownloadEnabledType, allowDownloadEnabledType.toStringMultiline());
                return allowDownloadEnabledType;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
