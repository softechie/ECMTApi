package com.pel2.ecmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan(basePackages = { "com.pel2.emt.Controller",
// "com.pel2.emt.Service" })
public class ECMTApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ECMTApplicationInitializer.class, args);

//		Ignite ignite = null;
//		try {
//			ignite = Ignition.start("example-ignite.xml");
//
//			// Apache Ignite node configuration.
//			IgniteConfiguration cfg = new IgniteConfiguration();
//
//			// Native Persistence configuration.
//			PersistentStoreConfiguration psCfg = new PersistentStoreConfiguration();
//
//			// Enabling the Persistent Store.
//			cfg.setPersistentStoreConfiguration(psCfg);
//
//			ignite.active(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ignite = null;
//		}
	}
}
