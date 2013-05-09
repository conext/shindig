package org.apache.shindig.social.opensocial.spi;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.social.opensocial.model.Resource;

import java.util.concurrent.Future;

/**
 * A service for gathering resource information for specific groups and applications.
 *
 * Maciej Machulak (maciej.machulak@cloudidentity.co.uk)
 */
public interface ResourceService {

    /**
     * @param userId  a userId object
     * @param groupId  a groupId object
     * @param token   a valid security token
     * @return a collection of groups for a specific userId
     * @throws org.apache.shindig.protocol.ProtocolException
     */
    public Future<Resource> getResources(
            UserId userId,
            String groupId,
            SecurityToken token) throws ProtocolException;

    public Future<Resource> createResource(
            UserId userId,
            String groupId,
            String resourceObj,
            SecurityToken token) throws ProtocolException;

    public Future<Resource> deleteResource(
            UserId userId,
            String groupId,
            String resourceId,
            SecurityToken token) throws ProtocolException;

}
