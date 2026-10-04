package com.myscript.nebo.dms.sharepage.contacts.model;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.google.android.gms.actions.SearchIntents;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ContentResolverContactsRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/model/ContentResolverContactsRepository;", "Lcom/myscript/nebo/dms/sharepage/contacts/model/IContactsRepository;", "contentResolver", "Landroid/content/ContentResolver;", "<init>", "(Landroid/content/ContentResolver;)V", "getContacts", "", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", SearchIntents.EXTRA_QUERY, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ContentResolverContactsRepository implements IContactsRepository {
    private final ContentResolver contentResolver;

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.contacts.model.ContentResolverContactsRepository$getContacts$2 */
    /* JADX INFO: compiled from: ContentResolverContactsRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.contacts.model.ContentResolverContactsRepository$getContacts$2", m1609f = "ContentResolverContactsRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ContactItem>>, Object> {
        final /* synthetic */ String $query;
        int label;
        final /* synthetic */ ContentResolverContactsRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62952(String str, ContentResolverContactsRepository contentResolverContactsRepository, Continuation<? super C62952> continuation) {
            super(2, continuation);
            this.$query = str;
            this.this$0 = contentResolverContactsRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C62952(this.$query, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ContactItem>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<ContactItem>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ContactItem>> continuation) {
            return ((C62952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorQuery = this.this$0.contentResolver.query(Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode(this.$query)), new String[]{"_id", Keys.DISPLAY_NAME, "photo_uri", "data1"}, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    ArrayList arrayList = new ArrayList();
                    int columnIndex = cursor2.getColumnIndex("_id");
                    int columnIndex2 = cursor2.getColumnIndex(Keys.DISPLAY_NAME);
                    int columnIndex3 = cursor2.getColumnIndex("data1");
                    if (cursor2.moveToFirst()) {
                        do {
                            long j = cursor2.getLong(columnIndex);
                            String string = cursor2.getString(columnIndex2);
                            String string2 = cursor2.getString(columnIndex3);
                            Uri uriWithAppendedId = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j);
                            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                            Uri uriWithAppendedPath = Uri.withAppendedPath(uriWithAppendedId, "photo");
                            if (string2 != null) {
                                Intrinsics.checkNotNull(string);
                                arrayList.add(new ContactItem(string2, j, string, uriWithAppendedPath));
                            }
                        } while (cursor2.moveToNext());
                    }
                    List list = CollectionsKt.toList(arrayList);
                    CloseableKt.closeFinally(cursor, null);
                    if (list != null) {
                        return list;
                    }
                } finally {
                }
            }
            return CollectionsKt.emptyList();
        }
    }

    public ContentResolverContactsRepository(ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.contentResolver = contentResolver;
    }

    @Override // com.myscript.nebo.dms.sharepage.contacts.model.IContactsRepository
    public Object getContacts(String str, Continuation<? super List<ContactItem>> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C62952(str, this, null), continuation);
    }
}
