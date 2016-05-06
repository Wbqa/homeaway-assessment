package api.data.rs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import api.data.rs.model.AltFuelStation;
import api.data.rs.model.FuelStation;
import api.data.rs.model.StationList;

/**
 * REST client class providing REST based method calls to retrieve data from
 * https://api.data.gov/ website covering following scenarios: <br>
 * 
 * 1) Retrieve all charge point fuel stations <br>
 * 2) Retrieve Alt Fuel station by station Id
 * 
 * @author Pallavi Kummari
 * 
 */
public class FuelStationRestClient
{

	static
		{
			String jksFilePath = FuelStationRestClient.class.getResource("/keystore/apikeystore.jks").getPath();

			System.setProperty("javax.net.ssl.keyStore", jksFilePath);
			System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
			System.setProperty("javax.net.ssl.trustStore", jksFilePath);
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		}

	public FuelStationRestClient()
	{
	}

	// method to retrieve all chargepoint fuel stations
	public StationList getAllChargePointFuelStations()
	{
		String targetUrl = "https://api.data.gov/nrel/alt-fuel-stations/v1.json?api_key=7NgEN9TMS2aHlotPmxihjzXQ3YXeZtiL7EIpkQ7y&location=Austin+TX&ev_network=ChargePoint+Network";
		Client restClient = ClientBuilder.newClient();

		WebTarget target = restClient.target(targetUrl);
		Response response = target.request().get();
		StationList StationList = response.readEntity(StationList.class);
		response.close();
		restClient.close();

		return StationList;
	}

	// method to retrieve fuel station by ID
	public FuelStation getFuelStationById(int stationId)
	{
		String targetUrl = "https://api.data.gov/nrel/alt-fuel-stations/v1/" + stationId + ".json?api_key=7NgEN9TMS2aHlotPmxihjzXQ3YXeZtiL7EIpkQ7y";
		Client restClient = ClientBuilder.newClient();

		WebTarget target = restClient.target(targetUrl);
		Response response = target.request().get();
		AltFuelStation fuelStation = response.readEntity(AltFuelStation.class);
		response.close();
		restClient.close();

		return ((fuelStation != null) ? fuelStation.getAltFuelStation() : null);
	}

}
