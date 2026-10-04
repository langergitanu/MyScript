package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkAction;
import com.dropbox.core.p013v2.sharing.PermissionDeniedReason;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class LinkPermission {

    @Nonnull
    protected final LinkAction action;
    protected final boolean allow;

    @Nullable
    protected final PermissionDeniedReason reason;

    public LinkPermission(@Nonnull LinkAction linkAction, boolean z, @Nullable PermissionDeniedReason permissionDeniedReason) {
        if (linkAction == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = linkAction;
        this.allow = z;
        this.reason = permissionDeniedReason;
    }

    public LinkPermission(@Nonnull LinkAction linkAction, boolean z) {
        this(linkAction, z, null);
    }

    @Nonnull
    public LinkAction getAction() {
        return this.action;
    }

    public boolean getAllow() {
        return this.allow;
    }

    @Nullable
    public PermissionDeniedReason getReason() {
        return this.reason;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.action, Boolean.valueOf(this.allow), this.reason});
    }

    public boolean equals(Object obj) {
        LinkPermission linkPermission;
        LinkAction linkAction;
        LinkAction linkAction2;
        PermissionDeniedReason permissionDeniedReason;
        PermissionDeniedReason permissionDeniedReason2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((linkAction = this.action) == (linkAction2 = (linkPermission = (LinkPermission) obj).action) || linkAction.equals(linkAction2)) && this.allow == linkPermission.allow && ((permissionDeniedReason = this.reason) == (permissionDeniedReason2 = linkPermission.reason) || (permissionDeniedReason != null && permissionDeniedReason.equals(permissionDeniedReason2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LinkPermission> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LinkPermission linkPermission, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("action");
            LinkAction.Serializer.INSTANCE.serialize(linkPermission.action, jsonGenerator);
            jsonGenerator.writeFieldName("allow");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermission.allow), jsonGenerator);
            if (linkPermission.reason != null) {
                jsonGenerator.writeFieldName("reason");
                StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).serialize(linkPermission.reason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LinkPermission deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            LinkAction linkActionDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                PermissionDeniedReason permissionDeniedReason = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("action".equals(currentName)) {
                        linkActionDeserialize = LinkAction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("allow".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("reason".equals(currentName)) {
                        permissionDeniedReason = (PermissionDeniedReason) StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (linkActionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"action\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allow\" missing.");
                }
                LinkPermission linkPermission = new LinkPermission(linkActionDeserialize, boolDeserialize.booleanValue(), permissionDeniedReason);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(linkPermission, linkPermission.toStringMultiline());
                return linkPermission;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
