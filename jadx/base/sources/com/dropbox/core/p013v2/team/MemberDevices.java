package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.ActiveWebSession;
import com.dropbox.core.p013v2.team.DesktopClientSession;
import com.dropbox.core.p013v2.team.MobileClientSession;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MemberDevices {

    @Nullable
    protected final List<DesktopClientSession> desktopClients;

    @Nullable
    protected final List<MobileClientSession> mobileClients;

    @Nonnull
    protected final String teamMemberId;

    @Nullable
    protected final List<ActiveWebSession> webSessions;

    public MemberDevices(@Nonnull String str, @Nullable List<ActiveWebSession> list, @Nullable List<DesktopClientSession> list2, @Nullable List<MobileClientSession> list3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = str;
        if (list != null) {
            Iterator<ActiveWebSession> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'webSessions' is null");
                }
            }
        }
        this.webSessions = list;
        if (list2 != null) {
            Iterator<DesktopClientSession> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'desktopClients' is null");
                }
            }
        }
        this.desktopClients = list2;
        if (list3 != null) {
            Iterator<MobileClientSession> it3 = list3.iterator();
            while (it3.hasNext()) {
                if (it3.next() == null) {
                    throw new IllegalArgumentException("An item in list 'mobileClients' is null");
                }
            }
        }
        this.mobileClients = list3;
    }

    public MemberDevices(@Nonnull String str) {
        this(str, null, null, null);
    }

    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    @Nullable
    public List<ActiveWebSession> getWebSessions() {
        return this.webSessions;
    }

    @Nullable
    public List<DesktopClientSession> getDesktopClients() {
        return this.desktopClients;
    }

    @Nullable
    public List<MobileClientSession> getMobileClients() {
        return this.mobileClients;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected List<DesktopClientSession> desktopClients;
        protected List<MobileClientSession> mobileClients;
        protected final String teamMemberId;
        protected List<ActiveWebSession> webSessions;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
            }
            this.teamMemberId = str;
            this.webSessions = null;
            this.desktopClients = null;
            this.mobileClients = null;
        }

        public Builder withWebSessions(List<ActiveWebSession> list) {
            if (list != null) {
                Iterator<ActiveWebSession> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'webSessions' is null");
                    }
                }
            }
            this.webSessions = list;
            return this;
        }

        public Builder withDesktopClients(List<DesktopClientSession> list) {
            if (list != null) {
                Iterator<DesktopClientSession> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'desktopClients' is null");
                    }
                }
            }
            this.desktopClients = list;
            return this;
        }

        public Builder withMobileClients(List<MobileClientSession> list) {
            if (list != null) {
                Iterator<MobileClientSession> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'mobileClients' is null");
                    }
                }
            }
            this.mobileClients = list;
            return this;
        }

        public MemberDevices build() {
            return new MemberDevices(this.teamMemberId, this.webSessions, this.desktopClients, this.mobileClients);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamMemberId, this.webSessions, this.desktopClients, this.mobileClients});
    }

    public boolean equals(Object obj) {
        List<ActiveWebSession> list;
        List<ActiveWebSession> list2;
        List<DesktopClientSession> list3;
        List<DesktopClientSession> list4;
        List<MobileClientSession> list5;
        List<MobileClientSession> list6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberDevices memberDevices = (MemberDevices) obj;
        String str = this.teamMemberId;
        String str2 = memberDevices.teamMemberId;
        return (str == str2 || str.equals(str2)) && ((list = this.webSessions) == (list2 = memberDevices.webSessions) || (list != null && list.equals(list2))) && (((list3 = this.desktopClients) == (list4 = memberDevices.desktopClients) || (list3 != null && list3.equals(list4))) && ((list5 = this.mobileClients) == (list6 = memberDevices.mobileClients) || (list5 != null && list5.equals(list6))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberDevices> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberDevices memberDevices, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(memberDevices.teamMemberId, jsonGenerator);
            if (memberDevices.webSessions != null) {
                jsonGenerator.writeFieldName("web_sessions");
                StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).serialize(memberDevices.webSessions, jsonGenerator);
            }
            if (memberDevices.desktopClients != null) {
                jsonGenerator.writeFieldName("desktop_clients");
                StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).serialize(memberDevices.desktopClients, jsonGenerator);
            }
            if (memberDevices.mobileClients != null) {
                jsonGenerator.writeFieldName("mobile_clients");
                StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).serialize(memberDevices.mobileClients, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberDevices deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                List list2 = null;
                List list3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_member_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("web_sessions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("desktop_clients".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("mobile_clients".equals(currentName)) {
                        list3 = (List) StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_id\" missing.");
                }
                MemberDevices memberDevices = new MemberDevices(strDeserialize, list, list2, list3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberDevices, memberDevices.toStringMultiline());
                return memberDevices;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
