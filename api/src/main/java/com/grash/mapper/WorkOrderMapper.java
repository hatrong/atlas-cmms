package com.grash.mapper;

import com.grash.dto.WorkOrderBaseMiniDTO;
import com.grash.dto.WorkOrderPatchDTO;
import com.grash.dto.WorkOrderShowDTO;
import com.grash.model.WorkOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PartMapper.class, UserMapper.class, FileMapper.class})
public interface WorkOrderMapper {
    WorkOrder updateWorkOrder(@MappingTarget WorkOrder entity, WorkOrderPatchDTO dto);

    @Mappings({})
    WorkOrderPatchDTO toPatchDto(WorkOrder model);

    @Mappings({
            @Mapping(source = "parentRequest.audioDescription", target = "audioDescription")
    })
    WorkOrderShowDTO toShowDto(WorkOrder model);

    WorkOrderBaseMiniDTO toBaseMiniDto(WorkOrder model);
}
