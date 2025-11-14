package com.estudolivre.ProjetoPDS.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.VideoAula;
import com.estudolivre.ProjetoPDS.repositories.VideoRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repository;

    public VideoAula salvarVideo(MultipartFile file) throws IOException {
        VideoAula v = new VideoAula();
        v.setTipo(file.getContentType());
        v.setDados(file.getBytes());
        return repository.save(v);
    }

    public Optional<VideoAula> obterVideo(Long id) {
        return repository.findById(id);
    }
}
