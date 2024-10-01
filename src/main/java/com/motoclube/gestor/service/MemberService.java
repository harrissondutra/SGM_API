package com.motoclube.gestor.service;

import com.motoclube.gestor.model.entity.Member;
import com.motoclube.gestor.model.entity.Patent;
import com.motoclube.gestor.model.entity.PositionMember;
import com.motoclube.gestor.model.to.*;
import com.motoclube.gestor.repository.MemberRepository;
import com.motoclube.gestor.repository.PatentHistoryRepository;
import com.motoclube.gestor.repository.PatentRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PatentHistoryRepository patentHistoryRepository;

    @Autowired
    private PatentService patentService;

    @Autowired
    private PositionMemberService positionService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PatentRepository patentRepository;

    public Page<MemberDto> getMembers(Pageable page) {
        return repository.findAll(page).map(member -> modelMapper.map(member, MemberDto.class));
    }

    @Transactional
    public MemberDto createMember(MemberData memberData) {
        Member member = new Member(memberData);
        PatentDataDetails patent = modelMapper.map(patentService.getPatentById(memberData.getPatentId()), PatentDataDetails.class);
        PositionMemberDataDetails position = modelMapper.map(positionService.getPositionMemberById(memberData.getPositionId()), PositionMemberDataDetails.class);

        // Save the patent and position if they are new
        if (patent.getId() == null) {
            Patent patentCreated = new Patent(patent);
            patentRepository.save(patentCreated);
        }
        if (position.getId() == null) {
            PositionMember positionCreated = new PositionMember(position);
            var positionData = modelMapper.map(positionCreated, PositionMemberData.class);
            position = positionService.createPositionMember(positionData);
        }

        member.setPatent(modelMapper.map(patent, Patent.class));
        member.setPosition(modelMapper.map(position, PositionMember.class));
        member.getPatentHistory().add(member.getPatent());
        member.getPositionHistory().add(member.getPosition());
        repository.save(member);
        return modelMapper.map(member, MemberDto.class);
    }

    @Transactional
    public MemberData updatePatent(Long memberId, Long patentId) {
        Optional<Member> optionalMember = repository.findById(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            var patent = modelMapper.map(patentService.getPatentById(patentId), Patent.class);

            // Save the patent if it is new
            if (patent.getId() == null) {
                Patent patentCreated = new Patent(modelMapper.map(patent, PatentData.class));
                patentRepository.save(patentCreated);

            }

            member.setPatent(patent);
            member.getPatentHistory().add(patent);
            repository.save(member);
            return modelMapper.map(member, MemberData.class);
        } else {
            throw new RuntimeException("Member not found with id: " + memberId);
        }
    }

    @Transactional
    public MemberData updatePosition(Long memberId, PositionMember position) {
        Optional<Member> optionalMember = repository.findById(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();

            // Save the position if it is new
            if (position.getId() == null) {
                PositionMember positionCreated = new PositionMember(modelMapper.map(position, PositionMemberData.class));
                positionService.createPositionMember(modelMapper.map(positionCreated, PositionMemberData.class));
            }

            member.setPosition(position);
            member.getPositionHistory().add(position);
            repository.save(member);
            return modelMapper.map(member, MemberData.class);
        } else {
            throw new RuntimeException("Member not found with id: " + memberId);
        }
    }
}