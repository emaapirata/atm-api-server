package net.emamarquez.atms.atmapi.controller;

import net.emamarquez.atms.atmapi.entity.Atm;
import net.emamarquez.atms.atmapi.service.AtmService;
import net.emamarquez.atms.atmapi.service.IAtmService;
import net.emamarquez.atms.atmapi.util.ResponseTransfer;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AtmController {

    @Autowired
    private IAtmService service;

    //@ResponseStatus(value = HttpStatus.BAD_REQUEST,code = HttpStatus.BAD_REQUEST)
    @GetMapping("")
    @ResponseBody
    public ResponseTransfer notFound() {
        return new ResponseTransfer(false, "La pagina no existe");
    }

    @GetMapping("/atms")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseTransfer getAtms(@RequestParam(name = "city", required = false, defaultValue = "") String city,
                                    @RequestParam(name = "zipcode", required = false, defaultValue = "") String zipcode,
                                    @RequestParam(name = "street", required = false, defaultValue = "") String street,
                                    @RequestParam(name = "hnumber", required = false, defaultValue = "") String houseNumber,
                                    @RequestParam(name = "type", required = false, defaultValue = "") String type
    ) {

        List<Atm> atms = service.getAtms();
        if (city != "") {
            Iterator<Atm> it = atms.iterator();
            while (it.hasNext()) {
                Atm current = it.next();
                if (!current.getAddress().getCity().toLowerCase().contains(city.toLowerCase())) {
                    it.remove();
                }
            }


        }
        if (zipcode != "") {
            Iterator<Atm> it = atms.iterator();
            while (it.hasNext()) {
                Atm current = it.next();
                if (!current.getAddress().getPostalCode().toLowerCase().contains(zipcode.toLowerCase())) {
                    it.remove();
                }
            }


        }


        if (street != "") {
            Iterator<Atm> it = atms.iterator();
            while (it.hasNext()) {
                Atm current = it.next();
                if (!current.getAddress().getStreet().toLowerCase().contains(street.toLowerCase())) {
                    it.remove();
                }
            }


        }

        if (houseNumber != "") {
            Iterator<Atm> it = atms.iterator();
            while (it.hasNext()) {
                Atm current = it.next();
                if (!current.getAddress().getHouseNumber().toLowerCase().contains(houseNumber.toLowerCase())) {
                    it.remove();
                }
            }


        }

        if (type != "") {
            Iterator<Atm> it = atms.iterator();
            while (it.hasNext()) {
                Atm current = it.next();
                if (!current.getType().toLowerCase().contains(type.toLowerCase())) {
                    it.remove();
                }
            }


        }

        return new ResponseTransfer(true, atms);
    }

}
