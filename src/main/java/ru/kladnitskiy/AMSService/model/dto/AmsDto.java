package ru.kladnitskiy.AMSService.model.dto;

import lombok.Data;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.model.TypesOfWork;

@Data
public class AmsDto extends AbstractAmsDto {

    private final TypesOfWork typesOfWork;

    public AmsDto(Integer id, String code, Integer number, String address, TypeAms type, Double height,
                  boolean serviced, TypesOfWork typesOfWork) {
        super(id, code, number, address, type, height, serviced);
        this.typesOfWork = typesOfWork;
    }

    public static AmsDto convertToAmsDto(Ams ams) {
        return new AmsDto(ams.getId(), ams.getCode(), ams.getNumber(), ams.getAddress(), ams.getType(),
                ams.getHeight(), ams.isServiced(), ams.getTypesOfWork());
    }
}
