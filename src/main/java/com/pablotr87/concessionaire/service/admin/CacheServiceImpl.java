package com.pablotr87.concessionaire.service.admin;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * Cache administration.
 *
 * @author pablotr87
 */
@Service
public class CacheServiceImpl implements CacheService {

    /**
     * Cleans the cache.
     * No need for implementation, because the annotation cleans the cache.
     */
    @CacheEvict(value = {"paises", "zonaInfluencia", "especialidad", "areasTecnicas"},
            allEntries = true)
    public void clearCache() {
    }
}
