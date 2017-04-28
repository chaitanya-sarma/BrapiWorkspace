package org.BrAPI.Helper;

/**
 * "data": [
      {
        "locationDbId": 0,
        "locationType": "",
        "name": "",
        "abbreviation": "",
        "countryCode": "",
        "countryName": "",
        "latitude": 0,
        "longitude": 0,
        "altitude": 0,
        "attributes": [
          "object"
        ]
      }
 * @author CSarma
 *
 */
public class Location {
	private String locationDbId, locationType, name, countryName;

	public String getLocationDbId() {
		return locationDbId;
	}

	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
