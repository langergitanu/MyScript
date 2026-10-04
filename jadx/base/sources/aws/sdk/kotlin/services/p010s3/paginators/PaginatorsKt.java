package aws.sdk.kotlin.services.p010s3.paginators;

import androidx.compose.material.TextFieldImplKt;
import androidx.media3.extractor.p007ts.PsExtractor;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.model.Bucket;
import aws.sdk.kotlin.services.p010s3.model.ListBucketsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListDirectoryBucketsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListDirectoryBucketsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsV2Request;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsV2Response;
import aws.sdk.kotlin.services.p010s3.model.ListPartsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListPartsResponse;
import aws.sdk.kotlin.services.p010s3.model.Part;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Paginators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\b\r\u001a\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0010\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u00032\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0007¢\u0006\u0002\b\u0012\u001a\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0015\u001a)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u00032\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0019\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00032\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001*\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0007¢\u0006\u0002\b\u001d¨\u0006\u001e"}, m1599d2 = {"listBucketsPaginated", "Lkotlinx/coroutines/flow/Flow;", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;", "Laws/sdk/kotlin/services/s3/S3Client;", "initialRequest", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "buckets", "Laws/sdk/kotlin/services/s3/model/Bucket;", "listBucketsResponseBucket", "listDirectoryBucketsPaginated", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsResponse;", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsRequest;", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsRequest$Builder;", "listDirectoryBucketsResponseBucket", "listObjectsV2Paginated", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Response;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request$Builder;", "listPartsPaginated", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse;", "Laws/sdk/kotlin/services/s3/model/ListPartsRequest;", "Laws/sdk/kotlin/services/s3/model/ListPartsRequest$Builder;", "parts", "Laws/sdk/kotlin/services/s3/model/Part;", "listPartsResponsePart", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PaginatorsKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listBucketsPaginated$2 */
    /* JADX INFO: compiled from: Paginators.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listBucketsPaginated$2", m1609f = "Paginators.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {42, 45}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "cursor", "req", "hasNextPage", "$this$flow", "cursor", "req", "result", "hasNextPage"}, m1614nl = {43, 47}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
    static final class C34742 extends SuspendLambda implements Function2<FlowCollector<? super ListBucketsResponse>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ListBucketsRequest $initialRequest;
        final /* synthetic */ S3Client $this_listBucketsPaginated;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34742(ListBucketsRequest listBucketsRequest, S3Client s3Client, Continuation<? super C34742> continuation) {
            super(2, continuation);
            this.$initialRequest = listBucketsRequest;
            this.$this_listBucketsPaginated = s3Client;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C34742 c34742 = new C34742(this.$initialRequest, this.$this_listBucketsPaginated, continuation);
            c34742.L$0 = obj;
            return c34742;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ListBucketsResponse> flowCollector, Continuation<? super Unit> continuation) {
            return ((C34742) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
        /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b5 -> B:7:0x0023). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            int i;
            Ref.ObjectRef objectRef2;
            ListBucketsRequest listBucketsRequest;
            ListBucketsResponse listBucketsResponse;
            String str;
            int i2;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = this.$initialRequest.getContinuationToken();
                i = 1;
                if (i != 0) {
                }
            } else {
                if (i3 == 1) {
                    listBucketsRequest = (ListBucketsRequest) this.L$2;
                    objectRef2 = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    listBucketsResponse = (ListBucketsResponse) obj;
                    objectRef2.element = listBucketsResponse.getContinuationToken();
                    str = (String) objectRef2.element;
                    i2 = 0;
                    if (str != null) {
                        i2 = 1;
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listBucketsRequest);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(listBucketsResponse);
                    this.I$0 = i2;
                    this.label = 2;
                    if (flowCollector.emit(listBucketsResponse, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                objectRef = objectRef2;
                if (i != 0) {
                    ListBucketsRequest.Builder builder = new ListBucketsRequest.Builder(this.$initialRequest);
                    builder.setContinuationToken((String) objectRef.element);
                    ListBucketsRequest listBucketsRequestBuild = builder.build();
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listBucketsRequestBuild);
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 1;
                    Object objListBuckets = this.$this_listBucketsPaginated.listBuckets(listBucketsRequestBuild, this);
                    if (objListBuckets != coroutine_suspended) {
                        objectRef2 = objectRef;
                        obj = objListBuckets;
                        listBucketsRequest = listBucketsRequestBuild;
                        listBucketsResponse = (ListBucketsResponse) obj;
                        objectRef2.element = listBucketsResponse.getContinuationToken();
                        str = (String) objectRef2.element;
                        i2 = 0;
                        if (str != null && str.length() > 0) {
                            i2 = 1;
                        }
                        this.L$0 = flowCollector;
                        this.L$1 = objectRef2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(listBucketsRequest);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(listBucketsResponse);
                        this.I$0 = i2;
                        this.label = 2;
                        if (flowCollector.emit(listBucketsResponse, this) != coroutine_suspended) {
                            i = i2;
                            objectRef = objectRef2;
                            if (i != 0) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
    }

    public static /* synthetic */ Flow listBucketsPaginated$default(S3Client s3Client, ListBucketsRequest listBucketsRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            listBucketsRequest = ListBucketsRequest.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PaginatorsKt.listBucketsPaginated$lambda$0((ListBucketsRequest.Builder) obj2);
                }
            });
        }
        return listBucketsPaginated(s3Client, listBucketsRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit listBucketsPaginated$lambda$0(ListBucketsRequest.Builder ListBucketsRequest) {
        Intrinsics.checkNotNullParameter(ListBucketsRequest, "$this$ListBucketsRequest");
        return Unit.INSTANCE;
    }

    public static final Flow<ListBucketsResponse> listBucketsPaginated(S3Client s3Client, ListBucketsRequest initialRequest) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(initialRequest, "initialRequest");
        return FlowKt.flow(new C34742(initialRequest, s3Client, null));
    }

    public static final Flow<ListBucketsResponse> listBucketsPaginated(S3Client s3Client, Function1<? super ListBucketsRequest.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ListBucketsRequest.Builder builder = new ListBucketsRequest.Builder();
        block.invoke(builder);
        return listBucketsPaginated(s3Client, builder.build());
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listDirectoryBucketsPaginated$2 */
    /* JADX INFO: compiled from: Paginators.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsResponse;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listDirectoryBucketsPaginated$2", m1609f = "Paginators.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {96, 99}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "cursor", "req", "hasNextPage", "$this$flow", "cursor", "req", "result", "hasNextPage"}, m1614nl = {97, 101}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
    static final class C34752 extends SuspendLambda implements Function2<FlowCollector<? super ListDirectoryBucketsResponse>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ListDirectoryBucketsRequest $initialRequest;
        final /* synthetic */ S3Client $this_listDirectoryBucketsPaginated;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34752(ListDirectoryBucketsRequest listDirectoryBucketsRequest, S3Client s3Client, Continuation<? super C34752> continuation) {
            super(2, continuation);
            this.$initialRequest = listDirectoryBucketsRequest;
            this.$this_listDirectoryBucketsPaginated = s3Client;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C34752 c34752 = new C34752(this.$initialRequest, this.$this_listDirectoryBucketsPaginated, continuation);
            c34752.L$0 = obj;
            return c34752;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ListDirectoryBucketsResponse> flowCollector, Continuation<? super Unit> continuation) {
            return ((C34752) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
        /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b5 -> B:7:0x0023). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            int i;
            Ref.ObjectRef objectRef2;
            ListDirectoryBucketsRequest listDirectoryBucketsRequest;
            ListDirectoryBucketsResponse listDirectoryBucketsResponse;
            String str;
            int i2;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = this.$initialRequest.getContinuationToken();
                i = 1;
                if (i != 0) {
                }
            } else {
                if (i3 == 1) {
                    listDirectoryBucketsRequest = (ListDirectoryBucketsRequest) this.L$2;
                    objectRef2 = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    listDirectoryBucketsResponse = (ListDirectoryBucketsResponse) obj;
                    objectRef2.element = listDirectoryBucketsResponse.getContinuationToken();
                    str = (String) objectRef2.element;
                    i2 = 0;
                    if (str != null) {
                        i2 = 1;
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listDirectoryBucketsRequest);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(listDirectoryBucketsResponse);
                    this.I$0 = i2;
                    this.label = 2;
                    if (flowCollector.emit(listDirectoryBucketsResponse, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                objectRef = objectRef2;
                if (i != 0) {
                    ListDirectoryBucketsRequest.Builder builder = new ListDirectoryBucketsRequest.Builder(this.$initialRequest);
                    builder.setContinuationToken((String) objectRef.element);
                    ListDirectoryBucketsRequest listDirectoryBucketsRequestBuild = builder.build();
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listDirectoryBucketsRequestBuild);
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 1;
                    Object objListDirectoryBuckets = this.$this_listDirectoryBucketsPaginated.listDirectoryBuckets(listDirectoryBucketsRequestBuild, this);
                    if (objListDirectoryBuckets != coroutine_suspended) {
                        objectRef2 = objectRef;
                        obj = objListDirectoryBuckets;
                        listDirectoryBucketsRequest = listDirectoryBucketsRequestBuild;
                        listDirectoryBucketsResponse = (ListDirectoryBucketsResponse) obj;
                        objectRef2.element = listDirectoryBucketsResponse.getContinuationToken();
                        str = (String) objectRef2.element;
                        i2 = 0;
                        if (str != null && str.length() > 0) {
                            i2 = 1;
                        }
                        this.L$0 = flowCollector;
                        this.L$1 = objectRef2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(listDirectoryBucketsRequest);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(listDirectoryBucketsResponse);
                        this.I$0 = i2;
                        this.label = 2;
                        if (flowCollector.emit(listDirectoryBucketsResponse, this) != coroutine_suspended) {
                            i = i2;
                            objectRef = objectRef2;
                            if (i != 0) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
    }

    public static /* synthetic */ Flow listDirectoryBucketsPaginated$default(S3Client s3Client, ListDirectoryBucketsRequest listDirectoryBucketsRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            listDirectoryBucketsRequest = ListDirectoryBucketsRequest.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PaginatorsKt.listDirectoryBucketsPaginated$lambda$0((ListDirectoryBucketsRequest.Builder) obj2);
                }
            });
        }
        return listDirectoryBucketsPaginated(s3Client, listDirectoryBucketsRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit listDirectoryBucketsPaginated$lambda$0(ListDirectoryBucketsRequest.Builder ListDirectoryBucketsRequest) {
        Intrinsics.checkNotNullParameter(ListDirectoryBucketsRequest, "$this$ListDirectoryBucketsRequest");
        return Unit.INSTANCE;
    }

    public static final Flow<ListDirectoryBucketsResponse> listDirectoryBucketsPaginated(S3Client s3Client, ListDirectoryBucketsRequest initialRequest) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(initialRequest, "initialRequest");
        return FlowKt.flow(new C34752(initialRequest, s3Client, null));
    }

    public static final Flow<ListDirectoryBucketsResponse> listDirectoryBucketsPaginated(S3Client s3Client, Function1<? super ListDirectoryBucketsRequest.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ListDirectoryBucketsRequest.Builder builder = new ListDirectoryBucketsRequest.Builder();
        block.invoke(builder);
        return listDirectoryBucketsPaginated(s3Client, builder.build());
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listObjectsV2Paginated$1 */
    /* JADX INFO: compiled from: Paginators.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Response;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listObjectsV2Paginated$1", m1609f = "Paginators.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {TextFieldImplKt.AnimationDuration, 153}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "cursor", "req", "hasNextPage", "$this$flow", "cursor", "req", "result", "hasNextPage"}, m1614nl = {151, 155}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
    static final class C34761 extends SuspendLambda implements Function2<FlowCollector<? super ListObjectsV2Response>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ListObjectsV2Request $initialRequest;
        final /* synthetic */ S3Client $this_listObjectsV2Paginated;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34761(ListObjectsV2Request listObjectsV2Request, S3Client s3Client, Continuation<? super C34761> continuation) {
            super(2, continuation);
            this.$initialRequest = listObjectsV2Request;
            this.$this_listObjectsV2Paginated = s3Client;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C34761 c34761 = new C34761(this.$initialRequest, this.$this_listObjectsV2Paginated, continuation);
            c34761.L$0 = obj;
            return c34761;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ListObjectsV2Response> flowCollector, Continuation<? super Unit> continuation) {
            return ((C34761) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
        /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b5 -> B:7:0x0023). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            int i;
            Ref.ObjectRef objectRef2;
            ListObjectsV2Request listObjectsV2Request;
            ListObjectsV2Response listObjectsV2Response;
            String str;
            int i2;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = this.$initialRequest.getContinuationToken();
                i = 1;
                if (i != 0) {
                }
            } else {
                if (i3 == 1) {
                    listObjectsV2Request = (ListObjectsV2Request) this.L$2;
                    objectRef2 = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    listObjectsV2Response = (ListObjectsV2Response) obj;
                    objectRef2.element = listObjectsV2Response.getNextContinuationToken();
                    str = (String) objectRef2.element;
                    i2 = 0;
                    if (str != null) {
                        i2 = 1;
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listObjectsV2Request);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(listObjectsV2Response);
                    this.I$0 = i2;
                    this.label = 2;
                    if (flowCollector.emit(listObjectsV2Response, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                objectRef = objectRef2;
                if (i != 0) {
                    ListObjectsV2Request.Builder builder = new ListObjectsV2Request.Builder(this.$initialRequest);
                    builder.setContinuationToken((String) objectRef.element);
                    ListObjectsV2Request listObjectsV2RequestBuild = builder.build();
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listObjectsV2RequestBuild);
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 1;
                    Object objListObjectsV2 = this.$this_listObjectsV2Paginated.listObjectsV2(listObjectsV2RequestBuild, this);
                    if (objListObjectsV2 != coroutine_suspended) {
                        objectRef2 = objectRef;
                        obj = objListObjectsV2;
                        listObjectsV2Request = listObjectsV2RequestBuild;
                        listObjectsV2Response = (ListObjectsV2Response) obj;
                        objectRef2.element = listObjectsV2Response.getNextContinuationToken();
                        str = (String) objectRef2.element;
                        i2 = 0;
                        if (str != null && str.length() > 0) {
                            i2 = 1;
                        }
                        this.L$0 = flowCollector;
                        this.L$1 = objectRef2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(listObjectsV2Request);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(listObjectsV2Response);
                        this.I$0 = i2;
                        this.label = 2;
                        if (flowCollector.emit(listObjectsV2Response, this) != coroutine_suspended) {
                            i = i2;
                            objectRef = objectRef2;
                            if (i != 0) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
    }

    public static final Flow<ListObjectsV2Response> listObjectsV2Paginated(S3Client s3Client, ListObjectsV2Request initialRequest) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(initialRequest, "initialRequest");
        return FlowKt.flow(new C34761(initialRequest, s3Client, null));
    }

    public static final Flow<ListObjectsV2Response> listObjectsV2Paginated(S3Client s3Client, Function1<? super ListObjectsV2Request.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ListObjectsV2Request.Builder builder = new ListObjectsV2Request.Builder();
        block.invoke(builder);
        return listObjectsV2Paginated(s3Client, builder.build());
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listPartsPaginated$1 */
    /* JADX INFO: compiled from: Paginators.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.paginators.PaginatorsKt$listPartsPaginated$1", m1609f = "Paginators.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {191, 194}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "cursor", "req", "hasNextPage", "$this$flow", "cursor", "req", "result", "hasNextPage"}, m1614nl = {PsExtractor.AUDIO_STREAM, 196}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, m1616v = 2)
    static final class C34771 extends SuspendLambda implements Function2<FlowCollector<? super ListPartsResponse>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ListPartsRequest $initialRequest;
        final /* synthetic */ S3Client $this_listPartsPaginated;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34771(ListPartsRequest listPartsRequest, S3Client s3Client, Continuation<? super C34771> continuation) {
            super(2, continuation);
            this.$initialRequest = listPartsRequest;
            this.$this_listPartsPaginated = s3Client;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C34771 c34771 = new C34771(this.$initialRequest, this.$this_listPartsPaginated, continuation);
            c34771.L$0 = obj;
            return c34771;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ListPartsResponse> flowCollector, Continuation<? super Unit> continuation) {
            return ((C34771) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b1 -> B:7:0x0023). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            ?? r2;
            Ref.ObjectRef objectRef2;
            ListPartsRequest listPartsRequest;
            ListPartsResponse listPartsResponse;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = this.$initialRequest.getPartNumberMarker();
                r2 = 1;
                if (r2 != 0) {
                }
            } else {
                if (i == 1) {
                    listPartsRequest = (ListPartsRequest) this.L$2;
                    objectRef2 = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    listPartsResponse = (ListPartsResponse) obj;
                    objectRef2.element = listPartsResponse.getNextPartNumberMarker();
                    boolean zAreEqual = Intrinsics.areEqual(listPartsResponse.getIsTruncated(), Boxing.boxBoolean(true));
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listPartsRequest);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(listPartsResponse);
                    this.Z$0 = zAreEqual;
                    this.label = 2;
                    if (flowCollector.emit(listPartsResponse, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z = this.Z$0;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                boolean z2 = z;
                objectRef = objectRef2;
                r2 = z2;
                if (r2 != 0) {
                    ListPartsRequest.Builder builder = new ListPartsRequest.Builder(this.$initialRequest);
                    builder.setPartNumberMarker((String) objectRef.element);
                    ListPartsRequest listPartsRequestBuild = builder.build();
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(listPartsRequestBuild);
                    this.L$3 = null;
                    this.I$0 = r2;
                    this.label = 1;
                    Object objListParts = this.$this_listPartsPaginated.listParts(listPartsRequestBuild, this);
                    if (objListParts != coroutine_suspended) {
                        objectRef2 = objectRef;
                        obj = objListParts;
                        listPartsRequest = listPartsRequestBuild;
                        listPartsResponse = (ListPartsResponse) obj;
                        objectRef2.element = listPartsResponse.getNextPartNumberMarker();
                        boolean zAreEqual2 = Intrinsics.areEqual(listPartsResponse.getIsTruncated(), Boxing.boxBoolean(true));
                        this.L$0 = flowCollector;
                        this.L$1 = objectRef2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(listPartsRequest);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(listPartsResponse);
                        this.Z$0 = zAreEqual2;
                        this.label = 2;
                        if (flowCollector.emit(listPartsResponse, this) != coroutine_suspended) {
                            z2 = zAreEqual2;
                            objectRef = objectRef2;
                            r2 = z2;
                            if (r2 != 0) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
    }

    public static final Flow<ListPartsResponse> listPartsPaginated(S3Client s3Client, ListPartsRequest initialRequest) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(initialRequest, "initialRequest");
        return FlowKt.flow(new C34771(initialRequest, s3Client, null));
    }

    public static final Flow<ListPartsResponse> listPartsPaginated(S3Client s3Client, Function1<? super ListPartsRequest.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ListPartsRequest.Builder builder = new ListPartsRequest.Builder();
        block.invoke(builder);
        return listPartsPaginated(s3Client, builder.build());
    }

    public static final Flow<Bucket> listBucketsResponseBucket(Flow<ListBucketsResponse> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.flow(new PaginatorsKt$buckets$$inlined$transform$1(flow, null));
    }

    public static final Flow<Bucket> listDirectoryBucketsResponseBucket(Flow<ListDirectoryBucketsResponse> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.flow(new PaginatorsKt$buckets$$inlined$transform$2(flow, null));
    }

    public static final Flow<Part> listPartsResponsePart(Flow<ListPartsResponse> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.flow(new PaginatorsKt$parts$$inlined$transform$1(flow, null));
    }
}
