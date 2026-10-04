package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.MemberAction;
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
public class MemberPermission {

    @Nonnull
    protected final MemberAction action;
    protected final boolean allow;

    @Nullable
    protected final PermissionDeniedReason reason;

    public MemberPermission(@Nonnull MemberAction memberAction, boolean z, @Nullable PermissionDeniedReason permissionDeniedReason) {
        if (memberAction == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = memberAction;
        this.allow = z;
        this.reason = permissionDeniedReason;
    }

    public MemberPermission(@Nonnull MemberAction memberAction, boolean z) {
        this(memberAction, z, null);
    }

    @Nonnull
    public MemberAction getAction() {
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
        MemberPermission memberPermission;
        MemberAction memberAction;
        MemberAction memberAction2;
        PermissionDeniedReason permissionDeniedReason;
        PermissionDeniedReason permissionDeniedReason2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((memberAction = this.action) == (memberAction2 = (memberPermission = (MemberPermission) obj).action) || memberAction.equals(memberAction2)) && this.allow == memberPermission.allow && ((permissionDeniedReason = this.reason) == (permissionDeniedReason2 = memberPermission.reason) || (permissionDeniedReason != null && permissionDeniedReason.equals(permissionDeniedReason2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberPermission> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberPermission memberPermission, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("action");
            MemberAction.Serializer.INSTANCE.serialize(memberPermission.action, jsonGenerator);
            jsonGenerator.writeFieldName("allow");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(memberPermission.allow), jsonGenerator);
            if (memberPermission.reason != null) {
                jsonGenerator.writeFieldName("reason");
                StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).serialize(memberPermission.reason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberPermission deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberAction memberActionDeserialize = null;
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
                        memberActionDeserialize = MemberAction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("allow".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("reason".equals(currentName)) {
                        permissionDeniedReason = (PermissionDeniedReason) StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberActionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"action\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allow\" missing.");
                }
                MemberPermission memberPermission = new MemberPermission(memberActionDeserialize, boolDeserialize.booleanValue(), permissionDeniedReason);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberPermission, memberPermission.toStringMultiline());
                return memberPermission;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
