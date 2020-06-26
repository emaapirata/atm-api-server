package net.emamarquez.atms.atmapi.service;

import net.emamarquez.atms.atmapi.entity.Address;
import net.emamarquez.atms.atmapi.entity.Atm;
import net.emamarquez.atms.atmapi.entity.GeoLocation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;

import java.util.List;

@Service
public class AtmService implements IAtmService {



    private JSONParser atm_parser = new JSONParser();


    public AtmService() {
    }


    public List<Atm> getAtms() {


        List<Atm> salida = new ArrayList<>();
        try {
            JSONArray arrAtm = (JSONArray) atm_parser.parse(new FileReader("src/main/resources/static/ATMs"));
            for (int i = 0; i < arrAtm.size(); i++) {
                JSONObject objAtm = (JSONObject) arrAtm.get(i);
                JSONObject atmAddress = (JSONObject) objAtm.get("address");
                JSONObject addressGeoLocation = (JSONObject) atmAddress.get("geoLocation");

                if (addressGeoLocation.containsKey("lat") && addressGeoLocation.containsKey("lng")) {
                    GeoLocation geoLocation = new GeoLocation(addressGeoLocation.get("lat").toString(),
                            addressGeoLocation.get("lng").toString());

                    if (atmAddress.containsKey("street")) {
                        Address address = new Address(atmAddress.get("street").toString(),
                                atmAddress.get("housenumber").toString(),
                                atmAddress.get("postalcode").toString(),
                                atmAddress.get("city").toString(),
                                geoLocation);

                        Atm atm = new Atm(address,Integer.parseInt(objAtm.get("distance").toString()),objAtm.get("type").toString());
                        salida.add(atm);
                    }

                }


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return salida;
    }
}
