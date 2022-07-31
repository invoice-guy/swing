package com.swing.springboot.domain.svc;

import com.swing.springboot.web.dto.SvcUpdateRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SvcRepositoryTest {
    @Autowired
    SvcRepository svcRepository;

    @Autowired
    SvcRepositorySupport svcRepositorySupport;

    @Test
    public void 서비스저장_테스트() {
        svcRepository.save(Svc.builder()
                .ci("100000")
                .custnum("20000")
                .svcnum("01028268646")
                .prodid("NA00002500")
        .build());

        svcRepository.save(Svc.builder()
                .ci("100001")
                .custnum("20001")
                .svcnum("01023141242")
                .prodid("NA00004700")
                .build());

        List<Svc> svcList = svcRepository.findAll();

        //then
        Svc svc = svcList.get(1);

        System.out.println("ci : " + svc.getCi());
        System.out.println("custnum : " + svc.getCustnum());
        System.out.println("svcnum : " + svc.getSvcnum());
        System.out.println("prodid : " + svc.getProdid());
    }

    @Test
    public void CI로서비스정보불러오기테스트() {
        svcRepository.save(Svc.builder()
                .ci("100000")
                .custnum("20000")
                .svcmgmtnum("70000")
                .svcnum("01028268646")
                .prodid("NA00002500")
                .dcyn("N")
                .olmagoyn("N")
                .build());

        svcRepository.save(Svc.builder()
                .ci("100001")
                .custnum("20001")
                .svcmgmtnum("70001")
                .svcnum("01023141242")
                .prodid("NA00004700")
                .dcyn("Y")
                .olmagoyn("N")
                .build());


        List<Svc> svcList = svcRepositorySupport.findByCi("100001");

        //then
        System.out.println("List 값 확인 : " + svcList);

        Svc svc = svcList.get(0);

        System.out.println("ci : " + svc.getCi());
        System.out.println("custnum : " + svc.getCustnum());
        System.out.println("svcnum : " + svc.getSvcnum());
        System.out.println("prodid : " + svc.getProdid());

    }


}
