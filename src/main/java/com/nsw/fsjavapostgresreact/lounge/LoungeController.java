package com.nsw.fsjavapostgresreact.lounge.controllers;

import com.nsw.fsjavapostgresreact.lounge.Lounge;
import com.nsw.fsjavapostgresreact.lounge.services.LoungeService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/lounges")
public class LoungeController {
    private final LoungeService loungeService;

    @Autowired
    public LoungeController(LoungeService loungeService) {
        this.loungeService = loungeService;
    }

    @GetMapping(path = "{loungeId}")
    public Lounge getLounge(@PathVariable("loungeId") Long loungeId){
        return loungeService.getLounge(loungeId);
    }

    @GetMapping
	public List<Lounge> getLounges(){
		return loungeService.getLounges();
	}

    @PostMapping
    public void registerLounge(@RequestBody Lounge lounge){
        loungeService.addNewLounge(lounge);

    }

    @PutMapping(path = "{loungeId}")
    public void registerLounge(
            @PathVariable("loungeId") Long loungeId,
            @RequestBody Lounge loungeData){
                loungeService.updateLounge(loungeId, loungeData);
            }

    @DeleteMapping(path="{loungeId}")
    public void deleteLounge(@PathVariable("loungeId") Long loungeId){
        loungeService.deleteLounge(loungeId);
    }

    
}
