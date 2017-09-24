/**
 * File     : OrderResource.kt
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

import java.util.*
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton
import javax.ws.rs.*
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType

import com.hhandoko.luwak.api.order.OrderData
import com.hhandoko.luwak.api.order.OrderResponse
import com.hhandoko.luwak.api.order.OrdersResponse

/**
 * Coffee orders endpoint.
 */
@Singleton
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
class OrderResource {

    /**
     * Order data in-memory store.
     */
    private val orderRepo = ConcurrentHashMap<String, OrderData>()

    init {
        // Populate the orderRepo with some data
        listOf(
                OrderData(UUID.randomUUID().toString(), "Coffee"),
                OrderData(UUID.randomUUID().toString(), "Tea"),
                OrderData(UUID.randomUUID().toString(), "Milkshake")
        ).map {
            Pair(it.ref, it)
        }.forEach {
            orderRepo.put(it.first, it.second)
        }
    }

    /**
     * Get all orders.
     */
    @GET
    fun get(): OrdersResponse {
        return OrdersResponse(orderRepo.values.toList())
    }

    /**
     * Get a single order by its reference.
     *
     * @param ref The unique order reference.
     */
    @GET
    @Path("/{ref}")
    fun getOne(@PathParam("ref") ref: String): OrderResponse {
        return orderRepo[ref]?.run {
            OrderResponse(this)
        } ?: throw WebApplicationException(Response.Status.NOT_FOUND)
    }

}
