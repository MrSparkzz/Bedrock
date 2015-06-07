package net.sparkzz.test;

import net.sparkzz.core.config.Config;

import java.io.File;

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
public class Main {

	static File file;

	public static void main(String[] args) {
		file = new File(System.getProperty("user.dir"), "config.yml");

		Config config = new Config(file);

		config.put("one", "Hello There");
		config.put("one.two.three", 123);

		config.save();

		config.load();

		System.out.println(config.get("one.two.three"));

	}
}