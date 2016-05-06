package api.data.rs.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * Class to bind FuelStation JSON response to Java Object
 * 
 * @author Pallavi Kummari
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FuelStation
{

	@JsonProperty("id")
	private int stationId;

	@JsonProperty("station_name")
	private String statioName;

	@JsonProperty("street_address")
	private String streetAddress;

	private String city;
	private String state;
	private String zip;

	public int getStationId()
	{
		return stationId;
	}

	public void setStationId(int stationId)
	{
		this.stationId = stationId;
	}

	public String getStatioName()
	{
		return statioName;
	}

	public void setStatioName(String statioName)
	{
		this.statioName = statioName;
	}

	public String getStreetAddress()
	{
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}
}
