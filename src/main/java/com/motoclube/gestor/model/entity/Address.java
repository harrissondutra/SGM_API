package com.motoclube.gestor.model.entity;

import com.motoclube.gestor.model.to.AddressData;
import jakarta.persistence.Embeddable;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address extends EntityBase {

    private String street;
    private String neighborhood;
    private String cep;
    private String city;
    private String uf;
    private String number;
    private String complement;

    public Address(AddressData address) {
        if (address != null) {
            this.street = address.street();
            this.neighborhood = address.neighborhood();
            this.cep = address.cep();
            this.city = address.city();
            this.uf = address.uf();
            this.number = address.number();
            this.complement = address.complement();
        }
    }

    public void updateAddress(AddressData addressData) {
        if (addressData.street() != null) this.street = addressData.street();
        if (addressData.neighborhood() != null) this.neighborhood = addressData.neighborhood();
        if (addressData.cep() != null) this.cep = addressData.cep();
        if (addressData.city() != null) this.city = addressData.city();
        if (addressData.uf() != null) this.uf = addressData.uf();
        if (addressData.number() != null) this.number = addressData.number();
        if (addressData.complement() != null) this.complement = addressData.complement();
    }
}
