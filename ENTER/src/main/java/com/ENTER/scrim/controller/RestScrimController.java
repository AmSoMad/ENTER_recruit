package com.ENTER.scrim.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ENTER.config.AppProperties;
import com.ENTER.scrim.service.ScrimService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "img_scrim")
public class RestScrimController {
	private final AppProperties appProperties;
	private final ScrimService scrimService;

    //이미지 뷰어
    @GetMapping( value = "/{scrim_no}/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageView(@PathVariable("imageId") String imagId,@PathVariable("scrim_no") String scrim_no, HttpServletRequest request) throws IOException {
    	InputStream in =  new FileInputStream(new File(appProperties.getUploadDirScrim() + "/"+ 0 + "/" + imagId));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }



}
