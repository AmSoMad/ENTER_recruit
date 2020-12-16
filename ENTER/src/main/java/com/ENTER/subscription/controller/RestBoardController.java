package com.ENTER.subscription.controller;

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
import com.ENTER.subscription.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "img")
public class RestBoardController {
	private final BoardService boardService;
	private final AppProperties appProperties;

    //이미지 뷰어
    @GetMapping( value = "/{brd_no}/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageView(@PathVariable("imageId") String imagId,@PathVariable("brd_no") String brd_no, HttpServletRequest request) throws IOException {
    	InputStream in =  new FileInputStream(new File(appProperties.getUploadDirBoard() + "/"+ brd_no + "/" + imagId));
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
