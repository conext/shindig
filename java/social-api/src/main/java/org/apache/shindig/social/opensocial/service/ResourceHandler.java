package org.apache.shindig.social.opensocial.service;

import com.google.inject.Inject;
import org.apache.shindig.protocol.HandlerPreconditions;
import org.apache.shindig.protocol.Operation;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.Service;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.ResourceService;
import org.apache.shindig.social.opensocial.spi.UserId;

import java.util.Set;
import java.util.concurrent.Future;

/**
 * Maciej Machulak (maciej.machulak@cloudidentity.co.uk)
 */
@Service(name = "resources", path = "/{userId}")
public class ResourceHandler {

    public static final String GROUPID = "groupId";
    public static final String OBJ = "obj";

    private final ResourceService service;

    @Inject
    public ResourceHandler(ResourceService service) {
        this.service = service;
    }

    @Operation(httpMethods = "GET")
    public Future<?> getResources(SocialRequestItem request) throws ProtocolException {

        Set<UserId> userIds = request.getUsers();
        String groupId = request.getParameter(GROUPID);
        CollectionOptions options = new CollectionOptions(request);

        // Preconditions
        HandlerPreconditions.requireNotEmpty(userIds, "No userId specified");
        HandlerPreconditions.requireSingular(userIds, "Only one userId must be specified");

        return service.getResources(userIds.iterator().next(), groupId, request.getToken());
    }

    @Operation(httpMethods = "GET")
    public Future<?> createResource(SocialRequestItem request) throws ProtocolException {

        Set<UserId> userIds = request.getUsers();
        String groupId = request.getParameter(GROUPID);
        String obj = request.getParameter(OBJ);
        CollectionOptions options = new CollectionOptions(request);

        // Preconditions
        HandlerPreconditions.requireNotEmpty(userIds, "No userId specified");
        HandlerPreconditions.requireSingular(userIds, "Only one userId must be specified");

        return service.createResource(userIds.iterator().next(), groupId, obj, request.getToken());
    }

    @Operation(httpMethods = "GET")
    public Future<?> deleteResource(SocialRequestItem request) throws ProtocolException {

        Set<UserId> userIds = request.getUsers();
        String groupId = request.getParameter(GROUPID);
        String obj = request.getParameter(OBJ);
        CollectionOptions options = new CollectionOptions(request);

        // Preconditions
        HandlerPreconditions.requireNotEmpty(userIds, "No userId specified");
        HandlerPreconditions.requireSingular(userIds, "Only one userId must be specified");

        return service.deleteResource(userIds.iterator().next(), groupId, obj, request.getToken());
    }
}

