package ru.kladnitskiy.AMSService.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ru.kladnitskiy.AMSService.model.TypeAms;

@Data
public abstract class AbstractAmsDto {

        private Integer id;
        private String code;
        private int number;
        private String address;
        private TypeAms type;
        private double height;
        private boolean serviced;

        public AbstractAmsDto(){}

        public AbstractAmsDto(Integer id, String code, int number, String address, TypeAms type, double height, boolean serviced) {
                this.id = id;
                this.code = code;
                this.number = number;
                this.address = address;
                this.type = type;
                this.height = height;
                this.serviced = serviced;
        }

        @JsonIgnore
        public boolean isNew(){
                return this.id == null;
        }
}

