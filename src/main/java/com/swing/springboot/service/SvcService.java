package com.swing.springboot.service;

import com.swing.springboot.domain.svc.Svc;
import com.swing.springboot.domain.svc.SvcRepository;
import com.swing.springboot.domain.svc.SvcRepositorySupport;
import com.swing.springboot.web.dto.SvcResponseDto;
import com.swing.springboot.web.dto.SvcUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SvcService {
    private final SvcRepository svcRepository;
    private final SvcRepositorySupport svcRepositorysupport;

    @Transactional
    public Long update(String svcmgmtnum, SvcUpdateRequestDto requestDto) {
        List<Svc> svcList = svcRepositorysupport.findBySvcmgmtnum(svcmgmtnum);
        Svc objsvc = svcList.get(0);
        Long updateId = objsvc.getId();

        Svc svc = svcRepository.findById(updateId)
                .orElseThrow(() -> new IllegalArgumentException("해당 데이터가 없습니다. id=" + updateId));

        svc.update("Y");

        return updateId;
    }

    @Transactional
    public Long update(String svcmgmtnum) {
        List<Svc> svcList = svcRepositorysupport.findBySvcmgmtnum(svcmgmtnum);
        Svc objsvc = svcList.get(0);
        Long updateId = objsvc.getId();

        Svc svc = svcRepository.findById(updateId)
                .orElseThrow(() -> new IllegalArgumentException("해당 데이터가 없습니다. id=" + updateId));

        svc.update("N");

        return updateId;
    }


    @Transactional(readOnly = true)
    public List findBySvcmgmtnum(String svcmgmtnum) {
        List<Svc> svcList = svcRepositorysupport.findBySvcmgmtnum(svcmgmtnum);

        return svcList;
    }

    @Transactional(readOnly = true)
    public List findByCi(String ci) {
        List<Svc> svcList = svcRepositorysupport.findByCi(ci);

        return svcList;
    }
}
