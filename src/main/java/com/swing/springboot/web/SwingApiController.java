package com.swing.springboot.web;

import com.swing.springboot.service.SvcService;
import com.swing.springboot.web.dto.SvcResponseDto;
import com.swing.springboot.web.dto.SvcUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SwingApiController {
    private final SvcService svcService;

    @PutMapping("swing/api/v1/mobile-phones/{svcmgmtnum}/linked-olmag-customer")
    public Long update(@PathVariable String svcmgmtnum, @RequestBody SvcUpdateRequestDto requestDto) {
        return svcService.update(svcmgmtnum, requestDto);
    }

    @DeleteMapping("swing/api/v1/mobile-phones/{svcmgmtnum}/linked-olmag-customer")
    public Long update(@PathVariable String svcmgmtnum) {
        return svcService.update(svcmgmtnum);
    }

    @GetMapping("swing/api/v1/mobilephones&ci/{ci}")
    public List fildbyci(@PathVariable String ci) {
        return svcService.findByCi(ci);
    }

}
