package net.sparkzz.core.config;

import com.google.common.base.Optional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Bedrock - http://code.sparkzz.net/
 *  > Copyright (c) 2015, MrSparkzz <http://www.sparkzz.net>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 * @since June 06, 2015
 */
public class Config {

	private File config;

	public Config (File config) {
		this.config = config;
	}

	public Object get(String node) {
		return IOManager.cache.get(node);
	}

	public void load() {
		try {
			IOManager.load(config);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void put(String key, Object value) {
		IOManager.cache.put(key, value);
	}

	public void reload() {
		try {
			IOManager.load(config);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			IOManager.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}