package com.estudolivre.ProjetoPDS.controllers;

import com.estudolivre.ProjetoPDS.models.VideoAula;
import com.estudolivre.ProjetoPDS.services.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            service.salvarVideo(file);
            return ResponseEntity.ok("Upload realizado com sucesso!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao salvar o vídeo.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) {
        Optional<VideoAula> Video = service.obterVideo(id);
        if (Video.isPresent()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(Video.get().getTipo()))
                    .body(Video.get().getDados());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
