package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TfaConfiguration;
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

/* JADX INFO: loaded from: classes5.dex */
public class TfaChangeStatusDetails {

    @Nonnull
    protected final TfaConfiguration newValue;

    @Nullable
    protected final TfaConfiguration previousValue;

    @Nullable
    protected final Boolean usedRescueCode;

    public TfaChangeStatusDetails(@Nonnull TfaConfiguration tfaConfiguration, @Nullable TfaConfiguration tfaConfiguration2, @Nullable Boolean bool) {
        if (tfaConfiguration == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = tfaConfiguration;
        this.previousValue = tfaConfiguration2;
        this.usedRescueCode = bool;
    }

    public TfaChangeStatusDetails(@Nonnull TfaConfiguration tfaConfiguration) {
        this(tfaConfiguration, null, null);
    }

    @Nonnull
    public TfaConfiguration getNewValue() {
        return this.newValue;
    }

    @Nullable
    public TfaConfiguration getPreviousValue() {
        return this.previousValue;
    }

    @Nullable
    public Boolean getUsedRescueCode() {
        return this.usedRescueCode;
    }

    public static Builder newBuilder(TfaConfiguration tfaConfiguration) {
        return new Builder(tfaConfiguration);
    }

    public static class Builder {
        protected final TfaConfiguration newValue;
        protected TfaConfiguration previousValue;
        protected Boolean usedRescueCode;

        protected Builder(TfaConfiguration tfaConfiguration) {
            if (tfaConfiguration == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = tfaConfiguration;
            this.previousValue = null;
            this.usedRescueCode = null;
        }

        public Builder withPreviousValue(TfaConfiguration tfaConfiguration) {
            this.previousValue = tfaConfiguration;
            return this;
        }

        public Builder withUsedRescueCode(Boolean bool) {
            this.usedRescueCode = bool;
            return this;
        }

        public TfaChangeStatusDetails build() {
            return new TfaChangeStatusDetails(this.newValue, this.previousValue, this.usedRescueCode);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue, this.usedRescueCode});
    }

    public boolean equals(Object obj) {
        TfaConfiguration tfaConfiguration;
        TfaConfiguration tfaConfiguration2;
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TfaChangeStatusDetails tfaChangeStatusDetails = (TfaChangeStatusDetails) obj;
        TfaConfiguration tfaConfiguration3 = this.newValue;
        TfaConfiguration tfaConfiguration4 = tfaChangeStatusDetails.newValue;
        return (tfaConfiguration3 == tfaConfiguration4 || tfaConfiguration3.equals(tfaConfiguration4)) && ((tfaConfiguration = this.previousValue) == (tfaConfiguration2 = tfaChangeStatusDetails.previousValue) || (tfaConfiguration != null && tfaConfiguration.equals(tfaConfiguration2))) && ((bool = this.usedRescueCode) == (bool2 = tfaChangeStatusDetails.usedRescueCode) || (bool != null && bool.equals(bool2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TfaChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TfaChangeStatusDetails tfaChangeStatusDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TfaConfiguration.Serializer.INSTANCE.serialize(tfaChangeStatusDetails.newValue, jsonGenerator);
            if (tfaChangeStatusDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(TfaConfiguration.Serializer.INSTANCE).serialize(tfaChangeStatusDetails.previousValue, jsonGenerator);
            }
            if (tfaChangeStatusDetails.usedRescueCode != null) {
                jsonGenerator.writeFieldName("used_rescue_code");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(tfaChangeStatusDetails.usedRescueCode, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TfaChangeStatusDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TfaConfiguration tfaConfigurationDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TfaConfiguration tfaConfiguration = null;
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        tfaConfigurationDeserialize = TfaConfiguration.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        tfaConfiguration = (TfaConfiguration) StoneSerializers.nullable(TfaConfiguration.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("used_rescue_code".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (tfaConfigurationDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                TfaChangeStatusDetails tfaChangeStatusDetails = new TfaChangeStatusDetails(tfaConfigurationDeserialize, tfaConfiguration, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(tfaChangeStatusDetails, tfaChangeStatusDetails.toStringMultiline());
                return tfaChangeStatusDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
