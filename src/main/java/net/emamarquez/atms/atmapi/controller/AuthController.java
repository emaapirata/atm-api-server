package net.emamarquez.atms.atmapi.controller;


import net.emamarquez.atms.atmapi.util.ResponseTransfer;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @ResponseBody
    @GetMapping("")
    public ResponseTransfer basicAuth(){
        return new ResponseTransfer(true,"You are authenticated");
    }
}
