package com.ptirador.concessionaire.service.admin;

/**
 * Methods declaration to manage the application cache.
 *
 * @author ptirador
 */
@FunctionalInterface
public interface CacheService {

    /**
     * Cleans the cache.
     * No need for implementation, because the annotation cleans the cache.
     */
    void clearCache();
}
