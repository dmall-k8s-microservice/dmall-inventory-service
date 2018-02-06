package com.dmall.inventory.apis;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import com.dmall.inventory.model.Inventory;
import com.dmall.inventory.services.InventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.restdriver.clientdriver.ClientDriverRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static com.github.restdriver.clientdriver.RestClientDriver.giveResponse;
import static com.github.restdriver.clientdriver.RestClientDriver.onRequestTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(PactRunner.class)
@Provider("inventory_service")
@PactFolder("src/test/resources")
public class InventoryControllerContractTest {
    @ClassRule
    public static final ClientDriverRule embeddedService = new ClientDriverRule(8332);

    @TestTarget
    public final Target target = new HttpTarget(8332);

    @State("The products in Review service are ready")
    public void shouldGetRatings(Map<String, Object> params) throws JsonProcessingException {

        InventoryService inventoryService = new InventoryService();
        final List<Inventory> inventories = inventoryService.getInventories();
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        embeddedService.addExpectation(
                onRequestTo("/inventories").withParams(params)
                , giveResponse(objectMapper.writeValueAsString(inventories), "application/json;charset=UTF-8")
        );
    }
}