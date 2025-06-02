package com.motoclube.gestor.motoclube.service;

import com.motoclube.gestor.motoclube.dto.MotoclubeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MotoclubeService {

    private final List<MotoclubeDto> motoclubes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<MotoclubeDto> listarTodos() {
        return new ArrayList<>(motoclubes);
    }

    public MotoclubeDto buscarPorId(Long id) {
        return motoclubes.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public MotoclubeDto criar(MotoclubeDto dto) {
        dto.setId(idGenerator.getAndIncrement());
        motoclubes.add(dto);
        return dto;
    }
}
