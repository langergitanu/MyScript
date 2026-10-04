package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AlphaResolvedVisibility;
import com.dropbox.core.p013v2.sharing.RequestedVisibility;
import com.dropbox.core.p013v2.sharing.VisibilityPolicyDisallowedReason;
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
public class VisibilityPolicy {
    protected final boolean allowed;

    @Nullable
    protected final VisibilityPolicyDisallowedReason disallowedReason;

    @Nonnull
    protected final RequestedVisibility policy;

    @Nonnull
    protected final AlphaResolvedVisibility resolvedPolicy;

    public VisibilityPolicy(@Nonnull RequestedVisibility requestedVisibility, @Nonnull AlphaResolvedVisibility alphaResolvedVisibility, boolean z, @Nullable VisibilityPolicyDisallowedReason visibilityPolicyDisallowedReason) {
        if (requestedVisibility == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = requestedVisibility;
        if (alphaResolvedVisibility == null) {
            throw new IllegalArgumentException("Required value for 'resolvedPolicy' is null");
        }
        this.resolvedPolicy = alphaResolvedVisibility;
        this.allowed = z;
        this.disallowedReason = visibilityPolicyDisallowedReason;
    }

    public VisibilityPolicy(@Nonnull RequestedVisibility requestedVisibility, @Nonnull AlphaResolvedVisibility alphaResolvedVisibility, boolean z) {
        this(requestedVisibility, alphaResolvedVisibility, z, null);
    }

    @Nonnull
    public RequestedVisibility getPolicy() {
        return this.policy;
    }

    @Nonnull
    public AlphaResolvedVisibility getResolvedPolicy() {
        return this.resolvedPolicy;
    }

    public boolean getAllowed() {
        return this.allowed;
    }

    @Nullable
    public VisibilityPolicyDisallowedReason getDisallowedReason() {
        return this.disallowedReason;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.policy, this.resolvedPolicy, Boolean.valueOf(this.allowed), this.disallowedReason});
    }

    public boolean equals(Object obj) {
        VisibilityPolicy visibilityPolicy;
        RequestedVisibility requestedVisibility;
        RequestedVisibility requestedVisibility2;
        AlphaResolvedVisibility alphaResolvedVisibility;
        AlphaResolvedVisibility alphaResolvedVisibility2;
        VisibilityPolicyDisallowedReason visibilityPolicyDisallowedReason;
        VisibilityPolicyDisallowedReason visibilityPolicyDisallowedReason2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((requestedVisibility = this.policy) == (requestedVisibility2 = (visibilityPolicy = (VisibilityPolicy) obj).policy) || requestedVisibility.equals(requestedVisibility2)) && (((alphaResolvedVisibility = this.resolvedPolicy) == (alphaResolvedVisibility2 = visibilityPolicy.resolvedPolicy) || alphaResolvedVisibility.equals(alphaResolvedVisibility2)) && this.allowed == visibilityPolicy.allowed && ((visibilityPolicyDisallowedReason = this.disallowedReason) == (visibilityPolicyDisallowedReason2 = visibilityPolicy.disallowedReason) || (visibilityPolicyDisallowedReason != null && visibilityPolicyDisallowedReason.equals(visibilityPolicyDisallowedReason2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<VisibilityPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(VisibilityPolicy visibilityPolicy, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("policy");
            RequestedVisibility.Serializer.INSTANCE.serialize(visibilityPolicy.policy, jsonGenerator);
            jsonGenerator.writeFieldName("resolved_policy");
            AlphaResolvedVisibility.Serializer.INSTANCE.serialize(visibilityPolicy.resolvedPolicy, jsonGenerator);
            jsonGenerator.writeFieldName("allowed");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(visibilityPolicy.allowed), jsonGenerator);
            if (visibilityPolicy.disallowedReason != null) {
                jsonGenerator.writeFieldName("disallowed_reason");
                StoneSerializers.nullable(VisibilityPolicyDisallowedReason.Serializer.INSTANCE).serialize(visibilityPolicy.disallowedReason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public VisibilityPolicy deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            RequestedVisibility requestedVisibilityDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AlphaResolvedVisibility alphaResolvedVisibilityDeserialize = null;
                Boolean boolDeserialize = null;
                VisibilityPolicyDisallowedReason visibilityPolicyDisallowedReason = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("policy".equals(currentName)) {
                        requestedVisibilityDeserialize = RequestedVisibility.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("resolved_policy".equals(currentName)) {
                        alphaResolvedVisibilityDeserialize = AlphaResolvedVisibility.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("allowed".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("disallowed_reason".equals(currentName)) {
                        visibilityPolicyDisallowedReason = (VisibilityPolicyDisallowedReason) StoneSerializers.nullable(VisibilityPolicyDisallowedReason.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (requestedVisibilityDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"policy\" missing.");
                }
                if (alphaResolvedVisibilityDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"resolved_policy\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allowed\" missing.");
                }
                VisibilityPolicy visibilityPolicy = new VisibilityPolicy(requestedVisibilityDeserialize, alphaResolvedVisibilityDeserialize, boolDeserialize.booleanValue(), visibilityPolicyDisallowedReason);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(visibilityPolicy, visibilityPolicy.toStringMultiline());
                return visibilityPolicy;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
