package com.freight.freight_api.converter;

import com.freight.freight_api.dtos.FreightModelDto;
import com.freight.freight_api.models.FreightModel;

public class FreightConvert {
    
    public FreightModelDto toFreightModel(FreightModel freightModel){
        FreightModelDto freightModelDto = new FreightModelDto();
        freightModelDto.setOrderId(freightModel.getOrderId());
        freightModelDto.setFreightValue(freightModel.getFreightValue());
        return freightModelDto;
    }
}
