package com.nsw.fsjavapostgresreact.lounge.services;

import com.nsw.fsjavapostgresreact.lounge.Lounge;
import com.nsw.fsjavapostgresreact.lounge.repository.LoungeRepository;

import java.util.Objects;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoungeService {
    private final LoungeRepository loungeRepository;

	@Autowired
	public LoungeService(LoungeRepository loungeRepository){
		this.loungeRepository = loungeRepository;
	}

	public List<Lounge> getLounges(){
		return loungeRepository.findAll();
	}

	public Lounge getLounge(Long loungeId){
		Lounge lounge = loungeRepository.findById(loungeId)
			.orElseThrow(() -> new IllegalStateException("Lounge id does not exist: " + loungeId));
		return lounge;
	}

	public void addNewLounge(Lounge lounge){
		Optional<Lounge> checkClone = loungeRepository.findByName(lounge.getName());
		if (checkClone.isPresent()) { throw new IllegalStateException("Lounge with same name already exists!");}
		loungeRepository.save(lounge);
	}

	public void  deleteLounge(Long loungeId){
		boolean exists = loungeRepository.existsById(loungeId);
		if(!exists){ throw new IllegalStateException("Lounge id does not exist: " + loungeId);}
		loungeRepository.deleteById(loungeId);
	}

	@Transactional
	public void updateLounge(Long loungeId, Lounge updated){
		Lounge lounge = loungeRepository.findById(loungeId)
			.orElseThrow(() -> new IllegalStateException("Lounge id does not exist: " + loungeId));

			if (updated.getName()!=null && updated.getName().length()>0 &&
					!Objects.equals(lounge.getName(), updated.getName()))
				{
				lounge.setName(updated.getName());
				}
	}
}
