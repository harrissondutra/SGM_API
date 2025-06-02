package com.motoclube.gestor.members.model.to;

import com.motoclube.gestor.members.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberData {
    private String name;
    private String nickname;
    private String phone;
    private Address address;
    private String cpf;
    private Long patentId;
    private Long positionId;
}