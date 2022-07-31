package com.swing.springboot.domain.svc;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Svc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ci;
    private String custnum;
    private String svcmgmtnum;
    private String svcnum;
    private String prodid;
    private String dcyn;
    private String olmagoyn;

    @Builder
    public Svc(String ci, String custnum, String svcmgmtnum, String svcnum, String prodid, String dcyn, String olmagoyn) {
        this.ci = ci;
        this.svcmgmtnum = svcmgmtnum;
        this.custnum = custnum;
        this.svcnum = svcnum;
        this.prodid = prodid;
        this.dcyn = dcyn;
        this.olmagoyn = olmagoyn;
    }

    public void update(String olmagoyn) {
        this.olmagoyn = olmagoyn;
    }

}

