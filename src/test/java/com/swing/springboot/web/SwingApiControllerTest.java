package com.swing.springboot.web;

import com.swing.springboot.domain.svc.Svc;
import com.swing.springboot.domain.svc.SvcRepository;
import com.swing.springboot.domain.svc.SvcRepositorySupport;
import com.swing.springboot.web.dto.SvcResponseDto;
import com.swing.springboot.web.dto.SvcUpdateRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SwingApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    SvcRepository svcRepository;

    @Autowired
    SvcRepositorySupport svcRepositorySupport;


    @Test
    public void 구독연계여부업데이트테스트() {
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

        List<Svc> svcList = svcRepositorySupport.findBySvcmgmtnum("70001");

        //then
        System.out.println("List 값 확인 : " + svcList);

        Svc svc = svcList.get(0);

        System.out.println("id : " + svc.getId());
        System.out.println("ci : " + svc.getCi());
        System.out.println("custnum : " + svc.getCustnum());
        System.out.println("svcmgmtnum : " + svc.getSvcmgmtnum());
        System.out.println("olmagoyn : " + svc.getOlmagoyn());

        String updateSvcmgmtnum = svc.getSvcmgmtnum();

        System.out.println("updateId : " + updateSvcmgmtnum);

        SvcUpdateRequestDto requestDto = SvcUpdateRequestDto.builder()
                .olmagoyn("Y")
                .build();

        String url = "http://localhost:" + port + "swing/api/v1/mobile-phones/" + updateSvcmgmtnum + "/linked-olmag-customer";

        HttpEntity<SvcUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        List<Svc> aftersvcList = svcRepositorySupport.findBySvcmgmtnum("70001");
        Svc svc2 = aftersvcList.get(0);
        System.out.println("olmagoyn : " + svc2.getOlmagoyn());
    }


}
