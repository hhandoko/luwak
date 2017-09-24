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
package com.hhandoko.luwak.resource

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

import io.dropwizard.testing.ResourceHelpers.resourceFilePath
import io.dropwizard.testing.junit.DropwizardAppRule
import org.junit.After
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test

import com.hhandoko.luwak.Server
import com.hhandoko.luwak.api.order.OrdersResponse

// FIXME: classMethod NPE error
class OrderResourceIntegrationTest {

    lateinit var client: Client

    @Before
    fun setUp() {
        client = ClientBuilder.newClient()
    }

    @After
    fun tearDown() {
        client.close()
    }

    @Test
    fun getOrders() {
        val response =
                client.target("http://localhost:${RULE.localPort}/api/orders")
                      .request()
                      .get(OrdersResponse::class.java)
        assert(response.success)
        assert(response.results.count() == 3)
    }

    companion object {
        @get:ClassRule
        @JvmStatic
        val RULE = DropwizardAppRule(Server::class.java, resourceFilePath("app-test.yml"))
    }

}
