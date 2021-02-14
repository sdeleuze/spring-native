/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework;

import java.util.HashMap;
import java.util.Map;

import org.springframework.nativex.type.AccessChecker;
import org.springframework.nativex.type.Type;
import org.springframework.nativex.type.TypeSystem;

public class PropertiesAccessChecker implements AccessChecker {

	private static Map<String, String[]> requiredTypes = new HashMap<>();

	static {
		addRequiredTypes("org.springframework.boot.autoconfigure.cache.CacheProperties$Couchbase",
				"com.couchbase.client.java.Cluster", "org.springframework.data.couchbase.CouchbaseClientFactory",
				"org.springframework.data.couchbase.cache.CouchbaseCacheManager");
		addRequiredTypes("org.springframework.boot.autoconfigure.cache.CacheProperties$Redis",
				"org.springframework.data.redis.connection.RedisConnectionFactory");
		addRequiredTypes("org.springframework.boot.autoconfigure.cache.CacheProperties$EhCache",
				"net.sf.ehcache.Cache","net.sf.ehcache.CacheManager");
		addRequiredTypes("org.springframework.boot.autoconfigure.cache.CacheProperties$JCache",
				"org.springframework.cache.jcache.JCacheCacheManager",
				"javax.cache.Caching");
		addRequiredTypes("org.springframework.boot.autoconfigure.cache.CacheProperties$Caffeine",
				"com.github.benmanes.caffeine.cache.Caffeine",
				"org.springframework.cache.caffeine.CaffeineCacheManager");
		addRequiredTypes("org.springframework.boot.autoconfigure.cache.CacheProperties$Infinispan",
				"org.infinispan.spring.embedded.provider.SpringEmbeddedCacheManager");
	}

	private static void addRequiredTypes(String propertiesClass, String... dependantTypes) {
		requiredTypes.put(propertiesClass, dependantTypes);
	}

	@Override
	public boolean check(TypeSystem typeSystem, String typename) {
		boolean isOK = true;
		if (typename.endsWith("Properties") || typename.contains("Properties$")) {
			String[] dependants = requiredTypes.get(typename);
			if (dependants != null) {
				for (String dependant : dependants) {
					Type resolvedDependant = typeSystem.resolveDotted(dependant, true);
					if (resolvedDependant == null) {
						// System.out.println("Check on " + typename + " failed due to missing " + dependant);
						isOK = false;
						break;
					}
				}
			}
		}
		return isOK;
	}

}
