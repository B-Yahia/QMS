package moot.queue_management_system.mappers;

import moot.queue_management_system.dtos.OrganizationDTO;
import moot.queue_management_system.entities.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OrganizationMapper {
    @Autowired
    private QueueMapper queueMapper;

    public OrganizationDTO toDTO(Organization org) {
        if (org == null) return null;
        return OrganizationDTO.builder()
                .id(org.getId())
                .name(org.getName())
                .description(org.getDescription())
                .queues(queueMapper.toDTOs(org.getQueues()))
                .build();
    }

    public Organization toEntity(OrganizationDTO dto) {
        if (dto == null) return null;
        Organization org = Organization.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        if (dto.getQueues() != null && !dto.getQueues().isEmpty()) {
            org.setQueues(queueMapper.toEntities(dto.getQueues()));
        }
        return org;
    }

    public List<OrganizationDTO> toDTOs(List<Organization> organizations) {
        if (organizations == null || organizations.isEmpty()) return Collections.emptyList();
        return organizations.stream().filter(Objects::nonNull).map(this::toDTO).collect(Collectors.toList());
    }

    public List<Organization> toEntities(List<OrganizationDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) return Collections.emptyList();
        return dtos.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }
}
