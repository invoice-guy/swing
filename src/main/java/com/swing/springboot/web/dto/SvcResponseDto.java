package com.swing.springboot.web.dto;

import com.swing.springboot.domain.svc.Svc;
import lombok.Getter;

@Getter
public class SvcResponseDto {
    private Long id;
    private String ci;
    private String svcmgmtnum;
    private String svcnum;
    private String prodid;
    private String dcyn;
    private String olmagoyn;

    public SvcResponseDto(Svc entity) {
        this.id = entity.getId();
        this.ci = entity.getCi();
        this.svcmgmtnum = entity.getSvcmgmtnum();
        this.svcnum = entity.getSvcnum();
        this.prodid = entity.getProdid();
        this.dcyn = entity.getDcyn();
        this.olmagoyn = entity.getOlmagoyn();
    }
}
