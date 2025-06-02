package com.motoclube.gestor.members.service;

import com.motoclube.gestor.members.model.entity.Patent;
import com.motoclube.gestor.members.model.to.PatentData;
import com.motoclube.gestor.members.model.to.PatentDataDetails;
import com.motoclube.gestor.members.repository.PatentRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentService {

    @Autowired
    private PatentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PatentData> getPatents(Pageable page) {
        return repository.findAll(page).map(patent -> modelMapper.map(patent, PatentData.class));
    }

    @Transactional
    public PatentDataDetails createPatent(PatentData patentData) {
        if (patentData == null) {
            throw new IllegalArgumentException("Dados da patente não podem ser nulos");
        }
        Patent patent = new Patent(patentData);
        repository.save(patent);
        return modelMapper.map(patent, PatentDataDetails.class);
    }

    @Transactional
    public PatentData updatePatent(Long memberId, Long patentId) {
        if (patentId == null) {
            throw new IllegalArgumentException("Id da patente não pode ser nulo");
        }
        var patent = repository.findById(patentId).orElseThrow(() -> new ResourceNotFoundException("Patente não encontrada com o id: " + patentId));
        patent.setId(patentId);
        repository.save(patent);
        return modelMapper.map(patent, PatentData.class);
    }

    public PatentData getPatentById(Long patentId) {
        if (patentId == null) {
            throw new IllegalArgumentException("Id da patente não pode ser nulo");
        }
        return modelMapper.map(repository.findById(patentId).orElseThrow(() -> new ResourceNotFoundException("Patente não encontrada com o id: " + patentId)), PatentData.class);
    }

    @Transactional
    public void deletePatent(Long patentId) {
        if (patentId == null) {
            throw new IllegalArgumentException("Id da patente não pode ser nulo");
        }
        repository.deleteById(patentId);
    }

    public List<PatentData> getPatentsByMotoclubeId(Long motoclubeId) {
        if (motoclubeId == null) {
            throw new IllegalArgumentException("Id do Motoclube não pode ser nulo");
        }
        return repository.findByMotoclubeId(motoclubeId).stream()
                .map(patent -> modelMapper.map(patent, PatentData.class))
                .toList();
    }
}
