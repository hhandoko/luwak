/**
 * File     : Server.kt
 * License  :
 *   Copyright (c) 2017 Herdy Handoko
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.hhandoko.luwak

import com.fasterxml.jackson.module.kotlin.KotlinModule
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundle
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundleConfiguration
import io.dropwizard.Application
import io.dropwizard.configuration.ResourceConfigurationSourceProvider
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.glassfish.hk2.utilities.binding.AbstractBinder
import zone.dragon.dropwizard.HK2Bundle

import com.hhandoko.luwak.resources.OrderResource

class Server : Application<ServerConfiguration>() {

    override fun initialize(bootstrap: Bootstrap<ServerConfiguration>) {
        bootstrap.configurationSourceProvider = ResourceConfigurationSourceProvider()
        bootstrap.addBundle(
                TemplateConfigBundle(TemplateConfigBundleConfiguration())
        )
        bootstrap.addBundle(HK2Bundle())
        bootstrap.objectMapper.apply {
            registerModule(KotlinModule())
        }
    }

    override fun run(configuration: ServerConfiguration, environment: Environment) {
        environment.jersey().apply {
            register(object: AbstractBinder(){
                override fun configure() {

                }
            })

            register(OrderResource::class.java)
        }
    }

}
