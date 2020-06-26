package net.emamarquez.atms.atmapi.service;

import net.emamarquez.atms.atmapi.entity.Atm;

import java.util.List;

public interface IAtmService {
    List<Atm> getAtms();
}
