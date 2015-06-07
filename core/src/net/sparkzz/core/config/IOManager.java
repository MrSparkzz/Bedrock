package net.sparkzz.core.config;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Bedrock - http://code.sparkzz.net/
 * 	> Copyright (c) 2015, MrSparkzz <http://www.sparkzz.net>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version. See <http://www.gnu.org/licenses/>.
 *
 * @since June 07, 2015
 */
public class IOManager {

	protected static Map<String, Object> cache = Collections.synchronizedMap(new WeakHashMap<String, Object>());

	public static void load(File config) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		InputStream input = new FileInputStream(config.getAbsolutePath());

		if (!cache.isEmpty()) cache.clear();

		cache = (Map<String, Object>) yaml.load(input);
	}

	public static void save(File config) throws IOException {
		DumperOptions options = new DumperOptions();

		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

		Yaml yaml = new Yaml(options);
		FileWriter writer = new FileWriter(config.getAbsolutePath());

		yaml.dump(cache, writer);
	}
}