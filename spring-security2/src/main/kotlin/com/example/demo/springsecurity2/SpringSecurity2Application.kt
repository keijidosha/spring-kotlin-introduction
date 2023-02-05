package com.example.demo.springsecurity2

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import java.util.jar.Manifest

//@SpringBootApplication
//class SpringSecurity2Application

@SpringBootApplication
class SpringSecurity2Application(private val appContext: ApplicationContext): CommandLineRunner {
	companion object {
		private val log = LoggerFactory.getLogger(SpringSecurity2Application::class.java)
	}

	override fun run(vararg args: String?) {
//		appContext.getResource("/META-INF/MANIFEST.MF").inputStream.use {
//			val manifest = Manifest(it)
//			val attributes = manifest.mainAttributes
//			log.info("Version: {}", attributes.getValue("Implementation-Version"))
//		}
	}
}

fun main(args: Array<String>) {
	runApplication<SpringSecurity2Application>(*args)
}
