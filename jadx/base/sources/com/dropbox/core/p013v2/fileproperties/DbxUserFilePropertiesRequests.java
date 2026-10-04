package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.fileproperties.AddPropertiesArg;
import com.dropbox.core.p013v2.fileproperties.AddPropertiesError;
import com.dropbox.core.p013v2.fileproperties.AddTemplateArg;
import com.dropbox.core.p013v2.fileproperties.AddTemplateResult;
import com.dropbox.core.p013v2.fileproperties.GetTemplateArg;
import com.dropbox.core.p013v2.fileproperties.GetTemplateResult;
import com.dropbox.core.p013v2.fileproperties.InvalidPropertyGroupError;
import com.dropbox.core.p013v2.fileproperties.ListTemplateResult;
import com.dropbox.core.p013v2.fileproperties.ModifyTemplateError;
import com.dropbox.core.p013v2.fileproperties.OverwritePropertyGroupArg;
import com.dropbox.core.p013v2.fileproperties.PropertiesSearchArg;
import com.dropbox.core.p013v2.fileproperties.PropertiesSearchContinueArg;
import com.dropbox.core.p013v2.fileproperties.PropertiesSearchContinueError;
import com.dropbox.core.p013v2.fileproperties.PropertiesSearchError;
import com.dropbox.core.p013v2.fileproperties.PropertiesSearchResult;
import com.dropbox.core.p013v2.fileproperties.RemovePropertiesArg;
import com.dropbox.core.p013v2.fileproperties.RemovePropertiesError;
import com.dropbox.core.p013v2.fileproperties.RemoveTemplateArg;
import com.dropbox.core.p013v2.fileproperties.TemplateError;
import com.dropbox.core.p013v2.fileproperties.UpdatePropertiesArg;
import com.dropbox.core.p013v2.fileproperties.UpdatePropertiesError;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateArg;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateResult;
import com.dropbox.core.stone.StoneSerializers;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserFilePropertiesRequests {
    private final DbxRawClientV2 client;

    public DbxUserFilePropertiesRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    void propertiesAdd(AddPropertiesArg addPropertiesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/properties/add", addPropertiesArg, false, AddPropertiesArg.Serializer.INSTANCE, StoneSerializers.void_(), AddPropertiesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new AddPropertiesErrorException("2/file_properties/properties/add", e.getRequestId(), e.getUserMessage(), (AddPropertiesError) e.getErrorValue());
        }
    }

    public void propertiesAdd(String str, List<PropertyGroup> list) throws DbxException {
        propertiesAdd(new AddPropertiesArg(str, list));
    }

    void propertiesOverwrite(OverwritePropertyGroupArg overwritePropertyGroupArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/properties/overwrite", overwritePropertyGroupArg, false, OverwritePropertyGroupArg.Serializer.INSTANCE, StoneSerializers.void_(), InvalidPropertyGroupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new InvalidPropertyGroupErrorException("2/file_properties/properties/overwrite", e.getRequestId(), e.getUserMessage(), (InvalidPropertyGroupError) e.getErrorValue());
        }
    }

    public void propertiesOverwrite(String str, List<PropertyGroup> list) throws DbxException {
        propertiesOverwrite(new OverwritePropertyGroupArg(str, list));
    }

    void propertiesRemove(RemovePropertiesArg removePropertiesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/properties/remove", removePropertiesArg, false, RemovePropertiesArg.Serializer.INSTANCE, StoneSerializers.void_(), RemovePropertiesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RemovePropertiesErrorException("2/file_properties/properties/remove", e.getRequestId(), e.getUserMessage(), (RemovePropertiesError) e.getErrorValue());
        }
    }

    public void propertiesRemove(String str, List<String> list) throws DbxException {
        propertiesRemove(new RemovePropertiesArg(str, list));
    }

    PropertiesSearchResult propertiesSearch(PropertiesSearchArg propertiesSearchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (PropertiesSearchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/properties/search", propertiesSearchArg, false, PropertiesSearchArg.Serializer.INSTANCE, PropertiesSearchResult.Serializer.INSTANCE, PropertiesSearchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PropertiesSearchErrorException("2/file_properties/properties/search", e.getRequestId(), e.getUserMessage(), (PropertiesSearchError) e.getErrorValue());
        }
    }

    public PropertiesSearchResult propertiesSearch(List<PropertiesSearchQuery> list) throws DbxException {
        return propertiesSearch(new PropertiesSearchArg(list));
    }

    public PropertiesSearchResult propertiesSearch(List<PropertiesSearchQuery> list, TemplateFilter templateFilter) throws DbxException {
        if (templateFilter == null) {
            throw new IllegalArgumentException("Required value for 'templateFilter' is null");
        }
        return propertiesSearch(new PropertiesSearchArg(list, templateFilter));
    }

    PropertiesSearchResult propertiesSearchContinue(PropertiesSearchContinueArg propertiesSearchContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (PropertiesSearchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/properties/search/continue", propertiesSearchContinueArg, false, PropertiesSearchContinueArg.Serializer.INSTANCE, PropertiesSearchResult.Serializer.INSTANCE, PropertiesSearchContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PropertiesSearchContinueErrorException("2/file_properties/properties/search/continue", e.getRequestId(), e.getUserMessage(), (PropertiesSearchContinueError) e.getErrorValue());
        }
    }

    public PropertiesSearchResult propertiesSearchContinue(String str) throws DbxException {
        return propertiesSearchContinue(new PropertiesSearchContinueArg(str));
    }

    void propertiesUpdate(UpdatePropertiesArg updatePropertiesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/properties/update", updatePropertiesArg, false, UpdatePropertiesArg.Serializer.INSTANCE, StoneSerializers.void_(), UpdatePropertiesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UpdatePropertiesErrorException("2/file_properties/properties/update", e.getRequestId(), e.getUserMessage(), (UpdatePropertiesError) e.getErrorValue());
        }
    }

    public void propertiesUpdate(String str, List<PropertyGroupUpdate> list) throws DbxException {
        propertiesUpdate(new UpdatePropertiesArg(str, list));
    }

    AddTemplateResult templatesAddForUser(AddTemplateArg addTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (AddTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/add_for_user", addTemplateArg, false, AddTemplateArg.Serializer.INSTANCE, AddTemplateResult.Serializer.INSTANCE, ModifyTemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/add_for_user", e.getRequestId(), e.getUserMessage(), (ModifyTemplateError) e.getErrorValue());
        }
    }

    public AddTemplateResult templatesAddForUser(String str, String str2, List<PropertyFieldTemplate> list) throws DbxException {
        return templatesAddForUser(new AddTemplateArg(str, str2, list));
    }

    GetTemplateResult templatesGetForUser(GetTemplateArg getTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/get_for_user", getTemplateArg, false, GetTemplateArg.Serializer.INSTANCE, GetTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/file_properties/templates/get_for_user", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    public GetTemplateResult templatesGetForUser(String str) throws DbxException {
        return templatesGetForUser(new GetTemplateArg(str));
    }

    public ListTemplateResult templatesListForUser() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/list_for_user", null, false, StoneSerializers.void_(), ListTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/file_properties/templates/list_for_user", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    void templatesRemoveForUser(RemoveTemplateArg removeTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/remove_for_user", removeTemplateArg, false, RemoveTemplateArg.Serializer.INSTANCE, StoneSerializers.void_(), TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/file_properties/templates/remove_for_user", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    public void templatesRemoveForUser(String str) throws DbxException {
        templatesRemoveForUser(new RemoveTemplateArg(str));
    }

    UpdateTemplateResult templatesUpdateForUser(UpdateTemplateArg updateTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UpdateTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/update_for_user", updateTemplateArg, false, UpdateTemplateArg.Serializer.INSTANCE, UpdateTemplateResult.Serializer.INSTANCE, ModifyTemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/update_for_user", e.getRequestId(), e.getUserMessage(), (ModifyTemplateError) e.getErrorValue());
        }
    }

    public UpdateTemplateResult templatesUpdateForUser(String str) throws DbxException {
        return templatesUpdateForUser(new UpdateTemplateArg(str));
    }

    public TemplatesUpdateForUserBuilder templatesUpdateForUserBuilder(String str) {
        return new TemplatesUpdateForUserBuilder(this, UpdateTemplateArg.newBuilder(str));
    }
}
