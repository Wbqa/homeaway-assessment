package api.data.rs.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * Class to bind AltFuel JSON response to Java Object
 * 
 * @author Pallavi Kummari
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AltFuelStation
{

	@JsonProperty("alt_fuel_station")
	private FuelStation altFuelStation;

	public FuelStation getAltFuelStation()
	{
		return altFuelStation;
	}

	public void setAltFuelStation(FuelStation altFuelStation)
	{
		this.altFuelStation = altFuelStation;
	}

}
