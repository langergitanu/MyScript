package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ActorLogInfo;
import com.dropbox.core.p013v2.teamlog.AssetLogInfo;
import com.dropbox.core.p013v2.teamlog.ContextLogInfo;
import com.dropbox.core.p013v2.teamlog.EventCategory;
import com.dropbox.core.p013v2.teamlog.EventDetails;
import com.dropbox.core.p013v2.teamlog.EventType;
import com.dropbox.core.p013v2.teamlog.OriginLogInfo;
import com.dropbox.core.p013v2.teamlog.ParticipantLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class TeamEvent {

    @Nullable
    protected final ActorLogInfo actor;

    @Nullable
    protected final List<AssetLogInfo> assets;

    @Nullable
    protected final ContextLogInfo context;

    @Nonnull
    protected final EventDetails details;

    @Nonnull
    protected final EventCategory eventCategory;

    @Nonnull
    protected final EventType eventType;

    @Nullable
    protected final Boolean involveNonTeamMember;

    @Nullable
    protected final OriginLogInfo origin;

    @Nullable
    protected final List<ParticipantLogInfo> participants;

    @Nonnull
    protected final Date timestamp;

    public TeamEvent(@Nonnull Date date, @Nonnull EventCategory eventCategory, @Nonnull EventType eventType, @Nonnull EventDetails eventDetails, @Nullable ActorLogInfo actorLogInfo, @Nullable OriginLogInfo originLogInfo, @Nullable Boolean bool, @Nullable ContextLogInfo contextLogInfo, @Nullable List<ParticipantLogInfo> list, @Nullable List<AssetLogInfo> list2) {
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'timestamp' is null");
        }
        this.timestamp = LangUtil.truncateMillis(date);
        if (eventCategory == null) {
            throw new IllegalArgumentException("Required value for 'eventCategory' is null");
        }
        this.eventCategory = eventCategory;
        this.actor = actorLogInfo;
        this.origin = originLogInfo;
        this.involveNonTeamMember = bool;
        this.context = contextLogInfo;
        if (list != null) {
            Iterator<ParticipantLogInfo> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'participants' is null");
                }
            }
        }
        this.participants = list;
        if (list2 != null) {
            Iterator<AssetLogInfo> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'assets' is null");
                }
            }
        }
        this.assets = list2;
        if (eventType == null) {
            throw new IllegalArgumentException("Required value for 'eventType' is null");
        }
        this.eventType = eventType;
        if (eventDetails == null) {
            throw new IllegalArgumentException("Required value for 'details' is null");
        }
        this.details = eventDetails;
    }

    public TeamEvent(@Nonnull Date date, @Nonnull EventCategory eventCategory, @Nonnull EventType eventType, @Nonnull EventDetails eventDetails) {
        this(date, eventCategory, eventType, eventDetails, null, null, null, null, null, null);
    }

    @Nonnull
    public Date getTimestamp() {
        return this.timestamp;
    }

    @Nonnull
    public EventCategory getEventCategory() {
        return this.eventCategory;
    }

    @Nonnull
    public EventType getEventType() {
        return this.eventType;
    }

    @Nonnull
    public EventDetails getDetails() {
        return this.details;
    }

    @Nullable
    public ActorLogInfo getActor() {
        return this.actor;
    }

    @Nullable
    public OriginLogInfo getOrigin() {
        return this.origin;
    }

    @Nullable
    public Boolean getInvolveNonTeamMember() {
        return this.involveNonTeamMember;
    }

    @Nullable
    public ContextLogInfo getContext() {
        return this.context;
    }

    @Nullable
    public List<ParticipantLogInfo> getParticipants() {
        return this.participants;
    }

    @Nullable
    public List<AssetLogInfo> getAssets() {
        return this.assets;
    }

    public static Builder newBuilder(Date date, EventCategory eventCategory, EventType eventType, EventDetails eventDetails) {
        return new Builder(date, eventCategory, eventType, eventDetails);
    }

    public static class Builder {
        protected ActorLogInfo actor;
        protected List<AssetLogInfo> assets;
        protected ContextLogInfo context;
        protected final EventDetails details;
        protected final EventCategory eventCategory;
        protected final EventType eventType;
        protected Boolean involveNonTeamMember;
        protected OriginLogInfo origin;
        protected List<ParticipantLogInfo> participants;
        protected final Date timestamp;

        protected Builder(Date date, EventCategory eventCategory, EventType eventType, EventDetails eventDetails) {
            if (date == null) {
                throw new IllegalArgumentException("Required value for 'timestamp' is null");
            }
            this.timestamp = LangUtil.truncateMillis(date);
            if (eventCategory == null) {
                throw new IllegalArgumentException("Required value for 'eventCategory' is null");
            }
            this.eventCategory = eventCategory;
            if (eventType == null) {
                throw new IllegalArgumentException("Required value for 'eventType' is null");
            }
            this.eventType = eventType;
            if (eventDetails == null) {
                throw new IllegalArgumentException("Required value for 'details' is null");
            }
            this.details = eventDetails;
            this.actor = null;
            this.origin = null;
            this.involveNonTeamMember = null;
            this.context = null;
            this.participants = null;
            this.assets = null;
        }

        public Builder withActor(ActorLogInfo actorLogInfo) {
            this.actor = actorLogInfo;
            return this;
        }

        public Builder withOrigin(OriginLogInfo originLogInfo) {
            this.origin = originLogInfo;
            return this;
        }

        public Builder withInvolveNonTeamMember(Boolean bool) {
            this.involveNonTeamMember = bool;
            return this;
        }

        public Builder withContext(ContextLogInfo contextLogInfo) {
            this.context = contextLogInfo;
            return this;
        }

        public Builder withParticipants(List<ParticipantLogInfo> list) {
            if (list != null) {
                Iterator<ParticipantLogInfo> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'participants' is null");
                    }
                }
            }
            this.participants = list;
            return this;
        }

        public Builder withAssets(List<AssetLogInfo> list) {
            if (list != null) {
                Iterator<AssetLogInfo> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'assets' is null");
                    }
                }
            }
            this.assets = list;
            return this;
        }

        public TeamEvent build() {
            return new TeamEvent(this.timestamp, this.eventCategory, this.eventType, this.details, this.actor, this.origin, this.involveNonTeamMember, this.context, this.participants, this.assets);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.timestamp, this.eventCategory, this.actor, this.origin, this.involveNonTeamMember, this.context, this.participants, this.assets, this.eventType, this.details});
    }

    public boolean equals(Object obj) {
        EventCategory eventCategory;
        EventCategory eventCategory2;
        EventType eventType;
        EventType eventType2;
        EventDetails eventDetails;
        EventDetails eventDetails2;
        ActorLogInfo actorLogInfo;
        ActorLogInfo actorLogInfo2;
        OriginLogInfo originLogInfo;
        OriginLogInfo originLogInfo2;
        Boolean bool;
        Boolean bool2;
        ContextLogInfo contextLogInfo;
        ContextLogInfo contextLogInfo2;
        List<ParticipantLogInfo> list;
        List<ParticipantLogInfo> list2;
        List<AssetLogInfo> list3;
        List<AssetLogInfo> list4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamEvent teamEvent = (TeamEvent) obj;
        Date date = this.timestamp;
        Date date2 = teamEvent.timestamp;
        return (date == date2 || date.equals(date2)) && ((eventCategory = this.eventCategory) == (eventCategory2 = teamEvent.eventCategory) || eventCategory.equals(eventCategory2)) && (((eventType = this.eventType) == (eventType2 = teamEvent.eventType) || eventType.equals(eventType2)) && (((eventDetails = this.details) == (eventDetails2 = teamEvent.details) || eventDetails.equals(eventDetails2)) && (((actorLogInfo = this.actor) == (actorLogInfo2 = teamEvent.actor) || (actorLogInfo != null && actorLogInfo.equals(actorLogInfo2))) && (((originLogInfo = this.origin) == (originLogInfo2 = teamEvent.origin) || (originLogInfo != null && originLogInfo.equals(originLogInfo2))) && (((bool = this.involveNonTeamMember) == (bool2 = teamEvent.involveNonTeamMember) || (bool != null && bool.equals(bool2))) && (((contextLogInfo = this.context) == (contextLogInfo2 = teamEvent.context) || (contextLogInfo != null && contextLogInfo.equals(contextLogInfo2))) && (((list = this.participants) == (list2 = teamEvent.participants) || (list != null && list.equals(list2))) && ((list3 = this.assets) == (list4 = teamEvent.assets) || (list3 != null && list3.equals(list4))))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamEvent> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamEvent teamEvent, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(DiagnosticsEntry.TIMESTAMP_KEY);
            StoneSerializers.timestamp().serialize(teamEvent.timestamp, jsonGenerator);
            jsonGenerator.writeFieldName("event_category");
            EventCategory.Serializer.INSTANCE.serialize(teamEvent.eventCategory, jsonGenerator);
            jsonGenerator.writeFieldName("event_type");
            EventType.Serializer.INSTANCE.serialize(teamEvent.eventType, jsonGenerator);
            jsonGenerator.writeFieldName("details");
            EventDetails.Serializer.INSTANCE.serialize(teamEvent.details, jsonGenerator);
            if (teamEvent.actor != null) {
                jsonGenerator.writeFieldName("actor");
                StoneSerializers.nullable(ActorLogInfo.Serializer.INSTANCE).serialize(teamEvent.actor, jsonGenerator);
            }
            if (teamEvent.origin != null) {
                jsonGenerator.writeFieldName("origin");
                StoneSerializers.nullableStruct(OriginLogInfo.Serializer.INSTANCE).serialize(teamEvent.origin, jsonGenerator);
            }
            if (teamEvent.involveNonTeamMember != null) {
                jsonGenerator.writeFieldName("involve_non_team_member");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(teamEvent.involveNonTeamMember, jsonGenerator);
            }
            if (teamEvent.context != null) {
                jsonGenerator.writeFieldName(WebViewMessageType.CONTEXT);
                StoneSerializers.nullable(ContextLogInfo.Serializer.INSTANCE).serialize(teamEvent.context, jsonGenerator);
            }
            if (teamEvent.participants != null) {
                jsonGenerator.writeFieldName("participants");
                StoneSerializers.nullable(StoneSerializers.list(ParticipantLogInfo.Serializer.INSTANCE)).serialize(teamEvent.participants, jsonGenerator);
            }
            if (teamEvent.assets != null) {
                jsonGenerator.writeFieldName("assets");
                StoneSerializers.nullable(StoneSerializers.list(AssetLogInfo.Serializer.INSTANCE)).serialize(teamEvent.assets, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamEvent deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Date dateDeserialize = null;
                EventCategory eventCategoryDeserialize = null;
                EventType eventTypeDeserialize = null;
                EventDetails eventDetailsDeserialize = null;
                ActorLogInfo actorLogInfo = null;
                OriginLogInfo originLogInfo = null;
                Boolean bool = null;
                ContextLogInfo contextLogInfo = null;
                List list = null;
                List list2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (DiagnosticsEntry.TIMESTAMP_KEY.equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("event_category".equals(currentName)) {
                        eventCategoryDeserialize = EventCategory.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("event_type".equals(currentName)) {
                        eventTypeDeserialize = EventType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("details".equals(currentName)) {
                        eventDetailsDeserialize = EventDetails.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("actor".equals(currentName)) {
                        actorLogInfo = (ActorLogInfo) StoneSerializers.nullable(ActorLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("origin".equals(currentName)) {
                        originLogInfo = (OriginLogInfo) StoneSerializers.nullableStruct(OriginLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("involve_non_team_member".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if (WebViewMessageType.CONTEXT.equals(currentName)) {
                        contextLogInfo = (ContextLogInfo) StoneSerializers.nullable(ContextLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("participants".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(ParticipantLogInfo.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("assets".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(AssetLogInfo.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"timestamp\" missing.");
                }
                if (eventCategoryDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_category\" missing.");
                }
                if (eventTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_type\" missing.");
                }
                if (eventDetailsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"details\" missing.");
                }
                TeamEvent teamEvent = new TeamEvent(dateDeserialize, eventCategoryDeserialize, eventTypeDeserialize, eventDetailsDeserialize, actorLogInfo, originLogInfo, bool, contextLogInfo, list, list2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamEvent, teamEvent.toStringMultiline());
                return teamEvent;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
