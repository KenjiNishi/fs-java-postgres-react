package com.nsw.fsjavapostgresreact.controllers;

import com.nsw.fsjavapostgresreact.models.Lounge;
import com.nsw.fsjavapostgresreact.services.LoungeService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/lounge")
public class LoungeController {
    private final LoungeService loungeService;

    @Autowired
    public LoungeController(LoungeService loungeService) {
        this.loungeService = loungeService;
    }

    @GetMapping(path = "/id/{loungeId}")
    public Lounge getLounge(@PathVariable("loungeId") Long loungeId){
        return loungeService.getLounge(loungeId);
    }

    @GetMapping("/all")
	public List<Lounge> getLounges(){
		return loungeService.getLounges();
	}

    @PostMapping("/save")
    public void registerLounge(@RequestBody Lounge lounge){
        loungeService.addNewLounge(lounge);

    }

    @PutMapping(path = "/update/{loungeId}")
    public void registerLounge(
            @PathVariable("loungeId") Long loungeId,
            @RequestBody Lounge loungeData){
                loungeService.updateLounge(loungeId, loungeData);
            }

    @DeleteMapping(path="/delete/{loungeId}")
    public void deleteLounge(@PathVariable("loungeId") Long loungeId){
        loungeService.deleteLounge(loungeId);
    }

    
}
