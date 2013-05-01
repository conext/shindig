package org.apache.shindig.social.core.model;

import org.apache.shindig.social.opensocial.model.Resource;

/**
 * Maciej Machulak (maciej.machulak@cloudidentity.co.uk)
 */
public class ResourceImpl implements Resource {

    private String resource;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
