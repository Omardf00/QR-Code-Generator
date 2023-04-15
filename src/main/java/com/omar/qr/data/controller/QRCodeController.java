package com.omar.qr.data.controller;

import com.omar.qr.data.service.QRCodeService;
import com.omar.qr.data.service.UserService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api/v1/qr")
public class QRCodeController {

    @Autowired
    QRCodeService qrCodeService;

    private final String URL = "http://localhost:8080/api/v1/qr/name/";

    @GetMapping
    public void generateQRCode(HttpServletResponse response,
                               @RequestParam String name,
                               @RequestParam(defaultValue = "350") int width,
                               @RequestParam(defaultValue = "350") int height) throws Exception {

        String searchUrl = URL + name;

        BufferedImage image = qrCodeService.generateQRCode(searchUrl, width, height);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
