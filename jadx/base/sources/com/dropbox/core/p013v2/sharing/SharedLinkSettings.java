package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkAudience;
import com.dropbox.core.p013v2.sharing.RequestedLinkAccessLevel;
import com.dropbox.core.p013v2.sharing.RequestedVisibility;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class SharedLinkSettings {

    @Nullable
    protected final RequestedLinkAccessLevel access;

    @Nullable
    protected final Boolean allowDownload;

    @Nullable
    protected final LinkAudience audience;

    @Nullable
    protected final Date expires;

    @Nullable
    protected final String linkPassword;

    @Nullable
    protected final RequestedVisibility requestedVisibility;

    @Nullable
    protected final Boolean requirePassword;

    public SharedLinkSettings(@Nullable Boolean bool, @Nullable String str, @Nullable Date date, @Nullable LinkAudience linkAudience, @Nullable RequestedLinkAccessLevel requestedLinkAccessLevel, @Nullable RequestedVisibility requestedVisibility, @Nullable Boolean bool2) {
        this.requirePassword = bool;
        this.linkPassword = str;
        this.expires = LangUtil.truncateMillis(date);
        this.audience = linkAudience;
        this.access = requestedLinkAccessLevel;
        this.requestedVisibility = requestedVisibility;
        this.allowDownload = bool2;
    }

    public SharedLinkSettings() {
        this(null, null, null, null, null, null, null);
    }

    @Nullable
    public Boolean getRequirePassword() {
        return this.requirePassword;
    }

    @Nullable
    public String getLinkPassword() {
        return this.linkPassword;
    }

    @Nullable
    public Date getExpires() {
        return this.expires;
    }

    @Nullable
    public LinkAudience getAudience() {
        return this.audience;
    }

    @Nullable
    public RequestedLinkAccessLevel getAccess() {
        return this.access;
    }

    @Nullable
    public RequestedVisibility getRequestedVisibility() {
        return this.requestedVisibility;
    }

    @Nullable
    public Boolean getAllowDownload() {
        return this.allowDownload;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Boolean requirePassword = null;
        protected String linkPassword = null;
        protected Date expires = null;
        protected LinkAudience audience = null;
        protected RequestedLinkAccessLevel access = null;
        protected RequestedVisibility requestedVisibility = null;
        protected Boolean allowDownload = null;

        protected Builder() {
        }

        public Builder withRequirePassword(Boolean bool) {
            this.requirePassword = bool;
            return this;
        }

        public Builder withLinkPassword(String str) {
            this.linkPassword = str;
            return this;
        }

        public Builder withExpires(Date date) {
            this.expires = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withAudience(LinkAudience linkAudience) {
            this.audience = linkAudience;
            return this;
        }

        public Builder withAccess(RequestedLinkAccessLevel requestedLinkAccessLevel) {
            this.access = requestedLinkAccessLevel;
            return this;
        }

        public Builder withRequestedVisibility(RequestedVisibility requestedVisibility) {
            this.requestedVisibility = requestedVisibility;
            return this;
        }

        public Builder withAllowDownload(Boolean bool) {
            this.allowDownload = bool;
            return this;
        }

        public SharedLinkSettings build() {
            return new SharedLinkSettings(this.requirePassword, this.linkPassword, this.expires, this.audience, this.access, this.requestedVisibility, this.allowDownload);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.requirePassword, this.linkPassword, this.expires, this.audience, this.access, this.requestedVisibility, this.allowDownload});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Date date;
        Date date2;
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        RequestedLinkAccessLevel requestedLinkAccessLevel;
        RequestedLinkAccessLevel requestedLinkAccessLevel2;
        RequestedVisibility requestedVisibility;
        RequestedVisibility requestedVisibility2;
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedLinkSettings sharedLinkSettings = (SharedLinkSettings) obj;
        Boolean bool3 = this.requirePassword;
        Boolean bool4 = sharedLinkSettings.requirePassword;
        return (bool3 == bool4 || (bool3 != null && bool3.equals(bool4))) && ((str = this.linkPassword) == (str2 = sharedLinkSettings.linkPassword) || (str != null && str.equals(str2))) && (((date = this.expires) == (date2 = sharedLinkSettings.expires) || (date != null && date.equals(date2))) && (((linkAudience = this.audience) == (linkAudience2 = sharedLinkSettings.audience) || (linkAudience != null && linkAudience.equals(linkAudience2))) && (((requestedLinkAccessLevel = this.access) == (requestedLinkAccessLevel2 = sharedLinkSettings.access) || (requestedLinkAccessLevel != null && requestedLinkAccessLevel.equals(requestedLinkAccessLevel2))) && (((requestedVisibility = this.requestedVisibility) == (requestedVisibility2 = sharedLinkSettings.requestedVisibility) || (requestedVisibility != null && requestedVisibility.equals(requestedVisibility2))) && ((bool = this.allowDownload) == (bool2 = sharedLinkSettings.allowDownload) || (bool != null && bool.equals(bool2)))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkSettings> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkSettings sharedLinkSettings, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedLinkSettings.requirePassword != null) {
                jsonGenerator.writeFieldName("require_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(sharedLinkSettings.requirePassword, jsonGenerator);
            }
            if (sharedLinkSettings.linkPassword != null) {
                jsonGenerator.writeFieldName("link_password");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkSettings.linkPassword, jsonGenerator);
            }
            if (sharedLinkSettings.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedLinkSettings.expires, jsonGenerator);
            }
            if (sharedLinkSettings.audience != null) {
                jsonGenerator.writeFieldName("audience");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(sharedLinkSettings.audience, jsonGenerator);
            }
            if (sharedLinkSettings.access != null) {
                jsonGenerator.writeFieldName("access");
                StoneSerializers.nullable(RequestedLinkAccessLevel.Serializer.INSTANCE).serialize(sharedLinkSettings.access, jsonGenerator);
            }
            if (sharedLinkSettings.requestedVisibility != null) {
                jsonGenerator.writeFieldName("requested_visibility");
                StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).serialize(sharedLinkSettings.requestedVisibility, jsonGenerator);
            }
            if (sharedLinkSettings.allowDownload != null) {
                jsonGenerator.writeFieldName("allow_download");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(sharedLinkSettings.allowDownload, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkSettings deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean bool = null;
                String str = null;
                Date date = null;
                LinkAudience linkAudience = null;
                RequestedLinkAccessLevel requestedLinkAccessLevel = null;
                RequestedVisibility requestedVisibility = null;
                Boolean bool2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("require_password".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("link_password".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (ClientCookie.EXPIRES_ATTR.equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("audience".equals(currentName)) {
                        linkAudience = (LinkAudience) StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("access".equals(currentName)) {
                        requestedLinkAccessLevel = (RequestedLinkAccessLevel) StoneSerializers.nullable(RequestedLinkAccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("requested_visibility".equals(currentName)) {
                        requestedVisibility = (RequestedVisibility) StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("allow_download".equals(currentName)) {
                        bool2 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedLinkSettings sharedLinkSettings = new SharedLinkSettings(bool, str, date, linkAudience, requestedLinkAccessLevel, requestedVisibility, bool2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkSettings, sharedLinkSettings.toStringMultiline());
                return sharedLinkSettings;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
