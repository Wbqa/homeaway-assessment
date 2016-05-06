package api.data.rs.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Class to bind all stations JSON response to Java container object
 * 
 * @author Pallavi Kummari
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationList
{

	@JsonProperty("fuel_stations")
	private List<FuelStation> fuelStations;

	public FuelStation getStationByName(String stationName)
	{
		for (FuelStation fs : fuelStations)
			if (fs.getStatioName().equalsIgnoreCase(stationName)) return fs;

		return null;
	}
}
