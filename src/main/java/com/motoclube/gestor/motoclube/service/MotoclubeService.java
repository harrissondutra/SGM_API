package com.motoclube.gestor.motoclube.service;

import com.motoclube.gestor.motoclube.dto.MotoclubeDto;
import com.motoclube.gestor.motoclube.model.Motoclube;
import com.motoclube.gestor.motoclube.repository.MotoclubeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MotoclubeService {

    @Autowired
    MotoclubeRepository repository;

    private final List<MotoclubeDto> motoclubes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    @Autowired
    private ModelMapper modelMapper;

    public List<MotoclubeDto> listarTodos() {
        return new ArrayList<>(motoclubes);
    }

    public MotoclubeDto buscarPorId(Long id) {
        return motoclubes.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public MotoclubeDto criar(MotoclubeDto motoclubeDto) {
        motoclubeDto.setId(idGenerator.getAndIncrement());
        Motoclube motoclube = modelMapper.map(motoclubeDto, Motoclube.class);
        Motoclube newMotoclube = repository.save(motoclube);
        return modelMapper.map(newMotoclube, MotoclubeDto.class);
    }
}
