package com.motoclube.gestor.service;

import com.motoclube.gestor.model.entity.PositionMember;
import com.motoclube.gestor.model.to.PositionMemberData;
import com.motoclube.gestor.model.to.PositionMemberDataDetails;
import com.motoclube.gestor.repository.PositionMemberRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PositionMemberService {

    @Autowired
    private PositionMemberRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PositionMemberDataDetails> getPositionMembers(Pageable page) {
        return repository.findAll(page).map(position -> modelMapper.map(position, PositionMemberDataDetails.class));
    }

    @Transactional
    public PositionMemberDataDetails createPositionMember(PositionMemberData positionMemberData) {
        if (positionMemberData == null) {
            throw new IllegalArgumentException("Dados da posição não podem ser nulos");
        }
        PositionMember position = new PositionMember(positionMemberData);
        repository.save(position);
        return modelMapper.map(position, PositionMemberDataDetails.class);
    }

    public PositionMemberDataDetails getPositionMemberById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id da posição não pode ser nulo");
        }
        return modelMapper.map(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Posição não encontrada com o id: " + id)), PositionMemberDataDetails.class);
    }

    @Transactional
    public void deletePositionMember(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id da posição não pode ser nulo");
        }
        repository.deleteById(id);
    }

    @Transactional
    public PositionMemberDataDetails updatePositionMember(Long id, PositionMemberData positionMemberData) {
        if (id == null) {
            throw new IllegalArgumentException("Id da posição não pode ser nulo");
        }
        if (positionMemberData == null) {
            throw new IllegalArgumentException("Dados da posição não podem ser nulos");
        }
        var position = modelMapper.map(positionMemberData, PositionMember.class);
        position.setId(id);
        repository.save(position);
        return modelMapper.map(position, PositionMemberDataDetails.class);
    }
}