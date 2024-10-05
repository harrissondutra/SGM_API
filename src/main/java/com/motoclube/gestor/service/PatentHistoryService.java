package com.motoclube.gestor.service;

import com.motoclube.gestor.model.entity.Patent;
import com.motoclube.gestor.model.entity.PatentHistory;
import com.motoclube.gestor.repository.MemberRepository;
import com.motoclube.gestor.repository.PatentHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentHistoryService {

    @Autowired
    private PatentHistoryRepository repository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PatentHistory createPatentHistory(Long id, Patent patent) {
        var member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Membro não encontrado com o id: " + id));
        if (patent == null) {
            throw new IllegalArgumentException("Patente não pode ser nula");
        }
        return new PatentHistory(member, patent);
    }

    public List<Patent> getPatentByMemberId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id do membro não pode ser nulo");
        }
        return repository.findPatentHistoryByMember_Id(id);
    }
}