/**
 *  Copyright 2012 Rackspace
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.rackspacecloud.client.service_registry.clients;

import com.google.gson.reflect.TypeToken;
import com.rackspacecloud.client.service_registry.PaginationOptions;
import com.rackspacecloud.client.service_registry.objects.*;
import org.apache.http.client.methods.HttpGet;
import com.rackspacecloud.client.service_registry.ClientResponse;
import com.rackspacecloud.client.service_registry.containers.EventsContainer;

import java.lang.reflect.Type;
import java.util.List;

public class EventsClient extends BaseClient {

    public EventsClient(AuthClient authClient, String apiUrl) {
        super(authClient, apiUrl);
    }

    public List<Event> list(PaginationOptions paginationOptions) throws Exception {
        String url = "/events";
        Type type = new TypeToken<EventsContainer>() {}.getType();
        ClientResponse response = this.performListRequest(paginationOptions, url, null, new HttpGet(), true, type);

        EventsContainer container = (EventsContainer)response.getBody();
        return container.getValues();
    }
}