package com.ptirador.concessionaire.service.admin;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * Cache admin.
 *
 * @author ptirador
 */
@Service
public class CacheServiceImpl implements CacheService {

    /**
     * Cleans the cache.
     * No need for implementation, because the annotation cleans the cache.
     */
    @Override
    @CacheEvict(value = {"paises", "zonaInfluencia", "especialidad", "areasTecnicas"},
            allEntries = true)
    public void clearCache() {
        // Do nothing, because the annotation cleans the cache.
    }
}
