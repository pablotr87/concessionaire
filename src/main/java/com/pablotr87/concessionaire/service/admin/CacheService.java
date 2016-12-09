package com.pablotr87.concessionaire.service.admin;

/**
 * Methods declaration to manage the application cache.
 *
 * @author pablotr87
 */
public interface CacheService {

    /**
     * Cleans the cache.
     * No need for implementation, because the annotation cleans the cache.
     */
    void clearCache();
}
