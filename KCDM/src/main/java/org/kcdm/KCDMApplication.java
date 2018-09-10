package org.kcdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
@ImportResource({"classpath*:spring-api-servlet.xml"})
public class KCDMApplication {

	public static void main(String[] args) {
		SpringApplication.run(KCDMApplication.class, args);
	}

	@Bean
	public CacheManager createSimpleCacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		List<Cache> caches = new ArrayList<>(1);
		caches.add(new ConcurrentMapCache("local-memcached"));
		simpleCacheManager.setCaches(caches);
		return simpleCacheManager;
	}
}
