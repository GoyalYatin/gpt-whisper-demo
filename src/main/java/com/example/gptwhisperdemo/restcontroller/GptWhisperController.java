package com.example.gptwhisperdemo.restcontroller;

import com.example.gptwhisperdemo.model.*;
import com.example.gptwhisperdemo.service.GptWhisperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class GptWhisperController {
    private final GptWhisperService gptWhisperService;

    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GPTResponse chat(@RequestBody ChatRequest chatRequest){
        return gptWhisperService.chat(chatRequest);
    }

    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public WhisperTranscriptionResponse createTranscription(@ModelAttribute TranscriptionRequest transcriptionRequest){
        return gptWhisperService.createTranscription(transcriptionRequest);
    }

    @PostMapping(value = "/image", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenerateImageResponse generateImage(@RequestBody GenerateImageRequest request) {
        return  gptWhisperService.generateImage(request);
    }
}
