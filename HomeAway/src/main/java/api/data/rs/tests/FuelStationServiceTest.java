package api.data.rs.tests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import api.data.rs.client.FuelStationRestClient;
import api.data.rs.model.FuelStation;
import api.data.rs.model.StationList;

/**
 * Test class providing method calls to validate following scenarios: <br>
 * 
 * 1) Validate fuel station by station name (HYATT AUSTIN) <br>
 * 2) Retrieve Alt Fuel station by station Id and verify station address
 * 
 * @author Pallavi Kummari
 * 
 */

public class FuelStationServiceTest
{

	private FuelStationRestClient restClient = null;

	public FuelStationServiceTest()
	{
		this.restClient = new FuelStationRestClient();
	}

	@Test
	public void validateFuelStationByNameTest()
	{
		StationList stationResults = restClient.getAllChargePointFuelStations();
		FuelStation station = stationResults.getStationByName("HYATT AUSTIN");
		String stationName = (station != null) ? station.getStatioName() : null;
		Assert.assertEquals("HYATT AUSTIN", stationName);
	}

	@Test
	public void validateFuelStationByIdTest()
	{
		StationList stationResults = restClient.getAllChargePointFuelStations();
		FuelStation station = stationResults.getStationByName("HYATT AUSTIN");
		int stationId = (station != null) ? station.getStationId() : null;
		FuelStation stationResult = restClient.getFuelStationById(stationId);
		String streetAddress = (stationResult != null) ? stationResult.getStreetAddress() : null;
		String city = (stationResult != null) ? stationResult.getCity() : null;
		String state = (stationResult != null) ? stationResult.getState() : null;
		String zip = (stationResult != null) ? stationResult.getZip() : null;

		Assert.assertEquals("208 Barton Springs Rd", streetAddress);
		Assert.assertEquals("Austin", city);
		Assert.assertEquals("TX", state);
		Assert.assertEquals("78704", zip);
	}

}
